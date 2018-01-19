package ro.unitbv.eduassistant.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.fouad.jtb.core.JTelegramBot;
import ro.unitbv.eduassistant.chatbot.handler.GenericResponseHandler;

@Configuration
@ComponentScan({"ro.unitbv.eduassistant"})
public class BeanConfig {
	
	/** The Constant LOGGER. */
	public static final Logger LOGGER = LogManager.getLogger();

	private static final String API_TOKEN = "363877872:AAEGG9_770o2V7y_yVZfy2_zZjpweUp4J8Y";
	private static final String BOOT_NAME = "easyShopper_bot";

	@Autowired
	private GenericResponseHandler responseHandler;
	
	@Bean
	public JTelegramBot getTelegramBot() {
		LOGGER.info("Initilizate the chatbot with name: "+BOOT_NAME);
		JTelegramBot bot = new JTelegramBot(BOOT_NAME, API_TOKEN, responseHandler);
		return bot;
	}
}