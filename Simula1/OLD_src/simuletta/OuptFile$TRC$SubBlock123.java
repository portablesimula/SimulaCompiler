// JavaLine 1 <== SourceLine 123
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$TRC$SubBlock123 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=123, lastLine=137, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int p=0;
    int l=0;
    // Normal Constructor
    public OuptFile$TRC$SubBlock123(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 124
        {
            // BEGIN INSPECTION 
            ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31=sysout();
            if(((OuptFile$TRC)(CUR$.SL$)).inspect$124$31!=null) // INSPECT inspect$124$31
            // JavaLine 24 <== SourceLine 125
            {
                if(VALUE$((((OuptFile)(CUR$.SL$.SL$)).output_trace$3>(1)))) {
                    // JavaLine 27 <== SourceLine 126
                    {
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outtext(new TXT$("Line"));
                        ;
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outint(((OuptFile$TRC)(CUR$.SL$)).inspect$122$30.curline$1,6);
                        ;
                        // JavaLine 33 <== SourceLine 127
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.setpos(54);
                        ;
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outtext(((OuptFile$TRC)(CUR$.SL$)).p$m);
                        ;
                        // JavaLine 38 <== SourceLine 128
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outchar(':');
                        ;
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.setpos(65);
                        ;
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outtext(((OuptFile$TRC)(CUR$.SL$)).p$v);
                        ;
                        ((OuptFile$TRC)(CUR$.SL$)).inspect$124$31.outimage();
                        ;
                    }
                } else
                // JavaLine 49 <== SourceLine 131
                {
                    p=TXT$.pos(((OuptFile)(CUR$.SL$.SL$)).TRCBUFF$3);
                    ;
                    l=TXT$.length(((OuptFile$TRC)(CUR$.SL$)).p$v);
                    ;
                    // JavaLine 55 <== SourceLine 132
                    if(VALUE$((Math.addExact(p,l)>(TXT$.length(((OuptFile)(CUR$.SL$.SL$)).TRCBUFF$3))))) {
                        {
                            new OuptFile$outcode(((OuptFile)(CUR$.SL$.SL$)));
                            ;
                            p=1;
                        }
                    }
                    ;
                    // JavaLine 64 <== SourceLine 133
                    ASGTXT$(TXT$.sub(((OuptFile)(CUR$.SL$.SL$)).TRCBUFF$3,p,l),((OuptFile$TRC)(CUR$.SL$)).p$v);
                    ;
                    // JavaLine 67 <== SourceLine 134
                    TXT$.setpos(((OuptFile)(CUR$.SL$.SL$)).TRCBUFF$3,(((Math.addExact(Math.addExact(p,l),1)<(14)))?(14):(Math.addExact(Math.addExact(p,l),1))));
                    ;
                }
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","SubBlock SubBlock123",1,123,19,124,24,125,27,126,33,127,38,128,49,131,55,132,64,133,67,134,77,137);
} // End of SubBlock
