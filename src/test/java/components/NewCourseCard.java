package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class NewCourseCard  {
    private WebElement card;

    public NewCourseCard(WebElement element){
        card = element;
    }

    public String getCardName() {
        return card.findElement( By.cssSelector( "h6" )).getText();
    }

    public void click() {
        card.click();
    }

    public String getCardDate(){
        return card.findElement( By.cssSelector( ".sc-hrqzy3-1" ) ).getText().split( "." )[0];
    }

    public String getDuration(){
        return card.findElement( By.cssSelector( ".sc-hrqzy3-1" ) ).getText().split( "." )[1];
    }
}
