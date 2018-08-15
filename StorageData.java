import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

class StorageData {
    private String path;
    private int count;

    public StorageData(String path, int count) {
        this.path = path;
        this.count = count;
    }

    /*
        public String getPath() {
            return path;
        }

        public int getCount() {
            return count;
        }
    */
    private void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("{\"path\":");
        strBuilder.append("\"" + path + "\",");

        strBuilder.append("\"count\":");
        strBuilder.append(count + "}");

        return strBuilder.toString();
    }

    public static ArrayList<StorageData> getStorageSet(String[] paths) {
        ArrayList<StorageData> dataList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE) - 1;
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String p;


        for (String s : paths) {
            p = s + "\\" + year + "\\" + month + "\\" + day;
            dataList.add(new StorageData(
                    p,
                    getPathCount(p)));
        }

        return dataList;
    }

    private static int getPathCount(String path) {
        String[] rootContents = Directory.getDirContents(path);
        int total = 0;

        for (String dirLevel1 : rootContents) {
            int lineCount = 0;
            String[] subDirs = Directory.getDirContents(path + "\\" + dirLevel1);

            for (String dirLevel2 : subDirs) {
                lineCount = Directory.getDirContents(path + "\\" + dirLevel1 + "\\" + dirLevel2)
                        .length;

                total += lineCount;
            }
        }

        return total;
    }
}
