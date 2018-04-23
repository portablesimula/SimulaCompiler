package testing;
// Simula Beta(0.1) Compiled at Mon Apr 23 21:36:30 CEST 2018
import simula.runtime.*;
   public class adHoc00$A extends CLASS$ {
      // BlockKind=Class, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
      // Declare parameters as attributes
      public int p1;
      public float p2;
      // Declare locals as attributes
      public $ARRAY<TXT$[]>TA=null;
      public int i=0;
      public float r=0.0f;
      // Normal Constructor
      public adHoc00$A(RTObject$ staticLink,int p1,float p2) {
         super(staticLink);
         // Parameter assignment to locals
         this.p1 = p1;
         this.p2 = p2;
         // Declaration Code
         int[] TA$LB={1}; int[] TA$UB={40};
         TA=new $ARRAY<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
         // Create Class Body
         CODE$=new ClassBody(CODE$,this) {
            public void STM() {
               BBLK(); // Iff no prefix
               i=4;
               if(inner!=null) inner.STM();
               r=((float)(6));
               EBLK(); // Iff no prefix
         }};
      }
      // Class Statements
      public adHoc00$A STM() { return((adHoc00$A)CODE$.EXEC$()); }
      public adHoc00$A START() { START(this); return(this); }
   }
