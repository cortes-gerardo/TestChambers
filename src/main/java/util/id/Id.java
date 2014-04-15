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

package util.id;

import com.google.common.base.Objects;

/**
 * Id.class resolve the problem of use different kind of classes as ids like Integer, Long ans String all at the same time
 * The Passport/IdCard is a practical example, the Person class have an Id
 * <code>
 *     Map<Id<?>, Person> map = new HashMap<>();
 * </code>
 *
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 3/7/14.
 */
public class Id<T extends Comparable<T>> implements Comparable<Id<T>>
{
    private final T value;

    public static final <T extends Comparable<T>> Id<T> of(final T id)
    {
        return new Id<T>(id);
    }

    private Id(final T value)
    {
        this.value = value;
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    @Override
    public boolean equals(final Object obj)
    {
        return (this == obj) || (obj instanceof Id) && equals((Id<T>) obj);
    }

    private boolean equals(final Id<T> that)
    {
        return this.value.equals(that.value);
    }

    @Override
    public int compareTo(final Id<T> that)
    {
        return this.value.compareTo(that.value);
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this).add("value", value).toString();
    }
}
