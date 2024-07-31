package com.subash.api.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subash.api.model.Jewellery;
import com.subash.api.ownrepo.JewelleryOwnRepo;
import com.subash.api.service.JewelleryService;

@Service
public class JewelleryServiceImpl implements JewelleryService {

	public JewelleryServiceImpl(JewelleryOwnRepo ownrepo) {
		super();
		this.ownrepo = ownrepo;
	}

	JewelleryOwnRepo ownrepo;

	@Override
	public String addJewellery(Jewellery jewellery) {
		if (jewellery != null) {
			ownrepo.save(jewellery);
			return "Add Success";
		} else {
			return "Add Failure";
		}

	}

	@Override
	public Jewellery getJewellery(int id) {
		return ownrepo.findById(id);
	}

	public List<Jewellery> getAllJewellery() {
		return ownrepo.findAll();
	}

	@Override
	public void updateJewellery(Jewellery jewellery) {
		ownrepo.update(jewellery);
	}

	@Override
	public void deleteJewellery(int id) {
		ownrepo.deleteById(id);
	}

}
