package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(FuncionarioRepository repository) {

        return args -> {
            log.info("pré-carregamento de funcionario " + repository.save(new Funcionario("Ana Luiza", "Quality")));
            log.info("pré-carregamento de funcionario" + repository.save(new Funcionario("Gabriel", "Analista")));
        };
    }
}