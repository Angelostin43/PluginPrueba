package pp.Angelostin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import pp.Angelostin.PluginPrueba;
import pp.Angelostin.utilidades.utilMensajes;

public class EventoJugador implements Listener {

    @EventHandler
    public void escribeJugador(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String mensaje = event.getMessage();

        if(mensaje.toLowerCase().contains("aternos")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix +"&cNo escribas huevadas"));
        }

        if(mensaje.toLowerCase().contains("gay")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix +"&cTu viejo"));
        }

        if(mensaje.toLowerCase().contains("gonzalo")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&0Negro Huevon"));
        }

        if(mensaje.toLowerCase().contains("marco")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "Chamo de mierda"));
        }

        if(mensaje.toLowerCase().contains("alannys")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&cALANNYS VELA"));
        }

        if(mensaje.toLowerCase().contains("favio")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "-----"));
        }

        if(mensaje.toLowerCase().contains("leo")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "Gordo traga sable"));
        }

        if(mensaje.toLowerCase().contains("basilio")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "Oye no diga eso"));
        }

        if(mensaje.toLowerCase().contains("puto")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&eTu abuelo"));
        }

        if(mensaje.toLowerCase().contains("piero")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix + "&eEl mas pro"));
        }
    }
    @EventHandler
    public void entraJugador(PlayerJoinEvent event){
        //204.6 70 -99.6 -180 0
        Player player = event.getPlayer();

        player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.nombreServidor + "¡Bienvenido al servidor!"));
        Location location = new Location(Bukkit.getWorld("world"),204.6,70,-99.6,-180 ,0);
        player.teleport(location);
    }

    @EventHandler
    public void rompeBloqueJugador(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world") && !player.hasPermission("pluginprueba.romperbloque")){
            event.setCancelled(true);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix +"&cNo puedes romper bloques huevon"));
        }
    }

    @EventHandler
    public void colocarBloqueJugador(BlockCanBuildEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world") && !player.hasPermission("pluginprueba.colocarbloque")){
            event.setBuildable(false);
            player.sendMessage(utilMensajes.colorDeMensajes(PluginPrueba.prefix +"&cNo puedes colocar bloques huevon"));
        }
    }
}
