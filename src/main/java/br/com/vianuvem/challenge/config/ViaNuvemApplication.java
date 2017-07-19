package br.com.vianuvem.challenge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by eltonmoraes on 7/17/17.
 */
@SpringBootApplication(scanBasePackages = {
        "br.com.vianuvem.challenge.rest",
        "br.com.vianuvem.challenge.service"
})
@EnableJpaRepositories("br.com.vianuvem.challenge.repository")
@EntityScan("br.com.vianuvem.challenge.entity")
public class ViaNuvemApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(ViaNuvemApplication.class, args);
    }
}
