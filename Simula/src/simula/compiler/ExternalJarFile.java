package simula.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.utilities.Util;


public class ExternalJarFile {
	String jarFileName;
	public static Vector<ExternalJarFile> ExternalJarFiles=new Vector<ExternalJarFile>();
	
	public ExternalJarFile(String jarFileName)
	{ this.jarFileName=jarFileName;	}
	
	public BlockDeclaration readJarFile() //throws IOException
	{ Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
	  try { JarFile external=new JarFile(jarFileName);
//	        Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
		
	        Manifest manifest=external.getManifest();
//	        Util.BREAK("ExternalDeclaration.readJarFile: manifest="+manifest);
	        Attributes mainAttributes=manifest.getMainAttributes();
//	        Util.BREAK("ExternalDeclaration.readJarFile: MainAttributes="+mainAttributes);
	        String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
//	        Util.BREAK("ExternalDeclaration.readJarFile: simulaInfo="+simulaInfo);
	        JarEntry entry=external.getJarEntry(simulaInfo);
//	        Util.BREAK("ExternalDeclaration.readJarFile: entry="+entry);
	        ZipEntry zipEntry=external.getEntry(simulaInfo);
//	        Util.BREAK("ExternalDeclaration.readJarFile: ZipEntry="+zipEntry);
	        InputStream inputStream=external.getInputStream(zipEntry);
//	        Util.BREAK("ExternalDeclaration.readJarFile: inputStream="+inputStream);
	  
	        BlockDeclaration decl=AttributeFile.readAttributeFile(inputStream,simulaInfo);
//	  externalBlock=decl;
	        decl.blockKind=BlockDeclaration.Kind.External;
	        external.close();
	        ExternalJarFiles.add(this);
	        return(decl);
	  } catch(IOException e) {
		  e.printStackTrace();
		  return(null);
	  }
	}

}
