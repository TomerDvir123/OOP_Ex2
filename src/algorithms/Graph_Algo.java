package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms,Serializable {

	graph grap;

	@Override
	public void init(graph g) {
		// TODO Auto-generated method stub
		//add g.copy
		this.grap = g;

	}
	public void cleanGraf () {
		Collection<node_data> colnod = this.grap.getV();

		for (node_data nd : colnod)
		{
			nd.setWeight(Double.MAX_VALUE);
			nd.setInfo("");
			nd.setTag(0);
		}
	}
	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub
		try {

			FileInputStream fi = new FileInputStream(new File(file_name));
			ObjectInputStream oi = new ObjectInputStream(fi);
			Graph_Algo t =  (Graph_Algo) oi.readObject();
			this.grap =t.grap;

		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream f = new FileOutputStream(new File(file_name));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(this);
			o.close();
			f.close();
		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		cleanGraf();
		Collection<node_data> colnod = this.grap.getV();
		Iterator<node_data> connect = colnod.iterator();


		if (colnod.size()==1) {
			return true;
		}
		else
		{

			node_data d =connect.next();
			d =connect.next();
			Collection<edge_data> coledg = this.grap.getE(d.getKey());

			boolean ans =checkcon(d, coledg);
			colnod = this.grap.getV();
			for (node_data ttt : colnod) {
				if(ttt.getTag()!=5) {
					ans=false;
				}
			}
			return ans;
		}
	}

	private boolean checkcon(node_data start,Collection<edge_data> coledg )
	{

		if(coledg.size()!=0) {
			start.setTag(5);
		}
		if(coledg.size()==0)
		{
			return false;
		}
		else
		{
			boolean ans = true;
			for (edge_data ed : coledg)
			{
				if (ed.getTag()!=5)
				{
					ed.setTag(5);
					node_data dest = this.grap.getNode(ed.getDest());
					Collection<edge_data> destedg = this.grap.getE(ed.getDest());
					ans = checkcon(dest, destedg);
				}
			}
			if (ans==true) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub

		cleanGraf();
		this.grap.getNode(src).setWeight(0);
		this.grap.getNode(src).setInfo(src+"");
		PriorityQueue<Double> pQueue = new PriorityQueue<Double>();
		ArrayList<node_data> AR = new ArrayList<node_data>();
		pQueue.add(this.grap.getNode(src).getWeight());
		int start  = src;
		while(pQueue.size()!=0)
		{
			boolean check = true;
			for (int i = 0; i < AR.size() && check; i++) {

				if(AR.get(i).getWeight() == pQueue.peek()) {
					start=AR.get(i).getKey();
					AR.remove(i);
					check = false;
				}
			}
			pQueue.poll();//0
			Collection<edge_data> coledg = this.grap.getE(start);
			node_data source = this.grap.getNode(start);
			//	source.setInfo(s);
			for (edge_data ed : coledg)
			{
				double sum = ( source.getWeight() + ed.getWeight() );
				int dest3 = ed.getDest();
				double max = this.grap.getNode(dest3).getWeight();
				if( sum <= max)
				{
					//strings
					//String before = source.getInfo();
					//					String now = this.grap.getNode(dest3).getKey()+"";
					this.grap.getNode(dest3).setInfo(ed.getSrc()+"");

					//whights
					AR.remove(this.grap.getNode(dest3));
					pQueue.remove(this.grap.getNode(dest3).getWeight());
					this.grap.getNode(dest3).setWeight(sum);
				}
				if (this.grap.getNode(ed.getDest()).getTag()!=99 && sum<max)
				{
					int destn = ed.getDest();
					pQueue.add(this.grap.getNode(destn).getWeight());//2
					AR.add(this.grap.getNode(ed.getDest()));
				}
			}
			source.setTag(99);
		}
		//		System.out.println(this.grap.getNode(dest).getInfo());
		return this.grap.getNode(dest).getWeight();
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		List<node_data> rememberWay = new ArrayList<node_data>();

		shortestPathDist(src, dest);
		int now = dest;
		while (now!=src) {
			node_data temp = this.grap.getNode(now);
			rememberWay.add(temp);
			String t = temp.getInfo();
			now = Integer.parseInt(t);			
		}
		rememberWay.add(this.grap.getNode(src));
		return rememberWay;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		if((connection (this.grap))==false)
		{
			return null;
		}
		List<node_data> nodesTSP = new ArrayList<node_data>();
		List<node_data> nodesTSP_temp = new ArrayList<node_data>();
		int y = 0;
		int i = 0;
		while(i+1<targets.size())
		{
			nodesTSP_temp = shortestPath(targets.get(i), targets.get(i+1));
			for (int k = 0; k < nodesTSP_temp.size(); k++)
			{
				nodesTSP.set(y, nodesTSP_temp.get(k));
				y++;
			}
			i++;
		}
		return nodesTSP;
	}


	private boolean connection (graph x) {
		Collection<node_data> temp = this.grap.getV();
		int size = temp.size();
		int sum_edges = 0;
		for (node_data nd : temp) {
			sum_edges = this.grap.getE(nd.getKey()).size();
			if(sum_edges != size-1)
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public graph copy() {

		graph a = new DGraph();

		Collection<node_data> nod = this.grap.getV();
		Iterator<node_data> it = nod.iterator();

		while(it.hasNext()) {

			node_data temp_node = it.next();
			//deep copy of Node
			int key = temp_node.getKey();
			Point3D Location = new Point3D(temp_node.getLocation().x() , temp_node.getLocation().y() , temp_node.getLocation().z() );
			double weight = temp_node.getWeight();
			String info = new String(temp_node.getInfo());

			int tag = temp_node.getTag();


			a.addNode(new Node(key, Location, weight, info, tag));


			Collection<edge_data> edg = this.grap.getE(temp_node.getKey());
			Iterator<edge_data> it2 = edg.iterator();

			while(it2.hasNext()) {
				edge_data ed = it2.next();
				//deep copy of Edge
				int src = ed.getSrc();
				int dest = ed.getDest();
				double edge_weight = ed.getWeight();
				String edge_info = new String(ed.getInfo());
				int edge_tag = ed.getTag();
				a.connect(src, dest, edge_weight);
				a.getEdge(src, dest).setInfo(edge_info);
				a.getEdge(src, dest).setTag(edge_tag);
			}

		}

		return a;

	}

}
class comp implements Comparator<node_data>
{

	@Override
	public int compare(node_data o1, node_data o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getWeight() - o2.getWeight());
	}

}
