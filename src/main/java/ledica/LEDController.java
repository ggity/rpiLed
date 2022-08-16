package ledica;

import com.pi4j.*;
import com.pi4j.io.gpio.Gpio;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputProvider;
//import com.pi4j.context
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutput;
import com.pi4j.provider.Provider;
import com.pi4j.provider.Providers;
import com.pi4j.util.Console;

public class LEDController {

	public static void main(String[] args) throws Exception {
		System.out.println("zdravo");
		
		
		
		System.out.println(LEDController.class.getCanonicalName());
		
		var pi4j = Pi4J.newAutoContext();
		Console konzola = new Console();
		System.out.println(pi4j.getDigitalOutputProvider().description()	);
		
		System.out.println(pi4j.providers());
		
		var ledConfig = DigitalOutput.newConfigBuilder(pi4j)
				.id("id")
				.name("ime")
				.address(12)
				.shutdown(DigitalState.LOW)
				.initial(DigitalState.HIGH);	
//				.build();
				
//		PiGpioDigitalOutput ledara = new PiGpioDigitalOutput(18, , "faf");
		konzola.println("blebe");
//		System.out.println(ledConfig);
		var ledica = pi4j.dout().create(ledConfig);
		konzola.println(ledica.state());
		System.out.println(ledica.provider());
		System.out.println(ledica.getAddress());
		System.out.println(ledica.getName());
//		System.out.println(ledica.get
//		System.out.println(ledica);
		System.out.println("palim");
		ledica.state(DigitalState.HIGH);
//		PiGpioDigitalOutput ledara = new PiGpioDigitalOutput(18, , null)
		System.out.println();
//		PiGpioDigitalOutput ledara = new PiGpioDigitalOutput(18, ledica.provider(), ledConfig);
//		GpioFa
//		PiGpioDigitalOutput d = new 
			
		
//		GpioPinD
//		DigitalOutput.
//		ledConfig.	
//		ledConfig.state
		Thread.sleep(5000);
		System.out.println("gasim");
		ledica.toggle();
		konzola.println(ledica.state());	
		konzola.println(ledica.provider());
//		PiGpioDigitalOutput dout 
//		DigitalOutput at = new PiGpioDigitalOutput( , null, null)
		Thread.sleep(2000);
		
		
		
		pi4j.shutdown();
	}

}
