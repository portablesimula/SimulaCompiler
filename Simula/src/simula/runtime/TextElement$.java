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
	final Drawing$ animation;
    double x,y;
    String str;
    Color color;
    Font font;
    Stroke stroke;
    
	// Constructors

	public TextElement$(final RTObject$ staticLink,final TXT$ txt,final double x,final double y) {
		this(staticLink,txt.edText(),x,y);
	}
    
	public TextElement$(final RTObject$ staticLink,final String str,final double x,final double y) {
		super(staticLink);
		//TRACE_BEGIN_DCL$("TextElement$");
		animation=(Drawing$)staticLink;
		TextElement$.this.str=str; TextElement$.this.x=x; TextElement$.this.y=y;
		TextElement$.this.color=((Drawing$)(staticLink)).currentDrawColor;
		TextElement$.this.stroke=((Drawing$)(staticLink)).currentStroke;
		TextElement$.this.font=((Drawing$)(staticLink)).currentFont;
	    into(((Drawing$)(staticLink)).RENDERING_SET);
	    animation.repaintMe();
	}
	
	public TextElement$ STM$() {
		//TRACE_BEGIN_STM$("TextElement$");
//		TextElement$.this.str=str; TextElement$.this.x=x; TextElement$.this.y=y;
//		TextElement$.this.color=((Drawing$)(staticLink)).currentDrawColor;
//		TextElement$.this.stroke=((Drawing$)(staticLink)).currentStroke;
//		TextElement$.this.font=((Drawing$)(staticLink)).currentFont;
//	    into(((Drawing$)(staticLink)).RENDERING_SET);
//	      animation.repaintMe();
		// INNER
		//TRACE_END_STM$("TextElement$");
		EBLK();
		return(this);
	}
	
    public void setFontStylePlain() { font=font.deriveFont(Font.PLAIN); }
    public void setFontStyleBold() { font=font.deriveFont(Font.BOLD); }
    public void setFontStyleItalic() { font=font.deriveFont(Font.ITALIC); }
    public void setFontStyleBoldItalic() { font=font.deriveFont(Font.BOLD|Font.ITALIC); }
    public void setStroke(final float size) { stroke=new BasicStroke(size); }
    public float getFontSize() { return(font.getSize2D()); }
    public void setFontSize(final float size) { font=font.deriveFont(size); }

    public void setColor(final int rgb)
    { color=new Color(rgb);
      animation.repaintMe();
    }

    public void setText(TXT$ t)
    { str=t.edText();
      animation.repaintMe();
    }
    
    public void instantMoveTo(final double x,final double y)
    { this.x=x; this.y=y;
      animation.repaintMe();
    }
    
    // speed = pixels per milli-second ???
    public void moveTo(final double x2,final double y2,final double speed)
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

    public void paint(final Graphics2D g)
    { g.setStroke(stroke);
      g.setColor(color);
      g.setFont(font);
      //System.out.println("TextElement.paint: "+str+", color="+color+", font="+font);
      g.drawString(str,(float)x,(float)y);
    }

}
