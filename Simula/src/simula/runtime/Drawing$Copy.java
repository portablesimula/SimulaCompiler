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
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * The Class "Drawing".
 * <p>
 * <pre>
 * class Drawing(title); text title;
 * begin integer procedure color(r,g,b); integer r,g,b; ... ... ;
 *       integer procedure color(colorName); text colorName; ... ... ;
 *       integer procedure setDrawColor(color); integer color; ... ... ;
 *       integer procedure setFillColor(color); integer color; ... ... ;
 *       integer procedure setStroke(width); real width; ... ... ;
 *       
 *       procedure drawOval(x,y,width,height); integer x,y,width,height; ... ... ;
 *       procedure fillOval(x,y,width,height); integer x,y,width,height; ... ... ;
 * 
 * end Drawing;
 * </pre>
 * 
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Drawing$Copy extends CLASS$ {
	
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
//	JFrame frame;
	private Frame frame;
	private JWindow window;
    Color currentBackgroundColor=Color.WHITE;
    Color currentDrawColor=Color.BLACK;
    Color currentFillColor=Color.GRAY;
    Stroke currentStroke=new BasicStroke(2.5f);
    Font currentFont;
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
    
    Vector<DrawElement> elements=new Vector<DrawElement>();

	// Constructor
    public Drawing$Copy(RTObject$ staticLink,TXT$ title) {
       super(staticLink);
//  public Drawing$(ENVIRONMENT$ staticLink,TXT$ title) {
//     super((RTObject$)staticLink);
       BBLK(); // Iff no prefix
       TRACE_BEGIN_DCL$("Drawing$");
       CODE$=new ClassBody(CODE$,this,0) {
          public void STM() {
        	 TRACE_BEGIN_STM$("Drawing$",inner);
        	 init(title.edText());
             if(inner!=null) inner.STM();
             TRACE_END_STM$("Drawing$");
             EBLK(); // Iff no prefix
       }};
    }
    public Drawing$Copy STM() { return((Drawing$Copy)CODE$.EXEC$()); }
    public Drawing$Copy START() { START(this); return(this); }

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
	
    class DrawElement
    { Stroke stroke;
      public DrawElement() { stroke=currentStroke; }
      public void paint(Graphics2D g) {}
    }
    
    class TextElement extends DrawElement
    { double x,y;
      String str;
      Color color;
      Font font;
      public TextElement(String str,double x,double y)
      { this.str=str; this.x=x; this.y=y;
        this.color=currentDrawColor;
        this.font=currentFont; }
      public void paint(Graphics2D g)
      { g.setStroke(stroke);
        g.setColor(color);
        g.setFont(font);
        g.drawString(str,(float)x,(float)y);
      }
    }
    
    class ShapeElement extends DrawElement
    { Color drawColor; // null: no drawing
      Color fillColor; // null: no filling
      Shape shape;
      public ShapeElement(Shape shape)
      { this.shape=shape;
      }
      public void paint(Graphics2D g)
      { g.setStroke(stroke);
    	if(fillColor!=null)	{ g.setColor(fillColor); g.fill(shape); }
        if(drawColor!=null)	{ g.setColor(drawColor); g.draw(shape); }
      }
    }

    
    
    class Drawing extends Canvas {
    	static final long serialVersionUID=123;
    	public void update(Graphics g1) { paint(g1); }
    	public void paint(Graphics g1) {
    		Graphics2D g=(Graphics2D)g1;
    		this.setBackground(currentBackgroundColor);
            //for(DrawElement elt:elements) elt.paint(g);
    		for (Enumeration<DrawElement> e = elements.elements(); e.hasMoreElements();)
    		       e.nextElement().paint(g);
        }    	
    }
    private void init(String title)
//    { frame = new JFrame(title);
    { frame = new Frame(title);
      Canvas canvas = new Drawing();
      canvas.setSize(400, 400);
      currentFont=new Font(Font.SANS_SERIF,12,Font.PLAIN);
	  //System.out.println("Init: Current Font="+currentFont);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);  
//        frame.show();
        frame.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				System.out.println("windowStateChanged:WindowsEvent: "+e);
				
			}});
        frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) { System.out.println("windowOpened.WindowsEvent: "+e); }
			public void windowClosing(WindowEvent e) { System.out.println("windowClosing.WindowsEvent: "+e);
				if(e.getID()==WindowEvent.WINDOW_CLOSING) System.exit(0);
			}
			public void windowClosed(WindowEvent e) { System.out.println("windowClosed.WindowsEvent: "+e); }
			public void windowIconified(WindowEvent e) { System.out.println("windowIconified.WindowsEvent: "+e); }
			public void windowDeiconified(WindowEvent e) { System.out.println("windowDeiconified.WindowsEvent: "+e); }
			public void windowActivated(WindowEvent e) { System.out.println("windowActivated.WindowsEvent: "+e); }
			public void windowDeactivated(WindowEvent e) { System.out.println("windowClosing.WindowsEvent: "+e);
			}});
    }
    
    public void drawLine​(double x1, double y1, double x2, double y2) {}
    public void drawRectangle​(double x, double y, double width, double height) {}
    public void drawRoundRectangle(double x, double y, double width, double height, double arcWidth, double arcHeight) {}
    public void drawEllipse(double x,double y,double width,double height)
    { ShapeElement elt=new ShapeElement(new Ellipse2D.Double(x,y,width,height));
      elt.drawColor=currentDrawColor;
      elements.add(elt);
    }
    public void drawArc​(double x, double y, double width, double height, double startAngle, double arcAngle) {}
    
    public void FillerRectangle​(double x, double y, double width, double height)
    { ShapeElement elt=new ShapeElement(new Rectangle2D.Double(x,y,width,height));
      elt.fillColor=currentFillColor;
      elements.add(elt);
    }
    public void fillRoundRectangle(double x, double y, double width, double height, double arcWidth, double arcHeight) {}
    public void fillEllipse(double x,double y,double width,double height)
    { ShapeElement elt=new ShapeElement(new Ellipse2D.Double(x,y,width,height));
      elt.fillColor=currentFillColor;
      elements.add(elt); frame.repaint();
    }
    public void fillArc​(double x, double y, double width, double height, double startAngle, double arcAngle) {}
    
    public void drawText(TXT$ txt,double x,double y)
    { drawText(txt.edText(),x,y); }
    public void drawText(String str,double x,double y)
    { TextElement elt=new TextElement(str,x,y);
    	
      elements.add(elt);
    }
    
    public static void main(String[] args) {
    	Drawing$Copy drawing=new Drawing$Copy(null,new TXT$("Simula Drawing"));
    	drawing.init("Testing Drawing");
    	drawing.setDrawColor(Drawing$Copy.red);
    	drawing.setFillColor(Drawing$Copy.magenta);
    	
    	drawing.fillEllipse(100, 100, 200, 50);
    	drawing.setDrawColor(Drawing$Copy.black);
    	drawing.drawEllipse(200, 200, 200, 50);
    	drawing.setFontSize(24.0f);
    	drawing.setDrawColor(Drawing$Copy.orange);
    	drawing.drawText("Abracadabra",200,200);
    }

}
