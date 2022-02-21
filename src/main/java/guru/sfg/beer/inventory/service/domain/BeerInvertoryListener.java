package guru.sfg.beer.inventory.service.domain;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class BeerInvertoryListener
{
	@PostUpdate
	@PostPersist
	public void printListenerInfo(BeerInventory beerInventory)
	{
		System.out.println("LISTENER FIRED");
	}
}
