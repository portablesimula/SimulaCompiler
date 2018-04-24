package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 16:58:33 CEST 2018
import simula.runtime.*;
public class simtst21 extends RTObject$ {
   // BlockKind=SimulaProgram, BlockLevel=1, hasLocalClasses=false, System=false, detachUsed=false
   // Declare parameters as attributes
   // Declare locals as attributes
   boolean found_error=false;
   int i=0;
   int j=0;
   // Normal Constructor
   public simtst21(RTObject$ staticLink) {
      super(staticLink);
      // Parameter assignment to locals
      // Declaration Code
   }
   // SimulaProgram Statements
   public RTObject$ STM() {
      BPRG("simtst21");
      sysout().outtext(new TXT$("--- START Simula a.s. TEST 21"));
      sysout().outimage();
      sysout().outtext(new TXT$("--- Test arrays of simple types and text."));
      sysout().outimage();
      sysout().outimage();
      new simtst21$SubBlock32(PRG$).STM();
      i=10;
      new simtst21$SubBlock115(PRG$).STM();
      new simtst21$SubBlock165(PRG$).STM();
      if(found_error) {
      } else
         {
         sysout().outtext(new TXT$("--- NO ERRORS FOUND IN THIS TEST"));
         sysout().outimage();
         }
      sysout().outtext(new TXT$("--- END Simula a.s. TEST 21"));
      sysout().outimage();
      EBLK();
      return(null);
   }

   public static void main(String[] args) {
     new simtst21(CTX$).STM();
   }
}
