/**
 * 
 */
package br.com.lojaonline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.lojaonline.util.FileUploadUtility;
import br.com.lojaonline.validator.ProductValidator;
import br.com.lojaonlinebackend.dao.CategoryDAO;
import br.com.lojaonlinebackend.dao.ProductDAO;
import br.com.lojaonlinebackend.dto.Category;
import br.com.lojaonlinebackend.dto.Product;

/**
 * @author Bruno Fernando Yamada 2 de nov de 2017
 * 
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "ManageProducts");

		Product nproduct = new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);

		mv.addObject("product", nproduct);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "O Produto foi salvo com sucesso!");
			}
		}

		return mv;
	}

	// handing product subission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		new ProductValidator().validate(mProduct, results);

		// check if there are any errors
		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "ManageProducts");
			model.addAttribute("message", "Validação falhou, dados incorretos ou não válidos!");
			return "page";
		}

		logger.info(mProduct.toString());

		productDAO.add(mProduct);

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// recebendo produto da base de dados
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		//ativando e desativando o produto baseado no valor atual do campo
		product.setActive(!product.isActive());
		//atualizando o produto com o novo valor
		productDAO.update(product);
		
		return (isActive)? "Você desativou o produto com id "+ product.getId() : "Você ativou o produto com id "+ product.getId();
	}

	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}

}
