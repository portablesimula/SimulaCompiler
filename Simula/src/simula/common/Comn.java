package simula.common;

public class Comn {

	public static int getJavaVersion() {
		String ver = System.getProperty("java.version");
		try {
			if (ver.startsWith("1.")) {
				return (ver.charAt(2) - '0');
			} else {
				for (int i = 0; i < ver.length(); i++) {
					if (ver.charAt(i) == '.') {
						ver = ver.substring(0, i);
						return (Integer.parseInt(ver));
					}
				}
			}
		} catch (Exception e) {}
		return (0);
	}
}
