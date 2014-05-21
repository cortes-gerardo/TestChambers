package chamber.n05.configuration;

import java.util.concurrent.ExecutionException;

/**
 * @version 1.0
 * @autor Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @since 5/20/2014.
 */
public interface Multiton<T>
{
	<K extends T> K get(final Class<K> key) throws ExecutionException;
}
