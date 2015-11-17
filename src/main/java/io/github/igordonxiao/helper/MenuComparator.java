package io.github.igordonxiao.helper;

import io.github.igordonxiao.entity.sys.Menu;

import java.util.Comparator;

/**
 * Created by gordon on 15/10/23.
 */
public class MenuComparator implements Comparator<Menu> {
    @Override
    public int compare(Menu menu1, Menu menu2) {
        return menu1.getSequence() - menu2.getSequence();
    }
}
