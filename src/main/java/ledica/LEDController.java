package ledica;

import java.util.ServiceLoader;

import com.pi4j.*;
import com.pi4j.context.Context;
import com.pi4j.extension.Plugin;
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
