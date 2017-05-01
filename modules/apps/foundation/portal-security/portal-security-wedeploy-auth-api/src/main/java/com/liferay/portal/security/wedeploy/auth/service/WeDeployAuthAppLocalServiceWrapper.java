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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WeDeployAuthAppLocalService}.
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthAppLocalService
 * @generated
 */
@ProviderType
public class WeDeployAuthAppLocalServiceWrapper
	implements WeDeployAuthAppLocalService,
		ServiceWrapper<WeDeployAuthAppLocalService> {
	public WeDeployAuthAppLocalServiceWrapper(
		WeDeployAuthAppLocalService weDeployAuthAppLocalService) {
		_weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _weDeployAuthAppLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _weDeployAuthAppLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _weDeployAuthAppLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _weDeployAuthAppLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _weDeployAuthAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the we deploy auth app to the database. Also notifies the appropriate model listeners.
	*
	* @param weDeployAuthApp the we deploy auth app
	* @return the we deploy auth app that was added
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp addWeDeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp weDeployAuthApp) {
		return _weDeployAuthAppLocalService.addWeDeployAuthApp(weDeployAuthApp);
	}

	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp addWeDeployAuthApp(
		long companyId, long userId, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _weDeployAuthAppLocalService.addWeDeployAuthApp(companyId,
			userId, name, serviceContext);
	}

	/**
	* Creates a new we deploy auth app with the primary key. Does not add the we deploy auth app to the database.
	*
	* @param weDeployAuthAppId the primary key for the new we deploy auth app
	* @return the new we deploy auth app
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp createWeDeployAuthApp(
		long weDeployAuthAppId) {
		return _weDeployAuthAppLocalService.createWeDeployAuthApp(weDeployAuthAppId);
	}

	/**
	* Deletes the we deploy auth app from the database. Also notifies the appropriate model listeners.
	*
	* @param weDeployAuthApp the we deploy auth app
	* @return the we deploy auth app that was removed
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp deleteWeDeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp weDeployAuthApp) {
		return _weDeployAuthAppLocalService.deleteWeDeployAuthApp(weDeployAuthApp);
	}

	/**
	* Deletes the we deploy auth app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param weDeployAuthAppId the primary key of the we deploy auth app
	* @return the we deploy auth app that was removed
	* @throws PortalException if a we deploy auth app with the primary key could not be found
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp deleteWeDeployAuthApp(
		long weDeployAuthAppId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _weDeployAuthAppLocalService.deleteWeDeployAuthApp(weDeployAuthAppId);
	}

	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp fetchWeDeployAuthApp(
		long weDeployAuthAppId) {
		return _weDeployAuthAppLocalService.fetchWeDeployAuthApp(weDeployAuthAppId);
	}

	/**
	* Returns the we deploy auth app with the primary key.
	*
	* @param weDeployAuthAppId the primary key of the we deploy auth app
	* @return the we deploy auth app
	* @throws PortalException if a we deploy auth app with the primary key could not be found
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp getWeDeployAuthApp(
		long weDeployAuthAppId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _weDeployAuthAppLocalService.getWeDeployAuthApp(weDeployAuthAppId);
	}

	/**
	* Updates the we deploy auth app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param weDeployAuthApp the we deploy auth app
	* @return the we deploy auth app that was updated
	*/
	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp updateWeDeployAuthApp(
		com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp weDeployAuthApp) {
		return _weDeployAuthAppLocalService.updateWeDeployAuthApp(weDeployAuthApp);
	}

	/**
	* Returns the number of we deploy auth apps.
	*
	* @return the number of we deploy auth apps
	*/
	@Override
	public int getWeDeployAuthAppsCount() {
		return _weDeployAuthAppLocalService.getWeDeployAuthAppsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _weDeployAuthAppLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _weDeployAuthAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _weDeployAuthAppLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _weDeployAuthAppLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the we deploy auth apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.security.wedeploy.auth.model.impl.WeDeployAuthAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of we deploy auth apps
	* @param end the upper bound of the range of we deploy auth apps (not inclusive)
	* @return the range of we deploy auth apps
	*/
	@Override
	public java.util.List<com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp> getWeDeployAuthApps(
		int start, int end) {
		return _weDeployAuthAppLocalService.getWeDeployAuthApps(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _weDeployAuthAppLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _weDeployAuthAppLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WeDeployAuthAppLocalService getWrappedService() {
		return _weDeployAuthAppLocalService;
	}

	@Override
	public void setWrappedService(
		WeDeployAuthAppLocalService weDeployAuthAppLocalService) {
		_weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	private WeDeployAuthAppLocalService _weDeployAuthAppLocalService;
}