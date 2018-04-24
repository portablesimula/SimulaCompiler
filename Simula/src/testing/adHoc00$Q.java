package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 17:02:40 CEST 2018
import simula.runtime.*;
   public class adHoc00$Q extends RTObject$ {
      // BlockKind=Procedure, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
      // Declare parameters as attributes
      public $PRCQNT F;
      // Declare locals as attributes
      int i=0;
      // Parameter Transmission in case of Formal/Virtual Procedure Call
      private int $npar=0; // Number of actual parameters transmitted.
      public adHoc00$Q setPar(Object param)
      { //Util.BREAK("CALL adHoc00$Q.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL);
        try { switch($npar++) {
    	      case 0: F=($PRCQNT)param; break;
    	      default: throw new RuntimeException("Wrong number of parameters");
        } } catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
      }
      // Constructor in case of Formal/Virtual Procedure Call
      public adHoc00$Q(RTObject$ staticLink)
      { super(staticLink); }
      // Normal Constructor
      public adHoc00$Q(RTObject$ staticLink,$PRCQNT F) {
         super(staticLink);
         // Parameter assignment to locals
         this.F = F;
         // Declaration Code
         STM();
      }
      // Procedure Statements
      public adHoc00$Q STM() {
         BBLK();
         i=intValue(F.CPF().setPar(new $NAME<Integer>(){ public Integer get() { return(4); } }).setPar(new $NAME<Double>(){ public Double get() { return(3.14); } }).STM().$result());
         EBLK();
         return(this);
      }
   }
