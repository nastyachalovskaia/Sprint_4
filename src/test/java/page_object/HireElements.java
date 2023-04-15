package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HireElements {
    private final WebDriver driver;
    //дата доставки
    private final By dateOfDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле периода аренды
    private final By leasingPeriod = By.className("Dropdown-control");
    //выбор количества суток
    private final By countOfDays = By.xpath(".//*[(@role ='option' and text()='двое суток')]");
    //цвета самоката
    private final By colours = By.xpath(".//input[@id='black']");
    //локатор для коммента
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки согласия
    private final By acceptButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //локатор кнопки заказа
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор кнопки просмотра статуса заказа
    private final By status = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public HireElements(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOrderDate(String orderDate){
        driver.findElement(dateOfDelivery).sendKeys(orderDate);
        driver.findElement(dateOfDelivery).sendKeys(Keys.ENTER);
    }
    //метод для ввода длительности аренды
    public void enterLeasingPeriod(){
        driver.findElement(leasingPeriod).click();
        driver.findElement(countOfDays).click();
    }
    //метод для выбора цвета самоката
    public void clickOnColour(){
        driver.findElement(colours).click();
    }
    //метод для ввода комментария
    public void enterComment(String comment){
        driver.findElement(this.comment).sendKeys(comment);
    }
    //метод для принятия заказа
    public void clickOnAcceptButton(){
        driver.findElement(acceptButton).click();
    }
    //метод для подтверждения заказа
    public void approveOrderButton(){
        driver.findElement(orderButton).click();
    }
    //метод для проверки появления модального окна
    public  boolean isModalWindowEnabled() {
        return driver.findElement(status).isEnabled();
    }
    //создание заказа
    public void acceptOrder(String orderDate, String comment){
        enterOrderDate(orderDate);
        enterLeasingPeriod();
        clickOnColour();
        enterComment(comment);
        approveOrderButton();
        clickOnAcceptButton();
    }
}
