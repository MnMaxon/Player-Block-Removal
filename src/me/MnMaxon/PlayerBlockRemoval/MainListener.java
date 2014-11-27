package me.MnMaxon.PlayerBlockRemoval;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class MainListener implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void onTeleport(PlayerTeleportEvent e) {
		if (!e.isCancelled() && !e.getTo().getWorld().equals(e.getFrom().getWorld()))
			RBlocks.remove(e.getPlayer());
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlace(BlockPlaceEvent e) {
		if (!e.isCancelled() && !e.getPlayer().hasPermission("playerRemoval.exempt"))
			RBlocks.add(e.getPlayer(), e.getBlock());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (!e.getPlayer().hasPermission("playerRemoval.exempt"))
			RBlocks.remove(e.getPlayer());
	}
}
