package base;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.module.Configuration;
import java.util.logging.Logger;

@UtilityClass
public class DriverManagerHelper {

    //https://github.com/nelson-q/SelenideExample/blob/main/src/main/java/config/Browser.java

    private static final Logger LOG = Logger.getLogger(String.valueOf(DriverManagerHelper.class));

    public static void init(String testName) {
        initDriver(testName);
    }

    private static void initDriver(String testName) {
        LOG.info("### starting driver...");

        configSelenide(testName);
        //var proxy = configProxy();

        LOG.info("### driver is ready to work...");
    }

    public static void configSelenide(String testName) {
        //Configuration.proxyEnabled = true;
    }

    public static void setConfiguration(String testName) {
        //Configuration.remote = "http://loclhost:4444/wd/hub";
    }

    public static DesiredCapabilities capabilities(String testName) {
        var capabilities = new DesiredCapabilities();
        var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        capabilities.setCapability("goog:chromeOptions", options);

        //Selenoid
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("videoName", testName + ".mp4");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("sessionTimeout" , "2m");
        capabilities.setCapability("timeZone", "Europe/Kyiv");
        return capabilities;
    }
}
