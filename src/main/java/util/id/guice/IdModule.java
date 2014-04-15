package util.id.guice;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import util.id.AutoIncrementProvider;
import util.id.Id;
import util.id.annotation.AutoIncrement;

/**
 * Created by gcortes on 4/15/2014.
 */
public class IdModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<Id<Integer>>(){}).annotatedWith(AutoIncrement.class).toProvider(AutoIncrementProvider.class);
    }
}
