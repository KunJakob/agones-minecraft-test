package io.github.kunjakob

import io.github.kunjakob.agonesclient.apis.SDKApi
import io.github.kunjakob.agonesclient.models.SdkDuration
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

public class AgonesResponder : JavaPlugin(), Listener {
    companion object {
        var instance: JavaPlugin? = null
            private set;
    }

    private lateinit var agones: SDKApi;

    override fun onEnable() {
        instance = this;
        this.agones = SDKApi();

        doDelayed(20L) {
            agones.ready(null);
        }
    }

    override fun onDisable() {
        agones.shutdown(null);
    }

    @EventHandler
    fun AsyncChatEvent(e: AsyncPlayerChatEvent) {
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
    }
}

public inline fun doDelayed(seconds: Long, crossinline f: () -> Unit): BukkitTask? {
    return AgonesResponder.instance?.let {
        Bukkit.getScheduler().runTaskLaterAsynchronously(it, { f() } as Runnable, seconds * 20L)
    };

}

public inline fun doAsync(crossinline f: () -> Unit): BukkitTask? {
    return AgonesResponder.instance?.let { Bukkit.getScheduler().runTaskAsynchronously(it, { f() } as Runnable) }
}



