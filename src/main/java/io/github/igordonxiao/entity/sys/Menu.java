package io.github.igordonxiao.entity.sys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 15/10/20.
 */
@Entity
@Table(name="sys_menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 292874408169044L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
     * 名称
     */
    @Column(name="name", nullable = false)
    private String name;
    /**
     * 图标,支持Font Awesome
     */
    @Column(name = "icon_class")
    private String iconClass;
    /**
     * 菜单链接
     */
    @Column(name = "href")
    private String href;

    /**
     * 菜单级别
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 排序
     */
    @Column(name = "sequence")
    private Integer sequence;

    /**
     * 父级菜单
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    /**
     * 子菜单
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Menu> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
