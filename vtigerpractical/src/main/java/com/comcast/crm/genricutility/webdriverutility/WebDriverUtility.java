package com.comcast.crm.genricutility.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void  waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	public void switchTabOnURL(WebDriver driver, String Partialurl) {
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(Partialurl)) {
				break;
			}
		}
		
	}
	
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String acturl = driver.getTitle();
			if(acturl.contains(partialTitle)) {
				break;
			}
		}
		
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	
	public void switchToFrame(WebDriver driver, String nameorid) {
		driver.switchTo().frame(nameorid);
		
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void selectOnText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	public void selectOnIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void selectOnIndex(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}
	
	public void dragAndDrop(WebDriver driver, WebElement sourceelement, WebElement targetelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceelement, targetelement).perform();

	}
	
	
	
	
	

}
