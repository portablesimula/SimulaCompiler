/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import java.util.Set;

import simula.compiler.utilities.Global;

/**
 * Java class info.
 * <p>
 * This class is introduced to compensate for a weakness in ASM.
 * <p>
 * ClassWriter.getCommonSuperClass does not work because Global.tempClassFileDir is not present in java.class.path
 * <p>
 * See: ExtendedClassWriter.getCommonSuperClass
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/byteCodeEngineering/JavaClassInfo.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class JavaClassInfo {
	private static final boolean DEBUG=false;
	
	/**
	 * External identifier.
	 */
	public String externalIdent;
	
	/**
	 * Prefix identifier.
	 */
	public String prefixIdent;
	
	/**
	 * Default constructor.
	 */
	public JavaClassInfo(){}
	
	/**
	 * Update Global.javaClassMap.
	 * @param key the key
	 * @param info the info
	 */
	public static void put(String key,JavaClassInfo info) {
		Global.javaClassMap.putIfAbsent(key,info);
	}
	
	/**
	 * Get the JavaClassInfo associated with 'key'
	 * @param key a java class map key
	 * @return the associated info or an empty String if not found
	 */
	static JavaClassInfo get(String key) {
		JavaClassInfo info=Global.javaClassMap.get(key);
		if(info==null) printJavaClassMap("");
		return(info);		
	}

	/**
	 * Test if this JavaClassInfo is super of the other JavaClassInfo.
	 * <p>
	 * This is subtype of other   iff   This is in other's prefix chain.
	 * @param other the other JavaClassInfo
	 * @return true if condition holds
	 */
	boolean isSuperTypeOf(final JavaClassInfo other) {
		boolean res=false;
		String prefix=other.prefixIdent;
		LOOP:while(prefix != null) {
			if(this.externalIdent.equals(prefix)) { res=true; break LOOP; }
			prefix = getPrefixIdent(prefix);
		}
		if(DEBUG) System.out.println("JavaClassInfo.isSuperTypeOf: "+this.externalIdent+".isSuperTypeOf("+other.externalIdent+") ==> "+res);
		return (res);
	}

	private String getPrefixIdent(String ident) {
		JavaClassInfo prefix=Global.javaClassMap.get(ident);
		String res=((prefix==null)?null:prefix.prefixIdent);
		if(DEBUG) System.out.println("JavaClassInfo.getClassInfo: getPrefixIdent("+ident+") ==> "+res);
		return(res);
	}
	
	/**
	 * Utility: Print Java class map
	 * @param title the title
	 */
	static void printJavaClassMap(String title) {
		Set<String> keys=Global.javaClassMap.keySet();
		for(String key:keys) {
			System.out.println("JavaClassMap-Key: "+key+", value="+Global.javaClassMap.get(key));
		}
	}

	@Override
	public String toString() {
		return("JavaClassInfo: externalIdent="+externalIdent+", prefixIdent="+prefixIdent);
	}
}
