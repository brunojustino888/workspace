package cashflowmanagement.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cashflowmanagement.model.Cliente;
import cashflowmanagement.services.GestaoClientesService;

@SuppressWarnings("rawtypes")
@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value!=null) { 
			GestaoClientesService service = new GestaoClientesService();
			return service.buscarPorCodigo(new Integer(value)); 
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object cliente) {
		if (cliente != null) {
			Cliente clienteAux = (Cliente) cliente;
			return String.valueOf(clienteAux.getCod());
		}
		return null;
	}

}
