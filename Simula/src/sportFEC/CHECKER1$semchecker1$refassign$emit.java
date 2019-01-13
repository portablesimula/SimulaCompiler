// JavaLine 1 ==> SourceLine 930
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$refassign$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=930, lastLine=990, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 974
    COMMON$quantity inspect$974$93=null;
    // Normal Constructor
    public CHECKER1$semchecker1$refassign$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",974);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$refassign$emit STM$() {
        TRACE_BEGIN_STM$("emit",974);
        // JavaLine 25 ==> SourceLine 936
        if((((IS$(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source,CHECKER1$semchecker1$dotIdent.class)&&((((CHECKER1$semchecker1$dotIdent)(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source)).p2$dotexp!=(null))))&&((((CHECKER1$semchecker1$dotIdent)(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source)).p2$dotexp.type!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT))))&&(((boolean)(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$dotIdent)(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source)).p2$dotexp).ENT$().RESULT$()))))) {
            // JavaLine 27 ==> SourceLine 941
            {
                TRACE_BEGIN_STM$("CompoundStatement941",941);
                ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl;
                ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                // JavaLine 32 ==> SourceLine 942
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IINSP;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 35 ==> SourceLine 943
                if(((CHECKER1)(CUR$.SL$.SL$.SL$)).NoneCheck) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement943",943);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement943",943);
                    }
                }
                // JavaLine 44 ==> SourceLine 944
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOT;
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source.meaning;
                // JavaLine 47 ==> SourceLine 945
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 49 ==> SourceLine 946
                ((CHECKER1$semchecker1$dotIdent)(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source)).p2$dotexp=null;
                // JavaLine 51 ==> SourceLine 947
                ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).issimple=0;
                TRACE_END_STM$("CompoundStatement941",947);
            }
        } else
        // JavaLine 56 ==> SourceLine 954
        {
            TRACE_BEGIN_STM$("CompoundStatement954",954);
            if((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).issimple==(0))) {
                // JavaLine 60 ==> SourceLine 955
                {
                    TRACE_BEGIN_STM$("CompoundStatement955",955);
                    ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl;
                    ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                    // JavaLine 65 ==> SourceLine 957
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITO;
                    TRACE_END_STM$("CompoundStatement955",957);
                }
            }
            TRACE_END_STM$("CompoundStatement954",957);
        }
        // JavaLine 72 ==> SourceLine 961
        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source.emit$0().CPF();
        // JavaLine 75 ==> SourceLine 962
        if(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).implqua) {
            // JavaLine 77 ==> SourceLine 963
            {
                TRACE_BEGIN_STM$("CompoundStatement963",963);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).INONE;
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).qual;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement963",963);
            }
        }
        // JavaLine 86 ==> SourceLine 969
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).type;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IASSG;
        // JavaLine 89 ==> SourceLine 970
        if((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))) {
            // JavaLine 91 ==> SourceLine 971
            {
                TRACE_BEGIN_STM$("CompoundStatement971",971);
                if(((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).issimple!=(0))&&(IS$(((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target,CHECKER1$semchecker1$dotIdent.class)))) {
                    // JavaLine 95 ==> SourceLine 972
                    {
                        TRACE_BEGIN_STM$("CompoundStatement972",972);
                        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl;
                        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITO;
                        TRACE_END_STM$("CompoundStatement972",972);
                    }
                } else
                // JavaLine 104 ==> SourceLine 974
                {
                    // BEGIN INSPECTION 
                    inspect$974$93=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.meaning;
                    if(inspect$974$93!=null) //INSPECT inspect$974$93
                    // JavaLine 109 ==> SourceLine 975
                    {
                        TRACE_BEGIN_STM$("CompoundStatement975",975);
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((COMMON$quantity)inspect$974$93);
                        // JavaLine 113 ==> SourceLine 976
                        if((inspect$974$93.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))) {
                            ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=inspect$974$93.match;
                        }
                        // JavaLine 117 ==> SourceLine 977
                        if((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).issimple!=(0))) {
                            // JavaLine 119 ==> SourceLine 978
                            {
                                TRACE_BEGIN_STM$("CompoundStatement978",978);
                                if((inspect$974$93.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc))) {
                                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLC;
                                } else
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISIMU;
                                TRACE_END_STM$("CompoundStatement978",978);
                            }
                        } else
                        // JavaLine 129 ==> SourceLine 979
                        if((inspect$974$93.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_name))) {
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).INAME;
                        }
                        TRACE_END_STM$("CompoundStatement975",979);
                    }
                }
                TRACE_END_STM$("CompoundStatement971",979);
            }
        } else
        // JavaLine 139 ==> SourceLine 982
        if((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).issimple!=(0))) {
            // JavaLine 141 ==> SourceLine 983
            {
                TRACE_BEGIN_STM$("CompoundStatement983",983);
                ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl;
                ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITO;
                TRACE_END_STM$("CompoundStatement983",983);
            }
        }
        // JavaLine 150 ==> SourceLine 985
        if((((CHECKER1$semchecker1$refassign)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl))) {
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
        }
        // JavaLine 154 ==> SourceLine 986
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 156 ==> SourceLine 987
        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$target=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).p1$source=null;
        // JavaLine 158 ==> SourceLine 988
        ((CHECKER1$semchecker1$refassign)(CUR$.SL$)).qual=((CHECKER1$semchecker1$refassign)(CUR$.SL$)).meaning=null;
        // JavaLine 160 ==> SourceLine 989
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).refassList=((CHECKER1$semchecker1$refassign)(CUR$.SL$));
        TRACE_END_STM$("emit",989);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,930,11,974,25,936,27,941,32,942,35,943,44,944,47,945,49,946,51,947,56,954,60,955,65,957,72,961,75,962,77,963,86,969,89,970,91,971,95,972,104,974,109,975,113,976,117,977,119,978,129,979,139,982,141,983,150,985,154,986,156,987,158,988,160,989,165,990);
}
