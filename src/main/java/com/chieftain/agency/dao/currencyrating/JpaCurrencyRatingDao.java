package com.chieftain.agency.dao.currencyrating;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.CurrencyRating;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class JpaCurrencyRatingDao extends JpaDao<CurrencyRating, Long> implements CurrencyRatingDao {
	public JpaCurrencyRatingDao() {
		super(CurrencyRating.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CurrencyRating> findAll() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<CurrencyRating> criteriaQuery = builder.createQuery(CurrencyRating.class);

		Root<CurrencyRating> root = criteriaQuery.from(CurrencyRating.class);

		TypedQuery<CurrencyRating> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(25);
		return typedQuery.getResultList();
	}


	@Override
	public List<CurrencyRating> findFirstRows() {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<CurrencyRating> criteriaQuery = builder.createQuery(CurrencyRating.class);

		Root<CurrencyRating> root = criteriaQuery.from(CurrencyRating.class);
		criteriaQuery.orderBy(builder.desc(root.get("marketCapUsd")));

		TypedQuery<CurrencyRating> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(5);
		return typedQuery.getResultList();
	}
}
