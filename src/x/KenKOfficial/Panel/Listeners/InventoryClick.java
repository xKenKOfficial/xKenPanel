package x.KenKOfficial.Panel.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import x.KenKOfficial.Panel.Main.Main;
import x.KenKOfficial.Panel.Utils.ChatUtil;

import java.util.Collection;

public class InventoryClick implements Listener
{
    private static final String GUI_NAME = Main.getPlugin().getConfig().getString("gui_name");

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player clicker = (Player)e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatUtil.fixColor(GUI_NAME))) {
            e.setCancelled(true);
            if(e.getSlot() == 10) {
                clicker.closeInventory();
                final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
                final StringBuilder onlines = new StringBuilder();
                for (final Player p : players) {
                    if (clicker instanceof Player && !((Player)clicker).canSee(p)) {
                        continue;
                    }
                    if (onlines.length() > 0) {
                        onlines.append(ChatUtil.fixColor("&8, &c"));
                    }
                    onlines.append(p.getDisplayName());
                }
                clicker.sendMessage(ChatUtil.fixColor("&8&l>> &7Graczy online&8: &e" + players.size() + "&8/&c" + Bukkit.getMaxPlayers()));
                clicker.sendMessage(ChatUtil.fixColor("&8&l>> &c" + onlines.toString()));
            }
            if(e.getSlot() == 11) {
                clicker.closeInventory();
                for(final Player online : Bukkit.getOnlinePlayers()) {
                    online.setHealth(0.0);
                    online.sendMessage(ChatUtil.fixColor("&8>> &7Zostales zabity z niewyjasnionej przyczyny!"));
                }
            }
            if(e.getSlot() == 12) {
                clicker.closeInventory();
                for(final Player online : Bukkit.getOnlinePlayers()) {
                    online.kickPlayer(ChatUtil.fixColor("&8>> &7Zostales wyrzucony z serwera!"));
                }
            }
            if(e.getSlot() == 13) {
                clicker.closeInventory();
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "whitelist on");
            }
            if(e.getSlot() == 14) {
                clicker.closeInventory();
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "whitelist off");
            }
            if(e.getSlot() == 15) {
                clicker.closeInventory();
                Bukkit.shutdown();
            }
            if(e.getSlot() == 16) {
                clicker.closeInventory();
                Bukkit.reload();
            }
            if(e.getSlot() == 22) {
                clicker.closeInventory();
                clicker.sendMessage(ChatUtil.fixColor(listaPluginow()));
            }
            if(e.getSlot() == 34) {
                clicker.closeInventory();
            }
        }
    }

    private String listaPluginow() {
        final StringBuilder pluginList = new StringBuilder();
        final Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        Plugin[] array;
        for (int length = (array = plugins).length, i = 0; i < length; ++i) {
            final Plugin plugin = array[i];
            if (pluginList.length() > 0) {
                pluginList.append(ChatColor.GRAY);
                pluginList.append(", ");
            }
            pluginList.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED);
            pluginList.append(plugin.getDescription().getName());
        }
        return "&8>> &8(&e" + plugins.length + "&8) >> " + pluginList.toString();
    }
}
