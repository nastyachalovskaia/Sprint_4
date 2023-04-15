import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page_object.ElementsOfTheMainPage;
import page_object.HireElements;
import page_object.OrderPageElements;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class UserInfoTest extends GeneralElementsTest {

    private final String userName;
    private final String userLastName;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String orderDate;
    private final String comment;


    public UserInfoTest(WebDriver driver,  String userName, String userLastName, String userAddress, String userPhoneNumber, String orderDate, String comment) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.orderDate = orderDate;
        this.comment = comment;
        this.driver = driver;
    }

    @Parameterized.Parameters
    public static Object[][] getInfo() {
        return new Object[][]{
                {"Галина", "Теренькина", "Москва", "89999999999", "22.03.2023", "А успею ли я в Сызрань?"},
                {"Имечко", "Фамилькин", "Московская область", "89777777777", "01.04.2023", "Захвати пиццу!"}
        };
    }

    @Test
    public void testCreateNewOrderWithHeaderButton(){
        ElementsOfTheMainPage elements = new ElementsOfTheMainPage(driver);
        OrderPageElements pageElements = new OrderPageElements(driver);
        HireElements hireElements = new HireElements(driver);

        elements.scrollToClickHeaderOrderButton();
        elements.clickHeaderOrderButton();
        pageElements.createOrder(userName,userLastName, userAddress,userPhoneNumber);
        hireElements.acceptOrder(orderDate,comment);
        assertTrue(hireElements.isModalWindowEnabled());
    }
    @Test
    public void testCreateNewUserOrderWithFooterButton(){
        ElementsOfTheMainPage elements = new ElementsOfTheMainPage(driver);
        OrderPageElements pageElements = new OrderPageElements(driver);
        HireElements hireElements = new HireElements(driver);

        elements.scrollToClickFooterOrderButton();
        elements.clickFooterOrderButton();
        pageElements.createOrder(userName,userLastName, userAddress,userPhoneNumber);
        hireElements.acceptOrder(orderDate,comment);
        assertTrue(hireElements.isModalWindowEnabled());
    }

}
