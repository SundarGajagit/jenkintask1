package org.base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	WebDriver driver; 
	//1
	public void browserLaunch(String url) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url);
}				
	//2
	public void maximize() {
		driver.manage().window().maximize();
	}
	//3
	public void quit() {
		driver.quit();
	}
	//4
	public void close() {
		driver.close();
	}
	//5
	public WebElement findElementId(String Id) {
		WebElement element = driver.findElement(By.id(Id));
		return element;
	}			
	//6
	public WebElement findElementName(String Name) {
		WebElement elementName = driver.findElement(By.name(Name));
		return elementName;
	} 			
	//7
	public WebElement findElementClass(String ClassName) {
		WebElement elementClassName = driver.findElement(By.className(ClassName));
		return elementClassName;
	}   		
	//8
	public WebElement findElementXpath(String Xpath) {
		WebElement elementXpath = driver.findElement(By.xpath(Xpath));
		return elementXpath;
	}			
	//9
	public void sendValues(WebElement element,String data) {
		element.sendKeys(data);
	}
	//10
	public String getTexts(String Xpath ) {
		WebElement elementText = driver.findElement(By.xpath(Xpath));
		String text = elementText.getText();
		return text;
	}
	//11
	public void click(WebElement element) {
		element.click();
	}
	//12
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	//13
	private String getAttributes(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	//14
	public void threadSleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}
	//15
	public void moveToElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	//16
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	//17
	public void contextClick() {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	//18
	public void doubleClick() {
		Actions actions=new Actions(driver);
		actions.doubleClick();
	}
	//19
	public void alertAccept() {
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	//20
	public void alertDismiss() {
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	//21
	public void promptAlert(String data) {
		Alert al=driver.switchTo().alert();
		al.sendKeys(data);
	}
	//22
	public File getScreenshot() {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	//23
	public void copyFile(File s, File d) throws IOException {
	FileUtils.copyFile(s, d);	
	}
	//24
	public Object jsExecutor(WebElement element, String Name) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		Object executeScript = executor.executeScript("arguments[0].setAttribute('value',"+Name+")", element);
		return executeScript;
	}
	//25
	public Object jsScrollDown(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		Object scrollDown = executor.executeScript("arguments[0].scrollIntoView(true)", element);
		return scrollDown;
	}
	//26
	public Object jsScrollUp(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		Object scrollUp = executor.executeScript("arguments[0].scrollIntoView(false)", element);
		return scrollUp;
	}
	//27
	public void forwardPage() {
		driver.navigate().forward();
	}
	//28
	public void previousPage() {
		driver.navigate().back();
	}
	//29
	public void refresh() {
		driver.navigate().refresh();
	}
	//30
	public void selectByValue(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	//31
	public void selectByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	//32
	public void selectByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	//33
	public void deselectByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	//34
	public void deselectByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	//35
	public void deselectByVisiblettext(WebElement element, String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	//36
	public void deselectAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	//37
	public boolean isMultiple(WebElement element) {
		Select select=new Select(element);
		boolean b = select.isMultiple();
		return b;
	}
	//38
	public String firstSelectedOption(WebElement element) {
		Select select=new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	//39
	public List<WebElement> getOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	//40
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	//41
	public void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
	//42
	public void switchToWindow(String url) {
		driver.switchTo().window(url);
	}
	//43
	public String getWindowHandle() {
		String handle = driver.getWindowHandle();
		return handle;
	}
	//44
	public Set<String> getWindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}
	//45
	public WebDriver switchToFrameid(String id) {
		WebDriver frame = driver.switchTo().frame(id);
		return frame;
	}
	//46
	public WebDriver switchToFrameWebelement(WebElement element) {
		WebDriver webDriver = driver.switchTo().frame(element);
		return webDriver;
	}
	//47
	public WebDriver switchToFrameIndex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return frame;
	}
	//48
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	
	

}
