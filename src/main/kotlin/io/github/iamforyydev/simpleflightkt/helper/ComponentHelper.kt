package io.github.iamforyydev.simpleflightkt.helper

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

class ComponentHelper {

    companion object {
        private val MINI_MESSAGE: MiniMessage = MiniMessage.miniMessage()

        fun asComponent(message: String?): Component {
            if (message.isNullOrEmpty()) {
                return Component.empty()
            }

            return MINI_MESSAGE.deserialize(message)
        }
    }
}