package simula.compiler.utilities;

public final class TestError {

	public static void main(String[] args) {
		new TestError().TEST();
	}

	public void TEST() {
		try {
			throw (new RuntimeException());
		} catch (RuntimeException q) {
			int PFXL1 = 1;
			System.out.println("SITUASJON 1X: PFXL1=" + PFXL1);
		}
	}
}
