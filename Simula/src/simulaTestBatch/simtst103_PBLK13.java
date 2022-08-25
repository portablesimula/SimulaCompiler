package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:22:47 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103_PBLK13 extends _Simulation {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=2, firstLine=13, lastLine=72, hasLocalClasses=true, System=true, detachUsed=false
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 14
    public simtst103_simtst103_PBLK13_Car bil1_2=null;
    public simtst103_simtst103_PBLK13_Car bil2_2=null;
    public simtst103_simtst103_PBLK13_Car bil3_2=null;
    // JavaLine 15 <== SourceLine 15
    public _TXT t_2=null;
    // JavaLine 17 <== SourceLine 17
    public int traceCase_2=0;
    // JavaLine 19 <== SourceLine 18
    public _ARRAY<_TXT[]>facit=null;
    // Normal Constructor
    public simtst103_PBLK13(_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        // JavaLine 26 <== SourceLine 18
        int[] facit_LB=new int[1]; int[] facit_UB=new int[1];
        facit_LB[0]=0; facit_UB[0]=8;
        _BOUND_CHECK(facit_LB[0],facit_UB[0]);
        facit=new _ARRAY<_TXT[]>(new _TXT[facit_UB[0]-facit_LB[0]+1],facit_LB,facit_UB);
    }
    // Class Statements
    public simtst103_PBLK13 _STM() {
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class simtst103_PBLK13: Code before inner
        // JavaLine 37 <== SourceLine 48
        facit.Elt[0-facit.LB[0]]=new _TXT("  0.00: Bil-1: Run Fase-1");
        ;
        // JavaLine 40 <== SourceLine 49
        facit.Elt[1-facit.LB[0]]=new _TXT("  4.00: Bil-1: Run Fase-2");
        ;
        // JavaLine 43 <== SourceLine 50
        facit.Elt[2-facit.LB[0]]=new _TXT("  7.45: Bil-3: Run Fase-1");
        ;
        // JavaLine 46 <== SourceLine 51
        facit.Elt[3-facit.LB[0]]=new _TXT("  7.45: Bil-2: Run Fase-1");
        ;
        // JavaLine 49 <== SourceLine 52
        facit.Elt[4-facit.LB[0]]=new _TXT(" 11.45: Bil-3: Run Fase-2");
        ;
        // JavaLine 52 <== SourceLine 53
        facit.Elt[5-facit.LB[0]]=new _TXT(" 11.45: Bil-2: Run Fase-2");
        ;
        // JavaLine 55 <== SourceLine 54
        facit.Elt[6-facit.LB[0]]=new _TXT(" 16.00: Bil-1: Terminates");
        ;
        // JavaLine 58 <== SourceLine 55
        facit.Elt[7-facit.LB[0]]=new _TXT(" 23.45: Bil-3: Terminates");
        ;
        // JavaLine 61 <== SourceLine 56
        facit.Elt[8-facit.LB[0]]=new _TXT(" 23.45: Bil-2: Terminates");
        ;
        // JavaLine 64 <== SourceLine 58
        ((simtst103_PBLK13)(_CUR)).ActivateDirect(false,(_Process)bil1_2);
        ;
        // JavaLine 67 <== SourceLine 60
        bil1_2=((simtst103_simtst103_PBLK13_Car)new simtst103_simtst103_PBLK13_Car((_CUR),new _TXT("Bil-1"))._START());
        ;
        // JavaLine 70 <== SourceLine 61
        ((simtst103_PBLK13)(_CUR)).ActivateDirect(false,(_Process)bil1_2);
        ;
        // JavaLine 73 <== SourceLine 62
        bil2_2=((simtst103_simtst103_PBLK13_Car)new simtst103_simtst103_PBLK13_Car((_CUR),new _TXT("Bil-2"))._START());
        ;
        // JavaLine 76 <== SourceLine 63
        bil3_2=((simtst103_simtst103_PBLK13_Car)new simtst103_simtst103_PBLK13_Car((_CUR),new _TXT("Bil-3"))._START());
        ;
        // JavaLine 79 <== SourceLine 64
        ((simtst103_PBLK13)(_CUR)).ActivateAt(false,(_Process)bil2_2,7.45f,false);
        ;
        // JavaLine 82 <== SourceLine 65
        ((simtst103_PBLK13)(_CUR)).ActivateAt(false,(_Process)bil3_2,7.45f,true);
        ;
        // JavaLine 85 <== SourceLine 66
        ((simtst103_PBLK13)(_CUR)).ActivateDelay(false,(_Process)bil2_2,1.23f,false);
        ;
        // JavaLine 88 <== SourceLine 67
        ((simtst103_PBLK13)(_CUR)).ActivateDelay(false,(_Process)bil3_2,1.23f,true);
        ;
        // JavaLine 91 <== SourceLine 68
        ((simtst103_PBLK13)(_CUR)).ActivateBefore(false,(_Process)bil2_2,(_Process)bil1_2);
        ;
        // JavaLine 94 <== SourceLine 69
        ((simtst103_PBLK13)(_CUR)).ActivateAfter(false,(_Process)bil3_2,(_Process)bil1_2);
        ;
        // JavaLine 97 <== SourceLine 70
        hold(100.0d);
        ;
        EBLK();
        return(this);
    } // End of Class Statements
    public static _PROGINFO INFO_=new _PROGINFO("simtst103.sim","PrefixedBlock simtst103_PBLK13",11,14,15,15,17,17,19,18,26,18,37,48,40,49,43,50,46,51,49,52,52,53,55,54,58,55,61,56,64,58,67,60,70,61,73,62,76,63,79,64,82,65,85,66,88,67,91,68,94,69,97,70,102,72);
} // End of Class
