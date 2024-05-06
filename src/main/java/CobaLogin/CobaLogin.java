package CobaLogin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CobaLogin {

    private String baseUri = "https://reqres.in";
    private String loginPath = "/api/login";

    private String loginRequestBody;
    private Response response;

    public CobaLogin(String email, String password){
        RestAssured.baseURI = baseUri;
        loginRequestBody = "{\"email\": \""+email+"\",\"password\": \""+password+"\"}";
    }

    public void loginUser(){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginRequestBody)
                .post(loginPath);
    }

    public int getStatusCode(){
        return response.getStatusCode();
    }

    public String getResponseBodyUsingKey(String key){
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString(key);
    }

    public String getResponseBody(){
        return response.getBody().asString();
    }

}
