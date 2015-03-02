package mx.x10.aschim.code.bukkit.gamerulegetter;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class GameruleGetter extends JavaPlugin {

	public Server s = getServer();
	Logger l = s.getLogger();
	
	@Override
	public void onEnable(){
		getCommand("gamerules").setExecutor(new CmdGamerules(this));
		l.info("GameruleGetter has been enabled!");
	}
	
	@Override
	public void onDisable(){
		l.info("GameruleGetter has been disabled!");
	}
}
