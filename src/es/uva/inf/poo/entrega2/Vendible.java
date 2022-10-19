package es.uva.inf.poo.entrega2;



/**
 * Clase que almacena toda la informacion relativa a un Vendible
 * 
 * @author javabad
 * @author alemina
 *
 */
public abstract class Vendible {
	private String nombre;
	private String id; 
	
	/**
	 * Inicializa un Vendible formado por los parametros
	 * @param nombre nombre del Vendible
	 * @param id identificador del Vendible
	 * @throws IllegalArgumentException si {@code nombre==null}
	 * @throws IllegalArgumentException si {@code id==null}
	 * @throws IllegalArgumentException si {@code nombre.isEmpty()}
	 * @throws IllegalArgumentException si {@code id.isEmpty()}
	 */
	protected Vendible(String nombre,String id) {
		comprobarId(id);
		setNombre(nombre);
		this.id=id;
	}
	/**
	 * Compueba que el nombre sea correcto, es decir, no nulo.
	 * @param nombre nombre del Vendible
	 */
	private static void comprobarNombre(String nombre) {
		if (nombre==null) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce un nombre no null");
		}
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce un nombre no vacio");
		}
	}
	/**
	 * Compueba que el identificador sea correcto, es decir, no nulo.
	 * @param id identificador del Vendible
	 */
	private static void comprobarId(String id) {
		if (id==null) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce un identificador no null");
		}
		if(id.isEmpty()) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce un identificador no vacio");
		}
	}
	
	/**
	 * Devuelve el precio del vendible
	 * @return entero con el precio
	 */
	public abstract double getPrecio();
	
	/**
	 * Devuelve el nombre del Vendible
	 * @return nombre - Cadena con el nombre del Vendible
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Permite cambiar el nombre del Vendible 
	 * @param nombre nombre del Vendible
	 * @throws IllegalArgumentException si {@code nombre==null}
	 */
	public void setNombre(String nombre) {
		comprobarNombre(nombre);
		this.nombre = nombre;
	}
	/**
	 * Devuelve el id del Vendible
	 * @return id - Identificador del objeto vendible
	 */
	public String getId() {
		return id;
	}
}
