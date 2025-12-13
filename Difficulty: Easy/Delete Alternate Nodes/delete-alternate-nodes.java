/*
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public void deleteAlt(Node head) {
        // Code Here
        Node i=head;
        while(i!=null && i.next!=null){
            i.next=i.next.next;
            i=i.next;
        }
        
    }
}