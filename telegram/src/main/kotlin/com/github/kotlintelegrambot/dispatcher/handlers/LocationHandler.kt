package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Location
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.Update

data class LocationHandlerEnvironment(
    override val bot: Bot,
    override val update: Update,
    val message: Message,
    val location: Location
) : HandlerEnvironment

internal class LocationHandler(
    private val handleLocation: HandleLocation
) : Handler {

    override fun checkUpdate(update: Update): Boolean {
        return update.message?.location != null
    }

    override fun handleUpdate(bot: Bot, update: Update) {
        checkNotNull(update.message)
        checkNotNull(update.message.location)

        val locationHandlerEnv = LocationHandlerEnvironment(
            bot,
            update,
            update.message,
            update.message.location
        )
        handleLocation(locationHandlerEnv)
    }
}
