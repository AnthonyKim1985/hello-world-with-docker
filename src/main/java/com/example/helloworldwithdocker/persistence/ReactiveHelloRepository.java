package com.example.helloworldwithdocker.persistence;

import com.example.helloworldwithdocker.domain.NameCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveHelloRepository extends ReactiveMongoRepository<NameCard, String> {
}
