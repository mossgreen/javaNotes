package datetime;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;

public class datetimeMain {

    private static final SimpleDateFormat sdfNew =
        new SimpleDateFormat("EEEE, MMM d, yyyy HH:mm:ss a");

    public static void main(String[] args) {

        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        Instant instant = Instant.now();
        LocalTime localTime = LocalTime.parse("08:30:15.12345");
        LocalDate localDate = LocalDate.of(2020, 06, 10);
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.UTC);

        //long
        java.util.Date date = sqlDate;

        date.toInstant().atOffset(ZoneOffset.UTC);

        //java.sql.date

        sqlDate = Date.valueOf(LocalDateTime.now().toLocalDate());
        date = java.sql.Date.valueOf(zonedDateTime.toLocalDate());
        date = java.sql.Date.valueOf(offsetDateTime.toLocalDate());

        localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        localDateTime.atOffset(ZoneOffset.UTC).toInstant();

        // instant
        instant.atZone(ZoneId.systemDefault()).toLocalDate();
        sqlDate.toInstant().atOffset(ZoneOffset.UTC);
        instant.atOffset(ZoneOffset.UTC);

        localDate.atStartOfDay().toLocalTime();
        sqlDate.toInstant().atZone(ZoneId.systemDefault());
        localDate.atStartOfDay(ZoneId.systemDefault());
        localDateTime.atZone(ZoneId.of("Europe/Rome"));

        localDate.atTime(OffsetTime.now(ZoneId.systemDefault()));
        localDateTime.atOffset(ZoneOffset.UTC);

        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        java.sql.Date sqlDate1 = new java.sql.Date(System.currentTimeMillis());

        timestamp1.

        localDateTime.toLocalDate();
        zonedDateTime.toLocalDate();
        offsetDateTime.toLocalDate();
        sqlDate.toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
        instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        instant.atOffset(ZoneOffset.UTC);
        offsetDateTime.atZoneSameInstant(ZoneId.of("Europe/Rome"));

        zonedDateTime.toLocalDateTime();
        offsetDateTime.toLocalDateTime();
        instant.atZone(ZoneId.of("Europe/Rome"));



        zonedDateTime.toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
        offsetDateTime.toInstant();
        instant.atZone(ZoneId.systemDefault()).toLocalDate();
        localDateTime.toLocalTime();
        zonedDateTime.toLocalTime();
        offsetDateTime.toLocalTime();
        final java.util.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Timestamp a = new Timestamp(1L);


    }
}
