package edu.tdt.graph;

import java.io.*;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */
public class Graph {

    private static int MAX = 100;
    public int[][] A;
    public int noOfNode;
    public int[] visited;
    public int[] tracking;

    public Graph()
    {
        A = new int[MAX][MAX];
        noOfNode = 0;
        visited = new int[MAX];
        tracking = new int[MAX];
    }

    public Graph(final Graph g)
    {
        A = new int[MAX][MAX];
        for(int i = 0; i < g.noOfNode; i++)
        {
            for(int j = 0; j < g.noOfNode; j++)
            {
                this.A[i][j] = g.A[i][j];
            }
        }

        noOfNode = g.noOfNode;
        visited = new int[MAX];
        tracking = new int[MAX];
    }

    public void readGraph(final String INPUT_PATH)
    {
        try
        {
            // File Reader Construction
            FileReader fileReader = new FileReader(INPUT_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read lines of INPUT and assign to A[][]
            String line = null;
            int lineNumber = 0;
            while((line = bufferedReader.readLine()) != null)
            {
                if(noOfNode == 0)	// First line is the number of nodes
                {
                    noOfNode = Integer.parseInt(line);
                }
                else
                {
                    String[] data = line.split("\t");
                    for(int j = 0; j < noOfNode; j++)
                    {
                        A[lineNumber][j] = Integer.parseInt(data[j]);
                    }
                    lineNumber++;
                }
            }

            // Close File Reader
            fileReader.close();
            bufferedReader.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
