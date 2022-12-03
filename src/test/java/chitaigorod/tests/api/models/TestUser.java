package chitaigorod.tests.api.models;

import chitaigorod.config.AppConfigReader;

import static chitaigorod.helpers.RandomUtils.getRandomSurname;
import static chitaigorod.helpers.RandomUtils.getRandomName;
import static chitaigorod.helpers.RandomUtils.getRandomSecondName;

public abstract class TestUser {

    public static User createRandomUser() {

        User user = new User();
        user.setSurname(getRandomSurname());
        user.setName(getRandomName());
        user.setSecondName(getRandomSecondName());
        user.setEmail(AppConfigReader.Instance.read().login());
        return user;
    }
}
