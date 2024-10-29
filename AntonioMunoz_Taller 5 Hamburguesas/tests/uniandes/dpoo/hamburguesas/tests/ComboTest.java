
package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Combo;

public class ComboTest {
	
    private ProductoMenu producto1;
    private ProductoMenu producto2;
    private Combo combo;
    private ArrayList<ProductoMenu> listaCombo;
    @BeforeEach
    void setUp() throws Exception
    {
        producto1 = new ProductoMenu( "Corral", 14000 );
    	producto2 = new ProductoMenu("Papas Fritas", 5000);
    	listaCombo = new ArrayList<ProductoMenu>();
    	listaCombo.add(producto1);
    	listaCombo.add(producto2);
    	combo = new Combo("Combo Corral", 0.2,listaCombo);			
    }

    @AfterEach
    void tearDown()
    {
    }
    
    @Test
    void testGetNombreCombo()
    {
    	assertEquals("Combo Corral",combo.getNombre(),"El nombre del Combo no es el correcto");
    }
    
    @Test
    void testGetPrecioCombo()
    {
    	assertEquals(15200,combo.getPrecio(),"El precio del combo es incorrecto");
    }
    
    @Test
    void testGetFactura()
    {
    	assertEquals("Combo Combo Corral\n"
    			+ " Descuento: 0.2\n"
    			+ "            15200\n"
    			+ "",combo.generarTextoFactura(),"Genera la facrtura incorrectamente");
    }
}
