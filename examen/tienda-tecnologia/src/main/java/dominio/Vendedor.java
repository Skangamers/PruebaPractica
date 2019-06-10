package dominio;

import dominio.repositorio.RepositorioProducto;
import java.util.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    int bandera = 0;
    Producto prod;
    LocalDate fecha_in = LocalDate.now();
    LocalDate fecha_fin = LocalDate.now();
    double precio;
    String nombre;
    String regex;	
    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo){
    	
    		
    		Producto prueba = repositorioProducto.obtenerPorCodigo(codigo);
    			
    		GarantiaExtendida garantia = new GarantiaExtendida(prueba);
    		
    		System.out.print(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo));
    		if(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo) == prueba){
    			throw new NullPointerException("Este producto ya tiene garantía extendida");
    		}else{
    			Pattern patron = Pattern.compile("[AEIOU]{3}");
    			Matcher m = patron.matcher(codigo);
    			
    			if(m.matches()){
    				throw new NullPointerException("Este producto no cuenta con garantía extendida");
    			}else{   		
    		    		repositorioGarantia.agregar(garantia);
    		    		System.out.print(garantia.getProducto());
    			}
    		        			
    		}
    		        	
    }
 

    public boolean tieneGarantia(String codigo) {
        return false;
    }
    
    

}
