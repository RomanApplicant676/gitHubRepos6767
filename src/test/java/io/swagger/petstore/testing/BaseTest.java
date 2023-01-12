package io.swagger.petstore.testing;

import org.junit.jupiter.api.BeforeAll;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Config config = ConfigFactory.load();
        RestAssured.baseURI = config.getString("base.uri");
        RestAssured.basePath = config.getString("base.path");
        RestAssured.defaultParser = Parser.JSON;
    }
}
