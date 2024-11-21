package io.github.iamforyydev.simpleflightkt.commands

import io.github.iamforyydev.simpleflightkt.helper.ComponentHelper
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlightCommand : Command("flight") {

    override fun execute(commandSender: CommandSender, command: String, arguments: Array<out String>?): Boolean {
        if (commandSender is Player) {
            if (commandSender.allowFlight) {
                commandSender.allowFlight = false
                commandSender.isFlying = false

                commandSender.sendMessage(ComponentHelper.asComponent("<red>Your flight mode has been disabled"))
            } else {

                commandSender.allowFlight = true
                commandSender.isFlying = true

                commandSender.sendMessage(ComponentHelper.asComponent("<green>Your glith mode has been enabled"))
            }

            return true
        }

        commandSender.sendMessage("This command is only for player's.")
        return true
    }
}