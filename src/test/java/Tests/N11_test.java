package Tests;

import org.asynchttpclient.ClientStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N11_test {
    //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
    //seçilir.
    //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
    //txt dosyasına yazdırılır.


    @Test
    public void test01() throws IOException {
        File aIleBaslayan = new File("/Users/alice/Desktop/n11.txt");
        FileWriter fis=new FileWriter(aIleBaslayan);
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
        Driver.getDriver().findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//span[@title='Mağazalar']")).click();
        Driver.getDriver().findElement(By.xpath("//a[@title='Mağazaları Gör']")).click();
        Driver.getDriver().findElement(By.xpath("//h3[.='Tüm Mağazalar']")).click();
        List<WebElement> aharflidukkan=new ArrayList<>(Driver.getDriver().findElements(By.xpath("(//div[@class='sellerListHolder'])[4]")));

        for (WebElement each:aharflidukkan
             ) {

            fis.write(each.getText());
            fis.write("\n");
        }
        fis.close();

        Driver.closeDriver();

    }
}
