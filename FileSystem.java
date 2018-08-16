import java.io.File;

public class FileSystem {
    protected static String[] getChildren(String path) {
        File file = new File(path);
        String[] children = file.list();

        if (children != null)
            return children;
        else
            return new String[]{};
    }
}
