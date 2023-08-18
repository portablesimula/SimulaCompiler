/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import simula.compiler.AttributeFileIO;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

/**
 * External Declaration.
 * <pre>
 * Simula Standard: 6.1 External declarations
 * 
 *   external-head = external-declaration ; { external-declaration ; }
 *   
 *   external-declaration
 *      = external-procedure-declaration | external-class-declaration
 * </pre>
 * An external declaration is a substitute for a complete introduction of the
 * corresponding source module referred to, including its external head. In the
 * case where multiple but identical external declarations occur as a
 * consequence of this rule, this declaration will be incorporated only once.
 *
 * 
 * External Class Declaration
 * 
 * <pre>
 *    external-class-declaration
 *        =  EXTERNAL  CLASS  external-list
 * </pre>
 * 
 * An implementation may restrict the number of block levels at which an
 * external class declaration may occur.
 * <p>
 * Note: As a consequence of 5.5.1 all classes belonging to the prefix chain of
 * a separately compiled class must be declared in the same block as this class.
 * However, this need not be done explicitly; an external declaration of a
 * separately compiled class implicitly declares all classes in its prefix chain
 * (since these will be declared in the external head of the class in question).
 * 
 * 
 * 
 * 
 * External procedure declaration
 * 
 * <pre>
 * 
 * external-procedure-declaration
 *         = EXTERNAL [ kind ] [ type ] PROCEDURE external-list
 *         | EXTERNAL kind PROCEDURE external-item  IS procedure-declaration
 *         
 *    external-list = external-item { , external-item }
 * 	  external-item = identifier [ "=" external-identification ]
 * 
 *		 kind  =  identifier  // E.g. FORTRAN, JAVA, ...
 *		 external-identification = string   // E.g  a file-name
 * 
 * </pre>
 * <p>
 * The kind of an external procedure declaration may indicate the source
 * language in which the separately compiled procedure is written (e.g assembly,
 * Cobol, Fortran, PL1 etc.). The kind must be empty if this language is Simula.
 * The interpretation of kind (if given) is implementation-dependent.
 * <p>
 * If an external procedure declaration contains a procedure specification, the
 * procedure body of the procedure declaration must be empty. This specifies a
 * procedure whose actual body, which embodies the algorithm required, is
 * supplied in a separate (non-Simula) module. The procedure heading of the
 * procedure declaration will determine the procedure identifier (function
 * designator) to be used within the source module in which the external
 * declaration occurs, as well as the type, order, and transmission mode of the
 * parameters.
 * <p>
 * A non-Simula procedure cannot be used as an actual parameter corresponding to
 * a formal procedure.
 * <p> 
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/ExternalDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ExternalDeclaration extends Declaration {
	
	/**
	 * Create a new ExternalDeclaration.
	 */
	private ExternalDeclaration() {
		super(null);
		this.declarationKind = Declaration.Kind.ExternalDeclaration;
	}

	/**
	 * Parse an external declaration updating a declaration list.
	 * <pre>
	 *    external-head = external-declaration ; { external-declaration ; }
	 *       external-class-declaration
	 *            =  EXTERNAL  CLASS  external-list
	 *        
	 *       external-procedure-declaration
	 *            = EXTERNAL [ kind ] [ type ] PROCEDURE external-list
	 *            | EXTERNAL kind PROCEDURE external-item  IS procedure-declaration
	 * </pre>
	 * Precondition: EXTERNAL  is already read.
	 * @param declarationList the declaration list which is updated
	 */
	public static void expectExternalHead(final DeclarationList declarationList) {
		String kind = Parse.acceptIdentifier();
		if (kind != null)
			Util.IERR("*** NOT IMPLEMENTED: " + "External " + kind + " Procedure");
		Type expectedType = Parse.acceptType();
		if (!(Parse.accept(KeyWord.CLASS) || Parse.accept(KeyWord.PROCEDURE)))
			Util.error("parseExternalDeclaration: Expecting CLASS or PROCEDURE");

		String identifier = Parse.expectIdentifier();
		LOOP: while (true) {
			Token externalIdentifier = null;
			if (Parse.accept(KeyWord.EQ)) {
				externalIdentifier = Parse.currentToken;
				Parse.expect(KeyWord.TEXTKONST);
			}
			File jarFile = findJarFile(identifier, externalIdentifier);
			if (jarFile != null) {
				Type moduleType = readAttributeFile(identifier, jarFile, declarationList);
				if (moduleType != expectedType) {
					if (expectedType != null)
						Util.error("Wrong external type");
				}
			}

			if (Parse.accept(KeyWord.IS)) {
				// ...
				Util.IERR("*** NOT IMPLEMENTED: " + "External non-Simula Procedure");
				break LOOP;
			}
			if (!Parse.accept(KeyWord.COMMA))
				break LOOP;
			identifier = Parse.expectIdentifier();
		}
	}

	/**
	 * Find the .jar file containing an external class or procedure.
	 * @param identifier class or procedure identifier
	 * @param externalIdentifier the external identifier if any
	 * @return the resulting File
	 */
	private static File findJarFile(final String identifier, final Token externalIdentifier) {
		File jarFile = null;
		try {
			if (externalIdentifier == null) {
				// If present search extLib
				if (Global.extLib != null) {
					jarFile = new File(Global.extLib, identifier + ".jar");
					if (jarFile.exists())
						return (jarFile);
				}
				jarFile = new File(Global.outputDir, identifier + ".jar");
				if (jarFile.exists())
					return (jarFile);
			} else {
				jarFile = new File(externalIdentifier.getIdentifier());
				if (jarFile.exists())
					return (jarFile);
			}
		} catch (Exception e) {
			Util.IERR("Can't find attribute file: " + jarFile, e);
		}
		Util.error("Can't find attribute file: " + jarFile);
		return (null);
	}

	/**
	 * Read an attribute file.
	 * @param identifier class or procedure identifier
	 * @param file the file to read
	 * @param declarationList the declaration list to update
	 * @return the module type
	 */
	private static Type readAttributeFile(final String identifier, final File file,
			final DeclarationList declarationList) {
		Type moduleType = null;
		Util.warning("Separate Compiled Module is read from: \"" + file + "\"");
		if (!(file.exists() && file.canRead())) {
			Util.error("Can't read attribute file: " + file);
			return (null);
		}
		try {
			JarFile jarFile = new JarFile(file);
			Manifest manifest = jarFile.getManifest();
			Attributes mainAttributes = manifest.getMainAttributes();
			String simulaInfo = mainAttributes.getValue("SIMULA-INFO");
			ZipEntry zipEntry = jarFile.getEntry(simulaInfo);
			InputStream inputStream = jarFile.getInputStream(zipEntry);
			moduleType = AttributeFileIO.readAttributeFile(inputStream, new File(simulaInfo), declarationList);
			inputStream.close();

			File destDir = Global.tempClassFileDir;
			expandJarEntries(jarFile, destDir);
			inputStream.close();
			jarFile.close();
			Global.externalJarFiles.add(file);
		} catch (IOException | ClassNotFoundException e) {
			Util.error("Unable to read Attribute File: " + file + " caused by: " + e);
			Util.warning("It may be necessary to recompile '" + identifier + "'");
			Util.IERR("Caused by:", e);
		}
		return (moduleType);
	}

	/**
	 * Expand .jar file entries into the given directory.
	 * @param jarFile the .jar file
	 * @param destDir the output directory
	 * @throws IOException if something went wrong
	 */
	private static void expandJarEntries(final JarFile jarFile, final File destDir) throws IOException {
		if (Option.verbose)
			Util.println("---------  EXPAND .jar File: " + jarFile.getName() + "  ---------");
		new File(destDir, Global.packetName).mkdirs(); // Create directories
		Enumeration<JarEntry> entries = jarFile.entries();
		int nEntriesAdded = 0;
		LOOP: while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();

			String name = entry.getName();
			if (!name.startsWith(Global.packetName))
				continue LOOP;
			if (!name.endsWith(".class"))
				continue LOOP;

			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				inputStream = jarFile.getInputStream(entry);
				File destFile = new File(destDir, entry.getName());
				// System.out.println("ExternalDeclaration.expandJarEntries: "+destFile);
				outputStream = new FileOutputStream(destFile);
				byte[] buffer = new byte[4096];
				int bytesRead = 0;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				nEntriesAdded++;
			} finally {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			}
		}
		if (Option.verbose)
			Util.println("---------  END EXPAND .jar File, " + nEntriesAdded + " Entries Added  ---------");
	}

}
