package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$testreference extends PROC$ {
    public TXT$ p$tt;
    public simtst30$$A p$rat;
    public simtst30$$B p$rbt;
    public TXT$ p$tv;
    public simtst30$$A p$rav;
    public simtst30$$B p$rbv;
    public int p$errnr;
    public simtst30$$testreference setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 7: p$tt=(TXT$)objectValue(param); break;
                case 6: p$rat=(simtst30$$A)objectValue(param); break;
                case 5: p$rbt=(simtst30$$B)objectValue(param); break;
                case 4: p$tv=(TXT$)objectValue(param); break;
                case 3: p$rav=(simtst30$$A)objectValue(param); break;
                case 2: p$rbv=(simtst30$$B)objectValue(param); break;
                case 1: p$errnr=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst30$$testreference(RTObject$ SL$) {
        super(SL$,7);
    }
    public simtst30$$testreference(RTObject$ SL$,TXT$ sp$tt,simtst30$$A sp$rat,simtst30$$B sp$rbt,TXT$ sp$tv,simtst30$$A sp$rav,simtst30$$B sp$rbv,int sp$errnr) {
        super(SL$);
        this.p$tt = sp$tt;
        this.p$rat = sp$rat;
        this.p$rbt = sp$rbt;
        this.p$tv = sp$tv;
        this.p$rav = sp$rav;
        this.p$rbv = sp$rbv;
        this.p$errnr = sp$errnr;
        BBLK();
        STM$();
    }
    public simtst30$$testreference STM$() {
        if(VALUE$(((TRF_EQ(p$tt,p$tv)&((p$rat==(p$rav))))&((p$rbt==(p$rbv)))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Reference ("));
            sysout().outint(p$errnr,(((p$errnr<(10)))?(1):(2)));
            sysout().outtext(new TXT$(")."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values : "));
            sysout().outimage();
            sysout().outtext(new TXT$("            "));
            sysout().outtext(p$tt);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(p$rat.p$t);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(p$rbt.p$t);
            sysout().outimage();
            ((simtst30$)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure testreference",1,57,46,63,49,68,52,69,54,70,56,71,58,72,60,73,62,74,64,75,66,76,68,77,70,78,72,79,74,80,76,81,81,83);
}
