package techcourse.jcf.mission;

public class JudeArrayList<T> implements SimpleList<T> {

    private int size;
    private int realSize = 10;
    private Object[] array;

    public JudeArrayList() {
        this.array = new Object[realSize];
        this.size = 0;
    }

    @Override
    public boolean add(T value) {
        array = resizeArray();
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array = resizeArray();
        size++;
        Object[] tmp = new Object[realSize];
        for (int i = 0; i < index; i++) {
            tmp[i] = array[i];
        }
        tmp[index] = value;
        for (int i = index + 1; i < size; i++) {
            tmp[i] = array[i - 1];
        }

        array = tmp;

    }

    @Override
    public T set(int index, T value) {
        T prev = (T) array[index];
        array[index] = value;
        return prev;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(T value) {
        Object[] tmp = new Object[realSize];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            tmp[j++] = array[i];
        }
        array = tmp;
        size--;
        return true;
    }

    @Override
    public T remove(int index) {
        int j = 0;
        Object[] tmp = new Object[realSize];
        T removed = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                removed = (T) array[index];
                continue;
            }
            tmp[j++] = array[i];
        }
        size--;
        array = tmp;
        return removed;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private Object[] resizeArray() {
        if (size + 1 > array.length) {
            Object[] tmp = array;
            realSize *= 2;
            this.array = new Object[realSize];
            for (int i = 0; i < size; i++) {
                array[i] = tmp[i];
            }
        }
        return array;
    }
}
