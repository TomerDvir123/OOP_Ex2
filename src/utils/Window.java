package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class Window extends JFrame implements ActionListener, MouseListener
{
	graph grap;
	graph_algorithms temp;
	LinkedList<Point3D> points = new LinkedList<Point3D>();

	public Window()
	{
		initGUI();
	}

	private void initGUI() 
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("Item 1");
		item1.addActionListener(this);

		MenuItem item2 = new MenuItem("Item 2");
		item2.addActionListener(this);

		MenuItem item3 = new MenuItem("save");
		item2.addActionListener(this);

		MenuItem item4 = new MenuItem("load");
		item2.addActionListener(this);

		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);

		this.addMouseListener(this);
	}

	//	public void print(Graph_Algo g) {
	//		
	//		Collection<node_data> temp = this.grap.getV();
	//		for (node_data nd : temp) {
	//			
	//		}
	//
	//	}
	public Window(graph g) {
		this.grap = g;
		temp = new Graph_Algo();
		this.temp.init(g);
		initGUI();
	}
	public void paint(Graphics g)
	{
//		Collection<node_data> temp = this.grap.getV();
//		super.paint(g);
//		Point3D prev = null;
//		for (node_data p : temp) 
//		{
//			g.fillOval((int)p.getLocation().ix(), (int)p.getLocation().iy(), 10, 10);
//			g. setColor(Color.BLUE);
			//			int src = p.getKey();
			//			Collection<edge_data> coledg = this.grap.getE(src);
			//			for (edge_data ed : coledg)
			//			{
			//				
			//			}
			//			
			//
			//			if(prev != null)
			//			{
			//				g.setColor(Color.RED);
			//				g.drawLine((int)p.x(), (int)p.y(), 
			//						(int)prev.x(), (int)prev.y());
			//
			//				g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
			//			}

			//	prev = p;
		//}
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.equals("Item 1"))
		{
			Point3D p1 = new Point3D(100,100);
			Point3D p2 = new Point3D(50,300);
			Point3D p3 = new Point3D(400,150);

			points.add(p1);
			points.add(p2);
			points.add(p3);

			repaint();
		}
		if (str.equals("save")) 
		{

		}

	}
	//	private static BufferedImage offscreenImage, onscreenImage;
	//	public static void save(String filename) {
	//		if (filename == null) throw new IllegalArgumentException();
	//		File file = new File(filename);
	//		String suffix = filename.substring(filename.lastIndexOf('.') + 1);
	//
	//		// png files
	//		if ("png".equalsIgnoreCase(suffix)) {
	//			try {
	//				ImageIO.write(onscreenImage, suffix, file);
	//			}
	//			catch (IOException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//
	//		// need to change from ARGB to RGB for JPEG
	//		// reference: http://archives.java.sun.com/cgi-bin/wa?A2=ind0404&L=java2d-interest&D=0&P=2727
	//		else if ("jpg".equalsIgnoreCase(suffix)) {
	//			WritableRaster raster = onscreenImage.getRaster();
	//			WritableRaster newRaster;
	//			newRaster = raster.createWritableChild(0, 0, 5,5, 0, 0, new int[] {0, 1, 2});
	//			DirectColorModel cm = (DirectColorModel) onscreenImage.getColorModel();
	//			DirectColorModel newCM = new DirectColorModel(cm.getPixelSize(),
	//					cm.getRedMask(),
	//					cm.getGreenMask(),
	//					cm.getBlueMask());
	//			BufferedImage rgbBuffer = new BufferedImage(newCM, newRaster, false,  null);
	//			try {
	//				ImageIO.write(rgbBuffer, suffix, file);
	//			}
	//			catch (IOException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//
	//		else {
	//			System.out.println("Invalid image file type: " + suffix);
	//		}
	//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point3D p = new Point3D(x,y);
		points.add(p);
		repaint();
		System.out.println("mousePressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
}
