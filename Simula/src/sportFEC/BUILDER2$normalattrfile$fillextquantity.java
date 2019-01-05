// JavaLine 1 ==> SourceLine 157
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$fillextquantity extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=157, lastLine=207, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$extquantity p$xq;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 158
    COMMON$brecord xb=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$fillextquantity setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$fillextquantity.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$xq=(COMMON$extquantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$fillextquantity(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$fillextquantity(RTObject$ SL$,COMMON$extquantity sp$xq) {
        super(SL$);
        // Parameter assignment to locals
        this.p$xq = sp$xq;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("fillextquantity",158);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$fillextquantity STM$() {
        TRACE_BEGIN_STM$("fillextquantity",158);
        // JavaLine 43 ==> SourceLine 160
        if((((BUILDER2$normalattrfile)(CUR$.SL$)).xident==(null))) {
            // JavaLine 45 ==> SourceLine 161
            {
                TRACE_BEGIN_STM$("CompoundStatement161",161);
                ((BUILDER2)(CUR$.SL$.SL$)).simsymbol=((BUILDER2$normalattrfile)(CUR$.SL$)).xidentstring;
                new COMMON$DEFIDENT(((BUILDER2)(CUR$.SL$.SL$)));
                // JavaLine 50 ==> SourceLine 162
                p$xq.symb=new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2)(CUR$.SL$.SL$)).hashhi,((BUILDER2)(CUR$.SL$.SL$)).hashlo).RESULT$;
                TRACE_END_STM$("CompoundStatement161",162);
            }
        } else
        // JavaLine 55 ==> SourceLine 163
        p$xq.symb=((BUILDER2$normalattrfile)(CUR$.SL$)).xident;
        // JavaLine 57 ==> SourceLine 167
        p$xq.type=((BUILDER2$normalattrfile)(CUR$.SL$)).xtype;
        p$xq.kind=((BUILDER2$normalattrfile)(CUR$.SL$)).xkind;
        p$xq.categ=((BUILDER2$normalattrfile)(CUR$.SL$)).xcateg;
        // JavaLine 61 ==> SourceLine 168
        p$xq.visible=((BUILDER2)(CUR$.SL$.SL$)).NUL;
        p$xq.protect=((BUILDER2$normalattrfile)(CUR$.SL$)).xprotect;
        // JavaLine 64 ==> SourceLine 169
        p$xq.line=((-((rank(((BUILDER2$normalattrfile)(CUR$.SL$)).xprefqhi)*(256))))-(rank(((BUILDER2$normalattrfile)(CUR$.SL$)).xprefqlo)));
        // JavaLine 66 ==> SourceLine 170
        p$xq.plev=((BUILDER2)(CUR$.SL$.SL$)).one;
        // JavaLine 68 ==> SourceLine 171
        p$xq.ftag=((BUILDER2$normalattrfile)(CUR$.SL$)).xftag;
        // JavaLine 70 ==> SourceLine 172
        p$xq.clf=((BUILDER2$normalattrfile)(CUR$.SL$)).xclf;
        // JavaLine 72 ==> SourceLine 173
        p$xq.longindic=((BUILDER2$normalattrfile)(CUR$.SL$)).xlongindic;
        // JavaLine 74 ==> SourceLine 174
        if((((BUILDER2$normalattrfile)(CUR$.SL$)).xcateg==(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))) {
            // JavaLine 76 ==> SourceLine 175
            {
                TRACE_BEGIN_STM$("CompoundStatement175",175);
                p$xq.dim=((BUILDER2$normalattrfile)(CUR$.SL$)).xlanguage;
                // JavaLine 80 ==> SourceLine 176
                p$xq.virtno=((BUILDER2$normalattrfile)(CUR$.SL$)).xextident;
                // JavaLine 82 ==> SourceLine 177
                if(IS$(p$xq.descr,COMMON$extbrecord.class)) {
                    // JavaLine 84 ==> SourceLine 179
                    {
                        TRACE_BEGIN_STM$("CompoundStatement179",179);
                        xb=p$xq.descr;
                        // JavaLine 88 ==> SourceLine 180
                        xb.kind=((BUILDER2$normalattrfile)(CUR$.SL$)).xkind;
                        // JavaLine 90 ==> SourceLine 181
                        xb.thisused=((BUILDER2$normalattrfile)(CUR$.SL$)).xthisused;
                        // JavaLine 92 ==> SourceLine 182
                        xb.connests=rank(((BUILDER2$normalattrfile)(CUR$.SL$)).xconnests);
                        // JavaLine 94 ==> SourceLine 186
                        xb.inrtag=((BUILDER2$normalattrfile)(CUR$.SL$)).xinrtag;
                        xb.hasCode=((BUILDER2$normalattrfile)(CUR$.SL$)).xhascode;
                        // JavaLine 97 ==> SourceLine 187
                        ((COMMON$extbrecord)(xb)).modulhi=((BUILDER2$normalattrfile)(CUR$.SL$)).xmodulhi;
                        // JavaLine 99 ==> SourceLine 188
                        ((COMMON$extbrecord)(xb)).modullo=((BUILDER2$normalattrfile)(CUR$.SL$)).xmodullo;
                        // JavaLine 101 ==> SourceLine 189
                        ((COMMON$extbrecord)(xb)).checkhi=((BUILDER2$normalattrfile)(CUR$.SL$)).xcheckhi;
                        // JavaLine 103 ==> SourceLine 190
                        ((COMMON$extbrecord)(xb)).checklo=((BUILDER2$normalattrfile)(CUR$.SL$)).xchecklo;
                        // JavaLine 105 ==> SourceLine 191
                        xb.hidlist=((BUILDER2$normalattrfile)(CUR$.SL$)).xhidlist;
                        TRACE_END_STM$("CompoundStatement179",191);
                    }
                }
                TRACE_END_STM$("CompoundStatement175",191);
            }
        } else
        // JavaLine 113 ==> SourceLine 194
        p$xq.dim=((BUILDER2$normalattrfile)(CUR$.SL$)).xdim;
        // JavaLine 115 ==> SourceLine 195
        p$xq.special=((BUILDER2$normalattrfile)(CUR$.SL$)).xspecial;
        // JavaLine 117 ==> SourceLine 196
        if(((p$xq.special!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))||((p$xq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_rep))))) {
            // JavaLine 119 ==> SourceLine 199
            {
                TRACE_BEGIN_STM$("CompoundStatement199",199);
                xb=new COMMON$brecord(((BUILDER2)(CUR$.SL$.SL$))).STM$();
                // JavaLine 123 ==> SourceLine 201
                xb.declquant=p$xq;
                p$xq.descr=xb;
                // JavaLine 126 ==> SourceLine 202
                xb.blnohi=((BUILDER2$normalattrfile)(CUR$.SL$)).xarrhi;
                xb.blnolo=((BUILDER2$normalattrfile)(CUR$.SL$)).xarrlo;
                // JavaLine 129 ==> SourceLine 203
                if((p$xq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_rep))) {
                    // JavaLine 131 ==> SourceLine 204
                    {
                        TRACE_BEGIN_STM$("CompoundStatement204",204);
                        xb.line1=((BUILDER2$normalattrfile)(CUR$.SL$)).xlanguage;
                        xb.npar=((BUILDER2$normalattrfile)(CUR$.SL$)).xextident;
                        TRACE_END_STM$("CompoundStatement204",204);
                    }
                }
                TRACE_END_STM$("CompoundStatement199",204);
            }
        }
        TRACE_END_STM$("fillextquantity",204);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure fillextquantity",1,157,12,158,43,160,45,161,50,162,55,163,57,167,61,168,64,169,66,170,68,171,70,172,72,173,74,174,76,175,80,176,82,177,84,179,88,180,90,181,92,182,94,186,97,187,99,188,101,189,103,190,105,191,113,194,115,195,117,196,119,199,123,201,126,202,129,203,131,204,145,207);
}
