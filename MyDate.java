import java.util.Calendar;
import java.util.TimeZone;

class MyDate {
    private int day,
        month, year;

    MyDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        day = calendar.get(Calendar.DATE) - 1;
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
    }

    String GetDate() {
        return year + "\\" + month + "\\" + day;
    }
}
