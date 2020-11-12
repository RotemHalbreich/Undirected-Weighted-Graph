package ex1;

import java.util.Collection;
import java.util.HashMap;

public class WGraph_DS implements weighted_graph {

    private int v_size = 0;
    private int e_size = 0;
    private int mc = 1;
    private HashMap<Integer, node_info> vertices;
    private HashMap<Integer, HashMap<Integer, Double>> edges;

    // Constructor:
    public WGraph_DS() {
        this.vertices = new HashMap<Integer, node_info>();
        this.edges = new HashMap<Integer, HashMap<Integer, Double>>();

    }

    private class NodeInfo implements node_info {

        private int key;
        private String info;
        private double tag;
        private int count;

        public NodeInfo() {
            this.key = count++;
            this.info = "";
            this.tag = 0;
        }

        public NodeInfo(int id) {
            this.key = id;
            this.info = "";
            this.tag = 0;
        }


        @Override
        public int getKey() {
            return key;
        }

        @Override
        public String getInfo() {
            return info;
        }

        @Override
        public void setInfo(String s) {
            info = s;
        }

        @Override
        public double getTag() {
            return tag;
        }

        @Override
        public void setTag(double t) {
            tag = t;
        }
    }

    @Override
    public node_info getNode(int key) {
        return vertices.get(key);
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
        // if(node1 == node2) return false;
        if (vertices.get(node1) == null || vertices.get(node2) == null) return false;
        if (edges.containsKey(node1) || edges.containsKey(node2)) {
            if (edges.get(node2).get(node1) != null) return true;
        }
        return false;
    }

    @Override
    public double getEdge(int node1, int node2) {
        if (!hasEdge(node1, node2)) return -1;
        return edges.get(node1).get(node2).doubleValue();
    }

    @Override
    public void addNode(int key) {
        if (vertices.get(key) == null) {
            vertices.put(key, new NodeInfo(key));
        }
    }

    @Override
    public void connect(int node1, int node2, double w) {
        if (w < 0) return;

        if(!hasEdge(node1, node2)) {
            HashMap<Integer, Double> dick=new HashMap<Integer, Double>();
            dick.put(node2,w);
            edges.put(node1,(dick));
        }
    }

    @Override
    public Collection<node_info> getV() {
        return null;
    }

    @Override
    public Collection<node_info> getV(int node_id) {
        return null;
    }

    @Override
    public node_info removeNode(int key) {
        return null;
    }

    @Override
    public void removeEdge(int node1, int node2) {

    }

    @Override
    public int nodeSize() {
        return v_size;
    }

    @Override
    public int edgeSize() {
        return e_size;
    }

    @Override
    public int getMC() {
        return mc;
    }
}
