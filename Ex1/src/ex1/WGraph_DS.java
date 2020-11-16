package ex1;

import java.util.*;

/**
 * This class represents an undirectional weighted graph.
 * It should support a large number of nodes (over 10^6, with average degree of 10).
 * The implementation should be based on an efficient compact representation
 * (should NOT be based on a n*n matrix).
 *
 * @author Rotem Halbreich
 */

public class WGraph_DS implements weighted_graph {

    private int v_size = 0;
    private int e_size = 0;
    private int mc = 0;
    private HashMap<Integer, node_info> vertices;
    private HashMap<Integer, HashMap<Integer, Double>> edges;

    // Default constructor:
    public WGraph_DS() {
        this.vertices = new HashMap<Integer, node_info>();
        this.edges = new HashMap<Integer, HashMap<Integer, Double>>();

    }

    /**
     * This sub class represents the info of the graph's vertices
     *
     */

    private class NodeInfo implements node_info {

        private int key;
        private String info;
        private double tag;
        private int count;

        // Default constructor:
        public NodeInfo() {
            this.key = count++;
            this.info = "";
            this.tag = 0;
        }

        // Constructor:
        public NodeInfo(int id) {
            this.key = id;
            this.info = "";
            this.tag = 0;
        }

        /**
         * Return the key (id) associated with this node.
         * Note: each node_data should have a unique key.
         * @return
         */
        @Override
        public int getKey() {
            return key;
        }

        /**
         * return the remark (meta data) associated with this node.
         * @return
         */
        @Override
        public String getInfo() {
            return info;
        }

        /**
         * Allows changing the remark (meta data) associated with this node.
         * @param s
         */
        @Override
        public void setInfo(String s) {
            info = s;
        }

        /**
         * Temporal data (aka distance, color, or state)
         * which can be used be algorithms
         * @return
         */
        @Override
        public double getTag() {
            return tag;
        }

        /**
         * Allow setting the "tag" value for temporal marking an node - common
         * practice for marking by algorithms.
         * @param t - the new value of the tag
         */
        @Override
        public void setTag(double t) {
            tag = t;
        }

        @Override
        public String toString() {
            return "NodeInfo{" + "key = " + key + ", info = '" + info + '\'' + ", tag = " + tag + '}';
        }
    }

    /**
     * return the node_data by the node_id,
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public node_info getNode(int key) {
        return vertices.get(key);
    }

    /**
     * return true iff (if and only if) there is an edge between node1 and node2
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     * @return
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
        if(node1 == node2) return false;
        if (vertices.get(node1) == null || vertices.get(node2) == null) return false;
        if (edges.containsKey(node1) || edges.containsKey(node2)) {
            if (edges.get(node1) != null && edges.get(node2) != null) {
                if (edges.get(node2).get(node1) != null) return true;
            }
        }
        return false;
    }

    /**
     * return the weight if the edge (node1, node1). In case
     * there is no such edge - should return -1
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     * @return
     */
    @Override
    public double getEdge(int node1, int node2) {
        if (!hasEdge(node1, node2)) return -1;
        return edges.get(node1).get(node2).doubleValue();
    }

    /**
     * add a new node to the graph with the given key.
     * Note: this method should run in O(1) time.
     * Note2: if there is already a node with such a key -> no action should be performed.
     * @param key
     */
    @Override
    public void addNode(int key) {
        if (vertices.get(key) == null) {
            vertices.put(key, new NodeInfo(key));
            v_size++;
            mc++;
        }
    }

    /**
     * Connect an edge between node1 and node2, with an edge with weight >=0.
     * Note: this method should run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the method simply updates the weight of the edge.
     */
    @Override
    public void connect(int node1, int node2, double w) {

        //HashMap<Integer, HashMap<Integer, Double>> hash = new HashMap<Integer, HashMap<Integer, Double>>();
        if (w < 0) return;
        if(getNode(node1) == null || getNode(node2) == null) return;
        if(node1==node2) return;
        if (!hasEdge(node1, node2)) {
            connectDirection(node1, node2, w);
            connectDirection(node2, node1, w);
//            if(edges.get(node1) == null) {
//                HashMap<Integer, Double> hash = new HashMap<Integer, Double>();
//                hash.put(node2, w);
//                edges.put(node1, hash);
//            }
//            else edges.get(node1).put(node2, w);
//            if(edges.get(node2) == null) {
//                HashMap<Integer, Double> hash = new HashMap<Integer, Double>();
//                hash.put(node1, w);
//                edges.put(node2, hash);
//            }
//            else edges.get(node2).put(node1, w);
            e_size++;
            mc++;
        }
        else if (w != getEdge(node1, node2)) {
            edges.get(node1).put(node2, w);
            edges.get(node2).put(node1, w);
            mc++;
        }
    }

    // Help function for connect():
    private void connectDirection(int node1, int node2, double w) {
        if (edges.get(node1) == null) {
            HashMap<Integer, Double> hash = new HashMap<Integer, Double>();
            hash.put(node2, w);
            edges.put(node1, hash);
        }
        else edges.get(node1).put(node2, w);
    }

    /**
     * This method return a pointer (shallow copy) for a
     * Collection representing all the nodes in the graph.
     * Note: this method should run in O(1) tim
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_info> getV() {
        return vertices.values();
    }

    /**
     *
     * This method returns a Collection containing all the
     * nodes connected to node_id
     * Note: this method can run in O(k) time, k - being the degree of node_id.
     * @return Collection<node_info>
     */
    @Override
    public Collection<node_info> getV(int node_id) {
        List<node_info> list = new LinkedList<node_info>();
        if (getNode(node_id) != null) {
            for (int n : edges.get(node_id).keySet()) {
                list.add(getNode(n));
            }
        }
        return list;
    }

    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(n), |V|=n, as all the edges should be removed.
     * @return the data of the removed node (null if none).
     * @param key
     */
    @Override
    public node_info removeNode(int key) {
        if(vertices.get(key) == null) return null;
        for(node_info n : this.getV(key)){
            removeEdge(n.getKey(), key);
        }
        v_size--;
        mc++;
        return vertices.remove(key);
    }

    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        if(node1 == node2) return;
        if(!hasEdge(node1, node2)) return;
        edges.get(node1).remove(node2);
        edges.get(node2).remove(node1);
        e_size--;
        mc++;
    }

    /** return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * @return
     */
    @Override
    public int nodeSize() {
        return v_size;
    }

    /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * @return
     */
    @Override
    public int edgeSize() {
        return e_size;
    }

    /**
     * Returns the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     * @return mc
     */
    @Override
    public int getMC() {
        return mc;
    }

    @Override
    public String toString() {
        return "V:" + vertices.keySet() + "\nE:" + edges.toString();
    }
}
