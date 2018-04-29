/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Image-Oriented Files.
 * <p>
 * The (file) class "imagefile" defines the common attributes for all image-
 * oriented files.
 * <p>
 * <pre>
 *      file class imagefile;
 *           begin text image;
 *              procedure setpos(i);  integer i;  image.setpos(i);
 *              integer procedure pos;     pos    := image.pos;
 *              Boolean procedure more;    more   := image.more;
 *              integer procedure length;  length := image.length;
 *           end imagefile;
 * </pre>
 * <p>
 * The individual logical unit of an external file associated with an imagefile
 * is called an "external image". Each external image is an an ordered sequence
 * of characters.
 * <p>
 * The variable "image" is used to reference a text frame which acts as a
 * buffer, in the sense that it contains the external image currently being
 * processed.
 * <p>
 * The procedures "setpos", "pos", "more" and "length" are introduced for
 * reasons of convenience.
 * <p>
 * The three standard subclasses of imagefile are "infile" (sequential input
 * file), "outfile" (sequential output file) and "directfile" (bidirectional
 * direct file). In addition, "printfile", a standard subclass of class outfile,
 * is available. It represents a line printer oriented file.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class ImageFile$ extends FILE$ {
	public TXT$ image;

	public void setpos(int i) {
		image.setpos(i);
	}

	public int pos() {
		return (image.pos());
	}

	public boolean more() {
		return (image.more());
	}

	public int length() {
		return (image.length());
	}

	// Constructor
   public ImageFile$(RTObject$ staticLink,TXT$ FILENAME) {
      super(staticLink,FILENAME);
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
            if(inner!=null) inner.STM();
      }};
   }
   // Class Statements
   public ImageFile$ STM() { return((ImageFile$)CODE$.EXEC$()); }
   public ImageFile$ START() { START(this); return(this); }

}
