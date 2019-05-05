// JavaLine 1 <== SourceLine 185
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$skriv extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=185, lastLine=212, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 186
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    int m=0;
    char c=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$skriv(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skriv",186);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$skriv STM$() {
        TRACE_BEGIN_STM$("skriv",186);
        // JavaLine 30 <== SourceLine 187
        m=TXT$.pos(sysout().image);
        // JavaLine 32 <== SourceLine 188
        j=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
        // JavaLine 34 <== SourceLine 189
        i=0;
        // JavaLine 36 <== SourceLine 190
        while((i<(j))) {
            // JavaLine 38 <== SourceLine 192
            {
                TRACE_BEGIN_STM$("CompoundStatement192",192);
                i=(i+(1));
                // JavaLine 42 <== SourceLine 193
                k=i;
                // JavaLine 44 <== SourceLine 194
                TXT$.setpos(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1,k);
                // JavaLine 46 <== SourceLine 195
                c=TXT$.getchar(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
                // JavaLine 48 <== SourceLine 196
                while(((c!=(((char)32)))&((k<(j))))) {
                    // JavaLine 50 <== SourceLine 198
                    {
                        TRACE_BEGIN_STM$("CompoundStatement198",198);
                        k=(k+(1));
                        // JavaLine 54 <== SourceLine 199
                        c=TXT$.getchar(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
                        TRACE_END_STM$("CompoundStatement198",199);
                    }
                }
                // JavaLine 59 <== SourceLine 201
                l=(k-(i));
                // JavaLine 61 <== SourceLine 202
                if(VALUE$((k==(j)))) {
                    l=(l+(1));
                }
                // JavaLine 65 <== SourceLine 203
                if(VALUE$(((TXT$.pos(sysout().image)+(l))>(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).skjerm_image_lengde$1)))) {
                    // JavaLine 67 <== SourceLine 205
                    {
                        TRACE_BEGIN_STM$("CompoundStatement205",205);
                        sysout().outimage();
                        // JavaLine 71 <== SourceLine 206
                        TXT$.setpos(sysout().image,m);
                        TRACE_END_STM$("CompoundStatement205",206);
                    }
                }
                // JavaLine 76 <== SourceLine 208
                sysout().outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1,i,l));
                // JavaLine 78 <== SourceLine 209
                if(VALUE$((k<(j)))) {
                    sysout().outchar(((char)32));
                }
                // JavaLine 82 <== SourceLine 210
                i=k;
                TRACE_END_STM$("CompoundStatement192",210);
            }
        }
        TRACE_END_STM$("skriv",210);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv",1,185,11,186,30,187,32,188,34,189,36,190,38,192,42,193,44,194,46,195,48,196,50,198,54,199,59,201,61,202,65,203,67,205,71,206,76,208,78,209,82,210,90,212);
} // End of Procedure
