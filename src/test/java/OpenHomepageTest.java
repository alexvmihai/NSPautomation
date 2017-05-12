import com.nespresso.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class OpenHomepageTest extends BaseTest{

    @Test
    public void openHomepage(){
        // Open dice.com

        driver.get("https://www-pprd-ru.nespresso.com/ru/en");
        System.out.println("Nespresso homepage opened.\nTest passed !");

    }
}
