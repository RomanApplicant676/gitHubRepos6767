package io.swagger.petstore.testing.steps;

import io.restassured.response.Response;
import io.swagger.petstore.testing.controller.UserController;
import io.swagger.petstore.testing.models.user.User;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserSteps extends UserController {

    public UserSteps createUserSuccessful(User user) {
        Response response = postUser(user);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    public User getUserByName(String userName) {
        Response response = getUser(userName);
        assertStatusCode(HttpStatus.SC_OK, response);
        return response.as(User.class);
    }

    public UserSteps assertUserData(User expectedUser) {
        User user = getUserByName(expectedUser.getUsername());
        assertThat(user, equalTo(expectedUser));
        return this;
    }

    public UserSteps putUserSuccessfully(User user) {
        Response response = putUser(user, user.getUsername());
        assertStatusCode(HttpStatus.SC_OK, response);
        assertUserData(user);
        return this;
    }

    public UserSteps deleteUserByName(String userName) {
        Response response = deleteUser(userName);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    private void assertStatusCode(int ExpectedStatus, Response response) {
        assertThat(response.statusCode(), equalTo(ExpectedStatus));
    }
}
