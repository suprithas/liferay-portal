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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException;
import com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp;

/**
 * The persistence interface for the wedeploy auth app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.security.wedeploy.auth.service.persistence.impl.WedeployAuthAppPersistenceImpl
 * @see WedeployAuthAppUtil
 * @generated
 */
@ProviderType
public interface WedeployAuthAppPersistence extends BasePersistence<WedeployAuthApp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WedeployAuthAppUtil} to access the wedeploy auth app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the wedeploy auth apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wedeploy auth apps
	*/
	public java.util.List<WedeployAuthApp> findByUuid(java.lang.String uuid);

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
	public java.util.List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

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
	public java.util.List<WedeployAuthApp> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

	/**
	* Returns the wedeploy auth apps before and after the current wedeploy auth app in the ordered set where uuid = &#63;.
	*
	* @param wedeployAuthId the primary key of the current wedeploy auth app
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wedeploy auth app
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public WedeployAuthApp[] findByUuid_PrevAndNext(long wedeployAuthId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the wedeploy auth apps where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of wedeploy auth apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wedeploy auth apps
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wedeploy auth apps
	*/
	public java.util.List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

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
	public java.util.List<WedeployAuthApp> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last wedeploy auth app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

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
	public WedeployAuthApp[] findByUuid_C_PrevAndNext(long wedeployAuthId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the wedeploy auth apps where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of wedeploy auth apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wedeploy auth apps
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the wedeploy auth apps where clientName = &#63;.
	*
	* @param clientName the client name
	* @return the matching wedeploy auth apps
	*/
	public java.util.List<WedeployAuthApp> findByclientName(
		java.lang.String clientName);

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
	public java.util.List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end);

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
	public java.util.List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

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
	public java.util.List<WedeployAuthApp> findByclientName(
		java.lang.String clientName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByclientName_First(java.lang.String clientName,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByclientName_First(
		java.lang.String clientName,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

	/**
	* Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app
	* @throws NoSuchAppException if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp findByclientName_Last(java.lang.String clientName,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public WedeployAuthApp fetchByclientName_Last(java.lang.String clientName,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

	/**
	* Returns the wedeploy auth apps before and after the current wedeploy auth app in the ordered set where clientName = &#63;.
	*
	* @param wedeployAuthId the primary key of the current wedeploy auth app
	* @param clientName the client name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wedeploy auth app
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public WedeployAuthApp[] findByclientName_PrevAndNext(long wedeployAuthId,
		java.lang.String clientName,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the wedeploy auth apps where clientName = &#63; from the database.
	*
	* @param clientName the client name
	*/
	public void removeByclientName(java.lang.String clientName);

	/**
	* Returns the number of wedeploy auth apps where clientName = &#63;.
	*
	* @param clientName the client name
	* @return the number of matching wedeploy auth apps
	*/
	public int countByclientName(java.lang.String clientName);

	/**
	* Caches the wedeploy auth app in the entity cache if it is enabled.
	*
	* @param wedeployAuthApp the wedeploy auth app
	*/
	public void cacheResult(WedeployAuthApp wedeployAuthApp);

	/**
	* Caches the wedeploy auth apps in the entity cache if it is enabled.
	*
	* @param wedeployAuthApps the wedeploy auth apps
	*/
	public void cacheResult(java.util.List<WedeployAuthApp> wedeployAuthApps);

	/**
	* Creates a new wedeploy auth app with the primary key. Does not add the wedeploy auth app to the database.
	*
	* @param wedeployAuthId the primary key for the new wedeploy auth app
	* @return the new wedeploy auth app
	*/
	public WedeployAuthApp create(long wedeployAuthId);

	/**
	* Removes the wedeploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app that was removed
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public WedeployAuthApp remove(long wedeployAuthId)
		throws NoSuchAppException;

	public WedeployAuthApp updateImpl(WedeployAuthApp wedeployAuthApp);

	/**
	* Returns the wedeploy auth app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app
	* @throws NoSuchAppException if a wedeploy auth app with the primary key could not be found
	*/
	public WedeployAuthApp findByPrimaryKey(long wedeployAuthId)
		throws NoSuchAppException;

	/**
	* Returns the wedeploy auth app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app, or <code>null</code> if a wedeploy auth app with the primary key could not be found
	*/
	public WedeployAuthApp fetchByPrimaryKey(long wedeployAuthId);

	@Override
	public java.util.Map<java.io.Serializable, WedeployAuthApp> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the wedeploy auth apps.
	*
	* @return the wedeploy auth apps
	*/
	public java.util.List<WedeployAuthApp> findAll();

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
	public java.util.List<WedeployAuthApp> findAll(int start, int end);

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
	public java.util.List<WedeployAuthApp> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator);

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
	public java.util.List<WedeployAuthApp> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WedeployAuthApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the wedeploy auth apps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of wedeploy auth apps.
	*
	* @return the number of wedeploy auth apps
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}