package ru.skies.jdabot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skies.jdabot.entity.Reaction;
import ru.skies.jdabot.enumeration.ReactionType;
import ru.skies.jdabot.repository.ReactionRepository;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;

    @Override
    public Reaction getRandomReaction(ReactionType type) {
//        List<Reaction> reactions = reactionRepository.findAllByType(type);
//        return reactions.get((int) (reactions.size() * Math.random()));
        return Reaction.builder()
                .resourceId("DcTfiodfGak")
                .build();
    }
}
