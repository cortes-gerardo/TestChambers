package util.id;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 4/15/14.
 */
@Singleton
public class AutoIncrementProvider implements Provider<Id<Integer>>
{
	private int count;

	@Override
	public Id<Integer> get()
	{
        System.out.println(this);
        return Id.of(count++);
	}
}
