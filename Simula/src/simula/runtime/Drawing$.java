/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * 
 * The additional system class "Drawing" introduce basic graphical capabilities.
 * It has the class "simset" as prefix, so set-handling facilities are thus immediately available.
 * 
 * <pre>
 * Simset class Drawing(title,width,height); Value title; Text title; Integer width,height;
 * begin ref(Head) RENDERING_SET;
 * 		 Integer CURRENT_BACKGROUND_COLOR,CURRENT_DRAW_COLOR,CURRENT_FILL_COLOR,CURRENT_STROKE_WIDTH;
 *       ref(Font) CURRENT_FONT; ! Java Class Font is not visible in Simula ;
 *
 *       ref(Head) Procedure renderingSet; renderingSet :- RENDERING_SET;
 *       Integer white,lightGray,gray,darkGray,black,red,pink,orange,yellow,green,magenta,cyan,blue;  
 *       Integer Procedure color(r,g,b); Integer r,g,b; ...   
 *       Procedure setBackgroundColor(color); Integer color; CURRENT_BACKGROUND_COLOR := color;  
 *       Procedure setDrawColor(color); Integer color; CURRENT_DRAW_COLOR := color;  
 *       Procedure setFillColor(color); Integer color; CURRENT_FILL_COLOR := color;
 *       Procedure setStroke(width); Real width; CURRENT_STROKE_WIDTH := width; 
 *
 *       Procedure setFontStylePlain;      CURRENT_FONT :- CURRENT_FONT.deriveFont(Font.PLAIN);  
 *       Procedure setFontStyleBold;       CURRENT_FONT :- CURRENT_FONT.deriveFont(Font.BOLD); 
 *       Procedure setFontStyleItalic;     CURRENT_FONT :- CURRENT_FONT.deriveFont(Font.ITALIC); 
 *       Procedure setFontStyleBoldItalic; CURRENT_FONT :- CURRENT_FONT.deriveFont(Font.BOLD|Font.ITALIC); 
 *          
 *       Procedure setFontSize(size); Real size; CURRENT_FONT :- CURRENT_FONT.deriveFont(size); 
 *       Real Procedure getFontSize; getFontSize := CURRENT_FONT.getSize2D;
 *
 *       Link class ShapeElement; ...
 *       Link class TextElement; ...
 *
 *	     ref(TextElement) Procedure drawText(t,x,y); Value t; Text t; Long Real x1,y1,x2,y2;
 *       begin ref(TextElement) elt; drawText :- elt :- new TextElement(t,x,y); end;
 *
 *	     ref(ShapeElement) Procedure drawLine(x1,y1,x2,y2); Long Real x1,y1,x2,y2;
 *       begin ref(ShapeElement) elt; drawLine :- elt :- new ShapeElement; elt.drawLine(x1,y1,x2,y2); end;
 *      
 *       ref(ShapeElement) Procedure drawEllipse(x,y,width,height); Long Real x,y,width,height;
 *       begin ref(ShapeElement) elt; drawEllipse :- elt :- new ShapeElement; elt.drawEllipse(x,y,width,height); end;
 *       
 *       ref(ShapeElement) Procedure drawRectangle(double x,double y,double width,double height)
 *       begin ref(ShapeElement) elt; drawRectangle :- elt :- new ShapeElement; elt.drawRectangle(x,y,width,height); end;
 *       
 *       ref(ShapeElement) Procedure drawRoundRectangle(x,y,width,height,arcw,arch); Long Real x,y,width,height,arcw,arch;
 *       begin ref(ShapeElement) elt; drawRoundRectangle :- elt :- new ShapeElement; elt.drawRoundRectangle(x,y,width,height,arcw,arch); end;
 *      
 *       ref(ShapeElement) Procedure fillEllipse(x,y,width,height); Long Real x,y,width,height;
 *       begin ref(ShapeElement) elt; fillEllipse :- elt :- new ShapeElement; elt.fillEllipse(x,y,width,height); end;
 *       
 *       ref(ShapeElement) Procedure fillRectangle(x,y,width,height); Long Real x,y,width,height;
 *       begin ref(ShapeElement) elt; fillRectangle :- elt :- new ShapeElement; elt.fillRectangle(x,y,width,height); end;
 *       
 *       ref(ShapeElement) Procedure fillRoundRectangle(x,y,width,height,arcw,arch); Long Real x,y,width,height,arcw,arch;
 *       begin ref(ShapeElement) elt; fillRoundRectangle :- elt :- new ShapeElement; elt.fillRoundRectangle(x,y,width,height,arcw,arch); end;
 *
 *       RENDERING_SET  :-  new head;
 *       CURRENT_BACKGROUND_COLOR := white;
 *       CURRENT_DRAW_COLOR=black;
 *       CURRENT_FILL_COLOR=gray;
 *       CURRENT_STROKE_WIDTH := 2.5;
 *       CURRENT_FONT=new Font(Font.SANS_SERIF,12,Font.PLAIN); ! Font size 12 ;
 *
 * end Drawing;
 * </pre>
 * 
 * When used as a prefix to a block or a class, "simulation" introduces
 * simulation-oriented features through the class "process" and associated
 * procedures.
 * <p>
 * The variable RENDERING_SET refers to a set of graphical elements to be rendered.
 * The members of the rendering set are ShapeElements and TextElements.
 * The elements are rendered in the order defined by the RENDERING_SET, starting with RENDERING_SET.first.
 * 
 * @author Øystein Myhre Andersen
 */
public class Drawing$ extends Simset$ {
	private static final boolean DEBUG=false;
	
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
	Drawing canvas;
	BufferStrategy strategy;
	public Head$ RENDERING_SET = null;
    public Head$ renderingSet() { return(RENDERING_SET); }
    Color currentBackgroundColor=Color.WHITE;
    Color currentDrawColor=Color.BLACK;
    Color currentFillColor=Color.GRAY;
    Stroke currentStroke=new BasicStroke(2.5f);
    Font currentFont;

	interface Animable
	{ public void paint(Graphics2D g); }
	
	public void repaintMe()
	{ canvas.render(); }
	
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
    public void setStroke(float size) { currentStroke=new BasicStroke(size); }
    /*
     * FontSize usually 12.0 ?
     */
    public void setFontSize(float size)
    { if(DEBUG) RT.println("SetFontSize: size="+size+", OldFont="+currentFont);
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
	 */
	public int color(int red,int green,int blue)
	{ int value = (red << 16) | (green << 8) | blue;
	  return(value);
	}

	public TextElement$ drawText(TXT$ t,double x,double y)
	{ return(new TextElement$(this,t,x,y).STM$()); }
	   
	public ShapeElement$ drawLine(double x1,double y1,double x2,double y2)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.drawLine(x1,y1,x2,y2); return(elt); }
	   
	public ShapeElement$ drawEllipse(double x,double y,double width,double height)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.drawEllipse(x,y,width,height); return(elt); }

	public ShapeElement$ drawRectangle(double x,double y,double width,double height)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.drawRectangle(x,y,width,height); return(elt); }
	   
	public ShapeElement$ drawRoundRectangle(double x,double y,double width,double height, double arcw, double arch)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.drawRoundRectangle(x,y,width,height,arcw,arch); return(elt); }
	   
	public ShapeElement$ fillEllipse(double x,double y,double width,double height)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.fillEllipse(x,y,width,height); return(elt); }
 
	public ShapeElement$ fillRectangle(double x,double y,double width,double height)
	{ ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.fillRectangle(x,y,width,height); return(elt); }
	   
    public ShapeElement$ fillRoundRectangle(double x,double y,double width,double height, double arcw, double arch)
    { ShapeElement$ elt=new ShapeElement$(this).STM$(); elt.fillRoundRectangle(x,y,width,height,arcw,arch); return(elt); }

    
    class Drawing extends Canvas {
    	static final long serialVersionUID=123;
    	public void paint(Graphics g) { render(); }
    	public void render()
    	{ Graphics graphics = strategy.getDrawGraphics();
    	  Graphics2D g=(Graphics2D)graphics;
    	  g.setBackground(currentBackgroundColor);
//    	  g.setBackground(Color.WHITE);
    	  Rectangle bnd=this.getBounds();
    	  g.clearRect(bnd.x,bnd.y,bnd.width,bnd.height);
          // Render to graphics
		  Link$ lnk=RENDERING_SET.first();
		  while(lnk!=null) 
		  { if(lnk instanceof Drawing$.Animable)
			  ((Drawing$.Animable)lnk).paint(g);
		    lnk=lnk.suc();
		  }
   	      graphics.dispose();
   	      strategy.show();
    	}
    }

	// Constructor
	public Drawing$(RTObject$ staticLink,TXT$ title,int width,int height) {
		super(staticLink);
		TRACE_BEGIN_DCL$("Drawing$");
		// Create Class Body
		CODE$ = new ClassBody(CODE$, this,1) {
			public void STM$() {
				TRACE_BEGIN_STM$("Drawing$",inner);
				RENDERING_SET = (Head$) new Head$(Drawing$.this).STM$();
	        	init(title.edText(),width,height);
				if (inner != null) inner.STM$();
				TRACE_END_STM$("Drawing$");
			}
		};
	}
    
    private void init(String title,int width,int height)
    { frame = new JFrame(title);
      canvas = new Drawing();
      canvas.setSize(width, height);
      
//      currentFont=new Font(Font.DIALOG,12,Font.PLAIN);
//      currentFont=new Font(Font.DIALOG_INPUT,12,Font.PLAIN);
//      currentFont=new Font(Font.MONOSPACED,12,Font.PLAIN);
//      currentFont=new Font(Font.SANS_SERIF,12,Font.PLAIN);
      currentFont=new Font(Font.SERIF,12,Font.PLAIN);

//      currentFont=new Font(Font.SERIF,currentFont.getSize(),currentFont.getStyle());

      if(DEBUG) RT.println("Init: Current Font="+currentFont);
	  setFontSize(12);
	  if(DEBUG) RT.println("Init: Current Font="+currentFont);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);  
        canvas.createBufferStrategy(2);
        strategy = canvas.getBufferStrategy();        
        frame.setAlwaysOnTop(true); // VIRKER
//        frame.moveToFront(); //VIRKER IKKE !!!
        
//        frame.addWindowStateListener(new WindowStateListener() {
//			public void windowStateChanged(WindowEvent e) {
//				RT.println("windowStateChanged:WindowsEvent: "+e);
//				
//			}});
        frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) { if(DEBUG) RT.println("windowOpened.WindowsEvent: "+e); }
			public void windowClosing(WindowEvent e) { if(DEBUG) RT.println("windowClosing.WindowsEvent: "+e);
				if(e.getID()==WindowEvent.WINDOW_CLOSING) {
					//printThreadList(true);
					System.exit(0);
				}
			}
			public void windowClosed(WindowEvent e) { if(DEBUG) RT.println("windowClosed.WindowsEvent: "+e); }
			public void windowIconified(WindowEvent e) { if(DEBUG) RT.println("windowIconified.WindowsEvent: "+e); }
			public void windowDeiconified(WindowEvent e) { if(DEBUG) RT.println("windowDeiconified.WindowsEvent: "+e); }
			public void windowActivated(WindowEvent e) { if(DEBUG) RT.println("windowActivated.WindowsEvent: "+e); }
			public void windowDeactivated(WindowEvent e) { if(DEBUG) RT.println("windowClosing.WindowsEvent: "+e);
			}});
        
//        frame.setFocusable(true);
//        frame.addKeyListener(new KeyListener() {
        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(DEBUG) RT.println("KEY "+c+" TYPED");
				if(c=='x') System.exit(0);
			}
			public void keyPressed(KeyEvent e) {
				if(DEBUG) RT.println("KEY "+e.getKeyChar()+" PRESSED");
			}
			public void keyReleased(KeyEvent e) {
				if(DEBUG) RT.println("KEY "+e.getKeyChar()+" RELEASE");
			}});
    }

	public Drawing$ STM$() {
		return ((Drawing$) CODE$.EXEC$());
	}

	public Drawing$ START() {
		START(this);
		return (this);
	}
    
//	private void listRenderingSet()
//	{ Link$ lnk=RENDERING_SET.first();
//	  RT.println("RENDERING SET: first="+lnk);
//	  while(lnk!=null) 
//	  { RT.println(" - "+lnk.getClass().getSimpleName());
//	    lnk=lnk.suc();
//	  }
//	}


}
