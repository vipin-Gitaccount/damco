package tests;

import invoker.DriverInvoker;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MMT {
    public static WebDriver driver = DriverInvoker.getDriver();

    @Test(priority  =0)
    public void makeMyTrip() {
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/flights");
        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Delhi" + Keys.TAB);
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai" + Keys.ARROW_DOWN + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@aria-selected='true']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OKAY, GOT IT!')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
        try {
            List<WebElement> priceList = driver
                    .findElements(By.xpath("//*[@class='priceSection']//div[@class='textRight flexOne']/p"));
            Set<Integer> Price = new TreeSet<Integer>();
            List<String> price = new ArrayList<String>();
            for (WebElement e : priceList) {
                Price.add(Integer.parseInt(e.getText().replaceAll("[^0-9]", "")));
                price.add(e.getText());
            }
            int temp = (Integer) (Price.toArray())[1];
            String secLowestPrice = "";
            for (String e : price) {
                if (temp == Integer.parseInt(e.replaceAll("[^0-9]", ""))) {
                    secLowestPrice = e.substring(2);
                    break;
                }
            }
            System.out.println("second lowest, " + secLowestPrice);


            String filghtName = driver.findElement(By.xpath(
                    "//*[contains(text(),'" + secLowestPrice + "')]/ancestor::div[@class='listingCard']//p[@class='boldFont blackText airlineName']")).getText();


            System.out.println("This " + filghtName + " has 2nd lowest price of ‚ " + secLowestPrice);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        driver.close();
    }


}
