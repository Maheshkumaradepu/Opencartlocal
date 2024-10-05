package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	Properties p;

	@BeforeClass(groups = { "sanity", "Regression", "Master", "Datadriven" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws IOException {

		// loading config file

		FileReader File = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(File);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setPlatform(Platform.WIN10);
			if (os.equalsIgnoreCase("Windows")) {
				cap.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			} else {
				System.out.println("No Matching OS");
				return;
			}
			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("INVALID BROWSER");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.143.24:4444"), cap);
		}
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("INVALID BROWSER");
				return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();

	}

	public String random_String() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	public String random_Number() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	public String random_Pswd() {
		String S1 = RandomStringUtils.randomAlphabetic(4);
		String S2 = RandomStringUtils.randomAlphanumeric(3);
		return S1 + "@" + S2;
	}

	public String get_username() {
		return p.getProperty("email");
	}

	public String get_Passsword() {
		return p.getProperty("password");
	}

	@AfterClass(groups = { "sanity", "Regression", "Master", "Datadriven" })
	public void teardown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshorts\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
