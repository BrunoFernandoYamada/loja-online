/**
 * 
 */
package br.com.lojaonline.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.lojaonlinebackend.dto.Product;

/**
 * @author Bruno Fernando Yamada
 * 7 de nov de 2017
 *	
 */
public class ProductValidator implements Validator{

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		if(product.getFile() == null || 
				product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Selecione uma imagem para carregar!");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif")	
		)){
		
			errors.rejectValue("file", null, "Selecione um tipo de imagem válido (jpeg/png/gif)");
		}
		// TODO Auto-generated method stub
		
	}

}
