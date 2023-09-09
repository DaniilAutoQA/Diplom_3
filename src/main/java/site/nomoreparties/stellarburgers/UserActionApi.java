package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserActionApi {

    @Step("User creation from API")
    public static Response createUser(User user) {
        Response response =   given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
        return response;
    }

    @Step("User login from API")
    public static Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/login");
    }

    @Step("User deletion from API")
    public static Response deleteUser(String token) {
        return given()
                .auth().oauth2(token)
                .delete("/api/auth/user");
    }

    @Step("Getting accessToken user from API")
    public static String getAccessTokenUser(User user) {
        return loginUser(user)
                .then().extract().body().path("accessToken").toString().substring(7);
    }

}
