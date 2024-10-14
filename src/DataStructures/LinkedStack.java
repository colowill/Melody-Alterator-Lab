package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.StackADT;

/**
 * Linked list implementation of Stacks. 
 * 
 * @author ITSC 2214
 * @version 1.0
 * @param <T> 
 */
public class LinkedStack<T> implements StackADT<T> {
    /* top: the top of the stack */
    private SinglyLinkedNode<T> top;
    
    /* size: the number of elements in the stack */
    private int size;
    
    /**
     * Constructor
     * Hints:
     * Constructor method is a special method which method name is the same as 
     * the class name and it has no return type. The goal of the constructor method
     * is to initialize the data member variables.
     * In details, we need to initialize the data members, size and top
     */
    public LinkedStack() {
        //TODO Instantiate the linked list-based data collection
        top = null;
        size = 0;
    }
    
    /**
     * Insert an element on the top of the stack
     * @param target input element
     * Hints:
     * We need to correctly maintain the status of the top reference variable and the 
     * size variable in the push() method:
     *    1) to make sure that the top reference variable refers to the node on 
     *    the top of stack (namely, the most recently pushed node among the remaining nodes)
     *    2) to make sure that the size variable increased by one after pushing an item 
     *    in the stack
     * The procedure of pushing a node is as follows:
     *    a) to make a temporary SinglyLinkedNode instance that holds the input argument reference, named target
     *    b) to assign this temporary node's next reference variable to be what 
     *       the top reference variable refers to
     *    c) to re-assign the top reference variable to be the temporary node
     *    d) to increase the size by 1
     */
    @Override
    public void push(T target) {
        //TODO Add targer to the top of the stack 
        //(represented by the top reference node)
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(target);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    /**
     * Remove out of the top of the stack
     * @return the removed element
     * @throws EmptyCollectionException 
     * Hints:
     * We need to maintain the status of the top reference variable and the 
     * size variable in the pop() method:
     *    1) to make sure that the top reference variable refers to the node on 
     *    the top of stack (namely, the most recently pushed node among the remaining nodes)
     *    2) to make sure that the size variable decreased by one after popping an item 
     *    out of the stack
     * The procedure of popping an item out of the stack is as follows:
     *    a) to declare a temporary reference variable and assign it to be the 
     *       node on the top of the stack
     *    b) to re-assign the top reference variable to be the top node's next reference
     *    c) to decrease the size by 1
     *    d) return the data element stored in the node referred by the temporary reference variable
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Pop off empty stack");
        }
        SinglyLinkedNode<T> temp = top;
        top = top.getNext();
        size--;
        return temp.getElement();
        //TODO Remove and return the top item on the stack
        //Corresponding to retrieve the top node and reset 
        //the top reference to the reference of its next node
        
    }
    
    /**
     * Retrieve the element on the top of the stack
     * @return the element on the top of the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Peep on the top of empty stack");
        }
        return top.getElement();
        //TODO Return the top item on this stack, but do 
        //not modify the stack.
        //Corresponding to return the element in the node 
        //referred by the reference top
        
    }
    
     /**
     * Examine whether the stack is empty
     * @return true: if the stack is empty
     *         false: if the stack is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the stack is empty
        if (size<1) {
            return true;
        }
        return false;
    }
    
     /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //Return the size of the stack 
        return size;
    }
}

