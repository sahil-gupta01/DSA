package linkedList;

import java.util.HashMap;

//Q. Design LRU(Least Recently Used) cache

public class LruCache {
    //Node class for Doubly LL
    public class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //Dummy Nodes
    Node head;
    Node tail;
    //LRU cache capacity
    int capacity;
    HashMap<Integer, Node> map;

    public LruCache(int limit) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        capacity = limit;
    }

    public void addAtEnd(int key, int val){
        Node nn = new Node(key, val);

        Node prevNode = tail.prev;
        prevNode.next = nn;
        nn.prev = prevNode;
        nn.next = tail;
        tail.prev = nn;

        map.put(key, nn);
    }

    public void removeNode(Node curr){
        Node prevNode = curr.prev;
        Node nextNode = curr.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        map.remove(curr.key);
    }

    public int get(int key) {
        if( !map.containsKey(key) )return -1;

        Node requiredNode = map.get(key);
        int val = requiredNode.value;
        removeNode(requiredNode);

        addAtEnd(key, val);
        return val;
    }

    public void set(int key, int value) {
        //if key is present inside map
        if(map.containsKey(key)){
            Node requiredNode = map.get(key);
            removeNode(requiredNode);
            addAtEnd(key, value);
        }
        //if key is not present
        else{
            //if capacity is full we have to remove the first Node
            if(map.size() == capacity){
                removeNode(head.next);
            }
            addAtEnd(key, value);
        }

    }
}
