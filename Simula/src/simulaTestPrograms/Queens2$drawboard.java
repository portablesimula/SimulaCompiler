package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$drawboard extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Queens2$drawboard(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Queens2$drawboard STM$() {
        sysout().outtext(new TXT$("[32m"));
        sysout().breakoutimage();
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,23);
        sysout().outchar(((char)218));
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,55);
        sysout().outchar(((char)191));
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,23);
        sysout().outchar(((char)192));
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,55);
        sysout().outchar(((char)217));
        sysout().breakoutimage();
        for(boolean CB$20:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$20) continue;
        {
            for(boolean CB$21:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
               )) { if(!CB$21) continue;
            {
                new Queens2$Setpos(((Queens2)(CUR$.SL$)),(3+((2*(((Queens2)(CUR$.SL$)).i)))),(20+((4*(((Queens2)(CUR$.SL$)).j)))));
                sysout().outtext(new TXT$("ÄÄÄ"));
            }
        }
        sysout().breakoutimage();
    }
}
for(boolean CB$24:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
   )) { if(!CB$24) continue;
{
    for(boolean CB$25:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
       )) { if(!CB$25) continue;
    {
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(((Queens2)(CUR$.SL$)).j)))),(19+((4*(((Queens2)(CUR$.SL$)).i)))));
        sysout().outchar(((char)179));
    }
}
sysout().breakoutimage();
}
}
for(boolean CB$28:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$28) continue;
{
for(boolean CB$29:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$29) continue;
{
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).j)))),(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)197));
}
}
sysout().breakoutimage();
}
}
for(boolean CB$32:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$32) continue;
{
new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)194));
}
}
sysout().breakoutimage();
for(boolean CB$34:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$34) continue;
{
new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)193));
}
}
sysout().breakoutimage();
for(boolean CB$36:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$36) continue;
{
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).i)))),23);
sysout().outchar(((char)195));
}
}
sysout().breakoutimage();
for(boolean CB$38:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$38) continue;
{
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).i)))),55);
sysout().outchar(((char)180));
}
}
sysout().breakoutimage();
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure drawboard",1,15,14,16,17,17,22,18,25,19,29,20,33,21,38,22,44,23,48,24,52,25,57,26,63,27,67,28,71,29,76,30,82,31,86,32,90,33,97,34,101,35,108,36,112,37,119,38,123,39,132,40);
}
