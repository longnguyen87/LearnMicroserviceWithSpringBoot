package multiplication.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {
	private RabbitTemplate rabbitTemplate;
	private String multiplicationExchange;
	private String multiplicationSolvedRoutingKey;

	@Autowired
	public EventDispatcher(RabbitTemplate rabbitTemplate, String multiplicationExchange,
			String multiplicationSolvedRoutingKey) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.multiplicationExchange = multiplicationExchange;
		this.multiplicationSolvedRoutingKey = multiplicationSolvedRoutingKey;
	}

	public void send(final MultiplicationSolvedEvent multiplicationSolvedEvent) {
		rabbitTemplate.convertAndSend(multiplicationExchange, multiplicationSolvedRoutingKey,
				multiplicationSolvedEvent);
	}
}
