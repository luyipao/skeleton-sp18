public class LinkedListDeque<T> {
    private int size;
    private IntNode first;
    private IntNode sentinel;

    public class IntNode
    {
        public T item;
        public IntNode prev;
        public IntNode next;

        public IntNode(T i, IntNode p, IntNode n)
        {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque()
    {
        size = 0;
        first = null;
        T item = null;
        sentinel = new IntNode(item, sentinel, sentinel);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addFirst(T item)
    {
        if (first == null)
        {
            first = new IntNode(item, sentinel, sentinel);
            sentinel.prev = first;
            sentinel.next = first;
        }
        else
        {
            sentinel.next.prev = new IntNode(item, sentinel, sentinel.next);
            sentinel.next = sentinel.next.prev;
        }
        size++;
    }
    public void addLast(T item)
    {
        if (first == null)
        {
            first = new IntNode(item, sentinel, sentinel);
            sentinel.next = first;
            sentinel.prev = first;
        }
        else {
            first.next = new IntNode(item, first, sentinel);
            sentinel.prev = first.next;
            first = first.next;
        }
        size++;
    }

    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        IntNode n = sentinel.next;
        while(n != sentinel)
        {
            System.out.print(n.item + " ");
            n = n.next;
        }
        System.out.println();
    }
    public T removeFirst()
    {
        if(first == null)
            return null;
        else if(first.prev == sentinel)
        {
            T temp = first.item;
            first = null;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size--;
            return null;
        }
        else
        {
            T temp = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return temp;
        }
    }
    public T removeLast()
    {
        if(first == null)
            return null;
        else
        {
            T temp = first.item;
            first.prev.next = sentinel;
            first.next.prev = first.next;
            if(first.prev != sentinel)
                first = first.prev;
            else
                first = null;
            size--;
            return temp;
        }
    }
    public T get(int index)
    {
        if(first == null || index > size - 1)
            return null;
        else
        {
            IntNode n = sentinel.next;
            while(index > 0)
            {
                n = n.next;
                index--;
            }
            return n.item;
        }
    }
    public T getRecursive(int index)
    {
        return getrecursive(index, sentinel.next);
    }
    private T getrecursive(int index, IntNode n)
    {
        if(n == null)
            return null;
        else if(index == 0)
            return n.item;
        index = index - 1;
        return getrecursive(index, n.next);
    }
}


