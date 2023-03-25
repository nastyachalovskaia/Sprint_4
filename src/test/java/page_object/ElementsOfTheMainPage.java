package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class ElementsOfTheMainPage {
    private static WebDriver driver;
    // кнопка "Заказать" сверху
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    // кнопка "Заказать" снизу
    private final By footerOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Локаторы кнопок с вопросами
    public static final String[] buttonsQuestionArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    //Локаторы текстов вопросов о важном
    public static final String[] questionsAboutImportantStringArr = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};


    // кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");

    public ElementsOfTheMainPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка для нажатия на верхнюю кнопку заказа

    public void clickHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    // метод для пролистывания до нижней кнопки заказа
    public void scrollToClickHeaderOrderButton(){
        WebElement element = driver.findElement(headerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToClickFooterOrderButton(){
        WebElement element = driver.findElement(footerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод для нажатия нижней кнопки заказа
    public void clickFooterOrderButton(){
        driver.findElement(footerOrderButton).click();
    }

    //метод для пролистывания до списка с вопросами о важном
    public void scrollPageToQuestionsAboutImportant(){
        WebElement lastQuestionArrow = driver.findElement(By.id(buttonsQuestionArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }
    // клик по стрелке элемента списка с вопросами
    public static void clickOnArrowOnQuestionsAboutImportant(int questionNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(buttonsQuestionArray[questionNumber])));
        driver.findElement(By.id(buttonsQuestionArray[questionNumber])).click();
    }
    //проверка текста y кнопок списка с вопросами
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(questionsAboutImportantStringArr[answerNumber])));
        String answerText = driver.findElement(By.id(questionsAboutImportantStringArr[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    //Клик по кнопке вопроса
    public void clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
    }

}
