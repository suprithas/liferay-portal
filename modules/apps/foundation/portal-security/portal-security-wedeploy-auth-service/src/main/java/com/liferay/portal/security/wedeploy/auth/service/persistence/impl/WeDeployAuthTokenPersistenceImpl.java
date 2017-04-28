/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.security.wedeploy.auth.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.wedeploy.auth.exception.NoSuchTokenException;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken;
import com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthTokenImpl;
import com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthTokenModelImpl;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthTokenPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the we deploy auth token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthTokenPersistence
 * @see com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthTokenUtil
 * @generated
 */
@ProviderType
public class WeDeployAuthTokenPersistenceImpl extends BasePersistenceImpl<WeDeployAuthToken>
	implements WeDeployAuthTokenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WeDeployAuthTokenUtil} to access the we deploy auth token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WeDeployAuthTokenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenModelImpl.FINDER_CACHE_ENABLED,
			WeDeployAuthTokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenModelImpl.FINDER_CACHE_ENABLED,
			WeDeployAuthTokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WeDeployAuthTokenPersistenceImpl() {
		setModelClass(WeDeployAuthToken.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the we deploy auth token in the entity cache if it is enabled.
	 *
	 * @param weDeployAuthToken the we deploy auth token
	 */
	@Override
	public void cacheResult(WeDeployAuthToken weDeployAuthToken) {
		entityCache.putResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenImpl.class, weDeployAuthToken.getPrimaryKey(),
			weDeployAuthToken);

		weDeployAuthToken.resetOriginalValues();
	}

	/**
	 * Caches the we deploy auth tokens in the entity cache if it is enabled.
	 *
	 * @param weDeployAuthTokens the we deploy auth tokens
	 */
	@Override
	public void cacheResult(List<WeDeployAuthToken> weDeployAuthTokens) {
		for (WeDeployAuthToken weDeployAuthToken : weDeployAuthTokens) {
			if (entityCache.getResult(
						WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
						WeDeployAuthTokenImpl.class,
						weDeployAuthToken.getPrimaryKey()) == null) {
				cacheResult(weDeployAuthToken);
			}
			else {
				weDeployAuthToken.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all we deploy auth tokens.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WeDeployAuthTokenImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the we deploy auth token.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WeDeployAuthToken weDeployAuthToken) {
		entityCache.removeResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenImpl.class, weDeployAuthToken.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WeDeployAuthToken> weDeployAuthTokens) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WeDeployAuthToken weDeployAuthToken : weDeployAuthTokens) {
			entityCache.removeResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
				WeDeployAuthTokenImpl.class, weDeployAuthToken.getPrimaryKey());
		}
	}

	/**
	 * Creates a new we deploy auth token with the primary key. Does not add the we deploy auth token to the database.
	 *
	 * @param weDeployAuthTokenId the primary key for the new we deploy auth token
	 * @return the new we deploy auth token
	 */
	@Override
	public WeDeployAuthToken create(long weDeployAuthTokenId) {
		WeDeployAuthToken weDeployAuthToken = new WeDeployAuthTokenImpl();

		weDeployAuthToken.setNew(true);
		weDeployAuthToken.setPrimaryKey(weDeployAuthTokenId);

		weDeployAuthToken.setCompanyId(companyProvider.getCompanyId());

		return weDeployAuthToken;
	}

	/**
	 * Removes the we deploy auth token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param weDeployAuthTokenId the primary key of the we deploy auth token
	 * @return the we deploy auth token that was removed
	 * @throws NoSuchTokenException if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken remove(long weDeployAuthTokenId)
		throws NoSuchTokenException {
		return remove((Serializable)weDeployAuthTokenId);
	}

	/**
	 * Removes the we deploy auth token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the we deploy auth token
	 * @return the we deploy auth token that was removed
	 * @throws NoSuchTokenException if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken remove(Serializable primaryKey)
		throws NoSuchTokenException {
		Session session = null;

		try {
			session = openSession();

			WeDeployAuthToken weDeployAuthToken = (WeDeployAuthToken)session.get(WeDeployAuthTokenImpl.class,
					primaryKey);

			if (weDeployAuthToken == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(weDeployAuthToken);
		}
		catch (NoSuchTokenException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WeDeployAuthToken removeImpl(WeDeployAuthToken weDeployAuthToken) {
		weDeployAuthToken = toUnwrappedModel(weDeployAuthToken);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(weDeployAuthToken)) {
				weDeployAuthToken = (WeDeployAuthToken)session.get(WeDeployAuthTokenImpl.class,
						weDeployAuthToken.getPrimaryKeyObj());
			}

			if (weDeployAuthToken != null) {
				session.delete(weDeployAuthToken);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (weDeployAuthToken != null) {
			clearCache(weDeployAuthToken);
		}

		return weDeployAuthToken;
	}

	@Override
	public WeDeployAuthToken updateImpl(WeDeployAuthToken weDeployAuthToken) {
		weDeployAuthToken = toUnwrappedModel(weDeployAuthToken);

		boolean isNew = weDeployAuthToken.isNew();

		WeDeployAuthTokenModelImpl weDeployAuthTokenModelImpl = (WeDeployAuthTokenModelImpl)weDeployAuthToken;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (weDeployAuthToken.getCreateDate() == null)) {
			if (serviceContext == null) {
				weDeployAuthToken.setCreateDate(now);
			}
			else {
				weDeployAuthToken.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!weDeployAuthTokenModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				weDeployAuthToken.setModifiedDate(now);
			}
			else {
				weDeployAuthToken.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (weDeployAuthToken.isNew()) {
				session.save(weDeployAuthToken);

				weDeployAuthToken.setNew(false);
			}
			else {
				weDeployAuthToken = (WeDeployAuthToken)session.merge(weDeployAuthToken);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
			WeDeployAuthTokenImpl.class, weDeployAuthToken.getPrimaryKey(),
			weDeployAuthToken, false);

		weDeployAuthToken.resetOriginalValues();

		return weDeployAuthToken;
	}

	protected WeDeployAuthToken toUnwrappedModel(
		WeDeployAuthToken weDeployAuthToken) {
		if (weDeployAuthToken instanceof WeDeployAuthTokenImpl) {
			return weDeployAuthToken;
		}

		WeDeployAuthTokenImpl weDeployAuthTokenImpl = new WeDeployAuthTokenImpl();

		weDeployAuthTokenImpl.setNew(weDeployAuthToken.isNew());
		weDeployAuthTokenImpl.setPrimaryKey(weDeployAuthToken.getPrimaryKey());

		weDeployAuthTokenImpl.setWeDeployAuthTokenId(weDeployAuthToken.getWeDeployAuthTokenId());
		weDeployAuthTokenImpl.setCompanyId(weDeployAuthToken.getCompanyId());
		weDeployAuthTokenImpl.setUserId(weDeployAuthToken.getUserId());
		weDeployAuthTokenImpl.setUserName(weDeployAuthToken.getUserName());
		weDeployAuthTokenImpl.setCreateDate(weDeployAuthToken.getCreateDate());
		weDeployAuthTokenImpl.setModifiedDate(weDeployAuthToken.getModifiedDate());
		weDeployAuthTokenImpl.setToken(weDeployAuthToken.getToken());
		weDeployAuthTokenImpl.setType(weDeployAuthToken.getType());

		return weDeployAuthTokenImpl;
	}

	/**
	 * Returns the we deploy auth token with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the we deploy auth token
	 * @return the we deploy auth token
	 * @throws NoSuchTokenException if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenException {
		WeDeployAuthToken weDeployAuthToken = fetchByPrimaryKey(primaryKey);

		if (weDeployAuthToken == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return weDeployAuthToken;
	}

	/**
	 * Returns the we deploy auth token with the primary key or throws a {@link NoSuchTokenException} if it could not be found.
	 *
	 * @param weDeployAuthTokenId the primary key of the we deploy auth token
	 * @return the we deploy auth token
	 * @throws NoSuchTokenException if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken findByPrimaryKey(long weDeployAuthTokenId)
		throws NoSuchTokenException {
		return findByPrimaryKey((Serializable)weDeployAuthTokenId);
	}

	/**
	 * Returns the we deploy auth token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the we deploy auth token
	 * @return the we deploy auth token, or <code>null</code> if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
				WeDeployAuthTokenImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WeDeployAuthToken weDeployAuthToken = (WeDeployAuthToken)serializable;

		if (weDeployAuthToken == null) {
			Session session = null;

			try {
				session = openSession();

				weDeployAuthToken = (WeDeployAuthToken)session.get(WeDeployAuthTokenImpl.class,
						primaryKey);

				if (weDeployAuthToken != null) {
					cacheResult(weDeployAuthToken);
				}
				else {
					entityCache.putResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
						WeDeployAuthTokenImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
					WeDeployAuthTokenImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return weDeployAuthToken;
	}

	/**
	 * Returns the we deploy auth token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param weDeployAuthTokenId the primary key of the we deploy auth token
	 * @return the we deploy auth token, or <code>null</code> if a we deploy auth token with the primary key could not be found
	 */
	@Override
	public WeDeployAuthToken fetchByPrimaryKey(long weDeployAuthTokenId) {
		return fetchByPrimaryKey((Serializable)weDeployAuthTokenId);
	}

	@Override
	public Map<Serializable, WeDeployAuthToken> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WeDeployAuthToken> map = new HashMap<Serializable, WeDeployAuthToken>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WeDeployAuthToken weDeployAuthToken = fetchByPrimaryKey(primaryKey);

			if (weDeployAuthToken != null) {
				map.put(primaryKey, weDeployAuthToken);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
					WeDeployAuthTokenImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WeDeployAuthToken)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WEDEPLOYAUTHTOKEN_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (WeDeployAuthToken weDeployAuthToken : (List<WeDeployAuthToken>)q.list()) {
				map.put(weDeployAuthToken.getPrimaryKeyObj(), weDeployAuthToken);

				cacheResult(weDeployAuthToken);

				uncachedPrimaryKeys.remove(weDeployAuthToken.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WeDeployAuthTokenModelImpl.ENTITY_CACHE_ENABLED,
					WeDeployAuthTokenImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the we deploy auth tokens.
	 *
	 * @return the we deploy auth tokens
	 */
	@Override
	public List<WeDeployAuthToken> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the we deploy auth tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeDeployAuthTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of we deploy auth tokens
	 * @param end the upper bound of the range of we deploy auth tokens (not inclusive)
	 * @return the range of we deploy auth tokens
	 */
	@Override
	public List<WeDeployAuthToken> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the we deploy auth tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeDeployAuthTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of we deploy auth tokens
	 * @param end the upper bound of the range of we deploy auth tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of we deploy auth tokens
	 */
	@Override
	public List<WeDeployAuthToken> findAll(int start, int end,
		OrderByComparator<WeDeployAuthToken> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the we deploy auth tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeDeployAuthTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of we deploy auth tokens
	 * @param end the upper bound of the range of we deploy auth tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of we deploy auth tokens
	 */
	@Override
	public List<WeDeployAuthToken> findAll(int start, int end,
		OrderByComparator<WeDeployAuthToken> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WeDeployAuthToken> list = null;

		if (retrieveFromCache) {
			list = (List<WeDeployAuthToken>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WEDEPLOYAUTHTOKEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEDEPLOYAUTHTOKEN;

				if (pagination) {
					sql = sql.concat(WeDeployAuthTokenModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WeDeployAuthToken>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WeDeployAuthToken>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the we deploy auth tokens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WeDeployAuthToken weDeployAuthToken : findAll()) {
			remove(weDeployAuthToken);
		}
	}

	/**
	 * Returns the number of we deploy auth tokens.
	 *
	 * @return the number of we deploy auth tokens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEDEPLOYAUTHTOKEN);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WeDeployAuthTokenModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the we deploy auth token persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WeDeployAuthTokenImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WEDEPLOYAUTHTOKEN = "SELECT weDeployAuthToken FROM WeDeployAuthToken weDeployAuthToken";
	private static final String _SQL_SELECT_WEDEPLOYAUTHTOKEN_WHERE_PKS_IN = "SELECT weDeployAuthToken FROM WeDeployAuthToken weDeployAuthToken WHERE weDeployAuthTokenId IN (";
	private static final String _SQL_COUNT_WEDEPLOYAUTHTOKEN = "SELECT COUNT(weDeployAuthToken) FROM WeDeployAuthToken weDeployAuthToken";
	private static final String _ORDER_BY_ENTITY_ALIAS = "weDeployAuthToken.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WeDeployAuthToken exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WeDeployAuthTokenPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}