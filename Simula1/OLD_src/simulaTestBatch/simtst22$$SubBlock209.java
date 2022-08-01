package simulaTestBatch;
// Simula-1.0 Compiled at Thu Oct 03 12:45:10 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst22$$SubBlock209 extends BASICIO$ {
    int n1=0;
    public simtst22$$SubBlock209(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        if(VALUE$((((((simtst22$)(CUR$.SL$)).cp==(null))&((((simtst22$)(CUR$.SL$)).n==(1))))|(((((simtst22$)(CUR$.SL$)).cp!=(null))&((((simtst22$)(CUR$.SL$)).n==(2)))))))) {
            {
                sysout().outtext(new TXT$("*** error : Complex For (13)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneus values :"));
                sysout().outint(((simtst22$)(CUR$.SL$)).i,3);
                sysout().outint(((simtst22$)(CUR$.SL$)).n,3);
                sysout().outimage();
                ((simtst22$)(CUR$.SL$)).found_error=true;
            }
        }
        n1=1;
        for(boolean CB$224:new ForList(
            new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst22$)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst22$)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Boolean>() { public Boolean get(){return((((simtst22$)(CUR$.SL$)).i>(((simtst22$)(CUR$.SL$)).j))); }})
           ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst22$)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst22$)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(4); }})
           )) { if(!CB$224) continue;
        {
            if(VALUE$(((((simtst22$)(CUR$.SL$)).i!=(4))|((n1!=(1)))))) {
                {
                    sysout().outtext(new TXT$("*** error : Complex For (14)."));
                    sysout().outimage();
                    sysout().outtext(new TXT$("            Erroneus values :"));
                    sysout().outint(((simtst22$)(CUR$.SL$)).i,3);
                    sysout().outint(((simtst22$)(CUR$.SL$)).n,3);
                    sysout().outimage();
                    ((simtst22$)(CUR$.SL$)).found_error=true;
                }
            }
            n1=Math.addExact(n1,1);
        }
    }
    if(VALUE$(((((simtst22$)(CUR$.SL$)).i!=(4))|((n1!=(2)))))) {
        {
            sysout().outtext(new TXT$("*** error : Complex For (15)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values :"));
            sysout().outint(((simtst22$)(CUR$.SL$)).i,3);
            sysout().outint(((simtst22$)(CUR$.SL$)).n,3);
            sysout().outimage();
            ((simtst22$)(CUR$.SL$)).found_error=true;
        }
    }
    ((simtst22$)(CUR$.SL$)).n=Math.addExact(((simtst22$)(CUR$.SL$)).n,1);
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst22.sim","SubBlock SubBlock209",1,209,13,211,15,213,18,214,20,215,22,216,24,217,26,218,28,219,32,222,34,224,39,226,42,228,45,229,47,230,49,231,51,232,53,233,55,234,59,237,63,240,65,242,68,243,70,244,72,245,74,246,76,247,78,248,82,251,86,252);
}
