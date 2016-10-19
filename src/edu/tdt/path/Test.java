package edu.tdt.path;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */
public class Test {

    public static void main(String[] args)
    {
        PathFinding p = new PathFinding();
        p.readGraph("resources/test5.txt");
        System.out.println(p.DFS(0, 14));
        System.out.println(p.BFS(14, 0));
    }
}
