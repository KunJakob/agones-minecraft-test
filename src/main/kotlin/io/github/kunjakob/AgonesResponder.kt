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

        doRepeating(0, 4L) {
            agones.health(null);
        }
    }

    override fun onDisable() {
        agones.shutdown(null);
    }

    @EventHandler
    fun onAsyncChatEvent(e: AsyncPlayerChatEvent) {
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

public fun doDelayed(seconds: Long, f: () -> Unit): BukkitTask? {
    return AgonesResponder.instance?.let {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(it, f, seconds * 20L)
    };
}

public fun doRepeating(delay: Long, interval: Long, f: () -> Unit): BukkitTask? {
    return AgonesResponder.instance?.let {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(it, f, delay * 20L, interval * 20L);
    };
}


public inline fun doAsync(crossinline f: () -> Unit): BukkitTask? {
    return AgonesResponder.instance?.let { return Bukkit.getScheduler().runTaskAsynchronously(it, { f() } as Runnable) }
}



