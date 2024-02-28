package task8;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MockConstants {
    private MockConstants() {
    }
    public static final String ADRESS = "pr Partizanskiy";
    public static final int AGE = (int)(Math.random()*10+20);
    public static final Date DATE_OF_BIRTHDAY = Date.valueOf("2004-04-04");
    public static final Timestamp DATE_TIME_CREATE = Timestamp.valueOf("2020-12-12 12:12:12");
    public static final String LETTER = "letter";
    public static final String PASSPORT = "Passport";
    public static final float SALARY = 13123f;
    public static final Time TIME_TO_LUNCH = Time.valueOf("15:15:15");
}
