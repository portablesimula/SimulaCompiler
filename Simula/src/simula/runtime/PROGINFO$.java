package simula.runtime;

public class PROGINFO$ {
	String file; // Simula Source File - e.g.  program.sim
	String ident;
	int[] LINEMAP$;
//	PROGINFO$(String ident,int[] lineMap)
	public PROGINFO$(String file,String ident,int... lineMap)
	{ this.file=file;
	  this.ident=ident;
	  this.LINEMAP$=lineMap;
	}
}
