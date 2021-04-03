// JavaLine 1 <== SourceLine 1996
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:58:29 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$SubBlock1996 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1996, lastLine=2006, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$module m=null;
    Common$descr d=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$SubBlock1996(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 1997
        for(boolean CB$1997:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){m=(Common$module)x$; return(x$);};  public Link$ get(){return((Link$)m); }	},new NAME$<Link$>() { public Link$ get(){return(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.modset$1.first()); }})
           ,new WhileElt<Common$module>(new NAME$<Common$module>(){ public Common$module put(Common$module x$){m=x$; return(x$);};  public Common$module get(){return((Common$module)m); }	},new NAME$<Common$module>() { public Common$module get(){return(((Common$module)(m.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((m!=(null))); }})
           )) { if(!CB$1997) continue;
        // JavaLine 24 <== SourceLine 1998
        {
            // BEGIN INSPECTION 
            ((Pass2)(CUR$.SL$.SL$)).inspect$1998$227=m;
            if(((Pass2)(CUR$.SL$.SL$)).inspect$1998$227!=null) // INSPECT inspect$1998$227
            // JavaLine 29 <== SourceLine 1999
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.system$2)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SYSINSERT$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INSERT$1)));
                ;
                // JavaLine 33 <== SourceLine 2000
                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.p2$modid);
                ;
                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.modcode$2);
                ;
                // JavaLine 38 <== SourceLine 2001
                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("?"));
                ;
                // JavaLine 41 <== SourceLine 2003
                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,Math.addExact(((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.bias$2,1));
                ;
                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,Math.addExact(((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.bias$2,((Pass2)(CUR$.SL$.SL$)).inspect$1998$227.ntag$2));
                ;
                // JavaLine 46 <== SourceLine 2004
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
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock1996",1,1996,19,1997,24,1998,29,1999,33,2000,38,2001,41,2003,46,2004,57,2006);
} // End of SubBlock
