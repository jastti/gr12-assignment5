
/**
 * @author Jasmine Tian
 * Due Date: May 6, 2021
 * ICS4U
 * Ms. Wong
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Problem3 implements ActionListener {

	JFrame frame;
	JLabel label, playLabel, cardDisplay;
	JButton play, exit;
	JTextField text;
	boolean showed = false;
	int lastNum = 0;

	ImageIcon[] images; 
	// An array of 25 images
	ImageIcon[] imagesTo; 
	// An array of 25 images to adjust the size
	JLabel[] lableName;

	public Problem3() {
		frame = new JFrame("Arrage the Order of Cards GAME!");
		frame.setBounds(0, 0, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// set the frame
		
		label = new JLabel("Enter the size of the cards(max 25): ");
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		label.setFont(new Font("SimSun", Font.PLAIN, 16));
		label.setBounds(900, 50, 300, 15);
		playLabel = new JLabel("");
		playLabel.setBounds(50, 400, 650, 50);
		playLabel.setFont(new Font("", Font.PLAIN, 14));
		playLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		// set the label

		text = new JTextField();
		text.setBounds(900, 80, 135, 30);
		text.setFont(new Font("SimSun", Font.PLAIN, 16));
		// set the text
		
		play = new JButton("Play");
		play.setActionCommand("Play");
		play.setBounds(300, 600, 200, 40);
		play.setFont(new Font("SimSun", Font.PLAIN, 16));
		play.addActionListener(this);
		exit = new JButton("Exit");
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		exit.setBounds(650, 600, 200, 40);
		exit.setFont(new Font("SimSun", Font.PLAIN, 16));
		// set the play button and exit button

		frame.add(label);
		frame.add(play);
		frame.add(exit);
		frame.add(text);
		frame.add(playLabel);
		// add these components onto frame

		images = new ImageIcon[25];
		imagesTo = new ImageIcon[25];
		// create the array to save the original cards and resized images

		lableName = new JLabel[25];
		// create the Label to take the images.

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// set the frame is visible

	}

	public int[] resizeIcons(ImageIcon[] images, JLabel[] lableName) {
		// size of the pics
		int i = 0;
		int imgWidth = images[i].getIconWidth();
		int imgHeight = images[i].getIconHeight();
		int conWidth = lableName[i].getWidth();
		int conHeight = lableName[i].getHeight();

		int reImgWidth;
		int reImgHeight;
		if (imgWidth / imgHeight >= conWidth / conHeight) {
			if (imgWidth > conWidth) {
				reImgWidth = conWidth;
				reImgHeight = imgHeight * reImgWidth / imgWidth;
			} else {
				reImgWidth = imgWidth;
				reImgHeight = imgHeight;
			}
		} else {
			if (imgWidth > conWidth) {
				reImgHeight = conHeight;
				reImgWidth = imgWidth * reImgHeight / imgHeight;
				// resize the pics
			} else {
				reImgWidth = imgWidth;
				reImgHeight = imgHeight;
			}
		}
		int[] reImg = { reImgWidth, reImgHeight };
		return reImg;
		// resize the image in the array, and save in the new image array

	}

	public void IconChoose(LinkedList<Integer> display) {
		Iterator<Integer> itr = display.iterator();
		int i = 0;

		if (showed) {
			try {
				while (lastNum > 0) {
					// while the last number is bigger than 0
					lastNum--;
					lableName[lastNum].setIcon(null);
					// lastNum minus 1 and set the icon as null
				}
				cardDisplay.setText(null);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			cardDisplay = new JLabel();
			cardDisplay.setBounds(40, 700, 1200, 30);
			frame.add(cardDisplay);
			// add cardDisplay to the frame
		}

		while (itr.hasNext()) {
			int imgNum = itr.next();
			String imgFileName;
			imgFileName = (imgNum) + ".gif";
			// get the file name through the number of image that is going to display
			images[i] = new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage(imgFileName));
			// get the pics on the right position of the screen

			lableName[i] = new JLabel("");
			lableName[i].setBounds(15 + (i) * 48, 15 + (i) * 20, 80, 70);
			// set the location of the display label
			imagesTo[i] = new ImageIcon(images[i].getImage().getScaledInstance(lableName[i].getWidth(),
					lableName[i].getHeight() - 25, Image.SCALE_DEFAULT));
			// set the size of the images have the same size by scale

			frame.add(lableName[i]);
			lableName[i].setIcon(imagesTo[i]);
			i++;
			// once finish a round of the loop, i++ and do the loop again to add all the cards' images
		}

		showed = true;
		lastNum = display.size();
		// set the value of lastNum as the size of the LinkedList

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		// get action command
		if (eventName.equals("Play")) {
			// if the event name is "Play"
			String input = "";
			int num = 0;
			System.out.println("Enter the size of the cards(max 25): ");
			// initialize input string and num, print the notice to let the user input
			LinkedList<Integer> sortedList = new LinkedList<Integer>();
			
			while (true) {
				try {
					input = text.getText();
					// get the text and save as input string 
					if (input != null) {
						num = Integer.valueOf(input);
						// if input isn't null, convert the input string into num in integer
					}

					if (num < 1 || num > 25) {
						System.out.println("This number is out of bound! Max number should be 25 cards");
						JOptionPane.showMessageDialog(frame,
								(Object) "This number is out of bound! Max number should be 25 cards", "Play",
								JOptionPane.INFORMATION_MESSAGE);
						// if the num input is informal, show the notice
					} else {
						Cards cards = new Cards(num);
						// create an instance of class Cards
						sortedList = cards.order();
						cards.printOrder();
						// call methods: order(), printOrder() from the instance cards
					}
					IconChoose(sortedList);
					// choose the icon from sortedList
					break;

				} catch (Exception e) {
					System.out.println("Please enter an Integer (max 25): ");
					text.getAction();
					JOptionPane.showMessageDialog(frame,
							(Object) "Please enter an integer between 1 and 25 (included)!", "Play",
							JOptionPane.INFORMATION_MESSAGE);
					// if the number input is informal, show the notice of re-input
					break;
				}
			}
			playLabel.setText("The order is: " + sortedList.toString());
			// show the order of the cards onto the frame
			
		} else if (eventName.equals("Exit")) {
			System.exit(0);
			// if the event name is "Exit", exit the application
		}

	}

	public static void main(String[] args) {
		new Problem3();
	}

}
