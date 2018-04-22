package simula.runtime;

import simula.compiler.utilities.Util;

public abstract class ClassBody {
	RTObject$ object;
	public ClassBody inner;
	public ClassBody outer;
	
	public ClassBody(ClassBody outer,RTObject$ object)
	{ this.outer=outer; this.object=object;
      if(outer!=null) outer.inner=this;
	}
	
	public RTObject$ EXEC$()
	{ // Execute Concatenated Sequence of Class Statements
	  // Start with Statements before INNER in outermost Class
	  if(outer!=null) outer.EXEC$();
	  else {
		  //Util.BREAK("ClassBody.EXEC$: CALL STM: "+object);
		  STM();
		  //Util.BREAK("ClassBody.EXEC$: ENDE STM: "+object);
	  }
	  return(object);
	}
	
	public abstract void STM();

}
