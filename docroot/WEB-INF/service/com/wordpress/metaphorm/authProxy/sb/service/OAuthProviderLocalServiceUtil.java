/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.wordpress.metaphorm.authProxy.sb.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the o auth provider local service. This utility wraps {@link com.wordpress.metaphorm.authProxy.sb.service.impl.OAuthProviderLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author stiansigvartsen
 * @see OAuthProviderLocalService
 * @see com.wordpress.metaphorm.authProxy.sb.service.base.OAuthProviderLocalServiceBaseImpl
 * @see com.wordpress.metaphorm.authProxy.sb.service.impl.OAuthProviderLocalServiceImpl
 * @generated
 */
public class OAuthProviderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.wordpress.metaphorm.authProxy.sb.service.impl.OAuthProviderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the o auth provider to the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthProvider the o auth provider
	* @return the o auth provider that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider addOAuthProvider(
		com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider oAuthProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOAuthProvider(oAuthProvider);
	}

	/**
	* Creates a new o auth provider with the primary key. Does not add the o auth provider to the database.
	*
	* @param providerId the primary key for the new o auth provider
	* @return the new o auth provider
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider createOAuthProvider(
		long providerId) {
		return getService().createOAuthProvider(providerId);
	}

	/**
	* Deletes the o auth provider with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param providerId the primary key of the o auth provider
	* @return the o auth provider that was removed
	* @throws PortalException if a o auth provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider deleteOAuthProvider(
		long providerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOAuthProvider(providerId);
	}

	/**
	* Deletes the o auth provider from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthProvider the o auth provider
	* @return the o auth provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider deleteOAuthProvider(
		com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider oAuthProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOAuthProvider(oAuthProvider);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider fetchOAuthProvider(
		long providerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOAuthProvider(providerId);
	}

	/**
	* Returns the o auth provider with the primary key.
	*
	* @param providerId the primary key of the o auth provider
	* @return the o auth provider
	* @throws PortalException if a o auth provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider getOAuthProvider(
		long providerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthProvider(providerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the o auth providers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth providers
	* @param end the upper bound of the range of o auth providers (not inclusive)
	* @return the range of o auth providers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider> getOAuthProviders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthProviders(start, end);
	}

	/**
	* Returns the number of o auth providers.
	*
	* @return the number of o auth providers
	* @throws SystemException if a system exception occurred
	*/
	public static int getOAuthProvidersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthProvidersCount();
	}

	/**
	* Updates the o auth provider in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthProvider the o auth provider
	* @return the o auth provider that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider updateOAuthProvider(
		com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider oAuthProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOAuthProvider(oAuthProvider);
	}

	/**
	* Updates the o auth provider in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthProvider the o auth provider
	* @param merge whether to merge the o auth provider with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the o auth provider that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider updateOAuthProvider(
		com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider oAuthProvider,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOAuthProvider(oAuthProvider, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider getProviderForRealm(
		java.lang.String realm)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wordpress.metaphorm.authProxy.sb.NoSuchOAuthProviderException {
		return getService().getProviderForRealm(realm);
	}

	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider addOAuthProvider(
		long userId, java.lang.String realm, java.lang.String consumerKey,
		java.lang.String consumerSecret, java.lang.String requestTokenURL,
		java.lang.String authoriseURL, java.lang.String accessTokenURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOAuthProvider(userId, realm, consumerKey,
			consumerSecret, requestTokenURL, authoriseURL, accessTokenURL);
	}

	public static java.util.List<com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider> getAllOAuthProviders()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllOAuthProviders();
	}

	public static com.wordpress.metaphorm.authProxy.sb.model.OAuthProvider getMatchingOAuthProvider(
		java.net.URL urlObj)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wordpress.metaphorm.authProxy.sb.NoSuchOAuthProviderException {
		return getService().getMatchingOAuthProvider(urlObj);
	}

	public static void clearService() {
		_service = null;
	}

	public static OAuthProviderLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OAuthProviderLocalService.class.getName());

			if (invokableLocalService instanceof OAuthProviderLocalService) {
				_service = (OAuthProviderLocalService)invokableLocalService;
			}
			else {
				_service = new OAuthProviderLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OAuthProviderLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OAuthProviderLocalService service) {
	}

	private static OAuthProviderLocalService _service;
}