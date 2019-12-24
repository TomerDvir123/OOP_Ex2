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
//		Point3D p1 = new Point3D(0,0);
//		Point3D p2 = new Point3D(1,1);
//
//		node_data v1 = new Node(1, p1);		
//		node_data v2 = new Node(2, p2);	
//
//		graph g = new DGraph();
//
//		g.addNode(v1);
//		g.addNode(v2);
//
//		g.connect(v1.getKey(), v2.getKey(), 5);

		graph_algorithms test = new Graph_Algo();

			try {
				test.init("avi_graph");
			} catch (Exception e) {
				fail("Not yet implemented");
			}
			System.out.println("");
		
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

	@Test
	void testIsConnected() {
		
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);
		Point3D p3 = new Point3D(2,2);
		Point3D p4 = new Point3D(3,3);
		Point3D p5 = new Point3D(4,4);
		Point3D p6 = new Point3D(5,5);
		Point3D p7 = new Point3D(6,6);
		Point3D p8 = new Point3D(7,7);
		Point3D p9 = new Point3D(8,8);
		Point3D p10 = new Point3D(9,9);
		Point3D p11 = new Point3D(10,10);
		Point3D p12 = new Point3D(11,11);
		
		graph s = new DGraph();
		
		s.addNode(new Node(1,p1));
		s.addNode(new Node(2,p2));
		s.addNode(new Node(3,p3));
		s.addNode(new Node(4,p4));
		s.addNode(new Node(5,p5));
		s.addNode(new Node(6,p6));
		s.addNode(new Node(7,p7));
		s.connect(1, 2, 0);
		s.connect(1, 3, 0);
		s.connect(2, 4, 0);
		s.connect(2, 5, 0);
		s.connect(3, 2, 0);
		s.connect(4, 6, 0);
		s.connect(4, 5, 0);
		s.connect(5, 6, 0);
		s.connect(5, 7, 0);
		s.connect(6, 7, 0);
		s.connect(7, 1, 0);
		//// s.addNode(new Node(1));
		//// s.addNode(new Node(2));
		//// s.connect(1, 2, 0);
		Graph_Algo e = new Graph_Algo();
		e.init(s);
		assertEquals(true, e.isConnected());

		graph g2 = new DGraph();
		g2.addNode(new Node(1,p1));
		g2.addNode(new Node(2,p1));
		g2.addNode(new Node(3,p1));
		g2.addNode(new Node(4,p1));
		g2.addNode(new Node(5,p1));
		g2.connect(1, 5, 30);
		g2.connect(5, 1, 30);
		g2.connect(2, 5, 30);
		g2.connect(5, 2, 30);
		g2.connect(3, 5, 30);
		g2.connect(5, 3, 30);
		g2.connect(4, 5, 30);
		g2.connect(5, 4, 30);
		Graph_Algo ga2 = new Graph_Algo();
		ga2.init(g2);
		assertEquals(true, ga2.isConnected());

		graph g3 = new DGraph();
		g3.addNode(new Node(1,p1));
		g3.addNode(new Node(2,p1));
		g3.addNode(new Node(3,p1));
		g3.addNode(new Node(4,p1));
		g3.addNode(new Node(5,p1));
		g3.connect(1, 2, 30);
		g3.connect(2, 3, 30);
		g3.connect(3, 4, 30);
		g3.connect(4, 5, 30);
		Graph_Algo ga3 = new Graph_Algo();
		ga3.init(g3);
		assertEquals(false, ga3.isConnected());

	}

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
