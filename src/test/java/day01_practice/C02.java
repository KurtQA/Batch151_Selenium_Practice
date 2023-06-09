package day01_practice;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class C02 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");




        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);




        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin.

        //nutella iceren kodu calistirinca sayfada sol ust tarafta Customer Service ve yaninda Registry butonlari goruldu.
        //Her iki butonun locate'lerini almaliyiz. Bunlari ayri ayri alabiliriz ya da birlikte alabiliriz.Once Customer Service locate'ini aldik ve alt cubukta sonuc 1 of 12. Tek tek tiklayinca
        //5. sirada Today's Deals basligi secili iken 6. tiklamada yandaki customer service'in secili oldugunu goruldu yani 6. indexte oldugunu gorduk. indexi 6 olarak alinca alt cubukta
        //1 of 1 oldu. Yani unique olani elde ettik. Ikinci locate alma islemi Registery icin olacak. onun uzerinden inspect yapip HTML kodlarina baktik. Locate'i Customer Service locate'i ile or
        // | isaretini kullanarak ayni sirada yazdik. Ikinci locate sonucu 12 olsa da basa ve sona parantez koyup ayrica 7. indexte oldugunu anladigimiz icin 7. index'i [] icine yazinca sonuc 1 of 1
        //oldu. Boylece iki elementin tek seferde ayni sirada locate'leri alindi.Birden fazla webelements oldugu icin findelements yazdik. Burada birden fazla webelement oldugu icin bir liste
        //assign ettik. List'in data turu WEbElement. Artik aldigimiz locate'ler bu list icinde ve list icinde islem yapilacagindan, sirasiyla bakilacagindan for loop kullanmaya karar verdik.
        //Butonlar listesinde 2 webelement oldugundan for loop icinde i<2 ile bir limit koyduk.


        for (int i = 0; i <2 ; i++) {

            List<WebElement> butonlar = driver.findElements(By.xpath("(//a[@tabindex='0'])[6] | (//a[@tabindex='0'])[7]"));
            butonlar.get(i).click(); //ilk butona yani Customer Service'e tiklayacak. butonlar listesindeki i.nci indexteki butonu al ve tikla.
            //if blogu title'in amazon icerip icermedigini test etmek icin kullandik

            if(driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon Iceriyor");
            }

            driver.navigate().back(); //Bir butona tiklamis oldugumuz icin geri gelmemiz ve bir sonrakine tiklamamiz gerekli. Bu nedenle navigate().back(); yaptik.
        }




        // pencereyi kapatiniz
        driver.close();











    }





}