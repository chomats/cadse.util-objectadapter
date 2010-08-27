/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.imag.adele.cadse.objectadapter;

/**
 * Un apdaptle objet doit implementer cette interface ou utiliser l'implementation par defaut.
 * 
 * @author <a href="http://cadse.imag.fr">cadse team</a>
 */
public interface AdaptableObject {

	/**
	 * Adapts an adaptable object to an instance of class<T>
	 * @param <T> the type of the adapter.
	 * @param clazz the class of the adapter
	 * @return an adapter or null if not found.
	 */
	public <T extends ObjectAdapter<T>> T adapt(Class<T> clazz);
	
	/**
	 * recherche tout les adapter de type class<T>
	 * @param <T> the type of the adapter.
	 * @param clazz the class of the adapter.
	 * @return an array of adapter or null if not found.
	 */
	public <T extends ObjectAdapter<T>> T[] adapts(Class<T> clazz);
	
	/**
	 * Ajout un adapter
	 * @param <T> le type d'un adapter
	 * @param adapt un adapter
	 */
	public <T> void addAdapter(ObjectAdapter<T> adapt);
	
	/**
	 * Retire un adapter
	 * @param <T> le type d'un adpater
	 * @param adapt un adapter.
	 */
	public <T> void removeAdapter(ObjectAdapter<T> adapt);
}
