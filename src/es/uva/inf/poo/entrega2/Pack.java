package es.uva.inf.poo.entrega2;

import java.util.*;

/**
 * Clase que almacena toda la informacion relativa a un pack
 * 
 * @author javabad
 * @author alemina
 *
 */
public class Pack extends Vendible {
	
	private List<Product> listaProductos;
	
	/**
	 * Inicializa una instancia de la clase Pack, con los valores dados como argumento 
	 * @param nombre - Es el nombre del pack
	 * @param listaProductos - Una lista de productos que formaran el pack 
	 * @param id - El identificador por el cual se identifica el pack
	 * @throws IllegalArgumentException si {@code nombre ==null}}
	 * @throws IllegalArgumentException si {@code id ==null}}
	 * @throws NullPointerException si {@code listaProductos.get(i)==null}
	 * @throws IllegalArgumentException si {@code cantidadProductosPack()<2}
	 * @throws IllegalArgumentException si {@code listaProductos.get(i).equals(listaProductos.get(j))&& i!=j}
	 * @throws IllegalArgumentException si {@code listaProductos==null}
	 */
	protected Pack (String nombre, List<Product> listaProductos,String id) {
		super(nombre,id);  
		comprobarListaProductos(listaProductos); 
		this.listaProductos=new ArrayList<>(listaProductos);
	}
	/**
	 * Comprueba que la lista de Productos sea correcta
	 */
	private static void comprobarListaProductos(List<Product> listaProductos) {
		if(listaProductos==null) {
			throw new IllegalArgumentException ("Codigo erroneo: La lista no puede ser nula");
		}
		if(listaProductos.size()<2) {
			throw new IllegalArgumentException ("Codigo erroneo: Debe de haber al menos dos productos en el pack");
		}
		for(int i=0;i<listaProductos.size();i++) {
			
			for(int j=1;j<listaProductos.size();j++) {
				if(listaProductos.get(i)==null||listaProductos.get(j)==null) {
					throw new IllegalArgumentException ("Codigo erroneo: No pueden existir productos nulos");
				}
				if(listaProductos.get(i).equals(listaProductos.get(j))&& i!=j) {
					throw new IllegalArgumentException ("Codigo erroneo: No pueden existir productos repetidos");
				}
			}
		}
	}
	/**
	 * Devuelve el precio del Pack
	 * @return precio total del pack
	 */
	@Override 
	public double getPrecio() {
		double precio=0;
		for(int i=0;i<cantidadProductosPack();i++) {
			precio=precio+listaProductos.get(i).getPrecio();
		}
		return (precio*0.8);
	}
	/**
	 * Devuelve la cantidad de productos que forman el pack
	 * @return cantidad de productos que hay en el pack
	 */ 
	public int cantidadProductosPack() {
		return listaProductos.size();
	}
	/**
	 * Comprueba si el producto representado por su id esta dentro del pack
	 * @param id - identificador del pack
	 * @return true si el producto si esta en el pack, false si no esta en el pack
	 */
	public boolean productoIncluido(String id) {
		for(int i=0;i<cantidadProductosPack();i++) {
			if(listaProductos.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Lista de productos que forman el pack
	 * @return la lista de productos 
	 */
	public List<Product> getListaProductos() {
		return new ArrayList<>(listaProductos);
	}
	/**
	 * Añade un producto a la lista de productos
	 * @param p1 - Producto que se va a añadir
	 * @throws NullPointerException si {@code listaProductos.get(i)==null}
	 * @throws IllegalArgumentException si {@code cantidadProductosPack()<2}
	 * @throws IllegalArgumentException si {@code listaProductos.get(i).equals(listaProductos.get(j))&& i!=j}
	 * @throws IllegalArgumentException si {@code listaProductos==null}
	 */
	public void annadirProducto(Product p1) {
		listaProductos.add(p1);
		comprobarListaProductos(listaProductos);
	}
	/**
	 * Indica si dos productos son iguales o no
	 * @param obj - Objeto para comparar
	 * @return boolean true si son los dos productos iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack p1 =(Pack)obj;
		return this.getNombre().equals(p1.getNombre()) 
				&& this.getId().equals(p1.getId())
				&& this.getListaProductos().equals(p1.getListaProductos());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + listaProductos.hashCode();
		return result;
	}
	
}
