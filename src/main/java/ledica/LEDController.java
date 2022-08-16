package ledica;

import com.pi4j.*;
import com.pi4j.io.gpio.digital.DigitalOutput;
//import com.pi4j.context
import com.pi4j.io.gpio.digital.DigitalState;

public class LEDController {

	public static void main(String[] args) throws Exception {
		System.out.println("zdravo");
		
		System.out.println(LEDController.class.getCanonicalName());
		
		var pi4j = Pi4J.newAutoContext();
		
		var ledConfig = DigitalOutput.newConfigBuilder(pi4j)
				.id("id")
				.name("ime")
				.address(1)
				.shutdown(DigitalState.LOW)
				.initial(DigitalState.HIGH);
				
		Thread.sleep(5000);
		
		System.out.println("gasim");
		
		pi4j.shutdown();
	}

}
