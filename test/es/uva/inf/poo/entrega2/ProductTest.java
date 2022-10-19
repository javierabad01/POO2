package es.uva.inf.poo.entrega2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;


public class ProductTest {
	
	String upcValido="823880024474";
	String nombre="Patatas";
	String date = "16/08/2021";
	String formatoFecha="d/MM/yyyy";
	 
	@Test(expected=IllegalArgumentException.class)
	public void testupcNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		double precio = 7.5;
		new  Product(nombre, fecha, null, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcLogitudVacia() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		String upc = "";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcLogitudErroneaCorta() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		String upc="12345678901";
		double precio = 7.5;
		new Product(nombre, fecha, upc, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcLogitudLarga() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		String upc="1234567891234";
		double precio = 7.5;
		
		new  Product(nombre, fecha, upc, precio);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testupcConPrimeraLetraMinuscula() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		String upc="456734a63980";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcConUltimaLetraMinuscula() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		String upc="456734563z80";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcConPrimeraLetraMayuscula() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		String upc="456734A63980";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testupcConUltimaLetraMayuscula() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		String upc="4Z6734863980";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testupcUltimoDigitoIncorrecto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		String upc="823880024473";
		double precio = 7.5;
		new  Product(nombre, fecha, upc, precio);
	}
	
	
	@Test
	public void testupcLongitudCorrecta() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.getNombre(),nombre);
		assertEquals(p1.getFecha(),fecha);
		assertEquals(p1.getPrecio(),precio,0);
		assertEquals(p1.getId(),upcValido);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrecioIgualCero() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 0;
		new  Product(nombre, fecha, upcValido, precio);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrecioIgualNegativo() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = -1;
		new  Product(nombre, fecha, upcValido, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testFechaCaducidadNull() {		
		new  Product(nombre, null, upcValido, 5);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCaducadoNull() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		
		p1.estaCaducadoRespectoA(null);
	}
	@Test
	public void testNoEstaCaducado() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(formatoFecha);
		String date1 = "16/08/2021";
		LocalDate fecha1 = LocalDate.parse(date1,formatter1);
		
		assertEquals(p1.estaCaducadoRespectoA(fecha1),false);
	}
	
	@Test
	public void testEstaCaducado() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(formatoFecha);
		String date1 = "17/08/2021";
		LocalDate fecha1 = LocalDate.parse(date1,formatter1);
		
		assertEquals(p1.estaCaducadoRespectoA(fecha1),true);
	}
	@Test
	public void testGetPrecio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		
		double delta=0.0;
		assertEquals(p1.getPrecio(),precio,delta);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetPrecioNegativo() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 1;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		p1.setPrecio(-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetPrecioCero() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 1;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		p1.setPrecio(0);
	}
	@Test
	public void testSetPrecioCorrecto() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 1;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		p1.setPrecio(5);
		assertEquals(p1.getPrecio(),5,0);
	}

	@Test
	public void testGetFecha() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.getFecha(),fecha);
	}
	@Test
	public void testProductoIgualNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.equals(null),false);
	}
	@Test
	public void testProductoIgualProductoReferencia() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.equals(p1),true);
	}
	@Test
	public void testProductoIgualProducto() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);
		
		double precio = 10;
		Product p1 = new  Product(nombre, fecha, upcValido, precio);
		Product p2 = new  Product(nombre, fecha, upcValido, precio);

		assertEquals(p1.equals(p2),true);
	}
	@Test
	public void testProductoNoIgualString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		String date1 = "16/09/2021";
		LocalDate fecha = LocalDate.parse(date,formatter);

		Product p1 = new  Product(nombre, fecha,upcValido, 5);

		assertEquals(p1.equals(date1),false);
	}
	@Test
	public void testProductoNoIgualProductoNombre() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);

		Product p1 = new  Product(nombre, fecha,upcValido, 5);
		Product p2 = new  Product("Agua", fecha,upcValido, 5);

		assertEquals(p1.equals(p2),false);
	}
	@Test
	public void testProductoNoIgualProductoFecha() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		String date1 = "16/09/2021";
		LocalDate fecha = LocalDate.parse(date,formatter);
		LocalDate fecha1 = LocalDate.parse(date1,formatter);

		Product p1 = new  Product(nombre, fecha,upcValido, 5);
		Product p2 = new  Product(nombre, fecha1,upcValido, 5);

		assertEquals(p1.equals(p2),false);
	}
	@Test
	public void testProductoNoIgualProductoUpcValido() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);

		Product p1 = new  Product("nombre", fecha,upcValido, 5);
		Product p2 = new  Product(nombre, fecha,"123456789012", 5);
		
		assertEquals(p1.equals(p2),false);
	}
	@Test
	public void testProductoNoIgualProductoPrecio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		
		LocalDate fecha = LocalDate.parse(date,formatter);

		Product p1 = new  Product(nombre, fecha,upcValido, 5);
		Product p2 = new  Product(nombre, fecha,upcValido, 4);

		assertEquals(p1.equals(p2),false);
	}
	@Test
	public void testHashCode() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);
		Product p1 = new  Product(nombre, fecha,upcValido, 5);

		assertEquals(p1.hashCode(),1203379121);
	}
}
