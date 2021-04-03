// JavaLine 1 <== SourceLine 771
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations$read_par extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=771, lastLine=799, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$parspec RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 772
    Head$ x=null;
    // JavaLine 15 <== SourceLine 775
    Common$parspec inspect$775$80=null;
    // JavaLine 17 <== SourceLine 783
    Link$ inspect$783$81=null;
    // JavaLine 19 <== SourceLine 791
    Link$ inspect$791$82=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations$read_par(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$declarations$read_par STM$() {
        // JavaLine 31 <== SourceLine 773
        new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),773,new TXT$("read_par"));
        ;
        // JavaLine 34 <== SourceLine 774
        ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.addExact(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
        ;
        // JavaLine 37 <== SourceLine 775
        {
            // BEGIN INSPECTION 
            inspect$775$80=new Common$parspec(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62).STM$();
            if(inspect$775$80!=null) // INSPECT inspect$775$80
            // JavaLine 42 <== SourceLine 776
            {
                RESULT$=((Common$parspec)inspect$775$80);
                ;
                // JavaLine 46 <== SourceLine 777
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 49 <== SourceLine 778
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IMPORT$1)))) {
                    // JavaLine 51 <== SourceLine 779
                    {
                        inspect$775$80.import$=new Head$(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        ;
                        // JavaLine 55 <== SourceLine 780
                        new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),inspect$775$80.import$,true,((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inLocals);
                    }
                }
                ;
                // JavaLine 60 <== SourceLine 781
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_EXPORT$1)))) {
                    // JavaLine 62 <== SourceLine 782
                    {
                        x=new Head$(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        ;
                        new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),x,true,((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inLocals);
                        ;
                        // JavaLine 68 <== SourceLine 783
                        {
                            // BEGIN INSPECTION 
                            inspect$783$81=x.first();
                            if(inspect$783$81!=null) // INSPECT inspect$783$81
                            // JavaLine 73 <== SourceLine 784
                            {
                                inspect$775$80.export=((Common$quant)(((Link$)inspect$783$81)));
                                ;
                                // JavaLine 77 <== SourceLine 785
                                if(VALUE$((inspect$783$81.suc()!=(null)))) {
                                    // JavaLine 79 <== SourceLine 786
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Too many export variables"));
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 85 <== SourceLine 787
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Missing export variable"));
                        }
                        ;
                    }
                } else
                // JavaLine 91 <== SourceLine 789
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_EXIT$1)))) {
                    // JavaLine 93 <== SourceLine 790
                    {
                        x=new Head$(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        ;
                        new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),x,true,((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inLocals);
                        ;
                        // JavaLine 99 <== SourceLine 791
                        {
                            // BEGIN INSPECTION 
                            inspect$791$82=x.first();
                            if(inspect$791$82!=null) // INSPECT inspect$791$82
                            // JavaLine 104 <== SourceLine 792
                            {
                                inspect$775$80.exit=((Common$quant)(((Link$)inspect$791$82)));
                                ;
                                // JavaLine 108 <== SourceLine 793
                                if(VALUE$((inspect$791$82.suc()!=(null)))) {
                                    // JavaLine 110 <== SourceLine 794
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Too many exit variables"));
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 116 <== SourceLine 795
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Missing exit variable"));
                        }
                        ;
                    }
                }
                ;
            }
        }
        ;
        // JavaLine 126 <== SourceLine 798
        ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.subtractExact(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure read_par",1,771,13,772,15,775,17,783,19,791,31,773,34,774,37,775,42,776,46,777,49,778,51,779,55,780,60,781,62,782,68,783,73,784,77,785,79,786,85,787,91,789,93,790,99,791,104,792,108,793,110,794,116,795,126,798,131,799);
} // End of Procedure
