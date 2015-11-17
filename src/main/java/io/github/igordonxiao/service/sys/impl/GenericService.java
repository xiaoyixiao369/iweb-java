package io.github.igordonxiao.service.sys.impl;

import io.github.igordonxiao.dao.sys.IGenericDao;
import io.github.igordonxiao.service.sys.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("genericService")
public abstract class GenericService<T, PK extends Serializable> implements IGenericService<T, PK> {
    @Autowired
    private IGenericDao<T, PK> genericDao;

    @Override
    public IGenericDao<T, PK> getGenericDao() {
        return genericDao;
    }

    @Override
    public T load(PK id) {
        return this.genericDao.load(id);
    }

    @Override
    public T get(PK id) {
        return this.genericDao.get(id);
    }

    @Override
    public List<T> get(PK[] ids) {
        return this.genericDao.get(ids);
    }

    @Override
    public T get(String propertyName, Object value) {
        return this.genericDao.get(propertyName, value);
    }

    @Override
    public List<T> getList(String propertyName, Object value) {
        return this.genericDao.getList(propertyName, value);
    }

    @Override
    public Integer getAllCount() {
        return this.genericDao.getCount();
    }

    @Override
    public PK save(T entity) {
        return this.genericDao.save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        this.genericDao.saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        this.genericDao.update(entity);
    }

    @Override
    public void merge(T entity) {
        this.genericDao.merge(entity);
    }

    @Override
    public void delete(T entity) {
        this.genericDao.delete(entity);
    }

    @Override
    public void delete(PK id) {
        this.genericDao.delete(id);
    }

    @Override
    public void delete(PK[] ids) {
        this.genericDao.delete(ids);
    }

    @Override
    public void delete(List<T> list) {
        this.genericDao.delete(list);
    }

    @Override
    public List<T> list() {
        return this.genericDao.list();
    }

}
