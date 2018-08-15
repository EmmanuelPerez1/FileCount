import java.io.File;

public class Directory {
    protected static String[] getDirContents(String filePath) {
        File file = new File(filePath);
        String[] items = file.list();

        if (items != null) {
            return items;
        }
        return new String[0];
    }
}
