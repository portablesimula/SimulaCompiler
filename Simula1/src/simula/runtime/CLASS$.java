/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
* 
* @author SIMULA Standards Group
* @author Øystein Myhre Andersen
*/
public abstract class CLASS$ extends BASICIO$ implements Runnable {
	// Constructor
	public CLASS$(final RTObject$ staticLink) {
		super(staticLink);
	}

	// Runnable Body
	public RTObject$ START$() {
		beginCoroutine();
		return(this);
	}
  
	public void run() {
		STM$();
	}

	
	// *********************************************************************
	// *** BEGIN QPS COMPONENT IN A SEPARATE COROUTINE
	// *********************************************************************
	private void beginCoroutine() {
		// Using Thread or Virtual Thread
		this.CORUT$=new Coroutine(this);
		if(RT.Option.QPS_TRACING) RT.TRACE("START "+this.edObjectIdent());
		RT.ASSERT(CUR$==this,"CLASS$.START:Invariant-1");
		swapCoroutines();
	}

}