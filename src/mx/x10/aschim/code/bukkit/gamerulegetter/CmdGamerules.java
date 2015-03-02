package mx.x10.aschim.code.bukkit.gamerulegetter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdGamerules implements CommandExecutor{

	public static GameruleGetter plugin;
	
	public CmdGamerules(GameruleGetter instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gamerules")){
			if (p instanceof Player){
				p = (Player) p;
				if (p.hasPermission("gr.nocommand")){
					p.sendMessage("You don't have permission to view gamerules.");
					return true;
				}
				if (args.length == 0){
					p.sendMessage("GameruleGetter v1.0");
					p.sendMessage("-------------------");
					p.sendMessage("Usage: "+cmd.getUsage());
					String[] grs = ((Player) p).getWorld().getGameRules();
					String str = "";
					for (String s : grs){
						str += ", "+s;
					}
					p.sendMessage(str.replaceFirst(", ", ""));
				} else if (args.length == 1){
					for (String s : ((Player) p).getWorld().getGameRules()){
						if (s.equalsIgnoreCase(args[0])){
							p.sendMessage(s+" = "+((Player) p).getWorld().getGameRuleValue(s).toString());
							return true;
						}
					}
					p.sendMessage("Gamerule \""+args[0]+"\" not found!");
					return true;
				} else{
					p.sendMessage("Usage: "+cmd.getUsage());
					return true;
				}
				return true;
			} else{
				plugin.s.dispatchCommand(plugin.s.getConsoleSender(), "gamerule" + ((args.length == 1) ? " "+args[0] : ""));
				return true;
			}
		}
		return false;
	}

}
