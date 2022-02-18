package x.KenKOfficial.Panel.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import x.KenKOfficial.Panel.Commands.ServerPanelCommand;
import x.KenKOfficial.Panel.Listeners.InventoryClick;
import x.KenKOfficial.Panel.Listeners.PlayerJoin;

public class Main extends JavaPlugin
{
    private static Main plugin;

    public void onEnable()
    {
        (plugin) = this;
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        System.out.println("###########################################################");
        System.out.println("xKenPanel");
        System.out.println("Wersja: 1.0-Beta");
        System.out.println("Aktywowany!");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    public void onDisable()
    {
        this.saveDefaultConfig();
        System.out.println("###########################################################");
        System.out.println("xKenPanel");
        System.out.println("Wersja: 1.0-Beta");
        System.out.println("Aktywowany!");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    private void registerCommands()
    {
        this.getLogger().info("Ladowanie komend z pluginu: " + this.getName());
        this.getCommand("serverpanel").setExecutor(new ServerPanelCommand());
    }

    private void registerListeners()
    {
        this.getLogger().info("Ladowanie eventow z pluginu: " + this.getName());
        Bukkit.getPluginManager().registerEvents((Listener)new InventoryClick(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoin(), (Plugin)this);
    }

    public static Main getPlugin()
    {
        return plugin;
    }
}
