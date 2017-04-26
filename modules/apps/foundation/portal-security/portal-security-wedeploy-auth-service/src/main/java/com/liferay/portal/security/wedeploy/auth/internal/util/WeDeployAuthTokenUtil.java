package com.liferay.portal.security.wedeploy.auth.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.security.wedeploy.auth.constants.WeDeployAuthTokenConstants;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.service.WeDeployAuthTokenLocalServiceUtil;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WeDeployAuthAppPersistence;

/**
 * @author Supritha Sundaram
 */
public class WeDeployAuthTokenUtil {

    public static String generateAuthorizationCode(
            String clientId, long userId, long companyId,
            ServiceContext serviceContext)
        throws PortalException, SystemException {

        String token = randomizeToken(clientId);

        try {
            WeDeployAuthTokenLocalServiceUtil.addWeDeployAuthToken(
                userId, token,WeDeployAuthTokenConstants.TOKEN_TYPE_REQUEST,
                companyId, new ServiceContext());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    public static String generateAccessToken(
            String clientId, String clientSecret, String authorizationCode,
            long userId, long companyId, ServiceContext serviceContext) {

        String token = randomizeToken(clientId.concat(authorizationCode));

        try {
            WeDeployAuthTokenLocalServiceUtil.addWeDeployAuthToken(
                userId, token, WeDeployAuthTokenConstants.TOKEN_TYPE_ACCESS,
                companyId, new ServiceContext());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    private static String randomizeToken(String token) {
        return DigesterUtil.digestHex(
                Digester.MD5, token, PwdGenerator.getPassword());
    }

    static WeDeployAuthAppPersistence _weDeployAuthAppPersistence;
}
