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

package com.liferay.portal.security.wedeploy.auth.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for WedeployAuthApp. This utility wraps
 * {@link com.liferay.portal.security.wedeploy.auth.service.impl.WedeployAuthAppLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthAppLocalService
 * @see com.liferay.portal.security.wedeploy.auth.service.base.WedeployAuthAppLocalServiceBaseImpl
 * @see com.liferay.portal.security.wedeploy.auth.service.impl.WedeployAuthAppLocalServiceImpl
 * @generated
 */
@ProviderType
public class WedeployAuthAppLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.security.wedeploy.auth.service.impl.WedeployAuthAppLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the wedeploy auth app to the database. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthApp the wedeploy auth app
	* @return the wedeploy auth app that was added
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp addWedeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp wedeployAuthApp) {
		return getService().addWedeployAuthApp(wedeployAuthApp);
	}

	/**
	* Creates a new wedeploy auth app with the primary key. Does not add the wedeploy auth app to the database.
	*
	* @param wedeployAuthId the primary key for the new wedeploy auth app
	* @return the new wedeploy auth app
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp createWedeployAuthApp(
		long wedeployAuthId) {
		return getService().createWedeployAuthApp(wedeployAuthId);
	}

	/**
	* Deletes the wedeploy auth app from the database. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthApp the wedeploy auth app
	* @return the wedeploy auth app that was removed
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp deleteWedeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp wedeployAuthApp) {
		return getService().deleteWedeployAuthApp(wedeployAuthApp);
	}

	/**
	* Deletes the wedeploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app that was removed
	* @throws PortalException if a wedeploy auth app with the primary key could not be found
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp deleteWedeployAuthApp(
		long wedeployAuthId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWedeployAuthApp(wedeployAuthId);
	}

	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp fetchWedeployAuthApp(
		long wedeployAuthId) {
		return getService().fetchWedeployAuthApp(wedeployAuthId);
	}

	/**
	* Returns the wedeploy auth app with the matching UUID and company.
	*
	* @param uuid the wedeploy auth app's UUID
	* @param companyId the primary key of the company
	* @return the matching wedeploy auth app, or <code>null</code> if a matching wedeploy auth app could not be found
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp fetchWedeployAuthAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .fetchWedeployAuthAppByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the wedeploy auth app with the primary key.
	*
	* @param wedeployAuthId the primary key of the wedeploy auth app
	* @return the wedeploy auth app
	* @throws PortalException if a wedeploy auth app with the primary key could not be found
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp getWedeployAuthApp(
		long wedeployAuthId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWedeployAuthApp(wedeployAuthId);
	}

	/**
	* Returns the wedeploy auth app with the matching UUID and company.
	*
	* @param uuid the wedeploy auth app's UUID
	* @param companyId the primary key of the company
	* @return the matching wedeploy auth app
	* @throws PortalException if a matching wedeploy auth app could not be found
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp getWedeployAuthAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWedeployAuthAppByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the wedeploy auth app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wedeployAuthApp the wedeploy auth app
	* @return the wedeploy auth app that was updated
	*/
	public static com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp updateWedeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp wedeployAuthApp) {
		return getService().updateWedeployAuthApp(wedeployAuthApp);
	}

	/**
	* Returns the number of wedeploy auth apps.
	*
	* @return the number of wedeploy auth apps
	*/
	public static int getWedeployAuthAppsCount() {
		return getService().getWedeployAuthAppsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the wedeploy auth apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wedeploy auth apps
	* @param end the upper bound of the range of wedeploy auth apps (not inclusive)
	* @return the range of wedeploy auth apps
	*/
	public static java.util.List<com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp> getWedeployAuthApps(
		int start, int end) {
		return getService().getWedeployAuthApps(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static WedeployAuthAppLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WedeployAuthAppLocalService, WedeployAuthAppLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WedeployAuthAppLocalService.class);
}