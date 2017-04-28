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

package com.liferay.portal.security.wedeploy.auth.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Supritha Sundaram
 * @generated
 */
@ProviderType
public class WeDeployAuthTokenPK implements Comparable<WeDeployAuthTokenPK>,
	Serializable {
	public long weDeployAuthTokenId;
	public long weDeployAuthAppId;

	public WeDeployAuthTokenPK() {
	}

	public WeDeployAuthTokenPK(long weDeployAuthTokenId, long weDeployAuthAppId) {
		this.weDeployAuthTokenId = weDeployAuthTokenId;
		this.weDeployAuthAppId = weDeployAuthAppId;
	}

	public long getWeDeployAuthTokenId() {
		return weDeployAuthTokenId;
	}

	public void setWeDeployAuthTokenId(long weDeployAuthTokenId) {
		this.weDeployAuthTokenId = weDeployAuthTokenId;
	}

	public long getWeDeployAuthAppId() {
		return weDeployAuthAppId;
	}

	public void setWeDeployAuthAppId(long weDeployAuthAppId) {
		this.weDeployAuthAppId = weDeployAuthAppId;
	}

	@Override
	public int compareTo(WeDeployAuthTokenPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (weDeployAuthTokenId < pk.weDeployAuthTokenId) {
			value = -1;
		}
		else if (weDeployAuthTokenId > pk.weDeployAuthTokenId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (weDeployAuthAppId < pk.weDeployAuthAppId) {
			value = -1;
		}
		else if (weDeployAuthAppId > pk.weDeployAuthAppId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WeDeployAuthTokenPK)) {
			return false;
		}

		WeDeployAuthTokenPK pk = (WeDeployAuthTokenPK)obj;

		if ((weDeployAuthTokenId == pk.weDeployAuthTokenId) &&
				(weDeployAuthAppId == pk.weDeployAuthAppId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, weDeployAuthTokenId);
		hashCode = HashUtil.hash(hashCode, weDeployAuthAppId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("weDeployAuthTokenId");
		sb.append(StringPool.EQUAL);
		sb.append(weDeployAuthTokenId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("weDeployAuthAppId");
		sb.append(StringPool.EQUAL);
		sb.append(weDeployAuthAppId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}