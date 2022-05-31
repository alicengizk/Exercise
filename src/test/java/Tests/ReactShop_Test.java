package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;

public class ReactShop_Test {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
    // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    // (Her ürün 1 defadan fazla eklenemez!)
    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    // 7.Checkout'a tıklayın


    @Test
    public void test01() {
        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
        ArrayList<WebElement> tumUrunuler=new ArrayList<>(Driver.getDriver().findElements(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']")));
        int sira=1;
        for (WebElement each:tumUrunuler
             ) {

            System.out.println(sira+". urun : "+each.getText());
            sira++;
        }


    }
}
