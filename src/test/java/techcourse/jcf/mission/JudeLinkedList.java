package techcourse.jcf.mission;

public class JudeLinkedList<T> implements SimpleList<T>{

    class Node<T> {
        private T value;
        private Node<T> nextNode;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private Node<T> root;
    private int size;

    public JudeLinkedList() {
        this.root = new Node<T>();
        this.size = 0;
    }

    @Override
    public boolean add(T value) {
        Node<T> nodeNow = root;
        while (nodeNow.nextNode != null) {
            nodeNow = nodeNow.nextNode;
        }
        nodeNow.nextNode = new Node<T>(value);
        size++;
        return true;
    }

    @Override
    public void add(int index, T value) {
        Node<T> nodeNow = root;

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            nodeNow = nodeNow.nextNode;
        }
        Node<T> next = nodeNow.nextNode;

        nodeNow.nextNode = new Node<T>(value);
        nodeNow.nextNode.nextNode = next;

        size++;

    }

    @Override
    public T set(int index, T value) { //1
        Node<T> nodeNow = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            nodeNow = nodeNow.nextNode;// 0
        }
        Node<T> next = nodeNow.nextNode.nextNode; // 2
        T val = nodeNow.nextNode.value; //0.val
        nodeNow.nextNode = new Node<T>(value); // 1
        nodeNow.nextNode.nextNode = next; // 2

        return val;
    }

    @Override
    public T get(int index) {
        Node<T> nodeNow = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            nodeNow = nodeNow.nextNode;
        }
        return nodeNow.value;
    }

    @Override
    public boolean contains(T value) {
        Node<T> now = root;
        for (int i = 0; i < size; i++) {
            now = now.nextNode;
            if (now.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        var now = root;
        for (int i = 0; i < size; i++) {
            now = now.nextNode;
            if (now.value.equals(value)) {
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
        Node<T> now = root;
        for (int i = 0; i < size - 1; i++) {
            if (now.nextNode.value.equals(value)) {
                var next = now.nextNode.nextNode;
                now.nextNode = next;
                size--;
                return true;
            }
            now = now.nextNode;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        Node<T> now = root;
        var prev = root;
        var next = root;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            prev = now;
            now = now.nextNode;
            next = now.nextNode;
        }
        var val = now.value;
        prev.nextNode = next;
        size--;
        return val;
    }

    @Override
    public void clear() {
        root = new Node<T>();
        size = 0;
    }
}
