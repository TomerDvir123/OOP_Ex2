package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

		Dijkstra(src);
		return 0;
	}
	public void Dijkstra (int src) {
		Collection<node_data> colnod = this.grap.getV();
		Iterator<node_data> itrnod = colnod.iterator();		
		while (itrnod.hasNext()) 
		{
			if(itrnod.next().getKey()!=src)
			{
				itrnod.next().setWeight(Integer.MAX_VALUE);
			}
			else
				itrnod.next().setWeight(0);
		}
		Collection<edge_data> coledg = this.grap.getE(src);	
		Iterator<edge_data> itrnod2 = coledg.iterator();
		
		while (itrnod2.hasNext()) {
			double sum = ( itrnod.next().getWeight()+itrnod2.next().getWeight());
			double max = this.grap.getNode(itrnod2.next().getDest()).getWeight();
			if( sum <= max)
			{
				this.grap.getNode(itrnod2.next().getDest()).setWeight(sum);
			}
	
			
		}









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
