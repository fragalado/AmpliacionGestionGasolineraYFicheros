package aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Repostaje;
import aplicacion.servicios.ImplFicheros;
import aplicacion.servicios.ImplPrincipal;
import aplicacion.servicios.ImplRepostaje;
import aplicacion.servicios.InterfazFicheros;
import aplicacion.servicios.InterfazPrincipal;
import aplicacion.servicios.InterfazRepostaje;

public class Principal {
	
	static String rutaFichero = "c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt";
	
	public static void main(String[] args) {
		// Inicializamos la interfaz de repostaje y principal
		InterfazPrincipal intP = new ImplPrincipal();
		InterfazRepostaje intR = new ImplRepostaje();
		
		// Inicializamos la interfaz de ficheros
		InterfazFicheros intF = new ImplFicheros();
		
		// Creamos una lista que contendrá objetos de tipo Repostaje (Nuestra base de datos)
		List<Repostaje> listaBD = new ArrayList<>();
		
		// Scanner con la opción del usuario
		Scanner entradaOpcion = new Scanner(System.in);
		int opcion;
		String entradaValor;
		do {
			// Mostramos el menu
			intP.mostrarMenu();
			
			// Pedimos la opción y la guardamos
			System.out.println("Introduzca la opción deseada:");
			opcion = entradaOpcion.nextInt();
			System.out.println("[INFO] - Has seleccionado la opcion " + opcion); // Para mostrar al usuario la opción seleccionada
			
			// Ahora controlamos la opción
			switch (opcion) {
			case 1:
				intF.escribeFichero(rutaFichero, "Opción escogida: 1. Repostaje normal");
				// REPOSTAJE NORMAL
				try {
					listaBD.add(intR.repostajeNormal(listaBD));
				} catch (Exception e) {
					intF.escribeFichero(rutaFichero, "** Error: No se puedo crear el repostaje normal **");
				}
				break;

			case 2:
				intF.escribeFichero(rutaFichero, "Opción escogida: 2. Repostaje factura");
				// REPOSTAJE FACTURA
				try {
					listaBD = intR.repostajeFactura(listaBD);
				} catch (Exception e) {
					intF.escribeFichero(rutaFichero, "** Error: No se puedo crear el repostaje factura **");
				}
				break;
			
			case 3:
				intF.escribeFichero(rutaFichero, "Opción escogida: 3. Ver todos los repostajes");
				// VER TODOS LOS REPOSTAJES
				intR.todosRepostajes(listaBD);
				break;
			
			case 4:
				intF.escribeFichero(rutaFichero, "Opción escogida: 4. Listar repostaje por tipo");
				// LISTAR REPOSTAJE POR TIPOS
				// Mostramos primero un mensaje de las posibilidades que hay
				System.out.println("Introduzca \"false\" para ver repostaje Normal");
				System.out.println("Introduzca \"true\" para ver repostaje Factura");
				System.out.print("Opción: ");
				entradaValor = entradaOpcion.next();
				intR.mostrarRepostajePorTipo(listaBD, Boolean.valueOf(entradaValor));
				break;
			case 5:
				intF.escribeFichero(rutaFichero, "Opción escogida: 5. Eliminar repostaje");
				// ELIMINAR REPOSTAJE
				listaBD = intR.eliminarRepostaje(listaBD);
				break;
			case 6:
				intF.escribeFichero(rutaFichero, "Opción escogida: 6. Modificar repostaje");
				// MODIFICAR REPOSTAJE
				try {
					listaBD = intR.modificarRepostaje(listaBD);
				} catch (Exception e) {
					intF.escribeFichero(rutaFichero, "** Error: No se pudo modificar correctamente **");
				}
				break;
			}
		} while (opcion != 7);
		
		intF.escribeFichero(rutaFichero, "Opción escogida: 7. Salir");
		
		// Cerramos la variable Scanner
		entradaOpcion.close();
	}
}

