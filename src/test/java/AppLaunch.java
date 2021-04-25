import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppLaunch {
    public static AndroidDriver driver;
    public static AppLaunch instance;

    private AppLaunch() throws MalformedURLException, InterruptedException {
        setUp();
    }

    public static AppLaunch getInstance() throws IOException, InterruptedException {
        if (instance == null) {
            instance = new AppLaunch();
        }
        return instance;
    }
    private void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "My Device");
        cap.setCapability("platformName", "Android");
        cap.setCapability("uuid", "672125e00305");
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("autoGrantPermissions", true);
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver(url,cap);
        Thread.sleep(1000);
    }
}
