package util.id.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import util.id.AutoIncrementProvider;
import util.id.Id;
import util.id.annotation.AutoIncrement;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 4/15/2014.
 */
public class IdModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<Id<Integer>>(){}).annotatedWith(AutoIncrement.class).toProvider(AutoIncrementProvider.class).in(Singleton.class);
//        bind(new TypeLiteral<Id<Integer>>(){}).annotatedWith(AutoIncrement.class).toProvider(AutoIncrementProvider.class).in(RequestScoped.class);
    }
}
