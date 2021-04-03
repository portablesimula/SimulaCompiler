 Global ENVIR("TST 1.0");
 begin
       -----------------------------------------------------------------------
       ---                                                                 ---
       ---            S I M U L E T T A    T E S T B A T C H               ---
       ---                                                                 ---
       ---              G l o b a l     D e f i n i t i o n s              ---
       ---                                                                 ---
       -----------------------------------------------------------------------
% PASS 1 doTRACING = 4
% PASS 1 INPUT  = 4
%PASS 1 OUTPUT = 4
% PASS 1 MODTRC = 4
% PASS 1 TRACE  = 4
%PASS 2 INPUT  = 4

Visible character ccc;
Visible define
      MAX_BYT = 255 ,     -- Value of a byte
      MAX_TXT = 32000     -- Number of characters in a text object
 ;

 Visible integer maxint             system "MAXINT";
 Visible integer minint             system "MININT";
 Visible integer maxrank            system "MAXRNK";
 Visible real maxreal               system "MAXREA";
 Visible real minreal               system "MINREA";
 Visible long real maxlreal         system "MAXLRL";
 Visible long real minlreal         system "MINLRL";
 
-- Visible sysroutine("PRINT") PRINT; import String str; end; 
-- Visible sysroutine("TRACE") TRACE; import integer lno; String str; end; 
 
-- Visible const infix(string)
--       nostring=record:string(nchr=0,chradr=noname);

 Visible const infix(txtqnt)
       notext=record:txtqnt(sp=0,lp=0,cp=0,ent=none);

-- Visible const String s="Abra ca dab";

-- Visible record string;  info "TYPE";
-- begin name(character)   chradr;
--       integer           nchr;
-- end;

 Visible record txtqnt;  info "TYPE";
 begin ref(txtent)        ent;
       range(0:MAX_TXT)   cp;
       range(0:MAX_TXT)   sp;
       range(0:MAX_TXT)   lp;
 end;

 Visible record txtent;
 begin range(0:MAX_TXT)    ncha;
       character           cha(0);
 end;

 Visible record identifier;
 begin range(0:MAX_BYT)   ncha;
       character          cha(0);
 end;

 Visible routine rut; import integer str; export int res;
 begin res:=str+4; end;
 



 end;
