package mapsObjetInicio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import docsBase.ClaseBase;

public class MapsObjetInicio extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetInicio(WebDriver driver)

	{
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL - CLICK ELEMENTS
	protected By btnelements = By.xpath("//h5[normalize-space()='Elements']");

}
