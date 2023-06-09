package aplicacion.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Repostaje;

/**
 * Implementación de la interfaz repostaje
 * @author csi22
 *
 */
public class ImplRepostaje implements InterfazRepostaje {

	
	@Override
	public Repostaje repostajeNormal(List<Repostaje> listaBD) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método repostajeNormal");

		// Vamos a pedir al usuario los siguientes valores:
		// el id, la fecha, los litros y el importe.
		// Scanner con los valores del usuario
		Scanner entradaValores = new Scanner(System.in);
		
		// Variables utilizadas
		LocalDate entradaFecha;
		float entradaLitros, entradaImporte, eurosLitroGasolina, totalIVAGasolina;
		int entradaID;
		
		// Preguntamos el id del repostaje
		System.out.println("Introduzca el id del repostaje:");
		entradaID = entradaValores.nextInt();
		
		// Preguntamos la fecha del repostaje
		System.out.println("Introduzca la fecha del respotaje:");
		entradaFecha = LocalDate.parse(entradaValores.next());
		
		// Preguntamos los litros del repostaje
		System.out.println("Introduzca los litros del repostaje:");
		entradaLitros = entradaValores.nextFloat();
		
		// Para calcular el importe
		// Vamos a usar el precio real del diesel y le calculamos el iva (21%)
		eurosLitroGasolina = 1.65f;
		entradaImporte = entradaLitros * eurosLitroGasolina;
		// Ahora le calculamos le IVA, una vez calculada se lo sumamos al importe
		totalIVAGasolina = entradaImporte * 0.21f;
		entradaImporte += totalIVAGasolina;
		
		// Devolvemos el objeto de tipo Repostaje creado con los datos
		Repostaje aux = new Repostaje();
		aux.setId(entradaID);
		aux.setFecha(entradaFecha);
		aux.setLitros(Math.round(entradaLitros*10.0)/10f);
		aux.setImporte(Math.round(entradaImporte*100.0)/100f);
		// Le asignamos tambien el boolean en false
		aux.setEsFactura(false);
		
		// Cerramos la variable Scanner antes de cerrar
		// Si la cerramos da error
		//entradaValores.close();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Guardamos repostaje normal: "+aux.toString());
		return aux;
	}

	
	@Override
	public List<Repostaje> repostajeFactura(List<Repostaje> listaBD) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método repostajeFactura");

		// Declaramos las variables que vamos a utilizar
		LocalDate entradaFecha;
		float entradaLitros, entradaImporte, eurosLitroGasolina;
		String entradaDNI, entradaMatricula;
		int entradaID;
		
		// Scanner para preguntar los datos al usuario
		Scanner entradaDatos  = new Scanner(System.in);
		
		// Pedimos los datos
		// Preguntamos el id del repostaje
		System.out.println("Introduzca el id del repostaje:");
		entradaID = entradaDatos.nextInt();

		// Pedimos el DNI
		System.out.println("Introduzca su DNI:");
		entradaDNI = entradaDatos.next();
		
		// Pedimos la matrícula ahora
		System.out.println("Introduzca su matrícula del coche:");
		entradaMatricula = entradaDatos.next();
		
		// Pedimos la fecha
		System.out.println("Introduzca la fecha del repostaje:");
		entradaFecha = LocalDate.parse(entradaDatos.next());
		
		// Pedimos el importe a echar de gasolina y después calculamos cuántos litros serían
		System.out.println("Importe para el repostaje:");
		entradaImporte = entradaDatos.nextFloat();
		
		// Calculamos ahora los litros que serían
		eurosLitroGasolina = 1.65f;
		entradaLitros = entradaImporte / eurosLitroGasolina;
		
		// Creamos el objeto de tipo Repostaje para asignarle los valores
		Repostaje aux = new Repostaje();
		aux.setId(entradaID);
		aux.setFecha(entradaFecha);
		aux.setLitros(Math.round(entradaLitros*10.0)/10f);
		aux.setImporte(Math.round(entradaImporte*100.0)/100f);
		aux.setDni(entradaDNI);
		aux.setMatricula(entradaMatricula);
		// Le asignamos tambien el boolean en true
		aux.setEsFactura(true);
		
		// Devolvemos la lista con el nuevo objeto Repostaje
		listaBD.add(aux);
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Guardamos repostaje factura: "+aux.toString());
		return listaBD;
	}

	
	@Override
	public void todosRepostajes(List<Repostaje> listaBD) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método todosRepostajes");

		// Vamos a mostrar todos los repostajes de la base de datos
		for (Repostaje aux : listaBD) {
			System.out.println("[id=" + aux.getId() +"; Fecha Repostaje=" + aux.getFecha() + "; Litros=" + aux.getLitros() + "; Importe=" + aux.getImporte() + 
					"; Dni=\"" + aux.getDni() + "\"; Matricula=\"" + aux.getMatricula() + "\"; EsFactura="+aux.getEsFactura()+"]");
		}		
	}

	
	@Override
	public void mostrarRepostajePorTipo(List<Repostaje> listaBD, boolean esFactura) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método mostrarRepostajePorTipo");

		// Vamos a mostrar todos los repostajes del tipo elegido
		for (Repostaje aux : listaBD) {
			// Si se cumple imprimirá por pantalla el repostaje
			if(aux.getEsFactura() == esFactura) {
				System.out.println("[id=" + aux.getId() +"; Fecha Repostaje=" + aux.getFecha() + "; Litros=" + aux.getLitros() + "; Importe=" + aux.getImporte() + 
						"; Dni=\"" + aux.getDni() + "\"; Matricula=\"" + aux.getMatricula() + "\"; EsFactura="+aux.getEsFactura()+"]");
			}
		}		
	}

	
	@Override
	public List<Repostaje> eliminarRepostaje(List<Repostaje> listaBD) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método eliminarRepostaje");

		// Vamos a eliminar un repostaje por su id
		// Luego vamos a tener que pedir el id del repostaje
		
		// Scanner para leer la entrada del usuario
		Scanner entradaOpcion = new Scanner(System.in);
		// Declaramos las variables que vayamos a necesitar
		int id;
		
		// Pedimos el id
		System.out.println("Introduzca el id del repostaje a eliminar: ");
		id = entradaOpcion.nextInt();
		
		// Buscamos en la base de datos el repostaje con ese id y lo eliminamos
		for (Repostaje aux : listaBD) {
			// Si el id del objeto auxiliar es igual al id introducido por el usuario, borraremos
			if(aux.getId() == id) {
				listaBD.remove(aux); // Borramos el objeto que tiene el id
				intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Eliminamos repostaje: "+aux.toString());
				break;
			}
		}
		
		// Devolemos la base de datos actualizada
		return listaBD;
	}

	
	@Override
	public List<Repostaje> modificarRepostaje(List<Repostaje> listaBD) {
		// Inicializamos la interfaz de fichero
		InterfazFicheros intF = new ImplFicheros();
		intF.escribeFichero("c:\\zDatosPrueba\\PruebaAmpliacionGestionGasolinera.txt", "Entrada método modificarRepostaje");

		// Vamos a modificar un repostaje por su id
		// Luego vamos a tener que pedir el id del repostaje
		
		// Scanner para leer la entrada del usuario
		Scanner entradaOpcion = new Scanner(System.in);
		
		// Declaramos las variables que vayamos a necesitar
		int id;
		String campo="", dniNuevo, matriculaNueva;
		LocalDate fechaNueva;
		Repostaje auxiliar = new Repostaje();
		float litrosNuevo, importeNuevo;
		boolean esFacturaNuevo;
		
		// Pedimos el id
		System.out.println("Introduzca el id del repostaje a modificar: ");
		id = entradaOpcion.nextInt();
		
		// Buscamos el repostaje y lo guardamos
		for (Repostaje res : listaBD) {
			if(res.getId() == id) {
				auxiliar = res;
				break;
			}
		}
		
		// Vamos a hacer un bucle que pida los campos hasta que se quiera salir
		while(!campo.equals("salir")) {
			// Ahora vamos a preguntar cual es el dato a modificar
			System.out.println("Registro:");
			System.out.println("[Fecha:"+ auxiliar.getFecha() + "; Litros:"+ auxiliar.getLitros()+
					"; Importe:"+ auxiliar.getImporte()+"; DNI:"+auxiliar.getDni()+"; Matricula:"+auxiliar.getMatricula()+
					"; EsFactura:"+auxiliar.getEsFactura()+"]");
			System.out.println("Campos: fecha, litros, importe, dni, matricula, esFactura");
			System.out.println("¿Campo a modificar? [\"salir\" para salir]: ");
			campo = entradaOpcion.next();
			
			// Ahora según el campo introducido haremos una cosa u otra
			switch (campo.toLowerCase()) {
				case "fecha":
					// FECHA
					System.out.print("¿Fecha nueva?: ");
					fechaNueva = LocalDate.parse(entradaOpcion.next());
					auxiliar.setFecha(fechaNueva);
					break;
					
				case "litros":
					// LITROS
					System.out.print("¿Litros nuevo?: ");
					litrosNuevo = entradaOpcion.nextFloat();
					auxiliar.setLitros(litrosNuevo);
					break;
					
				case "importe":
					// IMPORTE
					System.out.print("¿Importe nuevo?: ");
					importeNuevo = entradaOpcion.nextFloat();
					auxiliar.setImporte(importeNuevo);
					break;
				case "dni":
					// DNI
					System.out.print("¿DNI nuevo?: ");
					dniNuevo = entradaOpcion.next();
					auxiliar.setDni(dniNuevo);
					break;
					
				case "matricula":
					// MATRICULA
					System.out.print("¿Matricula nueva?: ");
					matriculaNueva = entradaOpcion.next();
					auxiliar.setMatricula(matriculaNueva);
					break;
					
				case "esfactura":
					// ES FACTURA
					System.out.println("¿Nuevo valor? [\"false\" normal; \"true\" factura]: ");
					esFacturaNuevo = entradaOpcion.nextBoolean();
					auxiliar.setEsFactura(esFacturaNuevo);
					break;
			}
		}
		
		// Devolemos la base de datos actualizada
		return listaBD;
	}

}
