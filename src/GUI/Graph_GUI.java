
package GUI;

import dataStructure.*;
import algorithms.*;
import utils.*;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Graph_GUI extends JFrame implements ActionListener, MouseListener,Serializable
{
	private static JFrame frame;
	graph grap;	
	LinkedList<Point3D> points = new LinkedList<Point3D>();
	ArrayList<node_data> SP= new ArrayList<node_data>();
	public Graph_GUI()
	{
		initGUI();
	}
	public Graph_GUI(graph g )
	{
		this.grap = g;
		initGUI();
	}
	private void initGUI()
	{
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);

		Menu Functions = new Menu("Functions");
		menuBar.add(Functions);
		this.setMenuBar(menuBar);

		Menu help = new Menu("Help");
		menuBar.add(help);
		this.setMenuBar(menuBar);

		Menu tests = new Menu("tests");
		menuBar.add(tests);
		this.setMenuBar(menuBar);

		MenuItem item2 = new MenuItem("Is connected");
		item2.addActionListener(this);

		MenuItem item7 = new MenuItem("Shortest path dist");    
		item7.addActionListener(this);

		MenuItem item8 = new MenuItem("Shortest path");    
		item8.addActionListener(this);

		MenuItem item9 = new MenuItem("TSP");    
		item9.addActionListener(this);

		MenuItem item3 = new MenuItem("save");
		item3.addActionListener(this);

		MenuItem item4 = new MenuItem("load");
		item4.addActionListener(this);

		MenuItem item5 = new MenuItem("test1");
		item5.addActionListener(this);

		MenuItem item6 = new MenuItem("test2");
		item6.addActionListener(this);

		menu.add(item3);
		menu.add(item4);

		tests.add(item5);
		tests.add(item6);

		Functions.add(item2);
		Functions.add(item7);
		Functions.add(item8);
		Functions.add(item9);

		this.addMouseListener(this);
	}

	public void paint(Graphics g)
	{
		if (this.grap!=null) 
		{
			super.paint(g);
			for(node_data node : this.grap.getV()) {
				g.setColor(Color.RED);
				g.fillOval(node.getLocation().ix(), node.getLocation().iy(), 12, 12);
				Collection<edge_data> edd = this.grap.getE(node.getKey());
				g.setColor(Color.BLACK);
				g.drawString(""+node.getKey(), node.getLocation().ix()+4,node.getLocation().iy()-3);

				for (edge_data ed : edd)
				{
					if(ed.getTag()==2)
					{
						g.setColor(Color.green);
						ed.setTag(0);
					}
					else
					{
						g.setColor(Color.blue);
					}
					g.drawLine(node.getLocation().ix()+5, node.getLocation().iy()+5, this.grap.getNode(ed.getDest()).getLocation().ix()+5, this.grap.getNode(ed.getDest()).getLocation().iy()+5);
					int x1 = node.getLocation().ix()+5;
					int y1 = node.getLocation().iy()+5;
					int x2 = this.grap.getNode(ed.getDest()).getLocation().ix()+5;
					int y2 = this.grap.getNode(ed.getDest()).getLocation().iy()+5;
					int yyyyy = (((node.getLocation().iy()+this.grap.getNode(ed.getDest()).getLocation().iy())/2)+this.grap.getNode(ed.getDest()).getLocation().iy())/2;
					int xxxxx = (((node.getLocation().ix()+this.grap.getNode(ed.getDest()).getLocation().ix())/2)+this.grap.getNode(ed.getDest()).getLocation().ix())/2;
					g.setColor(Color.yellow);
					g.fillOval((xxxxx+this.grap.getNode(ed.getDest()).getLocation().ix())/2, (yyyyy+this.grap.getNode(ed.getDest()).getLocation().iy())/2, 10, 10);
					g.setColor(Color.BLACK);
					g.drawString(""+ed.getWeight(), (int)((x1+x2)/2),(int)((y1+y2)/2));
				}
			}
		}
		else
		{

		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		if(str.equals("TSP"))
		{
			ArrayList<Integer> keys = new ArrayList<Integer>();

			JFrame jinput = new JFrame();
			JOptionPane.showMessageDialog(jinput, "Enter all TSP nodes , from Start to Dest : "
					+ "\nenter stop when you finish!!");

			String start;

			do {
				start = JOptionPane.showInputDialog(jinput,"Enter all TSP nodes , from Start to Dest : \nor 'stop' to finish ");
				if(start.equals("stop"))
				{
					break;
				}
				try
				{
					keys.add(Integer.parseInt(start));
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
					JOptionPane.showMessageDialog(jinput, "Enter good Input : int or 'stop' to finish  ");
				}

			}
			while(!start.equals("stop"));

			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);
			java.util.List<node_data> k = temp.TSP(keys);
			if(k.size()!=0) 
			{
				for (int i = 0 ; i <k.size() ; i++) {
					SP.add(k.get(i));
				}
				String msg="" ;
				for (int i = 0 ; i <SP.size()-1 ; i++) {

					this.grap.getEdge(SP.get(i).getKey(), SP.get(i+1).getKey()).setTag(2);
					msg= msg+SP.get(i).getKey()+"->";
				}
				int siz = SP.size()-1;
				msg = msg + SP.get(siz).getKey();
				repaint();
				SP = new ArrayList<node_data>();
				JOptionPane.showMessageDialog(jinput, "path :\n"+msg+"");
			}
			else
			{
				JOptionPane.showMessageDialog(jinput, "some path not valid ");
			}
			SP = new ArrayList<node_data>();
		}

		////Shortest path distance///
		if(str.equals("Shortest path dist"))
		{

			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);
			JFrame jinput = new JFrame();
			double x =0;
			String start = JOptionPane.showInputDialog(jinput,"Start point");
			String finish = JOptionPane.showInputDialog(jinput,"Finish point");
			try
			{
				int src = Integer.parseInt(start);
				int des = Integer.parseInt(finish);

				x = temp.shortestPathDist(src, des);
				if(x!=-1) 
				{
					JOptionPane.showMessageDialog(jinput, "The shortest distance is: " + x);
				}
				else
				{
					JOptionPane.showMessageDialog(jinput, "char not valid ");
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}

			repaint();

		}

		//"Shortest path - draws the path"
		if(str.equals("Shortest path"))
		{

			java.util.List<node_data> nodes = new ArrayList<node_data>();

			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);

			JFrame jinput = new JFrame();
			String start = JOptionPane.showInputDialog(jinput,"Start point");
			String finish = JOptionPane.showInputDialog(jinput,"Finish point");
			try
			{
				int src = Integer.parseInt(start);
				int des = Integer.parseInt(finish);
				nodes = temp.shortestPath(src, des);

			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			if(nodes.size()!=0) 
			{
				for (int i = nodes.size()-1; i >= 0; i--) {
					SP.add(nodes.get(i));
				}

				for (int i = 0; i < SP.size()-1; i++) {
					this.grap.getEdge(SP.get(i).getKey(), SP.get(i+1).getKey()).setTag(2);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(jinput, "char not valid ");
			}

			repaint();
			SP = new ArrayList<node_data>();
		}

		//"Is connected"
		if(str.equals("Is connected"))
		{
			JFrame jinput = new JFrame();
			if (this.grap!=null) {

				Graph_Algo temp = new Graph_Algo();
				temp.init(grap);
				boolean ans = temp.isConnected();

				try
				{
					Graph_Algo ga = new Graph_Algo();
					ga.init(grap);
					JOptionPane.showMessageDialog(jinput, "Is connected? "+ans );
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
				repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(jinput, "the graph is empty ");
			}
		}

		////save///
		if(str.equals("save"))
		{
			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);

			FileDialog chooser = new FileDialog(Graph_GUI.frame, "Use a .txt extension", FileDialog.SAVE);
			chooser.setVisible(true);
			String filename = chooser.getFile();
			if (filename != null) 
			{
				temp.save(chooser.getDirectory()+filename+".txt");
			}
		}

		////load///
		if(str.equals("load"))
		{
			Graph_Algo temp = new Graph_Algo();
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			JFrame frame = new JFrame("JComboBox Test");
			frame.setLayout(new FlowLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				temp.init(selectedFile.getPath());
				grap = temp.copy();
				repaint();
			}
			frame.pack();
		}

		//test1
		if(str.equals("test1"))
		{		
			Point3D a = new Point3D(25,90,0);
			Point3D b = new Point3D(340,300,0);
			Point3D c = new Point3D(24,300,0);
			Point3D d = new Point3D(68,100,0);
			Point3D f = new Point3D(500,600,0);
			//Point3D h = new Point3D(300,550,0);

			node_data v1 = new Node(1, a);
			node_data v2 = new Node(2, b);
			node_data v3 = new Node(3, c);
			node_data v4 = new Node(4, d);
			node_data v5 = new Node(5, f);
			//node_data v8 = new Node(8, h);

			graph grap = new DGraph();

			grap.addNode(v1);
			grap.addNode(v2);
			grap.addNode(v3);
			grap.addNode(v4);
			grap.addNode(v5);

			grap.connect(v1.getKey(), v3.getKey(), 6);
			grap.connect(v1.getKey(), v4.getKey(), 10);
			grap.connect(v3.getKey(), v4.getKey(), 9);
			grap.connect(v4.getKey(), v2.getKey(), 3);
			grap.connect(v3.getKey(), v5.getKey(), 1);
			grap.connect(v1.getKey(), v3.getKey(), 5);
			grap.connect(v2.getKey(), v3.getKey(), 5);
			grap.connect(v2.getKey(), v5.getKey(), 1);
			Graph_GUI window = new Graph_GUI(grap);


			window.setVisible(true);
			repaint();
		}
		if(str.equals("test2"))
		{
			Point3D a = new Point3D(25,90,0);
			Point3D b = new Point3D(100,300,0);
			Point3D c = new Point3D(190,200,0);
			Point3D d = new Point3D(390,400,0);
			Point3D h = new Point3D(500,600,0);
			Point3D f = new Point3D(300,550,0);
			Point3D g = new Point3D(300,450,0);
			//Point3D h = new Point3D(300,550,0);

			node_data v1 = new Node(1, a);
			node_data v2 = new Node(2, b);
			node_data v3 = new Node(3, c);
			node_data v4 = new Node(4, d);
			node_data v5 = new Node(5, h);
			node_data v6 = new Node(6, f);
			node_data v7 = new Node(7, g);
			//node_data v8 = new Node(8, h);

			graph grap = new DGraph();

			grap.addNode(v1);
			grap.addNode(v2);
			grap.addNode(v3);
			grap.addNode(v4);
			grap.addNode(v5);
			grap.addNode(v6);
			grap.addNode(v7);
			//	grap.addNode(v8);
			grap.connect(v1.getKey(), v2.getKey(), 6);
			grap.connect(v2.getKey(), v3.getKey(), 10);
			grap.connect(v3.getKey(), v4.getKey(), 9);
			grap.connect(v4.getKey(), v5.getKey(), 3);
			grap.connect(v5.getKey(), v1.getKey(), 1);
			grap.connect(v1.getKey(), v3.getKey(), 5);
			grap.connect(v3.getKey(), v5.getKey(), 6);
			grap.connect(v2.getKey(), v4.getKey(), 1);
			grap.connect(v2.getKey(), v6.getKey(), 4);
			grap.connect(v4.getKey(), v7.getKey(), 3);
			grap.connect(v7.getKey(), v6.getKey(), 1);
			grap.connect(v7.getKey(), v5.getKey(), 6);
			grap.connect(v2.getKey(), v7.getKey(), 1);
			grap.connect(v6.getKey(), v5.getKey(), 1);
			grap.connect(v4.getKey(), v6.getKey(), 3);

			Graph_GUI window = new Graph_GUI(grap);
			window.setVisible(true);
			repaint();

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
		Point3D p = new Point3D(x,y);
		points.add(p);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("mouseEntered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("mouseExited");
	}



}
