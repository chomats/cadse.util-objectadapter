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

/**
 * Super class de tous les adapters.
 * 
 * @author <a href="http://cadse.imag.fr">cadse team</a>
 * 
 * @param <T>
 *            le type de l'adapter.
 */
public abstract class ObjectAdapter<T> {

	private T[] _ow;

	/**
	 * 
	 * @return le type de l'apdater.
	 */
	public abstract Class<T> getClassAdapt();

	/**
	 * 
	 * @return la liste des adapter surchargés.
	 */
	final public T[] getOverrideObject() {
		return _ow;
	}

	/**
	 * Quel sont les adapter que celui-ci surcharge ?
	 * 
	 * Cette methode n'est utilse que pour un AdaptableObject qui supporte un concept d'héritage
	 * dans l'implemtation des methods adapt et adapts.
	 * 
	 * @param ow
	 */
	final public void setOverrideObject(T... ow) {
		this._ow = ow;
	}

	/**
	 * Quel sont les adapter que celui-ci surcharge ? 
	 * Cette methode n'est utilse que pour un AdaptableObject qui supporte un concept d'héritage
	 * dans l'implemtation des methods adapt et adapts.
	 * 
	 * @param <E>
	 * @param ow
	 * @return
	 */
	final public <E> E override(T... ow) {
		this._ow = ow;
		return (E) this;
	}
}
