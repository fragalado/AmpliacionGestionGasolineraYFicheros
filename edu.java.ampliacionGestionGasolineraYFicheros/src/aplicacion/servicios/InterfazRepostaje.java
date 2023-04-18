package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Repostaje;

/**
 * Interfaz que define los métodos que darán servicio a la clase repostaje
 * @author csi22
 *
 */
public interface InterfazRepostaje {
	
	/**
	 * Método que crea un repostaje normal.
	 * Se guarda la fecha, los litros y el importe.
	 * @param listaBD
	 * @return
	 */
	public Repostaje repostajeNormal(List<Repostaje> listaBD);
	
	/**
	 * Método que crea un repostaje factura.
	 * Se guarda la fecha, los litros, el importe, el DNI del cliente y la matrícula del vehículo.
	 * @param listaBD
	 * @return
	 */
	public List<Repostaje> repostajeFactura(List<Repostaje> listaBD);
	
	/**
	 * Método para mostrar todos los repostajes.
	 * @param listaBD
	 */
	public void todosRepostajes(List<Repostaje> listaBD);
	
	/**
	 * Método para mostrar todos los repostajes del tipo elegido
	 * @param listaBD
	 * @param esFactura
	 */
	public void mostrarRepostajePorTipo(List<Repostaje> listaBD, boolean esFactura);
	
	/**
	 * Método para eliminar un repostaje según el id
	 * @param listaBD
	 * @return
	 */
	public List<Repostaje> eliminarRepostaje(List<Repostaje> listaBD);
	
	/**
	 * Método para modificar un repostaje
	 * @param listaBD
	 * @return
	 */
	public List<Repostaje> modificarRepostaje(List<Repostaje> listaBD);
}
