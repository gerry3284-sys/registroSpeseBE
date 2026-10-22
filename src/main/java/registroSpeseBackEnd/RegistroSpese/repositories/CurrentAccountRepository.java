package registroSpeseBackEnd.RegistroSpese.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registroSpeseBackEnd.RegistroSpese.models.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long>
{
    boolean existsByName(String name);
}
