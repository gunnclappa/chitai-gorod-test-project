package chitaigorod.tests.api.pages;

import chitaigorod.helpers.ParamsForAPI;
import chitaigorod.tests.api.models.User;

import java.util.HashMap;
import java.util.Map;

import static chitaigorod.tests.api.specs.Specification.requestSpec;
import static chitaigorod.tests.api.specs.Specification.responseSpec;
import static io.restassured.RestAssured.given;

public class PersonalPageAPI {

    public final PersonalPageAPI changePersonalData(final User user) {

        Map<String, String> paramsForChangePersonalData = ParamsForAPI.paramsForChangePersonalData(user);

        given()
                .spec(requestSpec())
                .formParams(paramsForChangePersonalData)
                .when()
                .post("/profile/personal/")
                .then()
                .statusCode(302);

        given()
                .spec(requestSpec())
                .when()
                .get("/profile/personal/")
                .then()
                .spec(responseSpec());

        return this;
    }

    public final Map<String, String> getPersonalData() {

        String surname = given()
                .spec(requestSpec())
                .when()
                .get("/profile/personal/")
                .htmlPath()
                .getString("**.find{it.@id == 'surname'}.@value");

        String name = given()
                .spec(requestSpec())
                .when()
                .get("/profile/personal/")
                .htmlPath()
                .getString("**.find{it.@id == 'name'}.@value");

        String secondName = given()
                .spec(requestSpec())
                .when()
                .get("/profile/personal/")
                .htmlPath()
                .getString("**.find{it.@id == 'second_name'}.@value");

        Map<String, String> userData = new HashMap<>();
        userData.put("surname", surname);
        userData.put("name", name);
        userData.put("secondName", secondName);

        return userData;
    }
}
