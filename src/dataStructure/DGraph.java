package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import utils.Point3D;

public class DGraph implements graph,Serializable {

	Hashtable<Integer, node_data> nodes = new Hashtable<Integer, node_data>();
	Hashtable<node_data, Hashtable<Integer, edge_data>> edges = new Hashtable<node_data,Hashtable<Integer, edge_data>>();
	public static int count_ed = 0;
	public static int count_mc = 0;
	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		count_mc++;
		return nodes.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		count_mc++;
		node_data x = nodes.get(src);		
		return edges.get(x).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		count_mc++;
		nodes.put(n.getKey(), n);
		edges.put(n,new Hashtable<Integer, edge_data>());
	}

	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated method stub
		count_mc++;
		count_ed++;
		edge_data e = new Edge(src, dest, w);
		node_data k = nodes.get(src);
		edges.get(k).put(dest, e);

	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		count_mc++;
		return nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		count_mc++;
		node_data k = nodes.get(node_id);
		return edges.get(k).values();
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		count_mc++;
		Collection<node_data> col = getV();
		Iterator<node_data> itr = col.iterator();
		while (itr.hasNext()) 
		{
			node_data temp = itr.next();
			if(edges.get(temp).containsKey(key)==true)
			{
				edges.get(temp).remove(key);
				count_ed--;
			}
		}
		node_data k = nodes.get(key);
		count_ed = count_ed - edges.get(k).size();
		edges.get(k).remove(key);		
		return nodes.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		count_mc++;
		count_ed--;
		node_data k = nodes.get(src);				
		return edges.get(k).remove(dest);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		count_mc++;
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		count_mc++;
		return count_ed;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return count_mc;
	}
	
	public graph copyGraph(graph gr) {

		
		graph other = new DGraph();
		
		Collection<node_data> nod = gr.getV();
		Iterator<node_data> it = nod.iterator();

		while(it.hasNext()) {

			node_data temp_node = it.next();
			//deep copy of Node
			int key = temp_node.getKey();
			Point3D Location = new Point3D(temp_node.getLocation().x() , temp_node.getLocation().y() , temp_node.getLocation().z() );
			double weight = temp_node.getWeight();
			String info = new String(temp_node.getInfo());
			int tag = temp_node.getTag();
			
			gr.addNode(new Node(key, Location, weight, info, tag));
			
			
			Collection<edge_data> edg = gr.getE(temp_node.getKey());
			Iterator<edge_data> it2 = edg.iterator();

			while(it2.hasNext()) {
				edge_data ed = it2.next();
				//deep copy of Edge
				int src = ed.getSrc();
				int dest = ed.getDest();
				double edge_weight = ed.getWeight();
				String edge_info = new String(ed.getInfo());
				int edge_tag = ed.getTag();
				gr.connect(src, dest, edge_weight);
				
			}

		}

		return null;
	}
}
