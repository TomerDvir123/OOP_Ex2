package algorithms;

import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);

		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	

		graph g = new DGraph();

		g.addNode(v1);
		g.addNode(v2);

		g.connect(v1.getKey(), v2.getKey(), 5);

		graph_algorithms test = new Graph_Algo();
		test.init(g);
		
		test.save("avi_graph");
		test.init("avi_graph");
		
//		v1.c
//		System.out.println();
//		

//		try {
////			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
////			ObjectOutputStream o = new ObjectOutputStream(f);
////
////			// Write objects to file
////			o.writeObject(test);
////			o.writeObject(p2);
//
////			o.close();
////			f.close();
//			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
//			ObjectInputStream oi = new ObjectInputStream(fi);
//			
//			test = (graph_algorithms) oi.readObject();
////
////			// Read objects
////			Person pr1 = (Person) oi.readObject();
////			Person pr2 = (Person) oi.readObject();
////
////			System.out.println(pr1.toString());
////			System.out.println(pr2.toString());
////
////			oi.close();
////			fi.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream");
//		} catch (RuntimeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

	
}
