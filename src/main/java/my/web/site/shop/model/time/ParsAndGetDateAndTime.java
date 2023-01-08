package my.web.site.shop.model.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class ParsAndGetDateAndTime {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG,FormatStyle.MEDIUM);
    public static String get(LocalDateTime time) {
        return LocalDateTime.now().format(formatter);
    }
}
