package driver;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utilities.ConfigurationReader;

public class BaseTest {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("baseURI");
        RestAssured.basePath = ConfigurationReader.getProperty("basePath");
    }
}
