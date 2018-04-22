package testing;
// Simula Beta(0.1) Compiled at Sun Apr 22 15:06:38 CEST 2018
import simula.runtime.*;
   public class adHoc00$A extends CLASS$ {
      // BlockKind=Class, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
      // Declare parameters as attributes
      // Declare locals as attributes
      // Normal Constructor
      public adHoc00$A(RTObject$ staticLink) {
         super(staticLink);
         // Parameter assignment to locals
         // Declaration Code
         // Create Class Body
         CODE$=new ClassBody(CODE$,this) {
            public void STM() {
               BBLK(); // Iff no prefix
               if(inner!=null) inner.STM();
               EBLK(); // Iff no prefix
         }};
      }
      // Class Statements
      public adHoc00$A STM() { return((adHoc00$A)CODE$.EXEC$()); }
      public adHoc00$A START() { START(this); return(this); }
   }
