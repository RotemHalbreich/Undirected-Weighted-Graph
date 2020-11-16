package ex1;

import java.util.*;

/**
 * This interface represents an Undirected (positive) Weighted Graph Theory algorithms including:
 * 0. clone(); (copy)
 * 1. init(graph);
 * 2. isConnected();
 * 3. double shortestPathDist(int src, int dest);
 * 4. List<node_data> shortestPath(int src, int dest);
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
//        weighted_graph ans = new WGraph_DS();
//        Iterator<node_info> point = g.getV().iterator();
//        node_info current;
//        int key;
//        String info;
//        double tag;
//        while (point.hasNext()) {
//            current = point.next();
//            key = current.getKey();
//            info = current.getInfo();
//            tag = current.getTag();
//            node_info vertices = new NodeData(key, info, tag);
//            ans.addNode(vertices);
//        }
//        for (node_info current_V : g.getV()) {
//            if (current_V.getNi() != null) {
//                for (node_info current_Ni : current_V.getNi()) {
//                    ans.connect(current_V.getKey(), current_Ni.getKey());
//                }
//            }
//        }
//        return ans;
        return null;
    }

    /**
     * Returns true if and only if (iff) there is a valid path from EVERY node to each
     * other node. NOTE: assume undirectional graph.
     *
     * @return
     */
    @Override
    public boolean isConnected() {
//        if (g.nodeSize() <= 1) return true;
//        node_info iter = this.g.getV().iterator().next();
//        BFSisConnected(iter);
//        // For every node, if the info isn't "END_ROUND"
//        // we can determine the graph isn't connected
//        for (node_info node : this.g.getV()) {
//            if (!node.getInfo().equals(END_ROUND))
//                return false;
//        }
//        return true;
//    }
//
//    // Help function for isConnected:
//    private boolean BFSisConnected(node_info start) {
//        Queue<node_info> queue = new LinkedList<>();
//        queue.add(start);
//
//        // Sets every node's info as "UNVISITED"
//        for (node_info vertices : g.getV()) {
//            vertices.setInfo(UNVISITED);
//        }
//        // For every new vertex in the queue, we set it's info from "UNVISITED" to "VISITED"
//        while (!queue.isEmpty()) {
//            node_info current = queue.poll();
//            if (current.getInfo().equals(UNVISITED)) {
//                current.setInfo(VISITED);
//            }
//            Collection<node_info> current_Ni = current.getNi();
//            // Sets this vertex's neighbors info to "VISITED"
//            // and adds all the neighbors of this vertex to the Queue
//            for (node_info neighbor : current_Ni) {
//                if (neighbor.getInfo().equals(UNVISITED)) {
//                    neighbor.setInfo(VISITED);
//                    queue.add(neighbor);
//                }
//            }
//            current.setInfo(END_ROUND);
//        }
        return true;
    }

    /**
     * returns the length of the shortest path between src to dest
     * Note: if no such path --> returns -1
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * Note if no such path --> returns null;
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_info> shortestPath(int src, int dest) {
        return null;
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
