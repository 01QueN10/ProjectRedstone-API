package qn.projectredstone.api.event;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import qn.projectredstone.lang.Event;
import qn.projectredstone.lang.event.EventItem;
import qn.projectredstone.lang.event.EventPlayer;

public class OnRightClick implements Event, EventPlayer, EventItem {

	private InteractItemEvent.Secondary event;

	@Listener
	public void onRightClick(InteractItemEvent.Secondary event) {
		this.event = event;
	}

	@Override
	public Player getEventPlayer() {
		return (Player) event.getSource();
	}

	@Override
	public org.spongepowered.api.event.Event getEvent() {
		return event;
	}

	@Override
	public ItemStack getEventItem() {
		return event.getItemStack().createStack();
	}
}
