package simula.compiler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import simula.compiler.utilities.Util;

public class AttributeInputStream {
	public static boolean TESTING=false;//true;//false;
	private String name;
	private ObjectInputStream in;
	
    public AttributeInputStream(String name,InputStream in) throws IOException {
    	this.name=name;
		this.in = new ObjectInputStream(new BufferedInputStream(in,10*512));
    }
	
	public Object readObject() throws IOException, ClassNotFoundException {
        Object obj=in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readObject: "+obj);
        return(obj);
	}
	
    public final boolean readBoolean() throws IOException, ClassNotFoundException {
        boolean b=(boolean) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readBoolean: "+b);
        return(b);
    }
	
    public final byte readByte() throws IOException, ClassNotFoundException {
        byte b=(byte) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readByte: "+b);
        return(b);
    }
	
    public final short readShort() throws IOException, ClassNotFoundException {
        short i=(short) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readShort: "+i);
        return(i);
    }
	
    public final int readInt() throws IOException, ClassNotFoundException {
        int i=(int) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readShort: "+i);
        return(i);
    }
	
    public final char readChar() throws IOException, ClassNotFoundException {
        char c=(char) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readChar: "+c);
        return(c);
    }
	
	public float readFloat() throws IOException, ClassNotFoundException {
        float f=(float) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readFloat: "+f);
        return(f);
	}

	public double readDouble() throws IOException, ClassNotFoundException {
        double d=(double) in.readObject();
    	if(TESTING) System.out.println("AttributeInputStream.readDouble: "+d);
        return(d);
	}

    private int kind=0;	
    public final byte readKind() throws IOException, ClassNotFoundException {
    	if(AttributeOutputStream.USE_SYNCMARK) {
    		checkSyncMark(AttributeOutputStream.SYNCMARK);
    	}
        kind = (int) in.readObject();
    	if(TESTING)
    		System.out.println("AttributeInputStream.readKind: "+kind);
        return (byte)(kind);
    }
	
	public String readIdent() throws IOException, ClassNotFoundException {
        String s=(String) in.readObject();
        if(TESTING) System.out.println("AttributeInputStream.readIdent: "+s);
    	return(s);
	}
	
	public String readString() throws IOException, ClassNotFoundException {
        String s=(String) in.readObject();
        if(TESTING) System.out.println("AttributeInputStream.readString: "+s);
    	return(s);
	}

	public void checkSyncMark(String mark) throws ClassNotFoundException, IOException {
		//System.out.println("checkSync: "+mark);
		if(AttributeOutputStream.USE_SYNCMARK) {
			Object mrk=in.readObject();
			if(mrk instanceof String smrk) if(smrk.equals(mark)) return;

			System.out.println("\n\n*******************************************************************************************************************");
			System.out.println("*** OUT OF SYNC WHILE READING "+name+": EXPECTING MARK '"+mark+"' GOT "+mrk.getClass().getSimpleName()+" '"+mrk+"'");
			System.out.println("*** OUT OF SYNC("+mark+") THE FOLLOWING INPUT IS READ-AHEAD");
			System.out.println("*******************************************************************************************************************");
			Object obj=null; int n=0;
			while((obj=in.readObject())!=null && (n++)<100) {
				System.out.println("*** OUT OF SYNC: Next Object: "+obj.getClass().getSimpleName()+" "+obj);
			}
			Util.IERR(name+":OUT OF SYNC("+mark+") "+obj.getClass().getSimpleName()+" "+mrk);
			Thread.dumpStack();
		}
	}
		
	public void readAhead(String msg,int lim) throws ClassNotFoundException, IOException {
		Object obj=null; int n=0;
		while((obj=in.readObject())!=null && (n++)<lim) {
			System.out.println("*** READ AHEAD: Next Object: "+obj.getClass().getSimpleName()+" "+obj);
		}
		Util.IERR(msg);
		Thread.dumpStack();
	}

	public void close() throws IOException {
		in.close();
	}

}
