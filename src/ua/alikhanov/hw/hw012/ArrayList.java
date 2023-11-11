package ua.alikhanov.hw.hw012;

public class ArrayList<T> {
    protected Object[] array;
    protected int size;

    ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }

    //Add element to the end of array {1,2,3} -> {1,2,3,4}
    void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    //Add element to given position of array {1,2,3} -> {1,4,2,3}
    void add(T element, int index) {
        ensureCapacity();
        if (index >= 0 && index <= size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Returns index of the given element, if element doesn't exist return -1
    int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    boolean isContains(T element) {
        return indexOf(element) != -1;
    }

    T get(int index) {
        if (index >= 0 && index < size) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    T remove(int index) {
        if (index >= 0 && index < size) {
            T removedElement = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[--size] = null; // to avoid memory leak
            return removedElement;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = size * 2;
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }
}