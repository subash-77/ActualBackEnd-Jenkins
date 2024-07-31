package com.subash.api.ownrepoimpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.subash.api.model.Jewellery;
import com.subash.api.ownrepo.JewelleryOwnRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JewelleryOwnRepoImpl implements JewelleryOwnRepo {

	EntityManager entityManager;

	public JewelleryOwnRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void save(Jewellery jewellery) {
		entityManager.merge(jewellery);
	}

	@Override
	public Jewellery findById(int id) {
		return entityManager.find(Jewellery.class, id);
	}

	@Override
	public List<Jewellery> findAll() {
		return entityManager.createQuery("from Jewellery", Jewellery.class).getResultList();
	}

	@Override
	public void update(Jewellery jewellery) {
		entityManager.merge(jewellery);
	}

	@Override
	public void deleteById(int id) {
		Jewellery jewellery = entityManager.find(Jewellery.class, id);
		if (jewellery != null) {
			entityManager.remove(jewellery);
		}
	}

}
