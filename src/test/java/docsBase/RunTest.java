// PRUEBA DE MASTER A MAIN

// A VER SI SIRVE, PRUEBA DE MASTER A CORRECT

package docsBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pagesObjetInicio.PageObjetAlerts;
import pagesObjetInicio.PageObjetElements;
import pagesObjetInicio.PageObjetInicio;
import pagesObjetInicio.PageObjetWidgets;
import utilitiesExe.ReadExcelFile;
import utilitiesExe.WriteExcelFile;

public class RunTest {

	private WebDriver driver;
	PageObjetInicio ingreso;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = null;
	PageObjetElements element;
	PageObjetWidgets widget;
	PageObjetAlerts alerts;

	@Before
	public void setUp() throws IOException {

		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.chromeDriverConection();
		// INSTANCIAR LA CLASE DE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		// CREAR VARIABLES TIPO INPUTSTRING
		InputStream entrada = null;
		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./src/test/resources/Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	@Test // PRUEBA 1 INGRESAR A LA PAGINA
	public void ingresoDemon() throws Exception {
		// INSTANCIAR CLASE BASE
		ClaseBase clasebase = new ClaseBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA
		File rutaCarpeta = clasebase.crearCarpeta(propiedades, nomTest);
		// INSTANCIAR LAS CLASES QUE SE COLOCAN EN PAGEOBJECT
		element = new PageObjetElements(driver);
		ingreso = new PageObjetInicio(driver);
		widget = new PageObjetWidgets(driver);
		alerts = new PageObjetAlerts(driver);
		// ALMACENO EN LA VARIABLE EL VALOR DE URL DEL EXCEL
		url = leer.getCellValue(propiedades.getProperty("filePathExcel"), "UrlInicial", 1, 0);
		// ACCEDEMOS A LA PAGINA DE PERIFERIA
		ingreso.urlAcceso(url);
		// ACCEDER AL METODO DE PRUEBA INICIO
		ingreso.pagDemon(leer, propiedades, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA ELEMENTS
		element.selecElements(leer, propiedades, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA WIDGETS
		widget.selecWidgets(leer, propiedades, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA ALERTS
		alerts.selecAlerts(leer, propiedades, "TextAlerts", rutaCarpeta); 
	}

	@After
	public void cerrar() {
		// CERRAR PROCESO
		driver.quit();
	}

}
