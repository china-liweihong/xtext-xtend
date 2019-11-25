/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author vivienjovet - Initial contribution and API
 */
public class Junit4LibClasspathAdder extends AbstractLibClasspathAdder {

	public static final IPath JUNIT4_LIBRARY_PATH = new Path("org.eclipse.jdt.junit.JUNIT_CONTAINER/4");
	public static final String BUNDLE_ID = "org.junit";

	@Override
	protected IClasspathEntry createContainerClasspathEntry() {
		return JavaCore.newContainerEntry(JUNIT4_LIBRARY_PATH);
	}

	@Override
	protected String[] getBundleIds() {
		return new String[] { BUNDLE_ID };
	}

}
