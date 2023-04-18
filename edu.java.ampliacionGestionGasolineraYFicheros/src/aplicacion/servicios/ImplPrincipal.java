package aplicacion.servicios;


/**
 * Implementación de la interfaz principal
 * @author csi22
 *
 */
public class ImplPrincipal implements InterfazPrincipal {

	@Override
	public void mostrarMenu() {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método mostrarMenu");
		
		System.out.println("1. Repostaje Normal");
		System.out.println("2. Repostaje Factura");
		System.out.println("3. Ver todos los repostajes");
		System.out.println("4. Listar repostajes por tipo");
		System.out.println("5. Eliminar repostaje");
		System.out.println("6. Modificar repostaje");
		System.out.println("7. Salir");		
	}
}
