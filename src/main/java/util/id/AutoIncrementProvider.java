package util.id;

import com.google.inject.Provider;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 4/15/14.
 */
public class AutoIncrementProvider implements Provider<Id<Integer>>
{
	private int count;

	@Override
	public Id<Integer> get()
	{
		return Id.of(count++);
	}
}
