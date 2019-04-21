

import simula.runtime.RTObject$.LABQNT$;
import simula.runtime.RTObject$.OperationalState;

/**
* 
* @author Øystein Myhre Andersen
*/
public abstract class ClassBody {
	String identifier;
	RTObject$ object;
	public int prefixLevel;
	public ClassBody inner;
	public ClassBody outer;
	
	public ClassBody(String identifier,ClassBody outer,RTObject$ object,int prefixLevel)
	{ this.identifier=identifier; this.outer=outer; this.object=object; this.prefixLevel=prefixLevel;
      if(outer!=null)
      { outer.inner=this;
        RT.ASSERT(this.prefixLevel==outer.prefixLevel+1, "Prefix Invariant");
      }
	}
	
	public RTObject$ OLD_EXEC$()
	{ // Execute Concatenated Sequence of Class Statements
	  // Start with Statements before INNER in outermost Class
	  if(outer!=null) outer.EXEC$();
	  else { //RT.BREAK("ClassBody.EXEC$: CALL STM$: "+object);
		     STM$(null); // Global.WITH_VIRTUAL_LABELS
		     //RT.BREAK("ClassBody.EXEC$: ENDE STM$: "+object);
	  } return(object);
	}
	
	public RTObject$ EXEC$() {
		// Execute Concatenated Sequence of Class Statements
		// Start with Statements before INNER in outermost Class
		if (outer != null) outer.EXEC$();
		else { try {
					if (RT.Option.GOTO_TRACING) RT.println("RTObject$.ClassBody.EXEC$: CALL STM$: "+object);
					STM$(null); // Global.WITH_VIRTUAL_LABELS
					if (RT.Option.GOTO_TRACING) RT.println("RTObject$.EXEC$: ENDE STM$: "+object);
				} catch (LABQNT$ q) {
					if (q.SL$ != RTObject$.CUR$) {
						RTObject$.CUR$.STATE$ = OperationalState.terminated;
						if (RT.Option.GOTO_TRACING)
							RTObject$.TRACE_GOTO("NON-LOCAL", q);
						throw (q);
					}
					if (RT.Option.GOTO_TRACING)
					{ RTObject$.TRACE_GOTO("ClassBody: GOTO", q);
//					  RT.println("RTObject$.EXEC$: GOTO VIRTUAL ? " + q);
//					  RT.println("RTObject$.EXEC$: GOTO VIRTUAL ? q.index=" + q.index);
//					  RT.println("RTObject$.EXEC$: GOTO VIRTUAL ? object=" + object);
//					  RT.println("RTObject$.EXEC$: GOTO VIRTUAL ? RTObject$.CUR$=" + RTObject$.CUR$);
					}
//					RT.println("NOT IMPLEMENTED: Goto Label "+q);
//					ENVIRONMENT$.printStackTrace(2);
//					//q.printStackTrace();
					
					throw(new RuntimeException("Illegal Goto Label ",q));
				}
			}
		
		return (object);
	}
	
//	public abstract void STM$();
	public abstract void STM$(LABQNT$ pendingGoto); // Global.WITH_VIRTUAL_LABELS
	
	public String toString() {
		return(identifier);//+"[outer="+outer+",inner="+inner+']');
	}

}
