// JavaLine 1 <== SourceLine 768
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$invariable$rutcall extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=768, lastLine=816, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$spec;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 769
    int c=0;
    int i=0;
    int j=0;
    int apar=0;
    int fpar=0;
    Common$quant par=null;
    // JavaLine 18 <== SourceLine 770
    int b=0;
    // JavaLine 20 <== SourceLine 771
    Common$parspec inspect$771$186=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$invariable$rutcall setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$invariable$rutcall.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$spec=(Common$parspec)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$invariable$rutcall(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$invariable$rutcall(RTObject$ SL$,Common$parspec sp$spec) {
        super(SL$);
        // Parameter assignment to locals
        this.p$spec = sp$spec;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$invariable$rutcall STM$() {
        {
            // BEGIN INSPECTION 
            inspect$771$186=p$spec;
            if(inspect$771$186!=null) // INSPECT inspect$771$186
            // JavaLine 53 <== SourceLine 772
            {
                if(VALUE$((inspect$771$186.import$!=(null)))) {
                    // JavaLine 56 <== SourceLine 773
                    {
                        fpar=inspect$771$186.import$.cardinal();
                        ;
                        par=((Common$quant)(inspect$771$186.import$.first()));
                    }
                } else
                // JavaLine 63 <== SourceLine 774
                {
                    fpar=0;
                    ;
                    par=null;
                }
                ;
                // JavaLine 70 <== SourceLine 775
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ARGLIST$1)))) {
                    // JavaLine 72 <== SourceLine 776
                    {
                        apar=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        for(i=1;i<=apar;i++) {
                            // JavaLine 77 <== SourceLine 778
                            if(VALUE$((par==(null)))) {
                                // JavaLine 79 <== SourceLine 779
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$);
                                    ;
                                    // JavaLine 83 <== SourceLine 780
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_POP$1);
                                    ;
                                    // JavaLine 86 <== SourceLine 781
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 93 <== SourceLine 784
                            {
                                b=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                                ;
                                // JavaLine 97 <== SourceLine 785
                                if(VALUE$((b==(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_REPEXPR$1)))) {
                                    // JavaLine 99 <== SourceLine 786
                                    {
                                        c=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                                        ;
                                        b=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                                        ;
                                    }
                                } else
                                // JavaLine 107 <== SourceLine 787
                                c=1;
                                ;
                                // JavaLine 110 <== SourceLine 788
                                ((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),b).RESULT$;
                                ;
                                // JavaLine 113 <== SourceLine 789
                                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ!=(par.p3$type)))) {
                                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ,par.p3$type);
                                }
                                ;
                                for(j=2;j<=c;j++) {
                                    // JavaLine 119 <== SourceLine 791
                                    {
                                        ((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                                        ;
                                        // JavaLine 123 <== SourceLine 792
                                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ!=(par.p3$type)))) {
                                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).typ,par.p3$type);
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 131 <== SourceLine 794
                                if(VALUE$((c>(par.count$3)))) {
                                    // JavaLine 133 <== SourceLine 795
                                    {
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Too many elts in repeated parameter"));
                                        ;
                                        // JavaLine 137 <== SourceLine 796
                                        while((c>(par.count$3))) {
                                            // JavaLine 139 <== SourceLine 797
                                            {
                                                c=Math.subtractExact(c,1);
                                                ;
                                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_POP$1);
                                                ;
                                                // JavaLine 145 <== SourceLine 798
                                                if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
                                                }
                                                ;
                                            }
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 156 <== SourceLine 801
                                if(VALUE$((c==(1)))) {
                                    // JavaLine 158 <== SourceLine 802
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ASSPAR$1);
                                } else
                                // JavaLine 161 <== SourceLine 803
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ASSREP$1);
                                    ;
                                    new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,c);
                                }
                                ;
                                // JavaLine 168 <== SourceLine 804
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 173 <== SourceLine 805
                                par=((Common$quant)(par.suc()));
                                ;
                            }
                        }
                        ;
                        // JavaLine 179 <== SourceLine 807
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                    }
                } else
                // JavaLine 184 <== SourceLine 809
                apar=0;
                ;
                // JavaLine 187 <== SourceLine 810
                if(VALUE$((apar!=(fpar)))) {
                    // JavaLine 189 <== SourceLine 811
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Wrong number of actual parameters"));
                }
                ;
                // JavaLine 193 <== SourceLine 812
                if(VALUE$(((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.rutlev$1>(0))&((inspect$771$186.exit!=(null)))))) {
                    // JavaLine 195 <== SourceLine 813
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Illegal call on routine with spec. exit-label"));
                }
                ;
                // JavaLine 199 <== SourceLine 814
                ((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$.SL$)).vartype=(((inspect$771$186.export==(null)))?(0):(inspect$771$186.export.p3$type));
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure rutcall",1,768,11,769,18,770,20,771,53,772,56,773,63,774,70,775,72,776,77,778,79,779,83,780,86,781,93,784,97,785,99,786,107,787,110,788,113,789,119,791,123,792,131,794,133,795,137,796,139,797,145,798,156,801,158,802,161,803,168,804,173,805,179,807,184,809,187,810,189,811,193,812,195,813,199,814,206,816);
} // End of Procedure
