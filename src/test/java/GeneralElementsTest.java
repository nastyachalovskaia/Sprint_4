import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.YandexScooterUrl;

public class GeneralElementsTest {
    protected WebDriver driver;
    private final By acceptCookieButton = By.id("rcc-confirm-button");

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(YandexScooterUrl.YANDEX_SCOOTER_URL);
        driver.findElement(acceptCookieButton).click();
    }

    // Закрываем браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}
