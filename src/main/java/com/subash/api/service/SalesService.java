package com.subash.api.service;

import java.util.List;

import com.subash.api.model.Sales;

public interface SalesService {
	public void addSales(Sales sales);

	public Sales getSales(int id);

	public List<Sales> getAllSales();

	public void updateSales(Sales sales);

	public void deleteSales(int id);
}
