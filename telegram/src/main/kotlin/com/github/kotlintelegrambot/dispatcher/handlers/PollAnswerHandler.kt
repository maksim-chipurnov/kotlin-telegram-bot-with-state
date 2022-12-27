package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.entities.polls.PollAnswer

data class PollAnswerHandlerEnvironment(
    override val bot: Bot,
    override val update: Update,
    val pollAnswer: PollAnswer
) : HandlerEnvironment

internal class PollAnswerHandler(
    private val handlePollAnswer: HandlePollAnswer
) : Handler {

    override fun checkUpdate(update: Update): Boolean = update.pollAnswer != null

    override fun handleUpdate(bot: Bot, update: Update) {
        val pollAnswer = update.pollAnswer
        checkNotNull(pollAnswer)

        val pollAnswerHandlerEnv = PollAnswerHandlerEnvironment(bot, update, pollAnswer)
        handlePollAnswer(pollAnswerHandlerEnv)
    }
}
