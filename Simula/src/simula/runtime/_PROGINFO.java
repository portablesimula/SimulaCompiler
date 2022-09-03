package simula.runtime;

public class _PROGINFO {
	final String file; // Simula Source File - e.g.  program.sim 
	final String ident;
	final int[] LINEMAP_;
	public _PROGINFO(final String file,final String ident,final int... lineMap)
	{ this.file=file;
	  this.ident=ident;
	  this.LINEMAP_=lineMap;
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(file).append(':').append(ident);
		int x=0;
		while(x<LINEMAP_.length) {
			sb.append("<j").append(LINEMAP_[x++]).append(":s").append(LINEMAP_[x++]).append('>');
		}
		return(sb.toString());
	}
}
