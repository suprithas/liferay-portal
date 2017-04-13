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

package com.liferay.portal.security.wedeploy.auth.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the WedeployAuthApp service. Represents a row in the &quot;WedeployAuthApp&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthAppModel
 * @see com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppImpl
 * @see com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppImpl")
@ProviderType
public interface WedeployAuthApp extends WedeployAuthAppModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.security.wedeploy.auth.model.impl.WedeployAuthAppImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WedeployAuthApp, Long> WEDEPLOY_AUTH_ID_ACCESSOR =
		new Accessor<WedeployAuthApp, Long>() {
			@Override
			public Long get(WedeployAuthApp wedeployAuthApp) {
				return wedeployAuthApp.getWedeployAuthId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WedeployAuthApp> getTypeClass() {
				return WedeployAuthApp.class;
			}
		};
}