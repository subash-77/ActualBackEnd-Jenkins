package com.subash.api.service;

import java.util.List;

import com.subash.api.model.Jewellery;

public interface JewelleryService {

	public String addJewellery(Jewellery jewellery);

	public Jewellery getJewellery(int id);

	public List<Jewellery> getAllJewellery();

	public void updateJewellery(Jewellery jewellery);

	public void deleteJewellery(int id);
}
