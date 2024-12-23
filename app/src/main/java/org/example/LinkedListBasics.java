package org.example;

public interface LinkedListBasics<Type extends Comparable<Type>>
{
    public void add(Node<Type> newNode);

    public void insert(Node<Type> newData, int index);

    public Node<Type> getFurthestNode();

    public boolean isEmpty();

    public Node<Type> remove(int index);

    public Type search(Type data);

    public Node<Type> getNode(int index);
}
