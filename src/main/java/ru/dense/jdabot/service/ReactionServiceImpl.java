package ru.dense.jdabot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dense.jdabot.entity.Reaction;
import ru.dense.jdabot.enumeration.ReactionType;
import ru.dense.jdabot.repository.ReactionRepository;

import java.util.List;

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
