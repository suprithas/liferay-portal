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

package com.liferay.portal.security.wedeploy.auth.service.base;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthAppPersistence;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthTokenPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

/**
 * @author Supritha Sundaram
 */
@ProviderType
public abstract class WeDeployAuthAppLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements WeDeployAuthAppLocalService,
		IdentifiableOSGiService {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WeDeployAuthApp addWeDeployAuthApp(WeDeployAuthApp weDeployAuthApp) {
		weDeployAuthApp.setNew(true);

		return weDeployAuthAppPersistence.update(weDeployAuthApp);
	}

	@Override
	public WeDeployAuthApp createWeDeployAuthApp(long weDeployAuthAppId) {
		return weDeployAuthAppPersistence.create(weDeployAuthAppId);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public WeDeployAuthApp deleteWeDeployAuthApp(long weDeployAuthAppId)
		throws PortalException {
		return weDeployAuthAppPersistence.remove(weDeployAuthAppId);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public WeDeployAuthApp deleteWeDeployAuthApp(
		WeDeployAuthApp weDeployAuthApp) {
		return weDeployAuthAppPersistence.remove(weDeployAuthApp);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(WeDeployAuthApp.class,
			clazz.getClassLoader());
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return weDeployAuthAppPersistence.findWithDynamicQuery(dynamicQuery);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return weDeployAuthAppPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return weDeployAuthAppPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return weDeployAuthAppPersistence.countWithDynamicQuery(dynamicQuery);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return weDeployAuthAppPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public WeDeployAuthApp fetchWeDeployAuthApp(long weDeployAuthAppId) {
		return weDeployAuthAppPersistence.fetchByPrimaryKey(weDeployAuthAppId);
	}

	@Override
	public WeDeployAuthApp getWeDeployAuthApp(long weDeployAuthAppId)
		throws PortalException {
		return weDeployAuthAppPersistence.findByPrimaryKey(weDeployAuthAppId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(weDeployAuthAppLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WeDeployAuthApp.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("weDeployAuthAppId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(weDeployAuthAppLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(WeDeployAuthApp.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"weDeployAuthAppId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(weDeployAuthAppLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WeDeployAuthApp.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("weDeployAuthAppId");
	}

	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return weDeployAuthAppLocalService.deleteWeDeployAuthApp((WeDeployAuthApp)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return weDeployAuthAppPersistence.findByPrimaryKey(primaryKeyObj);
	}

	@Override
	public List<WeDeployAuthApp> getWeDeployAuthApps(int start, int end) {
		return weDeployAuthAppPersistence.findAll(start, end);
	}

	@Override
	public int getWeDeployAuthAppsCount() {
		return weDeployAuthAppPersistence.countAll();
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WeDeployAuthApp updateWeDeployAuthApp(
		WeDeployAuthApp weDeployAuthApp) {
		return weDeployAuthAppPersistence.update(weDeployAuthApp);
	}

	public WeDeployAuthAppLocalService getWeDeployAuthAppLocalService() {
		return weDeployAuthAppLocalService;
	}

	public void setWeDeployAuthAppLocalService(
		WeDeployAuthAppLocalService weDeployAuthAppLocalService) {
		this.weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	public WeDeployAuthAppPersistence getWeDeployAuthAppPersistence() {
		return weDeployAuthAppPersistence;
	}

	public void setWeDeployAuthAppPersistence(
		WeDeployAuthAppPersistence weDeployAuthAppPersistence) {
		this.weDeployAuthAppPersistence = weDeployAuthAppPersistence;
	}

	public com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService getWeDeployAuthTokenLocalService() {
		return weDeployAuthTokenLocalService;
	}

	public void setWeDeployAuthTokenLocalService(
		com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService weDeployAuthTokenLocalService) {
		this.weDeployAuthTokenLocalService = weDeployAuthTokenLocalService;
	}

	public WeDeployAuthTokenPersistence getWeDeployAuthTokenPersistence() {
		return weDeployAuthTokenPersistence;
	}

	public void setWeDeployAuthTokenPersistence(
		WeDeployAuthTokenPersistence weDeployAuthTokenPersistence) {
		this.weDeployAuthTokenPersistence = weDeployAuthTokenPersistence;
	}

	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp",
			weDeployAuthAppLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp");
	}

	@Override
	public String getOSGiServiceIdentifier() {
		return WeDeployAuthAppLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return WeDeployAuthApp.class;
	}

	protected String getModelClassName() {
		return WeDeployAuthApp.class.getName();
	}

	protected void runSQL(String sql) {
		try {
			DataSource dataSource = weDeployAuthAppPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = WeDeployAuthAppLocalService.class)
	protected WeDeployAuthAppLocalService weDeployAuthAppLocalService;
	@BeanReference(type = WeDeployAuthAppPersistence.class)
	protected WeDeployAuthAppPersistence weDeployAuthAppPersistence;
	@BeanReference(type = com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService.class)
	protected com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService weDeployAuthTokenLocalService;
	@BeanReference(type = WeDeployAuthTokenPersistence.class)
	protected WeDeployAuthTokenPersistence weDeployAuthTokenPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}