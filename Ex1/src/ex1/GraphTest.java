package ex1;

import java.util.HashMap;
import java.util.HashSet;

public class GraphTest {
    public static void main(String[] args) {


        weighted_graph g = new WGraph_DS();
//        g.addNode(0);
//        System.out.println(g.getNode(0).toString());

//        weighted_graph graph = new WGraph_DS();
//        weighted_graph graph1 = new WGraph_DS();
//        HashMap<Integer, Double> Cock = new HashMap<Integer, Double>();
//        HashMap<Integer, Double> Cock2 = new HashMap<Integer, Double>();
//        HashMap<Integer, HashMap<Integer, Double>> Nose = new HashMap<Integer, HashMap<Integer, Double>>();
//
//        Cock.put(1,10.0);
//       // Cock2.put(12,210.0);
//
//        Nose.put(0,Cock);
//        // {0,1|10}
//
//        Nose.get(0).put(12,210.0);
//        //{0,12|210}
//        Nose.get(0).put(12,21.0);
//        //{0,12|21}
//
//        System.out.println(Nose.get(0).get(12).doubleValue());
//        //{12,0}->21
//        HashMap<Integer, Double> Cock3 = new HashMap<Integer, Double>();
//        Cock3.put(0,21.0);
//        Nose.put(12,Cock3);
//        System.out.println(Nose.get(12).get(0).doubleValue());
//
//        System.out.println(Nose.toString());
//
//        weighted_graph graph2 = graph1;
//        System.out.println(graph1.equals(graph2));
//        //{1,2|3},{1,3|4},{2,3|5}
//        HashMap<Integer, Double> dick1 = new HashMap<Integer, Double>();
//        dick1.put(2,3.0);
//        Nose.put(1,dick1);//{1,2|3}
//        System.out.println(Nose.get(1).get(2).doubleValue());System.out.println(Nose.toString());
//
//        HashMap<Integer, Double> dick2 = new HashMap<Integer, Double>();
//        dick2.put(1, 3.0);
//        Nose.put(2, dick2);
//        System.out.println(Nose.get(2).get(1).doubleValue());System.out.println(Nose.toString());
//
//        HashMap<Integer, Double> dick3 = new HashMap<Integer, Double>();
//        dick3.put(3,4.0);
//        Nose.get(1).put(3,4.0);
//        System.out.println(Nose.get(1).get(3).doubleValue());System.out.println(Nose.toString());
//
//        HashMap<Integer, Double> dick4 = new HashMap<Integer, Double>();
//        dick4.put(1,4.0);
//        Nose.put(3, dick4); //
//        System.out.println(Nose.get(3).get(1).doubleValue());System.out.println(Nose.toString());
//
//        HashMap<Integer, Double> dick5 = new HashMap<Integer, Double>();
//        dick5.put(3,5.0);
//        Nose.get(2).put(3, 5.0);
//        System.out.println(Nose.get(2).get(3).doubleValue());System.out.println(Nose.toString());
//
//        HashMap<Integer, Double> dick6 = new HashMap<Integer, Double>();
//        dick6.put(2, 5.0);
//        Nose.get(3).put(2, 5.0);
//        System.out.println(Nose.get(3).get(2).doubleValue());System.out.println(Nose.toString());
//
//
//        graph.addNode(0);
//        System.out.println(graph.toString());
//        int dick = 0;
//
//
//        weighted_graph g = new WGraph_DS();
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);

        g.connect(1,2,2.0);
        g.connect(2,3,5.0);
        g.connect(2,3,7.0);
        System.out.println("supposed 7.0: "+g.getEdge(3,2));
        System.out.println("true: " +g.hasEdge(1,2));
        System.out.println("true: " +g.hasEdge(2,1));
        System.out.println("false: " +g.hasEdge(2,2));
        System.out.println("false: " +g.hasEdge(3,1));

        System.out.println(g.getV().toString());
        System.out.println(g.getV(1).toString());
        System.out.println(g.getV(2).toString());
        System.out.println(g.getV(0).toString());

        System.out.println(g.toString());
//        g.removeEdge(1,2);
//        g.removeEdge(1,100);

        g.removeNode(1);
//        g.connect(2,3,5.0);
//        g.connect(3,1,7.0);
//        g.connect(1,3,7.0);
//        g.connect(2,1,7.0);
//        g.connect(3,1,7.0);
        System.out.println(g.toString());
         int n = 2;

    }
}