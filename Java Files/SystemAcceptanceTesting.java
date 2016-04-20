import static org.junit.Assert.*;
import org.junit.*;

public class SystemAcceptanceTesting {

	@Test
	public void Coordinator_SampleInput1() {
		String args[] = new String[1];
		args[0] =  "sample-inputs/hotel_california.txt";
		try {
			RSVPCoordinator.main(args);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

}
