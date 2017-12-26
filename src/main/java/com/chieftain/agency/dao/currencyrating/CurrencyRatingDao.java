package com.chieftain.agency.dao.currencyrating;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.CurrencyRating;

import java.util.List;

public interface CurrencyRatingDao extends Dao<CurrencyRating, Long> {


    List<CurrencyRating> findFirstRows();

}
