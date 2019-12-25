package algorithms;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Point3D p1 = new Point3D(0,0);
		Point3D p2 = new Point3D(1,1);
		Point3D p3 = new Point3D(2,2);
		Point3D p4 = new Point3D(3,3);
		Point3D p5 = new Point3D(4,4);
		Point3D p6 = new Point3D(5,5);
		Point3D p7 = new Point3D(6,6);
		Point3D p8 = new Point3D(5,5);
		Point3D p9 = new Point3D(6,3);
		Point3D p10 = new Point3D(7,7);
		Point3D p11 = new Point3D(8,8);
		Point3D p12 = new Point3D(9,9);
		Point3D p13 = new Point3D(10,12);
		Point3D p14 = new Point3D(11,31);
		Point3D p15 = new Point3D(12,14);
		Point3D p16 = new Point3D(13,25);
		Point3D p17 = new Point3D(14,26);
		
		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	
		node_data v3 = new Node(3, p3);
		node_data v4 = new Node(4, p4);		
		node_data v5 = new Node(5, p5);	
		node_data v6 = new Node(6, p6);
		node_data v7 = new Node(7, p7);
		node_data v8 = new Node(8, p8);	
		node_data v9 = new Node(9, p9);	
		node_data v10 = new Node(10, p10);	
		node_data v11 = new Node(11, p11);		
		node_data v12 = new Node(12, p12);	
		node_data v13 = new Node(13, p13);
		node_data v14 = new Node(14, p14);		
		node_data v15 = new Node(15, p15);	
		node_data v16 = new Node(16, p16);
		node_data v17 = new Node(17, p17);
		
		graph g = new DGraph();

		
		g.addNode(v1);
		g.addNode(v2);
		g.addNode(v3);
		g.addNode(v4);
		g.addNode(v5);
		g.addNode(v6);
		g.addNode(v7);
		g.addNode(v8);
		g.addNode(v9);
		g.addNode(v10);
		g.addNode(v11);
		g.addNode(v12);
		g.addNode(v13);
		g.addNode(v14);
		g.addNode(v15);
		g.addNode(v16);
		g.addNode(v17);
		
//		g.connect(v1.getKey(), v2.getKey(), 2);
		g.connect(v1.getKey(), v3.getKey(), 2);
		g.connect(v2.getKey(), v4.getKey(), 3);
		g.connect(v3.getKey(), v4.getKey(), 1);
		g.connect(v4.getKey(), v5.getKey(), 3);
		g.connect(v4.getKey(), v6.getKey(), 4);
		g.connect(v6.getKey(), v7.getKey(), 1);
		g.connect(v5.getKey(), v7.getKey(), 1);
		
		g.connect(v1.getKey(), v8.getKey(), 1);
		g.connect(v8.getKey(), v9.getKey(), 2);
		g.connect(v9.getKey(), v10.getKey(), 0);
		g.connect(v8.getKey(), v10.getKey(), 3);
		g.connect(v10.getKey(), v5.getKey(), 2);
		g.connect(v2.getKey(), v5.getKey(), 4);
		g.connect(v3.getKey(), v11.getKey(), 0);
		g.connect(v11.getKey(), v12.getKey(), 0);
		g.connect(v12.getKey(), v7.getKey(), 7);
		
		graph_algorithms test = new Graph_Algo();
		test.init(g);
		System.out.println(test.shortestPathDist(1,2));
		
	}

}
