package pp.Angelostin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pp.Angelostin.PluginPrueba;
import pp.Angelostin.utilidades.utilMensajes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cpluginprueba implements CommandExecutor {

    private PluginPrueba plugin;

    public Cpluginprueba(PluginPrueba plugin){
        this.plugin = plugin;
    }

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

            }else if (args[0].equalsIgnoreCase("obtener")){
                // /pluginprueba obtener <autor / version>
                subcomandosget(sender,args);

            }else {
                help(sender);
            }
        }else {
            // /pluginprueba
            help(sender);
        }
        return true;
    }

    public void help(CommandSender sender){
        sender.sendMessage(utilMensajes.colorDeMensajes("&f---&aComandos de  " + PluginPrueba.prefix + "&f---"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba bienvenida"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba fecha"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f- /pluginprueba obtener &3autor &f/ &3version"));
        sender.sendMessage(utilMensajes.colorDeMensajes("&f-------------------------------"));
    }

    public void subcomandosget(CommandSender sender, String[] args){

        if(sender.hasPermission("pluginprueba.get")){
            sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&cNo tienes permisos para ejecutar este comando"));
            return;
        }

        if(args.length == 1){
            sender.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&aDebes usar &f/pluginprueba obtener &3autor &f/ &3version"));
            return;
        }

        if(args[1].equalsIgnoreCase("autor")){
            sender.sendMessage(utilMensajes.colorDeMensajes(
                    PluginPrueba.prefix + "&fAutor: &a" + plugin.getDescription().getAuthors()));
        }else if(args[1].equalsIgnoreCase("version")){
            sender.sendMessage(utilMensajes.colorDeMensajes(
                    PluginPrueba.prefix + "&fVersion: &a" + plugin.getDescription().getVersion()));
        }else{
            sender.sendMessage(utilMensajes.colorDeMensajes(
                    PluginPrueba.prefix + "&aDebes usar &f/pluginprueba obtener &3autor &f/ &3version"));
        }
    }
}