import java.util.*;
import java.util.ArrayList;
//import java.util.Collections.sort();
import java.util.HashMap;
import java.util.LinkedList;

/**
 * graph1
 */
public class graph1 {

    private class vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, vertex> vtces = new HashMap<>();
    //number of vertex
    public int numvertex() {

        return vtces.size();
    }
     
    //contains vertex
    public boolean containsvertex(String vname) {

        return this.vtces.containsKey(vname);

    }
    
    //add vertex to the graph
    public void addvertex(String vname) {

        vertex vtx = new vertex();

        vtces.put(vname, vtx);

    }

    // remove of vertex
    public void removevertex(String vname) {

        vertex vtx = vtces.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

        for (String key : keys) {

            vertex nbrvtx = vtces.get(key);
            nbrvtx.nbrs.remove(vname);

        }
        vtces.remove(vname);
    }
    
    //number of Edges
    public int numEdeges() {

        int count = 0;
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());

        for (String key : keys) {
            vertex vtx = vtces.get(key);
            count = count + vtx.nbrs.size();
        }
        return count / 2;
    }

    //containsEdges
    public boolean containsEdges(String vname1, String vname2) {

        vertex vtx1 = vtces.get(vname1);
        vertex vtx2 = vtces.get(vname2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
            return false;

        }
        return true;

    }

    // addEdges
    public void addEdges(String vname1, String vname2, int cost) {

        vertex vtx1 = vtces.get(vname1);
        vertex vtx2 = vtces.get(vname2);
        if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
            return;
        }
        vtx1.nbrs.put(vname2, cost);
        vtx2.nbrs.put(vname1, cost);
    }
    
    //remove Edges from the graph
    public void removeEdge(String vname1, String vname2) {

        vertex vtx1 = vtces.get(vname1);
        vertex vtx2 = vtces.get(vname2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
            return;
        }

        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }
    
    //display of the graph
    public void display() {
        System.out.println("------------------------------");
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());

        for (String key : keys) {
            vertex vtx = vtces.get(key);
            System.out.println(key + " :" + vtx.nbrs);
        }
        System.out.println("-------------------------------");
    }

    // pair class
    private class pair {
        String vname;
        String psf;
    }

    // bfs
    public boolean bfs(String src, String dst) {

        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();

        // creat a new pair of src

        pair sp = new pair();
        sp.vname = src;
        sp.psf = src;
        queue.addLast(sp);

        while (!queue.isEmpty()) {

            pair rp = queue.removeFirst();
            if (processed.containsKey(rp.vname)) {
                continue;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            // direct Edge
            if (containsEdges(rp.vname, dst)) {
                System.out.println(rp.psf + dst);
                return true;
            }

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    queue.addLast(np);
                }
            }
        }
        return false;
    }

    // dfs
    public boolean dfs(String src, String dst) {

        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> stack = new LinkedList<>();

        // creat a new pair of src

        pair sp = new pair();
        sp.vname = src;
        sp.psf = src;
        stack.addFirst(sp);

        while (!stack.isEmpty()) {

            pair rp = stack.removeFirst();
            if (processed.containsKey(rp.vname)) {
                continue;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            // direct Edge
            if (containsEdges(rp.vname, dst)) {
                System.out.println(rp.psf + dst);
                return true;
            }

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    stack.addFirst(np);
                }
            }
        }
        return false;
    }
    
    //bft
    public void bft() {

        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
     
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        for(String key:keys){
        // creat a new pair of src

        pair sp = new pair();
        sp.vname = key;
        sp.psf = key;
        queue.addLast(sp);

        while (!queue.isEmpty()) {

            pair rp = queue.removeFirst();
            if (processed.containsKey(rp.vname)) {
                continue;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            System.out.println(rp.vname +" via "+rp.psf);

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    queue.addLast(np);
                }
            }
        }
    }
    }
    
    //dft
    public void dft() {

        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> stack = new LinkedList<>();
     
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        for(String key:keys){
        // creat a new pair of src

        pair sp = new pair();
        sp.vname = key;
        sp.psf = key;
        stack.addFirst(sp);

        while (!stack.isEmpty()) {

            pair rp = stack.removeFirst();
            if (processed.containsKey(rp.vname)) {
                continue;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            System.out.println(rp.vname +" via "+rp.psf);

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    stack.addFirst(np);
                }
            }
        }
    }
    }
      
    //check graph is cyclic or not?
    public boolean iscyclic() {

        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
     
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        for(String key:keys){
        // creat a new pair of src
        if (processed.containsKey(key)) {
            continue;
        }

        pair sp = new pair();
        sp.vname = key;
        sp.psf = key;
        queue.addLast(sp);

        while (!queue.isEmpty()) {

            pair rp = queue.removeFirst();
            if (processed.containsKey(rp.vname)) {
                return true;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    queue.addLast(np);
                }
            }
        }
    }
    return false;
    }
    
    //check graph is connected or not?
    public boolean isconnected() {
       int flag=0;
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
     
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        for(String key:keys){
        // creat a new pair of src
        if (processed.containsKey(key)) {
            continue;
        }
        flag++;
        pair sp = new pair();
        sp.vname = key;
        sp.psf = key;
        queue.addLast(sp);

        while (!queue.isEmpty()) {

            pair rp = queue.removeFirst();
            if (processed.containsKey(rp.vname)) {
                continue;
            }
            // put in to the hashmap
            processed.put(rp.vname, true);

            // work on nbrs
            vertex rpvtx = vtces.get(rp.vname);

            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            for (String nbr : nbrs) {

                if (!processed.containsKey(nbr)) {

                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;

                    queue.addLast(np);
                }
            }
        }
    }
    if(flag>=2){
        return false;
    }else{
        return true;
    }
       

    }
    
    public class disjointset{

        HashMap<String ,Node> map=new HashMap<>();

        private class Node{
            String data;
            Node parent;
            int rank;
        }
        public void createset(String value){
         
            Node nn=new Node();
            nn.parent=nn;
            nn.data=value;
            nn.rank=0;
           map.put(value, nn);
        }
        public void union(String value1,String value2){

            Node n1=map.get(value1);
            Node n2=map.get(value2);

            Node re1=find(n1);
            Node re2=find(n2);

            if(re1.data.equals(re2.data)){
                return ;
            }else{
                if(re1.rank==re2.rank){
                    re2.parent=re1;
                    re1.rank+=1;
                }else if(re1.rank>re2.rank){
                    re2.parent=re1;
                }else{
                    re1.parent=re2;
                }
            }
        }
         public String find(String value){
             return find(map.get(value)).data;
         }
         private Node find(Node node){
             if(node==node.parent){
                 return node;
             }
             Node rr=find(node.parent);
             node.parent=rr;
             return rr;
         }
    }
   
    public class Edgepair implements Comparable<Edgepair>{
        String v1;
        String v2;
        int cost;
        @Override
        public int compareTo(Edgepair o){
            
            return this.cost-o.cost;
        }
        public String toString(){
            return v1+"-"+v2+":"+cost;
        }
    }
   
    public ArrayList<Edgepair> getAllEdges(){

        ArrayList<Edgepair> edges=new ArrayList<>();

        for(String vname:vtces.keySet()){

            vertex vtx=vtces.get(vname);

            for(String nbr:vtx.nbrs.keySet()){

                Edgepair ep=new Edgepair();
                ep.v1=vname;
                ep.v2=nbr;
                ep.cost=vtx.nbrs.get(nbr);

                edges.add(ep);
            }

        }
        return edges;
    }
   
    public void kruskal(){
        ArrayList<Edgepair> edges=getAllEdges();
        Collections.sort(edges);
        disjointset set=new disjointset();

        for(String vname:vtces.keySet()){
            set.createset(vname);
        }
        for(Edgepair edge:edges){
            String re1=set.find(edge.v1);
            String re2=set.find(edge.v2);
            
            if(re1.equals(re2)){
                continue;
            }else{
                 System.out.println(edge);
                set.union(edge.v1,edge.v2);
            }     
        }
    }
      
    private class Primspair{
         String vname;
         String acqvname;
         int cost;

    }
    
    public graph1 prims(){ 
        graph1 mst=new graph1();

        HashMap<String,Primspair> map=new HashMap<>();

        
         
        return mst;
    }
}

