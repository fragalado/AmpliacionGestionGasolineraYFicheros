package aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Repostaje;
import aplicacion.servicios.ImplPrincipal;
import aplicacion.servicios.ImplRepostaje;
import aplicacion.servicios.InterfazPrincipal;
import aplicacion.servicios.InterfazRepostaje;

public class Principal {

	public static void main(String[] args) {
		// Inicializamos la interfaz de repostaje y principal
		InterfazPrincipal intP = new ImplPrincipal();
		InterfazRepostaje intR = new ImplRepostaje();

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
				// REPOSTAJE NORMAL
				listaBD.add(intR.repostajeNormal(listaBD));
				break;

			case 2:
				// REPOSTAJE FACTURA
				listaBD = intR.repostajeFactura(listaBD);
				break;
			
			case 3:
				// VER TODOS LOS REPOSTAJES
				intR.todosRepostajes(listaBD);
				break;
			
			case 4:
				// LISTAR REPOSTAJE POR TIPOS
				// Mostramos primero un mensaje de las posibilidades que hay
				System.out.println("Introduzca \"false\" para ver repostaje Normal");
				System.out.println("Introduzca \"true\" para ver repostaje Factura");
				System.out.print("Opción: ");
				entradaValor = entradaOpcion.next();
				intR.mostrarRepostajePorTipo(listaBD, Boolean.valueOf(entradaValor));
				break;
			case 5:
				// ELIMINAR REPOSTAJE
				listaBD = intR.eliminarRepostaje(listaBD);
				break;
			case 6:
				// MODIFICAR REPOSTAJE
				listaBD = intR.modificarRepostaje(listaBD);
				break;
			}
		} while (opcion != 7);
		
		// Cerramos la variable Scanner
		entradaOpcion.close();
	}
}

