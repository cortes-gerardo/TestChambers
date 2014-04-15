package util.id;

import com.google.inject.Provider;

/**
 * Created by gcortes on 4/15/2014.
 */
public class AutoIncrementProvider implements Provider<Id<Integer>> {
    private int count;

    @Override
    public Id<Integer> get() {
        return Id.of(count++);
    }
}
