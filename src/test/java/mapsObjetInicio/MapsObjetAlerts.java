package mapsObjetInicio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import docsBase.ClaseBase;

public class MapsObjetAlerts extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetAlerts(WebDriver driver)

	{
		super(driver);
	}

	// INGRESAR ALERTAS
	protected By btnRecoWidget = By.xpath("//div[1]//div[1]//div[4]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
	protected By btnFrame = By.xpath("//*[@class='left-pannel']/div/div[3]");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");

	// INGRESAR BOTONES
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']");
}