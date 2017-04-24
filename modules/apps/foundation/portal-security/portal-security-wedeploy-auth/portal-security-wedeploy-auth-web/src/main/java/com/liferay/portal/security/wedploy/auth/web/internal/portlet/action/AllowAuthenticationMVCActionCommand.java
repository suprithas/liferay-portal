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

package com.liferay.portal.security.wedploy.auth.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.security.wedploy.auth.web.internal.constants.WeDeployAuthPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Supritha Sundaram
 */
@Component(
	property = {
		"javax.portlet.name=" + WeDeployAuthPortletKeys.WEDEPLOY_VIEW,
		"mvc.command.name=/authorize/allow_user"
	},
	service = MVCActionCommand.class
)
public class AllowAuthenticationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		String reporterEmailAddress = ParamUtil.getString(
			actionRequest, "reporterEmailAddress");
		long reportedUserId = ParamUtil.getLong(
			actionRequest, "reportedUserId");
		String contentTitle = ParamUtil.getString(
			actionRequest, "contentTitle");
		String contentURL = ParamUtil.getString(actionRequest, "contentURL");
		String reason = ParamUtil.getString(actionRequest, "reason");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			"com.liferay.portlet.flags.model.FlagsEntry", actionRequest);

				actionResponse.setRenderParameter("mvcPath", "authorize.jsp");
	}


	//private FlagsEntryService _flagsEntryService;

}