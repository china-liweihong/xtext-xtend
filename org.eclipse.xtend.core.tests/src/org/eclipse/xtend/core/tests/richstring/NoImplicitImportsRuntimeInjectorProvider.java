/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.RuntimeTestSetup;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @author dietrich - Initial contribution and API
 */
public class NoImplicitImportsRuntimeInjectorProvider extends RuntimeInjectorProvider {

	@Singleton
	public static class NoImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
		@Override
		protected List<Class<?>> getExtensionClasses() {
			return Lists.newArrayList();
		}

		@Override
		protected List<Class<?>> getStaticImportClasses() {
			return Lists.newArrayList();
		}
	}

	@Override
	protected Injector internalCreateInjector() {

		return new RuntimeTestSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtendRuntimeTestModule() {
					public Class<? extends ImplicitlyImportedFeatures> bindImplicitlyImportedFeatures() {
						return NoImplicitlyImportedFeatures.class;
					}
				});

			}
		}.createInjectorAndDoEMFRegistration();
	}
}