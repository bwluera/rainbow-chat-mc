package me.ssnd.rainbowchat.utils;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import me.ssnd.rainbowchat.RainbowChat;

public class Common {
	public static void tell(CommandSender sender, String message) {
		sender.sendMessage(colorize(message));
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static void log(String message) {
		tell(Bukkit.getConsoleSender(), "[" + RainbowChat.getInstance().getName() + "] " + message);
	}

	public static void registerCommand(Command command) {
		try {
			final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			commandMapField.setAccessible(true);

			final CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
			commandMap.register(command.getLabel(), command);
		} catch (final Exception e) {
			e.printStackTrace();
			log("&4Could not register command: " + command.getName());
		}
	}
}
