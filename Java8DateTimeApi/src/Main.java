import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calendar c = Calendar.getInstance();
        long longValue = c.getTimeInMillis();
        System.out.println(longValue);
    }
}
