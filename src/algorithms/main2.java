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
		
		node_data v1 = new Node(1, p1);		
		node_data v2 = new Node(2, p2);	
		node_data v3 = new Node(3, p3);
		node_data v4 = new Node(4, p4);		
		node_data v5 = new Node(5, p5);	
		node_data v6 = new Node(6, p6);
		node_data v7 = new Node(7, p7);
		
		graph g = new DGraph();

		
		g.addNode(v1);
		g.addNode(v2);
		g.addNode(v3);
		g.addNode(v4);
		g.addNode(v5);
		g.addNode(v6);
		g.addNode(v7);
		
		g.connect(v1.getKey(), v2.getKey(), 2);
		g.connect(v1.getKey(), v3.getKey(), 2);
		g.connect(v2.getKey(), v4.getKey(), 3);
		g.connect(v3.getKey(), v4.getKey(), 1);
		g.connect(v4.getKey(), v5.getKey(), 3);
		g.connect(v4.getKey(), v6.getKey(), 4);
		g.connect(v6.getKey(), v7.getKey(), 1);
		g.connect(v5.getKey(), v7.getKey(), 1);
		
		graph_algorithms test = new Graph_Algo();
		test.init(g);
		test.shortestPathDist(1, 7);
	}

}
