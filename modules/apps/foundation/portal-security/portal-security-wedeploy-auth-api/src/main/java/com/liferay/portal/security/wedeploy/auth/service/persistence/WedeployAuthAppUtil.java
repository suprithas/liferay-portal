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

package com.liferay.portal.security.wedeploy.auth.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the wedeploy auth app service. This utility wraps {@link com.liferay.portal.security.wedeploy.auth.service.persistence.impl.WedeployAuthAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthAppPersistence
 * @see com.liferay.portal.security.wedeploy.auth.service.persistence.impl.WedeployAuthAppPersistenceImpl
 * @generated
 */
@ProviderType
public class WedeployAuthAppUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(WedeployAuthApp wedeployAuthApp) {
		getPersistence().clearCache(wedeployAuthApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WedeployAuthApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WedeployAuthApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WedeployAuthApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WedeployAuthApp update(WedeployAuthApp wedeployAuthApp) {
		return getPersistence().update(wedeployAuthApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WedeployAuthApp update(WedeployAuthApp wedeployAuthApp,
		ServiceContext serviceContext) {
		return getPersistence().update(wedeployAuthApp, serviceContext);
	}

	/**
	* Returns all the wedeploy auth apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wedeploy auth apps
	*/
	public static List<WedeployAuthApp> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp findByUuid_First(java.lang.String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp findByUuid_Last(java.lang.String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static WedeployAuthApp[] findByUuid_PrevAndNext(
		long wedeployAuthId, java.lang.String uuid,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByUuid_PrevAndNext(wedeployAuthId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the wedeploy auth apps where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of wedeploy auth apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wedeploy auth apps
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wedeploy auth apps
	*/
	public static List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static WedeployAuthApp findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static WedeployAuthApp findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static WedeployAuthApp[] findByUuid_C_PrevAndNext(
		long wedeployAuthId, java.lang.String uuid, long companyId,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(wedeployAuthId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the wedeploy auth apps where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wedeploy auth apps
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the wedeploy auth apps where clientName = &#63;.
	*
	* @param clientName the client name
	* @return the matching wedeploy auth apps
	*/
	public static List<WedeployAuthApp> findByclientName(
		java.lang.String clientName) {
		return getPersistence().findByclientName(clientName);
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
	public static List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end) {
		return getPersistence().findByclientName(clientName, start, end);
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
	public static List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .findByclientName(clientName, start, end, orderByComparator);
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
	public static List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByclientName(clientName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp findByclientName_First(
		java.lang.String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByclientName_First(clientName, orderByComparator);
	}

	/**
	* Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByclientName_First(
		java.lang.String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .fetchByclientName_First(clientName, orderByComparator);
	}

	/**
	* Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp findByclientName_Last(
		java.lang.String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByclientName_Last(clientName, orderByComparator);
	}

	/**
	* Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static WedeployAuthApp fetchByclientName_Last(
		java.lang.String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence()
				   .fetchByclientName_Last(clientName, orderByComparator);
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
	public static WedeployAuthApp[] findByclientName_PrevAndNext(
		long wedeployAuthId, java.lang.String clientName,
		OrderByComparator<WedeployAuthApp> orderByComparator)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence()
				   .findByclientName_PrevAndNext(wedeployAuthId, clientName,
			orderByComparator);
	}

	/**
	* Removes all the wedeploy auth apps where clientName = &#63; from the database.
	*
	* @param clientName the client name
	*/
	public static void removeByclientName(java.lang.String clientName) {
		getPersistence().removeByclientName(clientName);
	}

	/**
	* Returns the number of wedeploy auth apps where clientName = &#63;.
	*
	* @param clientName the client name
	* @return the number of matching wedeploy auth apps
	*/
	public static int countByclientName(java.lang.String clientName) {
		return getPersistence().countByclientName(clientName);
	}

	/**
	* Caches the wedeploy auth app in the entity cache if it is enabled.
	*
	* @param wedeployAuthApp the wedeploy auth app
	*/
	public static void cacheResult(WedeployAuthApp wedeployAuthApp) {
		getPersistence().cacheResult(wedeployAuthApp);
	}

	/**
	* Caches the wedeploy auth apps in the entity cache if it is enabled.
	*
	* @param wedeployAuthApps the wedeploy auth apps
	*/
	public static void cacheResult(List<WedeployAuthApp> wedeployAuthApps) {
		getPersistence().cacheResult(wedeployAuthApps);
	}

	/**
	* Creates a new wedeploy auth app with the primary key. Does not add the wedeploy auth app to the database.
	*
	* @param wedeployAuthId the primary key for the new wedeploy auth app
	* @return the new wedeploy auth app
	*/
	public static WedeployAuthApp create(long wedeployAuthId) {
		return getPersistence().create(wedeployAuthId);
	}

	/**
	* Removes the wedeploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app that was removed
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public static WedeployAuthApp remove(long wedeployAuthId)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence().remove(wedeployAuthId);
	}

	public static WedeployAuthApp updateImpl(WedeployAuthApp wedeployAuthApp) {
		return getPersistence().updateImpl(wedeployAuthApp);
	}

	/**
	* Returns the wedeploy auth app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public static WedeployAuthApp findByPrimaryKey(long wedeployAuthId)
		throws com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException {
		return getPersistence().findByPrimaryKey(wedeployAuthId);
	}

	/**
	* Returns the wedeploy auth app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app, or <code>null</code> if a wedeploy auth app with the primary key could not be found
	*/
	public static WedeployAuthApp fetchByPrimaryKey(long wedeployAuthId) {
		return getPersistence().fetchByPrimaryKey(wedeployAuthId);
	}

	public static java.util.Map<java.io.Serializable, WedeployAuthApp> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the wedeploy auth apps.
	*
	* @return the wedeploy auth apps
	*/
	public static List<WedeployAuthApp> findAll() {
		return getPersistence().findAll();
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
	public static List<WedeployAuthApp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<WedeployAuthApp> findAll(int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<WedeployAuthApp> findAll(int start, int end,
		OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the wedeploy auth apps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wedeploy auth apps.
	*
	* @return the number of wedeploy auth apps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WedeployAuthAppPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WedeployAuthAppPersistence, WedeployAuthAppPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WedeployAuthAppPersistence.class);
}