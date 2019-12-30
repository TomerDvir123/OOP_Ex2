
package utils;

import dataStructure.*;
import algorithms.*;
import Tests.*;
import utils.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.StdDraw;

public class Window extends JFrame implements ActionListener, MouseListener,Serializable
{
	private static JFrame frame;
	graph grap;	
	LinkedList<Point3D> points = new LinkedList<Point3D>();
	ArrayList<node_data> SP= new ArrayList<node_data>();
	public Window()
	{
		initGUI();
	}
	public Window(graph g )
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



		MenuItem item1 = new MenuItem("Init graph");
		item1.addActionListener(this);

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
		item5.addActionListener(this);


		menu.add(item1);
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		if(str.equals("TSP"))
		{
			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);
			JFrame jinput = new JFrame();
			String start = JOptionPane.showInputDialog(jinput,"Start point");
			String finish = JOptionPane.showInputDialog(jinput,"Finish point");
			try
			{
				int src = Integer.parseInt(start);
				int des = Integer.parseInt(finish);
				double x = temp.shortestPathDist(src, des);
				JOptionPane.showMessageDialog(jinput, "The shortest distance is: " + x);
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			repaint();
		}


		//"Shortest path dist"
		if(str.equals("Shortest path dist"))
		{
			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);
			JFrame jinput = new JFrame();
			String start = JOptionPane.showInputDialog(jinput,"Start point");
			String finish = JOptionPane.showInputDialog(jinput,"Finish point");
			try
			{
				int src = Integer.parseInt(start);
				int des = Integer.parseInt(finish);
				double x = temp.shortestPathDist(src, des);
				JOptionPane.showMessageDialog(jinput, "The shortest distance is: " + x);
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}

			repaint();
		}
		
		//"Shortest path"
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
			for (int i = nodes.size()-1; i >= 0; i--) {
				SP.add(nodes.get(i));
			}

			for (int i = 0; i < SP.size()-1; i++) {
				this.grap.getEdge(SP.get(i).getKey(), SP.get(i+1).getKey()).setTag(2);
			}
			repaint();
		}

		//"Is connected"
		if(str.equals("Is connected"))
		{
			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);
			boolean ans = temp.isConnected();
			JFrame jinput = new JFrame();
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
		
		//save
		if(str.equals("save"))
		{
			Graph_Algo temp = new Graph_Algo();
			temp.init(grap);

			FileDialog chooser = new FileDialog(Window.frame, "Use a .png or .jpg extension", FileDialog.SAVE);
			chooser.setVisible(true);
			String filename = chooser.getFile();
			if (filename != null) 
			{
				temp.save(chooser.getDirectory()+filename+".txt");
			}
		}
		
		//load
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
			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile = fileChooser.getSelectedFile();

				temp.init(selectedFile.getPath());
				grap = temp.copy();

				repaint();
			}
			frame.pack();;
		}
		if(str.equals("test1"))
		{		
			Point3D p1 = new Point3D(100,100);
			Point3D p2 = new Point3D(50,300);
			Point3D p3 = new Point3D(400,150);
			Point3D p4 = new Point3D(600,200);

			points.add(p1);
			points.add(p2);
			points.add(p3);
			points.add(p4);

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
		//repaint();
		//System.out.println("mousePressed");

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
