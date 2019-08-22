package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$A$Setvariables extends PROC$ {
    int i2=0;
    public simtst30$$A$Setvariables(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst30$$A$Setvariables STM$() {
        ((simtst30$$A)(CUR$.SL$)).bv=true;
        ((simtst30$$A)(CUR$.SL$)).cv='*';
        ((simtst30$$A)(CUR$.SL$)).iv=2;
        ((simtst30$$A)(CUR$.SL$)).rv=3.0f;
        ((simtst30$$A)(CUR$.SL$)).tv=copy(copy(new TXT$("tv")));
        ((simtst30$$A)(CUR$.SL$)).rav=new simtst30$$A(((simtst30$)(CUR$.SL$.SL$)),copy(new TXT$("rav"))).STM$();
        ((simtst30$$A)(CUR$.SL$)).rbv=new simtst30$$B(((simtst30$)(CUR$.SL$.SL$)),copy(new TXT$("rbv"))).STM$();
        ((simtst30$$A)(CUR$.SL$)).bva1.Elt[0-((simtst30$$A)(CUR$.SL$)).bva1.LB[0]]=false;
        ((simtst30$$A)(CUR$.SL$)).cva1.Elt[0-((simtst30$$A)(CUR$.SL$)).cva1.LB[0]]='&';
        ((simtst30$$A)(CUR$.SL$)).iva1.Elt[0-((simtst30$$A)(CUR$.SL$)).iva1.LB[0]]=6;
        ((simtst30$$A)(CUR$.SL$)).rva1.Elt[0-((simtst30$$A)(CUR$.SL$)).rva1.LB[0]]=7.0f;
        ((simtst30$$A)(CUR$.SL$)).tva1.Elt[0-((simtst30$$A)(CUR$.SL$)).tva1.LB[0]]=copy(copy(new TXT$(" (0)")));
        ((simtst30$$A)(CUR$.SL$)).rava1.Elt[0-((simtst30$$A)(CUR$.SL$)).rava1.LB[0]]=new simtst30$$A(((simtst30$)(CUR$.SL$.SL$)),copy(new TXT$("rava1 (0)"))).STM$();
        ((simtst30$$A)(CUR$.SL$)).rbva1.Elt[0-((simtst30$$A)(CUR$.SL$)).rbva1.LB[0]]=new simtst30$$B(((simtst30$)(CUR$.SL$.SL$)),copy(new TXT$("rbva1 (0)"))).STM$();
        i2=0;
        while((i2<=(1))) {
            {
                if(VALUE$((i2==(0)))) {
                    {
                    }
                } else
                {
                }
                i2=Math.addExact(i2,1);
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure Setvariables",1,294,7,296,15,298,17,299,19,300,21,301,23,302,25,303,27,304,29,305,31,306,33,307,35,308,37,309,39,310,41,311,43,312,45,314,47,317,50,322,54,323,57,324,63,326);
}
