import com.nespresso.base.BaseTest;
import com.nespresso.pages.HomepageObject;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class OpenHomepageTest extends BaseTest{
    @Test
    public void openHomepage() throws InterruptedException {
        // Open nespresso homepage

        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        System.out.println("Nespresso homepage opened.\nTest passed !");
    }
}
