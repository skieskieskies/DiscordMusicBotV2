package ru.skies.jdabot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.internal.utils.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skies.jdabot.listener.GuildVoiceUpdateEventListener;
import ru.skies.jdabot.util.BotWrapper;

import java.util.Collection;
import java.util.Comparator;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JdaConfig {

    private final GuildVoiceUpdateEventListener voiceUpdateEventListener;

    @Bean
    public BotWrapper jda(@Value("${jda.token}") String token,
                          @Value("${jda.guild-id}") Long guildId) throws InterruptedException {
        JDA jda = JDABuilder
                .createDefault(token)
                .addEventListeners(voiceUpdateEventListener)
                .build();
        jda.awaitStatus(JDA.Status.CONNECTED);
        Guild targetGuild = jda.getGuildById(guildId);
        VoiceChannel targetChannel = getMaxJoinedChannel(targetGuild.getVoiceChannels());
        AudioManager audioManager = targetGuild.getAudioManager();
        audioManager.openAudioConnection(targetChannel);

        return BotWrapper.builder()
                .jda(jda)
                .voiceChannel(targetChannel)
                .build();
    }

    private VoiceChannel getMaxJoinedChannel(Collection<VoiceChannel> voiceChannels) {
        if (voiceChannels.isEmpty()) {
            throw new IllegalArgumentException("No voice channels in guild");
        }
        Pair<VoiceChannel, Integer> pair = voiceChannels.stream().map(channel -> Pair.of(channel, channel.getMembers().size()))
                .max(Comparator.comparingInt(Pair::getRight))
                .get();
        VoiceChannel channel = null;
        if (!pair.getRight().equals(0)) {
            channel = pair.getLeft();
        }
        return channel;
    }
}
