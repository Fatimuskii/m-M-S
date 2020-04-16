package Negocio.Producto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Negocio.Producto.imp.SAProductoImp;
import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
import Negocio.Producto.imp.TProducto;
import Negocio.Producto.imp.Tipo;

public class SAProductoTest {
	private SAProductoImp saProducto;
	private TJuegoDeMesa tJuego1, tJuego2;
	private TMerchandising tMerchandising1, tMerchandising2;

	private int resJuego1;
	private int resJuego2;
	private int resMerch1;
	private int resMerch2;
	
	public SAProductoTest(){
		this.saProducto = new SAProductoImp();
		this.tJuego1 = new TJuegoDeMesa("Parchís", 20, 100, true, 7, 4);
		this.tJuego2 = new TJuegoDeMesa("Conecta 4", 20, 100, true, 7, 4);
		this.tMerchandising1 = new TMerchandising("Taza", 5, 10, true, Tipo.FIGURA);
		this.tMerchandising2 = new TMerchandising("Premio", 5, 10, true, Tipo.FIGURA);
	}
	
	@Before
	public void testAltaProducto() {
		resJuego1 = saProducto.altaProducto(tJuego1);
		assertTrue(resJuego1 > 0);
		
		resJuego2 = saProducto.altaProducto(tJuego2);
		assertTrue(resJuego2 > 0);
		
		resMerch1 = saProducto.altaProducto(tMerchandising1);
		assertTrue(resMerch1 > 0);
		
		resMerch2 = saProducto.altaProducto(tMerchandising2);
		assertTrue(resMerch2 > 0);
		
		//Producto repetido
		int repetido = saProducto.altaProducto(tJuego1);
		assertTrue(repetido < 0);
		
	}

	
	@After
	public void testBajaProducto() {
		int resBaja;
		
		resBaja = saProducto.bajaProducto(resJuego1);
		assertTrue(resBaja > 0);
		
		resBaja = saProducto.bajaProducto(resJuego2);
		assertTrue(resBaja > 0);
		
		resBaja = saProducto.bajaProducto(resMerch1);
		assertTrue(resBaja > 0);
		
		resBaja = saProducto.bajaProducto(resMerch2);
		assertTrue(resBaja > 0);
		
		//Producto ya dado de baja
		resBaja = saProducto.bajaProducto(resJuego1);
		assertTrue(resBaja < 0);
	}


	@Test
	public void testBuscarProducto() {
		TProducto buscar; 
		
		buscar = saProducto.buscarProducto(resJuego1);
		assertNotEquals(buscar, null);
		
		buscar = saProducto.buscarProducto(resJuego2);
		assertNotEquals(buscar, null);
		
		buscar = saProducto.buscarProducto(resMerch1);
		assertNotEquals(buscar, null);
		
		buscar = saProducto.buscarProducto(resMerch2);
		assertNotEquals(buscar, null);
		
		//Busqueda producto no encontrado
		buscar = saProducto.buscarProducto(0);
		assertEquals(buscar, null);

	}

	@Test
	public void testModificarProducto() {
		int modificar; 
		
		TProducto tJuego1 = saProducto.buscarProducto(resJuego1);
		assertNotEquals(tJuego1, null);
		tJuego1.setPrecio(25);
		modificar = saProducto.modificarProducto(tJuego1);
		assertTrue(modificar > 0);
		
		//Producto nombre repetido
		TProducto tJuego2 = saProducto.buscarProducto(resJuego2);
		assertNotEquals(tJuego2, null);
		tJuego2.setNombre("Parchis");
		modificar = saProducto.modificarProducto(tJuego2);
		assertTrue(modificar < 0);
	}

	@Test
	public void testListarProductos() {

		ArrayList<TProducto> productos = this.saProducto.listarProductos();

		assertNotEquals(productos, null);
		
	}

	@Test
	public void testBuscarProductoPorPrecio() {
		ArrayList<TProducto> productos = this.saProducto.buscarProductosporPrecio(20);

		assertNotEquals(productos, null);
	}

}
