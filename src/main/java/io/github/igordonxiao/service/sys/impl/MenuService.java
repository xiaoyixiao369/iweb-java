package io.github.igordonxiao.service.sys.impl;

import io.github.igordonxiao.entity.sys.Menu;
import io.github.igordonxiao.helper.MenuComparator;
import io.github.igordonxiao.service.sys.IMenuService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gordon on 15/10/20.
 */
@Service("menuService")
public class MenuService extends GenericService<Menu, Long> implements IMenuService {
    @Override
    @Cacheable("menuCache")
    public List<Menu> getMenu() {
        return this.getList("level", 1).stream().sorted(new MenuComparator()).peek(menu -> {
            List<Menu> children = menu.getChildren();
            if (children != null && children.size() > 0) {
                menu.setChildren(children.stream().sorted(new MenuComparator()).collect(Collectors.toList()));
            }
        }).collect(Collectors.toList());
        //return this.getList("level", 1);
    }
}
