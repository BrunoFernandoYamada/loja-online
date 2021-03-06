package br.com.lojaonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lojaonline.exception.ProductNotFoundException;
import br.com.lojaonlinebackend.dao.CategoryDAO;
import br.com.lojaonlinebackend.dao.ProductDAO;
import br.com.lojaonlinebackend.dto.Category;
import br.com.lojaonlinebackend.dto.Product;




@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page"); 
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passando a lista de categorias 
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	
	@RequestMapping(value="/about")
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("page"); 
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact(){
		
		ModelAndView mv = new ModelAndView("page"); 
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
	}
	
	//Method to load all the products
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts(){
		
		ModelAndView mv = new ModelAndView("page"); 
		mv.addObject("title", "All Products");
		
		//passando a lista de categorias 
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		
		ModelAndView mv = new ModelAndView("page"); 
		
		// recebendo a categoria 
		Category category = null;
		category = categoryDAO.get(id);
			
		mv.addObject("title", category.getName());
		
		//retornando a categoria
		mv.addObject("category", category);
		
		//passando a lista de categorias 
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleproduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		//Atualizando os views do produto
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
	
	/*
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		if(greeting == null) {
			greeting = "Hello Guy";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView testPathVariable(@PathVariable("greeting")String greeting) {
	
		if(greeting == null) {
			greeting = "Hello Guy";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	*/
}
