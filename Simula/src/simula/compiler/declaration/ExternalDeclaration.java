/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
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
public class ExternalDeclaration extends Declaration {
	/**
	 * The optional type of an external procedure. For external classes this
	 * field has no meaning.
	 */
	private Type type;
	/** Indicates Procedure or Class. */
	private String kind;
	/** The Class or Procedure identifier */
//	Token identifier;
	/** The external identification. Normally a file-name. */
	Token externalIdentifier;
	
	BlockDeclaration externalBlock;
	
	/**
	 * Create and parse a new External Declaration.
	 *
	 */
//	public static ExternalDeclaration doParse() {
	public static void doParse(Vector<Declaration> declarationList) {
        //= EXTERNAL  CLASS  ExternalList
        //= EXTERNAL [ kind ] [ type ] PROCEDURE ExternalList
        //| EXTERNAL kind PROCEDURE ExternalItem  IS ProcedureDeclaration
		String kind=acceptIdentifier();
		if(kind!=null) Util.NOT_IMPLEMENTED("External "+kind+" Procedure");
		Type type = acceptType();
		//Token kind = Parser.currentToken;
		if (!(Parser.accept(KeyWord.CLASS) || Parser.accept(KeyWord.PROCEDURE)))
			Util.error("parseExternalDeclaration: Expecting CLASS or PROCEDURE");
		
		String identifier = expectIdentifier();
		LOOP:while(true)
		{ Token externalIdentifier = null;
		  if (Parser.accept(KeyWord.EQ)) {
			  externalIdentifier = Parser.currentToken;
			  Parser.expect(KeyWord.TEXTKONST);
		  }
		  ExternalDeclaration externalDeclaration=new ExternalDeclaration(identifier,type,kind,externalIdentifier);
		  declarationList.add(externalDeclaration.externalBlock);
		  if(Parser.accept(KeyWord.IS))
		  { // ...
			Util.NOT_IMPLEMENTED("External non-Simula Procedure");
			break LOOP;
		  }
		  identifier=acceptIdentifier();
		  if(identifier==null) break LOOP;
		}
	}


	private ExternalDeclaration(String identifier,Type type,String kind,Token externalIdentifier) {
	    super(identifier);
	    this.type=type;
	    this.kind=kind;
	    this.externalIdentifier=externalIdentifier;
		Util.BREAK("END NEW ExternalDeclaration: " + toString());
		String jarFile=externalIdentifier.getIdentifier();
		try { readJarFile(jarFile); } catch(IOException e) { e.printStackTrace(); }
	}
	
	private void readJarFile(String jarFileName) throws IOException
	{ Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
	  JarFile external=new JarFile(jarFileName);
//	  Util.BREAK("ExternalDeclaration.readJarFile: "+jarFileName);
		
	  Manifest manifest=external.getManifest();
//	  Util.BREAK("ExternalDeclaration.readJarFile: manifest="+manifest);
	  Attributes mainAttributes=manifest.getMainAttributes();
//	  Util.BREAK("ExternalDeclaration.readJarFile: MainAttributes="+mainAttributes);
	  String simulaInfo=mainAttributes.getValue("SIMULA-INFO");
//	  Util.BREAK("ExternalDeclaration.readJarFile: simulaInfo="+simulaInfo);
	  JarEntry entry=external.getJarEntry(simulaInfo);
//	  Util.BREAK("ExternalDeclaration.readJarFile: entry="+entry);
	  ZipEntry zipEntry=external.getEntry(simulaInfo);
//	  Util.BREAK("ExternalDeclaration.readJarFile: ZipEntry="+zipEntry);
	  InputStream inputStream=external.getInputStream(zipEntry);
//	  Util.BREAK("ExternalDeclaration.readJarFile: inputStream="+inputStream);
	  
	  BlockDeclaration decl=AttributeFile.readAttributeFile(inputStream,simulaInfo);
	  externalBlock=decl;
	  externalBlock.blockKind=BlockDeclaration.Kind.External;
	  external.close();
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
