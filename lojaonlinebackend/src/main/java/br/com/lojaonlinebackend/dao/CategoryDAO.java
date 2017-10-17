package br.com.lojaonlinebackend.dao;

import java.util.List;

import br.com.lojaonlinebackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
	
}
