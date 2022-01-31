public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;
    private int capacity;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 3;
        back = 4;
        capacity = 8;
    }

    @Override
    public void addFirst(T item) {
        items[front] = item;
        int temp = (front - 1) % capacity;
        front = (temp >= 0) ? temp : temp + capacity;
        size++;
        resize();
    }

    @Override
    public void addLast(T item) {
        items[back] = item;
        back = (back + 1) % capacity;
        size++;
        resize();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(front + 1 + i) % capacity]);
        }
    }

    @Override
    public T removeFirst() {
        if (items[(front + 1) % capacity] == null) {
            return null;
        }
        front = (front + 1) % capacity;
        T temp = items[front];
        items[front] = null;
        size--;
        resize();
        return temp;
    }

    @Override
    public T removeLast() {
        int t = (back - 1) % capacity;
        if (t < 0) {
            t += capacity;
        }
        if (items[t] == null) {
            return null;
        }
        back = t;
        T temp = items[back];
        items[back] = null;
        size--;
        resize();
        return temp;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        index = (front + index + 1) % capacity;
        return items[index];
    }

    private void resize() {
        if (size >= capacity) {
            T[] temp = (T[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                temp[size / 2 + i] = items[(front + 1) % capacity];
                front++;
            }
            items = temp;
            front = size / 2 - 1;
            back = front + size + 1;
            capacity *= 2;
        } else if (size < capacity / 4 && capacity >= 16) {
            T[] temp = (T[]) new Object[capacity / 2];
            for (int i = 0; i < size; i++) {
                temp[capacity / 4 + i] = items[(front + 1) % capacity];
                front++;
            }
            items = temp;
            front = capacity / 4 - 1;
            back = front + size + 1;
            capacity /= 2;
        }
    }
}
