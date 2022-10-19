package es.uva.inf.poo.entrega2;

import java.util.*;

/**
 * Clase que almacena toda la informacion relativa a un sistema de vending.
 * 
 * @author javabad
 * @author alemina
 *
 */
public class VendingSystem {
 
	private ArrayList<VendingCity> sedes;
	
	/**
	 * Inicializacion del sistema mediante una lista de sedes 
	 * @param sedes - lista que contiene sedes
	 * @throws IllegalArgumentException {@code sedes==null} 
	 * @throws IllegalArgumentException {@code sedes.get(j)==null} 
	 * @throws IllegalArgumentException {@code sedes.get(i).getId()==sedes.get(j).getId() && i!=j} 
	 */
	public VendingSystem(List<VendingCity> sedes) {
		comprobarLista(sedes);
		comprobarSedesCorrecto(sedes);
		this.sedes=new ArrayList<>(sedes);
	}
	/**
	 * Comprueba que no haya sedes repetidas.
	 * @param sedes - lista que contiene sedes
	 * 
	 */
	private static void comprobarSedesCorrecto(List<VendingCity> sedes) {
		for(int i=0;i<sedes.size();i++) {
			for(int j=0;j<sedes.size();j++) {
				if(sedes.get(i).getId()==sedes.get(j).getId() && i!=j){
					throw new IllegalArgumentException("Codigo erroneo: No puede haber sedes repetidas");
				}
			}	
		}
	}
	/**
	 * Comprueba que las sedes son correctas.
	 * @param sedes - lista que contiene sedes
	 */
	private static void comprobarLista(List<VendingCity> sedes) {
		if (sedes==null) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce una lista no null");
		}else{
			for(int j=0;j<sedes.size();j++) {
				if (sedes.get(j)==null) {
					throw new IllegalArgumentException("Codigo erroneo: Introduce una lista con parametros no null");	
				}
			}
		}
	}
	
	/**
	 * Añade una nueva sede.
	 * @param sede - sede de tipo VendingCity
	 */
	public void annadirSede(VendingCity sede) {
		if(sede==null) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce una sede no null");
		}
		sedes.add(sede);
		comprobarSedesCorrecto(sedes);	
	}
	/** 
	 * Elimina una sede a partir de su identificador.
	 * @param id - identificador de una sede
	 */
	public void eliminarSede(int id) {
		for(int i=0;i<sedes.size();i++) {
			if(sedes.get(i).getId()==id) {
				sedes.remove(i);
			}
		}
	}
	/**
	 * Devuelve el numero de maquinas vending que contiene una sede a partir de su identificador.
	 * @param id - identificador de una sede
	 * @return entero con el numero de maquinas vending
	 */
	public int numeroMaquinasVending(int id) {
		for(int i=0;i<sedes.size();i++) {
			if(sedes.get(i).getId()==id) {
				return sedes.get(i).getMaquinas().size();
			}
		}
		return 0; 
	}
	/**
	 * Devuelve una lista con las maquinas vending de una sede.
	 * @param id - identificador de una sede
	 * @return lista con las maquinas vending
	 */
	public List<VendingMachine> getMaquinasVendingSede(int id) {
		for(int i=0;i<sedes.size();i++) {
			if(sedes.get(i).getId()==id) {
				return sedes.get(i).getMaquinas();
			}
		}
		return new ArrayList<>();
	}
	/**
	 * Devuelve el numero de provincias que se gestionan en el sistema.
	 * @return entero con el numero de provincias que se gestionan.
	 */
	public int numeroProvinciasGestionan() {
		return sedes.size();
	}
	/**
	 * Devuelve una lista con los nombres de todas las provincias donde hay una sede.
	 * @return provincias - lista con las provincias
	 */
	public List<String> getProvinciasQueSeGestionan(){
		List<String> provincias =new ArrayList<>();
		for(int i=0;i<sedes.size();i++) {
			provincias.add(sedes.get(i).getProvincia());
		}
		return provincias;
	}
	/**
	 * Obtiene una lista de la cantidad de maquinas vending que se gestionan en cada una de las provincias.
	 * @return cantidad - mapa que contiene asociado para cada provincia el numero de máquinas vending que gestiona
	 */
	public Map<Integer,Integer> getCantidadMaquinasPorProvincia(){
		HashMap<Integer,Integer> cantidad =new HashMap<>();
		for(int i=0;i<sedes.size();i++) {
			cantidad.put(sedes.get(i).getId(),sedes.get(i).getMaquinas().size() );
		}
		return cantidad;
	}
}