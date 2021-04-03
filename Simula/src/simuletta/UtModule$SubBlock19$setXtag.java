// JavaLine 1 <== SourceLine 26
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$setXtag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=26, lastLine=44, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$tag;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 27
    TXT$ id=null;
    // JavaLine 13 <== SourceLine 31
    PrintFile$ inspect$31$116=null;
    // JavaLine 15 <== SourceLine 37
    OuptFile inspect$37$117=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$setXtag setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$setXtag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$tag=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$setXtag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$setXtag(RTObject$ SL$,int sp$tag) {
        super(SL$);
        // Parameter assignment to locals
        this.p$tag = sp$tag;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$setXtag STM$() {
        // JavaLine 44 <== SourceLine 29
        ((UtModule$SubBlock19)(CUR$.SL$)).nx=Math.addExact(((UtModule$SubBlock19)(CUR$.SL$)).nx,1);
        ;
        // JavaLine 47 <== SourceLine 30
        if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$114.option.Elt[rank('Y')-((UtModule)(CUR$.SL$.SL$)).inspect$17$114.option.LB[0]]!=(0)))) {
            // JavaLine 49 <== SourceLine 31
            {
                // BEGIN INSPECTION 
                inspect$31$116=sysout();
                if(inspect$31$116!=null) // INSPECT inspect$31$116
                // JavaLine 54 <== SourceLine 32
                {
                    if(VALUE$((((UtModule$SubBlock19)(CUR$.SL$)).lb>=(80)))) {
                        {
                            inspect$31$116.outimage();
                            ;
                            ((UtModule$SubBlock19)(CUR$.SL$)).lb=21;
                        }
                    } else
                    // JavaLine 63 <== SourceLine 33
                    {
                        inspect$31$116.setpos(((UtModule$SubBlock19)(CUR$.SL$)).lb);
                        ;
                        ((UtModule$SubBlock19)(CUR$.SL$)).lb=Math.addExact(((UtModule$SubBlock19)(CUR$.SL$)).lb,20);
                        ;
                    }
                    ;
                    // JavaLine 71 <== SourceLine 34
                    id=new Common$TagName(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,p$tag).RESULT$;
                    ;
                    // JavaLine 74 <== SourceLine 35
                    inspect$31$116.outint(((UtModule$SubBlock19)(CUR$.SL$)).nxtag,4);
                    ;
                    inspect$31$116.outtext(id);
                    ;
                }
            }
        }
        ;
        // JavaLine 83 <== SourceLine 37
        {
            // BEGIN INSPECTION 
            inspect$37$117=((UtModule)(CUR$.SL$.SL$)).p$scode;
            if(inspect$37$117!=null) // INSPECT inspect$37$117
            // JavaLine 88 <== SourceLine 38
            {
                new OuptFile$outinst(inspect$37$117,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_TAG$1);
                ;
                // JavaLine 92 <== SourceLine 39
                new OuptFile$outnumber(inspect$37$117,p$tag);
                ;
                // JavaLine 95 <== SourceLine 40
                new OuptFile$outnumber(inspect$37$117,((UtModule$SubBlock19)(CUR$.SL$)).nxtag);
                ;
                ((UtModule$SubBlock19)(CUR$.SL$)).nxtag=Math.addExact(((UtModule$SubBlock19)(CUR$.SL$)).nxtag,1);
                ;
                // JavaLine 100 <== SourceLine 41
                if(VALUE$((inspect$37$117.output_trace$3>(0)))) {
                    new OuptFile$outcode(inspect$37$117);
                }
                ;
            }
        }
        ;
        // JavaLine 108 <== SourceLine 43
        if(VALUE$((((UtModule$SubBlock19)(CUR$.SL$)).nxtag!=(((UtModule$SubBlock19)(CUR$.SL$)).nx)))) {
            new Common$ERROR(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,new TXT$("Inconsistent X-tag numbering"));
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure setXtag",1,26,11,27,13,31,15,37,44,29,47,30,49,31,54,32,63,33,71,34,74,35,83,37,88,38,92,39,95,40,100,41,108,43,115,44);
} // End of Procedure
