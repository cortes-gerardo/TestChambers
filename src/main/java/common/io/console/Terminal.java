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

package common.io.console;

import java.io.PrintWriter;
import java.io.Reader;

/**
 * Facade of java.io.Console for manage the case when the console device isn't available.
 * For more info read {@link http://docs.oracle.com/javase/6/docs/api/java/io/Console.html}
 *
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 2/10/14.
 */
public interface Terminal {
	Terminal printf(final String fmt, final Object... params) throws TerminalException;

	String readLine() throws TerminalException;

	String readLine(final String fmt, final Object... params) throws TerminalException;

	char[] readPassword() throws TerminalException;

	char[] readPassword(final String fmt, final Object... params) throws TerminalException;

	Reader reader() throws TerminalException;

	PrintWriter writer() throws TerminalException;

	class TerminalException extends RuntimeException {
	}
}
