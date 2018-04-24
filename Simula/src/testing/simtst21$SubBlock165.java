package testing;
// Simula Beta(0.1) Compiled at Tue Apr 24 16:58:33 CEST 2018
import simula.runtime.*;
      public class simtst21$SubBlock165 extends RTObject$ {
         // BlockKind=SubBlock, BlockLevel=2, hasLocalClasses=false, System=false, detachUsed=false
         // Declare parameters as attributes
         // Declare locals as attributes
         public $NARRAY<TXT$[][]>T=null;
         TXT$ t1=null;
         // Normal Constructor
         public simtst21$SubBlock165(RTObject$ staticLink) {
            super(staticLink);
            // Parameter assignment to locals
            // Declaration Code
            T=new $NARRAY<TXT$[][]>(new TXT$[4-1+1][2-1+1],1,1);
         }
         // SubBlock Statements
         public RTObject$ STM() {
            BBLK();
            t1=blanks(16);
            for(((simtst21)PRG$).i=1;((simtst21)PRG$).i<=4;((simtst21)PRG$).i=((simtst21)PRG$).i+1) {
               for(((simtst21)PRG$).j=1;((simtst21)PRG$).j<=2;((simtst21)PRG$).j=((simtst21)PRG$).j+1) {
                  {
                  ((simtst21$SubBlock165)CV$[2]).T.Elt[((simtst21)PRG$).i-((simtst21$SubBlock165)CV$[2]).T.LB[0]][((simtst21)PRG$).j-((simtst21$SubBlock165)CV$[2]).T.LB[1]]=TXT$.sub(((simtst21$SubBlock165)CV$[2]).t1,4*(((simtst21)PRG$).i-(1))+(2*(((simtst21)PRG$).j))-(1),2);
                  TXT$.putint(TXT$.sub(((simtst21$SubBlock165)CV$[2]).T.Elt[((simtst21)PRG$).i-((simtst21$SubBlock165)CV$[2]).T.LB[0]][((simtst21)PRG$).j-((simtst21$SubBlock165)CV$[2]).T.LB[1]],1,1),((simtst21)PRG$).i);
                  TXT$.putint(TXT$.sub(((simtst21$SubBlock165)CV$[2]).T.Elt[((simtst21)PRG$).i-((simtst21$SubBlock165)CV$[2]).T.LB[0]][((simtst21)PRG$).j-((simtst21$SubBlock165)CV$[2]).T.LB[1]],2,1),((simtst21)PRG$).j);
                  }
               }
            }
            if(TXTREL$EQ(t1,new TXT$("1112212231324142"))) {
            } else
               {
               sysout().outtext(new TXT$("*** error : Text array (6)."));
               sysout().outimage();
               sysout().outtext(new TXT$("            Erroneus value : "));
               sysout().outtext(((simtst21$SubBlock165)CV$[2]).t1);
               sysout().outimage();
               ((simtst21)PRG$).found_error=true;
               }
            for(((simtst21)PRG$).i=10;((simtst21)PRG$).i<=40;((simtst21)PRG$).i=((simtst21)PRG$).i+10) {
               for(((simtst21)PRG$).j=1;((simtst21)PRG$).j<=2;((simtst21)PRG$).j=((simtst21)PRG$).j+1) {
                  if(TXT$.getint(T.Elt[((simtst21)PRG$).i/(10)-T.LB[0]][((simtst21)PRG$).j-T.LB[1]])==(((simtst21)PRG$).i+(((simtst21)PRG$).j))) {
                  } else
                     {
                     sysout().outtext(new TXT$("*** error : Text array (7)."));
                     sysout().outimage();
                     sysout().outtext(new TXT$("            Erroneus values : "));
                     sysout().outint(((simtst21)PRG$).i,4);
                     sysout().outint(((simtst21)PRG$).j,3);
                     sysout().outtext(new TXT$("  "));
                     sysout().outtext(((simtst21$SubBlock165)CV$[2]).T.Elt[4*(((simtst21)PRG$).i/(10)-(1))+(2*(((simtst21)PRG$).j))-(1)-((simtst21$SubBlock165)CV$[2]).T.LB[0]][2-((simtst21$SubBlock165)CV$[2]).T.LB[1]]);
                     sysout().outimage();
                     ((simtst21)PRG$).found_error=true;
                     }
               }
            }
            EBLK();
            return(null);
         }
      }
