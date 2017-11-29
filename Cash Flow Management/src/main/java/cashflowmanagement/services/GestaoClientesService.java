package cashflowmanagement.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cashflowmanagement.model.Cliente;
 

public class GestaoClientesService {

	private static Map<Integer, Cliente> clientesMap = new HashMap<Integer, Cliente>();
	
	static {
		clientesMap.put(1, new Cliente());
		clientesMap.put(2, new Cliente());
		clientesMap.put(3, new Cliente());
	}
	
	public List<Cliente> buscarClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.addAll(GestaoClientesService.clientesMap.values());
		return listaClientes;
	}
	
	public Cliente buscarPorCodigo(Integer codigo) {
		return clientesMap.get(codigo);
	}
	
}