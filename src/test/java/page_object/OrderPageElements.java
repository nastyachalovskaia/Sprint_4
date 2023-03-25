package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageElements {
    private final WebDriver driver;

    public OrderPageElements(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для ввода имени
    private final By enterUserName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор для ввода фамилии
    private final By enterUserLastName = By.xpath(".//input[(@placeholder='* Фамилия')]");
    //локатор для ввода адреса доставки
    private final By enterUserAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для ввода станции метро
    private final By enterMetroStation = By.xpath(".//*[(@class='select-search__input' and @placeholder='* Станция метро')]");
    //локатор для выбора станции метро
    private final By chooseMetroStation = By.xpath(".//*[@class='Order_SelectOption__82bhS select-search__option' and @value='2']");
    //локатор для ввода номера телефона
    private final By enterUserPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки "Далее"
    private final By clickNextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // метод для ввода имени
    public void enterUserName(String userFirstName){
        driver.findElement(enterUserName).sendKeys(userFirstName);
    }
    // метод для ввода фамилии
    public void enterUserLastName(String userLastName){
        driver.findElement(enterUserLastName).sendKeys(userLastName);
    }
    // метод для ввода адреса
    public void inputUserAddress(String userAddress){
        driver.findElement(enterUserAddress).sendKeys(userAddress);
    }
    // метод для ввода метро
    public void SelectMetroStation(){
        driver.findElement(enterMetroStation).click();
        driver.findElement(chooseMetroStation).click();
    }
    //метод для ввода мобильного телефона пользователя
    public void inputUserPhoneNumber(String userPhoneNumber){
        driver.findElement(enterUserPhoneNumber).sendKeys(userPhoneNumber);
    }
    // метод для нажатия на кнопку "Далее"
    public void pushNextButton(){
        driver.findElement(clickNextButton).click();
    }
    // метод для создания заказа
    public void createOrder(String userFirstName, String userLastName, String userAddress, String userPhoneNumber){
        enterUserName(userFirstName);
        enterUserLastName(userLastName);
        inputUserAddress(userAddress);
        SelectMetroStation();
        inputUserPhoneNumber(userPhoneNumber);
        pushNextButton();
    }

}
