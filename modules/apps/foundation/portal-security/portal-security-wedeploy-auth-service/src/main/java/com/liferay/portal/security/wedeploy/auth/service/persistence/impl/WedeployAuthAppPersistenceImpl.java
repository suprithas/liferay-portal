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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException;
import com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppImpl;
import com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppModelImpl;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WedeployAuthAppPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the wedeploy auth app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthAppPersistence
 * @see com.liferay.portal.security.wedeploy.auth.service.persistence.WedeployAuthAppUtil
 * @generated
 */
@ProviderType
public class WedeployAuthAppPersistenceImpl extends BasePersistenceImpl<WedeployAuthApp>
	implements WedeployAuthAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WedeployAuthAppUtil} to access the wedeploy auth app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WedeployAuthAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			WedeployAuthAppModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the wedeploy auth apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wedeploy auth apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @return the range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid(String uuid, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid(String uuid, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<WedeployAuthApp> list = null;

		if (retrieveFromCache) {
			list = (List<WedeployAuthApp>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WedeployAuthApp wedeployAuthApp : list) {
					if (!Objects.equals(uuid, wedeployAuthApp.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
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
	 * Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByUuid_First(String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByUuid_First(uuid,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByUuid_First(String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		List<WedeployAuthApp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByUuid_Last(String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByUuid_Last(uuid,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByUuid_Last(String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WedeployAuthApp> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wedeploy auth apps before and after the current wedeploy auth app in the ordered set where uuid = &#63;.
	 *
	 * @param wedeployAuthId the primary key of the current wedeploy auth app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wedeploy auth app
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp[] findByUuid_PrevAndNext(long wedeployAuthId,
		String uuid, OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = findByPrimaryKey(wedeployAuthId);

		Session session = null;

		try {
			session = openSession();

			WedeployAuthApp[] array = new WedeployAuthAppImpl[3];

			array[0] = getByUuid_PrevAndNext(session, wedeployAuthApp, uuid,
					orderByComparator, true);

			array[1] = wedeployAuthApp;

			array[2] = getByUuid_PrevAndNext(session, wedeployAuthApp, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WedeployAuthApp getByUuid_PrevAndNext(Session session,
		WedeployAuthApp wedeployAuthApp, String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wedeployAuthApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WedeployAuthApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wedeploy auth apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WedeployAuthApp wedeployAuthApp : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wedeployAuthApp);
		}
	}

	/**
	 * Returns the number of wedeploy auth apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wedeploy auth apps
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "wedeployAuthApp.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "wedeployAuthApp.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(wedeployAuthApp.uuid IS NULL OR wedeployAuthApp.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			WedeployAuthAppModelImpl.UUID_COLUMN_BITMASK |
			WedeployAuthAppModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @return the range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<WedeployAuthApp> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<WedeployAuthApp> list = null;

		if (retrieveFromCache) {
			list = (List<WedeployAuthApp>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WedeployAuthApp wedeployAuthApp : list) {
					if (!Objects.equals(uuid, wedeployAuthApp.getUuid()) ||
							(companyId != wedeployAuthApp.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
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
	 * Returns the first wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		List<WedeployAuthApp> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WedeployAuthApp> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wedeploy auth apps before and after the current wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param wedeployAuthId the primary key of the current wedeploy auth app
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wedeploy auth app
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp[] findByUuid_C_PrevAndNext(long wedeployAuthId,
		String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = findByPrimaryKey(wedeployAuthId);

		Session session = null;

		try {
			session = openSession();

			WedeployAuthApp[] array = new WedeployAuthAppImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, wedeployAuthApp, uuid,
					companyId, orderByComparator, true);

			array[1] = wedeployAuthApp;

			array[2] = getByUuid_C_PrevAndNext(session, wedeployAuthApp, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WedeployAuthApp getByUuid_C_PrevAndNext(Session session,
		WedeployAuthApp wedeployAuthApp, String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wedeployAuthApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WedeployAuthApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wedeploy auth apps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WedeployAuthApp wedeployAuthApp : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wedeployAuthApp);
		}
	}

	/**
	 * Returns the number of wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching wedeploy auth apps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "wedeployAuthApp.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "wedeployAuthApp.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(wedeployAuthApp.uuid IS NULL OR wedeployAuthApp.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "wedeployAuthApp.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTNAME =
		new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByclientName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME =
		new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED,
			WedeployAuthAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclientName",
			new String[] { String.class.getName() },
			WedeployAuthAppModelImpl.CLIENTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTNAME = new FinderPath(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByclientName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the wedeploy auth apps where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @return the matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByclientName(String clientName) {
		return findByclientName(clientName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wedeploy auth apps where clientName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientName the client name
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @return the range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByclientName(String clientName, int start,
		int end) {
		return findByclientName(clientName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where clientName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientName the client name
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByclientName(String clientName, int start,
		int end, OrderByComparator<WedeployAuthApp> orderByComparator) {
		return findByclientName(clientName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps where clientName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientName the client name
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findByclientName(String clientName, int start,
		int end, OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME;
			finderArgs = new Object[] { clientName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTNAME;
			finderArgs = new Object[] { clientName, start, end, orderByComparator };
		}

		List<WedeployAuthApp> list = null;

		if (retrieveFromCache) {
			list = (List<WedeployAuthApp>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WedeployAuthApp wedeployAuthApp : list) {
					if (!Objects.equals(clientName,
								wedeployAuthApp.getClientName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindClientName = false;

			if (clientName == null) {
				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_1);
			}
			else if (clientName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_3);
			}
			else {
				bindClientName = true;

				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClientName) {
					qPos.add(clientName);
				}

				if (!pagination) {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
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
	 * Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByclientName_First(String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByclientName_First(clientName,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientName=");
		msg.append(clientName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByclientName_First(String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		List<WedeployAuthApp> list = findByclientName(clientName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app
	 * @throws NoSuchAppException if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp findByclientName_Last(String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByclientName_Last(clientName,
				orderByComparator);

		if (wedeployAuthApp != null) {
			return wedeployAuthApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientName=");
		msg.append(clientName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	 */
	@Override
	public WedeployAuthApp fetchByclientName_Last(String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		int count = countByclientName(clientName);

		if (count == 0) {
			return null;
		}

		List<WedeployAuthApp> list = findByclientName(clientName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wedeploy auth apps before and after the current wedeploy auth app in the ordered set where clientName = &#63;.
	 *
	 * @param wedeployAuthId the primary key of the current wedeploy auth app
	 * @param clientName the client name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wedeploy auth app
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp[] findByclientName_PrevAndNext(long wedeployAuthId,
		String clientName, OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = findByPrimaryKey(wedeployAuthId);

		Session session = null;

		try {
			session = openSession();

			WedeployAuthApp[] array = new WedeployAuthAppImpl[3];

			array[0] = getByclientName_PrevAndNext(session, wedeployAuthApp,
					clientName, orderByComparator, true);

			array[1] = wedeployAuthApp;

			array[2] = getByclientName_PrevAndNext(session, wedeployAuthApp,
					clientName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WedeployAuthApp getByclientName_PrevAndNext(Session session,
		WedeployAuthApp wedeployAuthApp, String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE);

		boolean bindClientName = false;

		if (clientName == null) {
			query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_1);
		}
		else if (clientName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_3);
		}
		else {
			bindClientName = true;

			query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClientName) {
			qPos.add(clientName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wedeployAuthApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WedeployAuthApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wedeploy auth apps where clientName = &#63; from the database.
	 *
	 * @param clientName the client name
	 */
	@Override
	public void removeByclientName(String clientName) {
		for (WedeployAuthApp wedeployAuthApp : findByclientName(clientName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wedeployAuthApp);
		}
	}

	/**
	 * Returns the number of wedeploy auth apps where clientName = &#63;.
	 *
	 * @param clientName the client name
	 * @return the number of matching wedeploy auth apps
	 */
	@Override
	public int countByclientName(String clientName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTNAME;

		Object[] finderArgs = new Object[] { clientName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEDEPLOYAUTHAPP_WHERE);

			boolean bindClientName = false;

			if (clientName == null) {
				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_1);
			}
			else if (clientName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_3);
			}
			else {
				bindClientName = true;

				query.append(_FINDER_COLUMN_CLIENTNAME_CLIENTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClientName) {
					qPos.add(clientName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLIENTNAME_CLIENTNAME_1 = "wedeployAuthApp.clientName IS NULL";
	private static final String _FINDER_COLUMN_CLIENTNAME_CLIENTNAME_2 = "wedeployAuthApp.clientName = ?";
	private static final String _FINDER_COLUMN_CLIENTNAME_CLIENTNAME_3 = "(wedeployAuthApp.clientName IS NULL OR wedeployAuthApp.clientName = '')";

	public WedeployAuthAppPersistenceImpl() {
		setModelClass(WedeployAuthApp.class);
	}

	/**
	 * Caches the wedeploy auth app in the entity cache if it is enabled.
	 *
	 * @param wedeployAuthApp the wedeploy auth app
	 */
	@Override
	public void cacheResult(WedeployAuthApp wedeployAuthApp) {
		entityCache.putResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppImpl.class, wedeployAuthApp.getPrimaryKey(),
			wedeployAuthApp);

		wedeployAuthApp.resetOriginalValues();
	}

	/**
	 * Caches the wedeploy auth apps in the entity cache if it is enabled.
	 *
	 * @param wedeployAuthApps the wedeploy auth apps
	 */
	@Override
	public void cacheResult(List<WedeployAuthApp> wedeployAuthApps) {
		for (WedeployAuthApp wedeployAuthApp : wedeployAuthApps) {
			if (entityCache.getResult(
						WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
						WedeployAuthAppImpl.class,
						wedeployAuthApp.getPrimaryKey()) == null) {
				cacheResult(wedeployAuthApp);
			}
			else {
				wedeployAuthApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wedeploy auth apps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WedeployAuthAppImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wedeploy auth app.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WedeployAuthApp wedeployAuthApp) {
		entityCache.removeResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppImpl.class, wedeployAuthApp.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WedeployAuthApp> wedeployAuthApps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WedeployAuthApp wedeployAuthApp : wedeployAuthApps) {
			entityCache.removeResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
				WedeployAuthAppImpl.class, wedeployAuthApp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new wedeploy auth app with the primary key. Does not add the wedeploy auth app to the database.
	 *
	 * @param wedeployAuthId the primary key for the new wedeploy auth app
	 * @return the new wedeploy auth app
	 */
	@Override
	public WedeployAuthApp create(long wedeployAuthId) {
		WedeployAuthApp wedeployAuthApp = new WedeployAuthAppImpl();

		wedeployAuthApp.setNew(true);
		wedeployAuthApp.setPrimaryKey(wedeployAuthId);

		String uuid = PortalUUIDUtil.generate();

		wedeployAuthApp.setUuid(uuid);

		wedeployAuthApp.setCompanyId(companyProvider.getCompanyId());

		return wedeployAuthApp;
	}

	/**
	 * Removes the wedeploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wedeployAuthId the primary key of the wedeploy auth app
	 * @return the wedeploy auth app that was removed
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp remove(long wedeployAuthId)
		throws NoSuchAppException {
		return remove((Serializable)wedeployAuthId);
	}

	/**
	 * Removes the wedeploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wedeploy auth app
	 * @return the wedeploy auth app that was removed
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp remove(Serializable primaryKey)
		throws NoSuchAppException {
		Session session = null;

		try {
			session = openSession();

			WedeployAuthApp wedeployAuthApp = (WedeployAuthApp)session.get(WedeployAuthAppImpl.class,
					primaryKey);

			if (wedeployAuthApp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wedeployAuthApp);
		}
		catch (NoSuchAppException nsee) {
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
	protected WedeployAuthApp removeImpl(WedeployAuthApp wedeployAuthApp) {
		wedeployAuthApp = toUnwrappedModel(wedeployAuthApp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wedeployAuthApp)) {
				wedeployAuthApp = (WedeployAuthApp)session.get(WedeployAuthAppImpl.class,
						wedeployAuthApp.getPrimaryKeyObj());
			}

			if (wedeployAuthApp != null) {
				session.delete(wedeployAuthApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wedeployAuthApp != null) {
			clearCache(wedeployAuthApp);
		}

		return wedeployAuthApp;
	}

	@Override
	public WedeployAuthApp updateImpl(WedeployAuthApp wedeployAuthApp) {
		wedeployAuthApp = toUnwrappedModel(wedeployAuthApp);

		boolean isNew = wedeployAuthApp.isNew();

		WedeployAuthAppModelImpl wedeployAuthAppModelImpl = (WedeployAuthAppModelImpl)wedeployAuthApp;

		if (Validator.isNull(wedeployAuthApp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			wedeployAuthApp.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (wedeployAuthApp.isNew()) {
				session.save(wedeployAuthApp);

				wedeployAuthApp.setNew(false);
			}
			else {
				wedeployAuthApp = (WedeployAuthApp)session.merge(wedeployAuthApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WedeployAuthAppModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wedeployAuthAppModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					wedeployAuthAppModelImpl.getUuid(),
					wedeployAuthAppModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { wedeployAuthAppModelImpl.getClientName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wedeployAuthAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wedeployAuthAppModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { wedeployAuthAppModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((wedeployAuthAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wedeployAuthAppModelImpl.getOriginalUuid(),
						wedeployAuthAppModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						wedeployAuthAppModelImpl.getUuid(),
						wedeployAuthAppModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((wedeployAuthAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wedeployAuthAppModelImpl.getOriginalClientName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME,
					args);

				args = new Object[] { wedeployAuthAppModelImpl.getClientName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTNAME,
					args);
			}
		}

		entityCache.putResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
			WedeployAuthAppImpl.class, wedeployAuthApp.getPrimaryKey(),
			wedeployAuthApp, false);

		wedeployAuthApp.resetOriginalValues();

		return wedeployAuthApp;
	}

	protected WedeployAuthApp toUnwrappedModel(WedeployAuthApp wedeployAuthApp) {
		if (wedeployAuthApp instanceof WedeployAuthAppImpl) {
			return wedeployAuthApp;
		}

		WedeployAuthAppImpl wedeployAuthAppImpl = new WedeployAuthAppImpl();

		wedeployAuthAppImpl.setNew(wedeployAuthApp.isNew());
		wedeployAuthAppImpl.setPrimaryKey(wedeployAuthApp.getPrimaryKey());

		wedeployAuthAppImpl.setUuid(wedeployAuthApp.getUuid());
		wedeployAuthAppImpl.setWedeployAuthId(wedeployAuthApp.getWedeployAuthId());
		wedeployAuthAppImpl.setClientId(wedeployAuthApp.getClientId());
		wedeployAuthAppImpl.setClientName(wedeployAuthApp.getClientName());
		wedeployAuthAppImpl.setSecret(wedeployAuthApp.getSecret());
		wedeployAuthAppImpl.setCompanyId(wedeployAuthApp.getCompanyId());

		return wedeployAuthAppImpl;
	}

	/**
	 * Returns the wedeploy auth app with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wedeploy auth app
	 * @return the wedeploy auth app
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppException {
		WedeployAuthApp wedeployAuthApp = fetchByPrimaryKey(primaryKey);

		if (wedeployAuthApp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wedeployAuthApp;
	}

	/**
	 * Returns the wedeploy auth app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	 *
	 * @param wedeployAuthId the primary key of the wedeploy auth app
	 * @return the wedeploy auth app
	 * @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp findByPrimaryKey(long wedeployAuthId)
		throws NoSuchAppException {
		return findByPrimaryKey((Serializable)wedeployAuthId);
	}

	/**
	 * Returns the wedeploy auth app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wedeploy auth app
	 * @return the wedeploy auth app, or <code>null</code> if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
				WedeployAuthAppImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WedeployAuthApp wedeployAuthApp = (WedeployAuthApp)serializable;

		if (wedeployAuthApp == null) {
			Session session = null;

			try {
				session = openSession();

				wedeployAuthApp = (WedeployAuthApp)session.get(WedeployAuthAppImpl.class,
						primaryKey);

				if (wedeployAuthApp != null) {
					cacheResult(wedeployAuthApp);
				}
				else {
					entityCache.putResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
						WedeployAuthAppImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
					WedeployAuthAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wedeployAuthApp;
	}

	/**
	 * Returns the wedeploy auth app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wedeployAuthId the primary key of the wedeploy auth app
	 * @return the wedeploy auth app, or <code>null</code> if a wedeploy auth app with the primary key could not be found
	 */
	@Override
	public WedeployAuthApp fetchByPrimaryKey(long wedeployAuthId) {
		return fetchByPrimaryKey((Serializable)wedeployAuthId);
	}

	@Override
	public Map<Serializable, WedeployAuthApp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WedeployAuthApp> map = new HashMap<Serializable, WedeployAuthApp>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WedeployAuthApp wedeployAuthApp = fetchByPrimaryKey(primaryKey);

			if (wedeployAuthApp != null) {
				map.put(primaryKey, wedeployAuthApp);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
					WedeployAuthAppImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WedeployAuthApp)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WEDEPLOYAUTHAPP_WHERE_PKS_IN);

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

			for (WedeployAuthApp wedeployAuthApp : (List<WedeployAuthApp>)q.list()) {
				map.put(wedeployAuthApp.getPrimaryKeyObj(), wedeployAuthApp);

				cacheResult(wedeployAuthApp);

				uncachedPrimaryKeys.remove(wedeployAuthApp.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WedeployAuthAppModelImpl.ENTITY_CACHE_ENABLED,
					WedeployAuthAppImpl.class, primaryKey, nullModel);
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
	 * Returns all the wedeploy auth apps.
	 *
	 * @return the wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wedeploy auth apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @return the range of wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findAll(int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wedeploy auth apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wedeploy auth apps
	 * @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of wedeploy auth apps
	 */
	@Override
	public List<WedeployAuthApp> findAll(int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
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

		List<WedeployAuthApp> list = null;

		if (retrieveFromCache) {
			list = (List<WedeployAuthApp>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WEDEPLOYAUTHAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEDEPLOYAUTHAPP;

				if (pagination) {
					sql = sql.concat(WedeployAuthAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WedeployAuthApp>)QueryUtil.list(q,
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
	 * Removes all the wedeploy auth apps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WedeployAuthApp wedeployAuthApp : findAll()) {
			remove(wedeployAuthApp);
		}
	}

	/**
	 * Returns the number of wedeploy auth apps.
	 *
	 * @return the number of wedeploy auth apps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEDEPLOYAUTHAPP);

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
		return WedeployAuthAppModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wedeploy auth app persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WedeployAuthAppImpl.class.getName());
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
	private static final String _SQL_SELECT_WEDEPLOYAUTHAPP = "SELECT wedeployAuthApp FROM WedeployAuthApp wedeployAuthApp";
	private static final String _SQL_SELECT_WEDEPLOYAUTHAPP_WHERE_PKS_IN = "SELECT wedeployAuthApp FROM WedeployAuthApp wedeployAuthApp WHERE wedeployAuthId IN (";
	private static final String _SQL_SELECT_WEDEPLOYAUTHAPP_WHERE = "SELECT wedeployAuthApp FROM WedeployAuthApp wedeployAuthApp WHERE ";
	private static final String _SQL_COUNT_WEDEPLOYAUTHAPP = "SELECT COUNT(wedeployAuthApp) FROM WedeployAuthApp wedeployAuthApp";
	private static final String _SQL_COUNT_WEDEPLOYAUTHAPP_WHERE = "SELECT COUNT(wedeployAuthApp) FROM WedeployAuthApp wedeployAuthApp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wedeployAuthApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WedeployAuthApp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WedeployAuthApp exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WedeployAuthAppPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}