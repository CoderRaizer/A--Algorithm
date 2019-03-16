package astar_algorithm;

import java.util.Scanner;

public class Node implements Comparable<Node>{

    private String keyPoint;
    private String parentPoint;
    private int expectedCost;
    private int roadFromParentToPoint;
    private int f;

    Scanner o;

    public Node(){

    }

    public Node(String keyPoint, String parentPoint, int expectedCost, int roadFromParentToPoint, int f) {
        this.keyPoint = keyPoint;
        this.parentPoint = parentPoint;
        this.expectedCost = expectedCost;
        this.roadFromParentToPoint = roadFromParentToPoint;
        this.f = f;
    }

    public String getKeyPoint() {
        return keyPoint;
    }

    public void setKeyPoint(String keyPoint) {
        this.keyPoint = keyPoint;
    }

    public String getParentPoint() {
        return parentPoint;
    }

    public void setParentPoint(String parentPoint) {
        this.parentPoint = parentPoint;
    }

    public int getExpectedCost() {
        return expectedCost;
    }

    public void setExpectedCost(int expectedCost) {
        this.expectedCost = expectedCost;
    }

    public int getRoadFromParentToPoint() {
        return roadFromParentToPoint;
    }

    public void setRoadFromParentToPoint(int roadFromParentToPoint) {
        this.roadFromParentToPoint = roadFromParentToPoint;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void inputNode(boolean isRoot,String parentPoint){
        o = new Scanner(System.in);
        System.out.print("Enter Key Point : ");this.keyPoint = o.nextLine();
        if(isRoot == true){
            this.parentPoint = "";
        } else {
            o = new Scanner(System.in);
//            System.out.print("Enter Parent Point : ");this.parentPoint = o.nextLine();
            this.parentPoint = parentPoint;
        }
        o = new Scanner(System.in);
        System.out.print("Enter ExpectedCost : ");this.expectedCost = o.nextInt();
        o = new Scanner(System.in);
        System.out.print("Enter RoadFormParentToPoint : ");this.roadFromParentToPoint = o.nextInt();

    }

    @Override
    public String toString() {
        return "Node{" +
                "keyPoint='" + keyPoint + '\'' +
                ", parentPoint='" + parentPoint + '\'' +
                ", expectedCost=" + expectedCost +
                ", roadFromParentToPoint=" + roadFromParentToPoint +
                ", f=" + f +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        if (this.f > o.f){
            return 1;
        } else if (this.f == o.f){
            return 0;
        } else {
            return -1;
        }
    }
}
