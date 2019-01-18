import java.io.*;
import java.util.*;

public class Graph {
    private int V; //Number of vertices

    //Array of lists for adjacency list
    private LinkedList<Integer> adj[];

    Graph(int v){
        this.V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    protected int Size(){
        return V;
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    //Recursive Function
    void DFSUtil(int v, boolean visited[])
    {
        //Marks the current node as visited
        visited[v] = true;
        System.out.print(v + " ");

        //Recur for all vertices adjacent
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        //Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        //Initialize the DFSUtil function to do the meat of the work
        DFSUtil(v, visited);
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        g.DFS(1);
    }

}
