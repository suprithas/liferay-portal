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

package com.liferay.portal.security.wedploy.auth.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.security.wedploy.auth.web.internal.constants.WeDeployAuthPortletKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Supritha Sundaram
 */
@Component(
	property = {
		"com.liferay.portlet.css-class-wrapper=portal-security-wedeploy-auth-portlet",
		"com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=WeDeploy Authorization",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.info.keywords=WeDeploy Authorization",
		"javax.portlet.info.short-title=WeDeploy Authorization",
		"javax.portlet.info.title=WeDeploy Authorization",
		"javax.portlet.init-param.clear-request-parameters=true",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WeDeployAuthPortletKeys.WEDEPLOY_AUTH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class WeDeployAuthPortlet extends MVCPortlet {

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		super.processAction(actionRequest, actionResponse);
	}

}