package es.uva.inf.poo.entrega2;

import java.time.LocalDate;

/**
 * Clase en la que se almacena toda la información relativa a un producto
 * 
 * @author javabad
 * @author alemina
 *
 */
public class Product extends Vendible{ 
	
	private LocalDate fechaCaducidad;
	private double precio;
	
	/**
	 * Inicializa una instancia de la clase Producto con los valores dados como argumento
	 * @param nombre - Es el nombre del producto
	 * @param fechaCaducidad - Es la fecha de caducidad del producto
	 * @param id - Es el codigo identificador del producto
	 * @param precio - Es el precio del producto
	 * @throws IllegalArgumentException si {@code nombre ==null}}
	 * @throws IllegalArgumentException si {@code id ==null}}
	 * @throws IllegalArgumentException si {@code fechaCaducidad ==null}}
	 * @throws IllegalArgumentException si {@code UPC.length() != 12}
	 * @throws IllegalArgumentException si {@code c < '0' || c > '9' siendo c UPC.charAt(i)}
	 * @throws IllegalArgumentException si {@code UPC.charAt(12)!=d siendo d el digito de control}
	 * @throws IllegalArgumentException si {@code precio <=0}}
	 */
	public Product (String nombre, LocalDate fechaCaducidad, String id, double precio) {
		super(nombre,id); 
		comprobarCodigo(id);
		comprobarFechaCaducidad(fechaCaducidad);
		this.fechaCaducidad = fechaCaducidad;
		setPrecio(precio); 
	}
	/**
	 * Comprueba que el codigo dado es correcto
	 * @param UPC - Es el codigo identificador del producto
	 */
	private static void comprobarCodigo(String upc) {
		if (upc.length() != 12)
			throw new IllegalArgumentException("Codigo erroneo: debe tener 12 numeros");
		for (int i = 0; i < 12; i++) {
			char c = upc.charAt(i);
			if (c < '0' || c > '9')
				throw new IllegalArgumentException("Codigo erroneo: el numero de serie tiene que ser digitos");
		}
		if (!comprobacionDigitoUpc(upc))
			throw new IllegalArgumentException("Codigo erroneo: el ultimo digito no es correcto.");
		
	}

	/**
	 * Comprueba si el ultimo digito de UPC es el correcto
	 * @param UPC - Es el codigo identificador del producto
	 * @return true si el ultimo digito de upc es correcto, false si no lo es
	 */
	private static boolean comprobacionDigitoUpc(String upc) {
		boolean correcto=true;
		int s=0;
		for (int x=0; x<10; x+=2) {
			s+=(upc.charAt(x)-'0')*3;
			s+=(upc.charAt(x+1)-'0')*1;
		}
		s+=(upc.charAt(10)-'0')*3;
		int m = 0;
		m= (int) (10*(Math.round((double)s/10)));
		int d = Math.abs(s-m);
		
		int ultimoDigito = upc.charAt(11)-'0';
		if (ultimoDigito!=d)
			correcto = false;
		
		return correcto;
	}
	
	/**
	 * Comprueba que la fecha de caducidad no es nula
	 * @param fechaCaducidad - La fecha de caducidad del producto
	 */
	private static void comprobarFechaCaducidad(LocalDate fechaCaducidad) {
		if (fechaCaducidad==null) {
			throw new IllegalArgumentException("Codigo erroneo: introduce una fecha de caducidad no nula");
		}
	}
	/**
	 * Comprueba si el precio es correcto
	 * @param precio - Es el numero que contiene el precio del producto
	 */
	private static void comprobarPrecio(double precio){
		if (precio <=0) {
			throw new IllegalArgumentException("Codigo erroneo: el precio no puede ser 0 o negativo");
		}
	}
	/**
	 * Comprueba si el producto esta caducado
	 * @param fechaActual - Es la fecha que se toma como actual para comparar con la de caducidad
	 * @return true si el producto está caducado, false si no lo está
	 */
	public boolean estaCaducadoRespectoA (LocalDate fechaActual) {
		if (fechaActual==null) {
			throw new IllegalArgumentException ("Codigo erroneo: La fecha no puede ser null");
		}
		return fechaCaducidad.isBefore(fechaActual);
	}
	/**
	 * Devuelve el valor precio
	 * @return precio - El precio del producto
	 */
	@Override
	public double getPrecio() {
		return precio;
	}
	/**
	 * Permite modificar el precio
	 * @param precio nuevo que se pondra al producto
	 * @throws IllegalArgumentException si {@code precio <=0}}
	 */
	public void setPrecio(double precio) {
		comprobarPrecio(precio);
		this.precio=precio;
	}
	/**
	 * Devuelve la fecha de caducidad
	 * @return fecha - Fecha de caducidad
	 */
	public LocalDate getFecha() {
		return fechaCaducidad;
	}
	/**
	 * Indica si dos productos son iguales o no
	 * @param obj - Objeto para comparar
	 * @return boolean true si son los dos productos iguales
	 */
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass()!=this.getClass()) {
			return false;
		}
		Product p1 =(Product)obj;
		return this.getNombre().equals(p1.getNombre()) 
				&& this.precio==p1.precio 
				&& this.getId().equals(p1.getId())
				&& this.fechaCaducidad.equals(p1.getFecha());
	 }	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fechaCaducidad.hashCode();
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	} 
}
