package aplicacion.servicios;

/**
 * Interfaz que define los métodos que darán servicio a la clase fichero
 * @author csi22
 *
 */
public interface InterfazFicheros {
	
	/**
	 * Método que leerá un fichero y lo devolverá como String
	 */
	public String leerFichero(String ruta);
	
	/**
	 * Método que escribirá en un fichero lo que se le pase por parámetro
	 */
	public void escribeFichero(String ruta, String texto);
}
