package ru.skies.jdabot.config;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skies.jdabot.audio.ScheduledAudioEventAdapter;

@Configuration
@RequiredArgsConstructor
public class LavaPlayerConfig {

    private final ScheduledAudioEventAdapter audioEventAdapter;

    @Bean
    public AudioPlayerManager audioPlayerManager() {
        AudioPlayerManager audioPlayerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        return audioPlayerManager;
    }

    @Bean
    public AudioPlayer audioPlayer() {
        AudioPlayer player = audioPlayerManager().createPlayer();
        player.addListener(audioEventAdapter);
        return player;
    }
}
