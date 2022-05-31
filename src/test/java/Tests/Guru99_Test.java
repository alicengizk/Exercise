package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Guru99_Test {
    //http://demo.guru99.com/test/drag_drop.html url e git
    //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    //    Perfect butonun goruntulendigini dogrulayin


    @Test
    public void test01() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement bankButonu=Driver.getDriver().findElement(By.xpath("//li[@data-id='5']"));
        WebElement debitSideAccount=Driver.getDriver().findElement(By.xpath("(//div[@class='ui-widget-content'])[2]"));
        actions.dragAndDrop(bankButonu,debitSideAccount).perform();
        Thread.sleep(2000);
        WebElement salesButonu=Driver.getDriver().findElement(By.xpath("//li[@data-id='6']"));
        WebElement creditSideAccount=Driver.getDriver().findElement(By.xpath("(//div[@class='ui-widget-content'])[4]"));
        actions.dragAndDrop(salesButonu,creditSideAccount).perform();
        Thread.sleep(2000);
        WebElement besBinButonu=Driver.getDriver().findElement(By.xpath("//li[@data-id='2']"));
        WebElement debitSideAmount=Driver.getDriver().findElement(By.xpath("(//div[@class='ui-widget-content'])[3]"));
        actions.dragAndDrop(besBinButonu,debitSideAmount).perform();
        Thread.sleep(2000);
        WebElement ikinciBesBin=Driver.getDriver().findElement(By.xpath("(//li[@data-id='2'])[2]"));
        WebElement creditSideAmount=Driver.getDriver().findElement(By.xpath("(//div[@class='ui-widget-content'])[5]"));
        actions.dragAndDrop(ikinciBesBin,creditSideAmount).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("equal")).isDisplayed();
        Driver.closeDriver();




    }
}
