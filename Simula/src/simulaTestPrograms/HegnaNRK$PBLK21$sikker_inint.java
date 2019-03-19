// JavaLine 1 ==> SourceLine 1004
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sikker_inint extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1004, lastLine=1035, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1006
    TXT$ temp=null;
    char c=0;
    boolean ok=false;
    boolean tegn=false;
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$sikker_inint(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sikker_inint",1006);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$sikker_inint STM$() {
        TRACE_BEGIN_STM$("sikker_inint",1006);
        // JavaLine 32 ==> SourceLine 1007
        ok=false;
        // JavaLine 34 ==> SourceLine 1008
        while((!(ok))) {
            // JavaLine 36 ==> SourceLine 1010
            {
                TRACE_BEGIN_STM$("CompoundStatement1010",1010);
                temp=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde);
                // JavaLine 40 ==> SourceLine 1011
                i=0;
                // JavaLine 42 ==> SourceLine 1012
                c=sysin().inchar();
                // JavaLine 44 ==> SourceLine 1013
                while((c==(((char)32)))) {
                    c=sysin().inchar();
                }
                // JavaLine 48 ==> SourceLine 1014
                tegn=true;
                // JavaLine 50 ==> SourceLine 1015
                while(((c==('+'))|((c==('-'))))) {
                    // JavaLine 52 ==> SourceLine 1017
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1017",1017);
                        if(VALUE$((c==('-')))) {
                            tegn=(!(tegn));
                        }
                        // JavaLine 58 ==> SourceLine 1018
                        c=sysin().inchar();
                        TRACE_END_STM$("CompoundStatement1017",1018);
                    }
                }
                // JavaLine 63 ==> SourceLine 1020
                if(VALUE$((!(tegn)))) {
                    // JavaLine 65 ==> SourceLine 1022
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1022",1022);
                        TXT$.putchar(temp,'-');
                        // JavaLine 69 ==> SourceLine 1023
                        i=(i+(1));
                        TRACE_END_STM$("CompoundStatement1022",1023);
                    }
                }
                // JavaLine 74 ==> SourceLine 1025
                while(new HegnaNRK$PBLK21$number(((HegnaNRK$PBLK21)(CUR$.SL$)),c).RESULT$) {
                    // JavaLine 76 ==> SourceLine 1027
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1027",1027);
                        if(VALUE$((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde)))) {
                            TXT$.putchar(temp,c);
                        }
                        // JavaLine 82 ==> SourceLine 1028
                        i=(i+(1));
                        // JavaLine 84 ==> SourceLine 1029
                        c=sysin().inchar();
                        TRACE_END_STM$("CompoundStatement1027",1029);
                    }
                }
                // JavaLine 89 ==> SourceLine 1031
                ok=((c==(((char)32)))&((((i<(6))&(tegn))|(((i<(7))&((!(tegn))))))));
                // JavaLine 91 ==> SourceLine 1032
                if(VALUE$((!(ok)))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),20);
                }
                TRACE_END_STM$("CompoundStatement1010",1032);
            }
        }
        // JavaLine 98 ==> SourceLine 1034
        RESULT$=TXT$.getint(temp);
        TRACE_END_STM$("sikker_inint",1034);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sikker_inint",1,1004,14,1006,32,1007,34,1008,36,1010,40,1011,42,1012,44,1013,48,1014,50,1015,52,1017,58,1018,63,1020,65,1022,69,1023,74,1025,76,1027,82,1028,84,1029,89,1031,91,1032,98,1034,103,1035);
}
