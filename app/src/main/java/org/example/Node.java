package org.example;

// Class Node Which Is Generic And Extends The Parent Comparable
public class Node<Type extends Comparable<Type>>
{
    // The Data The Node Holds
    private Type data;
    // Access To The Node In Front
    private Node<Type> nextNode;
    
    /**
     * Constructor With Data Parameter
     * @param data, the data to be stored within this node
     */
    public Node(Type data)
    {
        this.data = data;
    }

    // Default Constructor 
    public Node()
    {
        data = null;
    }

    /**
     * Gets From The Node
     * @return returns the data
     */
    public Type getData()
    {
        return data;
    }

    /**
     * Sets The Data To The Node
     * @param data, the data to be added
     */
    public void setData(Type data)
    {
        this.data = data;
    }
     
    /**
     * Gets The Next Node In The Linked List
     * @return returns the next node
     */
    public Node<Type> getNext()
    {
        return nextNode;
    }

    /**
     * Sets The Next Node
     * @param nextNode, the node to be set
     */
    public void setNext(Node<Type> nextNode)
    {
        this.nextNode = nextNode;
    }

    /**
     * Checks If Next Node Is Not Null
     * @return returns true or false
     */
    public boolean hasNext()
    {
        return nextNode != null;
    }

}