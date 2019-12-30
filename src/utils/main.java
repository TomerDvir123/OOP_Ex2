package utils;

import javax.swing.JFrame;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;

public class main
{

	public static void main(String[] args) 
	{
//		Window window = new Window();
//		window.setVisible(true);
//		
		
		
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);
		Point3D p3 = new Point3D(2,2);
		//Point3D p4 = new Point3D(3,3);
//		Point3D p5 = new Point3D(4,4);
//		Point3D p6 = new Point3D(5,5);
//		Point3D p7 = new Point3D(6,6);
//		Point3D p8 = new Point3D(7,5);
//		Point3D p9 = new Point3D(6,3);
//		Point3D p10 = new Point3D(7,7);
//		Point3D p11 = new Point3D(8,8);
//		Point3D p12 = new Point3D(9,9);
//		Point3D p13 = new Point3D(10,12);
//		Point3D p14 = new Point3D(11,31);
//		Point3D p15 = new Point3D(12,14);
//		Point3D p16 = new Point3D(13,25);
//		Point3D p17 = new Point3D(14,26);
//		Point3D p18 = new Point3D(15,5);
//		Point3D p19 = new Point3D(16,3);
//		Point3D p20 = new Point3D(17,7);

		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	
		node_data v3 = new Node(3, p3);
	//	node_data v4 = new Node(4, p4);		
//		node_data v5 = new Node(5, p5);	
//		node_data v6 = new Node(6, p6);
//		node_data v7 = new Node(7, p7);
//		node_data v8 = new Node(8, p8);	
//		node_data v9 = new Node(9, p9);	
//		node_data v10 = new Node(10, p10);	
//		node_data v11 = new Node(11, p11);		
//		node_data v12 = new Node(12, p12);	
//		node_data v13 = new Node(13, p13);
//		node_data v14 = new Node(14, p14);		
//		node_data v15 = new Node(15, p15);	
//		node_data v16 = new Node(16, p16);
//		node_data v17 = new Node(17, p17);
//		node_data v18 = new Node(18, p8);	
//		node_data v19 = new Node(19, p9);	
//		node_data v20 = new Node(20, p10);

		graph g = new DGraph();


		g.addNode(v1);
		g.addNode(v2);
		g.addNode(v3);
	//	g.addNode(v4);
//		g.addNode(v5);
//		g.addNode(v6);
//		g.addNode(v7);
//		g.addNode(v8);
//		g.addNode(v9);
//		g.addNode(v10);
//		g.addNode(v11);
//		g.addNode(v12);
//		g.addNode(v13);
//		g.addNode(v14);
//		g.addNode(v15);
//		g.addNode(v16);
//		g.addNode(v17);
//		g.addNode(v18);
//		g.addNode(v19);
//		g.addNode(v20);

		g.connect(v1.getKey(), v2.getKey(), 5);
		g.connect(v2.getKey(), v1.getKey(), 5);
		g.connect(v2.getKey(), v3.getKey(), 5);
		g.connect(v3.getKey(), v2.getKey(), 5);
//		g.connect(v4.getKey(), v8.getKey(), 10);
//		g.connect(v4.getKey(), v10.getKey(), 8);
//		g.connect(v6.getKey(), v10.getKey(), 9);
//		g.connect(v6.getKey(), v12.getKey(), 5);
//
//		g.connect(v8.getKey(), v14.getKey(), 1);
//		g.connect(v10.getKey(), v14.getKey(), 1);
//		g.connect(v10.getKey(), v16.getKey(), 1);
//		g.connect(v10.getKey(), v18.getKey(), 1);
//		g.connect(v12.getKey(), v8.getKey(), 1);
//		g.connect(v14.getKey(), v20.getKey(), 4);
//		g.connect(v16.getKey(), v20.getKey(), 3);
//		g.connect(v18.getKey(), v20.getKey(), 2);
//		g.connect(v3.getKey(), v5.getKey(), 4);
//
//		g.connect(v3.getKey(), v7.getKey(), 1);
//		g.connect(v5.getKey(), v9.getKey(), 1);
//		g.connect(v5.getKey(), v11.getKey(), 3);
//		g.connect(v7.getKey(), v11.getKey(), 2);
//		g.connect(v7.getKey(), v13.getKey(), 1);
//		g.connect(v9.getKey(), v15.getKey(), 4);
//		g.connect(v11.getKey(), v15.getKey(), 5);
//		g.connect(v11.getKey(), v17.getKey(), 6);
//		g.connect(v11.getKey(), v19.getKey(), 7);
//		g.connect(v13.getKey(), v19.getKey(), 8);
//		g.connect(v15.getKey(), v20.getKey(), 1);
//		g.connect(v17.getKey(), v20.getKey(), 3);
//		g.connect(v19.getKey(), v20.getKey(), 9);


//		graph_algorithms test = new Graph_Algo();
//		
//		test.init(g);
//		System.out.println(test.isConnected());

		Window wind = new Window();
		wind.setVisible(true);
		
		
	}

}
