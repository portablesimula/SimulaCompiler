/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

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

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.utilities.Global;


public final class ExternalJarFile {
	String jarFileName;
	public static Vector<ExternalJarFile> ExternalJarFiles=new Vector<ExternalJarFile>();
	
	public ExternalJarFile(String jarFileName)
	{ this.jarFileName=jarFileName;	}
	
	public BlockDeclaration readJarFile() //throws IOException
	{ //Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
	  try { JarFile jarFile=new JarFile(jarFileName);
//	        Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
		
	        Manifest manifest=jarFile.getManifest();
//	        Util.BREAK("ExternalDeclaration.readJarFile: manifest="+manifest);
	        Attributes mainAttributes=manifest.getMainAttributes();
//	        Util.BREAK("ExternalDeclaration.readJarFile: MainAttributes="+mainAttributes);
	        String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
//	        Util.BREAK("ExternalDeclaration.readJarFile: simulaInfo="+simulaInfo);
//	        JarEntry entry=external.getJarEntry(simulaInfo);
//	        Util.BREAK("ExternalDeclaration.readJarFile: entry="+entry);
	        ZipEntry zipEntry=jarFile.getEntry(simulaInfo);
//	        Util.BREAK("ExternalDeclaration.readJarFile: ZipEntry="+zipEntry);
	        InputStream inputStream=jarFile.getInputStream(zipEntry);
//	        Util.BREAK("ExternalDeclaration.readJarFile: inputStream="+inputStream);
	  
	        BlockDeclaration decl=AttributeFile.readAttributeFile(inputStream,simulaInfo);
//	        decl.blockKind=BlockDeclaration.Kind.External;
	        inputStream.close();
	        
	        File destDir=new File(Global.tempClassFileDir);
	        expandJarEntries(jarFile,destDir);

	        
	        decl.isPreCompiled=true;
	        inputStream.close();
	        jarFile.close();
	        ExternalJarFiles.add(this);
	        return(decl);
	  } catch(IOException e) {
		  e.printStackTrace();
		  return(null);
	  }
	}

	   private static void expandJarEntries(JarFile jarFile, File destDir) throws IOException {
	       new File(destDir,Global.packetName).mkdirs(); // Create directories
	       Enumeration<JarEntry> entries = jarFile.entries();
	       LOOP:while (entries.hasMoreElements()) {
	           JarEntry entry = entries.nextElement();
	           InputStream inputStream = jarFile.getInputStream(entry);
	           
	           String name=entry.getName();
//	           if(name.startsWith("simula/runtime")) continue LOOP;
//	           if(name.startsWith("simula/compiler")) continue LOOP;
	           if(!name.startsWith(Global.packetName)) continue LOOP;
	           if(!name.endsWith(".class")) continue LOOP;
	           //Util.BREAK("ExternalJarFile.expandJarEntries: entry'name="+entry.getName());
	           //Util.BREAK("ExternalJarFile.expandJarEntries: TREAT entry="+entry);
		       File destFile = new File(destDir,entry.getName());
	           //Util.BREAK("ExternalJarFile.expandJarEntries: destFile="+destFile);
		       OutputStream outputStream=new FileOutputStream(destFile);	 
	           byte[] buffer = new byte[4096];
	           int bytesRead = 0;
	           while ((bytesRead = inputStream.read(buffer)) != -1) {
	        	   outputStream.write(buffer, 0, bytesRead);
	           }
	           inputStream.close();
	           outputStream.flush();
	           outputStream.close();
	       }
	   }


	   
}
