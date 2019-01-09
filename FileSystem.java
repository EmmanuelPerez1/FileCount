import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.util.ArrayList;

class FileSystem {
    private String inputFile;

    FileSystem(String inputFile) {
        this.inputFile = inputFile;
    }

    private String[] GetDirContents(String filePath) {
        File fichero = new File(String.valueOf(filePath));
        String[] lines = fichero.list();

        if (lines != null)
            return lines;

        return new String[0];
    }

    private String[] GetDirectories() {
        ArrayList<String> paths = new ArrayList<>();
        String date = new MyDate().GetDate();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                line = reader.readLine();
                paths.add(line + "\\" + date);
            }
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return paths.toArray(new String[0]);
    }

    private int GetCount(String path) {
        String[] scFolder = GetDirContents(path);
        int totalRecordings = 0;

        for (int i = 0; i < scFolder.length; i++) {
            String firstFolderName = path + "\\" + scFolder[i];
            String[] randomFolder = GetDirContents(firstFolderName);

            for (int j = 0; j < randomFolder.length; j++) {
                String secondFolderName =  firstFolderName + "\\" + randomFolder[j];
                String[] fileCount = GetDirContents(secondFolderName);

                totalRecordings += fileCount.length;
            }
        }

        return totalRecordings;
    }

    public String GetInfo() {
        StringBuilder builder = new StringBuilder();
        String[] directories = GetDirectories();

        for (int i = 0; i <= directories.length - 1; i++) {
            String dir = directories[i];

            builder.append(dir + GetCount(dir) +
                " grabaciones de la ruta \"" + dir + "\"\n");
        }

        return builder.toString();
    }
}
