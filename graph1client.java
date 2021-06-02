public class graph1client {
    public static void main(String[] args) {
        graph1 gr=new graph1();
        gr.addvertex("A");
        gr.addvertex("B");
        gr.addvertex("C");
        gr.addvertex("D");
        gr.addvertex("E");
        gr.addvertex("F");
        gr.addvertex("G");
       gr.addEdges("A","B",2);
       gr.addEdges("A","D",3);
       gr.addEdges("B","C",4);
       gr.addEdges("D","E",7);
       gr.addEdges("C","D",6);
       gr.addEdges("E","F",9);
       gr.addEdges("F","G",10);
       gr.addEdges("E","G",8);
       gr.display();
     //  System.out.println(gr.numEdeges());
      // System.out.println(gr.numvertex());
     //  System.out.println(gr.containsEdges("A", "E"));
      // System.out.println(gr.containsvertex("S"));
       //gr.removevertex("A");
      // gr.display();
       //gr.removeEdge("A", "D");
      // gr.display();
      // gr.addvertex("H");
      // gr.display();
      // gr.addEdges("H", "G", 11);

      // gr.display();
      // gr.addEdges("H", "A", 12);
      // gr.display();
      //gr.addEdges("B", "F", 13);
      //gr.addEdges("D", "F", 14);
     // gr.addEdges("A", "F", 15);
     // System.out.println(gr.bfs("A", "F"));
      //System.out.println(gr.dfs("A", "F"));
     // gr.bft();
     // System.out.println("*****************************");
     // gr.dft();
     //gr.removeEdge("A", "D");
    // gr.removeEdge("E", "F");
     //gr.display();
     //System.out.println(gr.iscyclic());
     //gr.removeEdge("D", "E");
    // System.out.println(gr.isconnected());
    gr.kruskal();

    }
}
