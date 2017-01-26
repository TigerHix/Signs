package me.tigerhix.signs.behavior

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.plugin.Plugin

open class Behavior : Listener {

    lateinit var plugin: Plugin

    fun start(plugin: Plugin) {
        this.plugin = plugin
        Bukkit.getPluginManager().registerEvents(this, this.plugin)
    }

    open fun onStart() {
    }

    fun stop() {
        HandlerList.unregisterAll(this)
    }

    open fun onStop() {
    }

    @EventHandler
    fun onPluginDisable(event: PluginDisableEvent) = with(event) {
        if (plugin == this.plugin) stop()
    }

}