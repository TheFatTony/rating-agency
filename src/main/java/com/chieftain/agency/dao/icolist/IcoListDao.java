package com.chieftain.agency.dao.icolist;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.IcoList;

import java.util.List;

public interface IcoListDao extends Dao<IcoList, Long> {


    List<IcoList> findFirstRows();
}
