package io.github.igordonxiao.dao.sys.impl;

import io.github.igordonxiao.dao.sys.IUserDao;
import io.github.igordonxiao.entity.sys.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends GenericDao<User, Long> implements IUserDao {

}
