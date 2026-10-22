package registroSpeseBackEnd.RegistroSpese.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class CurrentAccount
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    private boolean active = true;

    private LocalDateTime creationDate = LocalDateTime.now(), updateDate = LocalDateTime.now();
}
