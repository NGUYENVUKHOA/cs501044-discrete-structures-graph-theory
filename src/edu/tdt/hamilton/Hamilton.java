package edu.tdt.hamilton;

import edu.tdt.graph.Graph;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Phuc Duong on 8/10/2016.
 * huuphucduong@gmail.com
 */
public class Hamilton {

    private int _MAX = 100;
    private Graph g;
    private int noOfCircuits;
    private int[] hamilton, visited;
    private ArrayList<String> hamiltonCircuit;  // Contain all possible Hamilton circuits

    public Hamilton(String GRAPH_INPUT_PATH)
    {
        this.g = new Graph();
        g.readGraph(GRAPH_INPUT_PATH);

        this.noOfCircuits = 0;

        this.hamilton = new int[_MAX];
        Arrays.fill(this.hamilton, 0);

        this.visited = new int[_MAX];
        Arrays.fill(this.visited, 0);

        this.hamiltonCircuit = new ArrayList<>();
    }

    public ArrayList<String> getHamiltonCircuit(final int start)
    {
        if(start < 0 || start >= g.noOfNode)
            return null;

        this.hamilton[0] = start;
        _hamiltion(start);

        if(noOfCircuits != 0)
        {
            return this.hamiltonCircuit;
        }
        else
        {
            System.err.println("Not contain any Hamilton circuit!");
            return null;
        }
    }

    private String getHamiltonCircuitString()
    {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i <= g.noOfNode; i++)    // Because the start and end vertices of Hamilton circuit must be the same
            output.append(hamilton[i]);

        this.noOfCircuits++;

        return output.toString();
    }

    private void _hamiltion(int k)
    {
        for (int i = 0; i < g.noOfNode; i++)
        {
            if(g.A[hamilton[k]][i] != 0)
            {
                if(this.hamilton[0] == this.hamilton[k] && k == g.noOfNode)
                {
                    this.hamiltonCircuit.add(getHamiltonCircuitString());
                }
                else if(visited[i] == 0)
                {
                    hamilton[k + 1] = i;
                    visited[i] = 1;
                    _hamiltion(k + 1);
                    visited[i] = 0;
                }
            }
        }
    }
}
