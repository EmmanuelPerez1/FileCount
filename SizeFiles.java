import java.util.ArrayList;

public class SizeFiles {
    public static void main(String[] args) {
        String path = "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48";
        ArrayList<StorageData> arrg = StorageData.getStorageSet(new String[]{path});

        for (StorageData sd : arrg)
            System.out.println(sd.toString());
        /*for (int i = 0; i <= GetDir().length - 1; i++) {
            System.out.print("De la siguiente ruta: " + GetDir()[i] + " hay este número de grabaciones:  " + GetCount(GetDir()[i]) + "\n");
            //StorageData sd = new StorageData();
*/
    }
}


