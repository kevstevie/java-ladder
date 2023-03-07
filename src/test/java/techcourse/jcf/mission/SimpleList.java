package techcourse.jcf.mission;

public interface SimpleList<T> {

    static <E> SimpleList<E> fromArrayToList(E[] arrays) {
        JudeArrayList<E> list = new JudeArrayList<>();
        for (Object array : arrays) {
            list.add((E) array);
        }
        return list;
    }

    static <E extends Number> Double sum(SimpleList<E> simpleList) {
        Double result = 0.0;
        for (int i = 0; i < simpleList.size(); i++) {
            result += simpleList.get(i).doubleValue();
        }
        return result;
    }

    static <E> SimpleList<E> filterNegative(SimpleList<? extends Number> simpleList) {
        SimpleList<E> list = new JudeArrayList<>();
        for (int i = 0; i < simpleList.size(); i++) {
            if (simpleList.get(i).doubleValue() < 0) {
                continue;
            }
            list.add((E) simpleList.get(i));
        }
        return list;
    }

    static <E> void copy(SimpleList<? extends E> copy, SimpleList<? super E> origin) {
        origin.clear();
        for (int i = 0; i < copy.size(); i++) {
            origin.add(copy.get(i));
        }
    }

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();
}
