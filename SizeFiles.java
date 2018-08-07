import java.io.File;
import java.util.Arrays;
import javax.swing.*;

public class SizeFiles {
    public static void main(String[] args) {
        String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1";
        String[] lines = GetDirContents(path);
        int total = 0;

        for (int i = 0; i <= lines.length -1; i++) {
            String fileName = path + "\\" + lines[i];
            int lineCount = lines.length;

            System.out.println(fileName);
            System.out.println(lineCount);
            total += lineCount;
        }

        System.out.print("\nTotal: " + total);
    }

    private static String[] GetDirContents(String filePath) {
        File fichero = new File(filePath);
        String[] lines = fichero.list();

        if (lines != null)
            return lines;
        else
            return new String[0];
    }
}
