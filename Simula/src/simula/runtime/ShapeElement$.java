/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

/**
 * <pre>
 * link class ShapeElement;
 * begin 
 * 
 * 
 *    procedure drawEllipse(x,y,width,height); long real x,y,width,height; ... ... ;
 *    procedure fillEllipse(x,y,width,height); long real x,y,width,height; ... ... ;
 * end;
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ShapeElement$ extends Link$ implements Animation$.Animable {
    Color drawColor; // null: no drawing
    Color fillColor; // null: no filling
    Stroke stroke;
    Shape shape;

    public void drawEllipse(double x,double y,double width,double height)
    { shape=new Ellipse2D.Double(x,y,width,height);
      drawColor=((Animation$)(this.SL$)).currentDrawColor;
      //elements.add(elt);
    }

    public void fillEllipse(double x,double y,double width,double height)
    { shape=new Ellipse2D.Double(x,y,width,height);
      fillColor=((Animation$)(this.SL$)).currentFillColor;
      //elements.add(elt);
      
    }
    
    public void moveTo(double x,double y)
    { if(shape instanceof RectangularShape)
      { RectangularShape rect=((RectangularShape)shape);
        System.out.println("Move "+shape.getClass().getSimpleName()+" to x="+x+", y="+y);
        rect.setFrame(x,y,rect.getWidth(),rect.getHeight());
      }
      try {Thread.sleep(1);}catch(Exception e) {}
      ((Animation$)(this.SL$)).repaintMe();
    }

	// Constructor
	public ShapeElement$(RTObject$ staticLink) {
		super(staticLink);
		TRACE_BEGIN_DCL$("ShapeElement$");
		CODE$ = new ClassBody(CODE$, this,2) {
			public void STM() {
				TRACE_BEGIN_STM$("ShapeElement$",inner);
				ShapeElement$.this.stroke=((Animation$)(staticLink)).currentStroke;
			    into(((Animation$)(staticLink)).SQS);
				if (inner != null) inner.STM();
				TRACE_END_STM$("ShapeElement$");
			}
		};
	}

	public ShapeElement$ STM() {
		return ((ShapeElement$) CODE$.EXEC$());
	}

	public ShapeElement$ START() {
		START(this);
		return (this);
	}

    public void paint(Graphics2D g)
    { g.setStroke(stroke);
  	  if(fillColor!=null)	{ g.setColor(fillColor); g.fill(shape); }
      if(drawColor!=null)	{ g.setColor(drawColor); g.draw(shape); }
    }

}
