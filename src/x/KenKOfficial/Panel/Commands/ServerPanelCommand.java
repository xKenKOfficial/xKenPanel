package x.KenKOfficial.Panel.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import x.KenKOfficial.Panel.Guis.Gui;
import x.KenKOfficial.Panel.Main.Main;
import x.KenKOfficial.Panel.Utils.ChatUtil;

public class ServerPanelCommand implements CommandExecutor
{
    private static final String PREFIX = Main.getPlugin().getConfig().getString("prefix");
    private static final String NO_PERM = Main.getPlugin().getConfig().getString("brak_permisji");
    private static final String MANY_ARGS = Main.getPlugin().getConfig().getString("to_many_arguments");

    @Override
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] args) {
        if(!Sender.hasPermission("xkenpanel.admin.spanel")) {
            Sender.sendMessage(ChatUtil.fixColor(PREFIX + " " + NO_PERM));
            return false;
        }
        if(Sender instanceof Player) {
            if(args.length < 1) {
                Gui.menu((Player)Sender);
            } else {
                Sender.sendMessage(ChatUtil.fixColor(PREFIX + " " + MANY_ARGS));
            }
        } else {
            Sender.sendMessage(ChatColor.DARK_RED + "Tej komendy nie mozna uzywac w konsoli!");
        }
        return false;
    }
}
