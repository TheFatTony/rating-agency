package com.chieftain.agency.dao.news;

import java.util.List;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.News;

public interface NewsDao extends Dao<News, Long> {

	List<News> findAllByLang(String lang);

	List<News> findFirstByLang(String lang);

	List<News> findTopByLang(String lang);
}
