package homework12;

public enum DayOfWeek {
    MONDAY("ПОНЕДЕЛЬНИК"), TUESDAY("ВТОРНИК"), WEDNESDAY("СРЕДА"),
    THURSDAY("ЧЕТВЕРГ"), FRIDAY("ПЯТНИЦА") ,SATURDAY("СУББОТА"), SANDAY("ВОСКРЕСЕНЬЕ");
    private String day;
    private DayOfWeek(String day) {
        this.day = day;
    }
    public String getDay() {
        return day;
    }
}
