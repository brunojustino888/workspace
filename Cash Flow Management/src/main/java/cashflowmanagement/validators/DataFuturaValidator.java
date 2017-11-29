package cashflowmanagement.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("rawtypes")
@FacesValidator("datafuturaValidator")
public class DataFuturaValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {

		Boolean atributoTela = (Boolean) component.getAttributes().get("quitado");

		if (atributoTela != null && atributoTela) {
			
			Date dataDaTela = (Date) object;
			System.out.println("Data: "+dataDaTela);		
						
			System.out.println("Data Futura: "+dataDaTela.after(new Date()));
			
			if (dataDaTela.after(new Date())) {
				String label = " O campo \"Data de pagamento\" não pode conter uma data do futuro.";
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, label, label);
				throw new ValidatorException(mensagem);
			}

		}

	}

}