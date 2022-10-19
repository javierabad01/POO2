package es.uva.inf.poo.entrega2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.Test;



public class PackTest {
	
	String upcValido="823880024474";
	String nombre="Patatas";
	String nombre2="Agua";
	String date = "16/08/2021";
	String formatoFecha="d/MM/yyyy";
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testListaNull() {
		List<Product> lista =null;
		
		new Pack(nombre,lista,"2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testListaProductosMenor2() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		new Pack(nombre,lista,"2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testListaProductosArgumentoPrimeroNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(null);
		lista.add(p1);
		new Pack(nombre,lista,"2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testListaProductosArgumentoUltimoNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(null);
		new Pack(nombre,lista,"2");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testListaProductosRepetidos() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		new Pack(nombre,lista,"2");
	}
	@Test
	public void testPackCorrecto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack pa=new Pack(nombre,lista,"2");
		assertEquals(pa.getNombre(),nombre);
		assertEquals(pa.getPrecio(),(precio+precio)*0.8,0);
		assertEquals(pa.getListaProductos(),lista);
	}
	@Test
	public void testGetPrecio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		assertEquals(p.getPrecio(),(precio+precio)*0.8,0);
	}
	@Test
	public void testCantidadProductosPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		assertEquals(p.cantidadProductosPack(),2);
	}
	@Test
	public void testProductoIncluido() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		assertEquals(p.productoIncluido(upcValido),true);
	}
	@Test
	public void testProductoNoIncluido() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		assertEquals(p.productoIncluido("987345678432"),false);
	}
	@Test
	public void testGetListaProductos() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		assertEquals(p.getListaProductos(),lista);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirProductoNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		p.annadirProducto(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirProductoRepetido() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		p.annadirProducto(p1);
	}
	@Test
	public void testAnnadirProductoCorrecto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		Product p3=new  Product("Chocolate", fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"2");
		p.annadirProducto(p3);
		lista.add(p3);
		assertEquals(p.getListaProductos(),lista);
	}
	@Test
	public void testPackIgualNull() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		assertEquals(pack1.equals(null),false);		
	}
	@Test
	public void testPackIgualPackReferencia() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack pa1=new Pack(nombre,lista,"1");
		assertEquals(pa1.equals(pa1),true);
	}
	@Test
	public void testPackIgualPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack pa1=new Pack(nombre,lista,"1");
		Pack pa2=new Pack(nombre,lista,"1");
		assertEquals(pa1.equals(pa2),true);
	}
	@Test
	public void testPackNoIgualPackNombre() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack pa1=new Pack(nombre,lista,"1");
		Pack pa2=new Pack(nombre2,lista,"1");
		assertEquals(pa1.equals(pa2),false);
	}
	@Test
	public void testPackNoIgualPackId() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);

		Pack pa1=new Pack(nombre,lista,"1");
		Pack pa2=new Pack(nombre,lista,"2");
		assertEquals(pa1.equals(pa2),false);
	}
	@Test
	public void testPackNoIgualPackListaProductos() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		Product p3=new  Product("Chocolate", fecha, upcValido, precio);
		Product p4=new  Product("Leche", fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		List<Product> lista2 =new ArrayList<>();
		lista2.add(p3);
		lista2.add(p4);
		Pack pa1=new Pack(nombre,lista,"1");
		Pack pa2=new Pack(nombre,lista2,"1");
		assertEquals(pa1.equals(pa2),false);
	}
	@Test
	public void testPackNoIgualString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new  Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack pa1=new Pack(nombre,lista,"1");
		assertEquals(pa1.equals(nombre),false);
	}
	@Test
	public void testHashCode() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		
		assertEquals(pack1.hashCode(),-125601280);
	}
}
