package testing;
// Simula Beta(0.1) Compiled at Wed Apr 25 11:14:37 CEST 2018
import simula.runtime.*;
   public class adHoc00$P extends RTObject$ {
      // BlockKind=Procedure, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
      // Declare return value as attribute
      public int $result;
      public Object $result() { return($result); }
      // Declare parameters as attributes
      public int p1;
      public float p2;
      // Declare locals as attributes
      public $ARRAY<TXT$[]>TA=null;
      int i=0;
      // Parameter Transmission in case of Formal/Virtual Procedure Call
      private int $npar=0; // Number of actual parameters transmitted.
      public adHoc00$P setPar(Object param)
      { //Util.BREAK("CALL adHoc00$P.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL);
        try { switch($npar++) {
    	      case 0: p1=intValue(param); break;
    	      case 1: p2=floatValue(param); break;
    	      default: throw new RuntimeException("Wrong number of parameters");
        } } catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
      }
      // Constructor in case of Formal/Virtual Procedure Call
      public adHoc00$P(RTObject$ staticLink)
      { super(staticLink); }
      // Normal Constructor
      public adHoc00$P(RTObject$ staticLink,int p1,float p2) {
         super(staticLink);
         // Parameter assignment to locals
         this.p1 = p1;
         this.p2 = p2;
         // Declaration Code
         int[] TA$LB={1}; int[] TA$UB={40};
         TA=new $ARRAY<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
         STM();
      }
      // Procedure Statements
      public adHoc00$P STM() {
         BBLK();
         $result=p1;
         i=6;
         EBLK();
         return(this);
      }
   }
