// JavaLine 1 <== SourceLine 100
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$instringval extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=100, lastLine=155, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public char p$quote;
    // Declare local labels
    // JavaLine 11 <== SourceLine 140
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // JavaLine 13 <== SourceLine 151
    final LABQNT$ EXIT=new LABQNT$(this,2,"EXIT"); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 101
    char ch=0;
    // JavaLine 18 <== SourceLine 102
    int i=0;
    int j=0;
    // JavaLine 21 <== SourceLine 103
    int storepos=0;
    int storelength=0;
    // JavaLine 24 <== SourceLine 104
    TXT$ result=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$getsymb$instringval setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$getsymb$instringval.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$quote=(char)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$getsymb$instringval(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$instringval(RTObject$ SL$,char sp$quote) {
        super(SL$);
        // Parameter assignment to locals
        this.p$quote = sp$quote;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$instringval STM$() {
        Pass1$SubBlock32$getsymb$instringval THIS$=(Pass1$SubBlock32$getsymb$instringval)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 57 <== SourceLine 132
                while(true) {
                    // JavaLine 59 <== SourceLine 133
                    {
                        ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                        ;
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                        ;
                        // JavaLine 65 <== SourceLine 134
                        if(VALUE$((ch==('!')))) {
                            // JavaLine 67 <== SourceLine 135
                            new Pass1$SubBlock32$getsymb$instringval$ISOcode(((Pass1$SubBlock32$getsymb$instringval)(CUR$)));
                        } else
                        if(VALUE$((ch==(((char)30))))) {
                            // JavaLine 71 <== SourceLine 136
                            {
                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Missing quote at end-of-line"));
                                ;
                                // JavaLine 75 <== SourceLine 137
                                new Pass1$SubBlock32$getsymb$inline(((Pass1$SubBlock32$getsymb)(CUR$.SL$)));
                                ;
                                GOTO$(L); // GOTO EVALUATED LABEL
                                ;
                            }
                        } else
                        // JavaLine 82 <== SourceLine 139
                        if(VALUE$((ch==(p$quote)))) {
                            // JavaLine 84 <== SourceLine 140
                            {
                                LABEL$(1,"L");
                                ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                                ;
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                ;
                                // JavaLine 91 <== SourceLine 141
                                if(VALUE$((ch==(((char)32))))) {
                                    GOTO$(L); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 96 <== SourceLine 142
                                if(VALUE$((ch==(((char)30))))) {
                                    // JavaLine 98 <== SourceLine 143
                                    {
                                        new Pass1$SubBlock32$getsymb$inline(((Pass1$SubBlock32$getsymb)(CUR$.SL$)));
                                        ;
                                        GOTO$(L); // GOTO EVALUATED LABEL
                                    }
                                }
                                ;
                                // JavaLine 106 <== SourceLine 144
                                if(VALUE$((ch!=(p$quote)))) {
                                    // JavaLine 108 <== SourceLine 145
                                    {
                                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                        ;
                                        // JavaLine 112 <== SourceLine 146
                                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                                    }
                                }
                                ;
                            }
                        } else
                        // JavaLine 119 <== SourceLine 148
                        new Pass1$SubBlock32$getsymb$instringval$putchar(((Pass1$SubBlock32$getsymb$instringval)(CUR$)));
                        ;
                    }
                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                }
                ;
                // JavaLine 126 <== SourceLine 152
                LABEL$(2,"EXIT");
                // JavaLine 128 <== SourceLine 151
                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval=((TRF_EQ(result,null))?(null):(TXT$.sub(result,1,storepos)));
                ;
                // JavaLine 131 <== SourceLine 153
                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB"),153,CONC(CONC(new TXT$("instringval=\""),((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval),new TXT$("\"")));
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("instringval:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("instringval:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("instringval:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure instringval",1,100,11,140,13,151,16,101,18,102,21,103,24,104,57,132,59,133,65,134,67,135,71,136,75,137,82,139,84,140,91,141,96,142,98,143,106,144,108,145,112,146,119,148,126,152,128,151,131,153,150,155);
} // End of Procedure
