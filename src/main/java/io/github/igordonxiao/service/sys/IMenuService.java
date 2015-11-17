package io.github.igordonxiao.service.sys;

import io.github.igordonxiao.entity.sys.Menu;

import java.util.List;

public interface IMenuService extends IGenericService<Menu, Long> {
    /**
     * 获取所有的菜单
     * @return List<Menu>
     */
    List<Menu> getMenu();
}
