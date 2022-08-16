package ledica;

import com.pi4j.*;
import com.pi4j.io.gpio.Gpio;
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
//				.build();
				
//		System.out.println(ledConfig);
		var ledica = pi4j.dout().create(ledConfig);
		System.out.println(ledica.getAddress());
		System.out.println(ledica.getName());
//		System.out.println(ledica.get
//		System.out.println(ledica);
		System.out.println("palim");
		ledica.state(DigitalState.HIGH);
		
//		GpioPinD
//		DigitalOutput.
//		ledConfig.	
//		ledConfig.state
		Thread.sleep(5000);
		System.out.println("gasim");
		ledica.toggle();
		Thread.sleep(2000);
		
		
		
		pi4j.shutdown();
	}

}
