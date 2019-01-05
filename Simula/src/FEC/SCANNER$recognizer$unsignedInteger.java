// JavaLine 1 ==> SourceLine 977
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$recognizer$unsignedInteger extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=977, lastLine=1085, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1023
    final LABQNT$ digit=new LABQNT$(this,0,1); // Local Label #1=digit
    // JavaLine 14 ==> SourceLine 1042
    final LABQNT$ nterm=new LABQNT$(this,0,2); // Local Label #2=nterm
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 981
    public char radix=0;
    // JavaLine 19 ==> SourceLine 982
    public int startpos=0;
    public int i=0;
    // JavaLine 22 ==> SourceLine 983
    public final char hexradix='@';
    // JavaLine 24 ==> SourceLine 984
    public final char decradix=':';
    // Normal Constructor
    public SCANNER$recognizer$unsignedInteger(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("unsignedInteger",984);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("unsignedInteger",984,inner);
                SCANNER$recognizer$unsignedInteger THIS$=(SCANNER$recognizer$unsignedInteger)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 41 ==> SourceLine 986
                        detach();
                        // JavaLine 43 ==> SourceLine 987
                        while(true) {
                            // JavaLine 45 ==> SourceLine 988
                            {
                                TRACE_BEGIN_STM$("CompoundStatement988",988);
                                startpos=((SCANNER$recognizer)(CUR$.SL$)).hashpos;
                                radix=decradix;
                                // JavaLine 50 ==> SourceLine 989
                                while(true) {
                                    // JavaLine 52 ==> SourceLine 990
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement990",990);
                                        switch(((SCANNER$recognizer)(CUR$.SL$)).atom) { // BEGIN SWITCH STATEMENT
                                        case 1: 
                                        case 2: 
                                        case 3: 
                                        case 4: 
                                        case 5: 
                                        case 6: 
                                        case 14: 
                                        case 15: 
                                        case 16: 
                                        case 17: 
                                        case 18: 
                                        case 19: 
                                        case 20: 
                                        case 21: 
                                        case 22: 
                                        case 23: 
                                        case 24: 
                                        case 25: 
                                        case 26: 
                                        case 27: 
                                        case 28: 
                                        case 29: 
                                        case 30: 
                                        case 31: 
                                        case 35: 
                                        case 36: 
                                        case 63: 
                                        case 64: 
                                        case 37: 
                                        case 91: 
                                        case 92: 
                                        case 93: 
                                        case 94: 
                                        case 96: 
                                        case 123: 
                                        case 124: 
                                        case 125: 
                                        case 126: 
                                        case 128: 
                                        case 129: 
                                        case 130: 
                                        case 131: 
                                        case 132: 
                                        case 133: 
                                        case 134: 
                                        case 135: 
                                        case 136: 
                                        case 137: 
                                        case 138: 
                                        case 139: 
                                        case 140: 
                                        case 141: 
                                        case 142: 
                                        case 143: 
                                        case 144: 
                                        case 145: 
                                        case 146: 
                                        case 147: 
                                        case 148: 
                                        case 149: 
                                        case 150: 
                                        case 151: 
                                        case 152: 
                                        case 153: 
                                        case 154: 
                                        case 155: 
                                        case 156: 
                                        case 157: 
                                        case 158: 
                                        case 159: 
                                        case 160: 
                                        case 161: 
                                        case 162: 
                                        case 163: 
                                        case 164: 
                                        case 165: 
                                        case 166: 
                                        case 167: 
                                        case 168: 
                                        case 169: 
                                        case 170: 
                                        case 171: 
                                        case 172: 
                                        case 173: 
                                        case 174: 
                                        case 175: 
                                        case 176: 
                                        case 177: 
                                        case 178: 
                                        case 179: 
                                        case 180: 
                                        case 181: 
                                        case 182: 
                                        case 183: 
                                        case 184: 
                                        case 185: 
                                        case 186: 
                                        case 187: 
                                        case 188: 
                                        case 189: 
                                        case 190: 
                                        case 191: 
                                        case 192: 
                                        case 193: 
                                        case 194: 
                                        case 195: 
                                        case 196: 
                                        case 197: 
                                        case 198: 
                                        case 199: 
                                        case 200: 
                                        case 201: 
                                        case 202: 
                                        case 203: 
                                        case 204: 
                                        case 205: 
                                        case 206: 
                                        case 207: 
                                        case 208: 
                                        case 209: 
                                        case 210: 
                                        case 211: 
                                        case 212: 
                                        case 213: 
                                        case 214: 
                                        case 215: 
                                        case 216: 
                                        case 217: 
                                        case 218: 
                                        case 219: 
                                        case 220: 
                                        case 221: 
                                        case 222: 
                                        case 223: 
                                        case 224: 
                                        case 225: 
                                        case 226: 
                                        case 227: 
                                        case 228: 
                                        case 229: 
                                        case 230: 
                                        case 231: 
                                        case 232: 
                                        case 233: 
                                        case 234: 
                                        case 235: 
                                        case 236: 
                                        case 237: 
                                        case 238: 
                                        case 239: 
                                        case 240: 
                                        case 241: 
                                        case 242: 
                                        case 243: 
                                        case 244: 
                                        case 245: 
                                        case 246: 
                                        case 247: 
                                        case 248: 
                                        case 249: 
                                        case 250: 
                                        case 251: 
                                        case 252: 
                                        case 253: 
                                        case 254: 
                                        case 255: 
                                        // JavaLine 222 ==> SourceLine 996
                                        new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)(CUR$.SL$)));
                                        case 0: 
                                        case 95: 
                                        case 127: 
                                        case 7: 
                                        // JavaLine 228 ==> SourceLine 1001
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1001",1001);
                                            if((((SCANNER$recognizer)(CUR$.SL$)).linepos==(((SCANNER$recognizer)(CUR$.SL$)).linelength))) {
                                                GOTO$(nterm); // GOTO EVALUATED LABEL
                                            }
                                            // JavaLine 234 ==> SourceLine 1002
                                            new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)(CUR$.SL$)));
                                            TRACE_END_STM$("CompoundStatement1001",1002);
                                        }
                                        case 114: 
                                        case 82: 
                                        // JavaLine 240 ==> SourceLine 1005
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1005",1005);
                                            i=(((SCANNER$recognizer)(CUR$.SL$)).hashpos-(startpos));
                                            // JavaLine 244 ==> SourceLine 1006
                                            if((((i==(1))||((i==(2))))&&((radix==(decradix))))) {
                                                // JavaLine 246 ==> SourceLine 1008
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1008",1008);
                                                    i=TXT$.getint(TXT$.sub(((SCANNER$recognizer)(CUR$.SL$)).hashbuf,(startpos+(1)),i));
                                                    // JavaLine 250 ==> SourceLine 1009
                                                    if(((((i==(2))|((i==(4))))|((i==(8))))|((i==(16))))) {
                                                        // JavaLine 252 ==> SourceLine 1010
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1010",1010);
                                                            radix=char$((48+(i)));
                                                            // JavaLine 256 ==> SourceLine 1011
                                                            ((SCANNER$recognizer)(CUR$.SL$)).atom='R';
                                                            GOTO$(digit); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement1010",1011);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1008",1011);
                                                }
                                            }
                                            // JavaLine 265 ==> SourceLine 1013
                                            GOTO$(nterm); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1005",1013);
                                        }
                                        case 48: 
                                        // JavaLine 270 ==> SourceLine 1016
                                        if((!(((SCANNER$recognizer)(CUR$.SL$)).skipzeroes))) {
                                            // JavaLine 272 ==> SourceLine 1017
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1017",1017);
                                                storeChar(((SCANNER$recognizer)(CUR$.SL$)).atom,((SCANNER$recognizer)(CUR$.SL$)).hashbuf,((SCANNER$recognizer)(CUR$.SL$)).hashpos);
                                                // JavaLine 276 ==> SourceLine 1018
                                                ((SCANNER$recognizer)(CUR$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$)).hashpos+(1));
                                                TRACE_END_STM$("CompoundStatement1017",1018);
                                            }
                                        }
                                        case 49: 
                                        case 50: 
                                        case 51: 
                                        case 52: 
                                        case 53: 
                                        case 54: 
                                        case 55: 
                                        case 56: 
                                        case 57: 
                                        // JavaLine 290 ==> SourceLine 1021
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1021",1021);
                                            if((((SCANNER$recognizer)(CUR$.SL$)).atom>=(radix))) {
                                                // JavaLine 294 ==> SourceLine 1022
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1022",1022);
                                                    new SCANNER$P1error(((SCANNER)(CUR$.SL$.SL$)),183);
                                                    ((SCANNER$recognizer)(CUR$.SL$)).atom='0';
                                                    TRACE_END_STM$("CompoundStatement1022",1022);
                                                }
                                            }
                                            // JavaLine 302 ==> SourceLine 1023
                                            LABEL$(1); // digit
                                            ((SCANNER$recognizer)(CUR$.SL$)).skipzeroes=false;
                                            // JavaLine 305 ==> SourceLine 1024
                                            storeChar(((SCANNER$recognizer)(CUR$.SL$)).atom,((SCANNER$recognizer)(CUR$.SL$)).hashbuf,((SCANNER$recognizer)(CUR$.SL$)).hashpos);
                                            // JavaLine 307 ==> SourceLine 1025
                                            ((SCANNER$recognizer)(CUR$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$)).hashpos+(1));
                                            TRACE_END_STM$("CompoundStatement1021",1025);
                                        }
                                        case 97: 
                                        case 98: 
                                        case 99: 
                                        case 100: 
                                        case 101: 
                                        case 102: 
                                        case 65: 
                                        case 66: 
                                        case 67: 
                                        case 68: 
                                        case 69: 
                                        case 70: 
                                        // JavaLine 323 ==> SourceLine 1028
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1028",1028);
                                            if((radix!=(hexradix))) {
                                                GOTO$(nterm); // GOTO EVALUATED LABEL
                                            }
                                            // JavaLine 329 ==> SourceLine 1029
                                            if((((SCANNER$recognizer)(CUR$.SL$)).atom>=('a'))) {
                                                ((SCANNER$recognizer)(CUR$.SL$)).atom=char$((rank(((SCANNER$recognizer)(CUR$.SL$)).atom)-(32)));
                                            }
                                            // JavaLine 333 ==> SourceLine 1030
                                            GOTO$(digit); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1028",1030);
                                        }
                                        default:
                                        // JavaLine 338 ==> SourceLine 1033
                                        GOTO$(nterm); // GOTO EVALUATED LABEL
                                    } // END SWITCH STATEMENT
                                    // JavaLine 341 ==> SourceLine 1037
                                    ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$)).linepos);
                                    ((SCANNER$recognizer)(CUR$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$)).linepos+(1));
                                    TRACE_END_STM$("CompoundStatement990",1037);
                                }
                                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                            }
                            // JavaLine 348 ==> SourceLine 1042
                            LABEL$(2); // nterm
                            ((SCANNER$recognizer)(CUR$.SL$)).skipzeroes=false;
                            // JavaLine 351 ==> SourceLine 1043
                            if((startpos==(((SCANNER$recognizer)(CUR$.SL$)).hashpos))) {
                                // JavaLine 353 ==> SourceLine 1044
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1044",1044);
                                    storeChar('0',((SCANNER$recognizer)(CUR$.SL$)).hashbuf,((SCANNER$recognizer)(CUR$.SL$)).hashpos);
                                    ((SCANNER$recognizer)(CUR$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$)).hashpos+(1));
                                    TRACE_END_STM$("CompoundStatement1044",1044);
                                }
                            } else
                            // JavaLine 361 ==> SourceLine 1045
                            if((radix!=(decradix))) {
                                // JavaLine 363 ==> SourceLine 1079
                                new SCANNER$recognizer$unsignedInteger$CompoundStatement988$SubBlock1046(CUR$).STM$();
                            }
                            // JavaLine 366 ==> SourceLine 1082
                            detach();
                            TRACE_END_STM$("CompoundStatement988",1082);
                        }
                           if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                    }
                    // JavaLine 372 ==> SourceLine 986
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("unsignedInteger",986);
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
            TRACE_END_STM$("unsignedInteger",986);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public SCANNER$recognizer$unsignedInteger STM$() { return((SCANNER$recognizer$unsignedInteger)CODE$.EXEC$()); }
public SCANNER$recognizer$unsignedInteger START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class unsignedInteger",1,977,12,1023,14,1042,17,981,19,982,22,983,24,984,41,986,43,987,45,988,50,989,52,990,222,996,228,1001,234,1002,240,1005,244,1006,246,1008,250,1009,252,1010,256,1011,265,1013,270,1016,272,1017,276,1018,290,1021,294,1022,302,1023,305,1024,307,1025,323,1028,329,1029,333,1030,338,1033,341,1037,348,1042,351,1043,353,1044,361,1045,363,1079,366,1082,372,986,397,1085);
}
