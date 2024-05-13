package ru.dense.jdabot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.dense.jdabot.enumeration.ReactionSource;
import ru.dense.jdabot.enumeration.ReactionType;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {

    @Id
    private UUID id;

    private ReactionSource source;

    private ReactionType reactionType;

    private String resourceId;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }

}
