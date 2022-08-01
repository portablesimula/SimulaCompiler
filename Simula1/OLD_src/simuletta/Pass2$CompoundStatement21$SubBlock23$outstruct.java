// JavaLine 1 <== SourceLine 1522
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outstruct extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1522, lastLine=1577, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$record p$rec;
    public Head$ p$set;
    // Declare local labels
    // JavaLine 15 <== SourceLine 1568
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 18 <== SourceLine 1524
    Common$quant q=null;
    Common$elt_notice n=null;
    Common$variant v=null;
    // JavaLine 22 <== SourceLine 1525
    Linkage$ dentry=null;
    // JavaLine 24 <== SourceLine 1551
    Common$record inspect$1551$216=null;
    // JavaLine 26 <== SourceLine 1573
    Common$const$ inspect$1573$217=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outstruct.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$rec=(Common$record)objectValue(param); break;
                case 1: p$set=(Head$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outstruct(RTObject$ SL$,Common$record sp$rec,Head$ sp$set) {
        super(SL$);
        // Parameter assignment to locals
        this.p$rec = sp$rec;
        this.p$set = sp$set;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outstruct STM$() {
        Pass2$CompoundStatement21$SubBlock23$outstruct THIS$=(Pass2$CompoundStatement21$SubBlock23$outstruct)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 61 <== SourceLine 1551
                {
                    // BEGIN INSPECTION 
                    inspect$1551$216=p$rec;
                    if(inspect$1551$216!=null) // INSPECT inspect$1551$216
                    // JavaLine 66 <== SourceLine 1552
                    {
                        if(VALUE$((inspect$1551$216.prefbox$3!=(null)))) {
                            // JavaLine 69 <== SourceLine 1553
                            {
                                dentry=inspect$1551$216.prefbox$3.curmeaning;
                                ;
                                // JavaLine 73 <== SourceLine 1554
                                if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                                    // JavaLine 75 <== SourceLine 1555
                                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inspect$1551$216.prefbox$3.id).RESULT$;
                                }
                                ;
                                // JavaLine 79 <== SourceLine 1556
                                RESULT$=new Pass2$CompoundStatement21$SubBlock23$outstruct(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$record)(dentry)),p$set).RESULT$;
                                ;
                            }
                        }
                        ;
                        // JavaLine 85 <== SourceLine 1558
                        new Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset(((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$)),inspect$1551$216.atrset$3);
                        ;
                        // JavaLine 88 <== SourceLine 1559
                        if(VALUE$((!(inspect$1551$216.variantset$3.empty())))) {
                            // JavaLine 90 <== SourceLine 1560
                            {
                                for(boolean CB$1560:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=(Common$variant)x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(inspect$1551$216.variantset$3.first()); }})
                                   ,new WhileElt<Common$variant>(new NAME$<Common$variant>(){ public Common$variant put(Common$variant x$){v=x$; return(x$);};  public Common$variant get(){return((Common$variant)v); }	},new NAME$<Common$variant>() { public Common$variant get(){return(((Common$variant)(v.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                                   )) { if(!CB$1560) continue;
                                // JavaLine 96 <== SourceLine 1561
                                {
                                    if(VALUE$((!(v.atrset$2.empty())))) {
                                        // JavaLine 99 <== SourceLine 1562
                                        {
                                            for(boolean CB$1562:new ForList(
                                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=(Common$quant)x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(v.atrset$2.first()); }})
                                               ,new WhileElt<Common$quant>(new NAME$<Common$quant>(){ public Common$quant put(Common$quant x$){q=x$; return(x$);};  public Common$quant get(){return((Common$quant)q); }	},new NAME$<Common$quant>() { public Common$quant get(){return(((Common$quant)(q.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
                                               )) { if(!CB$1562) continue;
                                            // JavaLine 105 <== SourceLine 1564
                                            if(VALUE$((new Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt(((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$)),q.symb$2).RESULT$!=(null)))) {
                                                GOTO$(L); // GOTO EVALUATED LABEL
                                            }
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 117 <== SourceLine 1567
                        v=((Common$variant)(inspect$1551$216.variantset$3.first()));
                        ;
                        // JavaLine 120 <== SourceLine 1568
                        LABEL$(1,"L");
                        new Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset(((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$)),v.atrset$2);
                        ;
                    }
                }
                ;
                // JavaLine 127 <== SourceLine 1570
                if(VALUE$(p$rec.indefinite$3)) {
                    // JavaLine 129 <== SourceLine 1571
                    {
                        RESULT$=1;
                        ;
                        // JavaLine 133 <== SourceLine 1572
                        if(VALUE$((n!=(null)))) {
                            // JavaLine 135 <== SourceLine 1573
                            {
                                // BEGIN INSPECTION 
                                inspect$1573$217=n.p2$elt;
                                //INSPECT inspect$1573$217
                                if(inspect$1573$217 instanceof Common$repeated_const) // WHEN Common$repeated_const DO 
                                // JavaLine 141 <== SourceLine 1574
                                RESULT$=Math.addExact(((Common$repeated_const)(inspect$1573$217)).elt_set$4.cardinal(),1);
                                else // OTHERWISE 
                                RESULT$=2;
                            }
                        }
                        ;
                    }
                }
                ;
            }
        }
        break LOOP$;
    }
    catch(LABQNT$ q) {
        CUR$=THIS$;
        if(q.SL$!=CUR$) {
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("outstruct:NON-LOCAL",q);
            CUR$.STATE$=OperationalState.terminated;
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("outstruct:RE-THROW",q);
            throw(q);
        }
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("outstruct:LOCAL",q);
        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
    }
}
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure outstruct",1,1522,15,1568,18,1524,22,1525,24,1551,26,1573,61,1551,66,1552,69,1553,73,1554,75,1555,79,1556,85,1558,88,1559,90,1560,96,1561,99,1562,105,1564,117,1567,120,1568,127,1570,129,1571,133,1572,135,1573,141,1574,169,1577);
} // End of Procedure
