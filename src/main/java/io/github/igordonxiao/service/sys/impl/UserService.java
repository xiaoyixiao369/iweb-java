package io.github.igordonxiao.service.sys.impl;

import io.github.igordonxiao.bean.Page;
import io.github.igordonxiao.dao.sys.IUserDao;
import io.github.igordonxiao.entity.sys.User;
import io.github.igordonxiao.service.sys.IUserService;
import io.github.igordonxiao.util.PwdUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends GenericService<User, Long> implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public User checkLogin(User user) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("userName", user.getUserName())).add(Restrictions.eq("password", PwdUtil.md5(user.getPassword())));
        return (User)this.userDao.findObject(criteria);
    }

    @Override
    public Page<User> getUserPage(Integer pageSize, Integer nowPage) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        Page<User> page = new Page<User>();
        page.setOrderBy("id");
        page.setPageSize(pageSize);
        page.setNowPage(nowPage);
        return userDao.getPage(criteria, page);
    }
}
