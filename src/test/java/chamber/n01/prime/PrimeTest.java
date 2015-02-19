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

package chamber.n01.prime;

import chamber.n01.guice.Module01;
import com.google.inject.Inject;
import org.jukito.All;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 2/8/14.
 */
@RunWith(JukitoRunner.class)
public class PrimeTest {
	private Prime prime;

	@Before
	@Inject
	public void setUp(final Prime prime) throws Exception {
		this.prime = prime;
	}

	@Test
	public void testPrimes(@All("primes") Long input) throws Exception {
		//WHEN
		final boolean actual = prime.apply(input);

		//THEN
		final String message = String.format("value %d is prime", input);
		assertTrue(message, actual);
	}

	@Test
	public void testNonPrimes(@All("nonPrimes") Long input) throws Exception {
		//WHEN
		final boolean actual = prime.apply(input);

		//THEN
		final String message = String.format("value %d is not prime", input);
		assertFalse(message, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException(@All("invalid") Long input) throws Exception {
		//WHEN
		prime.apply(input);
	}

	public static class Module extends JukitoModule {
		@Override
		protected void configureTest() {
			install(new Module01());
			bindManyNamedInstances(Long.class, "primes", getPrimes());
			bindManyNamedInstances(Long.class, "nonPrimes", getNonPrimes());
			bindManyNamedInstances(Long.class, "invalid", getInvalid());
		}

		private Long[] getInvalid() {
			return new Long[]{0L, -1L, -2L};
		}

		private Long[] getPrimes() {
			return new Long[]{2L, 3L, 5L, 7L, 11L, 13L, 17L};
		}

		private Long[] getNonPrimes() {
			return new Long[]{4L, 6L, 8L, 9L, 10L, 12L, 14L, 15L};
		}
	}

}
