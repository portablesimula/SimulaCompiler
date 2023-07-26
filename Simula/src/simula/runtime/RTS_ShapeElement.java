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
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

/**
 * Additional System class ShapeElement.
 * <pre>
 * Link class ShapeElement;
 * begin Integer COLOR,STROKE;
 *       ref(Shape) SHAPE; ! Java Class Shape is not visible in Simula ;
 * 
 *       Procedure setColor(rgb); Integer rgb; ... ... ;
 *       Procedure setStroke(size); Real size; ... ... ;
 * 
 *       Procedure drawLine(x1,y1,x2,y2); Long Real x1,y1,x2,y2; ... ... ;
 *       Procedure drawEllipse(x,y,width,height); Long Real x,y,width,height; ... ... ;
 *       Procedure drawRectangle(x,y,width,height); Long Real x,y,width,height; ... ... ;
 *       Procedure drawRoundRectangle(x,y,width,height,arcw,arch); Long Real x,y,width,height,arcw,arch; ... ... ;
 *       Procedure fillEllipse(x,y,width,height); Long Real x,y,width,height; ... ... ;
 *       Procedure fillRectangle(x,y,width,height); Long Real x,y,width,height; ... ... ;
 *       Procedure fillRoundRectangle(x,y,width,height,arcw,arch); Long Real x,y,width,height,arcw,arch; ... ... ;
 *    
 *       Procedure instantMoveTo(x,y); Long Real x,y; ... ... ;
 *       Procedure moveTo(x,y,speed); Long Real x,y,speed; ... ... ;
 *    
 *       STROKE := CURRENT_STROKE_WIDTH;
 *       into(RENDERING_SET);
 * end;
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_ShapeElement.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public class RTS_ShapeElement extends RTS_Link implements RTS_Drawing.Animable {
	/**
	 * The current drawing.
	 */
	final RTS_Drawing drawing;
	/**
	 * The current draw color. If null: no drawing
	 */
	Color drawColor; // null: no drawing
	/**
	 * The current fill color. If null: no filling
	 */
	Color fillColor; // null: no filling
	/**
	 * The current stroke.
	 */
	Stroke stroke;
	/**
	 * The current shape.
	 */
	Shape shape;

	// Constructor
	/**
	 * Create a new _ShapeElement.
	 * @param SL staticLink
	 */
	public RTS_ShapeElement(RTS_RTObject SL) {
		super(SL);
		drawing = (RTS_Drawing) SL;
		stroke = drawing.currentStroke;
		// _RT.println("New ShapeElement: into "+drawing.RENDERING_SET);
		into(drawing.RENDERING_SET);
	}

	@Override
	public RTS_ShapeElement _STM() {
		// TRACE_BEGIN_STM("_ShapeElement");
//		_ShapeElement.this.stroke=drawing.currentStroke;
//		_ShapeElement.this.into(drawing.RENDERING_SET);
		// INNER
		// TRACE_END_STM("_ShapeElement");
		EBLK();
		return (this);
	}

	/**
	 * Draw Line
	 * 
	 * @param x1 the X coordinate of the start point
	 * @param y1 the Y coordinate of the start point
	 * @param x2 the X coordinate of the end point
	 * @param y2 the Y coordinate of the end point
	 */
	public void drawLine(final double x1, final double y1, final double x2, final double y2) {
		shape = new Line2D.Double(x1, y1, x2, y2);
		drawColor = drawing.currentDrawColor;
		drawing.repaintMe();
	}

	/**
	 * Draw Ellipse.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the ellipse
	 * @param h the height of the ellipse
	 */
	public void drawEllipse(final double x, final double y, final double w, final double h) {
		shape = new Ellipse2D.Double(x, y, w, h);
		drawColor = drawing.currentDrawColor;
		drawing.repaintMe();
	}

	/**
	 * Draw Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 */
	public void drawRectangle(final double x, final double y, final double w, final double h) {
		shape = new Rectangle2D.Double(x, y, w, h);
		drawColor = drawing.currentDrawColor;
		drawing.repaintMe();
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
	 */
	public void drawRoundRectangle(final double x, final double y, final double w, final double h,
			final double arcw, final double arch) {
		shape = new RoundRectangle2D.Double(x, y, w, h, arcw, arch);
		drawColor = drawing.currentDrawColor;
		drawing.repaintMe();
	}

	/**
	 * Fill Ellipse.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the ellipse
	 * @param h the height of the ellipse
	 */
	public void fillEllipse(final double x, final double y, final double w, final double h) {
		shape = new Ellipse2D.Double(x, y, w, h);
		// _RT.println("ShapeElement.fillEllipse: "+shape);
		fillColor = drawing.currentFillColor;
		drawing.repaintMe();
	}

	/**
	 * Fill Rectangle.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param w the width of the rectangle
	 * @param h the height of the rectangle
	 */
	public void fillRectangle(final double x, final double y, final double w, final double h) {
		shape = new Rectangle2D.Double(x, y, w, h);
		fillColor = drawing.currentFillColor;
		drawing.repaintMe();
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
	 */
	public void fillRoundRectangle(final double x, final double y, final double w, final double h,
			final double arcw, final double arch) {
		shape = new RoundRectangle2D.Double(x, y, w, h, arcw, arch);
		fillColor = drawing.currentFillColor;
		drawing.repaintMe();
	}

	/**
	 * Set fill and draw color.
	 * @param rgb the new fill and draw color.
	 */
	public void setColor(final int rgb) {
		if (fillColor != null) {
			fillColor = new Color(rgb);
		}
		if (drawColor != null) {
			drawColor = new Color(rgb);
		}
		drawing.repaintMe();
	}

	/**
	 * Set stroke size.
	 * @param size the new stroke size.
	 */
	public void setStroke(final float size) {
		stroke = new BasicStroke(size);
	}

	/**
	 * Instant move.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public void instantMoveTo(final double x, final double y) {
		if (shape instanceof RectangularShape rect) {
			rect.setFrame(x, y, rect.getWidth(), rect.getHeight());
		}
		drawing.repaintMe();
	}

	// speed = pixels per milli-second ???
	/**
	 * Rolling motion to a new position.
	 * 
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param speed pixels per milli-second
	 */
	public void moveTo(final double x, final double y, final double speed) {
		if (shape == null)
			return;
		Rectangle2D bnd = shape.getBounds2D();
		double x1 = bnd.getX();
		double y1 = bnd.getY();
		double dx = (x - x1) / 500;
		double dy = (y - y1) / 500;
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

	@Override
	public void paint(final Graphics2D g) {
		g.setStroke(stroke);
		if (fillColor != null) {
			g.setColor(fillColor);
			g.fill(shape);
		}
		if (drawColor != null) {
			g.setColor(drawColor);
			g.draw(shape);
		}
	}

}
