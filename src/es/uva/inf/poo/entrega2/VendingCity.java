package es.uva.inf.poo.entrega2;

import java.util.*;
/**
 * Clase que almacena toda la informacion relativa a VendingCity
 * 
 * @author javabad
 * @author alemina
 *
 */
public class VendingCity {
	
	private int id;
	private List<VendingMachine> maquinas;
	private static final String[] PROVINCIAS= {"Vitoria","Albacete","Alicante","Almería","Avila","Badajoz","Baleares, Islas","Barcelona",
			"Burgos","Cáceres","Cádiz","Castellón","Ciudad Real","Córdoba","Coruña, La","Cuenca","Gerona","Granada", 
			"Guadalajara","San Sebastian","Huelva","Huesca","Jaén","León","Lérida","Rioja, La","Lugo","Madrid","Malaga", 
			"Murcia","Navarra","Orense","Asturias","Palencia","Palmas, Las","Pontevedra","Salamanca","Santa Cruz de Tenerife","Cantabria", 
			"Segovia","Sevilla","Soria","Tarragona","Teruel","Toledo","Valencia","Valladolid","Bilbao","Zamora","Zaragora","Ceuta",
			"Melilla"};
	/**
	 * Inicializa una instancia de tipò VendingCity con el identificador de la provincia y una lista de maquinas como parámetro.
	 * @param id - identificador de una provincia.
	 * @param maquinas - Lista con maquinas a comprobar.
     * @throws IllegalArgumentException si {@code id<1}
     * @throws IllegalArgumentException si {@code id>52}
     * @throws IllegalArgumentException si {@code maquinas==null}
     * @throws IllegalArgumentException si {@code maquinas.get(j)==null} 
     * @throws IllegalArgumentException si {@code maquinas.get(i).getIdentificadorMaquina()==maquinas.get(j).getIdentificadorMaquina() && i!=j}
   	 */
	public VendingCity(int id,List<VendingMachine> maquinas ) {
		comprobarId(id);
		comprobarMaquinas(maquinas);
		this.id=id;
		this.maquinas = new ArrayList<>(maquinas);
		 
	}
	/**
	 * Comprueba que el identificador de la provincia sea correcto.
	 * @param id - identificador de una provincia.
	 */
	private static void comprobarId(int id) {
		if (id<1) {
			throw new IllegalArgumentException("Codigo erroneo: El identificador no puede ser menor que 1");
		}else if (id>52) {
			throw new IllegalArgumentException("Codigo erroneo: El identificador no puede ser mayor que 52");
		}
	}
	/**
	 * Comprueba que todas las maquinas de la lista no sean nulas.
	 * @param maquinas - Lista con maquinas a comprobar.
	 */
	private static void comprobarMaquinas(List<VendingMachine> maquinas) {
		if (maquinas==null) {
			throw new IllegalArgumentException("Codigo erroneo: Introduce una lista no null");
		}
		for(int i=0;i<maquinas.size();i++) {
			for(int j=0;j<maquinas.size();j++) {
				if (maquinas.get(j)==null) {
					throw new IllegalArgumentException("Codigo erroneo: Introduce una lista con parametros no null");
				}
				if(maquinas.get(i).getIdentificadorMaquina()==maquinas.get(j).getIdentificadorMaquina() && i!=j) {
					throw new IllegalArgumentException("Codigo erroneo: Introduce una lista con maquinas no repetidas");
				}
			}
		}
	}
	/**
     * Añade una nueva maquina vending al sistema.
     * @param m1 maquina que se añadirá.
     * @throws IllegalArgumentException si {@code maquinas.get(i).getIdentificadorMaquina()==m1.getIdentificadorMaquina()}
     */
    public void annadirMaquina(VendingMachine m1) {
    	if (m1==null) {
    		throw new IllegalArgumentException("Codigo erroneo: Introduce una maquina no null");
    	}
        for (int i=0;i<maquinas.size();i++) {
            if (maquinas.get(i).getIdentificadorMaquina()==m1.getIdentificadorMaquina()) {
                throw new IllegalArgumentException("Error: Ya existe esa maquina.");
            }
        }
        maquinas.add(m1);
    }
    /**
     * Elimina una maquina del sistema mediante su identificador.
     * @param identificador - Entero que identifica la maquina que se eliminará.
     * @throws IllegalArgumentException si {@code maquinas.isEmpty}
     * @throws IllegalArgumentException si {@code !existe}
     */
    public void eliminarMaquina(int identificador) {
        boolean existe=false;
        if (maquinas.isEmpty()) {
            throw new IllegalArgumentException("Errror: No existen maquinas para eliminar");
        } 
        for (int i=0;i<maquinas.size();i++) {
            if(maquinas.get(i).getIdentificadorMaquina()==(identificador)) {
                maquinas.remove(i);
                existe=true;
            }           
        }
        if (!existe) {
            throw new IllegalArgumentException("Error: No hay ninguna maquina con ese identificador");
        } 
    }
    /**
     * Obtiene una lista con todas las maquinas del sistema existentes
     * independientemente de su estado.
     * @return maquinas - Lista con todas las maquinas.
     */
    public List<VendingMachine> getMaquinas() {
        return new ArrayList<>(maquinas);
    }
    
    
    /**
     * Obtiene el numero de maquinas operativas del sistema.
     * @return entero con el numero de listas operativas.
     */
    public int maquinasOperativas() {
        int contador=0;
        for (int i=0;i<maquinas.size();i++) {
            if (maquinas.get(i).getEstado())
                contador++;
        }
        return contador;
    }
     
    /**
     * Obtiene una lista todas las maquinas operativas.
     * @return lista con las maquinas operativas.
     */
    public List<VendingMachine> getMaquinasOperativas() {
        ArrayList<VendingMachine> maquinasOperativas = new ArrayList<>();
        for (int i=0;i<maquinas.size();i++) {
            if (maquinas.get(i).getEstado()) {
                maquinasOperativas.add(maquinas.get(i));
            }
            	
        }
        return maquinasOperativas;
    }

    
    /**
     * Obtiene una lista que contenga todas las maquinas que tienen alguna linea vacia.
     * @return lista con las maquinas con lineas vacias.
     */
    public List<VendingMachine> getMaquinasLineaVacia() {
        ArrayList<VendingMachine> maquinasLineaVacias = new ArrayList<>();
        for (int i=0;i<getMaquinasOperativas().size();i++) {
            if (getMaquinasOperativas().get(i).getLineasVacias()>0) {
                maquinasLineaVacias.add(getMaquinasOperativas().get(i));
            }
        }
        return maquinasLineaVacias;
    }
    /**
     * Devuelve el entero al que corresponde un id
     * @return id - entero con el id 
     */
	public int getId() {
		return id;
	}
	/**
	 * Devuelve el nombre de la provincia.
	 * @return el nombre de la provincia.
	 */
	public String getProvincia() {
		return PROVINCIAS[id-1];
	}
}
