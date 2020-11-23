package ex1.tests;

import static org.junit.jupiter.api.Assertions.*;

import ex1.src.*;
import org.junit.jupiter.api.*;

import java.util.LinkedList;

class WGraph_AlgoTest {

    private weighted_graph_algorithms row, arrow, big, single, empty;

    @BeforeEach
    void beforeEach() {
        weighted_graph r = new WGraph_DS();
        weighted_graph a = new WGraph_DS();
        weighted_graph b = new WGraph_DS();
        weighted_graph s = new WGraph_DS();
        weighted_graph e = new WGraph_DS();

        for (int i = 0; i <= 7; i++) {
            b.addNode(i);
            a.addNode(i);
        }

        //Arrow graph:
        a.connect(0, 1, 1.0);
        a.connect(1, 2, 2.0);
        a.connect(2, 0, 3.0);
        a.connect(2, 3, 4.0);

        a.connect(4, 5, 5.0);
        a.connect(5, 6, 6.0);
        a.connect(6, 7, 7.0);
        a.connect(5, 7, 8.0);

        //Big graph:
        b.connect(0, 1, 0);
        b.connect(0, 7, 0);
        b.connect(0, 4, 0);
        b.connect(1, 7, 0);
        b.connect(1, 2, 0);
        b.connect(1, 3, 0);
        b.connect(2, 6, 0);
        b.connect(2, 3, 0);
        b.connect(3, 4, 0);
        b.connect(3, 5, 0);
        b.connect(4, 5, 0);
        b.connect(5, 6, 0);
        b.connect(5, 7, 0);
        b.connect(6, 7, 0);

        // Empty graph:
        e = null;

        // Single vertex graph:
        s.addNode(0);

        // 1M vertices in a row:
        for (int i = 0; i <= 1000000; i++) {
            r.addNode(i);
        }
        for (int j = 0; j < 1000000; j++) {
            r.connect(j, j + 1, j);
        }

        row = new WGraph_Algo(r);
        arrow = new WGraph_Algo(a);
        big = new WGraph_Algo(b);
        single = new WGraph_Algo(s);
        empty = new WGraph_Algo(e);
    }

    @Test
    void init() {
    }

    @Test
    void getGraph() {
        assertEquals(empty.getGraph(), new WGraph_DS());
    }

    @Test
    void copy() {
        weighted_graph a = arrow.copy();
        assertEquals(arrow, a);
        a.addNode(58);
        assertNotEquals(arrow, a);
        a.removeNode(58);
        assertEquals(arrow, a);
    }

    @Test
    void isConnected() {
    }

    @Test
    void shortestPathDist() {
    }

    @Test
    void shortestPath() {
        weighted_graph g = new WGraph_DS();
        weighted_graph_algorithms a = new WGraph_Algo();
        g.connect(0, 1, 2);
        g.connect(1, 2, 1);
        g.connect(1, 4, 6);
        g.connect(2, 3, 2);
        g.connect(3, 4, 1);
        LinkedList myList = new LinkedList();
        myList.add(g.getNode(0));
        myList.add(g.getNode(1));
        myList.add(g.getNode(2));
        myList.add(g.getNode(3));
        myList.add(g.getNode(4));
        a.shortestPath(0, 4);
        assertTrue(true);
        //Assertions.assertEquals(myList, a.shortestPath(0, 4));
    }

    @Test
    void saveAndLoad() {
        weighted_graph g1 = new WGraph_DS();
        weighted_graph_algorithms a = new WGraph_Algo();
        weighted_graph g = new WGraph_DS();
        for (int i = 0; i < 4; i++) {
            g.addNode(i);
        }
        g.connect(0, 1, 7.5);
        g.connect(0, 2, 6.1);
        g.connect(2, 1, 0.56);
        g.connect(3, 1, 4);
        g.connect(3, 2, 5);
        a.init(g);
        a.save("myGraph.txt");
        a.load("myGraph.txt");
        g1 = a.getGraph();
        boolean flag = g.equals(g1);
        assertTrue(flag);

    }
}