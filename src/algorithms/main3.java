	package algorithms;

	import dataStructure.DGraph;
	import dataStructure.Node;
	import dataStructure.graph;
	import dataStructure.node_data;
	import utils.Point3D;

	public class main3 {

	public static void main(String[] args) {
	Point3D p3 = new Point3D(2,2);
	Point3D p4 = new Point3D(3,3);
	Point3D p5 = new Point3D(4,4);
	//Point3D p6 = new Point3D(5,5);
	node_data v1 = new Node(1, p3);
	node_data v2 = new Node(2, p4);
	node_data v3 = new Node(3, p5 );
	//node_data v4 = new Node(4, p5 );
	//node_data v5 = new Node(5, p5 );


	graph g = new DGraph();

	g.addNode(v1);
	g.addNode(v2);
	g.addNode(v3);
	//g.addNode(v4);
	//g.addNode(v5);


	g.connect(v1.getKey(), v2.getKey(), 5);
	g.connect(v2.getKey(), v1.getKey(), 5);
	g.connect(v2.getKey(), v3.getKey(), 5);
	g.connect(v3.getKey(), v2.getKey(), 5);

	//g.connect(v4.getKey(), v1.getKey(), 5);
	//g.connect(v1.getKey(), v5.getKey(), 5);






	graph_algorithms test = new Graph_Algo();
	test.init(g);

	System.out.println(test.isConnected());

	}

	}