package io.github.igordonxiao.dao.sys.impl;

import io.github.igordonxiao.dao.sys.IMenuDao;
import io.github.igordonxiao.entity.sys.Menu;
import org.springframework.stereotype.Repository;

/**
 * Created by gordon on 15/10/20.
 */
@Repository("menuDao")
public class MenuDao extends GenericDao<Menu, Long> implements IMenuDao {
}
