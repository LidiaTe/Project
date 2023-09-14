package pages;

import components.CourseCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    private List<WebElement> courses;
    private List<CourseCard> cards = new ArrayList<>();

    public MainPage(WebDriver driver) {
        super(driver);
        for(WebElement element : courses) {
            cards.add( new CourseCard( element ) );
           // System.out.println("Карточка: " +element +"\n");
        }
        url = "http://otus.ru";
    }

    public List<CourseCard> getCards(){
        return cards;
    }


}
