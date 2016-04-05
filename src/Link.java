import org.w3c.dom.NodeList;

import java.util.Scanner;

public class Link {

    String data;
    Link next;
    Link front;
    Link prev;
    Link test;
    int count;

    public void init(){

        front = null;
        count = 0;
    }

    public Link makeNode(String data){
        Link newNode = new Link();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    }

    public Link findTail(){
        Link current;
        current = front;
        while(current.next != null){
            current = current.next;
        }
        return current;
    }




    public void insertAfter(Link position, String data){
        Link Node = makeNode(data);
        Node.prev = position;
        Node.next = position.next;
        position.next.prev = Node;
        position.next = Node;
    }
    public Link sendNode(){
        return test;
    }

    public void deleteNode(Link position){

        if(position.next == null){
            position.prev.next = null;
        } else {
            position.prev.next = position.next;

            position.next.prev = position.prev;
        }

    }

    public void addAtFirst(Link position, String data){
        Link Node = makeNode(data);
        if(position.prev == null){
           position.prev = Node;
            Node.next = position;
            Node.prev = null;
        }
    }
    public void insertBefore(Link position, String data){

        Link Node= makeNode(data);
        Node.prev = position.prev;
        Node.next = position;
        if(position.prev == null){

        } else {
            position.prev.next = Node;
        }

        position.prev = Node;
//        position.prev.next = Node;
//        position.prev = Node;
//        Node.next = position;




    }

    public void print(String choice){
        Link current = front;

        if (choice.equals("All")){
            while(current.next != null){
                System.out.println(current.data);
                current = current.next;
                count++;
            }
            System.out.println(current.data);

        } else if (choice.equals("Specific")){
            Scanner joke = new Scanner(System.in);
            System.out.println("Enter the character");
            String changed = joke.next();
            char alphabet = changed.charAt(0);

            while(current.next!= null){
                if(current.data.charAt(0) == alphabet){
                    System.out.println(current.data);
                    count++;
                }
                current = current.next;

            }
        }

        System.out.println("The number of names are: " + this.count);



    }

    public void addAtTail(String data){


        if(front == null){
            front = makeNode(data);
            front.prev = null;
        } else {
            Link tail = findTail();
            Link naya = makeNode(data);
            tail.next = naya;
            naya.prev = tail;

        }
    }



}
