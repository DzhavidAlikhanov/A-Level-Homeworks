package ua.alikhanov.hw.hw012;

public class ArrayList<T> {
    private Object[] array;
    int size;

    public ArrayList(int size) {
        this.size = 0;
        array = new Object[Math.max(size, 10)];
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void add(T element, int index) {
        ensureCapacity();
        if (index >= 0 && index <= size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isContains(T element) {
        return indexOf(element) != -1;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public T remove(int index) {
        if (index >= 0 && index < size) {
            T removedElement = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[--size] = null;
            return removedElement;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    protected void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = size * 2;
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }
}