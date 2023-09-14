import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.WebDriverFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.time.Duration;

public class SomeTest {
    private WebDriver driver;
    private Logger log = LogManager.getLogger( SomeTest.class );


    private final String LOGIN = "kipohe9581@mahmul.com";
    // private final String LOGIN = Properties.getPropertyValue("login");
    private final String PASSWORD = "@WSX1qaz";

//    @Test
//        public void test() {
//            log.fatal("fatal");
//        }

    @BeforeAll
    public static void webDriverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {

        driver = new WebDriverFactory().createWebDriver( "chrome" );
        log.info( "Драйвер запущен" );
    }

    @AfterEach
    public void closeAll() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        log.info( "Драйвер закрыт" );
    }

    @Test
    public void Test1() {

        /*

Обязательное тестовое покрытие:

Проверка количества курсов в разделе тестирование:
1 Пользователь переходит в разделе тестирование
2 На странице отображаются карточки курсов. Количество карточек равно 11
Просмотр карточки курса:
1 Пользователь переходит на карточку курса
2 В карточке указана информация о курсе:
Название
Описание
Длительность обучения
Формат // Минимально достаточное - проверить одну карточку. В идеале все в разделе тестирования.
Валидация дат предстоящих мероприятий:
1 Пользователь переходит в раздел События -> Календарь мероприятий
2 На странице отображаются карточки предстоящих мероприятий.
3 Даты проведения мероприятий больше или равны текущей дате
Просмотр мероприятий по типу:
1 Пользователь переходит в раздел События -> Календарь мероприятий
2 Пользователь сортирует мероприятия по типу Открытые вебинары
3 На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно "Открытые вебинары"
*/


        //Открыть https://otus.ru
        driver.get( "https://otus.ru" );

        //Авторизоваться на сайте
        //auth();

        String actual = new MainPage( driver )
                .getCards()
                .get( 0 )
                .getCourseName();
       // String expected = "Системный аналитик и бизнес-аналитик";
       // Assertions.assertEquals( expected, actual );

        //System.out.println("Карточка: " +actual +"\n");

    }

    @Test
    public void Test2(){
        driver.get( "https://otus.ru" );
        new MainPage( driver ).menuClick( "Программирование" );

    }


    private void auth() {
        new WebDriverWait( driver, Duration.ofSeconds( 10 ) ).until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( ".sc-mrx253-0" ) ) );
        driver.findElement( By.cssSelector( ".sc-mrx253-0" ) ).click();
        //login
        driver.findElement( By.cssSelector( "#__PORTAL__ > div > div > div.sc-1alnis6-1.ejcuap > div.sc-1alnis6-4.iVBbVz > div > div.sc-10p60tv-1.eDzhKh > div.sc-10p60tv-2.bQGCmu > div > div.sc-19qj39o-0.iLmCeO > div > div.sc-rq8xzv-1.hGvqzc.sc-11ptd2v-1.liHMCp > div > input" ) ).sendKeys( LOGIN );
        //.sc-rq8xzv-4.dCdvLX
        //driver.findElement( By.cssSelector( ".sc-rq8xzv-4.dCdvLX" ) ).sendKeys( LOGIN );


        //password
        driver.findElement( By.cssSelector( "#__PORTAL__ > div > div > div.sc-1alnis6-1.ejcuap > div.sc-1alnis6-4.iVBbVz > div > div.sc-10p60tv-1.eDzhKh > div.sc-10p60tv-2.bQGCmu > div > div.sc-19qj39o-0.iLmCeO > div > div.sc-rq8xzv-1.hGvqzc.sc-11ptd2v-1-Component.ciraFX > div > input" ) ).sendKeys( PASSWORD );
        //sc-11ptd2v-1-Component
        // driver.findElement( By.className( "sc-11ptd2v-1-Component" ) ).sendKeys( PASSWORD );

        driver.findElement( By.cssSelector( "#__PORTAL__ > div > div > div.sc-1alnis6-1.ejcuap > div.sc-1alnis6-4.iVBbVz > div > div.sc-10p60tv-1.eDzhKh > div.sc-10p60tv-2.bQGCmu > div > button > div" ) ).click();
        new WebDriverWait( driver, Duration.ofSeconds( 5 ) ).until( ExpectedConditions.invisibilityOf( driver.findElement( By.cssSelector( "#__PORTAL__ > div" ) ) ) );

    }

    private void enterToLK() {
        driver.get( "https://otus.ru/lk/biography/personal/" );

        new WebDriverWait( driver, Duration.ofSeconds( 10 ) ).until( ExpectedConditions.visibilityOf( driver.findElement( By.cssSelector( "#id_lname" ) ) ) );

    }

    private void clearAndEnter(By by, String text) {
        driver.findElement( by ).clear();
        driver.findElement( by ).sendKeys( text );
    }

    private void assertThat(By by, String text) {
        Assertions.assertEquals( text, driver.findElement( by ).getAttribute( "value" ) );
    }

}