import static org.junit.Assert.*;
import org.junit.*;

public class SystemAcceptanceTesting {

	@Test
	public void Coordinator_SampleInput1() {
		String args[] = new String[1];
		args[0] =  "sample-inputs/sample1.txt";
		RSVPCoordinator.main(args);
	}

}
