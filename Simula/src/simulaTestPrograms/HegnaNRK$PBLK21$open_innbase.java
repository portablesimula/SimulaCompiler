// JavaLine 1 ==> SourceLine 1145
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$open_innbase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1145, lastLine=1161, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1147
    TXT$ filnavn=null;
    // JavaLine 16 ==> SourceLine 1148
    boolean oppe=false;
    // Normal Constructor
    public HegnaNRK$PBLK21$open_innbase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("open_innbase",1148);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$open_innbase STM$() {
        TRACE_BEGIN_STM$("open_innbase",1148);
        // JavaLine 30 ==> SourceLine 1149
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image_lengde);
        // JavaLine 32 ==> SourceLine 1150
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image,1,5),((HegnaNRK$PBLK21)(CUR$.SL$)).default_file_type);
        // JavaLine 34 ==> SourceLine 1151
        oppe=false;
        // JavaLine 36 ==> SourceLine 1152
        while((!(oppe))) {
            // JavaLine 38 ==> SourceLine 1154
            {
                TRACE_BEGIN_STM$("CompoundStatement1154",1154);
                filnavn=new HegnaNRK$PBLK21$les_filnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 42 ==> SourceLine 1155
                ((HegnaNRK$PBLK21)(CUR$.SL$)).innbase=new InFile$(((BASICIO$)CTX$),filnavn).STM$();
                // JavaLine 44 ==> SourceLine 1156
                oppe=((HegnaNRK$PBLK21)(CUR$.SL$)).innbase.open(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image);
                // JavaLine 46 ==> SourceLine 1157
                if((!(oppe))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),11);
                }
                TRACE_END_STM$("CompoundStatement1154",1157);
            }
        }
        // JavaLine 53 ==> SourceLine 1159
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image,1,5),blanks(5));
        // JavaLine 55 ==> SourceLine 1160
        RESULT$=filnavn;
        TRACE_END_STM$("open_innbase",1160);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_innbase",1,1145,14,1147,16,1148,30,1149,32,1150,34,1151,36,1152,38,1154,42,1155,44,1156,46,1157,53,1159,55,1160,60,1161);
}
