package guru.sfg.beer.inventory.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

public class JmsConfig
{
	public static final String NEW_INVENTORY_QUEUE = "new-inventory";
	@Bean
	public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper)
	{
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setObjectMapper(objectMapper);
		converter.setTypeIdPropertyName("_type");

		return converter;
	}
}
