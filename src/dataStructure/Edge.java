package dataStructure;

import java.awt.Color;
import java.io.Serializable;

public class Edge implements edge_data,Serializable {

	int src;
	int dest;
	double weight;
	String info;
	Color tag;
	
	public Edge ( int src, int dest , Double weight ) {
		this.weight=weight;
		this.src=src;
		this.dest=dest;
	}

	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.src;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.info = s;
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag.getRGB();
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = new Color(t);
	}

}
