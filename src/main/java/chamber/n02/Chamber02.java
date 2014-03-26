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

package chamber.n02;

import chamber.n02.factorial.Factorial;
import chamber.n02.guice.Module02;
import com.google.inject.Inject;
import common.Program;
import common.ProgramFactory;
import common.io.console.Terminal;

/**
 * Created by Gerardo on 2/3/14.
 */
public class Chamber02 implements Program {
	private final Factorial factorial;
	private final Terminal terminal;

	@Inject
	public Chamber02(final Factorial factorial, final Terminal terminal) {
		this.factorial = factorial;
		this.terminal = terminal;
	}

	public static void main(final String[] args) {
		final Program program = ProgramFactory.create(Chamber02.class, new Module02());
		program.execute();
	}

	@Override
	public void execute() {
		final String line = terminal.readLine("write a number: ");
		final long input = Long.parseLong(line);
		terminal.printf("The factorial of %d is %d", input, factorial.apply(input));
	}
}