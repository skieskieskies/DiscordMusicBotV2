package ru.dense.jdabot.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;

@Builder
@Getter
@Setter
public class BotWrapper {

    private JDA jda;

    private VoiceChannel voiceChannel;
}
