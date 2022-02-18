package x.KenKOfficial.Panel.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import x.KenKOfficial.Panel.Main.Main;
import x.KenKOfficial.Panel.Utils.ChatUtil;

public class PlayerJoin implements Listener
{
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if(Main.getPlugin().getConfig().getBoolean("plugin_info")) {
            if(p.hasPermission("xkenpanel.admin.plugin")) {
                p.sendMessage(ChatUtil.fixColor("&8&l==========[&3&lxKenPanel&8&l]=========="));
                p.sendMessage(ChatUtil.fixColor(""));
                p.sendMessage(ChatUtil.fixColor(" &7Wersja&8: &b1.0-Beta"));
                p.sendMessage(ChatUtil.fixColor(""));
                p.sendMessage(ChatUtil.fixColor(" &7Author&8: &bxKenKOfficial"));
                p.sendMessage(ChatUtil.fixColor(""));
                p.sendMessage(ChatUtil.fixColor(" &7Discord&8: &bhttps://discord.gg/2HDuZrEFTg"));
                p.sendMessage(ChatUtil.fixColor(""));
                p.sendMessage(ChatUtil.fixColor(" &7Aktualizacja&8: &b18.02.2022r. o godz. 12:59"));
                p.sendMessage(ChatUtil.fixColor(""));
                p.sendMessage(ChatUtil.fixColor("&8&l==========[&3&lxKenPanel&8&l]=========="));
            }
        }
    }
}
