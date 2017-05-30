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

package com.liferay.portal.security.wedeploy.auth.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthAppLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Supritha Sundaram
 */
@Component(
	property = {"model.class.name=com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp"},
	service = BaseModelPermissionChecker.class
)
public class WeDeployAuthAppPermission implements BaseModelPermissionChecker {

	public static void check(
		PermissionChecker permissionChecker,
		WeDeployAuthApp weDeployAuthApp, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, weDeployAuthApp, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, WeDeployAuthApp.class.getName(),
				weDeployAuthApp.getWeDeployAuthAppId(), actionId);
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long weDeployAuthAppId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, weDeployAuthAppId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, WeDeployAuthApp.class.getName(), weDeployAuthAppId,
				actionId);
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, WeDeployAuthApp weDeployAuthApp,
		String actionId) {

		String portletId = PortletProviderUtil.getPortletId(
			WeDeployAuthApp.class.getName(), PortletProvider.Action.EDIT);

		if (permissionChecker.hasOwnerPermission(
			weDeployAuthApp.getCompanyId(), WeDeployAuthApp.class.getName(),
			weDeployAuthApp.getWeDeployAuthAppId(), weDeployAuthApp.getUserId(),
			actionId)) {

			return true;
		}

		return false;
		/*return permissionChecker.hasPermission(
			null, WeDeployAuthApp.class.getName(),
			weDeployAuthApp.getWeDeployAuthAppId(),
			actionId);*/
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long weDeployAuthAppId,
			String actionId)
		throws PortalException {

		WeDeployAuthApp weDeployAuthApp = _weDeployAuthAppLocalService
			.getWeDeployAuthApp(
			weDeployAuthAppId);

		return contains(permissionChecker, weDeployAuthApp, actionId);
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}

	@Reference(unbind = "-")
	protected void setWeDeployAuthAppLocalService(
		WeDeployAuthAppLocalService weDeployAuthAppLocalService) {

		_weDeployAuthAppLocalService = weDeployAuthAppLocalService;
	}

	private static WeDeployAuthAppLocalService _weDeployAuthAppLocalService;

}