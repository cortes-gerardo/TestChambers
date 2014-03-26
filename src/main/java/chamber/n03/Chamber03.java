/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014. Gerardo Cortés Oquendo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package chamber.n03;

import chamber.n03.guice.Module03;
import chamber.n03.labrat.LabRatFactory;
import com.google.inject.Inject;
import common.Program;
import common.ProgramFactory;
import common.io.console.Terminal;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * Created by gcortes on 3/6/14.
 */
public class Chamber03 implements Program {
    private final Terminal terminal;
    private final LabRatFactory factory;

    @Inject
    public Chamber03(final Terminal terminal, final LabRatFactory factory) {
        this.terminal = terminal;
        this.factory = factory;
    }

    public static void main(final String[] args) {
        Program program = ProgramFactory.create(Chamber03.class, new Module03());
        program.execute();
    }

    @Override
    public void execute() {

    }
}
