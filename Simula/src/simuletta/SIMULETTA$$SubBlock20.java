// JavaLine 1 <== SourceLine 20
package simuletta;
// Simula-1.0 Compiled at Sun Apr 19 14:20:37 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SIMULETTA$$SubBlock20 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=2, firstLine=20, lastLine=57, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ q=null;
    // Normal Constructor
    public SIMULETTA$$SubBlock20(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 21
        ((SIMULETTA$)(CUR$.SL$)).inspect$19$0.option.Elt[rank('Y')-((SIMULETTA$)(CUR$.SL$)).inspect$19$0.option.LB[0]]=1;
        ;
        // JavaLine 21 <== SourceLine 23
        new Pass1(((ENVIRONMENT$)CTX$),((Common)((SIMULETTA$)(CUR$.SL$)).inspect$19$0));
        ;
        // JavaLine 24 <== SourceLine 25
        for(boolean CB$25:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(((SIMULETTA$)(CUR$.SL$)).inspect$19$0.qntset$1.first()); }})
           ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(q.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
           )) { if(!CB$25) continue;
        new Common$prt(((SIMULETTA$)(CUR$.SL$)).inspect$19$0,q,0);
    }
    ;
    // JavaLine 32 <== SourceLine 27
    new Pass2(((ENVIRONMENT$)CTX$),((Common)((SIMULETTA$)(CUR$.SL$)).inspect$19$0));
    ;
    // JavaLine 35 <== SourceLine 29
    if(VALUE$(((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.option.Elt[rank('Y')-((SIMULETTA$)(CUR$.SL$)).inspect$19$0.option.LB[0]]!=(0))|((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1!=(0)))))) {
        // JavaLine 37 <== SourceLine 31
        {
            if(VALUE$((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.curline$1>(0)))) {
                // JavaLine 40 <== SourceLine 32
                {
                    sysout().outtext(new TXT$(", lines: "));
                    ;
                    sysout().outtext(new Common$leftint(((SIMULETTA$)(CUR$.SL$)).inspect$19$0,((SIMULETTA$)(CUR$.SL$)).inspect$19$0.curline$1).RESULT$);
                }
            }
            ;
            // JavaLine 48 <== SourceLine 33
            if(VALUE$((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1!=(0)))) {
                // JavaLine 50 <== SourceLine 34
                {
                    sysout().outtext(new TXT$(" , "));
                    ;
                    sysout().outtext(new Common$leftint(((SIMULETTA$)(CUR$.SL$)).inspect$19$0,((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1).RESULT$);
                    ;
                }
            } else
            // JavaLine 58 <== SourceLine 35
            sysout().outtext(new TXT$(" no"));
            ;
            // JavaLine 61 <== SourceLine 36
            sysout().outtext(new TXT$(" errors."));
            ;
            // JavaLine 64 <== SourceLine 37
            sysout().outimage();
            ;
        }
    }
    ;
    // JavaLine 70 <== SourceLine 41
    if(VALUE$((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.ListFile$1==(null)))) {
        ;
    } else
    // JavaLine 74 <== SourceLine 42
    if(VALUE$((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.ListFile$1!=(sysout())))) {
        ((SIMULETTA$)(CUR$.SL$)).inspect$19$0.ListFile$1.close();
    }
    ;
    // JavaLine 79 <== SourceLine 49
    if(VALUE$(((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1!=(0))&&((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.termstatus$1==(0)))))) {
        ((SIMULETTA$)(CUR$.SL$)).inspect$19$0.termstatus$1=4;
    }
    ;
    // JavaLine 84 <== SourceLine 53
    if(VALUE$((((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1>(0)))) {
        // JavaLine 86 <== SourceLine 54
        {
            sysout().outtext(CONC(CONC(new TXT$("Program Terminated due to "),new Common$leftint(((SIMULETTA$)(CUR$.SL$)).inspect$19$0,((SIMULETTA$)(CUR$.SL$)).inspect$19$0.nerr$1).RESULT$),new TXT$(" Errors")));
            ;
            sysout().outimage();
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("SIMULETTA.sim","SubBlock SubBlock20",1,20,18,21,21,23,24,25,32,27,35,29,37,31,40,32,48,33,50,34,58,35,61,36,64,37,70,41,74,42,79,49,84,53,86,54,97,57);
} // End of SubBlock
