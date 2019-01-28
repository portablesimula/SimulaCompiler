// JavaLine 1 ==> SourceLine 15
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:07:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$drawboard extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=15, lastLine=40, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Queens2$drawboard(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("drawboard",15);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$drawboard STM$() {
        TRACE_BEGIN_STM$("drawboard",15);
        // JavaLine 23 ==> SourceLine 16
        sysout().outtext(new TXT$("[32m"));
        sysout().breakoutimage();
        // JavaLine 26 ==> SourceLine 17
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,23);
        sysout().outchar(((char)218));
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,55);
        sysout().outchar(((char)191));
        // JavaLine 31 ==> SourceLine 18
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,23);
        sysout().outchar(((char)192));
        // JavaLine 34 ==> SourceLine 19
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,55);
        sysout().outchar(((char)217));
        sysout().breakoutimage();
        // JavaLine 38 ==> SourceLine 20
        for(boolean CB$20:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$20) continue;
        // JavaLine 42 ==> SourceLine 21
        {
            TRACE_BEGIN_STM$("CompoundStatement21",21);
            for(boolean CB$21:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
               )) { if(!CB$21) continue;
            // JavaLine 48 ==> SourceLine 22
            {
                TRACE_BEGIN_STM$("CompoundStatement22",22);
                new Queens2$Setpos(((Queens2)(CUR$.SL$)),(3+((2*(((Queens2)(CUR$.SL$)).i)))),(20+((4*(((Queens2)(CUR$.SL$)).j)))));
                sysout().outtext(new TXT$("ÄÄÄ"));
                TRACE_END_STM$("CompoundStatement22",22);
            }
        }
        // JavaLine 56 ==> SourceLine 23
        sysout().breakoutimage();
        TRACE_END_STM$("CompoundStatement21",23);
    }
}
// JavaLine 61 ==> SourceLine 24
for(boolean CB$24:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
   )) { if(!CB$24) continue;
// JavaLine 65 ==> SourceLine 25
{
    TRACE_BEGIN_STM$("CompoundStatement25",25);
    for(boolean CB$25:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
       )) { if(!CB$25) continue;
    // JavaLine 71 ==> SourceLine 26
    {
        TRACE_BEGIN_STM$("CompoundStatement26",26);
        new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(((Queens2)(CUR$.SL$)).j)))),(19+((4*(((Queens2)(CUR$.SL$)).i)))));
        sysout().outchar(((char)179));
        TRACE_END_STM$("CompoundStatement26",26);
    }
}
// JavaLine 79 ==> SourceLine 27
sysout().breakoutimage();
TRACE_END_STM$("CompoundStatement25",27);
}
}
// JavaLine 84 ==> SourceLine 28
for(boolean CB$28:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$28) continue;
// JavaLine 88 ==> SourceLine 29
{
TRACE_BEGIN_STM$("CompoundStatement29",29);
for(boolean CB$29:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$29) continue;
// JavaLine 94 ==> SourceLine 30
{
TRACE_BEGIN_STM$("CompoundStatement30",30);
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).j)))),(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)197));
TRACE_END_STM$("CompoundStatement30",30);
}
}
// JavaLine 102 ==> SourceLine 31
sysout().breakoutimage();
TRACE_END_STM$("CompoundStatement29",31);
}
}
// JavaLine 107 ==> SourceLine 32
for(boolean CB$32:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$32) continue;
// JavaLine 111 ==> SourceLine 33
{
TRACE_BEGIN_STM$("CompoundStatement33",33);
new Queens2$Setpos(((Queens2)(CUR$.SL$)),5,(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)194));
TRACE_END_STM$("CompoundStatement33",33);
}
}
sysout().breakoutimage();
// JavaLine 120 ==> SourceLine 34
for(boolean CB$34:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$34) continue;
// JavaLine 124 ==> SourceLine 35
{
TRACE_BEGIN_STM$("CompoundStatement35",35);
new Queens2$Setpos(((Queens2)(CUR$.SL$)),21,(23+((4*(((Queens2)(CUR$.SL$)).i)))));
sysout().outchar(((char)193));
TRACE_END_STM$("CompoundStatement35",35);
}
}
sysout().breakoutimage();
// JavaLine 133 ==> SourceLine 36
for(boolean CB$36:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$36) continue;
// JavaLine 137 ==> SourceLine 37
{
TRACE_BEGIN_STM$("CompoundStatement37",37);
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).i)))),23);
sysout().outchar(((char)195));
TRACE_END_STM$("CompoundStatement37",37);
}
}
sysout().breakoutimage();
// JavaLine 146 ==> SourceLine 38
for(boolean CB$38:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
   )) { if(!CB$38) continue;
// JavaLine 150 ==> SourceLine 39
{
TRACE_BEGIN_STM$("CompoundStatement39",39);
new Queens2$Setpos(((Queens2)(CUR$.SL$)),(5+((2*(((Queens2)(CUR$.SL$)).i)))),55);
sysout().outchar(((char)180));
TRACE_END_STM$("CompoundStatement39",39);
}
}
sysout().breakoutimage();
TRACE_END_STM$("drawboard",39);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure drawboard",1,15,23,16,26,17,31,18,34,19,38,20,42,21,48,22,56,23,61,24,65,25,71,26,79,27,84,28,88,29,94,30,102,31,107,32,111,33,120,34,124,35,133,36,137,37,146,38,150,39,162,40);
}
