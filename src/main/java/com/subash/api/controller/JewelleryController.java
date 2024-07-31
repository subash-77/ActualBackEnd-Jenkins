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

import com.subash.api.model.Jewellery;
import com.subash.api.serviceimpl.JewelleryServiceImpl;

@RestController
@RequestMapping("/jewellery")
//@CrossOrigin("http://localhost:1225")
@CrossOrigin("*")
public class JewelleryController {

	JewelleryServiceImpl service;

	public JewelleryController(JewelleryServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertJewellery(@RequestBody Jewellery jewellery) {
		String msg = "";

		try {
			service.addJewellery(jewellery);
			msg += "addSuccess";

		} catch (Exception e) {
			msg += "addFailure";
		}
		return msg;

	}

	@PutMapping
	public String updateJewellery(@RequestBody Jewellery jewellery) {
		String msg = "";

		try {

			service.updateJewellery(jewellery);
			msg += "updateSuccess";

		} catch (Exception e) {
			msg += "updateFailure";
		}
		return msg;
	}

	@GetMapping("{id}")
	public Jewellery getJewelleryById(@PathVariable("id") int id) {
		return service.getJewellery(id);
	}

	@GetMapping("/all")
	public List<Jewellery> getJewellery() {
		return service.getAllJewellery();
	}

	@DeleteMapping("{id}")
	public String deleteFirById(@PathVariable("id") int id) {
		String msg = "";

		try {

			service.deleteJewellery(id);
			msg += "deleteSuccess";

		} catch (Exception e) {
			msg += "deleteFailure";
		}
		return msg;

	}
}
