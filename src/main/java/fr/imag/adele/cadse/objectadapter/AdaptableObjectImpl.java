/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
