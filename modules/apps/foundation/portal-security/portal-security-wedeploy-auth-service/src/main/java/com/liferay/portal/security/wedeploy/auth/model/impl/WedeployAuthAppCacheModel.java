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

package com.liferay.portal.security.wedeploy.auth.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WedeployAuthApp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WedeployAuthApp
 * @generated
 */
@ProviderType
public class WedeployAuthAppCacheModel implements CacheModel<WedeployAuthApp>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WedeployAuthAppCacheModel)) {
			return false;
		}

		WedeployAuthAppCacheModel wedeployAuthAppCacheModel = (WedeployAuthAppCacheModel)obj;

		if (wedeployAuthId == wedeployAuthAppCacheModel.wedeployAuthId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wedeployAuthId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", wedeployAuthId=");
		sb.append(wedeployAuthId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", secret=");
		sb.append(secret);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WedeployAuthApp toEntityModel() {
		WedeployAuthAppImpl wedeployAuthAppImpl = new WedeployAuthAppImpl();

		if (uuid == null) {
			wedeployAuthAppImpl.setUuid(StringPool.BLANK);
		}
		else {
			wedeployAuthAppImpl.setUuid(uuid);
		}

		wedeployAuthAppImpl.setWedeployAuthId(wedeployAuthId);

		if (clientId == null) {
			wedeployAuthAppImpl.setClientId(StringPool.BLANK);
		}
		else {
			wedeployAuthAppImpl.setClientId(clientId);
		}

		if (clientName == null) {
			wedeployAuthAppImpl.setClientName(StringPool.BLANK);
		}
		else {
			wedeployAuthAppImpl.setClientName(clientName);
		}

		if (secret == null) {
			wedeployAuthAppImpl.setSecret(StringPool.BLANK);
		}
		else {
			wedeployAuthAppImpl.setSecret(secret);
		}

		wedeployAuthAppImpl.setCompanyId(companyId);

		wedeployAuthAppImpl.resetOriginalValues();

		return wedeployAuthAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		wedeployAuthId = objectInput.readLong();
		clientId = objectInput.readUTF();
		clientName = objectInput.readUTF();
		secret = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(wedeployAuthId);

		if (clientId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientId);
		}

		if (clientName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (secret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secret);
		}

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public long wedeployAuthId;
	public String clientId;
	public String clientName;
	public String secret;
	public long companyId;
}