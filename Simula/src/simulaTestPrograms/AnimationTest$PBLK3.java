package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class AnimationTest$PBLK3 extends Drawing$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    ShapeElement$ elt1$2=null;
    ShapeElement$ elt2$2=null;
    ShapeElement$ elt3$2=null;
    TextElement$ txt1$2=null;
    double x1$2=0.0d;
    double y1$2=0.0d;
    public AnimationTest$PBLK3(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        BPRG("AnimationTest$PBLK3");
    }
    public AnimationTest$PBLK3 STM$() {
        setBackgroundColor(lightGray$1);
        setStroke(4.5f);
        setDrawColor(red$1);
        setFillColor(magenta$1);
        elt2$2=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
        elt2$2.fillRectangle(((double)(100)),((double)(100)),((double)(200)),((double)(50)));
        setFillColor(blue$1);
        elt3$2=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
        elt3$2.fillRoundRectangle(((double)(100)),((double)(100)),((double)(200)),((double)(50)),((double)(50)),((double)(50)));
        setDrawColor(black$1);
        elt1$2=new ShapeElement$(((AnimationTest$PBLK3)CUR$)).STM$();
        elt1$2.drawEllipse(((double)(10)),((double)(10)),((double)(200)),((double)(50)));
        setFontSize(((float)(24)));
        setDrawColor(orange$1);
        setFontStyleBoldItalic();
        txt1$2=new TextElement$(((AnimationTest$PBLK3)CUR$),new TXT$("Abracadabra"),((double)(200)),((double)(100))).STM$();
        while((elt1$2!=(null))) {
            {
                elt3$2.moveTo(((double)(800)),((double)(800)),((double)(500)));
                elt1$2.moveTo(((double)(800)),((double)(800)),((double)(500)));
                elt1$2.moveTo(((double)(80)),((double)(80)),((double)(500)));
                elt3$2.moveTo(((double)(80)),((double)(80)),((double)(300)));
                elt1$2.moveTo(((double)(800)),((double)(800)),((double)(500)));
                elt2$2.moveTo(((double)(800)),((double)(800)),((double)(700)));
                elt1$2.moveTo(((double)(80)),((double)(800)),((double)(500)));
                elt2$2.moveTo(((double)(600)),((double)(10)),((double)(700)));
                txt1$2.instantMoveTo(((double)(300)),((double)(700)));
                elt3$2.moveTo(((double)(200)),((double)(10)),((double)(400)));
                elt1$2.moveTo(((double)(10)),((double)(10)),((double)(500)));
                txt1$2.setColor(red$1);
                txt1$2.moveTo(((double)(100)),((double)(400)),((double)(500)));
                elt2$2.moveTo(((double)(100)),((double)(100)),((double)(700)));
                txt1$2.moveTo(((double)(200)),((double)(100)),((double)(500)));
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new AnimationTest$PBLK3(CTX$,new TXT$("Animation Test"),900,900).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("AnimationTest.sim","PrefixedBlock AnimationTest$PBLK3",1,3,12,4,14,5,22,7,24,8,26,9,28,10,30,12,32,13,34,15,36,16,38,17,40,19,42,20,44,21,46,22,48,23,50,24,52,25,54,27,56,29,59,30,61,31,63,32,65,33,67,34,69,35,71,36,73,37,75,38,77,39,79,40,81,41,83,42,85,43,96,46);
}
