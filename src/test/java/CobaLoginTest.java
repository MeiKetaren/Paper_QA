import CobaLogin.CobaLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CobaLoginTest {
    @Test
    public void CreatingRequestLoginTest(){
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";
        CobaLogin cobaLogin = new CobaLogin(email,password);
        cobaLogin.loginUser();
        System.out.println("\n Status Code: " + cobaLogin.getStatusCode());
        System.out.println("---> Response JSON Body: " + cobaLogin.getResponseBody());
        Assert.assertEquals(cobaLogin.getStatusCode(),200);
        Assert.assertEquals(cobaLogin.getResponseBodyUsingKey("token"),"QpwL5tke4Pnpja7X4");
    }
}
