package me.ssnd.rainbowchat.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.ssnd.rainbowchat.RainbowChat;
import me.ssnd.rainbowchat.utils.Common;

public class RainbowCommand extends PlayerCommand {

	public static List<UUID> toggledRainbow = new ArrayList<>();

	public RainbowCommand() {
		super("rainbowchat");

		this.setAliases(Arrays.asList("rainbowtoggle", "togglerainbow"));
	}

	@Override
	protected void run(Player sender, String[] args) {
		if (!sender.hasPermission("rainbowchat.rainbow")) {
			Common.tell(sender, RainbowChat.prefix + "&cYou do not have access to that command!");
			return;
		}

		final UUID senderUUID = sender.getUniqueId();

		if (toggledRainbow.contains(senderUUID)) {
			toggledRainbow.remove(senderUUID);
			Common.tell(sender, RainbowChat.prefix + "&7You've disabled &cr&6a&ei&an&9b&1o&5w&7 messages!");
		}
		else {
			toggledRainbow.add(senderUUID);
			Common.tell(sender, RainbowChat.prefix + "&7You've enabled &cr&6a&ei&an&9b&1o&5w&7 messages!");
		}
	}

}
