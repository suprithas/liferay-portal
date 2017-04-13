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

package com.liferay.portal.security.wedeploy.auth.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.wedeploy.auth.exception.NoSuchAppException;
import com.liferay.portal.security.wedeploy.auth.model.WedeployAuthApp;
import com.liferay.portal.security.wedeploy.auth.service.WedeployAuthAppLocalServiceUtil;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WedeployAuthAppPersistence;
import com.liferay.portal.security.wedeploy.auth.service.persistence.WedeployAuthAppUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class WedeployAuthAppPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.portal.security.wedeploy.auth.service"));

	@Before
	public void setUp() {
		_persistence = WedeployAuthAppUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<WedeployAuthApp> iterator = _wedeployAuthApps.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		WedeployAuthApp wedeployAuthApp = _persistence.create(pk);

		Assert.assertNotNull(wedeployAuthApp);

		Assert.assertEquals(wedeployAuthApp.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		_persistence.remove(newWedeployAuthApp);

		WedeployAuthApp existingWedeployAuthApp = _persistence.fetchByPrimaryKey(newWedeployAuthApp.getPrimaryKey());

		Assert.assertNull(existingWedeployAuthApp);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addWedeployAuthApp();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		WedeployAuthApp newWedeployAuthApp = _persistence.create(pk);

		newWedeployAuthApp.setUuid(RandomTestUtil.randomString());

		newWedeployAuthApp.setClientId(RandomTestUtil.randomString());

		newWedeployAuthApp.setClientName(RandomTestUtil.randomString());

		newWedeployAuthApp.setSecret(RandomTestUtil.randomString());

		newWedeployAuthApp.setCompanyId(RandomTestUtil.nextLong());

		_wedeployAuthApps.add(_persistence.update(newWedeployAuthApp));

		WedeployAuthApp existingWedeployAuthApp = _persistence.findByPrimaryKey(newWedeployAuthApp.getPrimaryKey());

		Assert.assertEquals(existingWedeployAuthApp.getUuid(),
			newWedeployAuthApp.getUuid());
		Assert.assertEquals(existingWedeployAuthApp.getWedeployAuthId(),
			newWedeployAuthApp.getWedeployAuthId());
		Assert.assertEquals(existingWedeployAuthApp.getClientId(),
			newWedeployAuthApp.getClientId());
		Assert.assertEquals(existingWedeployAuthApp.getClientName(),
			newWedeployAuthApp.getClientName());
		Assert.assertEquals(existingWedeployAuthApp.getSecret(),
			newWedeployAuthApp.getSecret());
		Assert.assertEquals(existingWedeployAuthApp.getCompanyId(),
			newWedeployAuthApp.getCompanyId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByclientName() throws Exception {
		_persistence.countByclientName(StringPool.BLANK);

		_persistence.countByclientName(StringPool.NULL);

		_persistence.countByclientName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		WedeployAuthApp existingWedeployAuthApp = _persistence.findByPrimaryKey(newWedeployAuthApp.getPrimaryKey());

		Assert.assertEquals(existingWedeployAuthApp, newWedeployAuthApp);
	}

	@Test(expected = NoSuchAppException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<WedeployAuthApp> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("WedeployAuthApp", "uuid",
			true, "wedeployAuthId", true, "clientId", true, "clientName", true,
			"secret", true, "companyId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		WedeployAuthApp existingWedeployAuthApp = _persistence.fetchByPrimaryKey(newWedeployAuthApp.getPrimaryKey());

		Assert.assertEquals(existingWedeployAuthApp, newWedeployAuthApp);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		WedeployAuthApp missingWedeployAuthApp = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingWedeployAuthApp);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		WedeployAuthApp newWedeployAuthApp1 = addWedeployAuthApp();
		WedeployAuthApp newWedeployAuthApp2 = addWedeployAuthApp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newWedeployAuthApp1.getPrimaryKey());
		primaryKeys.add(newWedeployAuthApp2.getPrimaryKey());

		Map<Serializable, WedeployAuthApp> wedeployAuthApps = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, wedeployAuthApps.size());
		Assert.assertEquals(newWedeployAuthApp1,
			wedeployAuthApps.get(newWedeployAuthApp1.getPrimaryKey()));
		Assert.assertEquals(newWedeployAuthApp2,
			wedeployAuthApps.get(newWedeployAuthApp2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, WedeployAuthApp> wedeployAuthApps = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(wedeployAuthApps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newWedeployAuthApp.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, WedeployAuthApp> wedeployAuthApps = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, wedeployAuthApps.size());
		Assert.assertEquals(newWedeployAuthApp,
			wedeployAuthApps.get(newWedeployAuthApp.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, WedeployAuthApp> wedeployAuthApps = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(wedeployAuthApps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newWedeployAuthApp.getPrimaryKey());

		Map<Serializable, WedeployAuthApp> wedeployAuthApps = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, wedeployAuthApps.size());
		Assert.assertEquals(newWedeployAuthApp,
			wedeployAuthApps.get(newWedeployAuthApp.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = WedeployAuthAppLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<WedeployAuthApp>() {
				@Override
				public void performAction(WedeployAuthApp wedeployAuthApp) {
					Assert.assertNotNull(wedeployAuthApp);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WedeployAuthApp.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("wedeployAuthId",
				newWedeployAuthApp.getWedeployAuthId()));

		List<WedeployAuthApp> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		WedeployAuthApp existingWedeployAuthApp = result.get(0);

		Assert.assertEquals(existingWedeployAuthApp, newWedeployAuthApp);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WedeployAuthApp.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("wedeployAuthId",
				RandomTestUtil.nextLong()));

		List<WedeployAuthApp> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		WedeployAuthApp newWedeployAuthApp = addWedeployAuthApp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WedeployAuthApp.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"wedeployAuthId"));

		Object newWedeployAuthId = newWedeployAuthApp.getWedeployAuthId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("wedeployAuthId",
				new Object[] { newWedeployAuthId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingWedeployAuthId = result.get(0);

		Assert.assertEquals(existingWedeployAuthId, newWedeployAuthId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WedeployAuthApp.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"wedeployAuthId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("wedeployAuthId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected WedeployAuthApp addWedeployAuthApp() throws Exception {
		long pk = RandomTestUtil.nextLong();

		WedeployAuthApp wedeployAuthApp = _persistence.create(pk);

		wedeployAuthApp.setUuid(RandomTestUtil.randomString());

		wedeployAuthApp.setClientId(RandomTestUtil.randomString());

		wedeployAuthApp.setClientName(RandomTestUtil.randomString());

		wedeployAuthApp.setSecret(RandomTestUtil.randomString());

		wedeployAuthApp.setCompanyId(RandomTestUtil.nextLong());

		_wedeployAuthApps.add(_persistence.update(wedeployAuthApp));

		return wedeployAuthApp;
	}

	private List<WedeployAuthApp> _wedeployAuthApps = new ArrayList<WedeployAuthApp>();
	private WedeployAuthAppPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}