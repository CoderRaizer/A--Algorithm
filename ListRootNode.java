package astar_algorithm;

import java.util.LinkedList;

public class ListRootNode {

    LinkedList<Node> listRoot;

    public ListRootNode(){
        listRoot = new LinkedList<>();
    }

    public void addNodeToList(Node x){
        listRoot.addLast(x);
    }

    public void display(){
        for (Node x: listRoot) {
            System.out.println(x.toString());
        }
    }

}
