package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;

public class GraphClass {

    static class Edge{
        int src, dest, weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2,2));
        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));

    }

    public static void bfs(ArrayList<Edge> graph[],int v,boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                System.out.println(node);
            }
            for (Edge edge : graph[node]) {
                if(!visited[edge.dest]){
                    queue.add(edge.dest);
                }
            }
        }

    }

    public static void main(String[] args){
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        // print 2's neighbours
        for (Edge edge : graph[2]) {
            System.out.println(edge.src + " " + edge.dest+ " " + edge.weight);
        }
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if(!visited[i]){
                bfs(graph,vertices,visited,i);
            }
        }

    }
}
