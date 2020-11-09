package ex1;

import java.util.Collection;

public class WGraph_DS implements weighted_graph {
    @Override
    public node_info getNode(int key) {
        return null;
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
        return false;
    }

    @Override
    public double getEdge(int node1, int node2) {
        return 0;
    }

    @Override
    public void addNode(int key) {

    }

    @Override
    public void connect(int node1, int node2, double w) {

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
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
