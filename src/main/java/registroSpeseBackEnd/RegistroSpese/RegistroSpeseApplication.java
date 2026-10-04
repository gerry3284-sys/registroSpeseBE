package registroSpeseBackEnd.RegistroSpese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistroSpeseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroSpeseApplication.class, args);
	}
}

/*
↓ Esempio da cancellare

    package registroSpeseBackEnd.controller;

    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/spese")
    @Tag(name = "Spese", description = "Endpoint per la gestione delle spese")
    public class SpesaController {

        @GetMapping
        @Operation(summary = "Ottieni lista spese", description = "Ritorna l'elenco completo di tutte le spese registrate")
        public String getSpese() {
            return "Lista Spese";
        }
    }

*/