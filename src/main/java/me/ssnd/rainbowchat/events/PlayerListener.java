package me.ssnd.rainbowchat.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.ssnd.rainbowchat.commands.RainbowCommand;
import net.md_5.bungee.api.ChatColor;

public class PlayerListener implements Listener {

	final ChatColor colors[] = {ChatColor.RED, ChatColor.GOLD,
			ChatColor.YELLOW, ChatColor.GREEN, ChatColor.BLUE,
			ChatColor.DARK_BLUE, ChatColor.DARK_PURPLE};

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		final Player player = e.getPlayer();
		final String message = e.getMessage();

		if (!RainbowCommand.toggledRainbow.contains(player.getUniqueId()))
			return;

		final char messageChars[] = message.toCharArray();
		String result = "";

		for (int x = 0; x < messageChars.length; x++)
			result = result + colors[x % 7]  + messageChars[x];

		e.setMessage(result);
	}

}
