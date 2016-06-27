package com.benwager12.dice;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	Random r = new Random();
	
	BufferedImage one_two;
	BufferedImage three_four;
	BufferedImage five_six;
	
	BufferedImage one;
	BufferedImage two;
	BufferedImage three;
	BufferedImage four;
	BufferedImage five;
	BufferedImage six;
	
	BufferedImage first;
	BufferedImage second;
	
	public Window(String title) {
		super(title);
		setSize(new Dimension(1000, 500));
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		addKeyListener(new KeyListener(this));
		
		try {
			init();
		} catch (IOException e) {
			System.exit(0);
		}
		if (!(one_two.getWidth() == 500 && one_two.getHeight() == 1000))
			System.exit(0);
		if (!(three_four.getWidth() == 500 && three_four.getHeight() == 1000))
			System.exit(0);
		if (!(five_six.getWidth() == 500 && five_six.getHeight() == 1000))
			System.exit(0);
		rollDice();
	}

	private void getImages(Random r) {
		first = numberToImage(r.nextInt(6+1));
		second = numberToImage(r.nextInt(6+1));
	}
	
	
	private BufferedImage numberToImage(int number) {
		if (number == 1)
			return one;
		else if (number == 2)
			return two;
		else if (number == 3)
			return three;
		else if (number == 4)
			return four;
		else if (number == 5)
			return five;
		else if (number == 6)
			return six;
		else
			return null;
	}

	private void init() throws IOException {
		if (running)
			return;
		running = true;
		
		one_two = ImageIO.read(new URL("http://i.imgur.com/fbMrbc7.jpg"));
		three_four = ImageIO.read(new URL("http://i.imgur.com/GBNhUUZ.jpg"));
		five_six = ImageIO.read(new URL("http://i.imgur.com/QlShXjk.jpg"));
		
		one = one_two.getSubimage(0, 0, 500, 500);
		two = one_two.getSubimage(0, 500, 500, 500);
		three = three_four.getSubimage(0, 0, 500, 500);
		four = three_four.getSubimage(0, 500, 500, 500);
		five = five_six.getSubimage(0, 0, 500, 500);
		six = five_six.getSubimage(0, 500, 500, 500);
	}
	
	public void paint(Graphics g) {
		super.repaint();
		g.drawImage(first, 0, 25, 500, 475, null);
		g.drawImage(second, 500, 25, 500, 475, null);
	}

	public void rollDice() {
		getImages(r);
		repaint();
	}
}
