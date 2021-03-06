package Tests;

import Pages.AmazonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Amazon_Test {
    //Notes: It may also be necessary to write code to accept the accept cookies warning.
    //1. Go to 'https://www.amazon.com.tr/'
    //2. Search iPhone13 512
    //3. Check that the results are listed
    //4. Click iPhone13 at the top of the list
    //5. Log the following values for each size
    //.Size information .Price .Color .Stock status

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("iphone 13 512"+ Keys.ENTER);
        amazonPage.amazonCerez.click();
        String actualResult=amazonPage.aramaSonucElementi.getText();
        String expectedResult="iphone 13 512";
        Assert.assertTrue(actualResult.contains(expectedResult));
        amazonPage.amazonSonucIlkResim.click();
        System.out.println(Driver.getDriver().findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());
        //Driver.getDriver().findElement(By.xpath("(//input[@name='2'])[2]")).click();
        System.out.println(Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-none a-padding-none inline-twister-dim-title-value-truncate-expanded'])[1]")).getText());
        //Driver.getDriver().findElement(By.xpath("//input[@name='5']")).click();
        System.out.println(Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-none a-padding-none inline-twister-dim-title-value-truncate-expanded'])[2]")).getText());
        System.out.println(Driver.getDriver().findElement(By.id("availability")).getText());




    }
}
