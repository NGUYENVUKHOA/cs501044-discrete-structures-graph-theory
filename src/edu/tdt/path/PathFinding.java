package edu.tdt.path;

import edu.tdt.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Phuc Duong on 7/10/2016.
 * Last updated on 19/10/2016.
 * huuphucduong@gmail.com
 */

public class PathFinding {

    private Graph g;

    public PathFinding()
    {
        this.g = new Graph();
    }

    private void _DFS(int start)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(start);

        while(!stack.isEmpty())
        {
            start = stack.pop();
            g.visited[start] = 1;

            for(int i = g.noOfNode - 1; i >= 0; i--)
            {
                if(g.A[start][i] != 0 && g.visited[i] == 0)
                {
                    stack.push(i);
                    g.tracking[i] = start;
                }
            }
        }
    }

    private void _BFS(int start)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        while(!queue.isEmpty())
        {
            start = queue.remove();
            g.visited[start] = 1;

            for(int i = 0; i < g.noOfNode; i++)
            {
                if(g.A[start][i] != 0 && g.visited[i] == 0)
                {
                    queue.add(i);
                    g.visited[i] = 1;
                    g.tracking[i] = start;
                }
            }
        }
    }

    public String DFS(final int start, final int end)
    {
        if(g.noOfNode == 0)
        {
            System.err.println("Please import the graph first!");
            return null;
        }

        // 1- Set Visited and Tracking to default value
        for(int i = 0; i < g.noOfNode; i++)
        {
            g.visited[i] = 0;
            g.tracking[i] = -1;
        }

        // 2- Call DFS
        this._DFS(start);

        // 3- Get path String
        if(g.visited[end] == 1)
        {
            String path = "";

            int i = end;
            while(i != start)
            {
                path = path + i + " ";
                i = g.tracking[i];
            }
            path += start;

            return path;
        }
        else
        {
            return "N/A";
        }

    }

    public String BFS(final int start, final int end)
    {
        if(g.noOfNode == 0)
        {
            System.err.println("Please import the graph first!");
            return null;
        }

        // 1- Set Visited and Tracking to default value
        for(int i = 0; i < g.noOfNode; i++)
        {
            g.visited[i] = 0;
            g.tracking[i] = -1;
        }

        // 2- Call BFS
        this._BFS(start);

        // 3- Get path String
        if(g.visited[end] == 1)
        {
            String path = "";

            int i = end;
            while(i != start)
            {
                path = path + i + " ";
                i = g.tracking[i];
            }
            path += start;

            return path;
        }
        else
        {
            return "N/A";
        }
    }

    public void readGraph(final String INPUT_PATH)
    {
        this.g.readGraph(INPUT_PATH);
    }
}
