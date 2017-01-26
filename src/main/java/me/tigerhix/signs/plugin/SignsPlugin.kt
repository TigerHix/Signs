package me.tigerhix.signs.plugin

import me.tigerhix.signs.behavior.SignsBehavior
import me.tigerhix.signs.command.SignCommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class SignsPlugin : JavaPlugin() {

    override fun onEnable() {
        getCommand("sign").executor = SignCommandExecutor()
        SignsBehavior.start(this)
    }

}
