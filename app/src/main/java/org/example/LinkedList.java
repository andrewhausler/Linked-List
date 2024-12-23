package org.example;

public class LinkedList<Type extends Comparable<Type>> implements LinkedListBasics<Type>
{
    // The Starting Point Of The List
    private Node<Type> head;
    // Keeps Track Of Length Of List
    int nodeLength = 0;
    
    // Default Constructor
    public LinkedList()
    {
        head = new Node<Type>();
        nodeLength++;
    }

    /**
     * Constructor With Decided Data For Head
     * @param data, the generic data value 
     */
    public LinkedList(Type data)
    {
        head = new Node<Type>();
        head.setData(data);
        nodeLength++;
    }

    /**
     * Checks If List Is Empty
     * @return returns true or false
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Gives You The Furthest Node Until One Points To Null
     * @return returns the last node
     */
    public Node<Type> getFurthestNode()
    {
        if(isEmpty())
        {
            throw new NullPointerException();
        }
        else
        {
            Node<Type> node = head;
            if(nodeLength == 1)
            {
                return head;
            }
            else
            {
                while(node.hasNext())
                {
                    node = node.getNext();
                }
                return node;
            }
        }
    }

    /**
     * Adds A New Node To The Next Null Pointer
     * @param newNode, the node to be added
     */
    public void add(Node<Type> newNode)
    {
        if(isEmpty())
        {
            throw new NullPointerException();
        }
        else
        {
            getFurthestNode().setNext(newNode);
            nodeLength++;
        }
    }

    /**
     * Inserts A New Node At A Given Position
     * @param newNode, the node to be inserted
     * @param index, the position in the list
     */
    public void insert(Node<Type> newNode, int index)
    {
        Node<Type> tempNode;
        if(index < 0 || index >= nodeLength)
        {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0)
        {
            tempNode = head;
            head = newNode;
            newNode.setNext(tempNode);
        }
        else
        {
            Node<Type> node = head;
            for(int i=0; i<index-1; i++)
            {
                node = node.getNext();
            }
            tempNode = node.getNext();
            node.setNext(newNode);
            newNode.setNext(tempNode);
        }
        nodeLength++;
    }

    /**
     * Removes The Specified Node From Index
     * @param index, the position in the list
     * @return returns the node that was removed
     */
    public Node<Type> remove(int index)
    {
        Node<Type> tempNode;
        Node<Type> removedNode = null;

        if(isEmpty())
        {
            throw new IndexOutOfBoundsException();
        }

        else if(index == 0)
        {
            if(head.getNext() == null)
            {
                removedNode = head;
                head = null;
            }
            else
            {
                tempNode = head.getNext();
                removedNode = head;
                head = tempNode;
            }
        }
        
        else if(index > 0 && index < nodeLength)
        {
            Node<Type> node = head;
            for(int i=0; i<index-1; i++)
            {
                node = node.getNext();
            }

            if(node.getNext() == null)
            {
                removedNode = null;
            }
            else
            {
                tempNode = node.getNext().getNext();
                removedNode = node.getNext();
                node.setNext(tempNode);
            }
        }

        else
        {
            throw new IndexOutOfBoundsException();
        }
        return removedNode;
    }

    /**
     * Searches For The First Occurence Of A Nodes Data
     * @param data, the data searching for
     * @return returns the node that contains the data
     */
    public Type search(Type data)
    {
        if(head == null)
        {
            throw new NullPointerException();
        }
        else
        {
            Node<Type> node = head;
            for(int i=0; i<nodeLength-1; i++)
            {
                if(node.getData().compareTo(data) == 0)
                {
                    return node.getData();
                }
                node = node.getNext();
            }
        }
        return null;
    }

    /**
     * Gets A Node With A Specific Index
     * @param index, the index for specific node
     * @return returns the node of that index
     */
    public Node<Type> getNode(int index)
    {
        if(head == null || index < 0 || index >= nodeLength)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<Type> node = head;
        for(int i=0; i<index; i++)
        {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Sets The Specified Node With Data
     * @param index, the index for specific node
     * @param data, the data to be placed
     */
    public void setNode(int index, Type data)
    {
        if(head == null)
        {
            throw new IndexOutOfBoundsException();
        }

        if(index >= 0 && index < nodeLength)
        {
            Node<Type> node = head;
            for(int i=0; i<index; i++)
            {
                node = node.getNext();
            }
            node.setData(data);
            return;
        }

        throw new IndexOutOfBoundsException();
    }
}