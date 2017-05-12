import com.nespresso.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class SecondTest extends BaseTest{
    @Test
    public void secondTestMethod(){
        // Open linkedin.com

        driver.get("https://www.linkedin.com");
        System.out.println("LinkedIn opened. Test passed");

    }
}
