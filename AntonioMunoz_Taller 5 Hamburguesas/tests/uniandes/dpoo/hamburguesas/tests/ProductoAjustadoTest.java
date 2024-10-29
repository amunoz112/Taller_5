package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;


public class ProductoAjustadoTest 
{
    private ProductoMenu producto1;
    private Ingrediente ingrediente;
    private ProductoAjustado producto2;
    
    @BeforeEach
    void setUp() throws Exception
    {
        producto1 = new ProductoMenu( "Corral", 14000 );
        ingrediente = new Ingrediente("Carne", 4500);
    	producto2 = new ProductoAjustado(producto1);
    	producto2.agregarIngrediente(ingrediente);

    }

    @AfterEach
    void tearDown()
    {
    }
    
    @Test
    void testGetNombre()
    {
    	assertEquals("Corral",producto2.getNombre(),"No imprime el nombre correcto");
    }
    
    @Test
    void testGetPrecio() 
    {
    	assertEquals(18500,producto2.getPrecio(),"No imprime el precio corecto");
    }
    
    @Test
    void testFacturaAjustada ( ){
    	{
    		assertEquals("Corral\n"
    				+ "            14000\n"
    				+ "    +Carne                4500\n"
    				+ "            18500\n"
    				,producto2.generarTextoFactura(),"No imprime la factura correctamente");
    	}
    }
     

}
