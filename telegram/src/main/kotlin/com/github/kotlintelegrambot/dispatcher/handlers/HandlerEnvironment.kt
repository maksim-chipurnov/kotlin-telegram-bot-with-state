package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Update

interface HandlerEnvironment {
    val bot: Bot
    val update: Update
}
