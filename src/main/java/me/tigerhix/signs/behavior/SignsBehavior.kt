package me.tigerhix.signs.behavior

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.block.SignChangeEvent

object SignsBehavior : Behavior() {

    @EventHandler
    fun onSignChange(event: SignChangeEvent) = with(event) {
        for (index in lines.indices) {
            setLine(index, ChatColor.translateAlternateColorCodes('&', lines[index]))
        }
    }

}