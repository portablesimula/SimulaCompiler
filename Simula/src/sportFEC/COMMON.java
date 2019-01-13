// JavaLine 1 ==> SourceLine 1
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=0, firstLine=1, lastLine=1591, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1574
    final LABQNT$ EXCEPTION_HANDLER=new LABQNT$(this,0,1); // Local Label #1=EXCEPTION_HANDLER
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 61
    public final char NUL=((char)0);
    // JavaLine 16 ==> SourceLine 63
    public char identhi=0;
    public char identlo=0;
    public char consthi=0;
    public char constlo=0;
    // JavaLine 21 ==> SourceLine 64
    public char hashhi=0;
    public char hashlo=0;
    // JavaLine 24 ==> SourceLine 65
    public TXT$ simsymbol=null;
    // JavaLine 26 ==> SourceLine 69
    public ARRAY$<COMMON$symbolgroup[]>symtab=null;
    // JavaLine 28 ==> SourceLine 74
    public ARRAY$<COMMON$symbolbox[]>hashtab=null;
    // JavaLine 30 ==> SourceLine 79
    public COMMON$symbolgroup dummyGroup=null;
    public COMMON$identsymbol dummyBox=null;
    // JavaLine 33 ==> SourceLine 271
    public ARRAY$<char[]>option=null;
    // JavaLine 35 ==> SourceLine 290
    public final TXT$ sportid=new TXT$("S-PORT SYSTEM");
    // JavaLine 37 ==> SourceLine 294
    public final int maxasd=30;
    // JavaLine 39 ==> SourceLine 295
    public final int maxplev=63;
    // JavaLine 41 ==> SourceLine 296
    public final int maxblev=250;
    // JavaLine 43 ==> SourceLine 297
    public final int maxdepth=100;
    // JavaLine 45 ==> SourceLine 298
    public final int maxcalldepth=15;
    // JavaLine 47 ==> SourceLine 299
    public final int maxjumpdepth=100;
    // JavaLine 49 ==> SourceLine 308
    public final int SbufferMax=750;
    // JavaLine 51 ==> SourceLine 309
    public final int L2max=256;
    // JavaLine 53 ==> SourceLine 310
    public final int RepeatMax=256;
    // JavaLine 55 ==> SourceLine 335
    public final char IBOOL=((char)1);
    // JavaLine 57 ==> SourceLine 336
    public final char ICHAR=((char)2);
    // JavaLine 59 ==> SourceLine 337
    public final char ISHOR=((char)3);
    // JavaLine 61 ==> SourceLine 338
    public final char IINTG=((char)4);
    // JavaLine 63 ==> SourceLine 339
    public final char IREAL=((char)5);
    // JavaLine 65 ==> SourceLine 340
    public final char ILONG=((char)6);
    // JavaLine 67 ==> SourceLine 341
    public final char IREF=((char)7);
    // JavaLine 69 ==> SourceLine 342
    public final char ITEXT=((char)8);
    // JavaLine 71 ==> SourceLine 343
    public final char IPTR=((char)9);
    // JavaLine 73 ==> SourceLine 344
    public final char IVALU=((char)10);
    // JavaLine 75 ==> SourceLine 345
    public final char ILABE=((char)11);
    // JavaLine 77 ==> SourceLine 346
    public final char IPROC=((char)12);
    // JavaLine 79 ==> SourceLine 347
    public final char IARRA=((char)13);
    // JavaLine 81 ==> SourceLine 348
    public final char INOTY=((char)14);
    // JavaLine 83 ==> SourceLine 349
    public final char IELSE=((char)15);
    // JavaLine 85 ==> SourceLine 350
    public final char IEND=((char)16);
    // JavaLine 87 ==> SourceLine 351
    public final char IEQV=((char)17);
    // JavaLine 89 ==> SourceLine 352
    public final char IEXTR=((char)18);
    // JavaLine 91 ==> SourceLine 353
    public final char IFOR=((char)19);
    // JavaLine 93 ==> SourceLine 354
    public final char IGO=((char)20);
    // JavaLine 95 ==> SourceLine 355
    public final char IGOTO=((char)21);
    // JavaLine 97 ==> SourceLine 356
    public final char IHIDD=((char)22);
    // JavaLine 99 ==> SourceLine 357
    public final char IIF=((char)23);
    // JavaLine 101 ==> SourceLine 358
    public final char IIMP=((char)24);
    // JavaLine 103 ==> SourceLine 359
    public final char IIN=((char)25);
    // JavaLine 105 ==> SourceLine 360
    public final char IINNE=((char)26);
    // JavaLine 107 ==> SourceLine 361
    public final char IINSP=((char)27);
    // JavaLine 109 ==> SourceLine 362
    public final char IDO=((char)28);
    // JavaLine 111 ==> SourceLine 363
    public final char IIS=((char)29);
    // JavaLine 113 ==> SourceLine 364
    public final char ICLAS=((char)30);
    // JavaLine 115 ==> SourceLine 365
    public final char IRCRD=((char)31);
    // JavaLine 117 ==> SourceLine 366
    public final char IBEGI=((char)32);
    // JavaLine 119 ==> SourceLine 367
    public final char INAME='!';
    // JavaLine 121 ==> SourceLine 368
    public final char INEW='"';
    // JavaLine 123 ==> SourceLine 369
    public final char INOT='#';
    // JavaLine 125 ==> SourceLine 370
    public final char IOR='$';
    // JavaLine 127 ==> SourceLine 371
    public final char IOTHW='%';
    // JavaLine 129 ==> SourceLine 372
    public final char IPRIO='&';
    // JavaLine 131 ==> SourceLine 373
    public final char IDELA=((char)39);
    // JavaLine 133 ==> SourceLine 374
    public final char IPRTC='(';
    // JavaLine 135 ==> SourceLine 375
    public final char IQUA=')';
    // JavaLine 137 ==> SourceLine 376
    public final char IREAC='*';
    // JavaLine 139 ==> SourceLine 377
    public final char IAT='+';
    // JavaLine 141 ==> SourceLine 378
    public final char IBEFO=',';
    // JavaLine 143 ==> SourceLine 379
    public final char IAND='-';
    // JavaLine 145 ==> SourceLine 380
    public final char ISTEP='.';
    // JavaLine 147 ==> SourceLine 381
    public final char ISWIT='/';
    // JavaLine 149 ==> SourceLine 382
    public final char IACTV='0';
    // JavaLine 151 ==> SourceLine 383
    public final char ITHEN='1';
    // JavaLine 153 ==> SourceLine 384
    public final char ITHIS='2';
    // JavaLine 155 ==> SourceLine 385
    public final char ITO='3';
    // JavaLine 157 ==> SourceLine 386
    public final char IUNTI='4';
    // JavaLine 159 ==> SourceLine 387
    public final char IAFTR='5';
    // JavaLine 161 ==> SourceLine 388
    public final char IVIRT='6';
    // JavaLine 163 ==> SourceLine 389
    public final char IWHEN='7';
    // JavaLine 165 ==> SourceLine 390
    public final char IWHIL='8';
    // JavaLine 167 ==> SourceLine 391
    public final char ILT='9';
    // JavaLine 169 ==> SourceLine 392
    public final char IEQ=':';
    // JavaLine 171 ==> SourceLine 393
    public final char ILE=';';
    // JavaLine 173 ==> SourceLine 394
    public final char IGT='<';
    // JavaLine 175 ==> SourceLine 395
    public final char INE='=';
    // JavaLine 177 ==> SourceLine 396
    public final char IGE='>';
    // JavaLine 179 ==> SourceLine 397
    public final char ICOMN='?';
    // JavaLine 181 ==> SourceLine 398
    public final char INONE='@';
    // JavaLine 183 ==> SourceLine 399
    public final char INOTE='A';
    // JavaLine 185 ==> SourceLine 400
    public final char ITRUE='B';
    // JavaLine 187 ==> SourceLine 401
    public final char IFALS='C';
    // JavaLine 189 ==> SourceLine 403
    public final char detachident='D';
    // JavaLine 191 ==> SourceLine 404
    public final char printfileindex='E';
    // JavaLine 193 ==> SourceLine 405
    public final char infileindex='F';
    // JavaLine 195 ==> SourceLine 406
    public final char errorident='G';
    // JavaLine 197 ==> SourceLine 407
    public final char textclassindex='H';
    // JavaLine 199 ==> SourceLine 408
    public final char predefindex='I';
    // JavaLine 201 ==> SourceLine 409
    public final char alloc2index='J';
    // JavaLine 203 ==> SourceLine 410
    public final char recordindex='K';
    // JavaLine 205 ==> SourceLine 411
    public final char Cindex='L';
    // JavaLine 207 ==> SourceLine 412
    public final char Pascalindex='M';
    // JavaLine 209 ==> SourceLine 413
    public final char Libraryindex='N';
    // JavaLine 211 ==> SourceLine 415
    public final char IRFEQ='D';
    // JavaLine 213 ==> SourceLine 416
    public final char IRFNE='E';
    // JavaLine 215 ==> SourceLine 417
    public final char IPLUS='F';
    // JavaLine 217 ==> SourceLine 418
    public final char IMINU='G';
    // JavaLine 219 ==> SourceLine 419
    public final char IMULT='H';
    // JavaLine 221 ==> SourceLine 420
    public final char ISLAS='I';
    // JavaLine 223 ==> SourceLine 421
    public final char IPOWE='J';
    // JavaLine 225 ==> SourceLine 422
    public final char IIDIV='K';
    // JavaLine 227 ==> SourceLine 423
    public final char IDOT='L';
    // JavaLine 229 ==> SourceLine 424
    public final char ICL='M';
    // JavaLine 231 ==> SourceLine 425
    public final char ICOMA='N';
    // JavaLine 233 ==> SourceLine 426
    public final char ISMCL='O';
    // JavaLine 235 ==> SourceLine 427
    public final char ILFPA='P';
    // JavaLine 237 ==> SourceLine 428
    public final char IRGPA='Q';
    // JavaLine 239 ==> SourceLine 429
    public final char IASSG='R';
    // JavaLine 241 ==> SourceLine 430
    public final char IDENO='S';
    // JavaLine 243 ==> SourceLine 431
    public final char ICONC='T';
    // JavaLine 245 ==> SourceLine 432
    public final char ICAND='U';
    // JavaLine 247 ==> SourceLine 433
    public final char ICOR='V';
    // JavaLine 249 ==> SourceLine 434
    public final char ICASE='W';
    // JavaLine 251 ==> SourceLine 435
    public final char IEOP='X';
    // JavaLine 253 ==> SourceLine 436
    public final char IROPD='Y';
    // JavaLine 255 ==> SourceLine 437
    public final char IIDN='Z';
    // JavaLine 257 ==> SourceLine 438
    public final char ICONS='[';
    // JavaLine 259 ==> SourceLine 442
    public final char IBLKB='\\';
    // JavaLine 261 ==> SourceLine 443
    public final char IBPRF=']';
    // JavaLine 263 ==> SourceLine 444
    public final char IDCLI='^';
    // JavaLine 265 ==> SourceLine 445
    public final char IFRMP='_';
    // JavaLine 267 ==> SourceLine 446
    public final char IABTE='`';
    // JavaLine 269 ==> SourceLine 447
    public final char IACTE='a';
    // JavaLine 271 ==> SourceLine 448
    public final char IARGE='b';
    // JavaLine 273 ==> SourceLine 449
    public final char IARDE='c';
    // JavaLine 275 ==> SourceLine 450
    public final char IASGE='d';
    // JavaLine 277 ==> SourceLine 451
    public final char IBLNO='e';
    // JavaLine 279 ==> SourceLine 452
    public final char IBNDE='f';
    // JavaLine 281 ==> SourceLine 453
    public final char IBREC='g';
    // JavaLine 283 ==> SourceLine 454
    public final char ICAPE='h';
    // JavaLine 285 ==> SourceLine 455
    public final char ICONB='i';
    // JavaLine 287 ==> SourceLine 456
    public final char ICONE='j';
    // JavaLine 289 ==> SourceLine 457
    public final char ICPRF='k';
    // JavaLine 291 ==> SourceLine 458
    public final char ICSPC='l';
    // JavaLine 293 ==> SourceLine 459
    public final char IDCLA='m';
    // JavaLine 295 ==> SourceLine 460
    public final char IDCLC='n';
    // JavaLine 297 ==> SourceLine 461
    public final char IDCLE='o';
    // JavaLine 299 ==> SourceLine 462
    public final char IDCLP='p';
    // JavaLine 301 ==> SourceLine 463
    public final char IDCLS='q';
    // JavaLine 303 ==> SourceLine 464
    public final char IDIME='r';
    // JavaLine 305 ==> SourceLine 465
    public final char IDOTP='s';
    // JavaLine 307 ==> SourceLine 466
    public final char IEEXP='t';
    // JavaLine 309 ==> SourceLine 467
    public final char IECWI='u';
    // JavaLine 311 ==> SourceLine 468
    public final char IELME='v';
    // JavaLine 313 ==> SourceLine 469
    public final char IELSB='w';
    // JavaLine 315 ==> SourceLine 470
    public final char IEPRM='x';
    // JavaLine 317 ==> SourceLine 471
    public final char IEREC='y';
    // JavaLine 319 ==> SourceLine 472
    public final char IESTM='z';
    // JavaLine 321 ==> SourceLine 473
    public final char IEXNM='{';
    // JavaLine 323 ==> SourceLine 474
    public final char IFASG='|';
    // JavaLine 325 ==> SourceLine 475
    public final char IFDNO='}';
    // JavaLine 327 ==> SourceLine 476
    public final char IFORE='~';
    // JavaLine 329 ==> SourceLine 477
    public final char IFWHN=((char)127);
    // JavaLine 331 ==> SourceLine 478
    public final char IGOE=((char)128);
    // JavaLine 333 ==> SourceLine 479
    public final char IIDNP=((char)129);
    // JavaLine 335 ==> SourceLine 480
    public final char IIFSB=((char)130);
    // JavaLine 337 ==> SourceLine 481
    public final char IIFSE=((char)131);
    // JavaLine 339 ==> SourceLine 482
    public final char ILANG=((char)132);
    // JavaLine 341 ==> SourceLine 483
    public final char ILINE=((char)133);
    // JavaLine 343 ==> SourceLine 484
    public final char INEWP=((char)134);
    // JavaLine 345 ==> SourceLine 485
    public final char IOTHE=((char)135);
    // JavaLine 347 ==> SourceLine 486
    public final char IPRHI=((char)136);
    // JavaLine 349 ==> SourceLine 487
    public final char IPSPC=((char)137);
    // JavaLine 351 ==> SourceLine 488
    public final char ISCST=((char)138);
    // JavaLine 353 ==> SourceLine 489
    public final char ISIDN=((char)139);
    // JavaLine 355 ==> SourceLine 490
    public final char ISIMU=((char)140);
    // JavaLine 357 ==> SourceLine 491
    public final char ISSWA=((char)141);
    // JavaLine 359 ==> SourceLine 492
    public final char ISSWB=((char)142);
    // JavaLine 361 ==> SourceLine 493
    public final char ISWDE=((char)143);
    // JavaLine 363 ==> SourceLine 494
    public final char ISWEE=((char)144);
    // JavaLine 365 ==> SourceLine 495
    public final char ITHSB=((char)145);
    // JavaLine 367 ==> SourceLine 496
    public final char IUMNS=((char)146);
    // JavaLine 369 ==> SourceLine 497
    public final char IUPLS=((char)147);
    // JavaLine 371 ==> SourceLine 498
    public final char IVSPC=((char)148);
    // JavaLine 373 ==> SourceLine 499
    public final char IMXMX=((char)148);
    // JavaLine 375 ==> SourceLine 500
    public final char zerohi=((char)127);
    // JavaLine 377 ==> SourceLine 501
    public final char zerolo=((char)255);
    // JavaLine 379 ==> SourceLine 546
    public final int zero=0;
    public final int one=1;
    // JavaLine 382 ==> SourceLine 552
    public final char C_unspec=((char)0);
    // JavaLine 384 ==> SourceLine 553
    public final char C_value=((char)1);
    // JavaLine 386 ==> SourceLine 554
    public final char C_name=((char)2);
    // JavaLine 388 ==> SourceLine 555
    public final char C_local=((char)3);
    // JavaLine 390 ==> SourceLine 556
    public final char C_extnal=((char)4);
    // JavaLine 392 ==> SourceLine 557
    public final char C_unknwn=((char)5);
    // JavaLine 394 ==> SourceLine 558
    public final char C_virt=((char)6);
    // JavaLine 396 ==> SourceLine 559
    public final char C_block=((char)7);
    // JavaLine 398 ==> SourceLine 561
    public final char C_max=((char)7);
    // JavaLine 400 ==> SourceLine 579
    public final char K_ident=((char)0);
    // JavaLine 402 ==> SourceLine 580
    public final char K_proc=((char)1);
    // JavaLine 404 ==> SourceLine 581
    public final char K_array=((char)2);
    // JavaLine 406 ==> SourceLine 582
    public final char K_label=((char)3);
    // JavaLine 408 ==> SourceLine 583
    public final char K_switch=((char)4);
    // JavaLine 410 ==> SourceLine 584
    public final char K_class=((char)5);
    // JavaLine 412 ==> SourceLine 585
    public final char K_rep=((char)6);
    // JavaLine 414 ==> SourceLine 586
    public final char K_record=((char)7);
    // JavaLine 416 ==> SourceLine 587
    public final char K_subbl=((char)8);
    // JavaLine 418 ==> SourceLine 588
    public final char K_prefbl=((char)9);
    // JavaLine 420 ==> SourceLine 589
    public final char K_error=((char)10);
    // JavaLine 422 ==> SourceLine 590
    public final char K_labbl=((char)11);
    // JavaLine 424 ==> SourceLine 591
    public final char K_unknwn=((char)12);
    // JavaLine 426 ==> SourceLine 592
    public final char K_extnal=((char)13);
    // JavaLine 428 ==> SourceLine 594
    public final char K_max=((char)13);
    // JavaLine 430 ==> SourceLine 618
    public final char Clf000=((char)0);
    // JavaLine 432 ==> SourceLine 620
    public final char Clf001=((char)1);
    // JavaLine 434 ==> SourceLine 621
    public final char Clf002=((char)2);
    // JavaLine 436 ==> SourceLine 625
    public final char Clf003=((char)3);
    // JavaLine 438 ==> SourceLine 626
    public final char Clf004=((char)4);
    // JavaLine 440 ==> SourceLine 628
    public final char Clf005=((char)5);
    // JavaLine 442 ==> SourceLine 636
    public final char Clf006=((char)6);
    // JavaLine 444 ==> SourceLine 640
    public final char Clf007=((char)7);
    // JavaLine 446 ==> SourceLine 643
    public final char Clf008=((char)8);
    // JavaLine 448 ==> SourceLine 650
    public final char Clf009=((char)9);
    // JavaLine 450 ==> SourceLine 653
    public final char Clf010=((char)10);
    // JavaLine 452 ==> SourceLine 656
    public final char Clf011=((char)11);
    // JavaLine 454 ==> SourceLine 661
    public final char Clf012=((char)12);
    // JavaLine 456 ==> SourceLine 665
    public final char Clf013=((char)13);
    // JavaLine 458 ==> SourceLine 668
    public final char Clf014=((char)14);
    // JavaLine 460 ==> SourceLine 674
    public final char Clf015=((char)15);
    // JavaLine 462 ==> SourceLine 681
    public final char Clf016=((char)16);
    // JavaLine 464 ==> SourceLine 686
    public final char Clf017=((char)17);
    // JavaLine 466 ==> SourceLine 687
    public final char Clf018=((char)18);
    // JavaLine 468 ==> SourceLine 688
    public final char Clf019=((char)19);
    // JavaLine 470 ==> SourceLine 691
    public final char Clf020=((char)20);
    // JavaLine 472 ==> SourceLine 692
    public final char Clf021=((char)21);
    // JavaLine 474 ==> SourceLine 693
    public final char Clf022=((char)22);
    // JavaLine 476 ==> SourceLine 694
    public final char Clf023=((char)23);
    // JavaLine 478 ==> SourceLine 695
    public final char Clf024=((char)24);
    // JavaLine 480 ==> SourceLine 696
    public final char Clf025=((char)25);
    // JavaLine 482 ==> SourceLine 697
    public final char Clf026=((char)26);
    // JavaLine 484 ==> SourceLine 698
    public final char Clf027=((char)27);
    // JavaLine 486 ==> SourceLine 699
    public final char Clf028=((char)28);
    // JavaLine 488 ==> SourceLine 700
    public final char Clf029=((char)29);
    // JavaLine 490 ==> SourceLine 701
    public final char Clf030=((char)30);
    // JavaLine 492 ==> SourceLine 702
    public final char Clf031=((char)31);
    // JavaLine 494 ==> SourceLine 703
    public final char Clf032=((char)32);
    // JavaLine 496 ==> SourceLine 704
    public final char Clf033='!';
    // JavaLine 498 ==> SourceLine 705
    public final char Clf034='"';
    // JavaLine 500 ==> SourceLine 706
    public final char Clf035='#';
    // JavaLine 502 ==> SourceLine 707
    public final char Clf036='$';
    // JavaLine 504 ==> SourceLine 708
    public final char Clf037='%';
    // JavaLine 506 ==> SourceLine 709
    public final char Clf038='&';
    // JavaLine 508 ==> SourceLine 710
    public final char Clf039=((char)39);
    // JavaLine 510 ==> SourceLine 711
    public final char Clf040='(';
    // JavaLine 512 ==> SourceLine 712
    public final char Clf041=')';
    // JavaLine 514 ==> SourceLine 713
    public final char Clf042='*';
    // JavaLine 516 ==> SourceLine 714
    public final char Clf043='+';
    // JavaLine 518 ==> SourceLine 715
    public final char Clf044=',';
    // JavaLine 520 ==> SourceLine 716
    public final char Clf045='-';
    // JavaLine 522 ==> SourceLine 717
    public final char Clf046='.';
    // JavaLine 524 ==> SourceLine 718
    public final char Clf047='/';
    // JavaLine 526 ==> SourceLine 719
    public final char Clf048='0';
    // JavaLine 528 ==> SourceLine 721
    public final char Clfmax='0';
    // JavaLine 530 ==> SourceLine 744
    public int numerrfound=0;
    // JavaLine 532 ==> SourceLine 747
    public int simob_level=0;
    // JavaLine 534 ==> SourceLine 748
    public int linelength=0;
    public int signiflength=0;
    public int listlength=0;
    // JavaLine 538 ==> SourceLine 749
    public int maxnumoftags=0;
    // JavaLine 540 ==> SourceLine 750
    public char nextblhi=0;
    public char nextbllo=0;
    // JavaLine 543 ==> SourceLine 751
    public boolean simob_descr=false;
    public boolean simob_entity=false;
    public boolean simob_const=false;
    // JavaLine 547 ==> SourceLine 752
    public boolean RealCap=false;
    // JavaLine 549 ==> SourceLine 753
    public boolean definition=false;
    // JavaLine 551 ==> SourceLine 754
    public boolean recomp=false;
    // JavaLine 553 ==> SourceLine 755
    public boolean separatecomp=false;
    // JavaLine 555 ==> SourceLine 756
    public boolean listingon=false;
    public boolean GiveNotes=false;
    // JavaLine 558 ==> SourceLine 757
    public boolean SportOK=false;
    // JavaLine 560 ==> SourceLine 758
    public boolean Simuletta=false;
    // JavaLine 562 ==> SourceLine 759
    public boolean GenerateScode=false;
    // JavaLine 564 ==> SourceLine 761
    public char opt=0;
    public char opn=0;
    public char optx=0;
    // JavaLine 568 ==> SourceLine 762
    public char opdhi=0;
    public char opdlo=0;
    // JavaLine 571 ==> SourceLine 763
    public char ltype=0;
    public char rtype=0;
    // JavaLine 574 ==> SourceLine 764
    public char currentpass=0;
    // JavaLine 576 ==> SourceLine 765
    public char termstatus=0;
    // JavaLine 578 ==> SourceLine 767
    public PrintFile$ listfile=null;
    // JavaLine 580 ==> SourceLine 768
    public OutbyteFile$ L2OUPT=null;
    // JavaLine 582 ==> SourceLine 769
    public InbyteFile$ L2INPT=null;
    // JavaLine 584 ==> SourceLine 770
    public COMMON$component scanner=null;
    public COMMON$component parser=null;
    // JavaLine 587 ==> SourceLine 771
    public COMMON$outcodefile coder=null;
    // JavaLine 589 ==> SourceLine 773
    public COMMON$quantity setprefgoing=null;
    public COMMON$quantity alloc2called=null;
    // JavaLine 592 ==> SourceLine 774
    public COMMON$brecord unknowns=null;
    // JavaLine 594 ==> SourceLine 776
    public int linenr=0;
    // JavaLine 596 ==> SourceLine 777
    public int messageLinenr=0;
    // JavaLine 598 ==> SourceLine 778
    public int EXC_NUMBER=0;
    // JavaLine 600 ==> SourceLine 781
    public TXT$ listpart=null;
    // JavaLine 602 ==> SourceLine 782
    public TXT$ line=null;
    // JavaLine 604 ==> SourceLine 783
    public TXT$ L2NAME=null;
    public TXT$ nscodename=null;
    // JavaLine 607 ==> SourceLine 784
    public TXT$ timestamp=null;
    // JavaLine 609 ==> SourceLine 785
    public TXT$ progheadstring=null;
    // JavaLine 611 ==> SourceLine 786
    public TXT$ L2codebuffer=null;
    // JavaLine 613 ==> SourceLine 787
    public TXT$ predefname=null;
    // JavaLine 615 ==> SourceLine 788
    public TXT$ simsetname=null;
    public TXT$ simulaname=null;
    // JavaLine 618 ==> SourceLine 789
    public TXT$ attrfilename=null;
    public TXT$ moduleident=null;
    public TXT$ checkcode=null;
    // JavaLine 622 ==> SourceLine 791
    public TXT$ leftintbuf=null;
    // JavaLine 624 ==> SourceLine 792
    public TXT$ leftsintbuf=null;
    // JavaLine 626 ==> SourceLine 793
    public TXT$ permt=null;
    // JavaLine 628 ==> SourceLine 797
    public ARRAY$<COMMON$brctab2[]>brctab=null;
    // JavaLine 630 ==> SourceLine 798
    public ARRAY$<COMMON$quantity[]>prefixchain=null;
    // JavaLine 632 ==> SourceLine 799
    public ARRAY$<COMMON$brecord[]>display=null;
    // JavaLine 634 ==> SourceLine 800
    public ARRAY$<TXT$[]>diag=null;
    public PRCQNT$ COMMONerror$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ ENDCOMP$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public COMMON(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("COMMON",1569);
        // JavaLine 645 ==> SourceLine 69
        int[] symtab$LB=new int[1]; int[] symtab$UB=new int[1];
        symtab$LB[0]=0; symtab$UB[0]=127;
        BOUND_CHECK$(symtab$LB[0],symtab$UB[0]);
        symtab=new ARRAY$<COMMON$symbolgroup[]>(new COMMON$symbolgroup[symtab$UB[0]-symtab$LB[0]+1],symtab$LB,symtab$UB);
        // JavaLine 650 ==> SourceLine 74
        int[] hashtab$LB=new int[1]; int[] hashtab$UB=new int[1];
        hashtab$LB[0]=0; hashtab$UB[0]=255;
        BOUND_CHECK$(hashtab$LB[0],hashtab$UB[0]);
        hashtab=new ARRAY$<COMMON$symbolbox[]>(new COMMON$symbolbox[hashtab$UB[0]-hashtab$LB[0]+1],hashtab$LB,hashtab$UB);
        // JavaLine 655 ==> SourceLine 271
        int[] option$LB=new int[1]; int[] option$UB=new int[1];
        option$LB[0]=0; option$UB[0]=95;
        BOUND_CHECK$(option$LB[0],option$UB[0]);
        option=new ARRAY$<char[]>(new char[option$UB[0]-option$LB[0]+1],option$LB,option$UB);
        // JavaLine 660 ==> SourceLine 797
        int[] brctab$LB=new int[1]; int[] brctab$UB=new int[1];
        brctab$LB[0]=0; brctab$UB[0]=127;
        BOUND_CHECK$(brctab$LB[0],brctab$UB[0]);
        brctab=new ARRAY$<COMMON$brctab2[]>(new COMMON$brctab2[brctab$UB[0]-brctab$LB[0]+1],brctab$LB,brctab$UB);
        // JavaLine 665 ==> SourceLine 798
        int[] prefixchain$LB=new int[1]; int[] prefixchain$UB=new int[1];
        prefixchain$LB[0]=0; prefixchain$UB[0]=64;
        BOUND_CHECK$(prefixchain$LB[0],prefixchain$UB[0]);
        prefixchain=new ARRAY$<COMMON$quantity[]>(new COMMON$quantity[prefixchain$UB[0]-prefixchain$LB[0]+1],prefixchain$LB,prefixchain$UB);
        // JavaLine 670 ==> SourceLine 799
        int[] display$LB=new int[1]; int[] display$UB=new int[1];
        display$LB[0]=0; display$UB[0]=maxplev;
        BOUND_CHECK$(display$LB[0],display$UB[0]);
        display=new ARRAY$<COMMON$brecord[]>(new COMMON$brecord[display$UB[0]-display$LB[0]+1],display$LB,display$UB);
        // JavaLine 675 ==> SourceLine 800
        int[] diag$LB=new int[1]; int[] diag$UB=new int[1];
        diag$LB[0]=0; diag$UB[0]=5;
        BOUND_CHECK$(diag$LB[0],diag$UB[0]);
        diag=new ARRAY$<TXT$[]>(new TXT$[diag$UB[0]-diag$LB[0]+1],diag$LB,diag$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("COMMON",800,inner);
                COMMON THIS$=(COMMON)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 688 ==> SourceLine 1572
                        if(false) {
                            // JavaLine 690 ==> SourceLine 1573
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1573",1573);
                                // JavaLine 693 ==> SourceLine 1574
                                LABEL$(1); // EXCEPTION_HANDLER
                                sysout().outimage();
                                // JavaLine 696 ==> SourceLine 1575
                                if((((EXC_NUMBER==(22))||((EXC_NUMBER==(31))))||((EXC_NUMBER==(32))))) {
                                    // JavaLine 698 ==> SourceLine 1582
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1582",1582);
                                        sysout().outtext(new TXT$("*** NOT ENOUGH STORAGE AVAILABLE ***"));
                                        // JavaLine 702 ==> SourceLine 1583
                                        terminate_program();
                                        TRACE_END_STM$("CompoundStatement1582",1583);
                                    }
                                }
                                // JavaLine 707 ==> SourceLine 1585
                                ((COMMON)CUR$).COMMONerror$0().CPF().setPar((-(EXC_NUMBER))).ENT$();
                                TRACE_END_STM$("CompoundStatement1573",1585);
                            }
                        }
                        // JavaLine 712 ==> SourceLine 1588
                        giveIntInfo(1,6);
                        // JavaLine 714 ==> SourceLine 1589
                        new COMMON$StandardException(((COMMON)CUR$));
                        // JavaLine 716 ==> SourceLine 1572
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("COMMON",1572);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("COMMON",1572);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON STM$() { return((COMMON)CODE$.EXEC$()); }
    public COMMON START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class COMMON",1,1,11,1574,14,61,16,63,21,64,24,65,26,69,28,74,30,79,33,271,35,290,37,294,39,295,41,296,43,297,45,298,47,299,49,308,51,309,53,310,55,335,57,336,59,337,61,338,63,339,65,340,67,341,69,342,71,343,73,344,75,345,77,346,79,347,81,348,83,349,85,350,87,351,89,352,91,353,93,354,95,355,97,356,99,357,101,358,103,359,105,360,107,361,109,362,111,363,113,364,115,365,117,366,119,367,121,368,123,369,125,370,127,371,129,372,131,373,133,374,135,375,137,376,139,377,141,378,143,379,145,380,147,381,149,382,151,383,153,384,155,385,157,386,159,387,161,388,163,389,165,390,167,391,169,392,171,393,173,394,175,395,177,396,179,397,181,398,183,399,185,400,187,401,189,403,191,404,193,405,195,406,197,407,199,408,201,409,203,410,205,411,207,412,209,413,211,415,213,416,215,417,217,418,219,419,221,420,223,421,225,422,227,423,229,424,231,425,233,426,235,427,237,428,239,429,241,430,243,431,245,432,247,433,249,434,251,435,253,436,255,437,257,438,259,442,261,443,263,444,265,445,267,446,269,447,271,448,273,449,275,450,277,451,279,452,281,453,283,454,285,455,287,456,289,457,291,458,293,459,295,460,297,461,299,462,301,463,303,464,305,465,307,466,309,467,311,468,313,469,315,470,317,471,319,472,321,473,323,474,325,475,327,476,329,477,331,478,333,479,335,480,337,481,339,482,341,483,343,484,345,485,347,486,349,487,351,488,353,489,355,490,357,491,359,492,361,493,363,494,365,495,367,496,369,497,371,498,373,499,375,500,377,501,379,546,382,552,384,553,386,554,388,555,390,556,392,557,394,558,396,559,398,561,400,579,402,580,404,581,406,582,408,583,410,584,412,585,414,586,416,587,418,588,420,589,422,590,424,591,426,592,428,594,430,618,432,620,434,621,436,625,438,626,440,628,442,636,444,640,446,643,448,650,450,653,452,656,454,661,456,665,458,668,460,674,462,681,464,686,466,687,468,688,470,691,472,692,474,693,476,694,478,695,480,696,482,697,484,698,486,699,488,700,490,701,492,702,494,703,496,704,498,705,500,706,502,707,504,708,506,709,508,710,510,711,512,712,514,713,516,714,518,715,520,716,522,717,524,718,526,719,528,721,530,744,532,747,534,748,538,749,540,750,543,751,547,752,549,753,551,754,553,755,555,756,558,757,560,758,562,759,564,761,568,762,571,763,574,764,576,765,578,767,580,768,582,769,584,770,587,771,589,773,592,774,594,776,596,777,598,778,600,781,602,782,604,783,607,784,609,785,611,786,613,787,615,788,618,789,622,791,624,792,626,793,628,797,630,798,632,799,634,800,645,69,650,74,655,271,660,797,665,798,670,799,675,800,688,1572,690,1573,693,1574,696,1575,698,1582,702,1583,707,1585,712,1588,714,1589,716,1572,741,1591);
}
