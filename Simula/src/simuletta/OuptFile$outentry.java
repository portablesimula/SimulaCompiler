// JavaLine 1 <== SourceLine 86
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outentry extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=86, lastLine=98, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 87
    Common inspect$87$27=null;
    // JavaLine 13 <== SourceLine 90
    Common$symbolbox inspect$90$28=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outentry setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outentry.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$i=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outentry(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outentry(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outentry STM$() {
        // JavaLine 42 <== SourceLine 87
        {
            // BEGIN INSPECTION 
            inspect$87$27=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$87$27!=null) // INSPECT inspect$87$27
            // JavaLine 47 <== SourceLine 88
            {
                if(VALUE$((inspect$87$27.option.Elt[rank('L')-inspect$87$27.option.LB[0]]!=(0)))) {
                    // JavaLine 50 <== SourceLine 89
                    {
                        if(VALUE$((p$i==(0)))) {
                            new Common$WARNING(inspect$87$27,new TXT$("Illegal output tag: ZERO"));
                        }
                        ;
                        // JavaLine 56 <== SourceLine 90
                        {
                            // BEGIN INSPECTION 
                            inspect$90$28=inspect$87$27.tagtab.Elt[p$i-inspect$87$27.tagtab.LB[0]];
                            if(inspect$90$28!=null) // INSPECT inspect$90$28
                            // JavaLine 61 <== SourceLine 91
                            {
                                if(VALUE$(TRF_EQ(inspect$90$28.symbol,null))) {
                                    // JavaLine 64 <== SourceLine 92
                                    new OuptFile$outtag(((OuptFile)(CUR$.SL$)),p$i);
                                } else
                                // JavaLine 67 <== SourceLine 93
                                {
                                    ((OuptFile)(CUR$.SL$)).out2byte(0);
                                    ;
                                    new OuptFile$outtag(((OuptFile)(CUR$.SL$)),p$i);
                                    ;
                                    // JavaLine 73 <== SourceLine 94
                                    ((OuptFile)(CUR$.SL$)).outbyte(TXT$.length(inspect$90$28.symbol));
                                    ;
                                    ((OuptFile)(CUR$.SL$)).outtext(inspect$90$28.symbol);
                                    ;
                                }
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 85 <== SourceLine 97
                new OuptFile$outtagid(((OuptFile)(CUR$.SL$)),p$i);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outentry",1,86,11,87,13,90,42,87,47,88,50,89,56,90,61,91,64,92,67,93,73,94,85,97,92,98);
} // End of Procedure
