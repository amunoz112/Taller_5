package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Pedido;


public class PedidoTest {
	private Pedido pedido1;
    private Pedido pedido2;
    private ProductoMenu producto1;
    private ProductoMenu producto2;
    private Combo combo;
    private ArrayList<ProductoMenu> listaCombo;
    
    
    @BeforeEach
    void setUp() throws Exception
    {
    	pedido1 = new Pedido("Juan Pablo","01A");
    	pedido2 = new Pedido("Julio Cesar", "01B");
        producto1 = new ProductoMenu( "Corral", 14000 );
    	producto2 = new ProductoMenu("Papas Fritas", 5000);
    	listaCombo = new ArrayList<ProductoMenu>();
    	listaCombo.add(producto1);
    	listaCombo.add(producto2);
    	combo = new Combo("Combo Corral", 0.2,listaCombo);			
    	
    	pedido1.agregarProducto(combo);

    }

    @AfterEach
    void tearDown() throws Exception
    {
    }
    
    @Test
    void testGetIdPedido()
    {
    
    	assertEquals(0,pedido1.getIdPedido(),"El ID asignado es incorrecto");
    	assertEquals(1,pedido1.getIdPedido(),"El ID asignado es incorrecto");

    }
    
    @Test
    void testGetNombreCliente()
    {
    	assertEquals("Juan Pablo",pedido1.getNombreCliente(),"El nombre del cliente es incorrecto");
    }
    
    @Test
    void testAgregarProducto()
    {
    }
    
    @Test 
    void testPrecioNetoPedido()
    {
    	assertEquals(15200,pedido1.getPrecioNetoPedido(),"El precio neto asignado es incorrecto");
    }

    @Test 
    void testPrecioTotalPedido()
    {
    	assertEquals(18088,pedido1.getPrecioTotalPedido(),"El precio total asignado es incorrecto");

    }
    
    @Test
    void testPrecioIVAPedido()
    {
    	assertEquals(2888,pedido1.getPrecioIVAPedido(),"El precio del IVA asignado es incorrecto");

    }
    
    @Test
    void testGenerarTextoFactura()
    {
    	assertEquals("Cliente: Juan Pablo\n"
    			+ "Dirección: 01A\n"
    			+ "----------------\n"
    			+ "Combo Combo Corral\n"
    			+ " Descuento: 0.2\n"
    			+ "            15200\n"
    			+ "----------------\n"
    			+ "Precio Neto:  15200\n"
    			+ "IVA:          2888\n"
    			+ "Precio Total: 18088"
    			+ "\n"
    			+ ""    			,pedido1.generarTextoFactura(),"El texto de factura es incorrecto");
    }


	@Test
	void testGuardarFactura()
		{
		File archivoPrueba = new File("factura_test.txt");
		 try {
	            pedido1.guardarFactura(archivoPrueba);

	            assertTrue(archivoPrueba.exists(), "El archivo de la factura debería haberse creado.");


	            assertTrue(archivoPrueba.length() > 0, "El archivo de la factura no debería estar vacío.");
	        } catch (FileNotFoundException e) {
	            fail("No se debería lanzar FileNotFoundException: " + e.getMessage());

	    }
		}
	
}
	
