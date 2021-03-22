package de.xxschrandxx.sss.bukkit.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import de.xxschrandxx.sss.bukkit.ServerStatusSign;
import de.xxschrandxx.sss.bukkit.api.*;

public class CMDConfig {

  public static boolean run(CommandSender sender, Command command, String alias, String[] args) {
    if (ServerStatusSign.getPermissionHandler().hasPermission(sender, "permission.command.config")) {
      if (args.length != 1) {
        if (args[1].equalsIgnoreCase("load")) {
          if (args.length != 2) {
            if (args[2].equalsIgnoreCase("config")) {
              Storage.config.reload();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.load")).replace("%config%", "Config"));
              return true;
            }
            if (args[2].equalsIgnoreCase("message")) {
              Storage.message.reload();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.load")).replace("%config%", "Message"));
              return true;
            }
            if (args[2].equalsIgnoreCase("signs")) {
              API.loadServerStatusSign();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.load")).replace("%config%", "Signs"));
              return true;
            }
            if (args[2].equalsIgnoreCase("all")) {
              Storage.config.reload();
              Storage.message.reload();
              API.loadServerStatusSign();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.load")).replace("%config%", "All"));
              return true;
            }
          }
        }
        if (args[1].equalsIgnoreCase("save")) {
          if (args.length != 2) {
            if (args[2].equalsIgnoreCase("config")) {
              Storage.config.save();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.save")).replace("%config%", "Config"));
              return true;
            }
            if (args[2].equalsIgnoreCase("message")) {
              Storage.message.save();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.save")).replace("%config%", "Message"));
              return true;
            }
            if (args[2].equalsIgnoreCase("signs")) {
              API.saveServerStatusSign();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.save")).replace("%config%", "Signs"));
              return true;
            }
            if (args[2].equalsIgnoreCase("all")) {
              Storage.config.save();
              Storage.message.save();
              API.saveServerStatusSign();
              ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.success").replace("%do%", Storage.message.get().getString("command.config.save")).replace("%config%", "All"));
              return true;
            }
          }
        }
      }
      ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.config.usage"));
      return true;
    }
    else {
      ServerStatusSign.getCommandSenderHandler().sendMessage(sender, Storage.message.get().getString("command.nopermission").replace("%permission%", Storage.config.get().getString("permission.command.config")));
      return true;
    }
  }

  public static List<String> list(CommandSender sender, Command command, String alias, String[] args) {
    List<String> list = new ArrayList<String>();
    if (ServerStatusSign.getPermissionHandler().hasPermission(sender, "permission.command.config")) {
      if (args.length == 1) {
        list.add("config");
      }
      if ((args.length == 2) && args[0].equalsIgnoreCase("config")) {
        list.add("load");
        list.add("save");
      }
      if ((args.length == 3) && (args[1].equalsIgnoreCase("load") || args[1].equalsIgnoreCase("save"))) {
        list.add("config");
        list.add("message");
        list.add("signs");
        list.add("all");
      }
    }
    return list;
  }

}
