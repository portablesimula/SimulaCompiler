package simula.runtime;

public class _PROGINFO {
	final String file; // Simula Source File - e.g.  program.sim 
	final String ident;
	final int[] LINEMAP_;
//	_PROGINFO(String ident,int[] lineMap)
	public _PROGINFO(final String file,final String ident,final int... lineMap)
	{ this.file=file;
	  this.ident=ident;
	  this.LINEMAP_=lineMap;
	}
}
