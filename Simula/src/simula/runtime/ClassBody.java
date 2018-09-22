package simula.runtime;

import simula.runtime.RTObject$.LABQNT$;
import simula.runtime.RTObject$.OperationalState;

/**
* 
* @author Øystein Myhre Andersen
*/
public abstract class ClassBody {
	RTObject$ object;
	public int prefixLevel;
	public ClassBody inner;
	public ClassBody outer;
	
	public ClassBody(ClassBody outer,RTObject$ object,int prefixLevel)
	{ this.outer=outer; this.object=object; this.prefixLevel=prefixLevel;
      if(outer!=null)
      { outer.inner=this;
        RT.ASSERT(this.prefixLevel==outer.prefixLevel+1, "Prefix Invariant");
      }
	}
	
	public RTObject$ OLD_EXEC$()
	{ // Execute Concatenated Sequence of Class Statements
	  // Start with Statements before INNER in outermost Class
	  if(outer!=null) outer.EXEC$();
	  else { //RT.BREAK("ClassBody.EXEC$: CALL STM: "+object);
		     STM();
		     //RT.BREAK("ClassBody.EXEC$: ENDE STM: "+object);
	  } return(object);
	}
	
	public RTObject$ EXEC$() {
		// Execute Concatenated Sequence of Class Statements
		// Start with Statements before INNER in outermost Class
		if (outer != null) outer.EXEC$();
		else { try {
					if (RT.Option.GOTO_TRACING) System.out.println("RTObject$.ClassBody.EXEC$: CALL STM: "+object);
					STM();
					if (RT.Option.GOTO_TRACING) System.out.println("RTObject$.EXEC$: ENDE STM: "+object);
				} catch (LABQNT$ q) {
					if (q.SL$ != RTObject$.CUR$) {
						RTObject$.CUR$.STATE$ = OperationalState.terminated;
						if (RT.Option.GOTO_TRACING)
							RTObject$.TRACE_GOTO("NON-LOCAL", q);

						throw (q);
					}
					if (RT.Option.GOTO_TRACING)
					{ RTObject$.TRACE_GOTO("ClassBody: GOTO VIRTUAL", q);
					  System.out.println("RTObject$.EXEC$: GOTO VIRTUAL ? " + q);
					  System.out.println("RTObject$.EXEC$: GOTO VIRTUAL ? q.index=" + q.index);
					  System.out.println("RTObject$.EXEC$: GOTO VIRTUAL ? object=" + object);
					  System.out.println("RTObject$.EXEC$: GOTO VIRTUAL ? RTObject$.CUR$=" + RTObject$.CUR$);
					}
					System.out.println("NOT IMPLEMENTED: Goto Virtual Label "+q);
					RT.printStackTrace(2);
					//q.printStackTrace();
					
					throw(new RuntimeException("NOT IMPLEMENTED: Goto Virtual Label ",q));
				}
			}
		
		return (object);
	}
	
	public abstract void STM();

}
