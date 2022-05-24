package SeleniumHW2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Task1 {
    @Test(invocationCount = 1)
    public void urlValidation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void validationDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();




        List<WebElement> allbrands = driver.findElements(By.xpath("//select/option[2]"));
        List<String> actualBrand = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();

        for(int i = allbrands.size()-1;i>=1;i--){
            actualBrand.add(allbrands.get(i).getText().toLowerCase());
            expectedBrands.add(allbrands.get(i).getText().toLowerCase());
            Collections.sort(expectedBrands, Collections.reverseOrder());
            Assert.assertEquals(actualBrand,expectedBrands);
        }
        System.out.println(actualBrand);
        System.out.println(expectedBrands);




    }
    @Test
    public void displayedLowHighPrice() throws InterruptedException{


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        WebElement dropdown= driver.findElement(By.xpath("//span[@class='active_option']"));
        dropdown.isSelected();
        WebElement selectButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selectButton);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> actualPrices= new ArrayList<>();
        List<Double> expectedPrices = new ArrayList<>();

        for (int i = 0; i < allPrices.size(); i++) {

            actualPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","").trim()));
            expectedPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","").trim()));
            Collections.sort(expectedPrices);
            boolean itemsDisplayed  = allPrices.get(i).isDisplayed();
            Assert.assertEquals(actualPrices,expectedPrices);
            Assert.assertEquals(itemsDisplayed,true);

        }

        System.out.println(actualPrices);
        System.out.println(expectedPrices);



    }
    @Test
    public void TestCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        WebElement dropdown = driver.findElement(By.xpath("//span[@class='active_option']"));
        dropdown.isSelected();
        Thread.sleep(3000);
        WebElement selectButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selectButton);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> actualPrices= new ArrayList<>();
        List<Double> expectedPrices = new ArrayList<>();

        for (int i = 0; i < allPrices.size(); i+=3) {
            Thread.sleep(3000);
            actualPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","").trim()));
            expectedPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","").trim()));
            Collections.sort(expectedPrices);
            Thread.sleep(3000);
            boolean itemsDisplayed  = allPrices.get(i).isDisplayed();
            Assert.assertEquals(actualPrices,expectedPrices);
            Assert.assertEquals(itemsDisplayed,true);

        }

        System.out.println(actualPrices);
        System.out.println(expectedPrices);

    }
    @Test
    public void TestCaseTask4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        WebElement selectButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selectButton);
        select.selectByVisibleText("Price (high to low)");
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> actualPrices = new ArrayList<>();
        List<Double> expectedPrices = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i+=3) {
            Thread.sleep(3000);
            actualPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$", "").trim()));
            expectedPrices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$", "").trim()));
            Thread.sleep(3000);
            boolean itemsDisplayed = allPrices.get(i).isDisplayed();
            Assert.assertEquals(actualPrices, expectedPrices);
            Assert.assertEquals(itemsDisplayed, true);
        }
        System.out.println(actualPrices+"task 4");
        System.out.println(expectedPrices+"task 4");
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Thread.sleep(500);
        cart.click();
        WebElement checkOut = driver.findElement(By.xpath("//button]@id='checkout']"));
        checkOut.click();


    }
}