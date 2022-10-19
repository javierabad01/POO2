package es.uva.inf.poo.entrega2;

/**
 * Clase que almacena toda la informacion relativa a una linea de una Vending Machine
 * 
 * @author javabad
 * @author alemina
 *
 */
 public class Linea {
	private int identificadorLinea;
	private Vendible producto;
	private double precio;
	private int cantidad;
	
	/**
	 * Inicializa una linea formada por los parametros 
	 * @param identificadorLinea - Es el identificador de una linea
	 * @param producto - Es el Vendible asociado a la linea, puede ser un producto o un pack
	 * @param precioExtra - Precio que se añadira como comision al precio basico del vendible
	 * @param cantidad - Cantidad del vendible de la linea que se añadira o se restará a lo que hubiese anteriormente 
	 * @throws IllegalArgumentException si {@code identificadorLinea<0}
	 * @throws IllegalArgumentException si {@code producto==null}
	 * @throws IllegalArgumentException si {@code precio<0}}
	 * @throws IllegalArgumentException si {@code (cantidad)<0}
	 */
	public Linea (int identificadorLinea, Vendible producto, double precioExtra, int cantidad) {
		comprobarIdentificador(identificadorLinea);
		this.identificadorLinea=identificadorLinea;
		setProducto(producto);
		setPrecio(precioExtra);
		setCantidad(cantidad);
	}
	
	
	/**
	 * Comprueba si el identificador es correcto
	 * @param identificadorLinea - Es el identificador de una linea
	 */
	private static void comprobarIdentificador(int identificadorLinea) {
		if (identificadorLinea<0){
			throw new IllegalArgumentException("Codigo erroneo: El identificador no puede ser negativo");
		}
	}
	/**
	 * Comprueba si el producto a vender no es nulo
	 * @param identificadorLinea - Es el identificador de una linea
	 */
	private static void comprobarProducto(Vendible producto) {
		if (producto==null){
			throw new IllegalArgumentException("Codigo erroneo: El producto no puede ser null");
		}
	}
	/**
	 * Devuelve el identificadorLinea
	 * @return identificadorLinea - Entero con el identificador de la linea
	 */
	public int getIdentificadorLinea() {
		return identificadorLinea;
	}
	/**
	 * Devuelve el producto que esta almacenado en esa linea
	 * @return producto - Es el producto asociado a la linea
	 */
	public Vendible getProducto() {
		return producto;
	}
	/**
	 * Permite modificar el producto que hay en la linea
	 * @param producto - Es el producto asociado a la linea
	 * @throws IllegalArgumentException si {@code producto==null}
	 */
	public void setProducto(Vendible producto) {
		comprobarProducto(producto);
		this.producto = producto;
	}
	/**
	 * Devuelve el precio del producto en la linea tenga o no comision
	 * @return precio - Es el precio que tiene en ese momento el producto
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Permite modificar el precio del producto en la linea, cambiando el precio extra de la maquina
	 * @param precio - Es el precio del producto
	 * @throws IllegalArgumentException si {@code precio<0}}
	 */
	public void setPrecio(double precio) {
		if (precio<0) {
			throw new IllegalArgumentException("Codigo erroneo: El precio del producto no puede ser menor"
					+ "que el precio basico del producto");
		}
		this.precio = producto.getPrecio()+ precio;
	}
	/**
	 * Devuelve la cantidad del producto que hay en la linea
	 * @return cantidad - Entero con la cantidad del producto en la linea
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Permite cambiar la cantidad del producto
	 * @param cantidad - Entero con la cantidad del producto en la linea
	 * @throws IllegalArgumentException si {@code getCantidad() + cantidad<0}
	 */
	public void setCantidad(int cantidad) {
		if ((cantidad)<0) {
			throw new IllegalArgumentException("Codigo erroneo: La cantidad no puede ser menor que 0");
		}
		this.cantidad = cantidad;
	}
	/**
	 * Permite sumar la cantidad que se tenga anteriormente 
	 * @param cantidad - Entero con la cantidad del producto en la linea
	 * @throws IllegalArgumentException si {@code cantidad<0}
	 */
	public void annadirCantidadExtra(int cantidad) {
		if ( cantidad<0) {
			throw new IllegalArgumentException("Codigo erroneo: La cantidad no puede ser menor que 0");
		}
		setCantidad (getCantidad() + cantidad);
	}
	/**
	 * Permite sacar solo un producto de la linea
	 */
	public void sacarUno() {
		setCantidad(getCantidad()-1);
	}
	
	/**
	 * Permite vaciar una linea, es decir, poner la cantidad de producto igual a 0
	 */
	public void vaciarLinea() {
		setCantidad(0);
	}
	/**
	 * Comprueba si la linea esta vacia o no
	 * @return true si esta vacia y false si no esta vacia
	 */
	public boolean estaVacia () {
		return getCantidad()==0;
	}
	
}
