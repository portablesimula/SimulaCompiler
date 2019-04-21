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
 * 
 * @author Øystein Myhre Andersen
 */
public class ShapeElement$ extends Link$ implements Drawing$.Animable {
	final Drawing$ drawing;
    Color drawColor; // null: no drawing
    Color fillColor; // null: no filling
    Stroke stroke;
    Shape shape;

	// Constructor
	public ShapeElement$(RTObject$ staticLink) {
		super(staticLink);
		drawing=(Drawing$)staticLink;
		stroke=drawing.currentStroke;
		//RT.println("New ShapeElement: into "+drawing.RENDERING_SET);
		into(drawing.RENDERING_SET);
	}
	public ShapeElement$ STM$() {
		//TRACE_BEGIN_STM$("ShapeElement$");
//		ShapeElement$.this.stroke=drawing.currentStroke;
//		//RT.println("New ShapeElement: into "+drawing.RENDERING_SET);
//		ShapeElement$.this.into(drawing.RENDERING_SET);
		// INNER
		//TRACE_END_STM$("ShapeElement$");
		EBLK();
		return(this);
	}

    public void drawLine(final double x1,final double y1,final double x2,final double y2)
    { shape=new Line2D.Double(x1,y1,x2,y2);
      drawColor=drawing.currentDrawColor;
      drawing.repaintMe();
    }

    public void drawEllipse(final double x,final double y,final double width,final double height)
    { shape=new Ellipse2D.Double(x,y,width,height);
      drawColor=drawing.currentDrawColor;
      drawing.repaintMe();
    }

    public void drawRectangle(final double x,final double y,final double width,final double height)
    { shape=new Rectangle2D.Double(x,y,width,height);
      drawColor=drawing.currentDrawColor;
      drawing.repaintMe();
    }

    public void drawRoundRectangle(final double x,final double y,final double width,final double height, final double arcw, final double arch)
    { shape=new RoundRectangle2D.Double(x,y,width,height,arcw,arch);
      drawColor=drawing.currentDrawColor;
      drawing.repaintMe();
    }

    public void fillEllipse(final double x,final double y,final double width,final double height)
    { shape=new Ellipse2D.Double(x,y,width,height);
      //RT.println("ShapeElement.fillEllipse: "+shape);
      fillColor=drawing.currentFillColor;
      drawing.repaintMe();
    }

    public void fillRectangle(final double x,final double y,final double width,final double height)
    { shape=new Rectangle2D.Double(x,y,width,height);
      fillColor=drawing.currentFillColor;
      drawing.repaintMe();
    }

    public void fillRoundRectangle(final double x,final double y,final double width,final double height, final double arcw, final double arch)
    { shape=new RoundRectangle2D.Double(x,y,width,height,arcw,arch);
      fillColor=drawing.currentFillColor;
      drawing.repaintMe();
    }

    public void setColor(final int rgb)
    { if(fillColor!=null) { fillColor=new Color(rgb); }
      if(drawColor!=null) { drawColor=new Color(rgb); }
      drawing.repaintMe();
    }

    public void setStroke(final float size) { stroke=new BasicStroke(size); }
    
    public void instantMoveTo(final double x,final double y)
    { if(shape instanceof RectangularShape)
      { RectangularShape rect=((RectangularShape)shape);
        //RT.println("Move "+shape.getClass().getSimpleName()+" to x="+x+", y="+y);
        rect.setFrame(x,y,rect.getWidth(),rect.getHeight());
      }
      drawing.repaintMe();
    }
    
    // speed = pixels per milli-second ???
    public void moveTo(final double x,final double y,final double speed)
    { if(shape==null) return;
      Rectangle2D bnd=shape.getBounds2D();
      double x1=bnd.getX();
      double y1=bnd.getY();
      double dx=(x-x1)/500;
      double dy=(y-y1)/500;
      int wait=(int)speed/100;
      if(wait<1) wait=1;
      if(wait>50) wait=50;
      for(int i=0;i<500;i++)
      { x1=x1+dx; y1=y1+dy;
        instantMoveTo(x1,y1);
        try {Thread.sleep(wait);}catch(Exception e) {}
      }
      instantMoveTo(x,y);
    }

    public void paint(final Graphics2D g)
    { g.setStroke(stroke);
  	  if(fillColor!=null)	{ g.setColor(fillColor); g.fill(shape); }
      if(drawColor!=null)	{ g.setColor(drawColor); g.draw(shape); }
    }

}
