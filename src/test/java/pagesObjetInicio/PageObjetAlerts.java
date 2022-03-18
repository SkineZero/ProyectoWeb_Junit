package pagesObjetInicio;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import mapsObjetInicio.MapsObjetAlerts;
import utilitiesExe.ReadExcelFile;

public class PageObjetAlerts extends MapsObjetAlerts

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjetAlerts(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void selecAlerts(ReadExcelFile leer, Properties propiedades, String TextAlerts, File rutaCarpeta)
			throws Exception {

		// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - CLICK EN ALERTS
		scrollPage(0, 400);
		click(btnRecoWidget, rutaCarpeta);
		click(btnFrame, rutaCarpeta);
		click(btnAlerts, rutaCarpeta);

		// PRIMER CLICK
		click(btnClic1, rutaCarpeta);
		driver.switchTo().alert().dismiss();
		tiempoEspera(1000);

		// SEGUNDO CLICK
		click(btnClic2, rutaCarpeta);
		tiempoEspera(7000);
		driver.switchTo().alert().dismiss();
		tiempoEspera(1000);

		// TERCER CLICK - ACEPTAR
		click(btnClic3, rutaCarpeta);
		tiempoEspera(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		tiempoEspera(1000);

		// TERCER CLICK - CANCELAR
		click(btnClic3, rutaCarpeta);
		tiempoEspera(1000);
		driver.switchTo().alert().dismiss();
		tiempoEspera(1000);

		// CUARTO CLICK
		click(btnClic4, rutaCarpeta);
		driver.switchTo().alert().sendKeys(leer.getCellValue(propiedades.getProperty("filePathExcel"), TextAlerts, 1, 0));
		alert();
		tiempoEspera(5000);
	}

}