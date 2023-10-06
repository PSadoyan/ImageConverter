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

/**
 * ImageConverter is a simple Java program that allows you to read an image file,
 * convert it to a different format, and display it in a JFrame.
 */
public class ImageConverter {
	
	/**
	 * A scanner that takes in relevant filepath and output information.
	 */
	static Scanner input = new Scanner(System.in);

	/**
     * The main method of the ImageConverter program.
	 * Takes in a Windows file path, reads it as an image,
	 * writes it as a new image with the desired output image type,
	 * and opens the file.
     *
     * @param args Command-line arguments (replaced functionally by System.in).
     * @throws Exception If an error occurs during execution.
     */
	public static void main(String[] args) throws Exception {
		System.out.println("Please provide a Windows File Path for the file you wish to convert below:");
		
		String in = input.next();
		in = stripQuotations(in);
		//As ImageIO cannot accept the quotations around file paths, we need to strip those

		BufferedImage pic = null;
		pic = readFile(pic, in);
		writeFile(pic, in);
		openFile(pic);
	}

	 /**
     * Reads an image file and returns it as a BufferedImage.
     *
     * @param image The BufferedImage to read the image into.
     * @param systemInput The file path of the image to be read.
     * @return The BufferedImage containing the image data.
     */
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

	/**
     * Writes a BufferedImage to an output file in the specified image format.
     *
     * @param image The BufferedImage to be saved.
     * @param systemInput The file path of the input image (used to determine the output file type).
     */
	public static void writeFile(BufferedImage image, String systemInput) {
		System.out.println("Please select output location: ");
		
		String fileLocation = input.next(); //output location
		fileLocation = stripQuotations(fileLocation);
		System.out.println(fileLocation);
		String[] findingType = systemInput.split("\\.");
		
		System.out.println("Please input an image type to convert to: ");
		String option = input.next();
		
		try {
			File output = new File(fileLocation + "\\" + "ImageConverterOutput." + option);
			ImageIO.write(image, findingType[findingType.length-1], output);
			System.out.println("Writing Completed.");
		} catch(IOException ex) {
			System.out.println("Error: " + ex);
		}
	}

	/**
     * Opens the converted image in a JFrame for display.
	 * 
     * The original point of this project was to open an image using java code, 
	 * which is why I kept this function, though it is unnecessary.
	 * 
     * @param pic The BufferedImage to be displayed.
     */
	public static void openFile(BufferedImage pic) {
		JFrame open = new JFrame("OpeningImage"); //creates new JFrame to dispaly image
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

	 /**
     * Strips quotation marks from the provided string. 
     *
     * @param in The input string that may have leading and trailing quotation marks.
     * @return The input string with leading and trailing quotation marks removed.
     */
	public static String stripQuotations(String in) {
		if(in.charAt(0) == '\"') {
			in = in.substring(1,in.length()-1); //removes quotations from first index and last.
		}
		return in;
	}
}
