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

package chamber.n01;

import chamber.n01.guice.Module01;
import chamber.n01.prime.Prime;
import com.google.inject.Inject;
import common.Program;
import common.ProgramFactory;
import common.io.console.Terminal;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 2/8/14.
 */
public class Chamber01 implements Program
{
	private final Terminal terminal;
	private final Prime prime;

	@Inject
	public Chamber01(final Terminal terminal, final Prime prime)
	{
		this.terminal = terminal;
		this.prime = prime;
	}

	public static void main(final String[] args)
	{
		Program program = ProgramFactory.create(Chamber01.class, new Module01());
		program.execute();
	}

	@Override
	public void execute()
	{
		final String line = terminal.readLine("write a number: ");
		final boolean isPrime = prime.apply(Long.parseLong(line));
		terminal.printf("%s prime", isPrime ? "is" : "isn't");
	}
}
