// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:19:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class AnimationTest$PBLK3 extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=3, lastLine=46, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    ShapeElement$ elt1=null;
    ShapeElement$ elt2=null;
    ShapeElement$ elt3=null;
    // JavaLine 15 ==> SourceLine 4
    TextElement$ txt1=null;
    // JavaLine 17 ==> SourceLine 5
    double x1=0.0d;
    double y1=0.0d;
    // Normal Constructor
    public AnimationTest$PBLK3(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        BPRG("AnimationTest$PBLK3");
        // Declaration Code
        TRACE_BEGIN_DCL$("AnimationTest$PBLK3",5);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("AnimationTest$PBLK3",5,inner);
                // JavaLine 31 ==> SourceLine 7
                setBackgroundColor(lightGray);
                // JavaLine 33 ==> SourceLine 8
                setStroke(4.5f);
                // JavaLine 35 ==> SourceLine 9
                setDrawColor(red);
                // JavaLine 37 ==> SourceLine 10
                setFillColor(magenta);
                // JavaLine 39 ==> SourceLine 12
                elt2=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
                // JavaLine 41 ==> SourceLine 13
                elt2.fillRectangle(((double)(100)),((double)(100)),((double)(200)),((double)(50)));
                // JavaLine 43 ==> SourceLine 15
                setFillColor(blue);
                // JavaLine 45 ==> SourceLine 16
                elt3=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
                // JavaLine 47 ==> SourceLine 17
                elt3.fillRoundRectangle(((double)(100)),((double)(100)),((double)(200)),((double)(50)),((double)(50)),((double)(50)));
                // JavaLine 49 ==> SourceLine 19
                setDrawColor(black);
                // JavaLine 51 ==> SourceLine 20
                elt1=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
                // JavaLine 53 ==> SourceLine 21
                elt1.drawEllipse(((double)(10)),((double)(10)),((double)(200)),((double)(50)));
                // JavaLine 55 ==> SourceLine 22
                setFontSize(((float)(24)));
                // JavaLine 57 ==> SourceLine 23
                setDrawColor(orange);
                // JavaLine 59 ==> SourceLine 24
                setFontStyleBoldItalic();
                // JavaLine 61 ==> SourceLine 25
                txt1=new TextElement$(((AnimationTest$PBLK3)CUR$),new TXT$("Abracadabra"),((double)(200)),((double)(100))).STM$();
                // JavaLine 63 ==> SourceLine 27
                while((elt1!=(null))) {
                    // JavaLine 65 ==> SourceLine 29
                    {
                        TRACE_BEGIN_STM$("CompoundStatement29",29);
                        elt3.moveTo(((double)(800)),((double)(800)),((double)(500)));
                        // JavaLine 69 ==> SourceLine 30
                        elt1.moveTo(((double)(800)),((double)(800)),((double)(500)));
                        // JavaLine 71 ==> SourceLine 31
                        elt1.moveTo(((double)(80)),((double)(80)),((double)(500)));
                        // JavaLine 73 ==> SourceLine 32
                        elt3.moveTo(((double)(80)),((double)(80)),((double)(300)));
                        // JavaLine 75 ==> SourceLine 33
                        elt1.moveTo(((double)(800)),((double)(800)),((double)(500)));
                        // JavaLine 77 ==> SourceLine 34
                        elt2.moveTo(((double)(800)),((double)(800)),((double)(700)));
                        // JavaLine 79 ==> SourceLine 35
                        elt1.moveTo(((double)(80)),((double)(800)),((double)(500)));
                        // JavaLine 81 ==> SourceLine 36
                        elt2.moveTo(((double)(600)),((double)(10)),((double)(700)));
                        // JavaLine 83 ==> SourceLine 37
                        txt1.instantMoveTo(((double)(300)),((double)(700)));
                        // JavaLine 85 ==> SourceLine 38
                        elt3.moveTo(((double)(200)),((double)(10)),((double)(400)));
                        // JavaLine 87 ==> SourceLine 39
                        elt1.moveTo(((double)(10)),((double)(10)),((double)(500)));
                        // JavaLine 89 ==> SourceLine 40
                        txt1.setColor(red);
                        // JavaLine 91 ==> SourceLine 41
                        txt1.moveTo(((double)(100)),((double)(400)),((double)(500)));
                        // JavaLine 93 ==> SourceLine 42
                        elt2.moveTo(((double)(100)),((double)(100)),((double)(700)));
                        // JavaLine 95 ==> SourceLine 43
                        txt1.moveTo(((double)(200)),((double)(100)),((double)(500)));
                        TRACE_END_STM$("CompoundStatement29",43);
                    }
                }
                TRACE_END_STM$("AnimationTest$PBLK3",43);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new AnimationTest$PBLK3(CTX$,new TXT$("Animation Test"),900,900).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("AnimationTest.sim","PrefixedBlock AnimationTest$PBLK3",1,3,15,4,17,5,31,7,33,8,35,9,37,10,39,12,41,13,43,15,45,16,47,17,49,19,51,20,53,21,55,22,57,23,59,24,61,25,63,27,65,29,69,30,71,31,73,32,75,33,77,34,79,35,81,36,83,37,85,38,87,39,89,40,91,41,93,42,95,43,109,46);
}
