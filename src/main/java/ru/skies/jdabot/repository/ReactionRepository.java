package ru.skies.jdabot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skies.jdabot.entity.Reaction;
import ru.skies.jdabot.enumeration.ReactionType;

import java.util.List;
import java.util.UUID;

public interface ReactionRepository extends JpaRepository<Reaction, UUID> {
    List<Reaction> findAllByReactionType(ReactionType type);
}
