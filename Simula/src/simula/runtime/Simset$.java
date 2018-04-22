package simula.runtime;

import simula.compiler.utilities.Util;

/**
 * The class "simset" contains facilities for the manipulation of circular
 * two-way lists, called "sets".
 * 
 * <pre>
 *          class simset;
 *          begin
 *                     class linkage;
 *             linkage class link; 
 *             linkage class head; 
 *          end simset;
 * </pre>
 * 
 * The reference variables and procedures necessary for set handling are
 * introduced in standard classes declared within the class "simset". Using
 * these classes as prefixes, their relevant data and other properties are made
 * parts of the object themselves.
 * <p>
 * Both sets and objects which may acquire set membership have references to a
 * successor and a predecessor. Consequently they are made subclasses of the
 * "linkage" class.
 * <p>
 * The sets are represented by objects belonging to a subclass "head" of
 * "linkage". Objects which may be set members belong to subclasses of "link"
 * which is itself another subclass of "linkage".
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class Simset$ extends CLASS$ {

	// Constructor
    public Simset$(RTObject$ staticLink) {
      super(staticLink);
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
            BBLK(); // Iff no prefix
        	//Util.BREAK("Simset$ Before INNER");
            if(inner!=null) inner.STM();
        	//Util.BREAK("Simset$ After INNER");
            EBLK(); // Iff no prefix
      }};
    }
    public Simset$ STM() { return((Simset$)CODE$.EXEC$()); }
    public Simset$ START() { START(this); return(this); }

}
