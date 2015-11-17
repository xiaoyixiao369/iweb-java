package io.github.igordonxiao.service.sys;

import io.github.igordonxiao.dao.sys.IGenericDao;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, PK extends Serializable> {

    /**
     * 返回genericDao
     * @return IGenericDao<T, PK>
     */
    IGenericDao<T, PK> getGenericDao();

    /**
     * 通过id加载po实例
     *
     * @param id
     * @return 实体对象
     */
    T load(PK id);

    /**
     * 通过id加载po实例
     *
     * @param id
     * @return 实体对象
     */
    T get(PK id);

    /**
     * 根据ID数组获取实体对象集合.
     *
     * @param ids
     * @return 实体对象集合
     */
    List<T> get(PK[] ids);

    /**
     * 根据属性名和属性值获取实体对象.
     *
     * @param propertyName
     * @param value
     * @return 实体对象
     */
    T get(String propertyName, Object value);


    /**
     * 根据属性名和属性值获取实体对象集合.
     *
     * @param propertyName
     * @param value
     * @return 实体对象集合
     */
    List<T> getList(String propertyName, Object value);

    /**
     * 获取所有实体对象总数.
     *
     * @return 实体对象总数
     */
    Integer getAllCount();


    /**
     * 保存实体对象.
     *
     * @param entity
     * @return ID
     */
    PK save(T entity);

    /**
     * 保存或更新一个对象
     *
     * @param entity
     */
    void saveOrUpdate(T entity);

    /**
     * 更新实体对象.
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 合并一个对象
     *
     * @param entity
     */
    void merge(T entity);

    /**
     * 删除实体对象.
     *
     * @param entity
     * @return
     */
    void delete(T entity);

    /**
     * 根据ID删除实体对象.
     *
     * @param id
     */
    void delete(PK id);

    /**
     * 根据ID数组删除实体对象.
     *
     * @param ids
     */
    void delete(PK[] ids);

    /**
     * 根据实体集合删除实体对象
     *
     * @param list
     */
    void delete(List<T> list);

    /**
     * 获取全部列表
     *
     * @return
     */
    List<T> list();
}
