// JavaLine 1 <== SourceLine 633
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$rec_atr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=633, lastLine=673, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$quant RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$record p$r;
    public int p$i;
    // Declare local labels
    // JavaLine 15 <== SourceLine 637
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // JavaLine 17 <== SourceLine 668
    final LABQNT$ SCANX=new LABQNT$(this,2,"SCANX"); // Local Label #2=SCANX
    // JavaLine 19 <== SourceLine 673
    final LABQNT$ EXT=new LABQNT$(this,3,"EXT"); // Local Label #3=EXT
    // Declare locals as attributes
    // JavaLine 22 <== SourceLine 635
    Common$quant q=null;
    Common$quant a=null;
    Common$record rr=null;
    Common$variant v=null;
    // JavaLine 27 <== SourceLine 637
    Common$record inspect$637$4=null;
    // JavaLine 29 <== SourceLine 646
    Common$variant inspect$646$5=null;
    // JavaLine 31 <== SourceLine 660
    Common$record inspect$660$6=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$rec_atr setPar(Object param) {
        //Util.BREAK("CALL Common$rec_atr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$r=(Common$record)objectValue(param); break;
                case 1: p$i=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$rec_atr(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$rec_atr(RTObject$ SL$,Common$record sp$r,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$r = sp$r;
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$rec_atr STM$() {
        Common$rec_atr THIS$=(Common$rec_atr)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 66 <== SourceLine 636
                rr=p$r;
                ;
                // JavaLine 69 <== SourceLine 668
                LABEL$(1,"L");
                // JavaLine 71 <== SourceLine 637
                {
                    // BEGIN INSPECTION 
                    inspect$637$4=p$r;
                    if(inspect$637$4!=null) // INSPECT inspect$637$4
                    // JavaLine 76 <== SourceLine 638
                    {
                        a=((Common$quant)(inspect$637$4.atrset$3.first()));
                        ;
                        // JavaLine 80 <== SourceLine 639
                        while((a!=(null))) {
                            // JavaLine 82 <== SourceLine 640
                            {
                                if(VALUE$((a.symb$2.id==(p$i)))) {
                                    // JavaLine 85 <== SourceLine 642
                                    {
                                        RESULT$=a;
                                        ;
                                        GOTO$(EXT); // GOTO EVALUATED LABEL
                                    }
                                }
                                ;
                                // JavaLine 93 <== SourceLine 643
                                a=((Common$quant)(a.suc()));
                                ;
                            }
                        }
                        ;
                        // JavaLine 99 <== SourceLine 645
                        v=((Common$variant)(inspect$637$4.variantset$3.first()));
                        ;
                        // JavaLine 102 <== SourceLine 646
                        while(true) {
                            {
                                // BEGIN INSPECTION 
                                inspect$646$5=v;
                                if(inspect$646$5!=null) // INSPECT inspect$646$5
                                {
                                    v=((Common$variant)(inspect$646$5.suc()));
                                    ;
                                    // JavaLine 111 <== SourceLine 647
                                    a=((Common$quant)(inspect$646$5.atrset$2.first()));
                                    ;
                                    // JavaLine 114 <== SourceLine 648
                                    while((a!=(null))) {
                                        // JavaLine 116 <== SourceLine 649
                                        {
                                            if(VALUE$((a.symb$2.id==(p$i)))) {
                                                // JavaLine 119 <== SourceLine 651
                                                {
                                                    RESULT$=a;
                                                    ;
                                                    GOTO$(EXT); // GOTO EVALUATED LABEL
                                                }
                                            }
                                            ;
                                            // JavaLine 127 <== SourceLine 652
                                            a=((Common$quant)(a.suc()));
                                            ;
                                        }
                                    }
                                    ;
                                }
                                else // OTHERWISE 
                                // JavaLine 135 <== SourceLine 656
                                {
                                    if(VALUE$((inspect$637$4.prefbox$3!=(null)))) {
                                        // JavaLine 138 <== SourceLine 657
                                        {
                                            if(VALUE$(IS$(inspect$637$4.prefbox$3.curmeaning,Common$record.class))) {
                                                p$r=((Common$record)(inspect$637$4.prefbox$3.curmeaning));
                                            } else
                                            // JavaLine 143 <== SourceLine 659
                                            {
                                                new Common$ERROR(((Common)(CUR$.SL$)),CONC(new TXT$("Unknown prefix: "),inspect$637$4.prefbox$3.symbol));
                                                ;
                                                // JavaLine 147 <== SourceLine 660
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$660$6=new Common$record(((Common)(CUR$.SL$))).STM$();
                                                    if(inspect$660$6!=null) // INSPECT inspect$660$6
                                                    // JavaLine 152 <== SourceLine 661
                                                    {
                                                        inspect$660$6.atrset$3=new Head$(((Common)(CUR$.SL$))).STM$();
                                                        ;
                                                        inspect$660$6.variantset$3=new Head$(((Common)(CUR$.SL$))).STM$();
                                                        ;
                                                        // JavaLine 158 <== SourceLine 662
                                                        inspect$660$6.symb$2=inspect$660$6.prefbox$3;
                                                        ;
                                                        p$r=((Common$record)inspect$660$6);
                                                        ;
                                                    }
                                                }
                                                ;
                                            }
                                            ;
                                            // JavaLine 168 <== SourceLine 665
                                            GOTO$(L); // GOTO EVALUATED LABEL
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 174 <== SourceLine 666
                                    GOTO$(SCANX); // GOTO EVALUATED LABEL
                                    ;
                                }
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                        // JavaLine 182 <== SourceLine 668
                        LABEL$(2,"SCANX");
                        ;
                    }
                }
                ;
                // JavaLine 188 <== SourceLine 670
                RESULT$=q=new Common$quant(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).T_UNDEF$1).STM$();
                ;
                // JavaLine 191 <== SourceLine 671
                q.symb$2=((Common)(CUR$.SL$)).symtab.Elt[p$i-((Common)(CUR$.SL$)).symtab.LB[0]];
                ;
                // JavaLine 194 <== SourceLine 672
                new Common$ERROR(((Common)(CUR$.SL$)),CONC(CONC(q.symb$2.symbol,new TXT$(" is not an attribute of ")),rr.symb$2.symbol));
                ;
                // JavaLine 197 <== SourceLine 673
                LABEL$(3,"EXT");
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("rec_atr:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("rec_atr:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("rec_atr:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure rec_atr",1,633,15,637,17,668,19,673,22,635,27,637,29,646,31,660,66,636,69,668,71,637,76,638,80,639,82,640,85,642,93,643,99,645,102,646,111,647,114,648,116,649,119,651,127,652,135,656,138,657,143,659,147,660,152,661,158,662,168,665,174,666,182,668,188,670,191,671,194,672,197,673,216,673);
} // End of Procedure
