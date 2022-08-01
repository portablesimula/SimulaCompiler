begin insert ENVIR;

	boolean b;
	ref(txtqnt) ref1;
 
	entry(prof1) test1=ENTRY(BODY1);
	entry(prof2) test2=ENTRY(BODY2);

	Visible record subrecord:txtqnt;
	begin String ident;
	end;

	Visible sysroutine("LOWTEN") envir_LTEN;
	import character c  end;

	Visible routine TEST2;
	import ref(subrecord) pfil; begin
	    String s;
	    TEST_TRACE(sourceline,"Begin TEST2");
	    envir_LTEN('E');
	    s:="Dette er en tekst";
	    s:=s+" det er meningen at skal skrives ut";
	    print(s+"\n");
 	    TEST_TRACE(sourceline,"End of TEST2");
	end;
 

	Profile prof1;
       import integer eno; integer inf(4);
       export boolean res;
	end;

	Profile prof2;
       export boolean res;
	end;

	Visible body(prof1) BODY1;
	begin integer i,j,k;
 	   TEST_TRACE(sourceline,"Begin BODY1");
 	   i:=8; j:=13;
       k:=i+j;
       if k <> 21 then TEST_ERROR(sourceline,"Wrong value: k="+k+" Should be 21"); endif;
 	   TEST_TRACE(sourceline,"End of BODY1");
	end;

	Visible body(prof2) BODY2;
	begin integer er_no;
       er_no:=16;
	end;
 
 
	-----------------------------------------------------------------------
	---              T E S T I N G    C O D E
	-----------------------------------------------------------------------
	const boolean VERBOSE=false; --true; --false;
	TEST_BEGIN(VERBOSE,"TEST 120: Routines",("At START"
				   ,"Just before call BODY1"
				   ,"Begin BODY1"
				   ,"End of BODY1"
				   ,"Just before call test1"
				   ,"Just before call test2"
				   ,"Just before call TEST2"
				   ,"Begin TEST2"
				   ,"End of TEST2"
				   ,"At END OF TEST"));
 
	TEST_TRACE(sourceline,"At START");
      
	TEST_TRACE(sourceline,"Just before call BODY1");
	b:=BODY1(7,(7,6,5,4));   
 
	TEST_TRACE(sourceline,"Just before call test1");
	CALL  prof1 ( test1 ) (8,(1,2,3,4));   

	TEST_TRACE(sourceline,"Just before call test2");
	CALL  prof2 ( test2 );   

-- CALL  prof1 ( test2 ) (8);  

	TEST_TRACE(sourceline,"Just before call TEST2");
	TEST2(ref1); 
 
	TEST_TRACE(sourceline,"At END OF TEST");
   
	END_SIMULETTA_TEST;
      

end