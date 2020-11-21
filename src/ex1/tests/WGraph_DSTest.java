package ex1.tests;

import ex1.src.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_DSTest {
    private  weighted_graph g1;
    @BeforeEach
    void init() {

    }

    @Test
    void getNode() {
        weighted_graph w=new WGraph_DS();
        w.addNode(0);
        weighted_graph w1=new WGraph_DS();
        w1.addNode(0);
        assertEquals(w,w1);
    }

    @Test
    void hasEdge() {
    }

    @Test
    void getEdge() {
    }

    @Test
    void addNode() {
    }

    @Test
    void connect() {
    }

    @Test
    void getV() {
    }

    @Test
    void testGetV() {
    }

    @Test
    void removeNode() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void nodeSize() {
    }

    @Test
    void edgeSize() {
    }

    @Test
    void getMC() {
    }

    @Test
    void testToString() {
    }
}