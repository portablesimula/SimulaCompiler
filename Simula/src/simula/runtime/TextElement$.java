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
		CODE$ = new ClassBody(CODE$, this,2) {
			public void STM() {
				TRACE_BEGIN_STM$("TextElement$",inner);
				TextElement$.this.str=str; TextElement$.this.x=x; TextElement$.this.y=y;
				TextElement$.this.color=((Animation$)(staticLink)).currentDrawColor;
				TextElement$.this.stroke=((Animation$)(staticLink)).currentStroke;
				TextElement$.this.font=((Animation$)(staticLink)).currentFont;
			    into(((Animation$)(staticLink)).SQS);
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

    public void paint(Graphics2D g)
    { g.setStroke(stroke);
      g.setColor(color);
      g.setFont(font);
      g.drawString(str,(float)x,(float)y);
    }

}
