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
 * 
 * @author Øystein Myhre Andersen
 */
public class TextElement$ extends Link$ implements Drawing$.Animable {
	Drawing$ animation;
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
		animation=(Drawing$)staticLink;
		CODE$ = new ClassBody(CODE$, this,2) {
			public void STM$() {
				TRACE_BEGIN_STM$("TextElement$",inner);
				TextElement$.this.str=str; TextElement$.this.x=x; TextElement$.this.y=y;
				TextElement$.this.color=((Drawing$)(staticLink)).currentDrawColor;
				TextElement$.this.stroke=((Drawing$)(staticLink)).currentStroke;
				TextElement$.this.font=((Drawing$)(staticLink)).currentFont;
			    into(((Drawing$)(staticLink)).RENDERING_SET);
			      animation.repaintMe();
				if (inner != null) inner.STM$();
				TRACE_END_STM$("TextElement$");
			}
		};
	}

	public TextElement$ STM$() {
		return ((TextElement$) CODE$.EXEC$());
	}

	public TextElement$ START() {
		START(this);
		return (this);
	}
    public void setFontStylePlain() { font=font.deriveFont(Font.PLAIN); }
    public void setFontStyleBold() { font=font.deriveFont(Font.BOLD); }
    public void setFontStyleItalic() { font=font.deriveFont(Font.ITALIC); }
    public void setFontStyleBoldItalic() { font=font.deriveFont(Font.BOLD|Font.ITALIC); }
    public void setStroke(float size) { stroke=new BasicStroke(size); }
    public float getFontSize() { return(font.getSize2D()); }
    public void setFontSize(float size) { font=font.deriveFont(size); }

    public void setColor(int rgb)
    { color=new Color(rgb);
      animation.repaintMe();
    }

    public void setText(TXT$ t)
    { str=t.edText();
      animation.repaintMe();
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
      //System.out.println("TextElement.paint: "+str+", color="+color+", font="+font);
      g.drawString(str,(float)x,(float)y);
    }

}
