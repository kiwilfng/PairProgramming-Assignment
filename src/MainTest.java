import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		Main main;
		main = new Main();
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		assertEquals(292505, main.test(8500, 2100000));
		assertEquals(751850, main.test(5000000, 250000));
		assertEquals(43550, main.test(210000, 500000));
		assertEquals(0, main.test(150000, 50000));
		assertEquals(447800, main.test(2500000, 700000));
		assertEquals(0, main.test(210000, 8500));
		
	}

}
