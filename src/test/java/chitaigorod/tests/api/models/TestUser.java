package chitaigorod.tests.api.models;

import static chitaigorod.helpers.RandomUtils.*;

public abstract class TestUser {

    public static User createUser1() {

        User user1 = new User();
        user1.setSurname(getRandomSurname());
        user1.setName(getRandomName());
        user1.setSecondName(getRandomSecondName());
        user1.setEmail("pesprizrak21@mail.ru");
        return user1;
    }

    public static User createUser2() {

        User user2 = new User();
        user2.setSurname(getRandomSurname());
        user2.setName(getRandomName());
        user2.setSecondName(getRandomSecondName());
        user2.setEmail("pesprizrak21@mail.ru");
        return user2;
    }

    public static User createUser3() {

        User user3 = new User();
        user3.setSurname(getRandomSurname());
        user3.setName(getRandomName());
        user3.setSecondName(getRandomSecondName());
        user3.setEmail("pesprizrak21@mail.ru");
        return user3;
    }
}
