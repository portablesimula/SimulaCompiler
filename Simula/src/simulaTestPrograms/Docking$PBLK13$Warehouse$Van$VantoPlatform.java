// JavaLine 1 ==> SourceLine 89
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:06:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$VantoPlatform extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=89, lastLine=101, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$VantoPlatform(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoPlatform",89);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$VantoPlatform STM$() {
        TRACE_BEGIN_STM$("VantoPlatform",89);
        // JavaLine 23 ==> SourceLine 90
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.setColor(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)).black);
        // JavaLine 25 ==> SourceLine 91
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).drPos)),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLine)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 27 ==> SourceLine 92
        new Docking$PBLK13$Warehouse$Van$AnvanceQueue(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)));
        // JavaLine 29 ==> SourceLine 93
        if((((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength>(0))) {
            ((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength=(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength-(1));
        }
        // JavaLine 33 ==> SourceLine 95
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine=((((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).dLine1+(((((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).myDock.p2$nr-(1))*(20))))-(5));
        // JavaLine 35 ==> SourceLine 96
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).drPos)),((double)((((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine+(5)))),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 37 ==> SourceLine 98
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine=(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).dLine1+(((((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).myDock.p2$nr-(1))*(20))));
        // JavaLine 39 ==> SourceLine 99
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).pPos)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 41 ==> SourceLine 100
        new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is moved to plattform ...")));
        TRACE_END_STM$("VantoPlatform",100);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoPlatform",1,89,23,90,25,91,27,92,29,93,33,95,35,96,37,98,39,99,41,100,46,101);
}
