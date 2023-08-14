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
 * Additional System class Drawing.
 * <p>
 * The class "Drawing" introduce basic graphical capabilities.
 * It has the class "simset" as prefix, so set-handling facilities are thus immediately available.
 * 
 * <pre>
 * Simset class Drawing(title,width,height); Value title; Text title; Integer width,height;
 * begin ref(Head) RENDERING_SET;
 * 	     Integer CURRENT_BACKGROUND_COLOR,CURRENT_DRAW_COLOR,CURRENT_FILL_COLOR,CURRENT_STROKE_WIDTH;
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
 *       ref(TextElement) Procedure drawText(t,x,y); Value t; Text t; Long Real x1,y1,x2,y2;
 *       begin ref(TextElement) elt; drawText :- elt :- new TextElement(t,x,y); end;
 *
 *       ref(ShapeElement) Procedure drawLine(x1,y1,x2,y2); Long Real x1,y1,x2,y2;
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
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Drawing.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public class RTS_Drawing extends RTS_Simset {
	
	/**
	 * DEBUG on/off
	 */
	private static final boolean DEBUG = false;

	/**
	 * The color white.
	 */
	public static final int _white_1 = 0xffffff; // Color white: R=255, G=255, B=255.
	/**
	 * The color lightGray.
	 */
	public static final int _lightGray_1 = 0xc0c0c0; // Color light gray: R=192, G=192, B=192.
	/**
	 * The color gray.
	 */
	public static final int _gray_1 = 0x808080; // Color gray: R=128, G=128, B=128.
	/**
	 * The color darkGray.
	 */
	public static final int _darkGray_1 = 0x404040; // Color dark gray: R=64, G=64, B=64.
	/**
	 * The color black.
	 */
	public static final int _black_1 = 0x000000; // Color black: R=0, G=0, B=0.
	/**
	 * The color red.
	 */
	public static final int _red_1 = 0xff0000; // Color red: R=255, G=0, B=0.
	/**
	 * The color pink.
	 */
	public static final int _pink_1 = 0xffafaf; // Color pink: R=255, G=175, B=175.
	/**
	 * The color orange.
	 */
	public static final int _orange_1 = 0xffc800; // Color orange: R=255, G=200, B=0.
	/**
	 * The color yellow.
	 */
	public static final int _yellow_1 = 0xffff00; // Color yellow: R=255, G=255, B=0.
	/**
	 * The color green.
	 */
	public static final int _green_1 = 0x00ff00; // Color green: R=0, G=255, B=0.
	/**
	 * The color magenta.
	 */
	public static final int _magenta_1 = 0xff00ff; // Color magenta: R=255, G=0, B=255.
	/**
	 * The color cyan.
	 */
	public static final int _cyan_1 = 0x00ffff; // Color cyan: R=0, G=255, B=255.
	/**
	 * The color blue.
	 */
	public static final int _blue_1 = 0x0000ff; // Color blue: R=0, G=0, B=255.

	/**
	 * The current Frame.
	 */
	final JFrame frame;
	
	/**
	 * The current canvas.
	 */
	final DrawCanvas canvas;
	
	/**
	 * The buffer strategy.
	 */
	final BufferStrategy strategy;
	
	/**
	 * The redering set.
	 */
	final public RTS_Head RENDERING_SET;// = null;

	/**
	 * Returns the rendering set.
	 * @return the rendering set.
	 */
	public RTS_Head renderingSet() {
		return (RENDERING_SET);
	}

	/**
	 * The current background color
	 */
	Color currentBackgroundColor = Color.WHITE;

	/**
	 * The current draw color
	 */
	Color currentDrawColor = Color.BLACK;

	/**
	 * The current currentBackgroundColor
	 */
	Color currentFillColor = Color.GRAY;

	/**
	 * The current stroke
	 */
	Stroke currentStroke = new BasicStroke(2.5f);

	/**
	 * The current font
	 */
	Font currentFont;

	/**
	 * The Animable interface.
	 */
	interface Animable {
		/**
		 * Paint this Animable
		 * 
		 * @param g the graphic context
		 */
		public void paint(Graphics2D g);
	}

	/**
	 * Request a repaint.
	 */
	public void repaintMe() {
		canvas.render();
	}

	/*
	 * style - the style constant for the Font The style argument is an integer
	 * bitmask that may be PLAIN, or a bitwise union of BOLD and/or ITALIC (for
	 * example, ITALIC or BOLD|ITALIC). If the style argument does not conform to
	 * one of the expected integer bitmasks then the style is set to PLAIN.
	 */
	/**
	 * set font style plain
	 */
	public void setFontStylePlain() {
		currentFont = currentFont.deriveFont(Font.PLAIN);
	}

	/**
	 * set font style bold
	 */
	public void setFontStyleBold() {
		currentFont = currentFont.deriveFont(Font.BOLD);
	}

	/**
	 * set font style italic
	 */
	public void setFontStyleItalic() {
		currentFont = currentFont.deriveFont(Font.ITALIC);
	}

	/**
	 * Set font style bold and italic.
	 */
	public void setFontStyleBoldItalic() {
		currentFont = currentFont.deriveFont(Font.BOLD | Font.ITALIC);
	}

	/**
	 * Set stroke size.
	 * @param size the stroke size.
	 */
	public void setStroke(final float size) {
		currentStroke = new BasicStroke(size);
	}

	/*
	 * FontSize usually 12.0 ?
	 */
	/**
	 * Set font size.
	 * @param size the font size.
	 */
	public void setFontSize(final float size) {
		if (DEBUG)
			RTS_COMMON.println("SetFontSize: size=" + size + ", OldFont=" + currentFont);
		currentFont = currentFont.deriveFont(size);
	}

	/**
	 * Get font size.
	 * @return the font size.
	 */
	public float getFontSize() {
		return (currentFont.getSize2D());
	}

	/**
	 * Set background color.
	 * @param color the background color
	 */
	public void setBackgroundColor(final int color) {
		currentBackgroundColor = new Color(color);
	}

	/**
	 * Set draw color.
	 * @param color the draw color
	 */
	public void setDrawColor(final int color) {
		currentDrawColor = new Color(color);
	}

	/**
	 * Set fill color.
	 * @param color the fill color
	 */
	public void setFillColor(final int color) {
		currentFillColor = new Color(color);
	}

	/**
	 * <pre>
	 * integer procedure color(r,g,b); integer r,g,b; ... ... ;
	 * </pre>
	 * 
	 * Creates an opaque sRGB color with the specified combined RGB value consisting
	 * of the red component in bits 16-23, the green component in bits 8-15, and the
	 * blue component in bits 0-7.
	 * 
	 * @param red the red component
	 * @param green the green component
	 * @param blue the blue component
	 * @return the resulting color
	 */
	public int color(final int red, final int green, final int blue) {
		int value = (red << 16) | (green << 8) | blue;
		return (value);
	}

	/**
	 * Draw Text.
	 * @param t the text
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @return the resulting _TextElement
	 */
	public RTS_TextElement drawText(final RTS_TXT t, final double x, final double y) {
		return (new RTS_TextElement(this, t, x, y)._STM());
	}

	/**
	 * Draw Line
	 * 
	 * @param x1 the X coordinate of the start point
	 * @param y1 the Y coordinate of the start point
	 * @param x2 the X coordinate of the end point
	 * @param y2 the Y coordinate of the end point
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement drawLine(final double x1, final double y1, final double x2, final double y2) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.drawLine(x1, y1, x2, y2);
		return (elt);
	}

	/**
	 * Draw Ellipse.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the ellipse
	 * @param h the height of the ellipse
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement drawEllipse(final double x, final double y, final double w, final double h) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.drawEllipse(x, y, w, h);
		return (elt);
	}

	/**
	 * Draw Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement drawRectangle(final double x, final double y, final double w, final double h) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.drawRectangle(x, y, w, h);
		return (elt);
	}

	/**
	 * Draw Rounded Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 * @param arcw the width of the arc to use to round off the corners
	 * @param arch the height of the arc to use to round off the corners
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement drawRoundRectangle(final double x, final double y, final double w, final double h,
			final double arcw, final double arch) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.drawRoundRectangle(x, y, w, h, arcw, arch);
		return (elt);
	}

	/**
	 * Fill Ellipse.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the ellipse
	 * @param h the height of the ellipse
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement fillEllipse(final double x, final double y, final double w, final double h) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.fillEllipse(x, y, w, h);
		return (elt);
	}

	/**
	 * Fill Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement fillRectangle(final double x, final double y, final double w, final double h) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.fillRectangle(x, y, w, h);
		return (elt);
	}

	/**
	 * Fill Rounded Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 * @param arcw the width of the arc to use to round off the corners
	 * @param arch the height of the arc to use to round off the corners
	 * @return the resulting _ShapeElement
	 */
	public RTS_ShapeElement fillRoundRectangle(final double x, final double y, final double w, final double h,
			final double arcw, final double arch) {
		RTS_ShapeElement elt = new RTS_ShapeElement(this)._STM();
		elt.fillRoundRectangle(x, y, w, h, arcw, arch);
		return (elt);
	}

	/**
	 * Local class DrawCanvas. 
	 */
	@SuppressWarnings("serial")
	class DrawCanvas extends Canvas {
		
		/**
		 *  Default Constructor.
		 */
		DrawCanvas(){}

		@Override
		public void paint(Graphics g) {
			render();
		}

		/**
		 * Render all elements in the RENDERING_SET.
		 */
		public void render() {
			Graphics graphics = strategy.getDrawGraphics();
			Graphics2D g = (Graphics2D) graphics;
			g.setBackground(currentBackgroundColor);
			Rectangle bnd = this.getBounds();
			g.clearRect(bnd.x, bnd.y, bnd.width, bnd.height);
			// Render to graphics
			RTS_Link lnk = RENDERING_SET.first();
			while (lnk != null) {
				if (lnk instanceof RTS_Drawing.Animable l)
					l.paint(g);
				lnk = lnk.suc();
			}
			graphics.dispose();
			strategy.show();
		}
	}

	@Override
	public RTS_Drawing _STM() {
		EBLK();
		return (this);
	}

	// Constructor
	/**
	 * Create a new Drawing Canvas.
	 * @param SL staticLink
	 * @param title panel's title
	 * @param width the width of the panel
	 * @param height the height of the panel
	 */
	public RTS_Drawing(final RTS_RTObject SL, final RTS_TXT title, final int width, final int height) {
		super(SL);
		RENDERING_SET = (RTS_Head) new RTS_Head(RTS_Drawing.this)._STM();
		frame = new JFrame(title.edText());
		canvas = new DrawCanvas();
		canvas.setSize(width, height);
		currentFont = new Font(Font.SERIF, 12, Font.PLAIN);
		if (DEBUG)
			RTS_COMMON.println("Init: Current Font=" + currentFont);
		setFontSize(12);
		if (DEBUG)
			RTS_COMMON.println("Init: Current Font=" + currentFont);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		canvas.createBufferStrategy(2);
		strategy = canvas.getBufferStrategy();
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowOpened.WindowsEvent: " + e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowClosing.WindowsEvent: " + e);
				if (e.getID() == WindowEvent.WINDOW_CLOSING) {
					System.exit(0);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowClosed.WindowsEvent: " + e);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowIconified.WindowsEvent: " + e);
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowDeiconified.WindowsEvent: " + e);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowActivated.WindowsEvent: " + e);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				if (DEBUG)
					RTS_COMMON.println("windowClosing.WindowsEvent: " + e);
			}
		});
		canvas.setFocusable(true);
		canvas.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (DEBUG)
					RTS_COMMON.println("KEY " + c + " TYPED");
				if (c == 'x')
					System.exit(0);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (DEBUG)
					RTS_COMMON.println("KEY " + e.getKeyChar() + " PRESSED");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (DEBUG)
					RTS_COMMON.println("KEY " + e.getKeyChar() + " RELEASE");
			}
		});
	}

//	private void listRenderingSet() {
//		_Link lnk = RENDERING_SET.first();
//		_RT.println("RENDERING SET: first=" + lnk);
//		while (lnk != null) {
//			_RT.println(" - " + lnk.getClass().getSimpleName());
//			lnk = lnk.suc();
//		}
//	}

}
