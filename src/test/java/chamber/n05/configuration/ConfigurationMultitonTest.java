package chamber.n05.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @autor Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 5/20/2014.
 */
public class ConfigurationMultitonTest
{
	private ConfigurationMultiton multiton;

	@Before
	public void setUp() throws Exception
	{
		final CacheLoader<? super Class<? extends Configuration>, Object> loader = new CacheLoader<Class<? extends Configuration>, Object>()
		{
			@Override
			public Object load(final Class<? extends Configuration> key) throws Exception
			{
				String name = key.getClass().getSimpleName();

				return null;
			}
		};

		final LoadingCache<Class<? extends Configuration>, Object> cache = CacheBuilder.newBuilder().build(loader);
		multiton = new ConfigurationMultitonImpl(cache);
	}

	@Test
	public void test() throws ExecutionException
	{
		DataBaseConf conf = multiton.get(DataBaseConf.class);
	}
}
