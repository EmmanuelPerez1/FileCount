import java.io.File;
import java.util.Arrays;

public class SizeFiles {
	public static void main(String[] args) {
			//String path = "\\\\172.18.19.141\\nice\\Grabaciones\\Llamadas nice";
		    //System.out.println(Size(path));
			//System.out.println(/*Arrays.toString*/(nameCarpet(path)[1]));
			String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1";
			String[] as = Size(nameCarpet(path), path);
			int fSize = 0;
			for (int i = 0; i <= nameCarpet(path).length -1; i++) {
				String path2 = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1" + "\\" + as[i];
				System.out.println(path2);
				int x = nameCarpet(path2).length;
				System.out.println(x);
				fSize += x;
			}
			System.out.println(fSize);
			//String path2 = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1" + "\\" + as[1];
			//System.out.println(path2);
			//int x = nameCarpet(path2).length;
			//System.out.println(x);

			//for (int i = 0; i <= nameCarpet(path).length - 1; i ++ ) {
			//	System.out.println("File No. = " + (i + 1) + " : " + as[i]);
			//}
			//System.out.println(as[0]);
	}

	public static String[] nameCarpet(String path) {
			String sTest = path;
    		File fichero = new File(sTest);
    		String as[] = fichero.list();
    		return as;
   			//return fichero.list() /*.length*/;
	}

	public static String[] Size(String[] nameCarpet, String path) {
		String[] x = new String[nameCarpet(path).length];
		x = nameCarpet(path);
		//x[0] = nameCarpet(path)[1];
		return x;
	}
}
