// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=12, lastLine=566, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 14 ==> SourceLine 14
    public ARRAY$<TXT$[]>ut=null;
    public ARRAY$<TXT$[]>answer=null;
    // JavaLine 17 ==> SourceLine 15
    int utno=0;
    // JavaLine 19 ==> SourceLine 83
    public ARRAY$<simtst107$PBLK12$p[]>pa=null;
    // JavaLine 21 ==> SourceLine 84
    public ARRAY$<boolean[]>active=null;
    public ARRAY$<boolean[]>passive=null;
    public ARRAY$<boolean[]>terminatd=null;
    // JavaLine 25 ==> SourceLine 85
    int i=0;
    int testno=0;
    // JavaLine 28 ==> SourceLine 86
    TXT$ activationtimes=null;
    TXT$ delaytimes=null;
    TXT$ actime=null;
    // Normal Constructor
    public simtst107$PBLK12(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("simtst107$PBLK12");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst107$PBLK12",86);
        // JavaLine 39 ==> SourceLine 14
        int[] ut$LB=new int[1]; int[] ut$UB=new int[1];
        ut$LB[0]=1; ut$UB[0]=250;
        BOUND_CHECK$(ut$LB[0],ut$UB[0]);
        ut=new ARRAY$<TXT$[]>(new TXT$[ut$UB[0]-ut$LB[0]+1],ut$LB,ut$UB);
        int[] answer$LB=new int[1]; int[] answer$UB=new int[1];
        answer$LB[0]=1; answer$UB[0]=250;
        BOUND_CHECK$(answer$LB[0],answer$UB[0]);
        answer=new ARRAY$<TXT$[]>(new TXT$[answer$UB[0]-answer$LB[0]+1],answer$LB,answer$UB);
        // JavaLine 48 ==> SourceLine 83
        int[] pa$LB=new int[1]; int[] pa$UB=new int[1];
        pa$LB[0]=1; pa$UB[0]=10;
        BOUND_CHECK$(pa$LB[0],pa$UB[0]);
        pa=new ARRAY$<simtst107$PBLK12$p[]>(new simtst107$PBLK12$p[pa$UB[0]-pa$LB[0]+1],pa$LB,pa$UB);
        // JavaLine 53 ==> SourceLine 84
        int[] active$LB=new int[1]; int[] active$UB=new int[1];
        active$LB[0]=1; active$UB[0]=10;
        BOUND_CHECK$(active$LB[0],active$UB[0]);
        active=new ARRAY$<boolean[]>(new boolean[active$UB[0]-active$LB[0]+1],active$LB,active$UB);
        int[] passive$LB=new int[1]; int[] passive$UB=new int[1];
        passive$LB[0]=1; passive$UB[0]=10;
        BOUND_CHECK$(passive$LB[0],passive$UB[0]);
        passive=new ARRAY$<boolean[]>(new boolean[passive$UB[0]-passive$LB[0]+1],passive$LB,passive$UB);
        int[] terminatd$LB=new int[1]; int[] terminatd$UB=new int[1];
        terminatd$LB[0]=1; terminatd$UB[0]=10;
        BOUND_CHECK$(terminatd$LB[0],terminatd$UB[0]);
        terminatd=new ARRAY$<boolean[]>(new boolean[terminatd$UB[0]-terminatd$LB[0]+1],terminatd$LB,terminatd$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst107$PBLK12",84,inner);
                // JavaLine 70 ==> SourceLine 88
                sysout().outtext(new TXT$("--- START Simula a.s. - TEST No. 97      ---"));
                sysout().outimage();
                // JavaLine 73 ==> SourceLine 89
                sysout().outtext(new TXT$("--- Tests Process, activation statements, ---"));
                sysout().outimage();
                // JavaLine 76 ==> SourceLine 90
                sysout().outtext(new TXT$("--- idle, terminated, time.               ---"));
                sysout().outimage();
                // JavaLine 79 ==> SourceLine 93
                answer.Elt[1-answer.LB[0]]=copy(copy(new TXT$("p(10) activated at time =    0.000")));
                // JavaLine 81 ==> SourceLine 95
                answer.Elt[2-answer.LB[0]]=copy(copy(new TXT$("State(1,10): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s    a")));
                // JavaLine 83 ==> SourceLine 97
                answer.Elt[3-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     p     p     p     p     p     a")));
                // JavaLine 85 ==> SourceLine 99
                answer.Elt[4-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  idle  idle  idle  idle  idle  0.00")));
                // JavaLine 87 ==> SourceLine 101
                answer.Elt[5-answer.LB[0]]=copy(copy(new TXT$("p( 9) activated at time =    0.000")));
                // JavaLine 89 ==> SourceLine 103
                answer.Elt[6-answer.LB[0]]=copy(copy(new TXT$("State(1, 9): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s    a     t")));
                // JavaLine 91 ==> SourceLine 105
                answer.Elt[7-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     p     p     p     p     a     t")));
                // JavaLine 93 ==> SourceLine 107
                answer.Elt[8-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  idle  idle  idle  idle  0.00  idle")));
                // JavaLine 95 ==> SourceLine 109
                answer.Elt[9-answer.LB[0]]=copy(copy(new TXT$("p( 8) activated at time =    0.000")));
                // JavaLine 97 ==> SourceLine 111
                answer.Elt[10-answer.LB[0]]=copy(copy(new TXT$("State(1, 8): p/s   p/s   p/s   p/s   p/s   p/s   p/s    a     t     t")));
                // JavaLine 99 ==> SourceLine 113
                answer.Elt[11-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     p     p     p     a     t     t")));
                // JavaLine 101 ==> SourceLine 115
                answer.Elt[12-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  idle  idle  idle  0.00  idle  idle")));
                // JavaLine 103 ==> SourceLine 117
                answer.Elt[13-answer.LB[0]]=copy(copy(new TXT$("p( 7) activated at time =    0.000")));
                // JavaLine 105 ==> SourceLine 119
                answer.Elt[14-answer.LB[0]]=copy(copy(new TXT$("State(1, 7): p/s   p/s   p/s   p/s   p/s   p/s    a     t     t     t")));
                // JavaLine 107 ==> SourceLine 121
                answer.Elt[15-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     p     p     a     t     t     t")));
                // JavaLine 109 ==> SourceLine 123
                answer.Elt[16-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  idle  idle  0.00  idle  idle  idle")));
                // JavaLine 111 ==> SourceLine 125
                answer.Elt[17-answer.LB[0]]=copy(copy(new TXT$("p( 6) activated at time =    0.000")));
                // JavaLine 113 ==> SourceLine 127
                answer.Elt[18-answer.LB[0]]=copy(copy(new TXT$("State(1, 6): p/s   p/s   p/s   p/s   p/s    a     t     t     t     t")));
                // JavaLine 115 ==> SourceLine 129
                answer.Elt[19-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     p     a     t     t     t     t")));
                // JavaLine 117 ==> SourceLine 131
                answer.Elt[20-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  idle  0.00  idle  idle  idle  idle")));
                // JavaLine 119 ==> SourceLine 133
                answer.Elt[21-answer.LB[0]]=copy(copy(new TXT$("p( 5) activated at time =    0.000")));
                // JavaLine 121 ==> SourceLine 135
                answer.Elt[22-answer.LB[0]]=copy(copy(new TXT$("State(1, 5): p/s   p/s   p/s   p/s    a     t     t     t     t     t")));
                // JavaLine 123 ==> SourceLine 137
                answer.Elt[23-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     p     a     t     t     t     t     t")));
                // JavaLine 125 ==> SourceLine 139
                answer.Elt[24-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  idle  0.00  idle  idle  idle  idle  idle")));
                // JavaLine 127 ==> SourceLine 141
                answer.Elt[25-answer.LB[0]]=copy(copy(new TXT$("p( 4) activated at time =    0.000")));
                // JavaLine 129 ==> SourceLine 143
                answer.Elt[26-answer.LB[0]]=copy(copy(new TXT$("State(1, 4): p/s   p/s   p/s    a     t     t     t     t     t     t")));
                // JavaLine 131 ==> SourceLine 145
                answer.Elt[27-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     p     a     t     t     t     t     t     t")));
                // JavaLine 133 ==> SourceLine 147
                answer.Elt[28-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  idle  0.00  idle  idle  idle  idle  idle  idle")));
                // JavaLine 135 ==> SourceLine 149
                answer.Elt[29-answer.LB[0]]=copy(copy(new TXT$("p( 3) activated at time =    0.000")));
                // JavaLine 137 ==> SourceLine 151
                answer.Elt[30-answer.LB[0]]=copy(copy(new TXT$("State(1, 3): p/s   p/s    a     t     t     t     t     t     t     t")));
                // JavaLine 139 ==> SourceLine 153
                answer.Elt[31-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     p     a     t     t     t     t     t     t     t")));
                // JavaLine 141 ==> SourceLine 155
                answer.Elt[32-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  idle  0.00  idle  idle  idle  idle  idle  idle  idle")));
                // JavaLine 143 ==> SourceLine 157
                answer.Elt[33-answer.LB[0]]=copy(copy(new TXT$("p( 2) activated at time =    0.000")));
                // JavaLine 145 ==> SourceLine 159
                answer.Elt[34-answer.LB[0]]=copy(copy(new TXT$("State(1, 2): p/s    a     t     t     t     t     t     t     t     t")));
                // JavaLine 147 ==> SourceLine 161
                answer.Elt[35-answer.LB[0]]=copy(copy(new TXT$("SQS:          p     a     t     t     t     t     t     t     t     t")));
                // JavaLine 149 ==> SourceLine 163
                answer.Elt[36-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     idle  0.00  idle  idle  idle  idle  idle  idle  idle  idle")));
                // JavaLine 151 ==> SourceLine 165
                answer.Elt[37-answer.LB[0]]=copy(copy(new TXT$("p( 1) activated at time =    0.000")));
                // JavaLine 153 ==> SourceLine 167
                answer.Elt[38-answer.LB[0]]=copy(copy(new TXT$("State(1, 1):  a     t     t     t     t     t     t     t     t     t")));
                // JavaLine 155 ==> SourceLine 169
                answer.Elt[39-answer.LB[0]]=copy(copy(new TXT$("SQS:          a     t     t     t     t     t     t     t     t     t")));
                // JavaLine 157 ==> SourceLine 171
                answer.Elt[40-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     0.00  idle  idle  idle  idle  idle  idle  idle  idle  idle")));
                // JavaLine 159 ==> SourceLine 173
                answer.Elt[41-answer.LB[0]]=copy(copy(new TXT$("State(2, 0): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 161 ==> SourceLine 175
                answer.Elt[42-answer.LB[0]]=copy(copy(new TXT$("SQS:          s     s     s     s     s     s     s     s     s     s")));
                // JavaLine 163 ==> SourceLine 177
                answer.Elt[43-answer.LB[0]]=copy(copy(new TXT$("  0.00 :     1.53  7.60  2.00  4.19  2.01  1.84  2.00  8.00  9.25  5.40")));
                // JavaLine 165 ==> SourceLine 179
                answer.Elt[44-answer.LB[0]]=copy(copy(new TXT$("p( 1) activated at time =    1.530")));
                // JavaLine 167 ==> SourceLine 181
                answer.Elt[45-answer.LB[0]]=copy(copy(new TXT$("State(2, 1):  a    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 169 ==> SourceLine 183
                answer.Elt[46-answer.LB[0]]=copy(copy(new TXT$("SQS:          a     s     s     s     s     s     s     s     s     s")));
                // JavaLine 171 ==> SourceLine 185
                answer.Elt[47-answer.LB[0]]=copy(copy(new TXT$("  1.53 :     1.53  7.60  2.00  4.19  2.01  1.84  2.00  8.00  9.25  5.40")));
                // JavaLine 173 ==> SourceLine 187
                answer.Elt[48-answer.LB[0]]=copy(copy(new TXT$("p( 6) activated at time =    1.840")));
                // JavaLine 175 ==> SourceLine 189
                answer.Elt[49-answer.LB[0]]=copy(copy(new TXT$("State(2, 6):  t    p/s   p/s   p/s   p/s    a    p/s   p/s   p/s   p/s")));
                // JavaLine 177 ==> SourceLine 191
                answer.Elt[50-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     s     s     s     a     s     s     s     s")));
                // JavaLine 179 ==> SourceLine 193
                answer.Elt[51-answer.LB[0]]=copy(copy(new TXT$("  1.84 :     idle  7.60  2.00  4.19  2.01  1.84  2.00  8.00  9.25  5.40")));
                // JavaLine 181 ==> SourceLine 195
                answer.Elt[52-answer.LB[0]]=copy(copy(new TXT$("p( 3) activated at time =    2.000")));
                // JavaLine 183 ==> SourceLine 197
                answer.Elt[53-answer.LB[0]]=copy(copy(new TXT$("State(2, 3):  t    p/s    a    p/s   p/s    t    p/s   p/s   p/s   p/s")));
                // JavaLine 185 ==> SourceLine 199
                answer.Elt[54-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     a     s     s     t     s     s     s     s")));
                // JavaLine 187 ==> SourceLine 201
                answer.Elt[55-answer.LB[0]]=copy(copy(new TXT$("  2.00 :     idle  7.60  2.00  4.19  2.01  idle  2.00  8.00  9.25  5.40")));
                // JavaLine 189 ==> SourceLine 203
                answer.Elt[56-answer.LB[0]]=copy(copy(new TXT$("p( 7) activated at time =    2.000")));
                // JavaLine 191 ==> SourceLine 205
                answer.Elt[57-answer.LB[0]]=copy(copy(new TXT$("State(2, 7):  t    p/s    t    p/s   p/s    t     a    p/s   p/s   p/s")));
                // JavaLine 193 ==> SourceLine 207
                answer.Elt[58-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     s     s     t     a     s     s     s")));
                // JavaLine 195 ==> SourceLine 209
                answer.Elt[59-answer.LB[0]]=copy(copy(new TXT$("  2.00 :     idle  7.60  idle  4.19  2.01  idle  2.00  8.00  9.25  5.40")));
                // JavaLine 197 ==> SourceLine 211
                answer.Elt[60-answer.LB[0]]=copy(copy(new TXT$("p( 5) activated at time =    2.010")));
                // JavaLine 199 ==> SourceLine 213
                answer.Elt[61-answer.LB[0]]=copy(copy(new TXT$("State(2, 5):  t    p/s    t    p/s    a     t     t    p/s   p/s   p/s")));
                // JavaLine 201 ==> SourceLine 215
                answer.Elt[62-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     s     a     t     t     s     s     s")));
                // JavaLine 203 ==> SourceLine 217
                answer.Elt[63-answer.LB[0]]=copy(copy(new TXT$("  2.01 :     idle  7.60  idle  4.19  2.01  idle  idle  8.00  9.25  5.40")));
                // JavaLine 205 ==> SourceLine 219
                answer.Elt[64-answer.LB[0]]=copy(copy(new TXT$("p( 4) activated at time =    4.190")));
                // JavaLine 207 ==> SourceLine 221
                answer.Elt[65-answer.LB[0]]=copy(copy(new TXT$("State(2, 4):  t    p/s    t     a     t     t     t    p/s   p/s   p/s")));
                // JavaLine 209 ==> SourceLine 223
                answer.Elt[66-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     a     t     t     t     s     s     s")));
                // JavaLine 211 ==> SourceLine 225
                answer.Elt[67-answer.LB[0]]=copy(copy(new TXT$("  4.19 :     idle  7.60  idle  4.19  idle  idle  idle  8.00  9.25  5.40")));
                // JavaLine 213 ==> SourceLine 227
                answer.Elt[68-answer.LB[0]]=copy(copy(new TXT$("p(10) activated at time =    5.400")));
                // JavaLine 215 ==> SourceLine 229
                answer.Elt[69-answer.LB[0]]=copy(copy(new TXT$("State(2,10):  t    p/s    t     t     t     t     t    p/s   p/s    a")));
                // JavaLine 217 ==> SourceLine 231
                answer.Elt[70-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     t     t     t     t     s     s     a")));
                // JavaLine 219 ==> SourceLine 233
                answer.Elt[71-answer.LB[0]]=copy(copy(new TXT$("  5.40 :     idle  7.60  idle  idle  idle  idle  idle  8.00  9.25  5.40")));
                // JavaLine 221 ==> SourceLine 235
                answer.Elt[72-answer.LB[0]]=copy(copy(new TXT$("p( 2) activated at time =    7.600")));
                // JavaLine 223 ==> SourceLine 237
                answer.Elt[73-answer.LB[0]]=copy(copy(new TXT$("State(2, 2):  t     a     t     t     t     t     t    p/s   p/s    t")));
                // JavaLine 225 ==> SourceLine 239
                answer.Elt[74-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     a     t     t     t     t     t     s     s     t")));
                // JavaLine 227 ==> SourceLine 241
                answer.Elt[75-answer.LB[0]]=copy(copy(new TXT$("  7.60 :     idle  7.60  idle  idle  idle  idle  idle  8.00  9.25  idle")));
                // JavaLine 229 ==> SourceLine 243
                answer.Elt[76-answer.LB[0]]=copy(copy(new TXT$("p( 8) activated at time =    8.000")));
                // JavaLine 231 ==> SourceLine 245
                answer.Elt[77-answer.LB[0]]=copy(copy(new TXT$("State(2, 8):  t     t     t     t     t     t     t     a    p/s    t")));
                // JavaLine 233 ==> SourceLine 247
                answer.Elt[78-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     t     t     t     t     t     a     s     t")));
                // JavaLine 235 ==> SourceLine 249
                answer.Elt[79-answer.LB[0]]=copy(copy(new TXT$("  8.00 :     idle  idle  idle  idle  idle  idle  idle  8.00  9.25  idle")));
                // JavaLine 237 ==> SourceLine 251
                answer.Elt[80-answer.LB[0]]=copy(copy(new TXT$("p( 9) activated at time =    9.250")));
                // JavaLine 239 ==> SourceLine 253
                answer.Elt[81-answer.LB[0]]=copy(copy(new TXT$("State(2, 9):  t     t     t     t     t     t     t     t     a     t")));
                // JavaLine 241 ==> SourceLine 255
                answer.Elt[82-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     t     t     t     t     t     t     a     t")));
                // JavaLine 243 ==> SourceLine 257
                answer.Elt[83-answer.LB[0]]=copy(copy(new TXT$("  9.25 :     idle  idle  idle  idle  idle  idle  idle  idle  9.25  idle")));
                // JavaLine 245 ==> SourceLine 259
                answer.Elt[84-answer.LB[0]]=copy(copy(new TXT$("State(3, 0): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 247 ==> SourceLine 261
                answer.Elt[85-answer.LB[0]]=copy(copy(new TXT$("SQS:          s     s     s     s     s     s     s     s     s     s")));
                // JavaLine 249 ==> SourceLine 263
                answer.Elt[86-answer.LB[0]]=copy(copy(new TXT$(" 20.00 :    21.53 27.60 22.00 24.19 22.01 21.84 22.00 28.00 29.25 25.40")));
                // JavaLine 251 ==> SourceLine 265
                answer.Elt[87-answer.LB[0]]=copy(copy(new TXT$("p( 1) activated at time =   21.530")));
                // JavaLine 253 ==> SourceLine 267
                answer.Elt[88-answer.LB[0]]=copy(copy(new TXT$("State(3, 1):  a    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 255 ==> SourceLine 269
                answer.Elt[89-answer.LB[0]]=copy(copy(new TXT$("SQS:          a     s     s     s     s     s     s     s     s     s")));
                // JavaLine 257 ==> SourceLine 271
                answer.Elt[90-answer.LB[0]]=copy(copy(new TXT$(" 21.53 :    21.53 27.60 22.00 24.19 22.01 21.84 22.00 28.00 29.25 25.40")));
                // JavaLine 259 ==> SourceLine 273
                answer.Elt[91-answer.LB[0]]=copy(copy(new TXT$("p( 6) activated at time =   21.840")));
                // JavaLine 261 ==> SourceLine 275
                answer.Elt[92-answer.LB[0]]=copy(copy(new TXT$("State(3, 6):  t    p/s   p/s   p/s   p/s    a    p/s   p/s   p/s   p/s")));
                // JavaLine 263 ==> SourceLine 277
                answer.Elt[93-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     s     s     s     a     s     s     s     s")));
                // JavaLine 265 ==> SourceLine 279
                answer.Elt[94-answer.LB[0]]=copy(copy(new TXT$(" 21.84 :     idle 27.60 22.00 24.19 22.01 21.84 22.00 28.00 29.25 25.40")));
                // JavaLine 267 ==> SourceLine 281
                answer.Elt[95-answer.LB[0]]=copy(copy(new TXT$("p( 7) activated at time =   22.000")));
                // JavaLine 269 ==> SourceLine 283
                answer.Elt[96-answer.LB[0]]=copy(copy(new TXT$("State(3, 7):  t    p/s   p/s   p/s   p/s    t     a    p/s   p/s   p/s")));
                // JavaLine 271 ==> SourceLine 285
                answer.Elt[97-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     s     s     s     t     a     s     s     s")));
                // JavaLine 273 ==> SourceLine 287
                answer.Elt[98-answer.LB[0]]=copy(copy(new TXT$(" 22.00 :     idle 27.60 22.00 24.19 22.01  idle 22.00 28.00 29.25 25.40")));
                // JavaLine 275 ==> SourceLine 289
                answer.Elt[99-answer.LB[0]]=copy(copy(new TXT$("p( 3) activated at time =   22.000")));
                // JavaLine 277 ==> SourceLine 291
                answer.Elt[100-answer.LB[0]]=copy(copy(new TXT$("State(3, 3):  t    p/s    a    p/s   p/s    t     t    p/s   p/s   p/s")));
                // JavaLine 279 ==> SourceLine 293
                answer.Elt[101-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     a     s     s     t     t     s     s     s")));
                // JavaLine 281 ==> SourceLine 295
                answer.Elt[102-answer.LB[0]]=copy(copy(new TXT$(" 22.00 :     idle 27.60 22.00 24.19 22.01  idle  idle 28.00 29.25 25.40")));
                // JavaLine 283 ==> SourceLine 297
                answer.Elt[103-answer.LB[0]]=copy(copy(new TXT$("p( 5) activated at time =   22.010")));
                // JavaLine 285 ==> SourceLine 299
                answer.Elt[104-answer.LB[0]]=copy(copy(new TXT$("State(3, 5):  t    p/s    t    p/s    a     t     t    p/s   p/s   p/s")));
                // JavaLine 287 ==> SourceLine 301
                answer.Elt[105-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     s     a     t     t     s     s     s")));
                // JavaLine 289 ==> SourceLine 303
                answer.Elt[106-answer.LB[0]]=copy(copy(new TXT$(" 22.01 :     idle 27.60  idle 24.19 22.01  idle  idle 28.00 29.25 25.40")));
                // JavaLine 291 ==> SourceLine 305
                answer.Elt[107-answer.LB[0]]=copy(copy(new TXT$("p( 4) activated at time =   24.190")));
                // JavaLine 293 ==> SourceLine 307
                answer.Elt[108-answer.LB[0]]=copy(copy(new TXT$("State(3, 4):  t    p/s    t     a     t     t     t    p/s   p/s   p/s")));
                // JavaLine 295 ==> SourceLine 309
                answer.Elt[109-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     a     t     t     t     s     s     s")));
                // JavaLine 297 ==> SourceLine 311
                answer.Elt[110-answer.LB[0]]=copy(copy(new TXT$(" 24.19 :     idle 27.60  idle 24.19  idle  idle  idle 28.00 29.25 25.40")));
                // JavaLine 299 ==> SourceLine 313
                answer.Elt[111-answer.LB[0]]=copy(copy(new TXT$("p(10) activated at time =   25.400")));
                // JavaLine 301 ==> SourceLine 315
                answer.Elt[112-answer.LB[0]]=copy(copy(new TXT$("State(3,10):  t    p/s    t     t     t     t     t    p/s   p/s    a")));
                // JavaLine 303 ==> SourceLine 317
                answer.Elt[113-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     s     t     t     t     t     t     s     s     a")));
                // JavaLine 305 ==> SourceLine 319
                answer.Elt[114-answer.LB[0]]=copy(copy(new TXT$(" 25.40 :     idle 27.60  idle  idle  idle  idle  idle 28.00 29.25 25.40")));
                // JavaLine 307 ==> SourceLine 321
                answer.Elt[115-answer.LB[0]]=copy(copy(new TXT$("p( 2) activated at time =   27.600")));
                // JavaLine 309 ==> SourceLine 323
                answer.Elt[116-answer.LB[0]]=copy(copy(new TXT$("State(3, 2):  t     a     t     t     t     t     t    p/s   p/s    t")));
                // JavaLine 311 ==> SourceLine 325
                answer.Elt[117-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     a     t     t     t     t     t     s     s     t")));
                // JavaLine 313 ==> SourceLine 327
                answer.Elt[118-answer.LB[0]]=copy(copy(new TXT$(" 27.60 :     idle 27.60  idle  idle  idle  idle  idle 28.00 29.25  idle")));
                // JavaLine 315 ==> SourceLine 329
                answer.Elt[119-answer.LB[0]]=copy(copy(new TXT$("p( 8) activated at time =   28.000")));
                // JavaLine 317 ==> SourceLine 331
                answer.Elt[120-answer.LB[0]]=copy(copy(new TXT$("State(3, 8):  t     t     t     t     t     t     t     a    p/s    t")));
                // JavaLine 319 ==> SourceLine 333
                answer.Elt[121-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     t     t     t     t     t     a     s     t")));
                // JavaLine 321 ==> SourceLine 335
                answer.Elt[122-answer.LB[0]]=copy(copy(new TXT$(" 28.00 :     idle  idle  idle  idle  idle  idle  idle 28.00 29.25  idle")));
                // JavaLine 323 ==> SourceLine 337
                answer.Elt[123-answer.LB[0]]=copy(copy(new TXT$("p( 9) activated at time =   29.250")));
                // JavaLine 325 ==> SourceLine 339
                answer.Elt[124-answer.LB[0]]=copy(copy(new TXT$("State(3, 9):  t     t     t     t     t     t     t     t     a     t")));
                // JavaLine 327 ==> SourceLine 341
                answer.Elt[125-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     t     t     t     t     t     t     a     t")));
                // JavaLine 329 ==> SourceLine 343
                answer.Elt[126-answer.LB[0]]=copy(copy(new TXT$(" 29.25 :     idle  idle  idle  idle  idle  idle  idle  idle 29.25  idle")));
                // JavaLine 331 ==> SourceLine 345
                answer.Elt[127-answer.LB[0]]=copy(copy(new TXT$("State(4, 0): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 333 ==> SourceLine 347
                answer.Elt[128-answer.LB[0]]=copy(copy(new TXT$("SQS:          s     s     s     s     s     s     s     s     s     s")));
                // JavaLine 335 ==> SourceLine 349
                answer.Elt[129-answer.LB[0]]=copy(copy(new TXT$(" 40.00 :    41.53 41.53 47.60 47.60 42.00 42.00 44.19 44.19 42.01 42.01")));
                // JavaLine 337 ==> SourceLine 351
                answer.Elt[130-answer.LB[0]]=copy(copy(new TXT$("p( 2) activated at time =   41.530")));
                // JavaLine 339 ==> SourceLine 353
                answer.Elt[131-answer.LB[0]]=copy(copy(new TXT$("State(4, 2): p/s    a    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 341 ==> SourceLine 355
                answer.Elt[132-answer.LB[0]]=copy(copy(new TXT$("SQS:          s     a     s     s     s     s     s     s     s     s")));
                // JavaLine 343 ==> SourceLine 357
                answer.Elt[133-answer.LB[0]]=copy(copy(new TXT$(" 41.53 :    41.53 41.53 47.60 47.60 42.00 42.00 44.19 44.19 42.01 42.01")));
                // JavaLine 345 ==> SourceLine 359
                answer.Elt[134-answer.LB[0]]=copy(copy(new TXT$("p( 1) activated at time =   41.530")));
                // JavaLine 347 ==> SourceLine 361
                answer.Elt[135-answer.LB[0]]=copy(copy(new TXT$("State(4, 1):  a     t    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 349 ==> SourceLine 363
                answer.Elt[136-answer.LB[0]]=copy(copy(new TXT$("SQS:          a     t     s     s     s     s     s     s     s     s")));
                // JavaLine 351 ==> SourceLine 365
                answer.Elt[137-answer.LB[0]]=copy(copy(new TXT$(" 41.53 :    41.53  idle 47.60 47.60 42.00 42.00 44.19 44.19 42.01 42.01")));
                // JavaLine 353 ==> SourceLine 367
                answer.Elt[138-answer.LB[0]]=copy(copy(new TXT$("p( 6) activated at time =   42.000")));
                // JavaLine 355 ==> SourceLine 369
                answer.Elt[139-answer.LB[0]]=copy(copy(new TXT$("State(4, 6):  t     t    p/s   p/s   p/s    a    p/s   p/s   p/s   p/s")));
                // JavaLine 357 ==> SourceLine 371
                answer.Elt[140-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     s     a     s     s     s     s")));
                // JavaLine 359 ==> SourceLine 373
                answer.Elt[141-answer.LB[0]]=copy(copy(new TXT$(" 42.00 :     idle  idle 47.60 47.60 42.00 42.00 44.19 44.19 42.01 42.01")));
                // JavaLine 361 ==> SourceLine 375
                answer.Elt[142-answer.LB[0]]=copy(copy(new TXT$("p( 5) activated at time =   42.000")));
                // JavaLine 363 ==> SourceLine 377
                answer.Elt[143-answer.LB[0]]=copy(copy(new TXT$("State(4, 5):  t     t    p/s   p/s    a     t    p/s   p/s   p/s   p/s")));
                // JavaLine 365 ==> SourceLine 379
                answer.Elt[144-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     a     t     s     s     s     s")));
                // JavaLine 367 ==> SourceLine 381
                answer.Elt[145-answer.LB[0]]=copy(copy(new TXT$(" 42.00 :     idle  idle 47.60 47.60 42.00  idle 44.19 44.19 42.01 42.01")));
                // JavaLine 369 ==> SourceLine 383
                answer.Elt[146-answer.LB[0]]=copy(copy(new TXT$("p(10) activated at time =   42.010")));
                // JavaLine 371 ==> SourceLine 385
                answer.Elt[147-answer.LB[0]]=copy(copy(new TXT$("State(4,10):  t     t    p/s   p/s    t     t    p/s   p/s   p/s    a")));
                // JavaLine 373 ==> SourceLine 387
                answer.Elt[148-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     s     s     s     a")));
                // JavaLine 375 ==> SourceLine 389
                answer.Elt[149-answer.LB[0]]=copy(copy(new TXT$(" 42.01 :     idle  idle 47.60 47.60  idle  idle 44.19 44.19 42.01 42.01")));
                // JavaLine 377 ==> SourceLine 391
                answer.Elt[150-answer.LB[0]]=copy(copy(new TXT$("p( 9) activated at time =   42.010")));
                // JavaLine 379 ==> SourceLine 393
                answer.Elt[151-answer.LB[0]]=copy(copy(new TXT$("State(4, 9):  t     t    p/s   p/s    t     t    p/s   p/s    a     t")));
                // JavaLine 381 ==> SourceLine 395
                answer.Elt[152-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     s     s     a     t")));
                // JavaLine 383 ==> SourceLine 397
                answer.Elt[153-answer.LB[0]]=copy(copy(new TXT$(" 42.01 :     idle  idle 47.60 47.60  idle  idle 44.19 44.19 42.01  idle")));
                // JavaLine 385 ==> SourceLine 399
                answer.Elt[154-answer.LB[0]]=copy(copy(new TXT$("p( 8) activated at time =   44.190")));
                // JavaLine 387 ==> SourceLine 401
                answer.Elt[155-answer.LB[0]]=copy(copy(new TXT$("State(4, 8):  t     t    p/s   p/s    t     t    p/s    a     t     t")));
                // JavaLine 389 ==> SourceLine 403
                answer.Elt[156-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     s     a     t     t")));
                // JavaLine 391 ==> SourceLine 405
                answer.Elt[157-answer.LB[0]]=copy(copy(new TXT$(" 44.19 :     idle  idle 47.60 47.60  idle  idle 44.19 44.19  idle  idle")));
                // JavaLine 393 ==> SourceLine 407
                answer.Elt[158-answer.LB[0]]=copy(copy(new TXT$("p( 7) activated at time =   44.190")));
                // JavaLine 395 ==> SourceLine 409
                answer.Elt[159-answer.LB[0]]=copy(copy(new TXT$("State(4, 7):  t     t    p/s   p/s    t     t     a     t     t     t")));
                // JavaLine 397 ==> SourceLine 411
                answer.Elt[160-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     a     t     t     t")));
                // JavaLine 399 ==> SourceLine 413
                answer.Elt[161-answer.LB[0]]=copy(copy(new TXT$(" 44.19 :     idle  idle 47.60 47.60  idle  idle 44.19  idle  idle  idle")));
                // JavaLine 401 ==> SourceLine 415
                answer.Elt[162-answer.LB[0]]=copy(copy(new TXT$("p( 4) activated at time =   47.600")));
                // JavaLine 403 ==> SourceLine 417
                answer.Elt[163-answer.LB[0]]=copy(copy(new TXT$("State(4, 4):  t     t    p/s    a     t     t     t     t     t     t")));
                // JavaLine 405 ==> SourceLine 419
                answer.Elt[164-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     a     t     t     t     t     t     t")));
                // JavaLine 407 ==> SourceLine 421
                answer.Elt[165-answer.LB[0]]=copy(copy(new TXT$(" 47.60 :     idle  idle 47.60 47.60  idle  idle  idle  idle  idle  idle")));
                // JavaLine 409 ==> SourceLine 423
                answer.Elt[166-answer.LB[0]]=copy(copy(new TXT$("p( 3) activated at time =   47.600")));
                // JavaLine 411 ==> SourceLine 425
                answer.Elt[167-answer.LB[0]]=copy(copy(new TXT$("State(4, 3):  t     t     a     t     t     t     t     t     t     t")));
                // JavaLine 413 ==> SourceLine 427
                answer.Elt[168-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     a     t     t     t     t     t     t     t")));
                // JavaLine 415 ==> SourceLine 429
                answer.Elt[169-answer.LB[0]]=copy(copy(new TXT$(" 47.60 :     idle  idle 47.60  idle  idle  idle  idle  idle  idle  idle")));
                // JavaLine 417 ==> SourceLine 431
                answer.Elt[170-answer.LB[0]]=copy(copy(new TXT$("State(5, 0): p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 419 ==> SourceLine 433
                answer.Elt[171-answer.LB[0]]=copy(copy(new TXT$("SQS:          s     s     s     s     s     s     s     s     s     s")));
                // JavaLine 421 ==> SourceLine 435
                answer.Elt[172-answer.LB[0]]=copy(copy(new TXT$(" 60.00 :    61.53 61.53 67.60 67.60 62.00 62.00 64.19 64.19 62.01 62.01")));
                // JavaLine 423 ==> SourceLine 437
                answer.Elt[173-answer.LB[0]]=copy(copy(new TXT$("p( 1) activated at time =   61.530")));
                // JavaLine 425 ==> SourceLine 439
                answer.Elt[174-answer.LB[0]]=copy(copy(new TXT$("State(5, 1):  a    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 427 ==> SourceLine 441
                answer.Elt[175-answer.LB[0]]=copy(copy(new TXT$("SQS:          a     s     s     s     s     s     s     s     s     s")));
                // JavaLine 429 ==> SourceLine 443
                answer.Elt[176-answer.LB[0]]=copy(copy(new TXT$(" 61.53 :    61.53 61.53 67.60 67.60 62.00 62.00 64.19 64.19 62.01 62.01")));
                // JavaLine 431 ==> SourceLine 445
                answer.Elt[177-answer.LB[0]]=copy(copy(new TXT$("p( 2) activated at time =   61.530")));
                // JavaLine 433 ==> SourceLine 447
                answer.Elt[178-answer.LB[0]]=copy(copy(new TXT$("State(5, 2):  t     a    p/s   p/s   p/s   p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 435 ==> SourceLine 449
                answer.Elt[179-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     a     s     s     s     s     s     s     s     s")));
                // JavaLine 437 ==> SourceLine 451
                answer.Elt[180-answer.LB[0]]=copy(copy(new TXT$(" 61.53 :     idle 61.53 67.60 67.60 62.00 62.00 64.19 64.19 62.01 62.01")));
                // JavaLine 439 ==> SourceLine 453
                answer.Elt[181-answer.LB[0]]=copy(copy(new TXT$("p( 5) activated at time =   62.000")));
                // JavaLine 441 ==> SourceLine 455
                answer.Elt[182-answer.LB[0]]=copy(copy(new TXT$("State(5, 5):  t     t    p/s   p/s    a    p/s   p/s   p/s   p/s   p/s")));
                // JavaLine 443 ==> SourceLine 457
                answer.Elt[183-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     a     s     s     s     s     s")));
                // JavaLine 445 ==> SourceLine 459
                answer.Elt[184-answer.LB[0]]=copy(copy(new TXT$(" 62.00 :     idle  idle 67.60 67.60 62.00 62.00 64.19 64.19 62.01 62.01")));
                // JavaLine 447 ==> SourceLine 461
                answer.Elt[185-answer.LB[0]]=copy(copy(new TXT$("p( 6) activated at time =   62.000")));
                // JavaLine 449 ==> SourceLine 463
                answer.Elt[186-answer.LB[0]]=copy(copy(new TXT$("State(5, 6):  t     t    p/s   p/s    t     a    p/s   p/s   p/s   p/s")));
                // JavaLine 451 ==> SourceLine 465
                answer.Elt[187-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     a     s     s     s     s")));
                // JavaLine 453 ==> SourceLine 467
                answer.Elt[188-answer.LB[0]]=copy(copy(new TXT$(" 62.00 :     idle  idle 67.60 67.60  idle 62.00 64.19 64.19 62.01 62.01")));
                // JavaLine 455 ==> SourceLine 469
                answer.Elt[189-answer.LB[0]]=copy(copy(new TXT$("p( 9) activated at time =   62.010")));
                // JavaLine 457 ==> SourceLine 471
                answer.Elt[190-answer.LB[0]]=copy(copy(new TXT$("State(5, 9):  t     t    p/s   p/s    t     t    p/s   p/s    a    p/s")));
                // JavaLine 459 ==> SourceLine 473
                answer.Elt[191-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     s     s     a     s")));
                // JavaLine 461 ==> SourceLine 475
                answer.Elt[192-answer.LB[0]]=copy(copy(new TXT$(" 62.01 :     idle  idle 67.60 67.60  idle  idle 64.19 64.19 62.01 62.01")));
                // JavaLine 463 ==> SourceLine 477
                answer.Elt[193-answer.LB[0]]=copy(copy(new TXT$("p(10) activated at time =   62.010")));
                // JavaLine 465 ==> SourceLine 479
                answer.Elt[194-answer.LB[0]]=copy(copy(new TXT$("State(5,10):  t     t    p/s   p/s    t     t    p/s   p/s    t     a")));
                // JavaLine 467 ==> SourceLine 481
                answer.Elt[195-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     s     s     t     a")));
                // JavaLine 469 ==> SourceLine 483
                answer.Elt[196-answer.LB[0]]=copy(copy(new TXT$(" 62.01 :     idle  idle 67.60 67.60  idle  idle 64.19 64.19  idle 62.01")));
                // JavaLine 471 ==> SourceLine 485
                answer.Elt[197-answer.LB[0]]=copy(copy(new TXT$("p( 7) activated at time =   64.190")));
                // JavaLine 473 ==> SourceLine 487
                answer.Elt[198-answer.LB[0]]=copy(copy(new TXT$("State(5, 7):  t     t    p/s   p/s    t     t     a    p/s    t     t")));
                // JavaLine 475 ==> SourceLine 489
                answer.Elt[199-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     a     s     t     t")));
                // JavaLine 477 ==> SourceLine 491
                answer.Elt[200-answer.LB[0]]=copy(copy(new TXT$(" 64.19 :     idle  idle 67.60 67.60  idle  idle 64.19 64.19  idle  idle")));
                // JavaLine 479 ==> SourceLine 493
                answer.Elt[201-answer.LB[0]]=copy(copy(new TXT$("p( 8) activated at time =   64.190")));
                // JavaLine 481 ==> SourceLine 495
                answer.Elt[202-answer.LB[0]]=copy(copy(new TXT$("State(5, 8):  t     t    p/s   p/s    t     t     t     a     t     t")));
                // JavaLine 483 ==> SourceLine 497
                answer.Elt[203-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     s     s     t     t     t     a     t     t")));
                // JavaLine 485 ==> SourceLine 499
                answer.Elt[204-answer.LB[0]]=copy(copy(new TXT$(" 64.19 :     idle  idle 67.60 67.60  idle  idle  idle 64.19  idle  idle")));
                // JavaLine 487 ==> SourceLine 501
                answer.Elt[205-answer.LB[0]]=copy(copy(new TXT$("p( 3) activated at time =   67.600")));
                // JavaLine 489 ==> SourceLine 503
                answer.Elt[206-answer.LB[0]]=copy(copy(new TXT$("State(5, 3):  t     t     a    p/s    t     t     t     t     t     t")));
                // JavaLine 491 ==> SourceLine 505
                answer.Elt[207-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     a     s     t     t     t     t     t     t")));
                // JavaLine 493 ==> SourceLine 507
                answer.Elt[208-answer.LB[0]]=copy(copy(new TXT$(" 67.60 :     idle  idle 67.60 67.60  idle  idle  idle  idle  idle  idle")));
                // JavaLine 495 ==> SourceLine 509
                answer.Elt[209-answer.LB[0]]=copy(copy(new TXT$("p( 4) activated at time =   67.600")));
                // JavaLine 497 ==> SourceLine 511
                answer.Elt[210-answer.LB[0]]=copy(copy(new TXT$("State(5, 4):  t     t     t     a     t     t     t     t     t     t")));
                // JavaLine 499 ==> SourceLine 513
                answer.Elt[211-answer.LB[0]]=copy(copy(new TXT$("SQS:          t     t     t     a     t     t     t     t     t     t")));
                // JavaLine 501 ==> SourceLine 515
                answer.Elt[212-answer.LB[0]]=copy(copy(new TXT$(" 67.60 :     idle  idle  idle 67.60  idle  idle  idle  idle  idle  idle")));
                // JavaLine 503 ==> SourceLine 518
                activationtimes=copy(copy(new TXT$("1.53 7.6 2 4.19 2.01 1.84 2 8.0 9.25 5.4")));
                // JavaLine 505 ==> SourceLine 519
                delaytimes=copy(copy(new TXT$(".01 .02 .05 .03 .08 .09 .04 .06 .06 .07")));
                // JavaLine 507 ==> SourceLine 521
                new simtst107$PBLK12$createobjects(((simtst107$PBLK12)CUR$));
                // JavaLine 509 ==> SourceLine 522
                for(boolean CB$522:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(10); }},new NAME$<Number>() { public Number get(){return(-1); }},new NAME$<Number>() { public Number get(){return(1); }})
                   )) { if(!CB$522) continue;
                ((simtst107$PBLK12)CUR$).ActivateDirect(false,pa.Elt[i-pa.LB[0]]);
            }
            // JavaLine 515 ==> SourceLine 524
            new simtst107$PBLK12$createobjects(((simtst107$PBLK12)CUR$));
            // JavaLine 517 ==> SourceLine 525
            actime=copy(copy(activationtimes));
            // JavaLine 519 ==> SourceLine 526
            for(boolean CB$526:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
               )) { if(!CB$526) continue;
            ((simtst107$PBLK12)CUR$).ActivateAt(false,pa.Elt[i-pa.LB[0]],time()+(((double)(new simtst107$PBLK12$getime(((simtst107$PBLK12)CUR$)).RESULT$))),false);
        }
        // JavaLine 525 ==> SourceLine 527
        new simtst107$PBLK12$startup(((simtst107$PBLK12)CUR$));
        // JavaLine 527 ==> SourceLine 529
        new simtst107$PBLK12$createobjects(((simtst107$PBLK12)CUR$));
        // JavaLine 529 ==> SourceLine 530
        actime=copy(copy(activationtimes));
        // JavaLine 531 ==> SourceLine 531
        for(boolean CB$531:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
           )) { if(!CB$531) continue;
        ((simtst107$PBLK12)CUR$).ActivateAt(false,pa.Elt[i-pa.LB[0]],time()+(((double)(new simtst107$PBLK12$getime(((simtst107$PBLK12)CUR$)).RESULT$))),true);
    }
    // JavaLine 537 ==> SourceLine 532
    new simtst107$PBLK12$startup(((simtst107$PBLK12)CUR$));
    // JavaLine 539 ==> SourceLine 534
    new simtst107$PBLK12$createobjects(((simtst107$PBLK12)CUR$));
    // JavaLine 541 ==> SourceLine 535
    actime=copy(copy(activationtimes));
    // JavaLine 543 ==> SourceLine 536
    for(boolean CB$536:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(9); }})
       )) { if(!CB$536) continue;
    ((simtst107$PBLK12)CUR$).ActivateAt(false,pa.Elt[i-pa.LB[0]],time()+(((double)(new simtst107$PBLK12$getime(((simtst107$PBLK12)CUR$)).RESULT$))),false);
}
// JavaLine 549 ==> SourceLine 537
for(boolean CB$537:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(10); }})
   )) { if(!CB$537) continue;
((simtst107$PBLK12)CUR$).ActivateBefore(false,pa.Elt[i-pa.LB[0]],pa.Elt[(i-(1))-pa.LB[0]]);
}
// JavaLine 555 ==> SourceLine 538
new simtst107$PBLK12$startup(((simtst107$PBLK12)CUR$));
// JavaLine 557 ==> SourceLine 540
new simtst107$PBLK12$createobjects(((simtst107$PBLK12)CUR$));
// JavaLine 559 ==> SourceLine 541
actime=copy(copy(activationtimes));
// JavaLine 561 ==> SourceLine 542
for(boolean CB$542:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(9); }})
   )) { if(!CB$542) continue;
((simtst107$PBLK12)CUR$).ActivateAt(false,pa.Elt[i-pa.LB[0]],time()+(((double)(new simtst107$PBLK12$getime(((simtst107$PBLK12)CUR$)).RESULT$))),false);
}
// JavaLine 567 ==> SourceLine 543
for(boolean CB$543:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(10); }})
   )) { if(!CB$543) continue;
((simtst107$PBLK12)CUR$).ActivateAfter(false,pa.Elt[i-pa.LB[0]],pa.Elt[(i-(1))-pa.LB[0]]);
}
// JavaLine 573 ==> SourceLine 544
new simtst107$PBLK12$startup(((simtst107$PBLK12)CUR$));
// JavaLine 575 ==> SourceLine 546
for(boolean CB$546:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(utno); }})
   )) { if(!CB$546) continue;
// JavaLine 579 ==> SourceLine 547
if(VALUE$(TXTREL$NE(ut.Elt[i-ut.LB[0]],answer.Elt[i-answer.LB[0]]))) {
found_error=true;
}
}
// JavaLine 584 ==> SourceLine 549
if(VALUE$(found_error)) {
// JavaLine 586 ==> SourceLine 550
{
TRACE_BEGIN_STM$("CompoundStatement550",550);
sysout().outtext(new TXT$("*** error : Output"));
sysout().outimage();
// JavaLine 591 ==> SourceLine 551
sysout().outtext(new TXT$("            Outputlines which did not match:"));
// JavaLine 593 ==> SourceLine 552
sysout().outimage();
// JavaLine 595 ==> SourceLine 553
for(boolean CB$553:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(utno); }})
   )) { if(!CB$553) continue;
// JavaLine 599 ==> SourceLine 554
if(VALUE$(TXTREL$NE(answer.Elt[i-answer.LB[0]],ut.Elt[i-ut.LB[0]]))) {
// JavaLine 601 ==> SourceLine 555
{
TRACE_BEGIN_STM$("CompoundStatement555",555);
sysout().outchar('*');
sysout().outtext(ut.Elt[i-ut.LB[0]]);
sysout().outimage();
// JavaLine 607 ==> SourceLine 556
sysout().outchar('-');
sysout().outtext(answer.Elt[i-answer.LB[0]]);
// JavaLine 610 ==> SourceLine 559
sysout().outimage();
TRACE_END_STM$("CompoundStatement555",559);
}
}
}
TRACE_END_STM$("CompoundStatement550",559);
}
} else
// JavaLine 619 ==> SourceLine 561
{
TRACE_BEGIN_STM$("CompoundStatement561",561);
sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 97"));
TRACE_END_STM$("CompoundStatement561",561);
}
// JavaLine 625 ==> SourceLine 564
sysout().outtext(new TXT$("--- END OF Simula a.s - SIMULA TEST NO 97 "));
// JavaLine 627 ==> SourceLine 566
sysout().outimage();
TRACE_END_STM$("simtst107$PBLK12",566);
}
};
} // End of Constructor

public static void main(String[] args) {
//System.setProperty("file.encoding","UTF-8");
RT.setRuntimeOptions(args);
new simtst107$PBLK12(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","PrefixedBlock simtst107$PBLK12",1,12,14,14,17,15,19,83,21,84,25,85,28,86,39,14,48,83,53,84,70,88,73,89,76,90,79,93,81,95,83,97,85,99,87,101,89,103,91,105,93,107,95,109,97,111,99,113,101,115,103,117,105,119,107,121,109,123,111,125,113,127,115,129,117,131,119,133,121,135,123,137,125,139,127,141,129,143,131,145,133,147,135,149,137,151,139,153,141,155,143,157,145,159,147,161,149,163,151,165,153,167,155,169,157,171,159,173,161,175,163,177,165,179,167,181,169,183,171,185,173,187,175,189,177,191,179,193,181,195,183,197,185,199,187,201,189,203,191,205,193,207,195,209,197,211,199,213,201,215,203,217,205,219,207,221,209,223,211,225,213,227,215,229,217,231,219,233,221,235,223,237,225,239,227,241,229,243,231,245,233,247,235,249,237,251,239,253,241,255,243,257,245,259,247,261,249,263,251,265,253,267,255,269,257,271,259,273,261,275,263,277,265,279,267,281,269,283,271,285,273,287,275,289,277,291,279,293,281,295,283,297,285,299,287,301,289,303,291,305,293,307,295,309,297,311,299,313,301,315,303,317,305,319,307,321,309,323,311,325,313,327,315,329,317,331,319,333,321,335,323,337,325,339,327,341,329,343,331,345,333,347,335,349,337,351,339,353,341,355,343,357,345,359,347,361,349,363,351,365,353,367,355,369,357,371,359,373,361,375,363,377,365,379,367,381,369,383,371,385,373,387,375,389,377,391,379,393,381,395,383,397,385,399,387,401,389,403,391,405,393,407,395,409,397,411,399,413,401,415,403,417,405,419,407,421,409,423,411,425,413,427,415,429,417,431,419,433,421,435,423,437,425,439,427,441,429,443,431,445,433,447,435,449,437,451,439,453,441,455,443,457,445,459,447,461,449,463,451,465,453,467,455,469,457,471,459,473,461,475,463,477,465,479,467,481,469,483,471,485,473,487,475,489,477,491,479,493,481,495,483,497,485,499,487,501,489,503,491,505,493,507,495,509,497,511,499,513,501,515,503,518,505,519,507,521,509,522,515,524,517,525,519,526,525,527,527,529,529,530,531,531,537,532,539,534,541,535,543,536,549,537,555,538,557,540,559,541,561,542,567,543,573,544,575,546,579,547,584,549,586,550,591,551,593,552,595,553,599,554,601,555,607,556,610,559,619,561,625,564,627,566,638,566);
}
