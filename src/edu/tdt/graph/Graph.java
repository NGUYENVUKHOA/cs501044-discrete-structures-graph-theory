package edu.tdt.graph;

import java.io.*;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */
public class Graph {

    private static int MAX = 100;
    public int[][] A;
    public int noOfVertices;
    public int[] visited;
    public int[] tracking;

    public Graph()
    {
        A = new int[MAX][MAX];
        noOfVertices = 0;
        visited = new int[MAX];
        tracking = new int[MAX];
    }

    public Graph(final Graph g)
    {
        A = new int[MAX][MAX];
        for(int i = 0; i < g.noOfVertices; i++)
        {
            for(int j = 0; j < g.noOfVertices; j++)
            {
                this.A[i][j] = g.A[i][j];
            }
        }

        noOfVertices = g.noOfVertices;
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
                if(noOfVertices == 0)	// First line is the number of nodes
                {
                    noOfVertices = Integer.parseInt(line);
                }
                else
                {
                    String[] data = line.split("\t");
                    for(int j = 0; j < noOfVertices; j++)
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
