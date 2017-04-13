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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portal.security.wedeploy.auth.service.http.WedeployAuthAppServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.security.wedeploy.auth.service.http.WedeployAuthAppServiceSoap
 * @generated
 */
@ProviderType
public class WedeployAuthAppSoap implements Serializable {
	public static WedeployAuthAppSoap toSoapModel(WedeployAuthApp model) {
		WedeployAuthAppSoap soapModel = new WedeployAuthAppSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWedeployAuthId(model.getWedeployAuthId());
		soapModel.setClientId(model.getClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setSecret(model.getSecret());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static WedeployAuthAppSoap[] toSoapModels(WedeployAuthApp[] models) {
		WedeployAuthAppSoap[] soapModels = new WedeployAuthAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WedeployAuthAppSoap[][] toSoapModels(
		WedeployAuthApp[][] models) {
		WedeployAuthAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WedeployAuthAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WedeployAuthAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WedeployAuthAppSoap[] toSoapModels(
		List<WedeployAuthApp> models) {
		List<WedeployAuthAppSoap> soapModels = new ArrayList<WedeployAuthAppSoap>(models.size());

		for (WedeployAuthApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WedeployAuthAppSoap[soapModels.size()]);
	}

	public WedeployAuthAppSoap() {
	}

	public long getPrimaryKey() {
		return _wedeployAuthId;
	}

	public void setPrimaryKey(long pk) {
		setWedeployAuthId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWedeployAuthId() {
		return _wedeployAuthId;
	}

	public void setWedeployAuthId(long wedeployAuthId) {
		_wedeployAuthId = wedeployAuthId;
	}

	public String getClientId() {
		return _clientId;
	}

	public void setClientId(String clientId) {
		_clientId = clientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getSecret() {
		return _secret;
	}

	public void setSecret(String secret) {
		_secret = secret;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private String _uuid;
	private long _wedeployAuthId;
	private String _clientId;
	private String _clientName;
	private String _secret;
	private long _companyId;
}