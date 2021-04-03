// JavaLine 1 <== SourceLine 775
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=775, lastLine=1035, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Linkage$ p$d;
    public int p$pos;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 804
    Linkage$ inspect$804$16=null;
    // JavaLine 14 <== SourceLine 871
    Link$ inspect$871$17=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$prt setPar(Object param) {
        //Util.BREAK("CALL Common$prt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$d=(Linkage$)objectValue(param); break;
                case 1: p$pos=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$prt(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$prt(RTObject$ SL$,Linkage$ sp$d,int sp$pos) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        this.p$pos = sp$pos;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$prt STM$() {
        // JavaLine 45 <== SourceLine 802
        if(VALUE$((p$pos>(0)))) {
            sysout().setpos(p$pos);
        }
        ;
        // JavaLine 50 <== SourceLine 804
        {
            // BEGIN INSPECTION 
            inspect$804$16=p$d;
            //INSPECT inspect$804$16
            if(inspect$804$16 instanceof Common$system_descr) // WHEN Common$system_descr DO 
            // JavaLine 56 <== SourceLine 805
            {
                new Common$prt$outName(((Common$prt)(CUR$)),new TXT$("system-function "));
                ;
                sysout().outchar(';');
                ;
                // JavaLine 62 <== SourceLine 806
                sysout().outimage();
            }
            else if(inspect$804$16 instanceof Common$label_descr) // WHEN Common$label_descr DO 
            // JavaLine 66 <== SourceLine 807
            {
                new Common$prt$outName(((Common$prt)(CUR$)),new TXT$("label-const "));
                ;
                sysout().outchar(';');
                ;
                sysout().outimage();
                ;
            }
            else if(inspect$804$16 instanceof Common$dest_descr) // WHEN Common$dest_descr DO 
            // JavaLine 76 <== SourceLine 809
            {
                new Common$prt$outName(((Common$prt)(CUR$)),new TXT$("destination-const "));
                ;
                sysout().outimage();
                ;
            }
            else if(inspect$804$16 instanceof Common$record) // WHEN Common$record DO 
            // JavaLine 84 <== SourceLine 831
            new Common$prt$SubBlock811((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$peculiar) // WHEN Common$peculiar DO 
            // JavaLine 87 <== SourceLine 842
            new Common$prt$SubBlock832((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$profile) // WHEN Common$profile DO 
            // JavaLine 90 <== SourceLine 843
            {
                if(VALUE$(((Common$profile)(inspect$804$16)).interface$$3)) {
                    sysout().outtext(new TXT$("global "));
                }
                ;
                // JavaLine 96 <== SourceLine 844
                new Common$prt$outName(((Common$prt)(CUR$)),new TXT$("profile "));
                ;
                sysout().outchar(';');
                ;
                sysout().outimage();
                ;
                // JavaLine 103 <== SourceLine 845
                new Common$prt$prt_parspec(((Common$prt)(CUR$)),((Common$profile)(inspect$804$16)).spec$3,p$pos);
                ;
            }
            else if(inspect$804$16 instanceof Common$routine) // WHEN Common$routine DO 
            // JavaLine 108 <== SourceLine 848
            {
                sysout().outtext(new TXT$("Routine("));
                ;
                sysout().outtext(((Common$routine)(inspect$804$16)).profbox$3.symbol);
                ;
                // JavaLine 114 <== SourceLine 849
                new Common$prt$outName(((Common$prt)(CUR$)),new TXT$(") "));
                ;
                sysout().outchar(';');
                ;
                sysout().outimage();
                ;
                // JavaLine 121 <== SourceLine 850
                if(VALUE$((((Common$routine)(inspect$804$16)).local$3!=(null)))) {
                    {
                        new Common$prt(((Common)(CUR$.SL$)),((Common$routine)(inspect$804$16)).local$3,p$pos);
                        ;
                        sysout().outimage();
                    }
                }
                ;
            }
            else if(inspect$804$16 instanceof Common$quant) // WHEN Common$quant DO 
            // JavaLine 132 <== SourceLine 853
            {
                if(VALUE$(((Common$quant)(inspect$804$16)).read_only$3)) {
                    sysout().outtext(new TXT$("constant "));
                }
                ;
                // JavaLine 138 <== SourceLine 854
                new Common$prt$outName(((Common$prt)(CUR$)),CONC(new Common$edtype(((Common)(CUR$.SL$)),((Common$quant)(inspect$804$16)).p3$type).RESULT$,new TXT$(" ")));
                ;
                // JavaLine 141 <== SourceLine 855
                if(VALUE$((((Common$quant)(inspect$804$16)).count$3!=(1)))) {
                    sysout().outtext(CONC(CONC(new TXT$("("),new Common$leftint(((Common)(CUR$.SL$)),((Common$quant)(inspect$804$16)).count$3).RESULT$),new TXT$(")")));
                }
                ;
                // JavaLine 146 <== SourceLine 856
                if(VALUE$((((Common$quant)(inspect$804$16)).initval$3!=(null)))) {
                    // JavaLine 148 <== SourceLine 864
                    new Common$prt$CompoundStatement853$SubBlock857((CUR$)).STM$();
                }
                ;
                // JavaLine 152 <== SourceLine 865
                sysout().outchar(';');
                ;
                sysout().outimage();
                ;
            }
            else if(inspect$804$16 instanceof Common$designator) // WHEN Common$designator DO 
            // JavaLine 159 <== SourceLine 920
            new Common$prt$SubBlock868((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$repexpr) // WHEN Common$repexpr DO 
            // JavaLine 162 <== SourceLine 926
            new Common$prt$SubBlock921((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$quaopr) // WHEN Common$quaopr DO 
            // JavaLine 165 <== SourceLine 927
            {
                sysout().outchar('(');
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$quaopr)(inspect$804$16)).p3$x,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 173 <== SourceLine 928
                sysout().outtext(new TXT$(" qua "));
                ;
                sysout().outtext(new Common$edtype(((Common)(CUR$.SL$)),((Common$quaopr)(inspect$804$16)).p3$type).RESULT$);
                ;
            }
            else if(inspect$804$16 instanceof Common$dsize) // WHEN Common$dsize DO 
            // JavaLine 180 <== SourceLine 931
            {
                sysout().outtext(CONC(CONC(new TXT$("size("),new Common$edSymbol(((Common)(CUR$.SL$)),((Common$dsize)(inspect$804$16)).p3$r).RESULT$),new TXT$(":")));
                ;
                // JavaLine 184 <== SourceLine 932
                new Common$prt(((Common)(CUR$.SL$)),((Common$dsize)(inspect$804$16)).p3$x,0);
                ;
                sysout().outchar(')');
                ;
            }
            else if(inspect$804$16 instanceof Common$binopr) // WHEN Common$binopr DO 
            // JavaLine 191 <== SourceLine 935
            {
                sysout().outchar('(');
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$binopr)(inspect$804$16)).p3$x,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 199 <== SourceLine 936
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_ADD$1)))) {
                    // JavaLine 201 <== SourceLine 937
                    sysout().outtext(new TXT$(" + "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_SUB$1)))) {
                    // JavaLine 205 <== SourceLine 938
                    sysout().outtext(new TXT$(" - "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_MULT$1)))) {
                    // JavaLine 209 <== SourceLine 939
                    sysout().outtext(new TXT$(" * "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_DIV$1)))) {
                    // JavaLine 213 <== SourceLine 940
                    sysout().outtext(new TXT$(" / "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_REM$1)))) {
                    // JavaLine 217 <== SourceLine 941
                    sysout().outtext(new TXT$(" rem "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_LT$1)))) {
                    // JavaLine 221 <== SourceLine 942
                    sysout().outtext(new TXT$(" < "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_LE$1)))) {
                    // JavaLine 225 <== SourceLine 943
                    sysout().outtext(new TXT$(" <= "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_EQ$1)))) {
                    // JavaLine 229 <== SourceLine 944
                    sysout().outtext(new TXT$(" = "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_GT$1)))) {
                    // JavaLine 233 <== SourceLine 945
                    sysout().outtext(new TXT$(" > "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_GE$1)))) {
                    // JavaLine 237 <== SourceLine 946
                    sysout().outtext(new TXT$(" >= "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_NE$1)))) {
                    // JavaLine 241 <== SourceLine 947
                    sysout().outtext(new TXT$(" <> "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_AND$1)))) {
                    // JavaLine 245 <== SourceLine 948
                    sysout().outtext(new TXT$(" and "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_OR$1)))) {
                    // JavaLine 249 <== SourceLine 949
                    sysout().outtext(new TXT$(" or "));
                } else
                if(VALUE$((((Common$binopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_XOR$1)))) {
                    // JavaLine 253 <== SourceLine 950
                    sysout().outtext(new TXT$(" xor "));
                } else
                new Common$IERR(((Common)(CUR$.SL$)));
                ;
                // JavaLine 258 <== SourceLine 951
                sysout().outchar('(');
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$binopr)(inspect$804$16)).p3$y,0);
                ;
                sysout().outchar(')');
                ;
            }
            else if(inspect$804$16 instanceof Common$unopr) // WHEN Common$unopr DO 
            // JavaLine 267 <== SourceLine 955
            {
                if(VALUE$((((Common$unopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_NEG$1)))) {
                    // JavaLine 270 <== SourceLine 956
                    sysout().outtext(new TXT$(" - "));
                } else
                if(VALUE$((((Common$unopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_NOT$1)))) {
                    // JavaLine 274 <== SourceLine 957
                    sysout().outtext(new TXT$(" not "));
                } else
                if(VALUE$((((Common$unopr)(inspect$804$16)).p3$opr==(((Common)(CUR$.SL$)).S_NAME$1)))) {
                    // JavaLine 278 <== SourceLine 958
                    sysout().outtext(new TXT$(" name"));
                } else
                new Common$IERR(((Common)(CUR$.SL$)));
                ;
                // JavaLine 283 <== SourceLine 959
                sysout().outchar('(');
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$unopr)(inspect$804$16)).p3$x,0);
                ;
                sysout().outchar(')');
                ;
            }
            else if(inspect$804$16 instanceof Common$ifexpr) // WHEN Common$ifexpr DO 
            // JavaLine 292 <== SourceLine 962
            {
                sysout().outtext(new TXT$("if "));
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$ifexpr)(inspect$804$16)).cond$3,0);
                ;
                sysout().outtext(new TXT$(" then "));
                ;
                // JavaLine 300 <== SourceLine 963
                new Common$prt(((Common)(CUR$.SL$)),((Common$ifexpr)(inspect$804$16)).x$3,0);
                ;
                sysout().outtext(new TXT$(" else "));
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$ifexpr)(inspect$804$16)).y$3,0);
                ;
            }
            else if(inspect$804$16 instanceof Common$module) // WHEN Common$module DO 
            // JavaLine 309 <== SourceLine 966
            {
                if(VALUE$(((Common$module)(inspect$804$16)).system$2)) {
                    sysout().outtext(new TXT$("sys"));
                }
                ;
                // JavaLine 315 <== SourceLine 967
                sysout().outtext(new TXT$("insert "));
                ;
                sysout().outtext(((Common$module)(inspect$804$16)).p2$modid);
                ;
                // JavaLine 320 <== SourceLine 968
                sysout().outchar(';');
                ;
                sysout().outimage();
                ;
                new Common$prt(((Common)(CUR$.SL$)),((Common$module)(inspect$804$16)).dclset$2,p$pos);
                ;
            }
            else if(inspect$804$16 instanceof Common$val_const) // WHEN Common$val_const DO 
            // JavaLine 329 <== SourceLine 971
            {
                sysout().outchar(((char)39));
                ;
                sysout().outtext(((Common$val_const)(inspect$804$16)).p4$v);
                ;
                // JavaLine 335 <== SourceLine 972
                sysout().outchar(((char)39));
            }
            else if(inspect$804$16 instanceof Common$offset_const) // WHEN Common$offset_const DO 
            // JavaLine 339 <== SourceLine 979
            new Common$prt$SubBlock973((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$idn_const) // WHEN Common$idn_const DO 
            // JavaLine 342 <== SourceLine 980
            {
                if(VALUE$((((Common$idn_const)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_C_OADDR$1)))) {
                    // JavaLine 345 <== SourceLine 981
                    sysout().outtext(new TXT$("ref("));
                } else
                if(VALUE$((((Common$idn_const)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_C_GADDR$1)))) {
                    // JavaLine 349 <== SourceLine 982
                    sysout().outtext(new TXT$("name("));
                } else
                if(VALUE$((((Common$idn_const)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_C_SIZE$1)))) {
                    // JavaLine 353 <== SourceLine 983
                    sysout().outtext(new TXT$("size("));
                } else
                if(VALUE$((((Common$idn_const)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_C_PADDR$1)))) {
                    // JavaLine 357 <== SourceLine 984
                    sysout().outtext(new TXT$("label("));
                } else
                if(VALUE$((((Common$idn_const)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_C_RADDR$1)))) {
                    // JavaLine 361 <== SourceLine 985
                    sysout().outtext(new TXT$("entry("));
                } else
                sysout().outtext(new TXT$("**Unknown("));
                ;
                // JavaLine 366 <== SourceLine 986
                sysout().outtext(((Common$idn_const)(inspect$804$16)).p4$ibox.symbol);
                ;
                sysout().outchar(')');
                ;
            }
            else if(inspect$804$16 instanceof Common$structured_const) // WHEN Common$structured_const DO 
            // JavaLine 373 <== SourceLine 1002
            new Common$prt$SubBlock989((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$repeated_const) // WHEN Common$repeated_const DO 
            // JavaLine 376 <== SourceLine 1011
            new Common$prt$SubBlock1003((CUR$)).STM$();
            else if(inspect$804$16 instanceof Common$const$) // WHEN Common$const$ DO 
            // JavaLine 379 <== SourceLine 1012
            {
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_TRUE$1)))) {
                    // JavaLine 382 <== SourceLine 1013
                    sysout().outtext(new TXT$("true"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_FALSE$1)))) {
                    // JavaLine 386 <== SourceLine 1014
                    sysout().outtext(new TXT$("false"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_ONONE$1)))) {
                    // JavaLine 390 <== SourceLine 1015
                    sysout().outtext(new TXT$("none"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_ANONE$1)))) {
                    // JavaLine 394 <== SourceLine 1016
                    sysout().outtext(new TXT$("nofield"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_GNONE$1)))) {
                    // JavaLine 398 <== SourceLine 1017
                    sysout().outtext(new TXT$("noname"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_NOSIZE$1)))) {
                    // JavaLine 402 <== SourceLine 1018
                    sysout().outtext(new TXT$("nosize"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_NOWHERE$1)))) {
                    // JavaLine 406 <== SourceLine 1019
                    sysout().outtext(new TXT$("nowhere"));
                } else
                if(VALUE$((((Common$const$)(inspect$804$16)).p3$instr==(((Common)(CUR$.SL$)).S_NOBODY$1)))) {
                    // JavaLine 410 <== SourceLine 1020
                    sysout().outtext(new TXT$("nobody"));
                } else
                sysout().outtext(new TXT$("**Unknown"));
                ;
            }
            else if(inspect$804$16 instanceof Common$macro) // WHEN Common$macro DO 
            // JavaLine 417 <== SourceLine 1025
            {
            }
            else if(inspect$804$16 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
            // JavaLine 421 <== SourceLine 1028
            {
            }
            else if(inspect$804$16 instanceof Head$) // WHEN Head$ DO 
            // JavaLine 425 <== SourceLine 1034
            new Common$prt$SubBlock1029((CUR$)).STM$();
            else // OTHERWISE 
            // JavaLine 428 <== SourceLine 1034
            sysout().outtext(new TXT$("**Unknown data element**"));
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure prt",1,775,12,804,14,871,45,802,50,804,56,805,62,806,66,807,76,809,84,831,87,842,90,843,96,844,103,845,108,848,114,849,121,850,132,853,138,854,141,855,146,856,148,864,152,865,159,920,162,926,165,927,173,928,180,931,184,932,191,935,199,936,201,937,205,938,209,939,213,940,217,941,221,942,225,943,229,944,233,945,237,946,241,947,245,948,249,949,253,950,258,951,267,955,270,956,274,957,278,958,283,959,292,962,300,963,309,966,315,967,320,968,329,971,335,972,339,979,342,980,345,981,349,982,353,983,357,984,361,985,366,986,373,1002,376,1011,379,1012,382,1013,386,1014,390,1015,394,1016,398,1017,402,1018,406,1019,410,1020,417,1025,421,1028,425,1034,428,1034,434,1035);
} // End of Procedure
