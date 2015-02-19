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

package common.io.console.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import common.io.console.ConsoleDevice;
import common.io.console.StreamDevice;
import common.io.console.Terminal;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 2/24/14.
 */
public class TerminalModule extends AbstractModule {
	@Override
	protected void configure() {
	}

	@Provides
	private Terminal getTerminal() {
		return (System.console() == null) ? createStreamDevice() : createConsoleDevice();
	}

	private StreamDevice createStreamDevice() {
		return new StreamDevice(System.in, System.out);
	}

	private ConsoleDevice createConsoleDevice() {
		return new ConsoleDevice(System.console());
	}
}
