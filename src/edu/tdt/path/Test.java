package edu.tdt.path;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */
public class Test {

    public static void main(String[] args)
    {
        PathFinding p = new PathFinding();
        p.readGraph("resources/test1.txt");
        System.out.println(p.DFS(0, 4));
        System.out.println(p.BFS(0, 3));
    }
}
