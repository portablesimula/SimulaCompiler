/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import simula.compiler.AttributeFile;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.KeyWord;
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
 * <pre>
 * 
 * Syntax:
 *   external-declaration = EXTERNAL [ type ] PROCEDURE external-list
 *                        | EXTERNAL CLASS external-list
 *    external list = external-item { , external-item }
 * 	  external-item = identifier [ "=" external-identifier ]
 *          external-identifier = text-constant   // E.g  a file-name
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ExternalDeclaration extends Declaration {
	/**
	 * The optional type of an external procedure. For external classes this
	 * field has no meaning.
	 */
	private Type type;
	/** Indicates Procedure or Class. */
	private Token kind;
	/** The Class or Procedure identifier */
//	Token identifier;
	/** The external identification. Normally a file-name. */
	Token externalIdentifier;
	
	BlockDeclaration externalBlock;

	public ExternalDeclaration(String identifier,Type type,Token kind,Token externalIdentifier) {
	    super(identifier);
	    this.type=type;
	    this.kind=kind;
	    this.externalIdentifier=externalIdentifier;
		Util.BREAK("END NEW ExternalDeclaration: " + toString());
		String jarFile=externalIdentifier.getIdentifier();
		try { readJarFile(jarFile); } catch(IOException e) { e.printStackTrace(); }
		Util.NOT_IMPLEMENTED("ExternalDeclaration");
		//Util.EXIT();
	}
	
	private void readJarFile1(String jarFileName) throws IOException
	{ Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
	  JarInputStream external=new JarInputStream(new FileInputStream(jarFileName));
	  Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
		
	  Manifest manifest=external.getManifest();
	  Util.BREAK("ExternalDeclaration.readJarFile: manifest="+manifest);
	  Attributes mainAttributes=manifest.getMainAttributes();
	  Util.BREAK("ExternalDeclaration.readJarFile: MainAttributes="+mainAttributes);
	  String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
	  Util.BREAK("ExternalDeclaration.readJarFile: simulaInfo="+simulaInfo);
	  external.close();
	}
	
	private void readJarFile(String jarFileName) throws IOException
	{ Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
	  JarFile external=new JarFile(jarFileName);
	  Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
		
	  Manifest manifest=external.getManifest();
	  Util.BREAK("ExternalDeclaration.readJarFile: manifest="+manifest);
	  Attributes mainAttributes=manifest.getMainAttributes();
	  Util.BREAK("ExternalDeclaration.readJarFile: MainAttributes="+mainAttributes);
	  String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
	  Util.BREAK("ExternalDeclaration.readJarFile: simulaInfo="+simulaInfo);
	  JarEntry entry=external.getJarEntry(simulaInfo);
	  Util.BREAK("ExternalDeclaration.readJarFile: entry="+entry);
	  ZipEntry zipEntry=external.getEntry(simulaInfo);
	  Util.BREAK("ExternalDeclaration.readJarFile: ZipEntry="+zipEntry);
	  InputStream inputStream=external.getInputStream(zipEntry);
	  Util.BREAK("ExternalDeclaration.readJarFile: inputStream="+inputStream);
	  
	  BlockDeclaration decl=AttributeFile.readAttributeFile(inputStream,simulaInfo);
	  externalBlock=decl;

	  external.close();
	}
	/**
	 * Create and parse a new External Declaration.
	 *
	 */
//	public static ExternalDeclaration doParse() {
	public static BlockDeclaration doParse() {
		Type type = acceptType();
		Token kind = Parser.currentToken;
		if (!(Parser.accept(KeyWord.CLASS) || Parser.accept(KeyWord.PROCEDURE)))
			Util.error("parseExternalDeclaration: Expecting CLASS or PROCEDURE");
		String identifier = expectIdentifier();
		Token externalIdentifier = null;
		if (Parser.accept(KeyWord.EQ))	{
			externalIdentifier = Parser.currentToken;
			Parser.expect(KeyWord.TEXTKONST);
		}
		ExternalDeclaration externalDeclaration=new ExternalDeclaration(identifier,type,kind,externalIdentifier);
		return(externalDeclaration.externalBlock);
	}

	/**
	 * Redefinition of the toString method.
	 * 
	 * @return The string representation of this External Declaration.
	 */
	public String toString() {
		return ("EXTERNAL " + type + ' ' + kind + ' ' + identifier + " = "
				+ externalIdentifier);
	}
}
