package pagesObjetInicio;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import mapsObjetInicio.MapsObjetWidgets;
import utilitiesExe.ReadExcelFile;

public class PageObjetWidgets extends MapsObjetWidgets

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjetWidgets(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void selecWidgets(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		// INGRESAR FECHA
		scrollPage(0, 300);
		click(btnRecoger, rutaCarpeta);
		click(btnWidgets, rutaCarpeta);
		click(btnDatePïcker, rutaCarpeta);
		comando(numDateSelect, rutaCarpeta);
		bspace(numDateSelect, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DatePickSel", 10, 0), numDateSelect,
				rutaCarpeta);
		intro(numDateSelect, rutaCarpeta);
		tiempoEspera(1000);


		// INFRESAR FECHA Y HORA	
		comando(btnDT, rutaCarpeta);
		bspace(btnDT, rutaCarpeta);
		tiempoEspera(5000);		
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DatePickSel", 10, 4)+" "+leer.getCellValue(propiedades.getProperty("filePathExcel"), "DatePickSel", 10, 6),btnDT, rutaCarpeta);
		tiempoEspera(500);
		intro(btnDT, rutaCarpeta);
		tiempoEspera(5000);	
	}

}