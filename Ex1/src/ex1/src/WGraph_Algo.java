package ex1.src;

import java.util.*;

/**
 * This interface represents an Undirected (positive) Weighted Graph Theory algorithms including:
 * 0. clone(); (copy)
 * 1. init(graph);
 * 2. isConnected();
 * 3. double shortestPathDist(int ex1.ex1.src, int dest);
 * 4. List<node_data> shortestPath(int ex1.ex1.src, int dest);
 * 5. Save(file);
 * 6. Load(file);
 *
 * @author Rotem Halbreich
 */

public class WGraph_Algo implements weighted_graph_algorithms {

    private static final String UNVISITED = "white", VISITED = "gray", END_ROUND = "black";
    private weighted_graph g;

    public WGraph_Algo() {
        this.g = new WGraph_DS();
    }

    /**
     * Init the graph on which this set of algorithms operates on.
     *
     * @param g
     */
    @Override
    public void init(weighted_graph g) {
        this.g = g;
    }

    /**
     * Return the underlying graph of which this class works.
     *
     * @return
     */
    @Override
    public weighted_graph getGraph() {
        return this.g;
    }

    /**
     * Compute a deep copy of this weighted graph.
     *
     * @return
     */
    @Override
    public weighted_graph copy() {
        weighted_graph ans = new WGraph_DS();
        for (node_info n : g.getV()) {
            ans.addNode(n.getKey());
            for (node_info ni : g.getV(n.getKey())) {
                ans.connect(n.getKey(), ni.getKey(), g.getEdge(n.getKey(), ni.getKey()));
            }
        }
        return ans;
    }

    /**
     * Returns true if and only if (iff) there is a valid path from EVERY node to each
     * other node. NOTE: assume undirectional graph.
     *
     * @return
     */
    @Override
    public boolean isConnected() {
        if (g.nodeSize() <= 1) return true;
        node_info iter = this.g.getV().iterator().next();
        BFSisConnected(iter);
        // For every node, if the info isn't "END_ROUND"
        // we can determine the graph isn't connected
        for (node_info node : this.g.getV()) {
            if (!node.getInfo().equals(END_ROUND))
                return false;
        }
        return true;
    }

    // Help function for isConnected:
    private boolean BFSisConnected(node_info start) {
        Queue<node_info> queue = new LinkedList<>();
        queue.add(start);

        // Sets every node's info as "UNVISITED"
        for (node_info vertices : g.getV()) {
            vertices.setInfo(UNVISITED);
        }
        // For every new vertex in the queue, we set it's info from "UNVISITED" to "VISITED"
        while (!queue.isEmpty()) {
            node_info current = queue.poll();
            if (current.getInfo().equals(UNVISITED)) {
                current.setInfo(VISITED);
            }
            Collection<node_info> current_Ni = g.getV(current.getKey());
            // Sets this vertex's neighbors info to "VISITED"
            // and adds all the neighbors of this vertex to the Queue
            for (node_info neighbor : current_Ni) {
                if (neighbor.getInfo().equals(UNVISITED)) {
                    neighbor.setInfo(VISITED);
                    queue.add(neighbor);
                }
            }
            current.setInfo(END_ROUND);
        }
        return true;
    }

    /**
     * returns the length of the shortest path between ex1.ex1.src to dest
     * Note: if no such path --> returns -1
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public double shortestPathDist(int src, int dest) {
        Dijkstra((WGraph_DS) g, g.getNode(src), dest);
        if (g.getNode(dest).getTag() == Double.MAX_VALUE) return -1;
        return g.getNode(dest).getTag();
    }

    /**
     * returns the the shortest path between ex1.ex1.src to dest - as an ordered List of nodes:
     * ex1.ex1.src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * Note if no such path --> returns null;
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_info> shortestPath(int src, int dest) {
        HashMap<Integer, node_info> hash = Dijkstra((WGraph_DS) g, g.getNode(src), dest);
        boolean flag = true;
        List<node_info> l = new ArrayList<>();
        l.add(g.getNode(dest));
        while (flag) {
            node_info n = hash.get(dest);
            if (n.getKey() == src) {
                flag = false;
            }
            l.add(n);
            dest = n.getKey();
            int dickInAss = 0;
        }
        return l;
    }

    /**
     * Dijkstra algorithm
     *
     * @param
     */

    // Dijkstra algorithm help function:
    private HashMap<Integer, node_info> Dijkstra(WGraph_DS g, node_info start, int dest) {
        HashMap<Integer, node_info> prevNodes = new HashMap<>();
        PriorityQueue<node_info> minPQ = new PriorityQueue<>();

        start.setTag(0.0);
        start.setInfo(UNVISITED);
        minPQ.add(start);

        for (node_info vertex : g.getV()) {
            if (vertex != start) {
                vertex.setTag(Double.MAX_VALUE);
                vertex.setInfo(UNVISITED);
            }
        }
        while (!minPQ.isEmpty()) {
            node_info newSmallest = minPQ.poll();
            Collection<node_info> current_Ni = g.getV(newSmallest.getKey());
            if (newSmallest.getKey() == dest || newSmallest.getTag() == Double.MAX_VALUE) return prevNodes;
            for (node_info neighbor : current_Ni) {

                double currWeight = newSmallest.getTag() + g.getEdge(neighbor.getKey(), newSmallest.getKey());
                if (neighbor.getInfo().equals(UNVISITED) && currWeight < neighbor.getTag()) {
                    minPQ.remove(neighbor);
                    neighbor.setTag(currWeight);
                    minPQ.add(neighbor);
                    prevNodes.put(neighbor.getKey(), newSmallest);
                }

            }
            newSmallest.setInfo(VISITED);
        }
        return prevNodes;
    }

    /**
     * Saves this weighted (undirected) graph to the given
     * file name
     *
     * @param file - the file name (may include a relative path).
     * @return true - iff the file was successfully saved
     */
    @Override
    public boolean save(String file) {
        return false;
    }

    /**
     * This method load a graph to this graph algorithm.
     * if the file was successfully loaded - the underlying graph
     * of this class will be changed (to the loaded one), in case the
     * graph was not loaded the original graph should remain "as is".
     *
     * @param file - file name
     * @return true - iff the graph was successfully loaded.
     */
    @Override
    public boolean load(String file) {
        return false;
    }
}
