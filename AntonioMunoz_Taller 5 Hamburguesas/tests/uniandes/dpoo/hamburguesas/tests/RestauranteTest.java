package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;


public class RestauranteTest {

    private Restaurante restaurante1;
    @BeforeEach
    void setUp() throws Exception
    {
    	restaurante1 = new Restaurante();
    	restaurante1.cargarInformacionRestaurante(new File("data/ingredientes.txt"), new File("data/menu.txt"), new File("data/combos.txt"));
    	restaurante1.iniciarPedido("Julio Cesar", "02A");
    }

    @AfterEach
    void tearDown()
    {
    }
    
    @Test
    void testIniciarPedido () 
    {
    	
    	  try {
    	        restaurante1.iniciarPedido("Julio Cesar", "02A");
    	        
    	        fail("Se esperaba una Excepcion pero no se lanzó.");
    	    } catch (YaHayUnPedidoEnCursoException e) {
    	        assertEquals("Ya existe un pedido en curso, para el cliente Julio Cesar así que no se puede crear un pedido para Julio Cesar",
    	        		e.getMessage());
    	    }
    }
    
    @Test 
    void testCerrarYGuardar() throws IOException, NoHayPedidoEnCursoException
    {
  	  try {
	        restaurante1.cerrarYGuardarPedido();
	  } catch (NoHayPedidoEnCursoException e) {
	    	 fail("No esperaba una excepcion y la mando"); 
	  }	catch (IOException IO) {
		  fail("Existe algun error en  el archivo ");
		  }
  	  
  	  
  	assertNull(restaurante1.getPedidoEnCurso(),"Deberia haber guardado y borrado el pedido en curso");

    }
    
    @Test
    void testGetPedidoEnCurso()
    {
    	
    	assertNotNull(restaurante1.getPedidoEnCurso(),"El pedido en curso no es el mismo");
    }
    
    @Test
    void testGetPedidos() throws IOException, NoHayPedidoEnCursoException
    {
    	  try {
  	        restaurante1.cerrarYGuardarPedido();
  	  } catch (NoHayPedidoEnCursoException e) {
  	    	 fail("No esperaba una excepcion y la mando"); 
  	  }	catch (IOException IO) {
  		  fail("Existe algun error en  el archivo ");
  		  }
    	  
    assertNotEquals(new ArrayList<Pedido>(),restaurante1.getPedidos(),"Devuelve una lista vacia, cuando deberia tener un pedido");
    }
    
    @Test
    void testGetMenuBase()
    {
    	assertNotEquals(new ArrayList<ProductoMenu>(),restaurante1.getMenuBase(),"Devuelve una lista vacia, cuando deberia tener una serie de productos");
    }
    
    @Test 
    void testGetMenuCombos()
    {
    	assertNotEquals(new ArrayList<Combo>(),restaurante1.getMenuCombos(),"Devuelve una lista vacia, cuando deberia tener una serie de combos");

    }
    
    @Test
    void testGetIngredientes()
    {
    	assertNotEquals(new ArrayList<Ingrediente>(),restaurante1.getIngredientes(),"Devuelve una lista vacia, cuando deberia tener una serie de ingredientes");

    }
    

}
