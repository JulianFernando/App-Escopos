package br.com.julianfernando.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.julianfernando.modelo.Telefone;

@FacesValidator("br.com.julianfernando.ValidadorDeNumero")
public class ValidadorDeNumeroTelefone implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		FacesMessage messages = null;

		if (value == null || "".equals(value)) {
			messages = new FacesMessage("número não pode ser nulo.");
			messages.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, messages);
			context.renderResponse();
		} else {
			Telefone telefone = (Telefone)value;
			value = telefone.getNumeroTelefone();
			if (!Pattern.matches("[0-9]+", value.toString())) {
				messages = new FacesMessage("Número inválido.");
				messages.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, messages);
				context.renderResponse();
			}
		}
	}
}
