package utiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utilidades {

	public static String leerArchivoTxt(String ruta) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		String cad = br.readLine();
		
		br.close();
		return cad;
	}
}
