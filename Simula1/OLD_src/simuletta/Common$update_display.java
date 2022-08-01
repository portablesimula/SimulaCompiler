// JavaLine 1 <== SourceLine 746
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$update_display extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=746, lastLine=771, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Head$ p$s;
    // Declare local labels
    // JavaLine 11 <== SourceLine 768
    final LABQNT$ XXX=new LABQNT$(this,1,"XXX"); // Local Label #1=XXX
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 747
    Common$descr d=null;
    Linkage$ old=null;
    // JavaLine 17 <== SourceLine 750
    Head$ inspect$750$10=null;
    // JavaLine 19 <== SourceLine 752
    Common$descr inspect$752$11=null;
    // JavaLine 21 <== SourceLine 754
    Common$symbolbox inspect$754$12=null;
    // JavaLine 23 <== SourceLine 760
    Linkage$ inspect$760$13=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$update_display setPar(Object param) {
        //Util.BREAK("CALL Common$update_display.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$s=(Head$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$update_display(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$update_display(RTObject$ SL$,Head$ sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$update_display STM$() {
        Common$update_display THIS$=(Common$update_display)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 56 <== SourceLine 748
                if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
                    // JavaLine 58 <== SourceLine 749
                    {
                        sysout().outtext(new TXT$(" >>>>>>> Update display start"));
                        ;
                        sysout().outimage();
                    }
                }
                ;
                // JavaLine 66 <== SourceLine 750
                {
                    // BEGIN INSPECTION 
                    inspect$750$10=p$s;
                    if(inspect$750$10!=null) // INSPECT inspect$750$10
                    // JavaLine 71 <== SourceLine 751
                    {
                        d=((Common$descr)(inspect$750$10.first()));
                        ;
                        // JavaLine 75 <== SourceLine 752
                        while(true) {
                            {
                                // BEGIN INSPECTION 
                                inspect$752$11=d;
                                if(inspect$752$11!=null) // INSPECT inspect$752$11
                                // JavaLine 81 <== SourceLine 753
                                {
                                    if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
                                        new Common$prt(((Common)(CUR$.SL$)),((Common$descr)inspect$752$11),20);
                                    }
                                    ;
                                    // JavaLine 87 <== SourceLine 754
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$754$12=inspect$752$11.symb$2;
                                        if(inspect$754$12!=null) // INSPECT inspect$754$12
                                        // JavaLine 92 <== SourceLine 755
                                        {
                                            old=inspect$754$12.curmeaning;
                                            ;
                                            inspect$754$12.curmeaning=((Common$descr)inspect$752$11);
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 101 <== SourceLine 757
                                    if(VALUE$((!(inspect$752$11.global$2)))) {
                                        // JavaLine 103 <== SourceLine 758
                                        new Common$displnotice(((Common)(CUR$.SL$)),((Common$descr)inspect$752$11),((Common$descr)(old))).STM$().into(((Common)(CUR$.SL$)).redeclset$1);
                                    }
                                    ;
                                    // JavaLine 107 <== SourceLine 760
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$760$13=old;
                                        //INSPECT inspect$760$13
                                        if(inspect$760$13 instanceof Common$descr) // WHEN Common$descr DO 
                                        // JavaLine 113 <== SourceLine 761
                                        if(VALUE$((((Common$descr)(inspect$760$13)).global$2&&(d.global$2)))) {
                                            // JavaLine 115 <== SourceLine 763
                                            new Common$ERROR(((Common)(CUR$.SL$)),CONC(new TXT$("Illegal re-declaration of "),((Common$descr)(inspect$760$13)).symb$2.symbol));
                                        }
                                        else if(inspect$760$13 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
                                        // JavaLine 119 <== SourceLine 765
                                        new Common$ERROR(((Common)(CUR$.SL$)),CONC(new TXT$("Mnemonic re-declaration: "),inspect$752$11.symb$2.symbol));
                                    }
                                    ;
                                    // JavaLine 123 <== SourceLine 766
                                    d=((Common$descr)(inspect$752$11.suc()));
                                    ;
                                }
                                else // OTHERWISE 
                                // JavaLine 128 <== SourceLine 767
                                GOTO$(XXX); // GOTO EVALUATED LABEL
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                        // JavaLine 134 <== SourceLine 768
                        LABEL$(1,"XXX");
                        ;
                    }
                }
                ;
                // JavaLine 140 <== SourceLine 769
                if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
                    // JavaLine 142 <== SourceLine 770
                    {
                        sysout().outtext(new TXT$(" <<<<<<> Update display end"));
                        ;
                        sysout().outimage();
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("update_display:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("update_display:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("update_display:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure update_display",1,746,11,768,14,747,17,750,19,752,21,754,23,760,56,748,58,749,66,750,71,751,75,752,81,753,87,754,92,755,101,757,103,758,107,760,113,761,115,763,119,765,123,766,128,767,134,768,140,769,142,770,166,771);
} // End of Procedure
