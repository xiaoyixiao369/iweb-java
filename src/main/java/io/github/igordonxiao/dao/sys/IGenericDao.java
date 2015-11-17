package io.github.igordonxiao.dao.sys;

import io.github.igordonxiao.bean.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, PK extends Serializable> {

    void setEntityClass(Class<T> entityClass);

    /**
     * 获取hibernate session对象
     *
     * @return
     */
    Session getSession();

    /**
     * 创建一个criteria
     *
     * @return
     */
    Criteria getCriteria();

    /**
     * 通过id加载实体
     *
     * @param id
     * @return 实体对象
     */
    T load(PK id);

    /**
     * 通过id加载实体
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
     * 根据DetachedCriteria获取对象
     *
     * @param criteria
     * @return
     */
    T get(DetachedCriteria criteria);

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
    Integer getCount();

    /**
     * 根据DetachedCriteria获取实体数量
     *
     * @param criteria
     * @return
     */
    Integer getCount(DetachedCriteria criteria);

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

    /**
     * 根据DetachedCriteria 获取列表
     *
     * @param criteria
     * @return
     */
    List<T> list(DetachedCriteria criteria);

    /**
     * 执行criteria查询获得一个结果
     *
     * @param criteria
     * @return
     */
    Object findObject(DetachedCriteria criteria);

    /**
     * DetachedCriteria分页查询
     *
     * @param criteria
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<T> page(DetachedCriteria criteria, Integer pageSize, Integer pageNumber);

    /**
     * 根据DetachedCriteria和Page对象获取分页page对象
     *
     * @param criteria
     * @param page
     * @return
     */
    Page<T> getPage(DetachedCriteria criteria, Page<T> page);
}