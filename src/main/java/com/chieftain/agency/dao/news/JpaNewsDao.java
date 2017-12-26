package com.chieftain.agency.dao.news;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.News;

public class JpaNewsDao extends JpaDao<News, Long> implements NewsDao {
    public JpaNewsDao() {
        super(News.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findAll() {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);

        Root<News> root = criteriaQuery.from(News.class);

        TypedQuery<News> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> findAllByLang(String lang) {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);

        Root<News> root = criteriaQuery.from(News.class);
        Predicate p1 = builder.and(builder.equal(root.get("language"), lang));
        Predicate p2 = builder.and(builder.equal(root.get("published"), true));

        criteriaQuery.where(p1, p2);
        criteriaQuery.orderBy(builder.desc(root.get("publishDate")));

        TypedQuery<News> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        typedQuery.setMaxResults(10);
        return typedQuery.getResultList();
    }

    @Override
    public List<News> findFirstByLang(String lang) {
        return getFirstRows(lang, 1);
    }

    @Override
    public List<News> findTopByLang(String lang) {
        return getFirstRows(lang, 5);
    }

    private List<News> getFirstRows(String lang, int rowCount) {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);

        Root<News> root = criteriaQuery.from(News.class);
        Predicate p1 = builder.and(builder.equal(root.get("language"), lang));
        Predicate p2 = builder.and(builder.equal(root.get("published"), true));

        criteriaQuery.where(p1, p2);
        criteriaQuery.orderBy(builder.desc(root.get("publishDate")));

        TypedQuery<News> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        typedQuery.setMaxResults(rowCount);
        return typedQuery.getResultList();
    }

}
