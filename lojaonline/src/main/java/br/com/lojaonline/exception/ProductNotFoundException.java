/**
 * 
 */
package br.com.lojaonline.exception;

import java.io.Serializable;

/**
 * @author Bruno Fernando Yamada
 * 29 de out de 2017
 *	
 */
public class ProductNotFoundException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		this("Product is not available!");
	}

	/**
	 * @param string
	 */
	public ProductNotFoundException(String string) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	
	public String getMessage() {
		return message;
	}

}
