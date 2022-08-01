package simula.compiler.byteCodeEngineering;

import java.util.Set;

import simula.compiler.utilities.Global;

/**
 * This class is introduced to compensate for a weakness in ASM.
 * ClassWriter.getCommonSuperClass does not work because Global.tempClassFileDir is not present in java.class.path
 * 
 * See: ExtendedClassWriter.getCommonSuperClass
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class JavaClassInfo {
	private static final boolean DEBUG=false;
	public String externalIdent; // JavaClassName TODO: TESTING NYTT_OPPLEGG
	public String prefixIdent;   // JavaClassName TODO: TESTING NYTT_OPPLEGG
	
	public static void put(String key,JavaClassInfo info) {
		Global.javaClassMap.putIfAbsent(key,info); // TODO: TESTING NYTT_OPPLEGG
	}
	
	public static JavaClassInfo get(String key) {
		JavaClassInfo info=Global.javaClassMap.get(key);
		if(info==null) printJavaClassMap("");
		return(info);		
	}

	public boolean isSuperTypeOf(final JavaClassInfo other) { // TODO: TESTING NYTT_OPPLEGG
		// This is subtype of other   iff   This is in other's prefix chain.
		boolean res=false;
		String prefix=other.prefixIdent;
		LOOP:while(prefix != null) {
			if(this.externalIdent.equals(prefix)) { res=true; break LOOP; }
			prefix = getPrefixIdent(prefix);
		}
		if(DEBUG) System.out.println("JavaClassInfo.isSuperTypeOf: "+this.externalIdent+".isSuperTypeOf("+other.externalIdent+") ==> "+res);  // TODO: TESTING Path
		return (res);
	}

	private String getPrefixIdent(String ident) {
		JavaClassInfo prefix=Global.javaClassMap.get(ident);
		String res=((prefix==null)?null:prefix.prefixIdent);
		if(DEBUG) System.out.println("JavaClassInfo.getClassInfo: getPrefixIdent("+ident+") ==> "+res);  // TODO: TESTING Path
		return(res);
	}
	
	public static void printJavaClassMap(String title) {
		Set<String> keys=Global.javaClassMap.keySet();
		for(String key:keys) {
			System.out.println("JavaClassMap-Key: "+key+", value="+Global.javaClassMap.get(key));
		}
	}

	public String toString() {
		return("JavaClassInfo: externalIdent="+externalIdent+", prefixIdent="+prefixIdent);
	}
}
