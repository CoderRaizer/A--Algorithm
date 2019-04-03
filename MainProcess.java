package astar_algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
*** Author : VoDuyKhanh - < 10/03/2019 >
 */

public class MainProcess {


    public static void main(String []arg){

        System.out.println(" <========== A STAR Algorithm ==========> ");
        Scanner o = new Scanner(System.in);

        MapBucket mapbucket = new MapBucket();

        int quantityPointNode;
        System.out.print("Enter quantity Point Node : ");quantityPointNode = o.nextInt();
        mapbucket.inputMapNODE(quantityPointNode);

        LinkedList<Node> openList = new LinkedList<>();
        LinkedList<Node> closeList = new LinkedList<>();

        String startPoint;
        String endPoint;

        o = new Scanner(System.in);
        System.out.print("Enter Start Point : ");startPoint = o.nextLine();
        o = new Scanner(System.in);
        System.out.print("Enter End Point : ");endPoint = o.nextLine();
        String outKeyPoint = startPoint;

        boolean isFirstStep = true;
        boolean foundEndPoint = false;

        int sizeMapBucket = mapbucket.mapNODE.size();

        while (foundEndPoint == false){

            for (int indexMap = 0 ; indexMap < sizeMapBucket ; indexMap++ ){

                if (mapbucket.mapNODE.get(indexMap).listRoot.get(0).getKeyPoint().compareTo(outKeyPoint) == 0){

                    if (isFirstStep == true){
                        mapbucket.traverseBuketListFirstStep(indexMap,openList);
                        Collections.sort(openList);
                        outKeyPoint = openList.get(0).getKeyPoint();
                        Node x = openList.get(0);
                        closeList.addLast(x);
                        openList.removeFirst();
                    }

                    if (isFirstStep == false){
                        int value = closeList.getLast().getF();
                        mapbucket.traverseBuketList(indexMap,openList,value);
                        Collections.sort(openList);
                        outKeyPoint = openList.get(0).getKeyPoint();
                        Node x = openList.get(0);
                        closeList.addLast(x);
                        openList.removeFirst();
                    }

                    isFirstStep = false;
                    if (outKeyPoint.compareTo(endPoint) == 0){
                        foundEndPoint = true;
                    }break;
                }


            }
        }// End while

        int sizeCloseList = closeList.size();
        System.out.println(" --- CLOSE LIST --- ");
        for (int i = 0 ; i < sizeCloseList ; i++){
            System.out.println("("+closeList.get(i).getKeyPoint()+","+closeList.get(i).getF()+","+closeList.get(i).getParentPoint()+")");
        }

        System.out.println( " === SOLVE SUCCESS === " );
        System.out.print(" ROAD FROM " + startPoint + " to " + endPoint + " : ");
        int costBestRoad = 0;
        for (int i = 0 ; i < sizeCloseList ; i++){
            boolean check = false;
            for (int j = i+1 ; j < sizeCloseList ; j++){
                if (closeList.get(i).getParentPoint().compareTo(closeList.get(j).getParentPoint()) == 0){
                    check = true; // not show
                    break;
                }
            }
            if (check == false){
                System.out.print(closeList.get(i).getParentPoint() + " -> ");
            }
            costBestRoad = closeList.get(i).getF();
        }
        System.out.println(endPoint);
        System.out.println("Cost For Best Road From " + startPoint + " to " + endPoint + " is : " + costBestRoad);






    }
}
