package aplicacion.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Implementación de la interfaz de ficheros
 * @author csi22
 *
 */
public class ImplFicheros implements InterfazFicheros {
	
	
	@Override
	public String leerFichero(String ruta) {
		
		// Variable que devolveremos con todo el texto del fichero
		String texto = "";
		
		// Variables para leer el fichero
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea = br.readLine()) != null) {
				texto += linea;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerramos el fichero
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return texto;
	}

	@Override
	public void escribeFichero(String ruta,String texto) {
		
		// Variables necesarias para escribir en un fichero
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta, true);
			pw = new PrintWriter(fw);
			
			// Escribimos el texto
			pw.println(texto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerramos el fichero
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
