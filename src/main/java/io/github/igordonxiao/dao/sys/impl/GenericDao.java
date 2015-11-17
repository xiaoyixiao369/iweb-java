package io.github.igordonxiao.dao.sys.impl;

import io.github.igordonxiao.bean.Page;
import io.github.igordonxiao.dao.sys.IGenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
@Repository
public abstract class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings({"unchecked"})
    public GenericDao() {
        this.entityClass = null;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Override
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Criteria getCriteria() {
        return getSession().createCriteria(entityClass);
    }

    @Override
    public T load(PK id) {
        return getSession().load(this.entityClass, id);
    }

    @Override
    public T get(PK id) {
        return getSession().get(this.entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> get(PK[] ids) {
        return getSession().createQuery("from " + entityClass.getName() + " as model where model.id in (:ids)").setParameterList("ids", ids).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(String propertyName, Object value) {
        return (T) getSession().createQuery("from " + entityClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).uniqueResult();
    }

    @Override
    public T get(DetachedCriteria criteria) {
        List<T> list = list(criteria);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getList(String propertyName, Object value) {
        return getSession().createQuery("from " + entityClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).list();
    }

    @Override
    public Integer getCount() {
        return Integer.parseInt(getCriteria().setProjection(Projections.rowCount()).uniqueResult().toString());
    }

    @Override
    public Integer getCount(DetachedCriteria criteria) {
        return Integer.parseInt(criteria.setProjection(Projections.rowCount()).getExecutableCriteria(getSession()).uniqueResult().toString());
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        return (PK) getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void merge(T entity) {
        getSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void delete(PK id) {
        getSession().delete(load(id));
    }

    @Override
    public void delete(PK[] ids) {
        for (PK id : ids) {
            delete(id);
        }
    }

    @Override
    public void delete(List<T> list) {
        if (list != null && !list.isEmpty()) {
            list.forEach(T -> {
                getSession().delete(T);
            });
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return getCriteria().list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> list(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(getSession()).list();
    }

    @Override
    public Object findObject(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> page(DetachedCriteria criteria, Integer pageSize, Integer pageNumber) {
        return criteria.getExecutableCriteria(getSession()).setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize).list();
    }

    @Override
    public Page<T> getPage(DetachedCriteria criteria, Page<T> page) {
        if (page.getKeyWords() != null && page.getProperty() != null && "".equals(page.getKeyWords().trim())) {
            criteria.add(Restrictions.like(page.getProperty(), page.getKeyWords(), page.getMatchMode()));
        }
        page.setTotalCount(getCount(criteria));
        criteria.setProjection(null);
        if (page.getOrderBy() != null) {
            if (page.getOrderType().equals(Page.OrderType.asc)) {
                criteria.addOrder(Order.asc(page.getOrderBy()));
            } else {
                criteria.addOrder(Order.desc(page.getOrderBy()));
            }
        }
        page.setList(page(criteria, page.getPageSize(), page.getNowPage()));
        return page;
    }
}