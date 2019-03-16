package astar_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MapBucket {

    ArrayList<ListRootNode> mapNODE;
    Scanner o;

    public MapBucket(){
        mapNODE = new ArrayList<>();
    }

    public void inputForEachElementMap(int index){
        ListRootNode listTemp = new ListRootNode();
        System.out.println("--- INPUT NODE ---");
        Node rootNode = new Node();
        rootNode.inputNode(true,"");
        String parentThis = rootNode.getKeyPoint();
        listTemp.addNodeToList(rootNode);
        int number = 0; o = new Scanner(System.in);
        System.out.print(rootNode.getKeyPoint() + " Co The Toi Bao Nhieu Dinh : ");number = o.nextInt();
        if(number >= 1){
            for (int i = 0; i < number ; i++){
                Node subNode = new Node();
                subNode.inputNode(false,parentThis);
                listTemp.addNodeToList(subNode);
            }
        }
        mapNODE.add(listTemp);
    }

    public void inputMapNODE(int quantityPointNode){
        for (int i = 0 ; i < quantityPointNode ; i++){
            inputForEachElementMap(i);
            System.out.println("-------------------------------");
        }
    }

    public void display(){
        for (ListRootNode l: mapNODE) {
            l.display();
        }
    }


    public void traverseBuketListFirstStep(int indexMap , LinkedList<Node> open){
        if (mapNODE.get(indexMap).listRoot.get(1) == null){ // at index node not have road to any other point
            return;
        } else {
            int size = mapNODE.get(indexMap).listRoot.size();
            for (int i = 1 ; i < size ; i++){
                String keyPoint = mapNODE.get(indexMap).listRoot.get(i).getKeyPoint();
                String parentPoint = mapNODE.get(indexMap).listRoot.get(0).getKeyPoint();
                int expectedCost = mapNODE.get(indexMap).listRoot.get(i).getExpectedCost();
                int roadFromParentToPoint = mapNODE.get(indexMap).listRoot.get(i).getRoadFromParentToPoint();
                int f = mapNODE.get(indexMap).listRoot.get(i).getExpectedCost() + mapNODE.get(indexMap).listRoot.get(i).getRoadFromParentToPoint();
                open.addLast(new Node(keyPoint,parentPoint,expectedCost,roadFromParentToPoint,f));

            }
        }
    }

    public void traverseBuketList(int indexMap , LinkedList<Node> open, int value){
        int x = mapNODE.get(indexMap).listRoot.get(0).getExpectedCost();
        if (mapNODE.get(indexMap).listRoot.get(1) == null){ // at index node not have road to any other point
            return;
        } else {
            int size = mapNODE.get(indexMap).listRoot.size();
            for (int i = 1 ; i < size ; i++){
                String keyPoint = mapNODE.get(indexMap).listRoot.get(i).getKeyPoint();
                String parentPoint = mapNODE.get(indexMap).listRoot.get(0).getKeyPoint();
                int f = value - x;
                f += mapNODE.get(indexMap).listRoot.get(i).getExpectedCost();
                f += mapNODE.get(indexMap).listRoot.get(i).getRoadFromParentToPoint();
                int expectedCost = mapNODE.get(indexMap).listRoot.get(i).getExpectedCost();
                int roadFromParentToPoint = mapNODE.get(indexMap).listRoot.get(i).getRoadFromParentToPoint();
                // TODO : Delete Node similar but have value f > this new node
                for (int j = 0 ; j < open.size() ; j++){
                    if (open.get(j).getKeyPoint().compareTo(keyPoint) == 0){
                        if (open.get(j).getF() > f){
                            open.remove(j);
                            break;
                        }
                    }
                }
                open.addLast(new Node(keyPoint,parentPoint,expectedCost,roadFromParentToPoint,f));
            }
        }
    }



}
