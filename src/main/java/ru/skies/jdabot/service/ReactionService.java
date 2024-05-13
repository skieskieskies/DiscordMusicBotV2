package ru.skies.jdabot.service;

import ru.skies.jdabot.entity.Reaction;
import ru.skies.jdabot.enumeration.ReactionType;

public interface ReactionService {

    Reaction getRandomReaction(ReactionType type);
}
