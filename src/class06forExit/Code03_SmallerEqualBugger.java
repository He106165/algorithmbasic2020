package class06forExit;

public class Code03_SmallerEqualBugger {
    public class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }

    public static Node listPatition1(Node head,int provt){

        if(head==null) return  null;
        //记录链表长度
        int size=0;
        Node cur=head;
        while (cur.next!=null){
            size++;
            cur=cur.next;
        }
        Node[] nodes=new Node[size];
        cur=head;
        /*for (Node node : nodes) {
            node=cur;
            cur=cur.next;
        }*/
        for (int i = 0; i <nodes.length ; i++) {
            nodes[i]=cur;
            cur=cur.next;
        }
        arrPatition(nodes,provt);
        for (int i = 1; i < nodes.length; i++) {
            nodes[size].next=nodes[i];
        }
        nodes[size-1].next=null;
        return nodes[0];
    }

    public static void arrPatition(Node[] arr, int provt){
        int index=0;
        int min=-1;
        int max=arr.length;
        while (index!=max){
            if(arr[index].value <arr[provt].value){
                swap(arr,++index,++min);
            }else if(arr[index].value ==arr[provt].value){
                index++;
            }else{
                swap(arr,--max,index);
            }

        }

    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

}
