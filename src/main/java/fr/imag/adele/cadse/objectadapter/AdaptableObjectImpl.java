/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package fr.imag.adele.cadse.objectadapter;

import fr.imag.adele.cadse.util.ArraysUtil;

/**
 * Implementation par default de AdaptableObject.
 * 
 * @author <a href="http://cadse.imag.fr">cadse team</a>
 */
public class AdaptableObjectImpl implements AdaptableObject {
	ObjectAdapter<?>[]	_adaptObjects	= null;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ObjectAdapter<T>> T adapt(Class<T> clazz) {
		if (_adaptObjects != null)
			for (int i = 0; i < _adaptObjects.length; i++) {
				if (_adaptObjects[i].getClassAdapt() == clazz)
					return (T) _adaptObjects[i];
			}

		return null;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ObjectAdapter<T>> T[] adapts(Class<T> clazz) {
		T[] ret = null;
		if (_adaptObjects != null)
			for (int i = 0; i < _adaptObjects.length; i++) {
				if (_adaptObjects[i].getClassAdapt() == clazz)
					ret = ArraysUtil.add(clazz, ret, (T) _adaptObjects[i]);
			}

		return ret;
	}

	@Override
	public <T> void addAdapter(ObjectAdapter<T> adapt) {
		_adaptObjects = ArraysUtil.add(ObjectAdapter.class, _adaptObjects, adapt);
	}

	@Override
	public <T> void removeAdapter(ObjectAdapter<T> adapt) {
		_adaptObjects = ArraysUtil.remove(ObjectAdapter.class, _adaptObjects, adapt);
	}

}
