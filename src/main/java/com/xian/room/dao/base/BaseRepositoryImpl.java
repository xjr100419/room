package com.xian.room.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{

	private final EntityManager entityManager;
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	@Override
	public List<Object[]> listBySQL(String sql) {
		// TODO Auto-generated method stub
		return entityManager.createNativeQuery(sql).getResultList();
	}

}
