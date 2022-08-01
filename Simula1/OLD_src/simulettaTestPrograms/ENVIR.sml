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
% PASS 1 OUTPUT = 4
% PASS 1 MODTRC = 4
% PASS 1 TRACE  = 4

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

 Visible routine print; import String str;
 begin PRINT(str); end;

 Visible routine println; import String str;
 begin PRINT(str+"\n"); end;


	-----------------------------------------------------------------------
	---                                                                 ---
	---              T E S T I N G    F R A M E W O R K                 ---
	---                                                                 ---
	-----------------------------------------------------------------------
	boolean verbose;
	String facit(?);
	String title;
	integer traceCase;
	integer nError;
	
	Visible routine TEST_BEGIN; import boolean pVerbose; String pTitle; String pFacit(?);
	begin verbose:=pVerbose;
		  facit:=pFacit;
          title:=pTitle;
          if verbose then
			 println("--- START SIMULETTA TEST: "+title);
		  endif;
		  traceCase:=0; nError:=0; 
	end;
 
   Visible routine TEST_TRACE; import integer line; String msg;
   begin
      if verbose then TRACE(line,msg); endif;
      if msg NE facit(traceCase) then
         nError:=nError+1;
         TRACE(line,"ERROR in Case "+traceCase);
         TRACE(line,"Trace: " + msg);
         TRACE(line,"Facit: " + facit(traceCase));
      endif;
      traceCase:=traceCase+1;
   end;
 
   Visible routine TEST_ERROR; import integer line; String msg;
   begin nError:=nError+1;
         TRACE(line,"ERROR "+msg);
   end;

   Visible routine END_SIMULETTA_TEST;
   begin if nError>0 then
			  println ("--- "+nError+" ERRORS FOUND IN TEST: "+title);
		 else println ("--- NO ERRORS FOUND IN TEST: "+title); endif;
		 if verbose then println ("--- END SIMULETTA TEST: "+title); endif;
   end;






 end;
