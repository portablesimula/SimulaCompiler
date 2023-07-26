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

/**
 *  Additional System class TextElement.
 * <pre>
 * Link class TextElement(t,x,y); Value t; Text t; Long Real x,y;
 * begin Integer COLOR,STROKE; Text T; Long Real X,Y;
 *       ref(Font) FONT; ! Java Class Font is not visible in Simula ;
 *
 *       Procedure setColor(color); Integer color; COLOR := color;  
 *       Procedure setStroke(width); Real width; CURRENT_STROKE_WIDTH := width; 
 *
 *       Procedure setFontStylePlain;      FONT :- FONT.deriveFont(Font.PLAIN);  
 *       Procedure setFontStyleBold;       FONT :- FONT.deriveFont(Font.BOLD); 
 *       Procedure setFontStyleItalic;     FONT :- FONT.deriveFont(Font.ITALIC); 
 *       Procedure setFontStyleBoldItalic; FONT :- FONT.deriveFont(Font.BOLD|Font.ITALIC); 
 *          
 *       Procedure setFontSize(size); Real size; FONT :- FONT.deriveFont(size); 
 *       Real Procedure getFontSize; getFontSize := FONT.getSize2D;
 * 
 *       Procedure setText(t); Value t; Text t; T :- t;
 *       Procedure moveTo(x,y,speed); Long Real x,y,speed; begin X := x; Y := y; ... end;
 *       Procedure instantMoveTo(x,y); Long Real x,y; begin X := x; Y := y; end;
 *       
 *       T :- t; X := x; Y := y;
 *       
 *       COLOR := CURRENT_DRAW_COLOR;
 *       STROKE := CURRENT_STROKE_WIDTH;
 *       FONT :- CURRENT_FONT;
 *       
 *       into(RENDERING_SET);
 *
 * end;
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_TextElement.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public class RTS_TextElement extends RTS_Link implements RTS_Drawing.Animable {
	/**
	 * The current animation.
	 */
	final RTS_Drawing animation;
	/**
	 * The X coordinate
	 */
	double x;
	/**
	 * The Y coordinate
	 */
	double y;
	/**
	 * The current string text.
	 */
	String str;
	/**
	 * The current color.
	 */
	Color color;
	/**
	 * The current Font.
	 */
	Font font;
	/**
	 * The current stroke.
	 */
	Stroke stroke;

	/**
	 * Create a new _TextElement.
	 * @param SL staticLink
	 * @param txt the initial text
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public RTS_TextElement(final RTS_RTObject SL, final RTS_TXT txt, final double x, final double y) {
		this(SL, txt.edText(), x, y);
	}

	/**
	 * Create a new _TextElement.
	 * @param SL staticLink
	 * @param str the initial text
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public RTS_TextElement(final RTS_RTObject SL, final String str, final double x, final double y) {
		super(SL);
		// TRACE_BEGIN_DCL("_TextElement");
		animation = (RTS_Drawing) SL;
		RTS_TextElement.this.str = str;
		RTS_TextElement.this.x = x;
		RTS_TextElement.this.y = y;
		RTS_TextElement.this.color = ((RTS_Drawing) (SL)).currentDrawColor;
		RTS_TextElement.this.stroke = ((RTS_Drawing) (SL)).currentStroke;
		RTS_TextElement.this.font = ((RTS_Drawing) (SL)).currentFont;
		into(((RTS_Drawing) (SL)).RENDERING_SET);
		animation.repaintMe();
	}

	@Override
	public RTS_TextElement _STM() {
		// TRACE_BEGIN_STM("_TextElement");
//		_TextElement.this.str=str; _TextElement.this.x=x; _TextElement.this.y=y;
//		_TextElement.this.color=((_Drawing)(staticLink)).currentDrawColor;
//		_TextElement.this.stroke=((_Drawing)(staticLink)).currentStroke;
//		_TextElement.this.font=((_Drawing)(staticLink)).currentFont;
//	    into(((_Drawing)(staticLink)).RENDERING_SET);
//	    animation.repaintMe();
		// INNER
		// TRACE_END_STM("_TextElement");
		EBLK();
		return (this);
	}

	/**
	 * Set font style plain.
	 */
	public void setFontStylePlain() {
		font = font.deriveFont(Font.PLAIN);
	}

	/**
	 * Set font style bold.
	 */
	public void setFontStyleBold() {
		font = font.deriveFont(Font.BOLD);
	}

	/**
	 * Set font style talic.
	 */
	public void setFontStyleItalic() {
		font = font.deriveFont(Font.ITALIC);
	}

	/**
	 * Set font style bold and italic.
	 */
	public void setFontStyleBoldItalic() {
		font = font.deriveFont(Font.BOLD | Font.ITALIC);
	}

	/**
	 * Set stroke size.
	 * @param size stroke size
	 */
	public void setStroke(final float size) {
		stroke = new BasicStroke(size);
	}

	/**
	 * Get font size.
	 * @return the font size
	 */
	public float getFontSize() {
		return (font.getSize2D());
	}

	/**
	 * Set font size.
	 * @param size font size
	 */
	public void setFontSize(final float size) {
		font = font.deriveFont(size);
	}

	/**
	 * Set color.
	 * @param rgb color
	 */
	public void setColor(final int rgb) {
		color = new Color(rgb);
		animation.repaintMe();
	}

	/**
	 * Set new text.
	 * @param t new text
	 */
	public void setText(RTS_TXT t) {
		str = t.edText();
		animation.repaintMe();
	}

	/**
	 * Instant move.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public void instantMoveTo(final double x, final double y) {
		this.x = x;
		this.y = y;
		animation.repaintMe();
	}

	// speed = pixels per milli-second ???
	/**
	 * Rolling motion to a new position.
	 * 
	 * @param x2 the X coordinate
	 * @param y2 the Y coordinate
	 * @param speed pixels per milli-second
	 */
	public void moveTo(final double x2, final double y2, final double speed) {
		double x1 = x;
		double y1 = y;
		double dx = (x2 - x1) / 500;
		double dy = (y2 - y1) / 500;
		int wait = (int) speed / 100;
		if (wait < 1)
			wait = 1;
		if (wait > 50)
			wait = 50;
		for (int i = 0; i < 500; i++) {
			x1 = x1 + dx;
			y1 = y1 + dy;
			instantMoveTo(x1, y1);
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
			}
		}
		instantMoveTo(x, y);
	}

	public void paint(final Graphics2D g) {
		g.setStroke(stroke);
		g.setColor(color);
		g.setFont(font);
		g.drawString(str, (float) x, (float) y);
	}

}
