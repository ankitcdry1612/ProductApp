package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	ProductDAO dao; // = new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(Product toBeCreated) {
		if(toBeCreated.getPrice() * toBeCreated.getQoh() >= 10000) {
			Product created = dao.save(toBeCreated);
			return created.getId();
		}else {
			throw new IllegalArgumentException("The product passed to create is not worth 10k");
		}
	}

	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		if(existing==null) {
			throw new IllegalArgumentException("Product with id " + id + " nnot found!");
		}
		if(existing.getPrice() * existing.getQoh() >= 100000) {
			throw new IllegalArgumentException("Can't delete product when stock >= 100k");
		}
		dao.deleteById(id);
	}
	
	public void changePrice(int id, float newPrice) {
		Product p = dao.findById(id);
		p.setPrice(newPrice);
	}
	
	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

}
