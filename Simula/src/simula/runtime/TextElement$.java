/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 * <pre>
 * link class TextElement;
 * begin
 *  
 * end;
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class TextElement$ extends Link$ implements Animation$.Animable {
	Animation$ animation;
    double x,y;
    String str;
    Color color;
    Font font;
    Stroke stroke;
    
	// Constructors

	public TextElement$(RTObject$ staticLink,TXT$ txt,double x,double y) {
		this(staticLink,txt.edText(),x,y);
	}
    
	public TextElement$(RTObject$ staticLink,String str,double x,double y) {
		super(staticLink);
		TRACE_BEGIN_DCL$("TextElement$");
		animation=(Animation$)staticLink;
		CODE$ = new ClassBody(CODE$, this,2) {
			public void STM() {
				TRACE_BEGIN_STM$("TextElement$",inner);
				TextElement$.this.str=str; TextElement$.this.x=x; TextElement$.this.y=y;
				TextElement$.this.color=((Animation$)(staticLink)).currentDrawColor;
				TextElement$.this.stroke=((Animation$)(staticLink)).currentStroke;
				TextElement$.this.font=((Animation$)(staticLink)).currentFont;
			    into(((Animation$)(staticLink)).SQS);
			      animation.repaintMe();
				if (inner != null) inner.STM();
				TRACE_END_STM$("TextElement$");
			}
		};
	}

	public TextElement$ STM() {
		return ((TextElement$) CODE$.EXEC$());
	}

	public TextElement$ START() {
		START(this);
		return (this);
	}
    
    public void instantMoveTo(double x,double y)
    { this.x=x; this.y=y;
      animation.repaintMe();
    }
    
    // speed = pixels per milli-second ???
    public void moveTo(double x2,double y2,double speed)
    { double x1=x;
      double y1=y;
      double dx=(x2-x1)/500;
      double dy=(y2-y1)/500;
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

    public void paint(Graphics2D g)
    { g.setStroke(stroke);
      g.setColor(color);
      g.setFont(font);
      System.out.println("TextElement.paint: "+str+", color="+color+", font="+font);
      g.drawString(str,(float)x,(float)y);
    }

}
