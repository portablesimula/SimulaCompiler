package simulaTestBatch;
// Simula-1.0 Compiled at Fri Oct 04 10:16:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst23$ extends BASICIO$ {
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    float eps=0.0f;
    int i=0;
    int n=0;
    float r=0.0f;
    double lr=0.0d;
    public simtst23$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst23$");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 23"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test all possible type conversions in connection with"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- step-until"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        eps=0.01f;
        n=1;
        for(i=(int)Math.round(3.14f);i<=6;i++) {
            {
                if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
                    {
                        sysout().outtext(new TXT$("*** error: Iteration - int int int(1)."));
                        sysout().outimage();
                        sysout().outtext(new TXT$("            Erroneous values :"));
                        sysout().outint(i,3);
                        sysout().outint(n,3);
                        sysout().outimage();
                        found_error=true;
                    }
                }
                n=Math.addExact(n,1);
            }
        }
        if(VALUE$(((i!=(7))|((n!=(5)))))) {
            {
                sysout().outtext(new TXT$("*** error: Number of iterations or value of controlled"));
                sysout().outimage();
                sysout().outtext(new TXT$("***         variable - int int int(2)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outint(i,3);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=1;
        for(r=3.14f;r<=6.0f;r++) {
            {
                if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
                    {
                        sysout().outtext(new TXT$("*** error: Iteration - real real real(3)."));
                        sysout().outimage();
                        sysout().outtext(new TXT$("            Erroneous values :"));
                        sysout().outreal(r,4,11);
                        sysout().outint(n,3);
                        sysout().outimage();
                        found_error=true;
                    }
                }
                n=Math.addExact(n,1);
            }
        }
        if(VALUE$((((n!=(4))|((r<((6.14f-(eps))))))|((r>((6.14f+(eps)))))))) {
            {
                sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
                sysout().outimage();
                sysout().outtext(new TXT$("***         controlled variabel - real real real(4)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outreal(r,4,11);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=1;
        for(lr=((double)(3.14f));lr<=6.0d;lr++) {
            {
                if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
                    {
                        sysout().outtext(new TXT$("*** error: Iteration - lreal lreal lreal(5)."));
                        sysout().outimage();
                        sysout().outtext(new TXT$("            Erroneous values :"));
                        sysout().outreal(lr,4,11);
                        sysout().outint(n,3);
                        sysout().outimage();
                        found_error=true;
                    }
                }
                n=Math.addExact(n,1);
            }
        }
        if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
            {
                sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
                sysout().outimage();
                sysout().outtext(new TXT$("***         controlled variable - lreal lreal lreal(6)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outreal(lr,4,11);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=1;
        for(i=(int)Math.round(3.14f);i<=(int)Math.round(6.0f);i++) {
            {
                if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
                    {
                        sysout().outtext(new TXT$("*** error: Iteration - int int real(7)."));
                        sysout().outimage();
                        sysout().outtext(new TXT$("            Erroneous values :"));
                        sysout().outint(i,3);
                        sysout().outint(n,3);
                        sysout().outimage();
                        found_error=true;
                    }
                }
                n=Math.addExact(n,1);
            }
        }
        if(VALUE$(((i!=(7))|((n!=(5)))))) {
            {
                sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
                sysout().outimage();
                sysout().outtext(new TXT$("***         controlled variable - int int real(8)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outint(i,3);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=1;
        for(boolean CB$161:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0f)); }},new NAME$<Number>() { public Number get(){return(6); }})
           )) { if(!CB$161) continue;
        {
            if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
                {
                    sysout().outtext(new TXT$("*** error: Iteration - int real int(9)."));
                    sysout().outimage();
                    sysout().outtext(new TXT$("            Erroneous values :"));
                    sysout().outint(i,3);
                    sysout().outint(n,3);
                    sysout().outimage();
                    found_error=true;
                }
            }
            n=Math.addExact(n,1);
        }
    }
    if(VALUE$(((i!=(7))|((n!=(5)))))) {
        {
            sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
            sysout().outimage();
            sysout().outtext(new TXT$("***         controlled variable - int real int(10)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneous values :"));
            sysout().outint(i,3);
            sysout().outint(n,3);
            sysout().outimage();
            found_error=true;
        }
    }
    n=1;
    for(boolean CB$193:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1))); }},new NAME$<Number>() { public Number get(){return(((float)(6))); }})
       )) { if(!CB$193) continue;
    {
        if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
            {
                sysout().outtext(new TXT$("*** error: Iteration - real int int(11)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outreal(r,4,11);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=Math.addExact(n,1);
    }
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
    {
        sysout().outtext(new TXT$("*** error: Number of iterations - real int int(12)."));
        sysout().outimage();
        sysout().outtext(new TXT$("            Erroneous values :"));
        sysout().outreal(r,4,11);
        sysout().outint(n,3);
        sysout().outimage();
        found_error=true;
    }
}
n=1;
for(i=(int)Math.round(3.14f);i<=(int)Math.round(6.0d);i++) {
    {
        if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
            {
                sysout().outtext(new TXT$("*** error: Iteration - int int lreal(13)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneous values :"));
                sysout().outint(i,3);
                sysout().outint(n,3);
                sysout().outimage();
                found_error=true;
            }
        }
        n=Math.addExact(n,1);
    }
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
    {
        sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
        sysout().outimage();
        sysout().outtext(new TXT$("***         controlled variable - int int lreal(14)."));
        sysout().outimage();
        sysout().outtext(new TXT$("            Erroneous values :"));
        sysout().outint(i,3);
        sysout().outint(n,3);
        sysout().outimage();
        found_error=true;
    }
}
n=1;
for(boolean CB$255:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0d)); }},new NAME$<Number>() { public Number get(){return(6); }})
   )) { if(!CB$255) continue;
{
    if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
        {
            sysout().outtext(new TXT$("*** error: Iteration - int lreal int(15)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneous values :"));
            sysout().outint(i,3);
            sysout().outint(n,3);
            sysout().outimage();
            found_error=true;
        }
    }
    n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
{
    sysout().outtext(new TXT$("*** error: Number of iterations or final value of  "));
    sysout().outimage();
    sysout().outtext(new TXT$("***         controlled variable - int lreal int(16)."));
    sysout().outimage();
    sysout().outtext(new TXT$("            Erroneous values :"));
    sysout().outint(i,3);
    sysout().outint(n,3);
    sysout().outimage();
    found_error=true;
}
}
n=1;
for(boolean CB$287:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1))); }},new NAME$<Number>() { public Number get(){return(((double)(6))); }})
   )) { if(!CB$287) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
    {
        sysout().outtext(new TXT$("*** error: Iteration - lreal int int(18)."));
        sysout().outimage();
        sysout().outtext(new TXT$("            Erroneous values :"));
        sysout().outreal(lr,4,11);
        sysout().outint(n,3);
        sysout().outimage();
        found_error=true;
    }
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal int int(19)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$319:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(6.0d)); }})
   )) { if(!CB$319) continue;
{
if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
{
    sysout().outtext(new TXT$("*** error: Iteration - int real lreal(20)."));
    sysout().outimage();
    sysout().outtext(new TXT$("            Erroneous values :"));
    sysout().outint(i,3);
    sysout().outint(n,3);
    sysout().outimage();
    found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - int real lreal(21)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$351:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0d)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(6.0f)); }})
   )) { if(!CB$351) continue;
{
if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - int lreal real(22)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - int lreal real(23)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$383:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1))); }},new NAME$<Number>() { public Number get(){return(((float)(6.0d))); }})
   )) { if(!CB$383) continue;
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real int lreal(24)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real int lreal(25)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$415:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1.0d))); }},new NAME$<Number>() { public Number get(){return(((float)(6))); }})
   )) { if(!CB$415) continue;
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real lreal int(26)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real lreal int(27)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$447:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1))); }},new NAME$<Number>() { public Number get(){return(((double)(6.0f))); }})
   )) { if(!CB$447) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal int real(28)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal int real(29)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$479:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1.0f))); }},new NAME$<Number>() { public Number get(){return(((double)(6))); }})
   )) { if(!CB$479) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal real int(30)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal real int(31)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(r=3.14f;r<=((float)(6));r++) {
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real real int(32)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real real int(33)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$543:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1))); }},new NAME$<Number>() { public Number get(){return(6.0f); }})
   )) { if(!CB$543) continue;
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real int real(34)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real int real(35)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$575:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(6.0f)); }})
   )) { if(!CB$575) continue;
{
if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - int real real(36)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - int real real(37)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(r=3.14f;r<=((float)(6.0d));r++) {
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real real lreal(38)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of "));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real real lreal(39)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$639:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1.0d))); }},new NAME$<Number>() { public Number get(){return(6.0f); }})
   )) { if(!CB$639) continue;
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real lreal real(40)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real lreal real(41)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$671:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1.0f))); }},new NAME$<Number>() { public Number get(){return(((double)(6.0f))); }})
   )) { if(!CB$671) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal real real(42)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal real real(43)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(lr=((double)(3.14f));lr<=((double)(6));lr++) {
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal lreal int(44)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal lreal int(45)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$735:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1))); }},new NAME$<Number>() { public Number get(){return(6.0d); }})
   )) { if(!CB$735) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal int lreal(46)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal int lreal(47)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$767:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((int)Math.round(3.14f)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(1.0d)); }},new NAME$<Number>() { public Number get(){return((int)Math.round(6.0d)); }})
   )) { if(!CB$767) continue;
{
if(VALUE$(((i!=(Math.addExact(n,2)))|((n>(4)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - int lreal lreal(48)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$(((i!=(7))|((n!=(5)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - int lreal lreal(49)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outint(i,3);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(lr=((double)(3.14f));lr<=((double)(6.0f));lr++) {
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal lreal real(50)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal lreal real(51)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$831:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){lr=(double)x$; return(x$);};  public Number get(){return((Number)lr); }	},new NAME$<Number>() { public Number get(){return(((double)(3.14f))); }},new NAME$<Number>() { public Number get(){return(((double)(1.0f))); }},new NAME$<Number>() { public Number get(){return(6.0d); }})
   )) { if(!CB$831) continue;
{
if(VALUE$((((lr<(((double)(((((float)(n))+(2.14f))-(eps))))))|((lr>(((double)(((((float)(n))+(2.14f))+(eps))))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - lreal real lreal(52)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((lr<(((double)((6.14f-(eps))))))|((lr>(((double)((6.14f+(eps))))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - lreal real lreal(53)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(lr,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=1;
for(boolean CB$863:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){r=(float)x$; return(x$);};  public Number get(){return((Number)r); }	},new NAME$<Number>() { public Number get(){return(3.14f); }},new NAME$<Number>() { public Number get(){return(((float)(1.0d))); }},new NAME$<Number>() { public Number get(){return(((float)(6.0d))); }})
   )) { if(!CB$863) continue;
{
if(VALUE$((((r<(((((float)(n))+(2.14f))-(eps))))|((r>(((((float)(n))+(2.14f))+(eps))))))|((n>(3)))))) {
{
sysout().outtext(new TXT$("*** error: Iteration - real lreal lreal(54)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
n=Math.addExact(n,1);
}
}
if(VALUE$((((r<((6.14f-(eps))))|((r>((6.14f+(eps))))))|((n!=(4)))))) {
{
sysout().outtext(new TXT$("*** error: Number of iterations or final value of"));
sysout().outimage();
sysout().outtext(new TXT$("***         controlled variable - real lreal lreal(55)."));
sysout().outimage();
sysout().outtext(new TXT$("            Erroneous values :"));
sysout().outreal(r,4,11);
sysout().outint(n,3);
sysout().outimage();
found_error=true;
}
}
if(VALUE$((!(found_error)))) {
{
sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 23"));
}
}
if(VALUE$(verbose)) {
{
sysout().outtext(new TXT$("--- END Simula a.s. TEST 23"));
sysout().outimage();
}
}
EBLK();
return(this);
}

public static void main(String[] args) {
RT.setRuntimeOptions(args);
new simtst23$(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst23.sim","SimulaProgram simtst23$",1,14,8,15,10,17,12,19,15,20,17,21,25,23,27,24,30,25,32,26,34,27,36,28,38,29,43,32,45,34,48,38,51,40,54,41,56,42,58,43,60,44,62,45,64,46,68,49,72,52,74,54,77,55,79,56,81,57,83,58,85,59,87,60,89,61,91,62,95,65,98,69,101,71,104,72,106,73,108,74,110,75,112,76,114,77,118,80,122,83,124,85,127,86,129,87,131,88,133,89,135,90,137,91,139,92,141,93,145,96,148,100,151,102,154,103,156,104,158,105,160,106,162,107,164,108,168,111,172,114,174,116,177,117,179,118,181,119,183,120,185,121,187,122,189,123,191,124,195,127,198,131,201,133,204,134,206,135,208,136,210,137,212,138,214,139,218,142,222,145,224,147,227,148,229,149,231,150,233,151,235,152,237,153,239,154,241,155,245,159,247,161,251,163,254,165,257,166,259,167,261,168,263,169,265,170,267,171,271,174,275,177,277,179,280,180,282,181,284,182,286,183,288,184,290,185,292,186,294,187,298,191,300,193,304,195,307,197,310,198,312,199,314,200,316,201,318,202,320,203,324,206,328,209,330,211,333,212,335,213,337,214,339,215,341,216,343,217,347,221,350,225,353,227,356,228,358,229,360,230,362,231,364,232,366,233,370,236,374,239,376,241,379,242,381,243,383,244,385,245,387,246,389,247,391,248,393,249,397,253,399,255,403,257,406,259,409,260,411,261,413,262,415,263,417,264,419,265,423,268,427,271,429,273,432,274,434,275,436,276,438,277,440,278,442,279,444,280,446,281,450,285,452,287,456,289,459,291,462,292,464,293,466,294,468,295,470,296,472,297,476,300,480,303,482,305,485,306,487,307,489,308,491,309,493,310,495,311,497,312,499,313,503,317,505,319,509,321,512,323,515,324,517,325,519,326,521,327,523,328,525,329,529,332,533,335,535,337,538,338,540,339,542,340,544,341,546,342,548,343,550,344,552,345,556,349,558,351,562,353,565,355,568,356,570,357,572,358,574,359,576,360,578,361,582,364,586,367,588,369,591,370,593,371,595,372,597,373,599,374,601,375,603,376,605,377,609,381,611,383,615,385,618,387,621,388,623,389,625,390,627,391,629,392,631,393,635,396,639,399,641,401,644,402,646,403,648,404,650,405,652,406,654,407,656,408,658,409,662,413,664,415,668,417,671,419,674,420,676,421,678,422,680,423,682,424,684,425,688,428,692,431,694,433,697,434,699,435,701,436,703,437,705,438,707,439,709,440,711,441,715,445,717,447,721,449,724,451,727,452,729,453,731,454,733,455,735,456,737,457,741,460,745,463,747,465,750,466,752,467,754,468,756,469,758,470,760,471,762,472,764,473,768,477,770,479,774,481,777,483,780,484,782,485,784,486,786,487,788,488,790,489,794,492,798,495,800,497,803,498,805,499,807,500,809,501,811,502,813,503,815,504,817,505,821,509,824,513,827,515,830,516,832,517,834,518,836,519,838,520,840,521,844,524,848,527,850,529,853,530,855,531,857,532,859,533,861,534,863,535,865,536,867,537,871,541,873,543,877,545,880,547,883,548,885,549,887,550,889,551,891,552,893,553,897,556,901,559,903,561,906,562,908,563,910,564,912,565,914,566,916,567,918,568,920,569,924,573,926,575,930,577,933,579,936,580,938,581,940,582,942,583,944,584,946,585,950,588,954,591,956,593,959,594,961,595,963,596,965,597,967,598,969,599,971,600,973,601,977,605,980,609,983,611,986,612,988,613,990,614,992,615,994,616,996,617,1000,620,1004,623,1006,625,1009,626,1011,627,1013,628,1015,629,1017,630,1019,631,1021,632,1023,633,1027,637,1029,639,1033,641,1036,643,1039,644,1041,645,1043,646,1045,647,1047,648,1049,649,1053,652,1057,655,1059,657,1062,658,1064,659,1066,660,1068,661,1070,662,1072,663,1074,664,1076,665,1080,669,1082,671,1086,673,1089,675,1092,676,1094,677,1096,678,1098,679,1100,680,1102,681,1106,684,1110,687,1112,689,1115,690,1117,691,1119,692,1121,693,1123,694,1125,695,1127,696,1129,697,1133,701,1136,705,1139,707,1142,708,1144,709,1146,710,1148,711,1150,712,1152,713,1156,716,1160,719,1162,721,1165,722,1167,723,1169,724,1171,725,1173,726,1175,727,1177,728,1179,729,1183,733,1185,735,1189,737,1192,739,1195,740,1197,741,1199,742,1201,743,1203,744,1205,745,1209,748,1213,751,1215,753,1218,754,1220,755,1222,756,1224,757,1226,758,1228,759,1230,760,1232,761,1236,765,1238,767,1242,769,1245,771,1248,772,1250,773,1252,774,1254,775,1256,776,1258,777,1262,780,1266,783,1268,785,1271,786,1273,787,1275,788,1277,789,1279,790,1281,791,1283,792,1285,793,1289,797,1292,801,1295,803,1298,804,1300,805,1302,806,1304,807,1306,808,1308,809,1312,812,1316,815,1318,817,1321,818,1323,819,1325,820,1327,821,1329,822,1331,823,1333,824,1335,825,1339,829,1341,831,1345,833,1348,835,1351,836,1353,837,1355,838,1357,839,1359,840,1361,841,1365,844,1369,847,1371,849,1374,850,1376,851,1378,852,1380,853,1382,854,1384,855,1386,856,1388,857,1392,861,1394,863,1398,865,1401,867,1404,868,1406,869,1408,870,1410,871,1412,872,1414,873,1418,876,1422,879,1424,881,1427,882,1429,883,1431,884,1433,885,1435,886,1437,887,1439,888,1441,889,1445,893,1447,895,1452,898,1454,899,1457,900,1468,903);
}
