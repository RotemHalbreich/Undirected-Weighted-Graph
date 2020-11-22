package ex1.tests;

import ex1.src.*;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_DSTest {
    private weighted_graph arrow, big, single, empty;

    @BeforeEach
    void beforeEach() {
        arrow = new WGraph_DS();
        big = new WGraph_DS();
        single = new WGraph_DS();
        empty = new WGraph_DS();

        for (int i = 0; i <= 7; i++) {
            arrow.addNode(i);
            big.addNode(i);
        }
        empty = null;

        single.addNode(0);

        //Arrow graph:
        arrow.connect(0, 1, 1.0);
        arrow.connect(1, 2, 2.0);
        arrow.connect(2, 0, 3.0);
        arrow.connect(2, 3, 4.0);

        arrow.connect(4, 5, 5.0);
        arrow.connect(5, 6, 6.0);
        arrow.connect(6, 7, 7.0);
        arrow.connect(5, 7, 8.0);

        //Big graph:
        big.connect(0, 1, 0);
        big.connect(0, 7, 0);
        big.connect(0, 4, 0);
        big.connect(1, 7, 0);
        big.connect(1, 2, 0);
        big.connect(1, 3, 0);
        big.connect(2, 6, 0);
        big.connect(2, 3, 0);
        big.connect(3, 4, 0);
        big.connect(3, 5, 0);
        big.connect(4, 5, 0);
        big.connect(5, 6, 0);
        big.connect(5, 7, 0);
        big.connect(6, 7, 0);

    }

    @Test
    void getNode() {
        weighted_graph w = new WGraph_DS();
        w.addNode(0);
        weighted_graph w1 = new WGraph_DS();
        w1.addNode(0);
        assertEquals(w, w1);
    }

    @Test
    void hasEdge() {
        assertTrue(arrow.hasEdge(2, 0));
        assertFalse(arrow.hasEdge(4, 3));
        arrow.connect(3, 4, 10.0);
        assertTrue(arrow.hasEdge(4, 3));

        assertFalse(single.hasEdge(0, 0));
        assertFalse(empty.hasEdge(0, 0));
        assertFalse(empty.hasEdge(0, 10));

    }

    @Test
    void getEdge() {
        assertEquals(4, arrow.getEdge(3,2));
        assertEquals(-1, arrow.getEdge(3,4));
        assertNotEquals(0, arrow.getEdge(3,4));
    }

    @Test
    void addNode() {
        assertEquals(8, arrow.nodeSize());
        arrow.addNode(8);
        assertEquals(9, arrow.nodeSize());
        assertEquals(9, arrow.getV().size());
        assertNull(empty);
    }

    @Test
    void connect() {
      assertEquals(-1,arrow.getEdge(2,4));
      assertFalse(arrow.hasEdge(2,4));
      arrow.connect(2,4,10);
      assertTrue(arrow.hasEdge(2,4));
      assertEquals(10,arrow.getEdge(2,4));
       double exp = arrow.edgeSize();
       arrow.connect(2,3,5.987543);
       assertEquals(exp,arrow.edgeSize());
    }

    @Test
    void getV() {
        assertEquals(big.getV().size(), big.nodeSize());
        big.removeEdge(0,1);
        assertEquals(big.getV().size(), big.nodeSize());
        big.removeNode(0);
        assertEquals(big.getV().size(), big.nodeSize());
        assertNotEquals(big.getV().size(), arrow.getV().size());
        big.addNode(0);
        assertEquals(big.getV().size(), arrow.getV().size());
    }

    @Test
    void testGetV() {
        assertEquals(3, arrow.getV(2).size());
        arrow.removeEdge(2,3);
        assertEquals(2, arrow.getV(2).size());
    }

    @Test
    void removeNode() {
        assertEquals(arrow.nodeSize(), big.nodeSize());
        big.removeNode(7);
        assertNotEquals(arrow.nodeSize(), big.nodeSize());
    }

    @Test
    void removeEdge() {
        assertEquals(14, big.edgeSize());
        big.removeEdge(0,1);
        assertEquals(13, big.edgeSize());
        big.removeEdge(2,1);
        assertEquals(12, big.edgeSize());
        assertEquals(0, single.edgeSize());
        single.removeEdge(0,0);
        assertEquals(0, single.edgeSize());
        assertNotEquals(3.4, single.edgeSize());
    }

    @Test
    void nodeSize() {
        assertEquals(big.nodeSize(), arrow.nodeSize());
        assertNotEquals(single.nodeSize(), arrow.nodeSize());
        assertEquals(1, single.nodeSize());
        single.addNode(5);
        assertEquals(2, single.getV().size());

    }

    @Test
    void edgeSize() {
        assertEquals(8, arrow.edgeSize());
        arrow.connect(3,4, 200.0);
        assertEquals(9, arrow.edgeSize());
        assertFalse(single.hasEdge(0,1));
        assertEquals(-1, single.getEdge(0,200));
        assertFalse(single.hasEdge(0,5));
        single.addNode(5);
        single.connect(0, 5, 56.0);
        assertEquals(56.0, single.getEdge(0,5));
    }

    @Test
    void getMC() {
        assertNotEquals(arrow.getMC(), single.getMC());
        assertEquals(big.getMC(),big.getMC());
        weighted_graph g1 = new WGraph_DS();

    }

    @Test
    void testToString() {
    }


//#############################################################
//@Test
//void removeNodeAndEdges() {
//    weighted_graph g0 = small_graph_creator();
//    g0.removeNode(3);
//    g0.removeEdge(1, 0);
//    boolean flag = true;
//    for (node_info curr : g0.getV()) {
//        for (node_info other : g0.getV(curr.getKey())) {
//            if (other.getKey() == 3)
//                flag = false;
//        }
//    }
//    Assertions.assertEquals(1, g0.edgeSize());//test for number of edges after removing node
//    Assertions.assertEquals(true, flag);
//    Assertions.assertEquals(4, g0.nodeSize());
//}
//
//    @Test
//    void AddAndRemoveDoubleNodesAndEdges() {
//        weighted_graph g0 = small_graph_creator();
//        double i = 0.3;
//        g0.connect(0, 1, i);//same
//        g0.connect(1, 2, i);//same
//        Assertions.assertEquals(5, g0.nodeSize());
//        Assertions.assertEquals(5, g0.edgeSize());
//        g0.removeEdge(0, 1);
//        g0.removeEdge(0, 1);
//        g0.removeNode(2);
//        g0.removeNode(2);
//        Assertions.assertEquals(2, g0.edgeSize());
//        Assertions.assertEquals(4, g0.nodeSize());
//    }
//
//    @Test
//    void checkGetAndHasEdgeFunctions() {
//        weighted_graph g0 = small_graph_creator();
//        Assertions.assertEquals(0, g0.getEdge(1, 1));
//        Assertions.assertEquals(-1, g0.getEdge(1, 7));
//        g0.connect(1, 3, 12);//check update from 0.3->12
//        Assertions.assertEquals(12, g0.getEdge(1, 3));
//    }
//
//    @Test
//    void checkMC() {
//        weighted_graph g0 = small_graph_creator();
//        Assertions.assertEquals(10, g0.getMC());
//        g0.removeEdge(3, 4);
//        Assertions.assertEquals(11, g0.getMC());//check if mc updates when removing edge
//        g0.removeNode(0);//check if mc updates when removing Node with edges
//        Assertions.assertEquals(14, g0.getMC());
//        g0.connect(1, 3, 0.2);////check if mc updates when connecting between two nodes
//        Assertions.assertEquals(15, g0.getMC());
//        g0.connect(1, 3, 0.6);//check if mc updates while changing weight
//        Assertions.assertEquals(16, g0.getMC());
//        g0.connect(1, 3, 0.6);//check if mc does not update while changing to the same weight
//        Assertions.assertEquals(16, g0.getMC());
//    }
//
//    @Test
//    void getV() {
//        weighted_graph g0 = small_graph_creator();
//        Assertions.assertEquals(g0.edgeSize(), g0.getV().size());//check size
//        Iterator<node_info> iterator = g0.getV().iterator();
//        int[] nodes = nodes(g0);
//        boolean flag = true;
//        int i = 0;
//        for (int node : nodes) {
//            while (iterator.hasNext()) {
//                if (iterator.next().getKey() == node)
//                    i++;
//            }
//            iterator = g0.getV().iterator();
//        }
//        Assertions.assertEquals(g0.nodeSize(), i);//check nodes
//        for (int node : nodes) {
//            for (node_info currNi : g0.getV(node)) {
//                if (!g0.hasEdge(node, currNi.getKey())) {
//                    flag = false;
//                }
//            }
//            Assertions.assertTrue(flag);//check Ni
//        }
//    }
//    //////////////////////////////////////////////////////
//
//    public static weighted_graph small_graph_creator() {
//        weighted_graph g0 = new WGraph_DS();
//        for (int i = 0; i < 5; i++) {
//            g0.addNode(i);
//        }
//        double i = 0.3;
//        g0.connect(0, 1, i);
//        g0.connect(1, 2, i);
//        g0.connect(0, 3, i);
//        g0.connect(4, 3, i);
//        g0.connect(2, 3, i);
//        return g0;
//    }
//
//    private static int[] nodes(weighted_graph g) {
//        int size = g.nodeSize();
//        Collection<node_info> V = g.getV();
//        node_info[] nodes = new node_info[size];
//        V.toArray(nodes);
//        int[] arr = new int[size];
//        int i = 0;
//        for (node_info Node : nodes) {
//            arr[i] = Node.getKey();
//            i++;
//        }
//        return arr;
//    }
}