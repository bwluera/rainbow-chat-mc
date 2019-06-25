package me.ssnd.rainbowchat;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.ssnd.rainbowchat.commands.RainbowCommand;
import me.ssnd.rainbowchat.events.PlayerListener;
import me.ssnd.rainbowchat.utils.Common;

public class RainbowChat extends JavaPlugin {

	public static final String prefix = "&f[&cR&6a&ei&an&9b&1o&5w&cC&6h&ea&at&f] &r";
	private static RainbowChat instance;

	@Override
	public void onEnable() {
		instance = this;


		registerEvents(new PlayerListener());

		Common.registerCommand(new RainbowCommand());

		Common.log("Initialized RainbowChat!");
	}

	@Override
	public void onDisable() {

	}

	private void registerEvents(Listener... listeners) {
		final PluginManager pm = getServer().getPluginManager();

		for (final Listener lis : listeners)
			pm.registerEvents(lis, this);
	}

	public static RainbowChat getInstance() {
		return instance;
	}
}
