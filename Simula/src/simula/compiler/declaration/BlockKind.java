package simula.compiler.declaration;

public enum BlockKind {
//	ExternalClass,
//	ExternalProcedure,
	StandardClass,
	ConnectionBlock,
	CompoundStatement,
    SubBlock,
    Procedure, // Normal Simula Procedure implemented as a Java Class
    MemberMethod,    // Procedure coded as a Java Member Method. 
	StaticMethod,      // Treated as a Java Static Method with implicit 0th parameter 'static link'
	ContextFreeMethod, // Treated as a Java Static Method without 0th parameter (Context Free Method)
    Class,
    PrefixedBlock,
    SimulaProgram,
//    Switch

}
