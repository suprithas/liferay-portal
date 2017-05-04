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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppService;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthAppPersistence;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthTokenPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * @author Supritha Sundaram
 */
public abstract class WeDeployAuthAppServiceBaseImpl extends BaseServiceImpl
	implements WeDeployAuthAppService, IdentifiableOSGiService {

	public com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService getWeDeployAuthAppLocalService() {
		return weDeployAuthAppLocalService;
	}

	public void setWeDeployAuthAppLocalService(
		com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService weDeployAuthAppLocalService) {
		this.weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	public WeDeployAuthAppService getWeDeployAuthAppService() {
		return weDeployAuthAppService;
	}

	public void setWeDeployAuthAppService(
		WeDeployAuthAppService weDeployAuthAppService) {
		this.weDeployAuthAppService = weDeployAuthAppService;
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

	public com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenService getWeDeployAuthTokenService() {
		return weDeployAuthTokenService;
	}

	public void setWeDeployAuthTokenService(
		com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenService weDeployAuthTokenService) {
		this.weDeployAuthTokenService = weDeployAuthTokenService;
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

	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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

	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	@Override
	public String getOSGiServiceIdentifier() {
		return WeDeployAuthAppService.class.getName();
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

	@BeanReference(type = com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService.class)
	protected com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService weDeployAuthAppLocalService;
	@BeanReference(type = WeDeployAuthAppService.class)
	protected WeDeployAuthAppService weDeployAuthAppService;
	@BeanReference(type = WeDeployAuthAppPersistence.class)
	protected WeDeployAuthAppPersistence weDeployAuthAppPersistence;
	@BeanReference(type = com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService.class)
	protected com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService weDeployAuthTokenLocalService;
	@BeanReference(type = com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenService.class)
	protected com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenService weDeployAuthTokenService;
	@BeanReference(type = WeDeployAuthTokenPersistence.class)
	protected WeDeployAuthTokenPersistence weDeployAuthTokenPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}