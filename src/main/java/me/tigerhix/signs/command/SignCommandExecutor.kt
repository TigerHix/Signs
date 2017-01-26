package me.tigerhix.signs.command

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.block.Sign
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SignCommandExecutor : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (!sender.isOp()) {
                sender.sendMessage("${ChatColor.RED} You do not have access to this command!")
                return true
            }
            if (args.size == 2) {
                if (args[0].matches(Regex.fromLiteral("^[-\\+]?[\\d]*$")) && args[0].toInt() in 1..4) {
                    val block = sender.getTargetBlock(setOf(), 10)
                    if (block.type in arrayOf(Material.SIGN_POST, Material.WALL_SIGN, Material.SIGN)) {
                        with(block.state as Sign) {
                            val message: String
                            if (args[1].equals("clear", ignoreCase = true)) {
                                message = ""
                            } else {
                                message = ChatColor.translateAlternateColorCodes('&', args[1]).replace("_", " ")
                            }
                            setLine(args[0].toInt() - 1, message)
                            update()
                        }
                        sender.sendMessage("${ChatColor.GRAY} Done! ヽ( ° ▽°)ノ")
                    } else {
                        sender.sendMessage("${ChatColor.RED} The line number is incorrect!")
                    }
                } else {
                    sender.sendMessage("${ChatColor.RED} Usage: /sign <line number> <message (use _ for space)>")
                }
            }
        } else {
            sender.sendMessage("This command is only available to players!")
        }
        return true
    }

}