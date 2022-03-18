package pagesObjetInicio;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import mapsObjetInicio.MapsObjetInicio;
import utilitiesExe.ReadExcelFile;

public class PageObjetInicio extends MapsObjetInicio

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjetInicio(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void pagDemon(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - BAJA EL NAVEGADOR
		scrollPage(0, 1000);
		tiempoEspera(1000);
	}

}