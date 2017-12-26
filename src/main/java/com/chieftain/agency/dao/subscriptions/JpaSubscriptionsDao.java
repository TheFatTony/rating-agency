package com.chieftain.agency.dao.subscriptions;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.Subscriptions;

public class JpaSubscriptionsDao extends JpaDao<Subscriptions, Long> implements SubscriptionsDao {
    public JpaSubscriptionsDao() {
        super(Subscriptions.class);
    }


}
