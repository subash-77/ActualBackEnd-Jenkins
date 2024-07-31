package com.subash.api.ownrepoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.subash.api.model.Sales;
import com.subash.api.ownrepo.SalesOwnRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SalesOwnRepoImpl implements SalesOwnRepo {

	public SalesOwnRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	EntityManager entityManager;

	@Override
	public void save(Sales sales) {
		entityManager.merge(sales);
	}

	@Override
	public Sales findById(int id) {
		return entityManager.find(Sales.class, id);
	}

	@Override
	public List<Sales> findAll() {
		return entityManager.createQuery("from Sales", Sales.class).getResultList();
	}

	@Override
	public void update(Sales sales) {
		entityManager.merge(sales);
	}

	@Override
	public void deleteById(int id) {
		Sales sales = entityManager.find(Sales.class, id);
		if (sales != null) {
			entityManager.remove(sales);
		}
	}

}
