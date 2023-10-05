import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class ImageConverter {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		System.out.println("Please provide a Windows File Path for the file you wish to convert Below:");
		
		String in = input.next();
		in = stripQuotations(in);
		//As ImageIO cannot accept the quotations around file paths, we need to strip those

		BufferedImage pic = null;
		pic = readFile(pic, in);
		writeFile(pic, in);
		openFile(pic);
	}

	public static BufferedImage readFile(BufferedImage image, String systemInput) {
		try {
			File sampleFile = new File(systemInput);
			image = ImageIO.read(sampleFile);
			System.out.println("Reading Complete: " + image);
		} catch(IOException ex) {
			System.out.println("Error: " + ex);
		}
		return image;
	}

	public static void writeFile(BufferedImage image, String systemInput) {
		System.out.println("Please select output location: ");
		
		String fileLocation = input.next(); //output location
		fileLocation = stripQuotations(fileLocation);
		System.out.println(fileLocation);
		String[] findingType = systemInput.split("\\.");
		
		System.out.println("Please input an image type to convert to: ");
		String option = input.next();
		
		
		try {
			File output = new File(fileLocation + "\\" + "OpeningImageOutput." + option);
			ImageIO.write(image, findingType[findingType.length-1], output);
			System.out.println("Writing Completed.");
		} catch(IOException ex) {
			System.out.println("Error: " + ex);
		}
	}

	public static void openFile(BufferedImage pic) {
		JFrame open = new JFrame("OpeningImage");
		open.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ImageIcon imageicon = new ImageIcon(pic);
		JLabel jLabel = new JLabel();
		jLabel.setIcon(imageicon);

		open.getContentPane().add(jLabel, BorderLayout.CENTER);
		Dimension size = new Dimension(imageicon.getIconWidth(), imageicon.getIconHeight());

		open.setSize(size);
		open.pack();
		open.setLocationRelativeTo(null);
		open.setVisible(true);

		System.out.println("Width: " + imageicon.getIconWidth());
		System.out.println("Height: " + imageicon.getIconHeight());
	}

	public static String stripQuotations(String in) {
		if(in.charAt(0) == '\"') {
			in = in.substring(1,in.length()-1);
		}
		return in;
	}
}
