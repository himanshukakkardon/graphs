
/*

1. You are given a graph, a source vertex and a destination vertex. 2. You are required to find and print all paths between source and destination. Print them in lexicographical order. E.g. Check the following paths 012546 01256 032546 03256 The lexicographically smaller path is printed first.


Constraints
None

Example
Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6



Sample Output
0123456
012346
03456
0346


 */



import java.util.ArrayList;
import java.util.Scanner;

public class print_all_paths {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int vertices=scn.nextInt();
        int edges=scn.nextInt();

        ArrayList<Edge>[] graph=new ArrayList[vertices];

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=edges;i++){
            int src=scn.nextInt();
            int nbr=scn.nextInt();
            int wt= scn.nextInt();
            Edge e=new Edge(src,nbr,wt);
            graph[src].add(e);
            Edge e_=new Edge(nbr,src,wt);
            graph[nbr].add(e_);
        }

        int src=scn.nextInt();
        int dest=scn.nextInt();

        boolean[] visited=new boolean[vertices];

        print_all_paths_func(graph,src,dest,visited,"");

    }

    public static void print_all_paths_func(ArrayList<Edge>[] graph,int src,int dest,boolean[] visisted,String psf){

        psf+=src;
        visisted[src]=true;

        if(src==dest){
            System.out.println(psf);
            visisted[src]=false;
            return;
        }

        for(int next_vertex=0;next_vertex<graph.length;next_vertex++){
            for(Edge e:graph[src]){
                if(e.nbr==next_vertex && !visisted[next_vertex]){
                    print_all_paths_func(graph,next_vertex,dest,visisted,psf);
                }
            }
        }

        visisted[src]=false;

    }

}
