package tests;

import io.qameta.allure.util.PropertiesUtils;
import io.swagger.petstore.testing.BaseTest;
import io.swagger.petstore.testing.models.user.User;
import io.swagger.petstore.testing.steps.UserSteps;
import io.swagger.petstore.testing.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class SwaggerPetsUserTest extends BaseTest {

    private final UserSteps userSteps = new UserSteps();
    private final User user = TestDataGenerator.generateFullDataUser();
    private final User modifiedUser = user.toBuilder().firstName("Evlampii").build();

    @Test
    public void SwaggerPetsUserTest() {
        Properties properties = PropertiesUtils.loadAllureProperties();
        properties.getProperty("allure.results.directory", "target/allure-results");
        userSteps.createUserSuccessful(user)
                .putUserSuccessfully(modifiedUser)
                .getUserByName(modifiedUser.getUsername());
        userSteps.deleteUserByName(modifiedUser.getUsername());

    }

}