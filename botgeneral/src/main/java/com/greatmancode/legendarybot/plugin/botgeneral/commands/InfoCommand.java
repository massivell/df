/*
 * MIT License
 *
 * Copyright (c) Copyright (c) 2017-2017, Greatmancode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.greatmancode.legendarybot.plugin.botgeneral.commands;

import com.greatmancode.legendarybot.api.LegendaryBot;
import com.greatmancode.legendarybot.api.commands.PublicCommand;
import com.greatmancode.legendarybot.api.commands.ZeroArgsCommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Command to give general information about the bot
 */
public class InfoCommand implements PublicCommand, ZeroArgsCommand {

    private LegendaryBot bot;

    public InfoCommand(LegendaryBot bot) {
        this.bot = bot;
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("LegendaryBot");
        eb.setAuthor("Greatman", "https://github.com/greatman/legendarybot", "https://avatars3.githubusercontent.com/u/95754?v=3&s=460");
        String prefix = bot.getGuildSettings(event.getGuild()).getSetting("PREFIX");
        if (prefix == null) {
            prefix = "!";
        }
        eb.setDescription(bot.getTranslateManager().translate(event.getGuild(), "command.info.text", prefix) + " https://discordbots.org/bot/Legendarybot");
        event.getChannel().sendMessage(eb.build()).queue();
    }

    @Override
    public String help(Guild guild) {
        return bot.getTranslateManager().translate(guild, "command.info.help");
    }

    @Override
    public String shortDescription(Guild guild) {
        return help(guild);
    }
}
