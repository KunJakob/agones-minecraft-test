package io.github.kunjakob

import io.github.kunjakob.agonesclient.apis.SDKApi
import io.github.kunjakob.agonesclient.models.SdkDuration
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

public class AgonesResponder : JavaPlugin(), Listener {
    companion object {
        var instance: JavaPlugin? = null
            private set;
    }

    private lateinit var agones: SDKApi;

    override fun onEnable() {
        instance = this;
        this.agones = SDKApi();
        System.out.println("Agones Responder enabled. Triggering ready state")
        Bukkit.getPluginManager().registerEvents(this, this);

        doDelayed(10L) {
            agones.ready(null);
        }

        doRepeating(0, 4L) {
            agones.health(null);
        }

    }

    override fun onDisable() {
        agones.shutdown(null);
    }


    @EventHandler
    public fun onPlayerJoin(e: PlayerJoinEvent) {
        e.player.sendMessage("Welcome to the agones test.")
    }

    @EventHandler
    public fun onAsyncChatEvent(e: AsyncPlayerChatEvent) {
        if (e.message.equals("allocate", true)) {
            doAsync { agones.allocate(null) }
        } else if (e.message.equals("shutdown", true)) {
            doAsync { agones.shutdown(null) }
        } else if (e.message.startsWith("reserve", true)) {
            val split = e.message.split(" ")
            val duration = SdkDuration();
            duration.seconds = split[1]
            doAsync { agones.reserve(duration) }
        }
        e.player.sendMessage("ACK: ${e.message}")
    }
}

public fun doDelayed(seconds: Long, f: () -> Unit) {
    AgonesResponder.instance?.let {
        Bukkit.getScheduler().runTaskLaterAsynchronously(it, f, seconds * 20L)
    };
}

public fun doRepeating(delay: Long, interval: Long, f: () -> Unit) {
    AgonesResponder.instance?.let {
        Bukkit.getScheduler().runTaskTimerAsynchronously(it, f, delay * 20L, interval * 20L);
    };
}


public fun doAsync( f: () -> Unit) {
    AgonesResponder.instance?.let { Bukkit.getScheduler().runTaskAsynchronously(it, f) }
}



