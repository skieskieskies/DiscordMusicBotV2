package ru.dense.jdabot.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JdaAudioLoadResultHandler implements AudioLoadResultHandler {

    private final AudioPlayer audioPlayer;

    @Override
    public void trackLoaded(AudioTrack track) {
        audioPlayer.playTrack(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist playlist) {

    }

    @Override
    public void noMatches() {
        log.error("Resource not found");
    }

    @Override
    public void loadFailed(FriendlyException exception) {
        log.error("Resource load failed", exception);
    }
}
