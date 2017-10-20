package br.com.lojaonlinebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lojaonlinebackend.dao.CategoryDAO;
import br.com.lojaonlinebackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	//Listando todas as Categorias ativas
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	// Busca no banco uma categoria pelo código
	
	@Override
	public Category get(int id) {
		
		Category category = sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
		return category;
	}

	//Adiciona uma categoria à base de dados
	@Override
	public boolean add(Category category) {
		
		try {
			//adiciona a categoria ao banco de dados
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

}
