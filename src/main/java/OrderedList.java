import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Number)
            return compareNumber(v1, v2);
        else
            return compareString(v1, v2);
    }

    private int compareNumber(T v1, T v2) {
        Integer intV1 = Optional.ofNullable((Integer) v1).orElse(0);
        Integer intV2 =  Optional.ofNullable((Integer) v2).orElse(0);
        int res = 0;
        if (intV1 < intV2) res = -1;
        if (intV1 > intV2) res = 1;
        return res;
    }

    private int compareString(T v1, T v2) {
        String strV1 = Optional.ofNullable((String) v1).orElse("").trim();
        String strV2 =  Optional.ofNullable((String) v2).orElse("").trim();
        return strV1.compareTo(strV2);
    }

    public void add(T value)
    {
        Node<T> insertNode = new Node(value);
        if (count() == 0) {
            this.head = insertNode;
            this.tail = insertNode;
            return;
        }

        Node<T> node = this.head;

        while (node != null) {
            if (node.prev == null && ((this._ascending && compare(node.value, value) >= 0) || (!this._ascending && compare(node.value, value) <= 0))) {
                addFirst(insertNode);
                return;
            }
            if (node.next == null && ((this._ascending && compare(node.value, value) <= 0) || (!this._ascending && compare(node.value, value) >= 0))) {
                addLast(insertNode);
                return;
            }
            if ((this._ascending && compare(node.value, value) <= 0 && compare(node.next.value, value) >= 0) || (!this._ascending && compare(node.value, value) >= 0 && compare(node.next.value, value) <= 0)) {
              addMiddle(node, insertNode);
                return;
            }
            node = node.next;
        }
    }

    private void addLast(Node<T> insertNode) {
        Node<T> temp = tail;
        tail = insertNode;
        tail.prev = temp;
        temp.next = tail;
    }

    private void addFirst(Node<T> insertNode) {
        Node<T> temp = head;
        head = insertNode;
        head.next = temp;
        temp.prev = head;
    }

    private void addMiddle(Node<T> node, Node<T> insertNode) {
        insertNode.prev = node;
        insertNode.next = node.next;
        node.next = insertNode;
        node.next.next.prev = insertNode;
    }

    public Node<T> find(T val)
    {
        Node<T> node = this.head;
        while (node != null) {
            if (node.value == val)
                return node;
            if (node.next == null)
                return null;
            if (this._ascending && compare(node.value, val) < 0 && compare(node.next.value, val) > 0)
                return null;
            if (!this._ascending && compare(node.value, val) > 0 && compare(node.next.value, val) < 0)
                return null;
            node = node.next;
        }
        return null;
    }

    public void delete(T val)
    {
        Node<T> fondNode = find(val);
        if (fondNode != null) {
            if (head != null && head.next == null) {
                this.head = null;
                this.tail = null;
                return;
            }
            if (fondNode == head) {
                this.head = fondNode.next;
                this.head.prev = null;
                return;
            }
            if (fondNode == tail) {
                this.tail = fondNode.prev;
                this.tail.next = null;
                return;
            }
            fondNode.prev.next = fondNode.next;
            fondNode.next.prev = fondNode.prev;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        Node iterNode = this.head;
        int i = 0;
        while (iterNode != null) {
            i++;
            iterNode = iterNode.next;
        }
        return i;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}