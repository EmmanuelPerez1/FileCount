import java.io.File;
import java.util.TimeZone;
import java.util.Calendar;

public class SizeFiles {
    public static void main(String[] args) {
        //String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\8\\5\\SC_SC Dinamarca 1";
        for(int i = 0; i <=GetDir().length - 1; i++) {
            System.out.print("De la siguiente ruta: " + GetDir()[i] + " hay este numero de grabaciones:  " + GetCount(GetDir()[i]) + "\n");
        }
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

    public static String[] GetDir(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE) - 1;
        int month = calendar.get(Calendar.MONTH) + 1;
        String[] path = {"\\\\172.18.48.230\\nice_sc\\niceapps1din\\48\\2018\\"+month+"\\"+day+"\\SC_SC Dinamarca 1",
        "\\\\172.18.54.152\\grabanicevol\\niceapps1yuc\\46\\2018\\"+month+"\\"+day+"\\SC_NiceSC1yuc",
        "\\\\172.18.54.152\\grabanicevol\\niceapps1yuc\\46\\2018\\"+month+"\\"+day+"\\SC_NiceSC2yuc",
        "\\\\172.18.54.152\\NIM 4.1 Dinamarca\\niceapps1yuc\\46\\2018\\"+month+"\\"+day+"\\SC_NiceSC1yuc",
        "\\\\172.18.54.152\\NIM 4.1 Dinamarca\\niceapps1yuc\\46\\2018\\"+month+"\\"+day+"\\SC_NiceSC2yuc",
        "\\\\172.18.25.243\\voip\\niceapps1din\\48\\2018\\"+month+"\\"+day+"\\SC_SC Dinamarca 1",
        "\\\\172.18.128.131\\RomaNortelVoIP\\niceapps1din\\48\\2018\\"+month+"\\"+day+"\\SC_SC Dinamarca 1",
        "\\\\172.18.128.131\\CobranzaWibe\\niceapps1din\\48\\2018\\"+month+"\\"+day+"\\SC_SC Dinamarca 1",
        "\\\\172.18.80.129\\nice\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC1SEV",
        "\\\\172.18.80.129\\nice\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC2SEV",
        "\\\\172.18.80.129\\dinamarca41\\niceapps1din\\48\\2018\\"+month+"\\"+day+"\\SC_SC Dinamarca 1",
        "\\\\172.18.104.167\\metlife\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC1SEV",
        "\\\\172.18.104.167\\metlife\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC2SEV",
        "\\\\172.18.128.212\\Amex\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC1SEV",
        "\\\\172.18.128.212\\Amex\\niceapps1sev\\46\\2018\\"+month+"\\"+day+"\\SC_NICESC2SEV"
        };
        return path;
    }
}
