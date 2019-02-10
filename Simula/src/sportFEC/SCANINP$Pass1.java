// JavaLine 1 ==> SourceLine 35
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 20:42:06 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANINP$Pass1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=35, lastLine=88, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 38
    char c=0;
    // JavaLine 16 ==> SourceLine 39
    int i=0;
    int j=0;
    int l=0;
    // JavaLine 20 ==> SourceLine 40
    TXT$ t=null;
    // JavaLine 22 ==> SourceLine 65
    InbyteFile$ inspect$65$0=null;
    // Normal Constructor
    public SCANINP$Pass1(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Pass1",65);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANINP$Pass1 STM$() {
        TRACE_BEGIN_STM$("Pass1",65);
        // JavaLine 36 ==> SourceLine 42
        call(((SCANINP)(CUR$.SL$)).scanner);
        // JavaLine 38 ==> SourceLine 44
        ((SCANINP)(CUR$.SL$)).optx=((SCANINP)(CUR$.SL$)).opdhi=((SCANINP)(CUR$.SL$)).opdlo=((SCANINP)(CUR$.SL$)).optx=((SCANINP)(CUR$.SL$)).NUL;
        // JavaLine 40 ==> SourceLine 45
        RESULT$=((SCANINP)(CUR$.SL$)).linenr;
        // JavaLine 42 ==> SourceLine 46
        ((SCANINP)(CUR$.SL$)).line=((SCANINP)(CUR$.SL$)).listpart=new TXT$("-- after Source End-of-File --");
        // JavaLine 44 ==> SourceLine 47
        ((SCANINP)(CUR$.SL$)).linelength=30;
        // JavaLine 46 ==> SourceLine 48
        if(VALUE$((((SCANINP)(CUR$.SL$)).maxnumoftags>(0)))) {
            // JavaLine 48 ==> SourceLine 49
            {
                TRACE_BEGIN_STM$("CompoundStatement49",49);
                t=new COMMON$leftint(((SCANINP)(CUR$.SL$)),((SCANINP)(CUR$.SL$)).maxnumoftags).RESULT$;
                new ERRMSG$error1(((SCANINP)(CUR$.SL$)),-367,t);
                // JavaLine 53 ==> SourceLine 50
                while((((SCANINP)(CUR$.SL$)).maxnumoftags>(0))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement50",50);
                        ((SCANINP)(CUR$.SL$)).maxnumoftags=(((SCANINP)(CUR$.SL$)).maxnumoftags-(1));
                        // JavaLine 58 ==> SourceLine 51
                        ((SCANINP)(CUR$.SL$)).parser.cs=((SCANINP)(CUR$.SL$)).opt=((SCANINP)(CUR$.SL$)).IEND;
                        ((SCANINP)(CUR$.SL$)).parser.getopt=false;
                        call(((SCANINP)(CUR$.SL$)).parser);
                        // JavaLine 62 ==> SourceLine 52
                        ((SCANINP)(CUR$.SL$)).optx=((SCANINP)(CUR$.SL$)).opdhi=((SCANINP)(CUR$.SL$)).opdlo=((SCANINP)(CUR$.SL$)).optx=((SCANINP)(CUR$.SL$)).NUL;
                        TRACE_END_STM$("CompoundStatement50",52);
                    }
                }
                TRACE_END_STM$("CompoundStatement49",52);
            }
        }
        // JavaLine 70 ==> SourceLine 54
        ((SCANINP)(CUR$.SL$)).parser.cs=((SCANINP)(CUR$.SL$)).opt=((SCANINP)(CUR$.SL$)).IEOP;
        ((SCANINP)(CUR$.SL$)).parser.getopt=false;
        call(((SCANINP)(CUR$.SL$)).parser);
        // JavaLine 74 ==> SourceLine 57
        new SCANNER$ClosePass1(((SCANINP)(CUR$.SL$)));
        // JavaLine 76 ==> SourceLine 58
        if(VALUE$((((SCANINP)(CUR$.SL$)).option.Elt[rank('O')-((SCANINP)(CUR$.SL$)).option.LB[0]]!=(((SCANINP)(CUR$.SL$)).NUL)))) {
            // JavaLine 78 ==> SourceLine 59
            {
                TRACE_BEGIN_STM$("CompoundStatement59",59);
                sysout().outimage();
                sysout().outtext(new TXT$("*** END PASS 1 *** - "));
                // JavaLine 83 ==> SourceLine 60
                sysout().outint(((SCANINP)(CUR$.SL$)).linenr,6);
                sysout().outtext(new TXT$(" lines"));
                // JavaLine 86 ==> SourceLine 63
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement59",63);
            }
        }
        // JavaLine 91 ==> SourceLine 65
        if(VALUE$((((SCANINP)(CUR$.SL$)).L2OUPT!=(null)))) {
            {
                // BEGIN INSPECTION 
                inspect$65$0=new InbyteFile$(((BASICIO$)CTX$),((SCANINP)(CUR$.SL$)).L2NAME).STM$();
                if(inspect$65$0!=null) //INSPECT inspect$65$0
                // JavaLine 97 ==> SourceLine 67
                {
                    TRACE_BEGIN_STM$("CompoundStatement67",67);
                    inspect$65$0.setaccess(new TXT$("%NOBUFFER"));
                    // JavaLine 101 ==> SourceLine 68
                    if(VALUE$((!(inspect$65$0.open())))) {
                        // JavaLine 103 ==> SourceLine 69
                        {
                            TRACE_BEGIN_STM$("CompoundStatement69",69);
                            ((SCANINP)(CUR$.SL$)).L2NAME=CONC(new TXT$("PASS 2 Input: "),((SCANINP)(CUR$.SL$)).L2NAME);
                            new ERRMSG$openerror(((SCANINP)(CUR$.SL$)),((SCANINP)(CUR$.SL$)).L2NAME);
                            TRACE_END_STM$("CompoundStatement69",69);
                        }
                    }
                    // JavaLine 111 ==> SourceLine 70
                    ((SCANINP)(CUR$.SL$)).L2INPT=((InbyteFile$)inspect$65$0);
                    inspect$65$0.intext(((SCANINP)(CUR$.SL$)).L2codebuffer);
                    TRACE_END_STM$("CompoundStatement67",70);
                }
            }
        }
        // JavaLine 118 ==> SourceLine 72
        ((SCANINP)(CUR$.SL$)).L2OUPT=null;
        // JavaLine 120 ==> SourceLine 73
        ((SCANINP)(CUR$.SL$)).currentpass='2';
        ((SCANINP)(CUR$.SL$)).linenr=0;
        // JavaLine 123 ==> SourceLine 74
        if(VALUE$(TRF_EQ(((SCANINP)(CUR$.SL$)).nscodename,null))) {
            // JavaLine 125 ==> SourceLine 75
            new ERRMSG$openerror(((SCANINP)(CUR$.SL$)),new TXT$(" *** SCRATCH FILE (S-code) ***"));
        }
        // JavaLine 128 ==> SourceLine 76
        ((SCANINP)(CUR$.SL$)).unknowns=new COMMON$brecord(((SCANINP)(CUR$.SL$))).STM$();
        // JavaLine 130 ==> SourceLine 77
        ((SCANINP)(CUR$.SL$)).unknowns.kind=((SCANINP)(CUR$.SL$)).K_subbl;
        // JavaLine 132 ==> SourceLine 78
        ((SCANINP)(CUR$.SL$)).setprefgoing=new COMMON$quantity(((SCANINP)(CUR$.SL$))).STM$();
        ((SCANINP)(CUR$.SL$)).alloc2called=new COMMON$quantity(((SCANINP)(CUR$.SL$))).STM$();
        // JavaLine 135 ==> SourceLine 79
        ((SCANINP)(CUR$.SL$)).setprefgoing.symb=((SCANINP)(CUR$.SL$)).alloc2called.symb=new COMMON$boxof(((SCANINP)(CUR$.SL$)),((SCANINP)(CUR$.SL$)).NUL,((SCANINP)(CUR$.SL$)).alloc2index).RESULT$;
        // JavaLine 137 ==> SourceLine 81
        ((SCANINP)(CUR$.SL$)).setprefgoing.encl=((SCANINP)(CUR$.SL$)).alloc2called.encl=((SCANINP)(CUR$.SL$)).unknowns;
        // JavaLine 139 ==> SourceLine 83
        ((SCANINP)(CUR$.SL$)).unknowns.declquant=((SCANINP)(CUR$.SL$)).setprefgoing;
        ((SCANINP)(CUR$.SL$)).setprefgoing.descr=((SCANINP)(CUR$.SL$)).unknowns;
        // JavaLine 142 ==> SourceLine 85
        ((SCANINP)(CUR$.SL$)).progheadstring=getTextInfo(13);
        // JavaLine 144 ==> SourceLine 86
        ((SCANINP)(CUR$.SL$)).progheadstring=CONC(CONC(TXT$.sub(((SCANINP)(CUR$.SL$)).timestamp,1,23),((SCANINP)(CUR$.SL$)).sportid),((SCANINP)(CUR$.SL$)).progheadstring);
        TRACE_END_STM$("Pass1",86);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANINP.DEF","Procedure Pass1",1,35,14,38,16,39,20,40,22,65,36,42,38,44,40,45,42,46,44,47,46,48,48,49,53,50,58,51,62,52,70,54,74,57,76,58,78,59,83,60,86,63,91,65,97,67,101,68,103,69,111,70,118,72,120,73,123,74,125,75,128,76,130,77,132,78,135,79,137,81,139,83,142,85,144,86,149,88);
}
