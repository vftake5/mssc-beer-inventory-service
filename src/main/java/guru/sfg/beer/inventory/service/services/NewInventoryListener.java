package guru.sfg.beer.inventory.service.services;

import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import hu.vf.guru.msscbeercommon.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static guru.sfg.beer.inventory.service.config.JmsConfig.NEW_INVENTORY_QUEUE;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener
{
	private final BeerInventoryRepository beerInventoryRepository;

	@JmsListener(destination = NEW_INVENTORY_QUEUE)
	public void listen(NewInventoryEvent event)
	{
		log.debug("Got invemtory: " + event.toString());

		beerInventoryRepository.save(BeerInventory.builder()
				.beerId(event.getBeerDto().getId())
				.upc(event.getBeerDto().getUpc())
				.quantityOnHand(event.getBeerDto().getQuantityOnHand())
			.build());
	}
}
