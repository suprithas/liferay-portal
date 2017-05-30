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
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Supritha Sundaram
 */
@Component(
	property = {"model.class.name=com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthToken"},
	service = BaseModelPermissionChecker.class
)
public class WeDeployAuthTokenPermission implements BaseModelPermissionChecker {

	public static void check(
		PermissionChecker permissionChecker,
		WeDeployAuthToken weDeployAuthToken, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, weDeployAuthToken, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, WeDeployAuthToken.class.getName(),
				weDeployAuthToken.getWeDeployAuthTokenId(), actionId);
		}
	}

	public static void check(
		PermissionChecker permissionChecker, long weDeployAuthTokenId,
		String actionId)
		throws PortalException {

		if (!contains(permissionChecker, weDeployAuthTokenId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, WeDeployAuthToken.class.getName(), weDeployAuthTokenId,
				actionId);
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, WeDeployAuthToken weDeployAuthToken,
		String actionId) {

		String portletId = PortletProviderUtil.getPortletId(
			WeDeployAuthToken.class.getName(), PortletProvider.Action.EDIT);

		if (permissionChecker.hasOwnerPermission(
			weDeployAuthToken.getCompanyId(), WeDeployAuthToken.class.getName(),
			weDeployAuthToken.getWeDeployAuthTokenId(), weDeployAuthToken.getUserId(),
			actionId)) {

			return true;
		}

		return false;
		/*return permissionChecker.hasPermission(
			null, WeDeployAuthToken.class.getName(),
			weDeployAuthToken.getWeDeployAuthTokenId(),
			actionId);*/
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long weDeployAuthTokenId,
		String actionId)
		throws PortalException {

		WeDeployAuthToken weDeployAuthToken = _weDeployAuthTokenLocalService
			.getWeDeployAuthToken(
				weDeployAuthTokenId);

		return contains(permissionChecker, weDeployAuthToken, actionId);
	}

	@Override
	public void checkBaseModel(
		PermissionChecker permissionChecker, long groupId, long primaryKey,
		String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}

	@Reference(unbind = "-")
	protected void setWeDeployAuthTokenLocalService(
		WeDeployAuthTokenLocalService weDeployAuthTokenLocalService) {

		_weDeployAuthTokenLocalService = weDeployAuthTokenLocalService;
	}

	private static WeDeployAuthTokenLocalService _weDeployAuthTokenLocalService;

}