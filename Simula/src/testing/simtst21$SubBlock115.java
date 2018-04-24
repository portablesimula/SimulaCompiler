package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 16:58:33 CEST 2018
import simula.runtime.*;
      public class simtst21$SubBlock115 extends RTObject$ {
         // BlockKind=SubBlock, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
         // Declare parameters as attributes
         // Declare locals as attributes
         public $NARRAY<char[][][]>C=null;
         public $NARRAY<char[][]>D=null;
         int n=0;
         // Normal Constructor
         public simtst21$SubBlock115(RTObject$ staticLink) {
            super(staticLink);
            // Parameter assignment to locals
            // Declaration Code
            C=new $NARRAY<char[][][]>(new char[3-2+1][5-4+1][7-6+1],2,4,6);
            D=new $NARRAY<char[][]>(new char[9-8+1][2-1+1],8,1);
         }
         // SubBlock Statements
         public RTObject$ STM() {
            BBLK();
            for(((simtst21)PRG$).i=8;((simtst21)PRG$).i<=9;((simtst21)PRG$).i=((simtst21)PRG$).i+1) {
               for(((simtst21)PRG$).j=1;((simtst21)PRG$).j<=2;((simtst21)PRG$).j=((simtst21)PRG$).j+1) {
                  {
                  ((simtst21$SubBlock115)CV$[2]).D.Elt[((simtst21)PRG$).i-((simtst21$SubBlock115)CV$[2]).D.LB[0]][((simtst21)PRG$).j-((simtst21$SubBlock115)CV$[2]).D.LB[1]]=Char(((simtst21$SubBlock115)CV$[2]).n+(65));
                  ((simtst21$SubBlock115)CV$[2]).n=((simtst21$SubBlock115)CV$[2]).n+(1);
                  }
               }
            }
            if(D.Elt[8-D.LB[0]][1-D.LB[1]]==('A')&(D.Elt[8-D.LB[0]][2-D.LB[1]]==('B'))&(D.Elt[9-D.LB[0]][1-D.LB[1]]==('C'))&(D.Elt[9-D.LB[0]][2-D.LB[1]]==('D'))) {
            } else
               {
               sysout().outtext(new TXT$("*** error : Value of character array (5)."));
               sysout().outimage();
               sysout().outtext(new TXT$("            Erroneus values : "));
               sysout().outimage();
               for(((simtst21)PRG$).i=8;((simtst21)PRG$).i<=9;((simtst21)PRG$).i=((simtst21)PRG$).i+1) {
                  for(((simtst21)PRG$).j=1;((simtst21)PRG$).j<=2;((simtst21)PRG$).j=((simtst21)PRG$).j+1) {
                     {
                     sysout().outint(((simtst21)PRG$).i,13);
                     sysout().outint(((simtst21)PRG$).j,3);
                     sysout().outchar(((simtst21$SubBlock115)CV$[2]).D.Elt[((simtst21)PRG$).i-((simtst21$SubBlock115)CV$[2]).D.LB[0]][((simtst21)PRG$).j-((simtst21$SubBlock115)CV$[2]).D.LB[1]]);
                     sysout().outimage();
                     }
                  }
               }
               ((simtst21)PRG$).found_error=true;
               }
            EBLK();
            return(null);
         }
      }
