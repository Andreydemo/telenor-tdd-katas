package dk.telenor.tdd;


import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Greater {
    private static Supplier<LocalDateTime> dateTimeSupplier;

    public static Supplier<LocalDateTime> getDateTimeSupplier() {
        return dateTimeSupplier;
    }

    public static void setDateTimeSupplier(Supplier<LocalDateTime> dateTimeSupplier) {
        Greater.dateTimeSupplier = dateTimeSupplier;
    }

    public static String greet(String name) {
        String input = transformInput(name);
        int hour = dateTimeSupplier.get().getHour();
        if (isMorning(hour)) {
            return "Good morning " + input;
        } else if (isEvening(hour)) {
            return "Good evening " + input;
        } else {
            return "Good night " + input;
        }
    }

    private static boolean isEvening(int hour) {
        return hour >= 18 && hour < 22;
    }

    private static boolean isMorning(int hour) {
        return hour >= 6 && hour < 12;
    }

    private static String transformInput(String name) {
        String trimedName = name.trim();
        return trimedName.substring(0, 1).toUpperCase() + trimedName.substring(1);
    }


}
