package x.KenKOfficial.Panel.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import x.KenKOfficial.Panel.Main.Main;
import x.KenKOfficial.Panel.Utils.ChatUtil;
import x.KenKOfficial.Panel.Utils.LoreUtil;

import java.util.ArrayList;
import java.util.List;

public class Gui
{
    private static final String GUI_NAME = Main.getPlugin().getConfig().getString("gui_name");

    public static InventoryView menu(Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 45, ChatUtil.fixColor(GUI_NAME));
        final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);

        final ItemStack online = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta onlineMeta = online.getItemMeta();
        onlineMeta.setDisplayName(ChatUtil.fixColor("&3Gracze Online"));
        final List<String> opisOnline = new ArrayList<String>();
        opisOnline.add("&8>> &7Kliknij &bLPM &7aby zobaczy graczy online.");
        onlineMeta.setLore(LoreUtil.fixColors(opisOnline));
        online.setItemMeta(onlineMeta);

        final ItemStack killAll = new ItemStack(Material.SKULL_ITEM);
        final ItemMeta killAllMeta = killAll.getItemMeta();
        killAllMeta.setDisplayName(ChatUtil.fixColor("&3Zabij Wszystkich Graczy"));
        final List<String> opisKillAll = new ArrayList<String>();
        opisKillAll.add("&8>> &7Kliknij &bLPM &7aby zabic graczy online.");
        killAllMeta.setLore(LoreUtil.fixColors(opisKillAll));
        killAll.setItemMeta(killAllMeta);

        final ItemStack kickAll = new ItemStack(Material.IRON_AXE, 1);
        final ItemMeta kickAllMeta = kickAll.getItemMeta();
        kickAllMeta.setDisplayName(ChatUtil.fixColor("&3Wyrzuc Graczy Online"));
        final List<String> opisKickAll = new ArrayList<String>();
        opisKickAll.add("&8>> &7Kliknij &bLPM &7aby wyrzucic graczy online.");
        kickAllMeta.setLore(LoreUtil.fixColors(opisKickAll));
        kickAll.setItemMeta(kickAllMeta);

        final ItemStack whOn = new ItemStack(Material.PAPER, 1);
        final ItemMeta whOnMeta = whOn.getItemMeta();
        whOnMeta.setDisplayName(ChatUtil.fixColor("&3Wlacz Whiteliste"));
        final List<String> opisWhOn = new ArrayList<String>();
        opisWhOn.add("&8>> &7Kliknij &bLPM &7aby wlaczyc whiteliste.");
        whOnMeta.setLore(LoreUtil.fixColors(opisWhOn));
        whOn.setItemMeta(whOnMeta);

        final ItemStack whOff = new ItemStack(Material.PAPER, 1);
        final ItemMeta whOffMeta = whOff.getItemMeta();
        whOffMeta.setDisplayName(ChatUtil.fixColor("&3Wylacz Whiteliste"));
        final List<String> opisWhOff = new ArrayList<String>();
        opisWhOff.add("&8>> &7Kliknij &bLPM &7aby wylaczyc whiteliste.");
        whOffMeta.setLore(LoreUtil.fixColors(opisWhOff));
        whOff.setItemMeta(whOffMeta);

        final ItemStack serverOff = new ItemStack(Material.REDSTONE, 1);
        final ItemMeta serverOffMeta = serverOff.getItemMeta();
        serverOffMeta.setDisplayName(ChatUtil.fixColor("&3Wylacz Serwer"));
        final List<String> opisServerOff = new ArrayList<String>();
        opisServerOff.add("&8>> &7Kliknij &bLPM &7aby wylaczyc serwer.");
        serverOffMeta.setLore(LoreUtil.fixColors(opisServerOff));
        serverOff.setItemMeta(serverOffMeta);

        final ItemStack serverReload = new ItemStack(Material.EMERALD, 1);
        final ItemMeta serverReloadMeta = serverReload.getItemMeta();
        serverReloadMeta.setDisplayName(ChatUtil.fixColor("&3Reload Serwera"));
        final List<String> opisServerReload = new ArrayList<String>();
        opisServerReload.add("&8>> &7Kliknij &bLPM &7aby wykonac reload serwera.");
        serverReloadMeta.setLore(LoreUtil.fixColors(opisServerReload));
        serverReload.setItemMeta(serverReloadMeta);

        final ItemStack serverPlugins = new ItemStack(Material.MAP, 1);
        final ItemMeta serverPluginsMeta = serverPlugins.getItemMeta();
        serverPluginsMeta.setDisplayName(ChatUtil.fixColor("&3Lista Pluginow"));
        final List<String> opisServerPlugins = new ArrayList<String>();
        opisServerPlugins.add("&8>> &7Kliknij &bLPM &7aby zobaczyc aktywne pluginy.");
        serverPluginsMeta.setLore(LoreUtil.fixColors(opisServerPlugins));
        serverPlugins.setItemMeta(serverPluginsMeta);

        final ItemStack guiOff = new ItemStack(Material.WOOL, 1, (short)14);
        final ItemMeta guiOffMeta = guiOff.getItemMeta();
        guiOffMeta.setDisplayName(ChatUtil.fixColor("&3Wylacz Gui"));
        final List<String> opisGuiOff = new ArrayList<String>();
        opisGuiOff.add("&8>> &7Kliknij &bLPM &7aby wyjsc z gui.");
        guiOffMeta.setLore(LoreUtil.fixColors(opisGuiOff));
        guiOff.setItemMeta(guiOffMeta);

        for(int i = 0; i < 45; i++) {
            inv.setItem(i, glass);
            inv.setItem(10, online);
            inv.setItem(11, killAll);
            inv.setItem(12, kickAll);
            inv.setItem(13, whOn);
            inv.setItem(14, whOff);
            inv.setItem(15, serverOff);
            inv.setItem(16, serverReload);
            inv.setItem(22, serverPlugins);
            inv.setItem(34, guiOff);
        }
        return p.openInventory(inv);
    }
}
