package io.github.igordonxiao.service.sys;

import io.github.igordonxiao.entity.sys.User;
import io.github.igordonxiao.bean.Page;

public interface IUserService extends IGenericService<User, Long> {

    /**
     * 检查用户登录
     * @param user
     * @return User
     */
    User checkLogin(User user);

    /**
     * 获取用户的分页对象
     *
     * @param pageSize
     * @param nowPage
     * @return
     */
    Page<User> getUserPage(Integer pageSize, Integer nowPage);
}
