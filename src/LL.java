public class LL {
     private int size;
     LL(){
         this.size=0;
     }
        class Node{
        String data;
        Node next;

        Node(String data){
            this.data= data;
            this.next= null;
        
        }
    }
    Node head;

    //add first -->>


    public void addFirst(String data){
        Node newnode= new Node(data);
        size++;
        if(head==null){
             head=newnode;
             return;
        }

        newnode.next=head;
        head=newnode;
    }

    //add last-->>


    public void addLast(String data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=newnode;
            return;
        }

        Node curNode=head;
        while(curNode.next != null){
                curNode=curNode.next;
        }
        curNode.next=newnode;
    }

    // print the list-->>


    public void printList(){
        Node curNode=head;
        while(curNode != null){
            System.out.print(curNode.data + " ");
            curNode=curNode.next;
        }
            System.out.println();
    }

    //delete first -->>


    public void deleteFirst(){
            if(head==null){
                System.out.println("The list is empty");
                return;
            }
            size--;
            head=head.next;
    }

    //delete last-->>


    public void deleteLast(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }

        Node secondlast=head;
        Node last=head.next;;
        while(last.next != null){
            secondlast=secondlast.next;
            last=last.next;
        }
        secondlast.next=null;

    }

    // getsize-->>


    public void getSize(){
        System.out.println(size);
    }

    // add a element in middle-->>


    public void addInMiddle(int index, String data){
        Node newEle= new Node(data);

        if(index>size || index<0){
            System.out.println("Invalid index number");
            return;
        }
        size++;
        Node curNode=head;
        Node nextNode=head.next;
        if(index==0 || head ==null){
            head=newEle;
            return;
        }
        
        int i=1;
        while(i != index){
            curNode=curNode.next;
            nextNode=nextNode.next;
            i++;
        }
        curNode.next=newEle;
        newEle.next= nextNode;
    }

    // reverse using looping

    public void reverseIterative(){
        if(head==null || head.next==null){
            return;
        }

        Node prevNode=head;
        Node currNode=head.next;
        while(currNode != null){
                Node nextNode=currNode.next;
                currNode.next=prevNode;

                //update
                prevNode=currNode;
                currNode=nextNode;

        }
        head.next=null;
        head=prevNode;
    }

    //reverse by recurssion

    public Node reverseRecursive(Node head){
        if(head==null || head.next==null){
            return head; 
        }
        Node newHead=reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        

        return newHead;
    }


    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("This");
        list.addLast("list");
        list.printList();
        list.reverseIterative();
        list.printList();
        list.head=list.reverseRecursive(list.head);
        list.printList();
        list.addFirst("So, ");
    }
}
