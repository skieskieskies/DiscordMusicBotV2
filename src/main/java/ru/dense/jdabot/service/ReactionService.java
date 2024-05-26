package ru.dense.jdabot.service;

import ru.dense.jdabot.entity.Reaction;
import ru.dense.jdabot.enumeration.ReactionType;

public interface ReactionService {

    Reaction getRandomReaction(ReactionType type);
}
