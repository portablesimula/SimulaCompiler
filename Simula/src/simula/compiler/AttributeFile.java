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
import java.util.Vector;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.StandardClass;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

public final class AttributeFile {
	private final String version="SimulaAttributeFile: Version 1.0";

	final File attributeFile;
	ObjectOutputStream oupt;
	ObjectInputStream inpt;
	boolean verbose=true; //false;//true;
	
	private AttributeFile(final File attributeFile) {
		this.attributeFile = attributeFile;
	}

	public static void write(final ProgramModule program) throws IOException {
		String relativeAttributeFileName = program.getRelativeAttributeFileName();
		if (relativeAttributeFileName == null) return;
		File file = new File(Global.tempClassFileDir,relativeAttributeFileName);
		if (Option.verbose)	Util.message("*** BEGIN Generate SimulaAttributeFile: \"" + file+"\"");
		AttributeFile attributeFile = new AttributeFile(file);
		attributeFile.write((BlockDeclaration) program.module);
		if (Option.TRACE_ATTRIBUTE_OUTPUT) {
			try { attributeFile.listAttributeFile(file);
			} catch (ClassNotFoundException e) {
				Util.INTERNAL_ERROR("Unable to list Attribute File: "+file, e);
			}
		}
		if (Option.verbose)	Util.TRACE("*** ENDOF Generate SimulaAttributeFile: " + file);
	}

	private void write(final BlockDeclaration module) throws IOException {
		File attributeDir = new File(Global.tempClassFileDir,Global.packetName);
		attributeDir.mkdirs();
		attributeFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(attributeFile);
		oupt = new ObjectOutputStream(fileOutputStream);
		writeVersion();
		writeDependencies();
		if (Option.verbose)
			Util.TRACE("***       Write External " + module.declarationKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
		oupt.writeObject(module);
		oupt.flush(); oupt.close();	oupt = null;
	}

	private void writeDependencies() throws IOException {
		for(Declaration dcl:StandardClass.ENVIRONMENT.declarationList) {
			if(dcl instanceof BlockDeclaration) {
				BlockDeclaration ext=(BlockDeclaration)dcl;
				if(ext.isPreCompiled) {
					if (Option.verbose) Util.TRACE("***       Write External "+ext.declarationKind+' '+ext.identifier+'['+ext.externalIdent+']');
					oupt.writeObject(ext);
				}
			}
		}
	}

	public static Type readAttributeFile(final InputStream inputStream,final File file,
            final Vector<Declaration> declarationList) throws IOException, ClassNotFoundException {
		AttributeFile attributeFile = new AttributeFile(file);
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + file);
		attributeFile.inpt = new ObjectInputStream(inputStream);
		if (!attributeFile.checkVersion())
			Util.error("Malformed SimulaAttributeFile: " + file);
		Type moduleType=null;
		LOOP: while (true) {
			BlockDeclaration module=null;
			try { module=(BlockDeclaration) attributeFile.inpt.readObject();}
			catch (EOFException e1) { break LOOP; }
			module.isPreCompiled = true;
			declarationList.add(module);
			moduleType=module.type;
			if (Option.verbose)
				Util.TRACE("***       Read External " + module.declarationKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
			if (Option.TRACE_ATTRIBUTE_INPUT) module.print(0);
		}
		attributeFile.inpt.close();
		if (Option.verbose)	Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + file);
		return(moduleType);
	}	
	  
	
	private BlockDeclaration listAttributeFile(final File attributeFile) throws IOException, ClassNotFoundException {
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFile);
		FileInputStream fileInputStream = new FileInputStream(attributeFile);
		inpt = new ObjectInputStream(fileInputStream);
		if (!checkVersion()) Util.error("Malformed SimulaAttributeFile: " + attributeFile);
		BlockDeclaration blockDeclaration=(BlockDeclaration)inpt.readObject();
		inpt.close();
		if (Option.verbose) {
			if (Option.TRACE_ATTRIBUTE_INPUT) {
				Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFile);
				blockDeclaration.print(0);
			}
		}
		return (blockDeclaration);
	}	
	  
	private void writeVersion() throws IOException {
		oupt.writeObject(version);
	}
	
	private boolean checkVersion() throws IOException, ClassNotFoundException {
		return(((String)inpt.readObject()).equals(version));
	}

}
