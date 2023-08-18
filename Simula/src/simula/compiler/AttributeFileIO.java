/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.BlockDeclaration;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.StandardClass;
import simula.compiler.syntaxClass.statement.ProgramModule;
import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Simula attribute file input/output.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/AttributeFileIO.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class AttributeFileIO {
	/**
	 * The Simula version.
	 */
	private final static String version="SimulaAttributeFile: Version 1.0";

	/**
	 * The attribute file.
	 */
	final File attributeFile;
	
	/**
	 * Create a new AttributeFileIO.
	 * @param aFile the attributeFile 
	 */
	private AttributeFileIO(final File aFile) {
		this.attributeFile = aFile;
	}

	/**
	 * Write an attribute file.
	 * @param program the program module
	 * @throws IOException if an output operation fail
	 */
	static void write(final ProgramModule program) throws IOException {
		String relativeAttributeFileName = program.getRelativeAttributeFileName();
		if (relativeAttributeFileName == null) return;
		File file = new File(Global.tempClassFileDir,relativeAttributeFileName);
		if (Option.verbose)
			Util.println("*** BEGIN Generate SimulaAttributeFile: \"" + file+"\"");
		AttributeFileIO attributeFile = new AttributeFileIO(file);
		attributeFile.write((BlockDeclaration) program.module);
		if (Option.TRACE_ATTRIBUTE_OUTPUT) {
			try { attributeFile.listAttributeFile(file);
			} catch (ClassNotFoundException e) {
				Util.IERR("Unable to list Attribute File: "+file, e);
			}
		}
		if (Option.verbose)	Util.TRACE("*** ENDOF Generate SimulaAttributeFile: " + file);
	}

	/**
	 * Read an attribute file.
	 * @param inputStream argument
	 * @param file argument
	 * @param declarationList argument
	 * @return the module type
	 * @throws IOException if an input operation fail
	 * @throws ClassNotFoundException if a class cast fail
	 */
	public static Type readAttributeFile(final InputStream inputStream,final File file,
            final DeclarationList declarationList) throws IOException, ClassNotFoundException {
		AttributeFileIO attributeFile = new AttributeFileIO(file);
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + file);
		ObjectInputStream inpt = new ObjectInputStream(inputStream);
		String vers=(String)inpt.readObject();
		if(!(vers.equals(version))) Util.error("Malformed SimulaAttributeFile: " + attributeFile);
		Type moduleType=null;
		LOOP: while (true) {
			BlockDeclaration module=null;
			try { module=(BlockDeclaration) inpt.readObject();}
			catch (EOFException e1) { break LOOP; }
			module.isPreCompiled = true;
			Declaration d=declarationList.find(module.identifier);
			if(d!=null) {
				Util.warning("Multiple declarations with the same name: "+module+" and "+d);
			} else {
				declarationList.add(module);
				moduleType=module.type;
				if (Option.verbose)
					Util.TRACE("***       Read External " + module.declarationKind + ' ' + module.identifier + '[' + module.externalIdent + ']'
							+"  ==>  "+declarationList.identifier);
				if (Option.TRACE_ATTRIBUTE_INPUT) module.print(0);
			}
		}
		inpt.close();
		if (Option.verbose)	Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + file);
		return(moduleType);
	}	

	/**
	 * Write a module's attribute file.
	 * @param module the module
	 * @throws IOException if an io-error occurs
	 */
	private void write(final BlockDeclaration module) throws IOException {
		File attributeDir = new File(Global.tempClassFileDir,Global.packetName);
		attributeDir.mkdirs();
		attributeFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(attributeFile);
		ObjectOutputStream oupt = new ObjectOutputStream(fileOutputStream);
		// writeVersion:
		oupt.writeObject(version);
		// writeDependencies:
		for(Declaration dcl:StandardClass.ENVIRONMENT.declarationList) {
			if(dcl instanceof BlockDeclaration ext) {
				if(ext.isPreCompiled) {
					if (Option.verbose) Util.TRACE("***       Write External "+ext.declarationKind+' '+ext.identifier+'['+ext.externalIdent+']');
					oupt.writeObject(ext);
				}
			}
		}
		if (Option.verbose)
			Util.TRACE("***       Write External " + module.declarationKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
		oupt.writeObject(module);
		oupt.flush(); oupt.close();	oupt = null;
	}
	  
	/**
	 * List an attribute file.
	 * @param aFile the attributeFile
	 * @throws IOException if an io-error occurs
	 * @throws ClassNotFoundException if readObject fails
	 */
	private void listAttributeFile(final File aFile) throws IOException, ClassNotFoundException {
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + aFile);
		FileInputStream fileInputStream = new FileInputStream(aFile);
		ObjectInputStream inpt = new ObjectInputStream(fileInputStream);
		String vers=(String)inpt.readObject();
		if(!(vers.equals(version))) Util.error("Malformed SimulaAttributeFile: " + aFile);
		BlockDeclaration blockDeclaration=(BlockDeclaration)inpt.readObject();
		inpt.close();
		if (Option.verbose) {
			if (Option.TRACE_ATTRIBUTE_INPUT) {
				Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + aFile);
				blockDeclaration.print(0);
			}
		}
	}	

}
