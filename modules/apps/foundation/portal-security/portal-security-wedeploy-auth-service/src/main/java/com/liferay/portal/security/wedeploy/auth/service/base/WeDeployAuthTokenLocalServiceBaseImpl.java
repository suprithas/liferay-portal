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
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService;
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
public abstract class WeDeployAuthTokenLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements WeDeployAuthTokenLocalService,
		IdentifiableOSGiService {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WeDeployAuthToken addWeDeployAuthToken(
		WeDeployAuthToken weDeployAuthToken) {
		weDeployAuthToken.setNew(true);

		return weDeployAuthTokenPersistence.update(weDeployAuthToken);
	}

	@Override
	public WeDeployAuthToken createWeDeployAuthToken(long weDeployAuthTokenId) {
		return weDeployAuthTokenPersistence.create(weDeployAuthTokenId);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public WeDeployAuthToken deleteWeDeployAuthToken(long weDeployAuthTokenId)
		throws PortalException {
		return weDeployAuthTokenPersistence.remove(weDeployAuthTokenId);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public WeDeployAuthToken deleteWeDeployAuthToken(
		WeDeployAuthToken weDeployAuthToken) {
		return weDeployAuthTokenPersistence.remove(weDeployAuthToken);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(WeDeployAuthToken.class,
			clazz.getClassLoader());
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return weDeployAuthTokenPersistence.findWithDynamicQuery(dynamicQuery);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return weDeployAuthTokenPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return weDeployAuthTokenPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return weDeployAuthTokenPersistence.countWithDynamicQuery(dynamicQuery);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return weDeployAuthTokenPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public WeDeployAuthToken fetchWeDeployAuthToken(long weDeployAuthTokenId) {
		return weDeployAuthTokenPersistence.fetchByPrimaryKey(weDeployAuthTokenId);
	}

	@Override
	public WeDeployAuthToken getWeDeployAuthToken(long weDeployAuthTokenId)
		throws PortalException {
		return weDeployAuthTokenPersistence.findByPrimaryKey(weDeployAuthTokenId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(weDeployAuthTokenLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WeDeployAuthToken.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("weDeployAuthTokenId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(weDeployAuthTokenLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(WeDeployAuthToken.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"weDeployAuthTokenId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(weDeployAuthTokenLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WeDeployAuthToken.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("weDeployAuthTokenId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return weDeployAuthTokenLocalService.deleteWeDeployAuthToken((WeDeployAuthToken)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return weDeployAuthTokenPersistence.findByPrimaryKey(primaryKeyObj);
	}

	@Override
	public List<WeDeployAuthToken> getWeDeployAuthTokens(int start, int end) {
		return weDeployAuthTokenPersistence.findAll(start, end);
	}
	@Override
	public int getWeDeployAuthTokensCount() {
		return weDeployAuthTokenPersistence.countAll();
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WeDeployAuthToken updateWeDeployAuthToken(
		WeDeployAuthToken weDeployAuthToken) {
		return weDeployAuthTokenPersistence.update(weDeployAuthToken);
	}

	public com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService getWeDeployAuthAppLocalService() {
		return weDeployAuthAppLocalService;
	}

	public void setWeDeployAuthAppLocalService(
		com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService weDeployAuthAppLocalService) {
		this.weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	public WeDeployAuthAppPersistence getWeDeployAuthAppPersistence() {
		return weDeployAuthAppPersistence;
	}

	public void setWeDeployAuthAppPersistence(
		WeDeployAuthAppPersistence weDeployAuthAppPersistence) {
		this.weDeployAuthAppPersistence = weDeployAuthAppPersistence;
	}

	public WeDeployAuthTokenLocalService getWeDeployAuthTokenLocalService() {
		return weDeployAuthTokenLocalService;
	}

	public void setWeDeployAuthTokenLocalService(
		WeDeployAuthTokenLocalService weDeployAuthTokenLocalService) {
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

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken",
			weDeployAuthTokenLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken");
	}

	@Override
	public String getOSGiServiceIdentifier() {
		return WeDeployAuthTokenLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return WeDeployAuthToken.class;
	}

	protected String getModelClassName() {
		return WeDeployAuthToken.class.getName();
	}

	protected void runSQL(String sql) {
		try {
			DataSource dataSource = weDeployAuthTokenPersistence.getDataSource();

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

	@BeanReference(type = com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService.class)
	protected com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService weDeployAuthAppLocalService;
	@BeanReference(type = WeDeployAuthAppPersistence.class)
	protected WeDeployAuthAppPersistence weDeployAuthAppPersistence;
	@BeanReference(type = WeDeployAuthTokenLocalService.class)
	protected WeDeployAuthTokenLocalService weDeployAuthTokenLocalService;
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