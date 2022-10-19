package es.uva.inf.poo.entrega2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;



public class VendingSystemTest {

	@Test(expected=IllegalArgumentException.class)
	public void testListaNull() {
		new VendingSystem(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testListaArgumentosNull() {
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(null);
		new VendingSystem(listaSystem);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSedesIncorrecto() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(1,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		new VendingSystem(listaSystem);
	}
	@Test
	public void testVendingSystemCorrecto() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		new VendingSystem(listaSystem);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirSedeNull() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		VendingCity vc1=new VendingCity(1,lista);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		VendingSystem vs=new VendingSystem(listaSystem);
		vs.annadirSede(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnnadirSedeRepetida() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(1,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		VendingSystem vs=new VendingSystem(listaSystem);
		vs.annadirSede(vc2);
	}
	@Test
	public void testAnnadirSede() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		VendingSystem vs=new VendingSystem(listaSystem);
		vs.annadirSede(vc2);
	}
	@Test
	public void testEliminarSedePrimera() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		vs.eliminarSede(1);
	}
	@Test
	public void testEliminarSedeUltima() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		vs.eliminarSede(2);
	}
	@Test
	public void testNumeroMaquinasVending() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		assertEquals(vs.numeroMaquinasVending(1),2);
	}
	@Test
	public void testNumeroMaquinasVendingCero() {
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		assertEquals(vs.numeroMaquinasVending(2),0);
	}
	@Test
	public void testNumeroMaquinasVendingIdMal() {
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		assertEquals(vs.numeroMaquinasVending(3),0);
	}
	@Test
	public void testGetMaquinasVendingSede() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		VendingSystem vs=new VendingSystem(listaSystem);
		
		assertEquals(vs.getMaquinasVendingSede(1),lista);
	}
	@Test
	public void testGetMaquinasVendingSedeIdMal() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		ArrayList<VendingMachine> listaComprobar=new ArrayList<>();
		assertEquals(vs.getMaquinasVendingSede(3),listaComprobar);
	}
	@Test
	public void testGetMaquinasVendingSedeVacio() {
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		ArrayList<VendingMachine> listaComprobar=new ArrayList<>();
		assertEquals(vs.getMaquinasVendingSede(1),listaComprobar);
	}
	@Test
	public void testNumeroProvinciasGestionan() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		assertEquals(vs.numeroProvinciasGestionan(),2);
	}
	@Test
	public void testNumeroProvinciasGestionanCero() {
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		VendingSystem vs=new VendingSystem(listaSystem);
		assertEquals(vs.numeroProvinciasGestionan(),0);
	}
	@Test
	public void testGetProvinciasQueSeGestionan() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		ArrayList<String> listaComprobar= new ArrayList<>();
		listaComprobar.add("Vitoria");
		listaComprobar.add("Albacete");
		assertEquals(vs.getProvinciasQueSeGestionan(),listaComprobar);
	}
	@Test
	public void testGetProvinciasQueSeGestionanCero() {	
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		VendingSystem vs=new VendingSystem(listaSystem);
		ArrayList<String> listaComprobar= new ArrayList<>();
		assertEquals(vs.getProvinciasQueSeGestionan(),listaComprobar);
	}
	@Test
	public void testGetCantidadMaquinasPorProvincia() {
		VendingMachine v1=new VendingMachine(0,true,2,20);
		VendingMachine v2=new VendingMachine(1,true,2,20);
		ArrayList<VendingMachine> lista=new ArrayList<>();
		ArrayList<VendingMachine> lista2=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista2.add(v2);
		VendingCity vc1=new VendingCity(1,lista);
		VendingCity vc2=new VendingCity(2,lista2);
		
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		listaSystem.add(vc1);
		listaSystem.add(vc2);
		VendingSystem vs=new VendingSystem(listaSystem);
		HashMap<Integer,Integer> listaComprobar =new HashMap<>();
		listaComprobar.put(1,2);
		listaComprobar.put(2,1);
		assertEquals(vs.getCantidadMaquinasPorProvincia(),listaComprobar);
	}
	@Test
	public void testGetCantidadMaquinasPorProvinciaCero() {
		ArrayList<VendingCity> listaSystem=new ArrayList<>();
		VendingSystem vs=new VendingSystem(listaSystem);
		HashMap<Integer,Integer> listaComprobar =new HashMap<>();

		assertEquals(vs.getCantidadMaquinasPorProvincia(),listaComprobar);
	}
}
