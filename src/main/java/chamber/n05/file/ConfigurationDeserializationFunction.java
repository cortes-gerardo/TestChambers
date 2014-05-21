package chamber.n05.file;

import chamber.n05.configuration.Configuration;
import com.google.common.base.Function;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import common.resource.Resource;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @version 1.0
 * @autor Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @since 5/21/2014.
 */
public class ConfigurationDeserializationFunction implements Function<Class<? extends Configuration>, Object>
{
	@Override
	public Object apply(final Class<? extends Configuration> input)
	{
		String name = input.getClass().getSimpleName();
		final File file = Resource.getFile(name);
		CharSource charSource = Files.asCharSource(file, Charset.defaultCharset());
		//Gson gson;
		return null;
	}
}
