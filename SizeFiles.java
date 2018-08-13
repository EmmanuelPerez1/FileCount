import java.io.File;
import java.util.TimeZone;
import java.util.Calendar;

public class SizeFiles {
    public static void main(String[] args) {
        //String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1";
        System.out.print("De la siguiente ruta: " + GetDir() + " hay este numero de grabaciones:  " +  GetCount(GetDir()) );
    }

    private static String[] GetDirContents(String filePath) {
        File fichero = new File(String.valueOf(filePath));
        String[] lines = fichero.list();

        if (lines != null) {
            return lines;
        }
        return new String[0];
    }

    private static int GetCount(String path1){
        String[] lines = GetDirContents(path1);
        int total = 0;

        for (int i = 0; i <= lines.length -1; i++) {
            String fileName = path1 + "\\" + lines[i];
            String[] filecount = GetDirContents(fileName);
            int lineCount = filecount.length;

            total += lineCount;
        }

        return total;
    }

    private static String GetDir(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE) - 1;
        int month = calendar.get(Calendar.MONTH) + 1;
        //System.out.printf("Día: " + (day - 1) + " mes " + (month + 1));
        String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\"+month+"\\"+day+ "\\SC_SC Dinamarca 1";
        return path;
    }
}
