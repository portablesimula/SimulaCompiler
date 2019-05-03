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

	final String attributeFileName;
	ObjectOutputStream oupt;
	ObjectInputStream inpt;
	boolean verbose=true; //false;//true;
	
	private AttributeFile(final String attributeFileName) {
		this.attributeFileName = attributeFileName;
	}

	public static void write(final ProgramModule program) throws IOException {
		String relativeAttributeFileName = program.getRelativeAttributeFileName();
		if (relativeAttributeFileName == null) return;
		String attributeFileName = Global.tempClassFileDir + relativeAttributeFileName;
		if (Option.verbose)	Util.message("*** BEGIN Generate SimulaAttributeFile: \"" + attributeFileName+"\"");
		AttributeFile attributeFile = new AttributeFile(attributeFileName);
		attributeFile.write((BlockDeclaration) program.module);
		if (Option.TRACE_ATTRIBUTE_OUTPUT) {
			try { attributeFile.listAttributeFile(attributeFileName);
			} catch (ClassNotFoundException e) {
				Util.error("Unable to list Attribute File: "+attributeFileName);
				e.printStackTrace();
			}
		}
		if (Option.verbose)	Util.TRACE("*** ENDOF Generate SimulaAttributeFile: " + attributeFileName);
	}

	private void write(final BlockDeclaration module) throws IOException {
		File attributeDir = new File(Global.tempClassFileDir + Global.packetName);
		// Util.BREAK("AttributeFile.write: attributeDir="+attributeDir);
		// Util.BREAK("AttributeFile.write: attributeDir'canWrite="+attributeDir.canWrite());
		attributeDir.mkdirs();
		File attributeFile = new File(attributeFileName);
		// Util.BREAK("AttributeFile.write: attributeFile="+attributeFile);
		// Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
		attributeFile.createNewFile();
		// Util.BREAK("AttributeFile.write: attributeFile'canWrite="+attributeFile.canWrite());
		FileOutputStream fileOutputStream = new FileOutputStream(attributeFile);
		oupt = new ObjectOutputStream(fileOutputStream);
		writeVersion();
		writeDependencies();
		if (Option.verbose)
			Util.TRACE("***       Write External " + module.blockKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
		oupt.writeObject(module);
		oupt.flush(); oupt.close();	oupt = null;
	}

	private void writeDependencies() throws IOException {
		//Util.BREAK("AttributeFile.write: BEGIN WRITING DEPENDENCIES");
		for(Declaration dcl:StandardClass.ENVIRONMENT.declarationList) {
			//Util.BREAK("AttributeFile.write: DCL: "+dcl,", QUAL="+dcl.getClass().getSimpleName());
			if(dcl instanceof BlockDeclaration) {
				BlockDeclaration ext=(BlockDeclaration)dcl;
				if(ext.isPreCompiled) {
					//Util.BREAK("AttributeFile.write: BLK="+ext.identifier+", isPreCompiled="+ext.isPreCompiled);   
					if (Option.verbose) Util.TRACE("***       Write External "+ext.blockKind+' '+ext.identifier+'['+ext.externalIdent+']');
						oupt.writeObject(ext);
				}
			}
		}
		//Util.BREAK("AttributeFile.write: END WRITING DEPENDENCIES");
	}

	public static Type readAttributeFile(final InputStream inputStream,final String attributeFileName,
			                             final Vector<Declaration> declarationList) throws IOException, ClassNotFoundException {
		AttributeFile attributeFile = new AttributeFile(attributeFileName);
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
//		Util.BREAK("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
		attributeFile.inpt = new ObjectInputStream(inputStream);
		if (!attributeFile.checkVersion())
			Util.error("Malformed SimulaAttributeFile: " + attributeFileName);
		Type moduleType=null;
		LOOP: while (true) {
			BlockDeclaration module=null;
//			Util.BREAK("AttributeFile.readBlockDeclaration(1): "+module);
			try { module=(BlockDeclaration) attributeFile.inpt.readObject();}
//			catch (ClassNotFoundException e) { Util.INTERNAL_ERROR("Impossible",e); }
			catch (EOFException e1) { break LOOP; }
				
			module.isPreCompiled = true;
			declarationList.add(module);
			moduleType=module.type;
			if (Option.verbose)
				Util.TRACE("***       Read External " + module.blockKind + ' ' + module.identifier + '[' + module.externalIdent + ']');
			if (Option.TRACE_ATTRIBUTE_INPUT) module.print(0);
		}
		attributeFile.inpt.close();
		if (Option.verbose)	Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFileName);
		return(moduleType);
	}	
	  
	
	private BlockDeclaration listAttributeFile(final String attributeFileName) throws IOException, ClassNotFoundException {
		if (Option.verbose)	Util.TRACE("*** BEGIN Read SimulaAttributeFile: " + attributeFileName);
		FileInputStream fileInputStream = new FileInputStream(attributeFileName);
		inpt = new ObjectInputStream(fileInputStream);
		if (!checkVersion()) Util.error("Malformed SimulaAttributeFile: " + attributeFileName);
		BlockDeclaration blockDeclaration=(BlockDeclaration)inpt.readObject();
		inpt.close();
		if (Option.verbose) {
			// Util.BREAK("*** ENDOF Read SimulaAttributeFile: "+attributeFileName);
			if (Option.TRACE_ATTRIBUTE_INPUT) {
				Util.TRACE("*** ENDOF Read SimulaAttributeFile: " + attributeFileName);
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
