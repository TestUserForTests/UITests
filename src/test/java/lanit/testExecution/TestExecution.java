package lanit.testExecution;

import cucumber.api.java.ru.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class TestExecution {

    private static WebDriver driver;

    @Пусть("^инициализируется драйвер загрузки браузера до выполнения сценария$")
    public void driverInit() {
        System.setProperty("webdriver.chrome.driver", "C://Tools//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Когда("^загружается главная страница сайта \"Мои документы\"$")
    public void basePageLoading() {
        driver.navigate().to("https://мдм.моидокументы.рф");
        driver.findElement(By.xpath("//h1[contains(text(),'Новости')]"));
    }

    @То("^происходит переход в раздел \"Мониторинг показателей работы МФЦ\"$")
    public void navigateToMonitoring() {
        driver.findElement(By.xpath("//span[contains(text(),'Мониторинг показателей работы МФЦ')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'DTFC_ScrollWrapper')]"));
    }

    @И("^устанавливается уровень детализации \"Субъекты РФ\"$")
    public void setSubjectsRF() {
//        WebElement selectSubject = driver.findElement(By.xpath("//select[contains(@class,'select-aggregation-territory')]"));
//        Select select = new Select(selectSubject);
//        select.selectByVisibleText("Субъекты РФ");
//        driver.findElement(By.xpath("//span[contains(text(),'Субъекты РФ')]"));
        Actions actions = new Actions(driver);
        WebElement clickableDiv = driver.findElement(By.xpath("//div[contains(@class,'mdm-form')]/div[1]/div[2]/div[1]/div[3]"));
        actions.moveToElement(clickableDiv).click().sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
   }

    @Когда("^нажимается кнопка \"Применить\"$")
    public void pressApplyButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Применить')]")).click();
    }

    @То("^выводится таблица с данными$")
    public void loadDataTable() {
    }

    @И("^происходит проверка вывода текста \"Все МФЦ/ТОСП\" в колонке \"Филиалы МФЦ и ТОСП\"$")
    public void textVerification() {
        driver.findElement(By.xpath("//td[contains(text(),'Все МФЦ/ТОСП')]"));
    }
}