// JavaLine 1 ==> SourceLine 1163
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$open_utbase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1163, lastLine=1179, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1165
    TXT$ filnavn=null;
    // JavaLine 16 ==> SourceLine 1166
    boolean oppe=false;
    // Normal Constructor
    public HegnaNRK$PBLK21$open_utbase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("open_utbase",1166);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$open_utbase STM$() {
        TRACE_BEGIN_STM$("open_utbase",1166);
        // JavaLine 30 ==> SourceLine 1167
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image_lengde);
        // JavaLine 32 ==> SourceLine 1168
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image,1,5),((HegnaNRK$PBLK21)(CUR$.SL$)).default_file_type);
        // JavaLine 34 ==> SourceLine 1169
        oppe=false;
        // JavaLine 36 ==> SourceLine 1170
        while((!(oppe))) {
            // JavaLine 38 ==> SourceLine 1172
            {
                TRACE_BEGIN_STM$("CompoundStatement1172",1172);
                filnavn=new HegnaNRK$PBLK21$les_filnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 42 ==> SourceLine 1173
                ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase=new OutFile$(((BASICIO$)CTX$),filnavn).STM$();
                // JavaLine 44 ==> SourceLine 1174
                oppe=((HegnaNRK$PBLK21)(CUR$.SL$)).utbase.open(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image);
                // JavaLine 46 ==> SourceLine 1175
                if(VALUE$((!(oppe)))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),11);
                }
                TRACE_END_STM$("CompoundStatement1172",1175);
            }
        }
        // JavaLine 53 ==> SourceLine 1177
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image,1,5),blanks(5));
        // JavaLine 55 ==> SourceLine 1178
        RESULT$=filnavn;
        TRACE_END_STM$("open_utbase",1178);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_utbase",1,1163,14,1165,16,1166,30,1167,32,1168,34,1169,36,1170,38,1172,42,1173,44,1174,46,1175,53,1177,55,1178,60,1179);
}
