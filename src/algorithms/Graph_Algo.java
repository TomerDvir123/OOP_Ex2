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
		Collection<node_data> colnod = this.grap.getV();
		Iterator<node_data> connect = colnod.iterator();
		Collection<edge_data> coledg = this.grap.getE(connect.next().getKey());
		if (colnod.size()==1) {
			return true;
		}
		else
		{
			boolean ans =checkcon(connect.next(), coledg);

			while (ans!=false&&connect.hasNext())
			{
				if(connect.next().getTag()!=5)
				{
					ans=false;
				}
			}
			return ans;
		}
	}

	private boolean checkcon(node_data start,Collection<edge_data> coledg ) 
	{
		start.setTag(5);
		if(coledg.size()==0) 
		{
			return false;
		}
		else 
		{
			boolean ans =true;
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

		Collection<node_data> colnod = this.grap.getV();

		for (node_data nd : colnod)
		{
			if(nd.getKey()!=src)
			{
				nd.setWeight(Double.MAX_VALUE);
			}
			else
				nd.setWeight(0);
				nd.setInfo(nd.getKey()+",");
		}
		PriorityQueue<Double> pQueue = new PriorityQueue<Double>();
		ArrayList<node_data> AR = new ArrayList<node_data>();
		pQueue.add(this.grap.getNode(src).getWeight());
		int start  = src;
		while(pQueue.size()!=0)
		{
			for (int i = 0; i < AR.size(); i++) {
				if(AR.get(i).getWeight() == pQueue.peek()) {
					start=AR.get(i).getKey();
					AR.remove(i);
				}
			}
			pQueue.poll();//0
			Collection<edge_data> coledg = this.grap.getE(start);
			Dijkstra(start , coledg);
			for (edge_data ed : coledg) {
				int destn = ed.getDest();

				pQueue.add(this.grap.getNode(destn).getWeight());//2
				AR.add(this.grap.getNode(ed.getDest()));
			}
		}
		System.out.println(this.grap.getNode(dest).getInfo());
		return 0;
	}
	public void Dijkstra (int src , Collection<edge_data> coledg) {

		node_data source = this.grap.getNode(src);
		for (edge_data ed : coledg)
		{		
			if (this.grap.getNode(ed.getDest()).getTag()!=99) 
			{
				double sum = ( source.getWeight() + ed.getWeight() );
				int dest = ed.getDest();
				double max = this.grap.getNode(dest).getWeight();
				if( sum <= max)
				{
					String path = this.grap.getNode(src).getInfo();
					String dest2 = this.grap.getNode(dest).getKey()+"";
					this.grap.getNode(dest).setInfo(path+dest2+",");
					this.grap.getNode(dest).setWeight(sum);
//					this.grap.getNode(dest).setWeight(sum);
//					int ke = source.getKey();
//					String des = this.grap.getNode(dest).getInfo()+ ke + ",";
//					this.grap.getNode(dest).setInfo(des);
				}			
			}
		}
		source.setTag(99);
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {

		DGraph other = new DGraph();

		other.copyGraph(this.grap);


		return null;

	}

}
