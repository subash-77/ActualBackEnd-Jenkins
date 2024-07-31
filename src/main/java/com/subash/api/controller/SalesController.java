package com.subash.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subash.api.model.Sales;
import com.subash.api.serviceimpl.SalesServiceImpl;

@RestController
@RequestMapping("/sales")
//@CrossOrigin("http://localhost:1225")
@CrossOrigin("*")
public class SalesController {

	public SalesController(SalesServiceImpl service) {
		super();
		this.service = service;
	}

	SalesServiceImpl service;

	@PostMapping
	public String insertSales(@RequestBody Sales sales) {
		String msg = "";

		try {

			service.addSales(sales);
			msg += "addSuccess";

		} catch (Exception e) {
			msg += "addFailure";
		}
		return msg;
	}

	@PutMapping
	public String updateSales(@RequestBody Sales sales) {
		String msg = "";

		try {

			service.updateSales(sales);
			msg += "updateSuccess";

		} catch (Exception e) {
			msg += "updateFailure";
		}
		return msg;
	}

	@GetMapping("{id}")
	public Sales getSalesById(@PathVariable("id") int id) {
		return service.getSales(id);
	}

	@GetMapping("/all")
	public List<Sales> getSales() {
		return service.getAllSales();
	}

	@DeleteMapping("{id}")
	public String deleteSalesById(@PathVariable("id") int id) {
		String msg = "";

		try {

			service.deleteSales(id);
			msg += "deleteSuccess";

		} catch (Exception e) {
			msg += "deleteFailure";
		}
		return msg;

	}
}
