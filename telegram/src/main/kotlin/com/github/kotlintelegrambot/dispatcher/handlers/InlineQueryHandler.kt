package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.InlineQuery
import com.github.kotlintelegrambot.entities.Update

data class InlineQueryHandlerEnvironment(
    override val bot: Bot,
    override val update: Update,
    val inlineQuery: InlineQuery
) : HandlerEnvironment

internal class InlineQueryHandler(
    private val handleInlineQuery: HandleInlineQuery
) : Handler {

    override fun checkUpdate(update: Update): Boolean = update.inlineQuery != null

    override fun handleUpdate(bot: Bot, update: Update) {
        val inlineQuery = update.inlineQuery
        checkNotNull(inlineQuery)

        val inlineQueryHandlerEnv = InlineQueryHandlerEnvironment(bot, update, inlineQuery)
        handleInlineQuery(inlineQueryHandlerEnv)
    }
}
