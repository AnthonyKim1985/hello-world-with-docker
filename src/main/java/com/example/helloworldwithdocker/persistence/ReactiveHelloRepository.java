package com.example.helloworldwithdocker.persistence;

import com.example.helloworldwithdocker.domain.Hello;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveHelloRepository extends ReactiveMongoRepository<Hello, String> {
}
