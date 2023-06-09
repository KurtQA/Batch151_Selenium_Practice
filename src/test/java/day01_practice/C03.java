package day01_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe"); //Set Driver Path
        WebDriver driver = new ChromeDriver(); //Create chrome driver object
        driver.manage().window().maximize(); //maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Wait for 15 seconds

        //Go to the "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");

        //Get the title and URL of the page
        String techproTitle=driver.getTitle();
        String techproUrl=driver.getCurrentUrl();
        System.out.println("techproTitle: " +techproTitle);
        System.out.println("techproUrl: "+techproUrl);

        //Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title
        //does not contains Bootcamps"

        if (techproTitle.contains("Bootcamps")){
            System.out.println("Title contains Bootcamps");
        }else System.out.println("Title does not contains Bootcamps");


        //check if the Url contains the word "Courses" print console "URL contains Courses" or "URL does not contain Courses"

        if (techproUrl.contains("Courses")){
            System.out.println("Url contains Courses");
        }else System.out.println("Url does not contains Courses");

        //Then go to "https://medunna.com/"
        driver.get("https://medunna.com/");

        //Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contains MEDUNNA"
        String medunnaTitle=driver.getTitle();
        if (medunnaTitle.contains("Bootcamps")){
            System.out.println("Title contains MEDUNNA");
        }else System.out.println("Title does not contains MEDUNNA");


        //Navigate Back to the previous webpage
        Thread.sleep(3000);
        driver.navigate().back();

        //Refresh the page
        Thread.sleep(3000);
        driver.navigate().refresh();

        //Navigate to forward
        driver.navigate().forward();

        //Wait for 3 seconds
        Thread.sleep(3000);

        //Close the browser
        driver.close();

        //techproTitle: Techpro Education | Online It Courses & Bootcamps
        //techproUrl: https://techproeducation.com/
        //Title contains Bootcamps
        //Url does not contains Courses
        //Title does not contains MEDUNNA







    }
}
