package com.shildon.treehole.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.shildon.treehole.dao.BaseMapper;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 24, 2016
 */
@Service
public abstract class BaseService<M, D extends BaseMapper<M>> {

	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	public D getMapper() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.getMapper(getMapperType());
	}
	
	@SuppressWarnings("unchecked")
	public Class<M> getEntityType() {
		return (Class<M>) ((ParameterizedType) getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public Class<D> getMapperType() {
		return (Class<D>) ((ParameterizedType) getClass().
				getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public boolean insert(M model) {
		BaseMapper<M> baseMapper = getMapper();
		
		try {
			baseMapper.insert(model);
		} catch (Exception e) {
			log.error("insert model to db failed.", e);
			return false;
		}
		return true;
	}
	
	public boolean delete(Serializable id) {
		BaseMapper<M> baseMapper = getMapper();
		
		try {
			baseMapper.delete(id);
		} catch (Exception e) {
			log.error("delete model from db failed.", e);
			return false;
		}
		return true;
	}
	
	public boolean update(M model) {
		BaseMapper<M> baseMapper = getMapper();
		
		try {
			baseMapper.update(model);
		} catch (Exception e) {
			log.error("update model to db failed.", e);
			return false;
		}
		return true;
	}
	
	public M get(Serializable id) {
		BaseMapper<M> baseMapper = getMapper();
		M model = null;
		
		try {
			model = baseMapper.get(id);
		} catch (Exception e) {
			log.error("get model from db failed.", e);
		}
		return model;
	}
	
	public List<M> queryBy(Map<String, Object> map) {
		BaseMapper<M> baseMapper = getMapper();
		List<M> models = null;
		
		try {
			models = baseMapper.queryBy(map);
		} catch (Exception e) {
			log.error("query models from db failed.", e);
		}
		return models;
	}
	
}
