package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest 
{
	    private ProductoMenu producto1;

	    @BeforeEach
	    void setUp() throws Exception
	    {
	        producto1 = new ProductoMenu( "Corral", 14000 );

	    }

	    @AfterEach
	    void tearDown()
	    {
	    }

	    @Test
	    public void testGetNombre()
	    {
	        assertEquals( "Corral", producto1.getNombre(), "El nombre del producto no es el esperado." );
	    }

	    @Test
	    public void testGetPrecio()
	    {
	        assertEquals( 14000, producto1.getPrecio( ), "El precio no coincide con el correcto" );

	    }
	    
	    @Test
	    public void testGetFactura()
	    {
	    	assertEquals("Corral\n"+"            14000\n",producto1.generarTextoFactura(),"No genera la factura correctamente");
	    }

	}


