package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest
{
    private LinkedList<Integer> newList;

    // Resets Each Test Case Before With Index 0 Equaling 5
    @BeforeEach
    public void setUp()
    {
        newList = new LinkedList<Integer>(5);
    }

    // Test Empty Method
    @Test
    public void testIsEmpty()
    {
        assertEquals(false, newList.isEmpty());
    }

    // Test Getting The Furthest Node Method
    @Test
    public void testGetFurthestNode()
    {
        newList.add(new Node<Integer>(1));
        newList.add(new Node<Integer>(2));
        assertEquals(2, newList.getFurthestNode().getData());
    }

    // Tests The Inserting Node Method
    @Test
    public void testInsertNode()
    {
        newList.add(new Node<Integer>(4));
        newList.insert(new Node<Integer>(7), 0);
        assertEquals(7, newList.getNode(0).getData());
        assertEquals(4, newList.getNode(2).getData());
        assertThrows(IndexOutOfBoundsException.class, () -> newList.getNode(-1));
    }

    // Tests Removing Node Method
    @Test
    public void testRemoveNode()
    {
        newList.add(new Node<Integer>(4));
        newList.add(new Node<Integer>(7));
        newList.remove(1);
        assertEquals(7, newList.getNode(1).getData());
        assertThrows(IndexOutOfBoundsException.class, () -> newList.remove(5));
    }

    // Tests The Searching A Node Method
    @Test
    public void testSearchNode()
    {
        newList.add(new Node<Integer>(5));
        newList.add(new Node<Integer>(4));
        newList.add(new Node<Integer>(2));
        newList.add(new Node<Integer>(4));
        newList.add(new Node<Integer>(3));
        assertEquals(4, newList.search(4));
        assertEquals(null, newList.search(10));
    }

    // Tests Getting A Node Method
    @Test
    public void testGetNode()
    {
        Node<Integer> firstNode = new Node<Integer>(4);
        newList.add(firstNode);
        newList.add(new Node<Integer>(2));
        newList.add(new Node<Integer>(2));
        Node<Integer> furthestNode = new Node<Integer>(10);
        newList.add(furthestNode);
        assertTrue(furthestNode == newList.getNode(4));
        assertEquals(firstNode, newList.getNode(1));
        assertThrows(IndexOutOfBoundsException.class, () -> newList.getNode(5));
    }

    // Tests Setting Nodes Current Data Method
    @Test
    public void testSetNode()
    {
        newList.add(new Node<Integer>(5));
        newList.add(new Node<Integer>(4));
        assertEquals(5, newList.getNode(1).getData());
        newList.setNode(1, 3);
        newList.setNode(0, 10);
        assertEquals(3, newList.getNode(1).getData());
        assertEquals(10, newList.getNode(0).getData());
        assertThrows(IndexOutOfBoundsException.class, () -> newList.setNode(6, 1));
    }
}
