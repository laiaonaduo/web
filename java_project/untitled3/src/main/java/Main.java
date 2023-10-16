import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {



        WebDriver driver;
        //本地存放chrome浏览器插件的路径
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        //打开百度---调用driver.get()方法
        driver.get("http://www.baidu.com");
        //窗体最大化--默认是一半展现
        driver.manage().window().maximize();




    }
}