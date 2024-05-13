package ru.skies.jdabot.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Component
@RequiredArgsConstructor
public class AudioPlayerSendHandler implements AudioSendHandler {

    private final AudioPlayer audioPlayer;

    private AudioFrame audioFrame;

    @Override
    public boolean canProvide() {
        audioFrame = audioPlayer.provide();
        return audioFrame != null;
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        return ByteBuffer.wrap(audioFrame.getData());
    }
}
