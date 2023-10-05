import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ImageConverterTest {
		String input = "\"C:\\Users\\pavel\\OneDrive\\Pictures\\out.png\"";
		String output = "\"C:\\Users\\pavel\\OneDrive\\Pictures\"";
		
	@Before
	public void setUp() throws Exception {
		;
	}
		
	@Test
	public void testReadFile() {
		
	}

	@Test
	public void testStripQuotations() {
		String test = "C:\\Users\\pavel\\OneDrive\\Pictures\\";
		assertEquals("C:\\Users\\pavel\\OneDrive\\Pictures", ImageConverter.stripQuotations(output));
		assertEquals("C:\\Users\\pavel\\OneDrive\\Pictures\\", ImageConverter.stripQuotations(test));
		assertEquals("C:\\Users\\pavel\\OneDrive\\Pictures\\out.png", ImageConverter.stripQuotations(input));
	}

}
