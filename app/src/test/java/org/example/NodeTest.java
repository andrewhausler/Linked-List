package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class NodeTest
{
    private Node<Integer> node;
    @BeforeEach
    public void setUp()
    {
        node = new Node<Integer>();
    }

    @Test
    public void testSetData()
    {
        int[] intArray = {1, 5, -10, 200};
        for(int i=0; i<intArray.length; i++)
        {
            node.setData(intArray[i]);
            assertEquals(intArray[i], node.getData());
        }
    }

    @Test
    public void testSetNext()
    {
        Node<Integer> nextNode = new Node<Integer>();
        nextNode.setData(45);
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
    }

    @Test
    public void testHasNext()
    {
        node.setNext(new Node<Integer>());
        assertEquals(true, node.hasNext());
    }
}