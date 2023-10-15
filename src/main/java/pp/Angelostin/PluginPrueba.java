package pp.Angelostin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pp.Angelostin.comandos.Cpluginprueba;
import pp.Angelostin.utilidades.utilMensajes;

public class PluginPrueba extends JavaPlugin {

    public static String prefix = "&l[&o&6Plugin Prueba] ";
    private String version = getDescription().getVersion();
    public void onEnable(){

        registrarComandos();

        Bukkit.getConsoleSender().sendMessage(utilMensajes.colorDeMensajes(prefix + "&aAh sido activado :) " + "&9Version: " + version));
        Bukkit.getConsoleSender().sendMessage(utilMensajes.colorDeMensajes(prefix + "&aGracias por usar este  plugin"));
    }

    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(utilMensajes.colorDeMensajes(prefix + "&cAh sido desactivado :( " + "&9Version: " + version));
        Bukkit.getConsoleSender().sendMessage(utilMensajes.colorDeMensajes(prefix + "&aGracias por usar este  plugin"));
    }

    public void registrarComandos(){
        this.getCommand("pluginprueba").setExecutor(new Cpluginprueba());

    }
}
