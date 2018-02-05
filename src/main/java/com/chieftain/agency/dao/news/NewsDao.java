package com.chieftain.agency.dao.news;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.News;

import java.util.List;

public interface NewsDao extends Dao<News, Long> {

	List<News> findAllByLang(String lang);

	List<News> findFirstByLang(String lang);

	List<News> findTopByLang(String lang);
}
