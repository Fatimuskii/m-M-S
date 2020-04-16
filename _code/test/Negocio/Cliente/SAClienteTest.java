package Negocio.Cliente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import Negocio.Cliente.imp.SAClienteImp;
import Negocio.Cliente.imp.TCliente;

public class SAClienteTest {
	private SAClienteImp saCliente;
	private TCliente tCliente1, tCliente2;
	private int cliente1;
	private int cliente2;
	
	public SAClienteTest(){
		this.saCliente = new SAClienteImp();
		this.tCliente1 = new TCliente("Pepe","640581239", "pepe@gmail.com", "25488776M", true);
		this.tCliente2 = new TCliente("Pepa","652144785", "pepa@gmail.com", "65877444S", true);
	}
	
	@Before
	public void testAltaCliente(){
		cliente1 = saCliente.altaCliente(tCliente1);
		assertTrue(cliente1 > 0);
		
		cliente2 = saCliente.altaCliente(tCliente2);
		assertTrue(cliente2 > 0);
		
		//cliente repetido
		int repetido = saCliente.altaCliente(tCliente1);
		assertTrue(repetido < 0);
	}
	
	
	@After
	public void testBajaCliente(){
		int baja;
		
		baja = saCliente.bajaCliente(cliente1);
		assertTrue(baja > 0);
		
		baja = saCliente.bajaCliente(cliente2);
		assertTrue(baja > 0);
		
		//cliente ya dado de baja
		baja = saCliente.bajaCliente(cliente1);
		assertTrue(baja < 0);
	}
	
	@Test
	public void testBuscarCliente(){
		TCliente buscar;
		
		buscar = saCliente.buscarCliente(cliente1);
		assertNotEquals(buscar, null);
		
		buscar = saCliente.buscarCliente(cliente2);
		assertNotEquals(buscar, null);
		
		//Busqueda de cliente no encontrado
		buscar = saCliente.buscarCliente(0);
		assertEquals(buscar, null);
	}
	
	@Test
	public void testModificarCliente(){
		int modificar;
		
		TCliente tCliente1 = saCliente.buscarCliente(cliente1);
		assertNotEquals(tCliente1, null);
		tCliente1.setNombre("Manolo");
		
		modificar = saCliente.modificarCliente(tCliente1);
		assertTrue(modificar > 0);
		
		//cliente dni repetido
		TCliente tCliente2 = saCliente.buscarCliente(cliente2);
		assertNotEquals(tCliente2, null);
		tCliente2.setDNI("25488776M");
		modificar = saCliente.modificarCliente(tCliente2);
		assertTrue(modificar < 0);
	}
	
	@Test
	public void testListarClientes(){
		ArrayList<TCliente> clientes = saCliente.listarCliente();
		assertNotEquals(clientes, null);
	}
	
	@Test
	public void testBuscarClientePorDNI(){
		tCliente1 = saCliente.buscarClienteDNI("65877444S");
		assertNotEquals(tCliente1, null);
	}
}
