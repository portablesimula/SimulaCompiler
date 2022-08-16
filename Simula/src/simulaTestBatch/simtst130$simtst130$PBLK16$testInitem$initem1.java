package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$initem1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public file$ p$fileref;
    public TXT$ res=null;
    public int i=0;
    public file$ inspect$608$0=null;
    public simtst130$simtst130$PBLK16$testInitem$initem1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$fileref=(file$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$initem1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testInitem$initem1(RTObject$ SL$,file$ sp$fileref) {
        super(SL$);
        this.p$fileref = sp$fileref;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$initem1 STM$() {
        {
            inspect$608$0=p$fileref;
            if(inspect$608$0 instanceof infile$)
            {
                if(VALUE$((!(((infile$)inspect$608$0).lastitem())))) {
                    res=simtst130$PBLK16.getitem(new NAME$<TXT$>(){ public TXT$ get() { return(((infile$)(inspect$608$0)).image); } public TXT$ put(TXT$ x$) { return(((infile$)(inspect$608$0)).image=(TXT$)x$); } });
                }
            }
            else if(inspect$608$0 instanceof directfile$)
            {
                if(VALUE$((!(((directfile$)inspect$608$0).lastitem())))) {
                    res=simtst130$PBLK16.getitem(new NAME$<TXT$>(){ public TXT$ get() { return(((directfile$)(inspect$608$0)).image); } public TXT$ put(TXT$ x$) { return(((directfile$)(inspect$608$0)).image=(TXT$)x$); } });
                }
            }
            else if(inspect$608$0 instanceof inbytefile$)
            {
                {
                    res=ENVIRONMENT$.blanks(1);
                    ;
                    i=ENVIRONMENT$.rank(((char)9));
                    ;
                    while(((i==(ENVIRONMENT$.rank(((char)32))))|((i==(ENVIRONMENT$.rank(((char)9))))))) {
                        i=((inbytefile$)inspect$608$0).inbyte();
                    }
                    ;
                    TXT$.putchar(TXT$.sub(res,1,1),ENVIRONMENT$.char$(i));
                    ;
                }
            }
            else if(inspect$608$0 instanceof directbytefile$)
            {
                {
                    res=ENVIRONMENT$.blanks(1);
                    ;
                    i=ENVIRONMENT$.rank(((char)9));
                    ;
                    while(((i==(ENVIRONMENT$.rank(((char)32))))|((i==(ENVIRONMENT$.rank(((char)9))))))) {
                        i=((directbytefile$)inspect$608$0).inbyte();
                    }
                    ;
                    TXT$.putchar(TXT$.sub(res,1,1),ENVIRONMENT$.char$(i));
                    ;
                }
            }
        }
        ;
        RESULT$=res;
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure initem1",1,605,10,606,13,608,38,609,45,611,52,613,59,614,64,615,70,618,77,619,82,620,89,622,94,623);
}
