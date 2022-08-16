package ledica;

import com.pi4j.*;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.Gpio;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalOutputProvider;
import com.pi4j.io.gpio.digital.DigitalOutputProviderBase;
//import com.pi4j.context
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.platform.Platforms;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutput;
import com.pi4j.provider.Provider;
import com.pi4j.provider.Providers;
import com.pi4j.util.Console;

public class LEDController {

	public static void main(String[] args) throws Exception {
		
		Console konzola = new Console();
		
		var pi = Pi4J.newAutoContext();
		
		Platforms platforma = pi.platforms();
		
//		pi.provid
		
		konzola.box("Pi platforma:");
		platforma.describe().print(System.out);
		System.out.println(pi.providers());
		var ledConfig = DigitalOutput.newConfigBuilder(pi)
			      .id("led")
			      .name("LED Flasher")
			      .address(18	)
			      .shutdown(DigitalState.LOW)
			      .initial(DigitalState.LOW)
			      .provider("pigpio-digital-output");
			      
			var led = pi.create(ledConfig);
			
			
		for (int i = 1; i <= 5; i++) {
			led.toggle();
			konzola.println();
			konzola.println("menjam stanje");
			konzola.println(led.state());
			konzola.println();
			Thread.sleep(3000);
		}
		
		pi.shutdown();
		
	}

}
