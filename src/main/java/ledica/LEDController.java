package ledica;


import com.pi4j.*;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.platform.Platforms;
import com.pi4j.util.Console;

public class LEDController {

	public static void main(String[] args) throws Exception {
		
		Console console = new Console();
		
		var pi4j = Pi4J.newAutoContext();
		
		pi4j.providers().describe().print(System.out);
		
		Platforms platforms = pi4j.platforms();

		console.box("Pi4J PLATFORMS");
		console.println();
		platforms.describe().print(System.out);
		console.println();
		
		final int PIN_LED = 18; // PIN 15 = BCM 22

		var ledConfig = DigitalOutput.newConfigBuilder(pi4j)
		      .id("led")
		      .name("LED Flasher")
		      .address(PIN_LED)
		      .shutdown(DigitalState.LOW)
		      .initial(DigitalState.LOW)
		      .provider("pigpio-digital-output");
		      
		var led = pi4j.create(ledConfig);

		for (int i = 1; i <= 5; i++) {
			console.box("Changing led state");
			led.toggle();
			console.println(led.state());
			Thread.sleep(3000);
		}
		
		pi4j.shutdown();
		
	}

}
