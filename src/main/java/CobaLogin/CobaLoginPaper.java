package CobaLogin;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CobaLoginPaper {
    private String paperLoginbaseUri = "https://www.paper.id";
    private String loginPaperPath = "/webappv1/#/login";
    private String loginPaperRequestBody;
    private Response responsePaper;

    public CobaLoginPaper(String email, String password){
        RestAssured.baseURI = paperLoginbaseUri;
        loginPaperRequestBody = "{\"email\": \""+email+"\",\"password\": \""+password+"\"}";
    }

    public void loginPaperUser(){
        responsePaper = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginPaperRequestBody)
                .post(loginPaperPath);
    }
    public int getStatusCodePaper(){
        return responsePaper.getStatusCode();
    }
    public String getResponseBodyPaper(){
        return responsePaper.getBody().asString();
    }


}
