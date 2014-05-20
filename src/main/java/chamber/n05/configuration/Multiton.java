package chamber.n05.configuration;

/**
 * @version 1.0
 * @autor gcortes <mail>
 * @since 5/20/2014.
 */
public interface Multiton<T>
{
	<K extends T> K get(Class<K> key);
}
