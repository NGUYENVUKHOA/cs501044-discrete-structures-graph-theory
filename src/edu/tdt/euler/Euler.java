package edu.tdt.euler;

import java.util.*;
import java.util.Stack;
import edu.tdt.graph.Graph;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */

public class Euler {

    private int _MAX = 100;
    private Graph g;
    private int[] label;

    public Euler(String GRAPH_INPUT_PATH)
    {
        this.g = new Graph();
        g.readGraph(GRAPH_INPUT_PATH);
        label = new int[_MAX];
        Arrays.fill(label, 0);
    }

    private void findConnectedVertices(int currVertice)
    {
        for(int i = 0; i < g.noOfVertices; i++)
        {
            if(g.A[currVertice][i] != 0 && label[currVertice] != label[i])
            {
                label[i] = label[currVertice];
                findConnectedVertices(i);
            }
        }
    }

    public int getConnectedComponents()
    {
        int noOfConnectedness = 0;

        for(int i = 0; i < g.noOfVertices; i++)
        {
            if(label[i] == 0)
            {
                noOfConnectedness++;
                label[i] = noOfConnectedness;
            }

            if(label[i] != 0)
            {
                findConnectedVertices(i);
            }
        }

        return noOfConnectedness;
    }

    public boolean isEulerCircuit()
    {
        for(int i = 0; i < g.noOfVertices; i++)
        {
            int tmp = 0;
            for(int j = 0; j < g.noOfVertices; j++)
            {
                if(g.A[i][j] != 0)
                    tmp++;
            }

            if(tmp % 2 != 0)
                return false;
        }

        return true;
    }

    public ArrayList<Integer> getEulerCircuit(int start)
    {
        if(!isEulerCircuit())
        {
            System.err.println("Not contain Euler circuit!");
            return null;
        }

        Graph tmpGraph = new Graph(g);
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        stack.push(start);
        while(!stack.isEmpty())
        {
            int curNode = stack.peek();

            int j = 0;
            for(j = 0; j < tmpGraph.noOfVertices; j++)
            {
                if(tmpGraph.A[curNode][j] != 0)
                    break;
            }

            if(j < tmpGraph.noOfVertices)
            {
                stack.push(j);
                tmpGraph.A[curNode][j] = tmpGraph.A[j][curNode] = 0;
            }
            else
            {
                output.add(stack.pop());
            }
        }

        // Case 1: still exist at least an edge in graph
        for(int i = 0; i < tmpGraph.noOfVertices; i++)
        {
            for(int j = 0; j < tmpGraph.noOfVertices; j++)
            {
                if(tmpGraph.A[i][j] != 0)
                    return null;
            }
        }

        // Case 2: if exists an Euler circuit, the start and end nodes must be the same
        if(output.get(0) != output.get(output.size()-1))
            return null;

        // output is an Euler circuit
        return output;
    }

    public boolean isEulerTrail()
    {
        int countOddDegreeVertices = 0;
        for(int i = 0; i < g.noOfVertices; i++)
        {
            int tmp = 0;
            for(int j = 0; j < g.noOfVertices; j++)
            {
                if(g.A[i][j] != 0)
                    tmp++;
            }

            if(tmp % 2 != 0)
                countOddDegreeVertices++;

            if(countOddDegreeVertices > 2)
                return false;
        }

        return true;
    }

    public ArrayList<Integer> getEulerTrail()
    {
        if(!isEulerTrail())
            return null;

        // Find the first odd degree vertex (~ the start vertex)
        int start = getFirstOddDegreeVertex();
        if(start == -1)
            return null;

        Graph tmpGraph = new Graph(g);
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        stack.push(start);
        while(!stack.isEmpty())
        {
            int curNode = stack.peek();

            int j = 0;
            for(j = 0; j < tmpGraph.noOfVertices; j++)
            {
                if(tmpGraph.A[curNode][j] != 0)
                    break;
            }

            if(j < tmpGraph.noOfVertices)
            {
                stack.push(j);
                tmpGraph.A[curNode][j] = tmpGraph.A[j][curNode] = 0;
            }
            else
            {
                output.add(stack.pop());
            }
        }

        // Case 1: still exist at least an edge in graph
        for(int i = 0; i < tmpGraph.noOfVertices; i++)
        {
            for(int j = 0; j < tmpGraph.noOfVertices; j++)
            {
                if(tmpGraph.A[i][j] != 0)
                    return null;
            }
        }

        // Case 2: if exists an Euler circuit, the start and end nodes must not be the same
        if(output.get(0) == output.get(output.size()-1))
            return null;

        // output is an Euler circuit
        return output;
    }

    private int getFirstOddDegreeVertex()
    {
        for(int i = 0; i < g.noOfVertices; i++)
        {
            int degree = 0;
            for(int j = 0; j < g.noOfVertices; j++)
            {
                if(g.A[i][j] != 0)
                    degree++;
            }

            if(degree % 2 != 0)
                return i;
        }

        return -1;
    }
}
