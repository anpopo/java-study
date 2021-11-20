package javas.study.inflearn.java8.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeApiApp {

    public static void main(String[] args) {
        Instant instant = Instant.now();

        Instant instant1 = Instant.ofEpochMilli(1312344123);

        System.out.println("instant = " + instant);  // 기준시 UTC(GMT)
        System.out.println("instant1 = " + instant1);

        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zone);

        System.out.println(zone);
        System.out.println(zonedDateTime);

        System.out.println("==================================================");

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        Instant now1 = Instant.now();

        ZonedDateTime zonedDateTime2 = now1.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime2);

        System.out.println("==================================================");


        LocalDate today = LocalDate.now();

        LocalDate thisYearBirthDay = LocalDate.of(2022, Month.JANUARY, 8);

        Period period = Period.between(today, thisYearBirthDay);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS));
        System.out.println("==================================================");

        Instant now2 = Instant.now();
        Instant now3 = now2.plus(10, ChronoUnit.SECONDS);


        Duration between = Duration.between(now2, now3);
        System.out.println(between.getSeconds());

        System.out.println("==================================================");


        LocalDateTime now4 = LocalDateTime.now();
        System.out.println(now4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate date = LocalDate.parse("07/15/1982", formatter);

        System.out.println(date);
        System.out.println(today.format(formatter));

        System.out.println("==================================================");

        Date date1 = new Date();

        Instant instant2 = date1.toInstant();

        Date newDate = Date.from(instant2);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.of("Asia/Seoul"));

        System.out.println(dateTime);

        LocalDateTime localDateTime = dateTime.toLocalDateTime();
        System.out.println(localDateTime);


        ZoneId newZone = TimeZone.getTimeZone("PST").toZoneId();

        TimeZone oldZone = TimeZone.getTimeZone(newZone);

        Instant newInstant = new Date().toInstant();

        Date oldInstant = Date.from(newInstant);

        System.out.println("newZone = " + newZone);
        System.out.println("oldZone = " + oldZone);
        System.out.println("newInstant = " + newInstant);
        System.out.println("oldInstant = " + oldInstant);


    }
}
