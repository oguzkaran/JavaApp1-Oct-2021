/*----------------------------------------------------------------------------------------------------------------------
    CSDStack sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CSDStack<E> extends ArrayList<E> {
    public boolean empty()
    {
        return this.isEmpty();
    }

    public E push(E item)
    {
        this.add(item);

        return item;
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        return this.remove(this.size() - 1);
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return this.get(this.size() - 1);
    }

    public int search(Object obj)
    {
        int index = this.indexOf(obj);

        return index == -1 ? index : this.size() - index;
    }
}
