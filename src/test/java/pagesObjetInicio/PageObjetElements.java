package pagesObjetInicio;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import mapsObjetInicio.MapsObjetElements;
import utilitiesExe.ReadExcelFile;

public class PageObjetElements extends MapsObjetElements

{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjetElements(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void selecElements(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR - ELEMENTS
		click(btnElements, rutaCarpeta);
		scrollPage(0, 300);
		click(btnWebTables, rutaCarpeta);
		
		//AGREGA UN NUEVO REGISTRO
		click(btnAdd, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 0), txtFirstName, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 1), txtLastName,	rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 2), txtEmail, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 3), numAge, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 4), numSalary, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "FormElem", 1, 5), txtDepartament, rutaCarpeta);
		click(btnSubmit, rutaCarpeta);

		// ELIMINAR CUALQUIER REGISTRO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Deleted", 1, 0), txtSearch, rutaCarpeta); tiempoEspera(1000);
		click(btnDeleted, rutaCarpeta);
		
		// BORRA EL TEXTO ESCRITO Y COLOCA UN DATO PARA VERIFICAR QUIENES SE HAN ELIMINADO
		borrar(txtSearch, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Deleted", 1, 1), txtSearch, rutaCarpeta); tiempoEspera(1000);

	}

}