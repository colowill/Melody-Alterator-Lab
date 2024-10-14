package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.QueueADT;

/**
 * Linked list implementation of Queues. 
 * 
 * @author ITSC 2214
 *
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /* front: the beginning of the queue */
    private SinglyLinkedNode<T> front;
    
    /* rear: the end of the queue */
    private SinglyLinkedNode<T> rear;
    
    /* size: the number of elements in the queue */
    private int size;
    
    /**
     * Constructor
     * Hints:
     * Constructor method is a special method which method name is the same as 
     * the class name and it has no return type. The goal of the constructor method
     * is to initialize the data member variables.
     * In details, we need to initialize the front and rear reference variables and 
     * the size variable 
     */
    public LinkedQueue() {
        //TODO Instantiate the linked list-based data 
        //collection
        front = null;
        rear = null;
        size = 0;

        
    }
    
    /**
     * Insert an element in the end of the queue
     * @param target input element
     * Hints:
     * We need to correctly maintain the status of the front and rear reference variables
     * and the size variable in the enqueue() method:
     *    1) to make sure that the front reference variable refers to the node at the 
     *    beginning of the queue and the rear reference variable refers to the node 
     *    at the end of the queue
     *    2) to make sure that the size variable increased by one after enqueueing an item 
     *    in the queue
     * The procedure of enqueueing a node is as follows:
     *    a) to make a temporary SinglyLinkedNode instance that holds the input 
     *       argument reference, named target
     *    b) if it is an empty linked queue, to assign the front and rear reference 
     *       variables to the temporary node instance
     *    c) else 1) to link the next reference of the rear reference variable to 
     *       the temporary node instance
     *            2) to re-assign the rear reference variable to be the temporary node
     *    d) to increase the size by 1
     */
    @Override
    public void enqueue(T target) {
        /** TODO if queue is empty, insert new node
         * and change the rear and front references
         * 
         * 
         * if queue is not empty, insert new node in 
         * the rear of the queue
         * 
         * make sure that the size variable has been increased
        **/
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>(target);
        if (isEmpty()) {
            front = temp;
            rear = temp;
            size++;
        }
        else {
            rear.setNext(temp);
            rear = temp;
            size++;
        }
        
    }
    
    /**
     * Remove from the beginning of the queue
     * @return the removed element
     * @throws EmptyCollectionException 
     * Hints:
     * We need to correctly maintain the status of the front and rear reference variables
     * and the size variable in the dequeue() method:
     *    1) to make sure that the front reference variable refers to the node at the 
     *    beginning of the queue and the rear reference variable refers to the node 
     *    at the end of the queue
     *    2) to make sure that the size variable decreased by one after dequeueing an item 
     *    from the queue
     * The procedure of dequeueing a node is as follows:
     *    a) to declare a temporary node reference variable and assign it to the 
     *       node at the beginning of the queue
     *    b) re-assign the top reference variable to its next node
     *    c) if the front refers to null, to reassign the rear reference 
     *       variables to null
     *    c) to decrease the size by 1
     *    d) return the data that is stored in the temporary instance in a)
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Remove item from empty queue");
        }
        SinglyLinkedNode<T> temp = front;
        front = front.getNext();
        size--;
        return temp.getElement();
        
        
        /** TODO Remove the data item from the queue
        * Do not forget to change the size
        **/

        
    }
    
    /**
     * Examine whether the queue is empty
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the queue is empty
        if (size<1) {
            return true;
        }
        return false;
    }
    
    /**
     * Retrieve the front
     * @return the element in the beginning of the queue
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Remove item from empty queue");
        }
        else {
            return front.getElement();
        }
        /**TODO return element in the frontmost position of the array **/
        
    }
    
    /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //Return the size of the QueueADT
        return size;
    }

    @Override
    public void add(T target) {
        this.enqueue(target);
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        
        SinglyLinkedNode<T> frontNode = front;
        front = front.getNext();
        
        size--;
        if (front == null) {
            rear = front;
        }
        
        return frontNode.getElement();
    }
}

