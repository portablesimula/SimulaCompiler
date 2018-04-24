package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 17:02:40 CEST 2018
import simula.runtime.*;
   public class adHoc00$A extends CLASS$ {
      // BlockKind=Class, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
      // Declare parameters as attributes
      public int p1;
      public float p2;
      // Declare locals as attributes
      public $NARRAY<TXT$[]>TA=null;
      public int i=0;
      public TXT$ t=null;
      public float r=0.0f;
      // Normal Constructor
      public adHoc00$A(RTObject$ staticLink,int p1,float p2) {
         super(staticLink);
         // Parameter assignment to locals
         this.p1 = p1;
         this.p2 = p2;
         // Declaration Code
         TA=new $NARRAY<TXT$[]>(new TXT$[40-p1+(1)+1],p1+(1));
         // Create Class Body
         CODE$=new ClassBody(CODE$,this) {
            public void STM() {
               BBLK(); // Iff no prefix
               i=4;
               t=TA.Elt[13-p1+(1)];
               TA.Elt[13-p1+(1)]=t;
               if(inner!=null) inner.STM();
               r=((float)(6));
               EBLK(); // Iff no prefix
         }};
      }
      // Class Statements
      public adHoc00$A STM() { return((adHoc00$A)CODE$.EXEC$()); }
      public adHoc00$A START() { START(this); return(this); }
   }
