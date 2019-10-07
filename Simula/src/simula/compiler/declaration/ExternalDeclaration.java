/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import simula.compiler.AttributeFile;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * External Declaration.
 * <p>
 * An external declaration is a substitute for a complete introduction of the
 * corresponding source module referred to, including its external head. In the
 * case where multiple but identical external declarations occur as a
 * consequence of this rule, this declaration will be incorporated only once.
 *
 * 
 * External Class Declaration
 * 
 * <pre>
     external-class-declaration
         =  EXTERNAL  CLASS  ExternalList
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
 * ExternalProcedureDeclaration
 *         = EXTERNAL [ kind ] [ type ] PROCEDURE ExternalList
 *         | EXTERNAL kind PROCEDURE ExternalItem  IS ProcedureDeclaration
 *         
 *    ExternalList = ExternalItem { , ExternalItem }
 * 	  ExternalItem = identifier [ "=" ExternalIdentifier ]
 * 
 *		 kind  =  identifier  // E.g. FORTRAN, JAVA, ...
 *		 ExternalIdentifier = TextConstant   // E.g  a file-name
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
 * a formal procedure. *
 * 
 * 
 * @author Øystein Myhre Andersen
 */
public final class ExternalDeclaration extends Declaration {
	private ExternalDeclaration() {
		super(null);
		this.declarationKind=Declaration.Kind.ExternalDeclaration;
	}

	public static void doParse(final Vector<Declaration> declarationList) {
        // = EXTERNAL  CLASS  ExternalList
        // | EXTERNAL [ kind ] [ type ] PROCEDURE ExternalList
        // | EXTERNAL kind PROCEDURE ExternalItem  IS ProcedureDeclaration
		String kind=acceptIdentifier();
		if(kind!=null) Util.NOT_IMPLEMENTED("External "+kind+" Procedure");
		Type expectedType = acceptType();
		if (!(Parser.accept(KeyWord.CLASS) || Parser.accept(KeyWord.PROCEDURE)))
			Util.error("parseExternalDeclaration: Expecting CLASS or PROCEDURE");
		
		String identifier = expectIdentifier();
   LOOP:while(true) {
			Token externalIdentifier = null;
			if (Parser.accept(KeyWord.EQ)) {
				externalIdentifier = Parser.currentToken;
				Parser.expect(KeyWord.TEXTKONST);
			}
			File jarFile;
			if(externalIdentifier==null)
				 jarFile=new File(Global.outputDir,identifier+".jar");
			else jarFile=new File(externalIdentifier.getIdentifier());
			Type moduleType=readAttributeFile(identifier,jarFile,declarationList);
			if(moduleType!=expectedType) {
				if(expectedType!=null) Util.error("Wrong external type");
			}
		  
			if(Parser.accept(KeyWord.IS)) {
				// ...
				Util.NOT_IMPLEMENTED("External non-Simula Procedure");
				break LOOP;
			}
			if(!Parser.accept(KeyWord.COMMA)) break LOOP;
			identifier=expectIdentifier();
		}
	}


	private static Type readAttributeFile(final String identifier,final File file,final Vector<Declaration> declarationList) {
		Type moduleType=null;
		Util.warning("Separate Compiled Module is read from: \"" + file+"\"");
		if(!(file.exists() && file.canRead())) {
			Util.error("Can't read attribute file: "+file);	return(null);
	    }
	    try {
	    	JarFile jarFile=new JarFile(file);
	        Manifest manifest=jarFile.getManifest();			
	        Attributes mainAttributes=manifest.getMainAttributes();
	        String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
	        ZipEntry zipEntry=jarFile.getEntry(simulaInfo);
	        InputStream inputStream=jarFile.getInputStream(zipEntry);
	        moduleType=AttributeFile.readAttributeFile(inputStream,new File(simulaInfo),declarationList);
	        inputStream.close();
	        
	        File destDir=Global.tempClassFileDir;
	        expandJarEntries(jarFile,destDir);
	        inputStream.close();
	        jarFile.close();
	        Global.externalJarFiles.add(file);
	    } catch(IOException | ClassNotFoundException e) {
			Util.error("Unable to read Attribute File: "+file);
			Util.warning("It may be necessary to recompile '"+identifier+"'");
	    	Util.INTERNAL_ERROR("Caused by:",e);
	    }
	    return(moduleType);
	}

	private static void expandJarEntries(final JarFile jarFile,final File destDir) throws IOException {
		if(Option.verbose) Util.message("---------  EXPAND .jar File: "+jarFile.getName()+"  ---------");
		new File(destDir,Global.packetName).mkdirs(); // Create directories
		Enumeration<JarEntry> entries = jarFile.entries();
		int nEntriesAdded=0;
		LOOP:while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
	           
			String name=entry.getName();
			if(!name.startsWith(Global.packetName))	continue LOOP;
			if(!name.endsWith(".class")) continue LOOP;
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try { inputStream = jarFile.getInputStream(entry);
			      File destFile = new File(destDir,entry.getName());
			      outputStream=new FileOutputStream(destFile);	 
			      byte[] buffer = new byte[4096];
			      int bytesRead = 0;
			      while ((bytesRead = inputStream.read(buffer)) != -1) {
				      outputStream.write(buffer, 0, bytesRead);
			      }
			      nEntriesAdded++;
			} finally {
				if(inputStream!=null) inputStream.close();
				if(outputStream!=null) {
					outputStream.flush();
					outputStream.close();
				}
			}
		}
		if(Option.verbose) Util.message("---------  END EXPAND .jar File, "+nEntriesAdded+" Entries Added  ---------");
	}

}
