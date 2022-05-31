package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Sauce_Demo_Test {
    //1. "https://www.saucedemo.com" Adresine gidin
    //2. Username kutusuna "standard_user" yazdirin
    //3. Password kutusuna "secret_sauce" yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin


    @Test
    public void test01() {
        Driver.getDriver().get("https://www.saucedemo.com");
        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.id("login-button")).click();
        String ilkUrunAdi = Driver.getDriver().findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
        Driver.getDriver().findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
        Driver.getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Driver.getDriver().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String eklenenUrun = Driver.getDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(ilkUrunAdi, eklenenUrun);
        Driver.closeDriver();


    }
}
