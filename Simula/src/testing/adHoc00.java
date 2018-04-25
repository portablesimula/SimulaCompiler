package testing;
// Simula Beta(0.1) Compiled at Wed Apr 25 11:14:37 CEST 2018
import simula.runtime.*;
public class adHoc00 extends RTObject$ {
   // BlockKind=SimulaProgram, BlockLevel=1, hasLocalClasses=true, System=true, detachUsed=false
   public boolean isQPSystemBlock() { return(true); }
   // Declare parameters as attributes
   // Declare locals as attributes
   int i=0;
   // Normal Constructor
   public adHoc00(RTObject$ staticLink) {
      super(staticLink);
      // Parameter assignment to locals
      // Declaration Code
   }
   // SimulaProgram Statements
   public RTObject$ STM() {
      BPRG("adHoc00");
      i=new adHoc00$P(((adHoc00)PRG$),4,((float)(3.14))).$result;
      sysout().outtext(new TXT$("Hallo fra meg åsså !!!"));
      EBLK();
      return(null);
   }

   public static void main(String[] args) {
     new adHoc00(CTX$).STM();
   }
}
