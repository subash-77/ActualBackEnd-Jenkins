package com.subash.api.ownrepo;

import java.util.List;

import com.subash.api.model.Sales;

public interface SalesOwnRepo {
	public void save(Sales sales);

	public Sales findById(int id);

	public List<Sales> findAll();

	public void update(Sales sales);

	public void deleteById(int id);
}
