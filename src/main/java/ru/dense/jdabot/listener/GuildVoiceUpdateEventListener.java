package ru.dense.jdabot.listener;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMuteEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;
import ru.dense.jdabot.entity.Reaction;
import ru.dense.jdabot.enumeration.ReactionType;
import ru.dense.jdabot.service.ReactionService;

@Slf4j
@Component
@RequiredArgsConstructor
public class GuildVoiceUpdateEventListener extends ListenerAdapter {

    private final AudioPlayerManager playerManager;

    private final ReactionService reactionService;

    private final AudioLoadResultHandler audioLoadResultHandler;

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        Reaction randomReaction = reactionService.getRandomReaction(ReactionType.CONNECT);
        playerManager.loadItem(randomReaction.getResourceId(), audioLoadResultHandler);
    }

    @Override
    public void onGuildVoiceMute(GuildVoiceMuteEvent event) {
        Reaction randomReaction = reactionService.getRandomReaction(ReactionType.MUTE);
        playerManager.loadItem(randomReaction.getResourceId(), audioLoadResultHandler);
    }
}
