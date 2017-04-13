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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WedeployAuthApp}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthApp
 * @generated
 */
@ProviderType
public class WedeployAuthAppWrapper implements WedeployAuthApp,
	ModelWrapper<WedeployAuthApp> {
	public WedeployAuthAppWrapper(WedeployAuthApp wedeployAuthApp) {
		_wedeployAuthApp = wedeployAuthApp;
	}

	@Override
	public Class<?> getModelClass() {
		return WedeployAuthApp.class;
	}

	@Override
	public String getModelClassName() {
		return WedeployAuthApp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("wedeployAuthId", getWedeployAuthId());
		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("secret", getSecret());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long wedeployAuthId = (Long)attributes.get("wedeployAuthId");

		if (wedeployAuthId != null) {
			setWedeployAuthId(wedeployAuthId);
		}

		String clientId = (String)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String secret = (String)attributes.get("secret");

		if (secret != null) {
			setSecret(secret);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public WedeployAuthApp toEscapedModel() {
		return new WedeployAuthAppWrapper(_wedeployAuthApp.toEscapedModel());
	}

	@Override
	public WedeployAuthApp toUnescapedModel() {
		return new WedeployAuthAppWrapper(_wedeployAuthApp.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wedeployAuthApp.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wedeployAuthApp.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wedeployAuthApp.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wedeployAuthApp.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WedeployAuthApp> toCacheModel() {
		return _wedeployAuthApp.toCacheModel();
	}

	@Override
	public int compareTo(WedeployAuthApp wedeployAuthApp) {
		return _wedeployAuthApp.compareTo(wedeployAuthApp);
	}

	@Override
	public int hashCode() {
		return _wedeployAuthApp.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wedeployAuthApp.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WedeployAuthAppWrapper((WedeployAuthApp)_wedeployAuthApp.clone());
	}

	/**
	* Returns the client ID of this wedeploy auth app.
	*
	* @return the client ID of this wedeploy auth app
	*/
	@Override
	public java.lang.String getClientId() {
		return _wedeployAuthApp.getClientId();
	}

	/**
	* Returns the client name of this wedeploy auth app.
	*
	* @return the client name of this wedeploy auth app
	*/
	@Override
	public java.lang.String getClientName() {
		return _wedeployAuthApp.getClientName();
	}

	/**
	* Returns the secret of this wedeploy auth app.
	*
	* @return the secret of this wedeploy auth app
	*/
	@Override
	public java.lang.String getSecret() {
		return _wedeployAuthApp.getSecret();
	}

	/**
	* Returns the uuid of this wedeploy auth app.
	*
	* @return the uuid of this wedeploy auth app
	*/
	@Override
	public java.lang.String getUuid() {
		return _wedeployAuthApp.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wedeployAuthApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wedeployAuthApp.toXmlString();
	}

	/**
	* Returns the company ID of this wedeploy auth app.
	*
	* @return the company ID of this wedeploy auth app
	*/
	@Override
	public long getCompanyId() {
		return _wedeployAuthApp.getCompanyId();
	}

	/**
	* Returns the primary key of this wedeploy auth app.
	*
	* @return the primary key of this wedeploy auth app
	*/
	@Override
	public long getPrimaryKey() {
		return _wedeployAuthApp.getPrimaryKey();
	}

	/**
	* Returns the wedeploy auth ID of this wedeploy auth app.
	*
	* @return the wedeploy auth ID of this wedeploy auth app
	*/
	@Override
	public long getWedeployAuthId() {
		return _wedeployAuthApp.getWedeployAuthId();
	}

	@Override
	public void persist() {
		_wedeployAuthApp.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wedeployAuthApp.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this wedeploy auth app.
	*
	* @param clientId the client ID of this wedeploy auth app
	*/
	@Override
	public void setClientId(java.lang.String clientId) {
		_wedeployAuthApp.setClientId(clientId);
	}

	/**
	* Sets the client name of this wedeploy auth app.
	*
	* @param clientName the client name of this wedeploy auth app
	*/
	@Override
	public void setClientName(java.lang.String clientName) {
		_wedeployAuthApp.setClientName(clientName);
	}

	/**
	* Sets the company ID of this wedeploy auth app.
	*
	* @param companyId the company ID of this wedeploy auth app
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wedeployAuthApp.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wedeployAuthApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wedeployAuthApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wedeployAuthApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wedeployAuthApp.setNew(n);
	}

	/**
	* Sets the primary key of this wedeploy auth app.
	*
	* @param primaryKey the primary key of this wedeploy auth app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wedeployAuthApp.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wedeployAuthApp.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the secret of this wedeploy auth app.
	*
	* @param secret the secret of this wedeploy auth app
	*/
	@Override
	public void setSecret(java.lang.String secret) {
		_wedeployAuthApp.setSecret(secret);
	}

	/**
	* Sets the uuid of this wedeploy auth app.
	*
	* @param uuid the uuid of this wedeploy auth app
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_wedeployAuthApp.setUuid(uuid);
	}

	/**
	* Sets the wedeploy auth ID of this wedeploy auth app.
	*
	* @param wedeployAuthId the wedeploy auth ID of this wedeploy auth app
	*/
	@Override
	public void setWedeployAuthId(long wedeployAuthId) {
		_wedeployAuthApp.setWedeployAuthId(wedeployAuthId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WedeployAuthAppWrapper)) {
			return false;
		}

		WedeployAuthAppWrapper wedeployAuthAppWrapper = (WedeployAuthAppWrapper)obj;

		if (Objects.equals(_wedeployAuthApp,
					wedeployAuthAppWrapper._wedeployAuthApp)) {
			return true;
		}

		return false;
	}

	@Override
	public WedeployAuthApp getWrappedModel() {
		return _wedeployAuthApp;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wedeployAuthApp.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wedeployAuthApp.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wedeployAuthApp.resetOriginalValues();
	}

	private final WedeployAuthApp _wedeployAuthApp;
}