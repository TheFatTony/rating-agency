package com.chieftain.agency.dao.files;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.Files;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaFilesDao extends JpaDao<Files, Long> implements FilesDao {
	public JpaFilesDao() {
		super(Files.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Files> findAll() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<Files> criteriaQuery = builder.createQuery(Files.class);

		Root<Files> root = criteriaQuery.from(Files.class);

		TypedQuery<Files> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public Files find(Long id) {

		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<Files> criteriaQuery = builder.createQuery(Files.class);

		Root<Files> root = criteriaQuery.from(Files.class);
		criteriaQuery.where(builder.equal(root.get("id"), id));

		TypedQuery<Files> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getSingleResult();

	}

}
