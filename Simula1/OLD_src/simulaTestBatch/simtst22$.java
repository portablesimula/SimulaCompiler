package simulaTestBatch;
// Simula-1.0 Compiled at Thu Oct 03 12:45:10 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst22$ extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    int i=0;
    int j=0;
    int n=0;
    simtst22$$c cp=null;
    public simtst22$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst22$");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 22"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test for-loops with various for-list elements."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        n=1;
        for(boolean CB$30:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(2); }})
           )) { if(!CB$30) continue;
        {
            if(VALUE$((i!=(n)))) {
                {
                    sysout().outtext(new TXT$("*** error : Fast For (1)."));
                    sysout().outimage();
                    sysout().outtext(new TXT$("            Erroneus values : "));
                    sysout().outint(i,3);
                    sysout().outint(n,3);
                    sysout().outimage();
                    found_error=true;
                }
            }
            n=Math.addExact(n,1);
        }
    }
    if(VALUE$((i!=(n)))) {
        {
            sysout().outtext(new TXT$("*** error : Fast For (2)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values :"));
            sysout().outint(i,3);
            sysout().outint(n,3);
            sysout().outimage();
            found_error=true;
        }
    }
    n=1;
    for(boolean CB$57:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(j,2)); }})
       )) { if(!CB$57) continue;
    {
        if(VALUE$((i!=(n)))) {
            {
                sysout().outtext(new TXT$("*** error : Single Step Element (3)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneus values :"));
                sysout().outint(i,3);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=Math.addExact(n,1);
    }
}
if(VALUE$((i!=(n)))) {
    {
        sysout().outtext(new TXT$("*** error :Single Step Element (4)."));
        sysout().outimage();
        sysout().outtext(new TXT$("            Erroneus values :"));
        sysout().outint(i,3);
        sysout().outint(n,3);
        sysout().outimage();
        found_error=true;
    }
}
n=1;
for(boolean CB$86:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(2); }})
   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(j); }})
   )) { if(!CB$86) continue;
{
    if(VALUE$((((i!=(n))&((n<(3))))|(((n==(3))&((i!=(j)))))))) {
        {
            sysout().outtext(new TXT$("*** error : Complex For (5)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values :"));
            sysout().outint(i,3);
            sysout().outint(n,3);
            sysout().outimage();
            found_error=true;
        }
    }
    n=Math.addExact(n,1);
}
}
if(VALUE$((i!=(j)))) {
{
    sysout().outtext(new TXT$("*** error : Complex For (6)."));
    sysout().outimage();
    sysout().outtext(new TXT$("            Erroneus values :"));
    sysout().outint(i,3);
    sysout().outint(n,3);
    sysout().outimage();
    found_error=true;
}
}
n=1;
for(boolean CB$116:new ForList(
    new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Boolean>() { public Boolean get(){return((i>(j))); }})
   )) { if(!CB$116) continue;
{
if(VALUE$(((i!=(n))|((n>(1)))))) {
    {
        sysout().outtext(new TXT$("*** error : Single While Element (7)."));
        sysout().outimage();
        sysout().outtext(new TXT$("            Erroneus values :"));
        sysout().outint(i,3);
        sysout().outint(n,3);
        sysout().outimage();
        found_error=true;
    }
}
n=Math.addExact(n,1);
j=2;
}
}
if(VALUE$(((i!=(1))|((n>(2)))))) {
{
sysout().outtext(new TXT$("*** error : Singel While Element (8)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneus values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$147:new ForList(
    new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Boolean>() { public Boolean get(){return((i>(j))); }})
   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(4); }})
   )) { if(!CB$147) continue;
{
if(VALUE$(((i!=(4))|((n>(1)))))) {
{
    sysout().outtext(new TXT$("*** error : Complex For (9)."));
    sysout().outimage();
    sysout().outtext(new TXT$("            Erroneus values :"));
    sysout().outint(i,3);
    sysout().outint(n,3);
    sysout().outimage();
    found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(4))|((n>(2)))))) {
{
sysout().outtext(new TXT$("*** error : Complex For (10)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneus values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$176:new ForList(
    new SingleElt<simtst22$$c>(new NAME$<simtst22$$c>(){ public simtst22$$c put(simtst22$$c x$){cp=(simtst22$$c)x$; return(x$);};  public simtst22$$c get(){return((simtst22$$c)cp); }	},new NAME$<simtst22$$c>() { public simtst22$$c get(){return(new simtst22$$c((CUR$)).STM$()); }})
   ,new WhileElt<simtst22$$c>(new NAME$<simtst22$$c>(){ public simtst22$$c put(simtst22$$c x$){cp=(simtst22$$c)x$; return(x$);};  public simtst22$$c get(){return((simtst22$$c)cp); }	},new NAME$<simtst22$$c>() { public simtst22$$c get(){return(cp.next); }},new NAME$<Boolean>() { public Boolean get(){return((cp!=(null))); }})
   )) { if(!CB$176) continue;
new simtst22$$SubBlock178((CUR$)).STM$();
}
if(VALUE$((n!=(2)))) {
{
sysout().outtext(new TXT$("*** error : Complex For (12)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneus values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$207:new ForList(
    new SingleElt<simtst22$$c>(new NAME$<simtst22$$c>(){ public simtst22$$c put(simtst22$$c x$){cp=(simtst22$$c)x$; return(x$);};  public simtst22$$c get(){return((simtst22$$c)cp); }	},new NAME$<simtst22$$c>() { public simtst22$$c get(){return(new simtst22$$c((CUR$)).STM$()); }})
   ,new WhileElt<simtst22$$c>(new NAME$<simtst22$$c>(){ public simtst22$$c put(simtst22$$c x$){cp=(simtst22$$c)x$; return(x$);};  public simtst22$$c get(){return((simtst22$$c)cp); }	},new NAME$<simtst22$$c>() { public simtst22$$c get(){return(cp.next); }},new NAME$<Boolean>() { public Boolean get(){return((cp!=(null))); }})
   ,new SingleElt<simtst22$$c>(new NAME$<simtst22$$c>(){ public simtst22$$c put(simtst22$$c x$){cp=(simtst22$$c)x$; return(x$);};  public simtst22$$c get(){return((simtst22$$c)cp); }	},new NAME$<simtst22$$c>() { public simtst22$$c get(){return(new simtst22$$c((CUR$)).STM$().next); }})
   )) { if(!CB$207) continue;
new simtst22$$SubBlock209((CUR$)).STM$();
}
if(VALUE$(((n!=(3))|((cp!=(null)))))) {
{
sysout().outtext(new TXT$("*** error : Complex For (16)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneus values :"));
sysout().outint(n,3);
sysout().outtext((((cp==(null)))?(new TXT$(" cp == none")):(new TXT$(" cp =/= none"))));
sysout().outimage();
found_error=true;
}
}
if(VALUE$(found_error)) {
} else
{
sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 22"));
}
if(VALUE$(verbose)) {
{
sysout().outtext(new TXT$("--- END Simula a.s. TEST 22"));
sysout().outimage();
}
}
EBLK();
return(this);
}

public static void main(String[] args) {
RT.setRuntimeOptions(args);
new simtst22$(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst22.sim","SimulaProgram simtst22$",1,12,9,13,11,18,15,19,23,21,25,22,28,23,30,24,32,25,37,28,39,30,43,32,46,34,49,35,51,36,53,37,56,38,58,39,62,41,66,44,68,46,71,47,73,48,75,49,77,50,79,51,81,52,85,55,87,57,91,59,94,61,97,62,99,63,101,64,103,65,105,66,107,67,111,69,115,72,117,74,120,75,122,76,124,77,126,78,128,79,130,80,134,84,136,86,141,88,144,91,147,92,149,93,151,94,153,95,155,96,157,97,161,100,165,103,167,105,170,106,172,107,174,108,176,109,178,110,180,111,184,114,186,116,190,118,193,120,196,121,198,122,200,123,202,124,204,125,206,126,210,129,212,130,216,133,218,135,221,136,223,137,225,138,227,139,229,140,231,141,235,145,237,147,242,149,245,151,248,152,250,153,252,154,254,155,256,156,258,157,262,160,266,163,268,165,271,166,273,167,275,168,277,169,279,170,281,171,285,174,287,176,292,192,295,194,297,196,300,197,302,198,304,199,306,200,308,201,310,202,314,205,316,207,322,252,325,254,327,256,330,257,332,258,334,259,336,260,338,261,340,262,344,268,347,271,351,274,353,275,356,278,367,278);
}
