package com.subash.api.ownrepo;

import java.util.List;

import com.subash.api.model.Jewellery;

public interface JewelleryOwnRepo {
	public void save(Jewellery jewellery);

	public Jewellery findById(int id);

	public List<Jewellery> findAll();

	public void update(Jewellery jewellery);

	public void deleteById(int id);

}
