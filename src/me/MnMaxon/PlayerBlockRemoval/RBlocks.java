package me.MnMaxon.PlayerBlockRemoval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class RBlocks {
	private static Map<Player, ArrayList<Block>> pBlocks = new HashMap<Player, ArrayList<Block>>();

	public static void add(Player p, Block b) {
		ArrayList<Block> blocks = null;
		if (pBlocks.containsKey(p))
			blocks = pBlocks.get(p);
		if (blocks == null)
			blocks = new ArrayList<Block>();
		blocks.add(b);
		pBlocks.remove(p);
		pBlocks.put(p, blocks);
	}

	public static void remove(Player p) {
		if (pBlocks.containsKey(p) && pBlocks.get(p) != null)
			for (Block b : pBlocks.get(p))
				if (b != null && b.getLocation().getBlock().equals(b))
					b.setType(Material.AIR);
		if (pBlocks.containsKey(p))
			pBlocks.remove(p);
	}
}
