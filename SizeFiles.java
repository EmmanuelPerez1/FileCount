import java.io.File;
import java.util.Arrays;

public class SizeFiles {
    public static void main(String[] args) {
            String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1";
            String[] lines = GetFileLines(path);
            int total = 0;

            for (int i = 0; i <= lines.length -1; i++) {
                String fileName = path + "\\" + lines[i];
                int lineCount = GetFileLines(fileName).length;

                System.out.println(fileName);
                System.out.println(lineCount);
                total += lineCount;
            }

            System.out.println();
            System.out.println("Total: " + total);
    }

    public static String[] GetFileLines(String filePath) {
            File fichero = new File(filePath);

            return fichero.list();
    }
}
