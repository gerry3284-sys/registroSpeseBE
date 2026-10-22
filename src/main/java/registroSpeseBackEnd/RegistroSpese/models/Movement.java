package registroSpeseBackEnd.RegistroSpese.models;

import jakarta.persistence.*;
import lombok.Data;
import registroSpeseBackEnd.RegistroSpese.enums.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Movement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovementType type;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, length = 500)
    private String causal;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY) // Non carica il conto se non serve
    @JoinColumn(name = "ca_id", nullable = false)
    private CurrentAccount currentAccount;

    private LocalDateTime creationDate = LocalDateTime.now(), updateDate = LocalDateTime.now();
}