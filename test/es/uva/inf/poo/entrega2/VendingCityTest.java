package es.uva.inf.poo.entrega2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;




public class VendingCityTest {
	
	String upcValido="823880024474";
	String nombre="Patatas";
	String nombre2="Agua";
	private LocalDate crearFechaPorDefecto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2021";
		return LocalDate.parse(date,formatter);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIdNegativo() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		new VendingCity(-1,lista); 
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIdCero() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		new VendingCity(0,lista); 
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIdMayor52() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		new VendingCity(53,lista); 
	}
	@Test(expected=IllegalArgumentException.class)
	public void testMaquinaNull() {
		new VendingCity(1,null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testArgumentosListaNull() {
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(null);
		new VendingCity(1,lista);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testVendingCityMaquinaRepetida() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v1);
		new VendingCity(1,lista);
	}
	@Test
	public void testVendingCityCorrecto() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.getId(),1);
		assertEquals(vc1.getMaquinas(),lista);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirMaquinaNull() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		VendingCity vc1=new VendingCity(1,lista);
		vc1.annadirMaquina(null);
	}
	@Test
	public void testAnnadirMaquinaCorrecta() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		VendingCity vc1=new VendingCity(1,lista);
		
		vc1.annadirMaquina(v2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirMaquinaRepetida() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		VendingCity vc1=new VendingCity(1,lista);
		VendingMachine v2=new VendingMachine(0,true,2,20);
		vc1.annadirMaquina(v2);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarMaquinasVacias() {
		ArrayList<VendingMachine> lista=new ArrayList<>();
		VendingCity vc1=new VendingCity(1,lista);
		vc1.eliminarMaquina(1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarMaquinasNoExiste() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		vc1.eliminarMaquina(2);
	}
	@Test
	public void testEliminarMaquinasCorrecto() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		vc1.eliminarMaquina(0);
	}
	@Test
	public void testGetMaquinas() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.getMaquinas(),lista);
	}
	@Test
	public void testGetMaquinasNoModifica() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		VendingMachine v3=new VendingMachine(2,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.getMaquinas(),lista);
		vc1.getMaquinas().add(v3);
		assertEquals(vc1.getMaquinas(),lista);
	}
	@Test
	public void testMaquinasOperativasCero() {
		VendingMachine v1=new VendingMachine(0,false,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.maquinasOperativas(),0);
	}
	@Test
	public void testMaquinasOperativasTodas() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.maquinasOperativas(),2);
	}
	@Test
	public void testMaquinasOperativas() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		VendingMachine v3=new VendingMachine(2,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		VendingCity vc1=new VendingCity(1,lista);
		assertEquals(vc1.maquinasOperativas(),2);
	}
	@Test
	public void testGetMaquinasOperativasCero() {
		VendingMachine v1=new VendingMachine(0,false,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		ArrayList<VendingMachine> listaOperativas=new ArrayList<>();
		assertEquals(vc1.getMaquinasOperativas(),listaOperativas);
	}
	@Test
	public void testGetMaquinasOperativasTodas() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		ArrayList<VendingMachine> listaOperativas=new ArrayList<>();
		listaOperativas.add(v1);
		listaOperativas.add(v2);
		assertEquals(vc1.getMaquinasOperativas(),listaOperativas);
	}
	@Test
	public void testGetMaquinasOperativas() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		VendingMachine v3=new VendingMachine(2,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		VendingCity vc1=new VendingCity(1,lista);
		ArrayList<VendingMachine> listaOperativas=new ArrayList<>();
		listaOperativas.add(v1);
		listaOperativas.add(v3);
		assertEquals(vc1.getMaquinasOperativas(),listaOperativas);
	}
	@Test
	public void testGetLineasVaciasCero() {
		Product p1 = new  Product(nombre, crearFechaPorDefecto(), upcValido, 10);
		Product p2 = new  Product(nombre2, crearFechaPorDefecto(), upcValido, 10);
		Linea l1=new Linea (0,p1,0,5);
		Linea l2=new Linea (1,p2,0,5);
		VendingMachine v1=new VendingMachine(0,true,2,20);
		v1.nuevaLinea(l1);
		v1.nuevaLinea(l2);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		v2.nuevaLinea(l1);
		v2.nuevaLinea(l2);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);

		ArrayList<VendingMachine> maquinasLineaVacias = new ArrayList<>();
		assertEquals(vc1.getMaquinasLineaVacia(),maquinasLineaVacias);
	}
	@Test
	public void testGetLineasVaciasTodas() {
		Product p1 = new  Product(nombre, crearFechaPorDefecto(), upcValido, 10);
		Product p2 = new  Product(nombre2, crearFechaPorDefecto(), upcValido, 10);
		Linea l1=new Linea (0,p1,0,0);
		Linea l2=new Linea (1,p2,0,5);
		VendingMachine v1=new VendingMachine(0,true,2,20);
		v1.nuevaLinea(l1);
		v1.nuevaLinea(l2);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		v2.nuevaLinea(l1);
		v2.nuevaLinea(l2);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);

		ArrayList<VendingMachine> listaLineaVacias = new ArrayList<>();
		listaLineaVacias.add(v1);
		listaLineaVacias.add(v2);
		assertEquals(vc1.getMaquinasLineaVacia(),listaLineaVacias);
	}
	@Test
	public void testGetLineasVacias() {
		Product p1 = new  Product(nombre, crearFechaPorDefecto(), upcValido, 10);
		Product p2 = new  Product(nombre2, crearFechaPorDefecto(), upcValido, 10);
		Linea l1=new Linea (0,p1,0,0);
		Linea l2=new Linea (1,p2,0,0);
		Linea l3=new Linea (0,p1,0,5);
		Linea l4=new Linea (1,p2,0,5);
		VendingMachine v1=new VendingMachine(0,true,2,20);
		v1.nuevaLinea(l1);
		v1.nuevaLinea(l2);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		v2.nuevaLinea(l3);
		v2.nuevaLinea(l4);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2); 
		VendingCity vc1=new VendingCity(1,lista);

		ArrayList<VendingMachine> listaLineaVacias = new ArrayList<>();
		listaLineaVacias.add(v1);
		assertEquals(vc1.getMaquinasLineaVacia(),listaLineaVacias);
	}
	@Test
	public void testGetId() {
		VendingMachine v1=new VendingMachine(0,false,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		
		assertEquals(vc1.getId(),1);
	}
	@Test
	public void testGetProvinciaPrimera() {
		VendingMachine v1=new VendingMachine(0,false,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		
		assertEquals(vc1.getProvincia(),"Vitoria");
	}
	@Test
	public void testGetProvinciaUltima() {
		VendingMachine v1=new VendingMachine(0,false,2,20);
		VendingMachine v2=new VendingMachine(1,false,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(52,lista);
		assertEquals(vc1.getProvincia(),"Melilla");
	}
	
 
}
