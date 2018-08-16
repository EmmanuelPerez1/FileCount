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

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append('{');
        strBuilder.append("\"path\":");
        strBuilder.append("\"" + path + "\",");

        strBuilder.append("\"count\":");
        strBuilder.append(count);
        strBuilder.append('}');

        return strBuilder.toString();
    }

    public static StorageData[] get(String[] paths) {
        ArrayList<StorageData> dataList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE) - 1;
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String tmpPath;

        for (String path : paths) {
            tmpPath = path + "\\" + Integer.toString(year) + "\\" +
                    Integer.toString(month) + "\\" + Integer.toString(day);

            dataList.add(new StorageData(tmpPath,
                    childrenCount(tmpPath)));
        }

        return dataList.toArray(new StorageData[]{});
    }

    private static int childrenCount(String path) {
        String[] rootContents = FileSystem.getChildren(path);
        int total = 0;

        for (String dirLevel1 : rootContents) {
            int lineCount = 0;
            String[] subDirs = FileSystem.getChildren(path + "\\" + dirLevel1);

            for (String dirLevel2 : subDirs) {
                lineCount = FileSystem.getChildren(path + "\\" + dirLevel1 + "\\" + dirLevel2)
                        .length;

                total += lineCount;
            }
        }

        return total;
    }
}
