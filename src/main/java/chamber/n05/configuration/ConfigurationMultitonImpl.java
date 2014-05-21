package chamber.n05.configuration;

import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;

import java.util.concurrent.ExecutionException;

/**
 * @autor Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 5/20/2014.
 */
public class ConfigurationMultitonImpl implements ConfigurationMultiton
{
	private final LoadingCache <Class<? extends Configuration>, Object> cache;

	@Inject
	public ConfigurationMultitonImpl(final LoadingCache<Class<? extends Configuration>, Object> cache)
	{
		this.cache = cache;
	}

	@Override
	public <K extends Configuration> K get(final Class<K> type) throws ExecutionException
	{
		return type.cast(cache.get(type));
	}

	private <K extends Configuration> K  create(final Class<K> key)
	{
		return null;
	}
}
