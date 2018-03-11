package qn.projectredstone.lang.event;

import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public interface EventLocation {

	Location<World> getEventLocation();
}
