package com.chieftain.agency.dao.icolist;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.IcoList;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;


public class JpaIcoListDao extends JpaDao<IcoList, Long> implements IcoListDao {
	public JpaIcoListDao() {
		super(IcoList.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IcoList> findAll() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<IcoList> criteriaQuery = builder.createQuery(IcoList.class);

		Root<IcoList> root = criteriaQuery.from(IcoList.class);

		TypedQuery<IcoList> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(25);
		return typedQuery.getResultList();
	}


	@Override
	public List<IcoList> findFirstRows() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<IcoList> criteriaQuery = builder.createQuery(IcoList.class);

		Root<IcoList> root = criteriaQuery.from(IcoList.class);
		criteriaQuery.where(builder.greaterThan(root.get("endTime"),  new Timestamp(System.currentTimeMillis())));
		criteriaQuery.orderBy(builder.asc(root.get("endTime")));

		TypedQuery<IcoList> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(5);
		return typedQuery.getResultList();
	}
}
