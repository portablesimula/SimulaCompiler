package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 16:58:33 CEST 2018
import simula.runtime.*;
      public class simtst21$SubBlock32 extends RTObject$ {
         // BlockKind=SubBlock, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
         // Declare parameters as attributes
         // Declare locals as attributes
         public $NARRAY<int[]>A=null;
         public $NARRAY<int[]>B=null;
         // Normal Constructor
         public simtst21$SubBlock32(RTObject$ staticLink) {
            super(staticLink);
            // Parameter assignment to locals
            // Declaration Code
            A=new $NARRAY<int[]>(new int[((simtst21)PRG$).j+(3)-((simtst21)PRG$).i-(3)+1],((simtst21)PRG$).i-(3));
            B=new $NARRAY<int[]>(new int[((simtst21)PRG$).j+(3)-((simtst21)PRG$).i-(3)+1],((simtst21)PRG$).i-(3));
         }
         // SubBlock Statements
         public RTObject$ STM() {
            BBLK();
            for(((simtst21)PRG$).i=3;((simtst21)PRG$).i<=(-(3));((simtst21)PRG$).i=((simtst21)PRG$).i+(-(1))) {
               A.Elt[(-(((simtst21)PRG$).i))-A.LB[0]]=B.Elt[((simtst21)PRG$).i-B.LB[0]]=((simtst21)PRG$).i;
            }
            if(A.Elt[(-(2))-A.LB[0]]+(B.Elt[(-(2))-B.LB[0]])==(0)) {
            } else
               {
               sysout().outtext(new TXT$("*** error : Integer Array (1)."));
               sysout().outimage();
               sysout().outtext(new TXT$("            Erroneus values : "));
               sysout().outimage();
               for(((simtst21)PRG$).i=(-(3));((simtst21)PRG$).i<=3;((simtst21)PRG$).i=((simtst21)PRG$).i+1) {
                  {
                  sysout().outint(((simtst21)PRG$).i,13);
                  sysout().outint(((simtst21$SubBlock32)CV$[2]).A.Elt[((simtst21)PRG$).i-((simtst21$SubBlock32)CV$[2]).A.LB[0]],4);
                  sysout().outint(((simtst21$SubBlock32)CV$[2]).B.Elt[((simtst21)PRG$).i-((simtst21$SubBlock32)CV$[2]).B.LB[0]],4);
                  sysout().outimage();
                  }
               }
               ((simtst21)PRG$).found_error=true;
               }
            for(((simtst21)PRG$).i=0;((simtst21)PRG$).i<=18;((simtst21)PRG$).i=((simtst21)PRG$).i+3) {
               {
               ((simtst21)PRG$).j=((simtst21$SubBlock32)CV$[2]).A.Elt[((simtst21)PRG$).i/(3)-(3)-((simtst21$SubBlock32)CV$[2]).A.LB[0]]+(((simtst21$SubBlock32)CV$[2]).B.Elt[((simtst21)PRG$).i/(3)-(3)-((simtst21$SubBlock32)CV$[2]).B.LB[0]]);
               if(((simtst21)PRG$).j==(0)) {
               } else
                  {
                  sysout().outtext(new TXT$("*** error : Integer Array (2)."));
                  sysout().outimage();
                  sysout().outtext(new TXT$("            Erroneus values : "));
                  sysout().outimage();
                  sysout().outint(((simtst21)PRG$).i/(3)-(3),13);
                  sysout().outint(((simtst21$SubBlock32)CV$[2]).A.Elt[((simtst21)PRG$).i/(3)-(3)-((simtst21$SubBlock32)CV$[2]).A.LB[0]],4);
                  sysout().outint(((simtst21$SubBlock32)CV$[2]).B.Elt[((simtst21)PRG$).i/(3)-(3)-((simtst21$SubBlock32)CV$[2]).B.LB[0]],4);
                  sysout().outimage();
                  ((simtst21)PRG$).found_error=true;
                  }
               }
            }
            EBLK();
            return(null);
         }
      }
