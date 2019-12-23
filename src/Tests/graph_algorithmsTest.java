package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import dataStructure.*;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import utils.Point3D;

class graph_algorithmsTest {

	@Test
	void testInitGraph() {
		
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);

		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	

		graph g = new DGraph();

		g.addNode(v1);
		g.addNode(v2);

		g.connect(v1.getKey(), v2.getKey(), 5);

		graph_algorithms test = new Graph_Algo();
	
		try {
			test.init(g);
		} catch (Exception e) {
			fail("Not yet implemented");	
		}
	}

//	@Test
//	void testCopy() {
//		
//		
//		
//		Person p1 = new Person("John", 30, "Male");
////		Person p2 = new Person("Rachel", 25, "Female");
//		
//		try {
//			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
//			ObjectOutputStream o = new ObjectOutputStream(f);
//
//			// Write objects to file
//			o.writeObject(p1);
//			o.writeObject(p2);
//
//			o.close();
//			f.close();
//
//			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
//			ObjectInputStream oi = new ObjectInputStream(fi);
//
//			// Read objects
//			Person pr1 = (Person) oi.readObject();
//			Person pr2 = (Person) oi.readObject();
//
//			System.out.println(pr1.toString());
//			System.out.println(pr2.toString());
//
//			oi.close();
//			fi.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//	}
//		fail("Not yet implemented");
//	}

	@Test
	void testInitString() {
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);

		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	

		graph g = new DGraph();

		g.addNode(v1);
		g.addNode(v2);

		g.connect(v1.getKey(), v2.getKey(), 5);

		graph_algorithms test = new Graph_Algo();

			try {
				test.init("avi_graph");
			} catch (Exception e) {
				fail("Not yet implemented");
			}

		
	}

	@Test
	void testSave() {
		
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
		
		try {
			test.save("avi_graph");
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
//
//	@Test
//	void testIsConnected() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testShortestPathDist() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testShortestPath() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTSP() {
//		fail("Not yet implemented");
//	}

}
