// JavaLine 1 <== SourceLine 1995
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$SubBlock1995 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1995, lastLine=2005, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$module m=null;
    Common$descr d=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$SubBlock1995(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 1996
        for(boolean CB$1996:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){m=(Common$module)x$; return(x$);};  public Link$ get(){return((Link$)m); }	},new NAME$<Link$>() { public Link$ get(){return(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.modset$1.first()); }})
           ,new WhileElt<Common$module>(new NAME$<Common$module>(){ public Common$module put(Common$module x$){m=x$; return(x$);};  public Common$module get(){return((Common$module)m); }	},new NAME$<Common$module>() { public Common$module get(){return(((Common$module)(m.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((m!=(null))); }})
           )) { if(!CB$1996) continue;
        // JavaLine 24 <== SourceLine 1997
        {
            // BEGIN INSPECTION 
            ((Pass2)(CUR$.SL$.SL$)).inspect$1997$227=m;
            if(((Pass2)(CUR$.SL$.SL$)).inspect$1997$227!=null) // INSPECT inspect$1997$227
            // JavaLine 29 <== SourceLine 1998
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.system$2)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SYSINSERT$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INSERT$1)));
                ;
                // JavaLine 33 <== SourceLine 1999
                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.p2$modid);
                ;
                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.modcode$2);
                ;
                // JavaLine 38 <== SourceLine 2000
                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("?"));
                ;
                // JavaLine 41 <== SourceLine 2002
                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,Math.addExact(((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.bias$2,1));
                ;
                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,Math.addExact(((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.bias$2,((Pass2)(CUR$.SL$.SL$)).inspect$1997$227.ntag$2));
                ;
                // JavaLine 46 <== SourceLine 2003
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                }
                ;
            }
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock1995",1,1995,19,1996,24,1997,29,1998,33,1999,38,2000,41,2002,46,2003,57,2005);
} // End of SubBlock
