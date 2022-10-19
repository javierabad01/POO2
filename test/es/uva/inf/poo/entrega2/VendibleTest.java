package es.uva.inf.poo.entrega2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;




public class VendibleTest {
	
	String upcValido="823880024474";
	String nombre="Patatas";
	String nombre2="Agua";
	String date = "16/08/2021";
	String formatoFecha="d/MM/yyyy";
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleNombreNullProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		new  Product(null, fecha, upcValido, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleIdNullProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		new  Product(nombre, fecha, null, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleNombreVacioProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		new  Product("", fecha, upcValido, precio);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleIdVacioProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		new  Product(nombre, fecha, "", precio);
	}
	@Test
	public void testVendibleCorrectoProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.getNombre(),nombre);
		assertEquals(p1.getId(),upcValido);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetNombreNullProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		Vendible p1=new  Product(nombre, fecha, upcValido, precio);
		p1.setNombre(null);
	}
	@Test
	public void testSetNombreCorrectoProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		Vendible p1=new  Product(nombre, fecha, upcValido, precio);
		p1.setNombre(nombre2);
		assertEquals(p1.getNombre(),nombre2);
	}
	@Test
	public void testGetNombreCorrectoProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		Vendible p1=new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.getNombre(),nombre);
	}
	@Test
	public void testGetIdCorrectoProducto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		double precio = 7.5;
		Vendible p1=new  Product(nombre, fecha, upcValido, precio);
		assertEquals(p1.getId(),upcValido);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleNombreNullPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);	
		new Pack(null,lista,"1");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleIdNullPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		new Pack(nombre,lista,null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleNombreVacioPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		new Pack("",lista,"1");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendibleIdVaciaPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		new Pack(nombre,lista,"");
	}
	@Test
	public void testVendibleCorrectoPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		Pack p=new Pack(nombre,lista,"1");
		assertEquals(p.getNombre(),nombre);
		assertEquals(p.getId(),"1");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetNombreNullPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		pack1.setNombre(null);
	}
	@Test
	public void testSetNombreCorrectoPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		pack1.setNombre("Pack2");
		assertEquals(pack1.getNombre(),"Pack2");
	}
	@Test
	public void testGetNombreCorrectoPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		assertEquals(pack1.getNombre(),nombre);
	}
	@Test
	public void testGetIdCorrectoPack() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
		LocalDate fecha = LocalDate.parse(date,formatter);		
		
		double precio = 7.5;
		Product p1=new  Product(nombre, fecha, upcValido, precio);
		Product p2=new Product(nombre2, fecha, upcValido, precio);
		List<Product> lista =new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		Pack pack1=new Pack(nombre,lista,"1");
		assertEquals(pack1.getId(),"1");
	}
	
	

}
