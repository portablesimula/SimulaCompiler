// JavaLine 1 <== SourceLine 82
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$TRC$SubBlock82 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=82, lastLine=93, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int p=0;
    int l=0;
    // Normal Constructor
    public InptFile$TRC$SubBlock82(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 83
        {
            // BEGIN INSPECTION 
            ((InptFile$TRC)(CUR$.SL$)).inspect$83$40=sysout();
            if(((InptFile$TRC)(CUR$.SL$)).inspect$83$40!=null) // INSPECT inspect$83$40
            // JavaLine 24 <== SourceLine 84
            {
                if(VALUE$((((InptFile)(CUR$.SL$.SL$)).input_trace$3>(1)))) {
                    // JavaLine 27 <== SourceLine 85
                    {
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outtext(new TXT$("Line"));
                        ;
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outint(((InptFile$TRC)(CUR$.SL$)).inspect$81$39.curline$1,6);
                        ;
                        // JavaLine 33 <== SourceLine 86
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.setpos(14);
                        ;
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outtext(((InptFile$TRC)(CUR$.SL$)).p$m);
                        ;
                        // JavaLine 38 <== SourceLine 87
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outchar(':');
                        ;
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.setpos(25);
                        ;
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outtext(((InptFile$TRC)(CUR$.SL$)).p$v);
                        ;
                        ((InptFile$TRC)(CUR$.SL$)).inspect$83$40.outimage();
                        ;
                    }
                } else
                // JavaLine 49 <== SourceLine 89
                {
                    p=TXT$.pos(((InptFile)(CUR$.SL$.SL$)).TRCBUFF$3);
                    ;
                    l=TXT$.length(((InptFile$TRC)(CUR$.SL$)).p$v);
                    ;
                    // JavaLine 55 <== SourceLine 90
                    if(VALUE$((Math.addExact(p,l)>(TXT$.length(((InptFile)(CUR$.SL$.SL$)).TRCBUFF$3))))) {
                        {
                            new InptFile$outcode(((InptFile)(CUR$.SL$.SL$)));
                            ;
                            p=1;
                        }
                    }
                    ;
                    // JavaLine 64 <== SourceLine 91
                    ASGTXT$(TXT$.sub(((InptFile)(CUR$.SL$.SL$)).TRCBUFF$3,p,l),((InptFile$TRC)(CUR$.SL$)).p$v);
                    ;
                    // JavaLine 67 <== SourceLine 92
                    TXT$.setpos(((InptFile)(CUR$.SL$.SL$)).TRCBUFF$3,(((Math.addExact(Math.addExact(p,l),1)<(14)))?(14):(Math.addExact(Math.addExact(p,l),1))));
                    ;
                }
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","SubBlock SubBlock82",1,82,19,83,24,84,27,85,33,86,38,87,49,89,55,90,64,91,67,92,75,93);
} // End of SubBlock
