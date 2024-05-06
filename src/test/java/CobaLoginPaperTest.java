import CobaLogin.CobaLoginPaper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CobaLoginPaperTest {
    @Test
    public void CreatingRequestLoginPaperTest(){
        String email = "kandidat@paper.id";
        String password = "paper.id";
        CobaLoginPaper cobaLoginPaper = new CobaLoginPaper(email, password);
        cobaLoginPaper.loginPaperUser();
        System.out.println("\n Status Code: " +cobaLoginPaper.getStatusCodePaper());
        System.out.println("---> Response JSON Body: " + cobaLoginPaper.getResponseBodyPaper());
        Assert.assertEquals(cobaLoginPaper.getStatusCodePaper(), 200);

    }
}
