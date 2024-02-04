package task8;

import task8.entity.Person;
import static task8.MockConstants.*;

public class MockUtils {
    public static Person getPerson() {
        return builderPerson();
    }

    private static Person builderPerson() {
        return Person.builder()
                .adress(ADRESS)
                .age(AGE)
                .dateOfBirthday(DATE_OF_BIRTHDAY)
                .dateTimeCreate(DATE_TIME_CREATE)
                .letter(LETTER)
                .passport(PASSPORT)
                .salary(SALARY)
                .timeToLunch(TIME_TO_LUNCH)
                .build();
    }
}
