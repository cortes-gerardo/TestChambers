package chamber.n05.configuration;

import com.google.inject.Inject;

import java.util.Map;

/**
 * @autor Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 5/20/2014.
 */
public class ConfigurationMultitonImpl implements ConfigurationMultiton
{
	private final Map<Class<? extends Configuration>, Object> map;

	@Inject
	public ConfigurationMultitonImpl(final Map<Class<? extends Configuration>, Object> map)
	{
		this.map = map;
	}

	@Override
	public <K extends Configuration> K get(final Class<K> key)
	{
		if (!map.containsKey(key))
		{
			map.put(key, create(key));
		}

		return key.cast(map.get(key));
	}

	private <K extends Configuration> K  create(final Class<K> key)
	{
		return null;
	}
}
