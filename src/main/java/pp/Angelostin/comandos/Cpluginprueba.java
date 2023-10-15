package pp.Angelostin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pp.Angelostin.PluginPrueba;
import pp.Angelostin.utilidades.utilMensajes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;

public class Cpluginprueba implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            //Consola
            sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&aSolo un jugador puede usar este comando"));
            return true;
        }
        //Jugador
        Player player = (Player) sender;

        if(args.length >= 1){
            if (args[0].equalsIgnoreCase("bienvenida")){
                // /pluginprueba bienvenida
                sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&2Bienvenido" + player.getName()));
            }else if (args[0].equalsIgnoreCase("fecha")){
                // /pluginprueba fecha
                // -----Metodo para obtener la fecha y hora actual----
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                // ---------------------------------------------------
                sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&aFecha y hora actual: &3" + date));

            }else if (args[0].equalsIgnoreCase("get")){
                // /pluginprueba get
                sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&2Bienvenido" + player.getName()));
            }else {
                help(sender);
            }

        }else{
            // /pluginprueba
            help(sender);
        }

        sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&aUsaste el comando '&7/pluginprueba'"));
        return true;
    }

    public void help(CommandSender sender){
        sender.sendMessage(utilMensajes.colorDeMensajes("&f---&aComandos" + PluginPrueba.prefix + "&f---"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba bienvenida"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba fecha"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba get"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f---------------------------------------------"));
    }
}