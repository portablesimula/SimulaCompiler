// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed Jun 05 18:05:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue33$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=61, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 50
    int nD=0;
    int nF=0;
    int i=0;
    int U1=0;
    int U2=0;
    // Normal Constructor
    public issue33$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue33$");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue33$",50);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue33$",50);
        // JavaLine 28 <== SourceLine 52
        U1=4001;
        U2=4013;
        // JavaLine 31 <== SourceLine 54
        for(boolean CB$54:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){nD=(int)x$; return(x$);};  public Number get(){return((Number)nD); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(6); }})
           )) { if(!CB$54) continue;
        // JavaLine 35 <== SourceLine 55
        for(boolean CB$55:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){nF=(int)x$; return(x$);};  public Number get(){return((Number)nF); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.multiplyExact(2,nD)); }})
           )) { if(!CB$55) continue;
        // JavaLine 39 <== SourceLine 60
        new issue33$PBLK56((CUR$),nD,nF).START$();
    }
}
TRACE_END_STM$("issue33$",59);
EBLK();
return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
//System.setProperty("file.encoding","UTF-8");
RT.setRuntimeOptions(args);
new issue33$(CTX$).STM$();
} // End of main
public static PROGINFO$ INFO$=new PROGINFO$("issue33.sim","SimulaProgram issue33$",1,6,11,50,28,52,31,54,35,55,39,60,52,61);
} // End of SubBlock
