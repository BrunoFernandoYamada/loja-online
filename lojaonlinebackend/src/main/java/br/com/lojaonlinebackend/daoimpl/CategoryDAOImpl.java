package br.com.lojaonlinebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lojaonlinebackend.dao.CategoryDAO;
import br.com.lojaonlinebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		//adding the first category
		Category category = new Category();

		category.setId(1);
		category.setName("Televison");
		category.setDescription("This is some desciption for television");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		//second category
		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some desciption for Mobile");
		category.setImageURL("CAT_2.png");

		
		categories.add(category);

		//third category
		
		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some desciption for Laptop");
		category.setImageURL("CAT_3.png");

		
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category: categories) {
			
			if(category.getId() == id) return category;
		}
		
		return null;
	}

}
