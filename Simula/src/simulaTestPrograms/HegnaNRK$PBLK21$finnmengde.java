// JavaLine 1 ==> SourceLine 1346
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finnmengde extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1346, lastLine=1374, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1348
    int i=0;
    int antall=0;
    int funn=0;
    // JavaLine 15 ==> SourceLine 1349
    HegnaNRK$PBLK21$liste_element lise=null;
    // JavaLine 17 ==> SourceLine 1350
    Head$ liste_mengde=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$finnmengde(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finnmengde",1350);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finnmengde STM$() {
        TRACE_BEGIN_STM$("finnmengde",1350);
        // JavaLine 31 ==> SourceLine 1351
        antall=0;
        // JavaLine 33 ==> SourceLine 1352
        new HegnaNRK$PBLK21$les_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 35 ==> SourceLine 1353
        liste_mengde=new Head$(((HegnaNRK$PBLK21)(CUR$.SL$))).STM$();
        // JavaLine 37 ==> SourceLine 1354
        funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),0).RESULT$;
        // JavaLine 39 ==> SourceLine 1355
        while((funn!=(0))) {
            // JavaLine 41 ==> SourceLine 1357
            {
                TRACE_BEGIN_STM$("CompoundStatement1357",1357);
                antall=(antall+(1));
                // JavaLine 45 ==> SourceLine 1358
                new HegnaNRK$PBLK21$liste_element(((HegnaNRK$PBLK21)(CUR$.SL$)),funn).STM$().into(liste_mengde);
                // JavaLine 47 ==> SourceLine 1359
                funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn).RESULT$;
                TRACE_END_STM$("CompoundStatement1357",1359);
            }
        }
        // JavaLine 52 ==> SourceLine 1361
        sysout().outtext(new TXT$("Antall poster i mengden:"));
        sysout().outint(antall,5);
        // JavaLine 55 ==> SourceLine 1362
        sysout().outimage();
        // JavaLine 57 ==> SourceLine 1363
        if(VALUE$((antall==(0)))) {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).mengde=null;
        } else
        // JavaLine 61 ==> SourceLine 1366
        {
            TRACE_BEGIN_STM$("CompoundStatement1366",1366);
            ((HegnaNRK$PBLK21)(CUR$.SL$)).mengde=new HegnaNRK$PBLK21$tabell_mengde(((HegnaNRK$PBLK21)(CUR$.SL$)),antall).STM$();
            // JavaLine 65 ==> SourceLine 1367
            for(boolean CB$1367:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(antall); }})
               )) { if(!CB$1367) continue;
            // JavaLine 69 ==> SourceLine 1369
            {
                TRACE_BEGIN_STM$("CompoundStatement1369",1369);
                lise=((HegnaNRK$PBLK21$liste_element)(liste_mengde.first()));
                // JavaLine 73 ==> SourceLine 1370
                lise.out();
                // JavaLine 75 ==> SourceLine 1371
                ((ARRAY$<int[]>)((HegnaNRK$PBLK21)(CUR$.SL$)).mengde.tabell).Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).mengde.tabell.LB[0]]=lise.p2$nr;
                TRACE_END_STM$("CompoundStatement1369",1371);
            }
        }
        TRACE_END_STM$("CompoundStatement1366",1371);
    }
    TRACE_END_STM$("finnmengde",1371);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finnmengde",1,1346,11,1348,15,1349,17,1350,31,1351,33,1352,35,1353,37,1354,39,1355,41,1357,45,1358,47,1359,52,1361,55,1362,57,1363,61,1366,65,1367,69,1369,73,1370,75,1371,85,1374);
}
