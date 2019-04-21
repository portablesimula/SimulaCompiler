package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$y$yvirt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$line;
    public TXT$ p$t;
    public TXT$ p$where;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$y$yvirt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                case 2: p$where=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$y$yvirt(RTObject$ SL$)
    { super(SL$); }
    public simtst98$y$yvirt(RTObject$ SL$,int sp$line,TXT$ sp$t,TXT$ sp$where) {
        super(SL$);
        this.p$line = sp$line;
        this.p$t = sp$t;
        this.p$where = sp$where;
        BBLK();
        STM$();
    }
    public simtst98$y$yvirt STM$() {
        ((simtst98$y)(CUR$.SL$)).virtproc$3().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(p$line); } public Integer put(Integer x$) { return(p$line=(int)x$); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(p$where); } public TXT$ put(TXT$ x$) { return(p$where=(TXT$)x$); } }).ENT$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure yvirt",1,258,35,259,39,259);
}
