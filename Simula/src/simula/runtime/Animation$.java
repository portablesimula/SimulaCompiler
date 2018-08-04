/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * 
 * The system class "simulation" may be considered an "application package"
 * oriented towards simulation problems. It has the class "simset" as prefix,
 * and set-handling facilities are thus immediately available.
 * <p>
 * The concepts defined in "simulation" are explained with respect to a prefixed
 * block, whose prefix part is an instance of the body of "simulation" or of a
 * subclass. The prefixed block instance acts as the head of a quasi-parallel
 * system which may represent a "discrete event" simulation model.
 * 
 * <pre>
 simset class animation;
        begin  ref (head) SQS;
      link class EVENT_NOTICE (EVTIME, PROC);
                     long real EVTIME; ref (process) PROC;
           begin
              ref (EVENT_NOTICE) procedure suc;
                 suc:- if SUC is EVENT_NOTICE then SUC else none;

              ref (EVENT_NOTICE) procedure pred;   pred:- PRED;

              procedure RANK_IN_SQS (afore); Boolean afore;
              begin ref (EVENT_NOTICE) evt;
                 evt:- SQS.last;
                 while evt.EVTIME > EVTIME do    evt :- evt.pred;
                 if afore then
                    while evt.EVTIME = EVTIME do evt :- evt.pred;
                 follow(evt)
              end RANK_IN_SQS;
           end EVENT_NOTICE;

           ref (MAIN_PROGRAM) main;

           ref (EVENT_NOTICE) procedure FIRSTEV;  FIRSTEV :- SQS.first;
           ref (process) procedure current; current :- FIRSTEV.PROC;
           long real procedure time; time := FIRSTEV.EVTIME;

      link class process;  .................... 12.1;
           procedure ACTIVAT .................. 12.3;
           procedure hold ..................... 12.4;
           procedure passivate ................ 12.4;
           procedure wait ..................... 12.4;
           procedure cancel ................... 12.4;
   process class MAIN_PROGRAM ................. 12.5;
           procedure accum .................... 12.6;

           SQS        :- new head;
           main       :- new MAIN_PROGRAM;
           main.EVENT :- new EVENT_NOTICE(0,main);
           main.EVENT.into(SQS)
        end simulation;
 * </pre>
 * 
 * When used as a prefix to a block or a class, "simulation" introduces
 * simulation-oriented features through the class "process" and associated
 * procedures.
 * <p>
 * The variable SQS refers to a set which is called the "sequencing set", and
 * serves to represent the system time axis. The members of the sequencing set
 * are event notices ranked according to increasing value of the attribute
 * "EVTIME". An event notice refers through its attribute PROC to a "process"
 * object and represents an event which is the next active phase of that object,
 * scheduled to take place at system time EVTIME. There may be at most one event
 * notice referencing any given process object.
 * <p>
 * The event notice at the lower end of the sequencing set refers to the
 * currently active process object. The object can be referenced through the
 * procedure "current". The value of EVTIME for this event notice is identified
 * as the current value of system time. It may be accessed through the procedure
 * "time".
 * <p>
 * Note: Since the statements and procedures introduced by "simulation" make
 * implicit use of the sequencing procedures (detach, call and resume) explicit
 * sequencing by these procedures should be done with care.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class Animation$ extends Simset$ {
	
	public static final int white =     0xffffff; // Color white:      R=255, G=255, B=255.
	public static final int lightGray = 0xc0c0c0; // Color light gray: R=192, G=192, B=192.
	public static final int gray =      0x808080; // Color gray:       R=128, G=128, B=128.
	public static final int darkGray =  0x404040; // Color dark gray:  R=64,  G=64,  B=64.
	public static final int black =     0x000000; // Color black:      R=0,   G=0,   B=0.
	public static final int red =       0xff0000; // Color red:        R=255, G=0,   B=0.
	public static final int pink =      0xffafaf; // Color pink:       R=255, G=175, B=175.
	public static final int orange =    0xffc800; // Color orange:     R=255, G=200, B=0.
	public static final int yellow =    0xffff00; // Color yellow:     R=255, G=255, B=0.
	public static final int green =     0x00ff00; // Color green:      R=0,   G=255, B=0.
	public static final int magenta =   0xff00ff; // Color magenta:    R=255, G=0,   B=255.
	public static final int cyan =      0x00ffff; // Color cyan:       R=0,   G=255, B=255.
	public static final int blue =      0x0000ff; // Color blue:       R=0,   G=0,   B=255.

	JFrame frame;
	JWindow window;
	public Head$ SQS = null;
    Color currentBackgroundColor=Color.WHITE;
    Color currentDrawColor=Color.BLACK;
    Color currentFillColor=Color.GRAY;
    Stroke currentStroke=new BasicStroke(2.5f);
    Font currentFont;

	interface Animable
	{ public void paint(Graphics2D g); }
	
	/*
	 * style - the style constant for the Font The style argument is an integer
	 * bitmask that may be PLAIN, or a bitwise union of BOLD and/or ITALIC (for
	 * example, ITALIC or BOLD|ITALIC). If the style argument does not conform to
	 * one of the expected integer bitmasks then the style is set to PLAIN.
	 */
    public void setFontStylePlain() { currentFont=currentFont.deriveFont(Font.PLAIN); }
    public void setFontStyleBold() { currentFont=currentFont.deriveFont(Font.BOLD); }
    public void setFontStyleItalic() { currentFont=currentFont.deriveFont(Font.ITALIC); }
    public void setFontStyleBoldItalic() { currentFont=currentFont.deriveFont(Font.BOLD|Font.ITALIC); }
    public void setStroke(float size) { currentStroke=new BasicStroke(2.5f); }
    /*
     * FontSize usually 12.0 ?
     */
    public void setFontSize(float size)
    { System.out.println("SetFontSize: size="+size+", OldFont="+currentFont);
    	currentFont=currentFont.deriveFont(size);
    }
    public float getFontSize() { return(currentFont.getSize2D()); }

	public void setBackgroundColor(int color)	{ currentBackgroundColor=new Color(color); }
	public void setDrawColor(int color)	{ currentDrawColor=new Color(color); }
	public void setFillColor(int color) { currentFillColor=new Color(color); }

	/**
	 * <pre>
	 * integer procedure color(r,g,b); integer r,g,b; ... ... ;
	 * </pre>
	 * Creates an opaque sRGB color with the specified combined RGB value consisting
	 * of the red component in bits 16-23, the green component in bits 8-15, and the
	 * blue component in bits 0-7.
	 * 
	 *
	 */
	public int color(int red,int green,int blue)
	{ int value = (red << 16) | (green << 8) | blue;
	  return(value);
	}
	public int color(TXT$ name) { return(color(name.edText())); }
	public int color(String name)
	{ if(name.equalsIgnoreCase("white")) return(white);
	  if(name.equalsIgnoreCase("lightGray")) return(lightGray);
	  if(name.equalsIgnoreCase("gray")) return(gray);
	  if(name.equalsIgnoreCase("darkGray")) return(darkGray);
	  if(name.equalsIgnoreCase("black")) return(black);
	  if(name.equalsIgnoreCase("red")) return(red);
	  if(name.equalsIgnoreCase("pink")) return(pink);
	  if(name.equalsIgnoreCase("orange")) return(orange);
	  if(name.equalsIgnoreCase("yellow")) return(yellow);
	  if(name.equalsIgnoreCase("green")) return(green);
	  if(name.equalsIgnoreCase("magenta")) return(magenta);
	  if(name.equalsIgnoreCase("cyan")) return(cyan);
	  if(name.equalsIgnoreCase("blue")) return(blue);
	  return(-1);
	}

	

	// Constructor
	public Animation$(RTObject$ staticLink) {
		super(staticLink);
		TRACE_BEGIN_DCL$("Animation$");
		// Create Class Body
		CODE$ = new ClassBody(CODE$, this,1) {
			public void STM() {
				TRACE_BEGIN_STM$("Animation$",inner);
				SQS = (Head$) new Head$(Animation$.this).STM();
				if (inner != null)
					inner.STM();
				TRACE_END_STM$("Animation$");
			}
		};
	}

	public Animation$ STM() {
		return ((Animation$) CODE$.EXEC$());
	}

	public Animation$ START() {
		START(this);
		return (this);
	}

}
