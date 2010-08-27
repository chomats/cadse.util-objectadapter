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
