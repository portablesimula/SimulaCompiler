// JavaLine 1 ==> SourceLine 1674
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$brecinit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1674, lastLine=1690, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$breckind;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1675
    COMMON$brctab2 tab2=null;
    // JavaLine 14 ==> SourceLine 1676
    COMMON$brecord inspect$1676$20=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$brecinit setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$brecinit.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$breckind=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$L2Coder$brecinit(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$brecinit(RTObject$ SL$,char sp$breckind) {
        super(SL$);
        // Parameter assignment to locals
        this.p$breckind = sp$breckind;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("brecinit",1676);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$brecinit STM$() {
        TRACE_BEGIN_STM$("brecinit",1676);
        {
            // BEGIN INSPECTION 
            inspect$1676$20=new COMMON$brecord(((SCANNER)(CUR$.SL$.SL$))).STM$();
            if(inspect$1676$20!=null) //INSPECT inspect$1676$20
            // JavaLine 49 ==> SourceLine 1677
            {
                TRACE_BEGIN_STM$("CompoundStatement1677",1677);
                inspect$1676$20.blnohi=((SCANNER)(CUR$.SL$.SL$)).nextblhi;
                inspect$1676$20.blnolo=((SCANNER)(CUR$.SL$.SL$)).nextbllo;
                // JavaLine 54 ==> SourceLine 1678
                inspect$1676$20.kind=p$breckind;
                inspect$1676$20.line1=((SCANNER)(CUR$.SL$.SL$)).linenr;
                // JavaLine 57 ==> SourceLine 1679
                if((((SCANNER)(CUR$.SL$.SL$)).nextbllo==(((char)255)))) {
                    // JavaLine 59 ==> SourceLine 1680
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1680",1680);
                        ((SCANNER)(CUR$.SL$.SL$)).nextbllo=((SCANNER)(CUR$.SL$.SL$)).NUL;
                        // JavaLine 63 ==> SourceLine 1681
                        ((SCANNER)(CUR$.SL$.SL$)).nextblhi=char$((rank(((SCANNER)(CUR$.SL$.SL$)).nextblhi)+(1)));
                        TRACE_END_STM$("CompoundStatement1680",1681);
                    }
                } else
                // JavaLine 68 ==> SourceLine 1682
                ((SCANNER)(CUR$.SL$.SL$)).nextbllo=char$((rank(((SCANNER)(CUR$.SL$.SL$)).nextbllo)+(1)));
                // JavaLine 70 ==> SourceLine 1683
                ((SCANNER$L2Coder)(CUR$.SL$)).cquant=inspect$1676$20.fpar=new COMMON$quantity(((SCANNER)(CUR$.SL$.SL$))).STM$();
                inspect$1676$20.fpar.categ=((SCANNER)(CUR$.SL$.SL$)).C_unknwn;
                // JavaLine 73 ==> SourceLine 1684
                inspect$1676$20.fpar.encl=((SCANNER$L2Coder)(CUR$.SL$)).cbrec;
                // JavaLine 75 ==> SourceLine 1685
                tab2=((SCANNER)(CUR$.SL$.SL$)).brctab.Elt[rank(inspect$1676$20.blnohi)-((SCANNER)(CUR$.SL$.SL$)).brctab.LB[0]];
                // JavaLine 77 ==> SourceLine 1686
                if((tab2==(null))) {
                    // JavaLine 79 ==> SourceLine 1687
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1687",1687);
                        tab2=new COMMON$brctab2(((SCANNER)(CUR$.SL$.SL$))).STM$();
                        ((SCANNER)(CUR$.SL$.SL$)).brctab.Elt[rank(inspect$1676$20.blnohi)-((SCANNER)(CUR$.SL$.SL$)).brctab.LB[0]]=tab2;
                        TRACE_END_STM$("CompoundStatement1687",1687);
                    }
                }
                // JavaLine 87 ==> SourceLine 1688
                ((ARRAY$<COMMON$brecord[]>)tab2.val).Elt[rank(inspect$1676$20.blnolo)-tab2.val.LB[0]]=((SCANNER$L2Coder)(CUR$.SL$)).cbrec=((COMMON$brecord)inspect$1676$20);
                TRACE_END_STM$("CompoundStatement1677",1688);
            }
        }
        TRACE_END_STM$("brecinit",1688);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure brecinit",1,1674,12,1675,14,1676,49,1677,54,1678,57,1679,59,1680,63,1681,68,1682,70,1683,73,1684,75,1685,77,1686,79,1687,87,1688,95,1690);
}
