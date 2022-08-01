package simula.compiler;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AttributeOutput {
	public static boolean TESTING=false;//true;//false;
	public static final boolean USE_SYNCMARK=true;//false;

	ObjectOutputStream out;

	public AttributeOutput(OutputStream out) throws IOException {
		this.out = new ObjectOutputStream(out);
	}

	
	public void writeObject(Object obj) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeObject: "+obj);
        out.writeObject(obj);
	}

	
    public final void writeBoolean(boolean val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeBoolean: "+val);
        out.writeObject(val);
    }

	
    public final void writeByte(int val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeByte: "+val);
        out.writeObject((byte)val);
    }

	
    public final void writeShort(int val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeShort: "+val);
        out.writeObject((short)val);
    }

	
    public final void writeChar(int val) throws IOException {
        out.writeObject(val);
    }

	
    public final void writeInt(int val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeInt: "+val);
        out.writeObject(val);
    }

	
	public void writeLong(long val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeLong: "+val);
        out.writeObject(val);
	}

	
    public final void writeFloat(float val) throws IOException {
        out.writeObject(val);
    }

	
    public final void writeDouble(double val) throws IOException {
        out.writeObject(val);
    }

    public static final String SYNCMARK="DESCRIPTOR";
	
    public final void writeKind(int val) throws IOException {
    	if(TESTING) System.out.println("AttributeOutputStream.writeKind: "+val);
    	if(USE_SYNCMARK) {
            out.writeObject(SYNCMARK);
    	}
        out.writeObject(val);
    }

	
	public void writeIdent(String str) throws IOException {
		if(TESTING) System.out.println("AttributeOutputStream.writeIdent: \""+str+'"');
        out.writeObject(str);
	}

	
	public void writeString(String str) throws IOException {
		if(TESTING) System.out.println("AttributeOutputStream.writeString: \""+str+'"');
        out.writeObject(str);
	}

	
	public void writeSyncMark(String mrk) throws IOException {
    	if(USE_SYNCMARK)
    		out.writeObject(mrk);
	}

	
	public void close() throws IOException {
        out.flush();
		out.close();
	}

}
