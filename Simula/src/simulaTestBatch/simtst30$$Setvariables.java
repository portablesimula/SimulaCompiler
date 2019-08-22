package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$Setvariables extends PROC$ {
    int i2=0;
    public simtst30$$Setvariables(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst30$$Setvariables STM$() {
        ((simtst30$)(CUR$.SL$)).bv=true;
        ((simtst30$)(CUR$.SL$)).cv='*';
        ((simtst30$)(CUR$.SL$)).iv=2;
        ((simtst30$)(CUR$.SL$)).rv=3.0f;
        ((simtst30$)(CUR$.SL$)).tv=copy(copy(new TXT$("tv")));
        ((simtst30$)(CUR$.SL$)).rav=new simtst30$$A(((simtst30$)(CUR$.SL$)),copy(new TXT$("rav"))).STM$();
        ((simtst30$)(CUR$.SL$)).rbv=new simtst30$$B(((simtst30$)(CUR$.SL$)),copy(new TXT$("rbv"))).STM$();
        ((simtst30$)(CUR$.SL$)).bva1.Elt[0-((simtst30$)(CUR$.SL$)).bva1.LB[0]]=false;
        ((simtst30$)(CUR$.SL$)).cva1.Elt[0-((simtst30$)(CUR$.SL$)).cva1.LB[0]]='&';
        ((simtst30$)(CUR$.SL$)).iva1.Elt[0-((simtst30$)(CUR$.SL$)).iva1.LB[0]]=6;
        ((simtst30$)(CUR$.SL$)).rva1.Elt[0-((simtst30$)(CUR$.SL$)).rva1.LB[0]]=7.0f;
        ((simtst30$)(CUR$.SL$)).tva1.Elt[0-((simtst30$)(CUR$.SL$)).tva1.LB[0]]=copy(copy(new TXT$(" (0)")));
        ((simtst30$)(CUR$.SL$)).rava1.Elt[0-((simtst30$)(CUR$.SL$)).rava1.LB[0]]=new simtst30$$A(((simtst30$)(CUR$.SL$)),copy(new TXT$("rava1 (0)"))).STM$();
        ((simtst30$)(CUR$.SL$)).rbva1.Elt[0-((simtst30$)(CUR$.SL$)).rbva1.LB[0]]=new simtst30$$B(((simtst30$)(CUR$.SL$)),copy(new TXT$("rbva1 (0)"))).STM$();
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure Setvariables",6,353,14,355,16,356,18,357,20,358,22,359,24,360,26,361,28,362,30,363,32,364,34,365,36,366,38,367,40,368,42,369,44,371,46,374,49,379,53,380,56,381,62,383);
}
