// JavaLine 1 <== SourceLine 68
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$close extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=68, lastLine=88, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 86
    final LABQNT$ FOUND=new LABQNT$(this,1,"FOUND"); // Local Label #1=FOUND
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 69
    Common$symbolbox cbox=null;
    Common$descr q=null;
    // Normal Constructor
    public Pass1$SubBlock32$close(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$close STM$() {
        Pass1$SubBlock32$close THIS$=(Pass1$SubBlock32$close)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 <== SourceLine 71
                while((((Pass1$SubBlock32)(CUR$.SL$)).cursource!=(null))) {
                    new Pass1$SubBlock32$sourceElt$close(((Pass1$SubBlock32)(CUR$.SL$)).cursource);
                }
                ;
                // JavaLine 35 <== SourceLine 72
                ((Pass1$SubBlock32)(CUR$.SL$)).taglast=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.taglist$1=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.taglist$1.next;
                ;
                // JavaLine 38 <== SourceLine 73
                while((((Pass1$SubBlock32)(CUR$.SL$)).taglast!=(null))) {
                    {
                        cbox=((Pass1$SubBlock32)(CUR$.SL$)).taglast.p$box;
                        ;
                        // JavaLine 43 <== SourceLine 74
                        q=((Common$descr)(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.qntset$1.first()));
                        ;
                        // JavaLine 46 <== SourceLine 75
                        while((q!=(null))) {
                            // JavaLine 48 <== SourceLine 76
                            {
                                if(VALUE$((q.symb$2==(cbox)))) {
                                    // JavaLine 51 <== SourceLine 77
                                    {
                                        new Common$newtag(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,q.symb$2);
                                        ;
                                        // JavaLine 55 <== SourceLine 78
                                        q.xtag$2=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ntag$1;
                                        ;
                                        // JavaLine 58 <== SourceLine 79
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).tracemode!=(0)))) {
                                            // JavaLine 60 <== SourceLine 80
                                            {
                                                sysout().outtext(new TXT$("%tag: "));
                                                ;
                                                new Common$prt(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,q,10);
                                            }
                                        }
                                        ;
                                        // JavaLine 68 <== SourceLine 81
                                        ((Pass1$SubBlock32)(CUR$.SL$)).taglast.d=q;
                                        ;
                                        GOTO$(FOUND); // GOTO EVALUATED LABEL
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 76 <== SourceLine 83
                                q=((Common$descr)(q.suc()));
                                ;
                            }
                        }
                        ;
                        // JavaLine 82 <== SourceLine 85
                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,CONC(new TXT$("%tag - identifier not found: "),cbox.symbol));
                        ;
                        // JavaLine 85 <== SourceLine 86
                        LABEL$(1,"FOUND");
                        ((Pass1$SubBlock32)(CUR$.SL$)).taglast=((Pass1$SubBlock32)(CUR$.SL$)).taglast.next;
                        ;
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("close:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("close:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("close:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure close",1,68,10,86,13,69,30,71,35,72,38,73,43,74,46,75,48,76,51,77,55,78,58,79,60,80,68,81,76,83,82,85,85,86,108,88);
} // End of Procedure
