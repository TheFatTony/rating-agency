package com.chieftain.agency.dao.accesstoken;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.AccessToken;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaAccessTokenDao extends JpaDao<AccessToken, Long> implements AccessTokenDao
{
    public JpaAccessTokenDao()
    {
        super(AccessToken.class);
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = NoResultException.class)
    public AccessToken findByToken(String accessTokenString)
    {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AccessToken> query = builder.createQuery(this.entityClass);
        Root<AccessToken> root = query.from(this.entityClass);
        query.where(builder.equal(root.get("token"), accessTokenString));

        try {
            return this.getEntityManager().createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
