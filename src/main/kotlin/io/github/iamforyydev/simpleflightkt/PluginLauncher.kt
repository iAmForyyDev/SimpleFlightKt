package io.github.iamforyydev.simpleflightkt

import io.github.iamforyydev.simpleflightkt.commands.FlightCommand
import org.bukkit.plugin.java.JavaPlugin

class PluginLauncher : JavaPlugin() {

    override fun onEnable() {
        logger.info("Plugin has been enabled")
        server.commandMap.register("flight", FlightCommand())
    }

    override fun onDisable() {
        logger.info("Plugin has been disabled")
    }
}