package com.example.helloworldwithdocker;

import com.example.helloworldwithdocker.domain.Hello;
import com.example.helloworldwithdocker.persistence.ReactiveHelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;

@RestController
@SpringBootApplication
public class HelloWorldWithDockerApplication {
    private final ReactiveHelloRepository reactiveHelloRepository;

    @Autowired
    public HelloWorldWithDockerApplication(ReactiveHelloRepository reactiveHelloRepository) {
        this.reactiveHelloRepository = reactiveHelloRepository;
    }

    @RequestMapping("/{name}")
    public Mono<String> home(@PathVariable("name") @NotBlank String name) {
        return reactiveHelloRepository.save(new Hello(name))
                .switchIfEmpty(Mono.error(new RuntimeException()))
                .flatMap(hello -> Mono.just(hello.toString()));
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldWithDockerApplication.class, args);
    }

}

