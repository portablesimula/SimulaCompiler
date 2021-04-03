// JavaLine 1 <== SourceLine 1527
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1527, lastLine=1534, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$elt_notice RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$symbolbox p$box;
    // Declare local labels
    // JavaLine 14 <== SourceLine 1532
    final LABQNT$ E=new LABQNT$(this,1,"E"); // Local Label #1=E
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 1528
    Head$ inspect$1528$214=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$box=(Common$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt(RTObject$ SL$,Common$symbolbox sp$box) {
        super(SL$);
        // Parameter assignment to locals
        this.p$box = sp$box;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt STM$() {
        Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt THIS$=(Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                {
                    // BEGIN INSPECTION 
                    inspect$1528$214=((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).p$set;
                    if(inspect$1528$214!=null) // INSPECT inspect$1528$214
                    // JavaLine 54 <== SourceLine 1529
                    {
                        if(VALUE$(inspect$1528$214.empty())) {
                            RESULT$=null;
                        } else
                        // JavaLine 59 <== SourceLine 1530
                        {
                            for(boolean CB$1530:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n=(Common$elt_notice)x$; return(x$);};  public Link$ get(){return((Link$)((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n); }	},new NAME$<Link$>() { public Link$ get(){return(inspect$1528$214.first()); }})
                               ,new WhileElt<Common$elt_notice>(new NAME$<Common$elt_notice>(){ public Common$elt_notice put(Common$elt_notice x$){((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n=x$; return(x$);};  public Common$elt_notice get(){return((Common$elt_notice)((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n); }	},new NAME$<Common$elt_notice>() { public Common$elt_notice get(){return(((Common$elt_notice)(((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n!=(null))); }})
                               )) { if(!CB$1530) continue;
                            // JavaLine 65 <== SourceLine 1531
                            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n.p2$ebox==(p$box)))) {
                                GOTO$(E); // GOTO EVALUATED LABEL
                            }
                        }
                        ;
                        // JavaLine 71 <== SourceLine 1532
                        LABEL$(1,"E");
                        RESULT$=((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n;
                        ;
                    }
                    ;
                }
            }
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("get_elt:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("get_elt:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("get_elt:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_elt",1,1527,14,1532,17,1528,54,1529,59,1530,65,1531,71,1532,95,1534);
} // End of Procedure
