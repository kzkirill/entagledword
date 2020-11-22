package io.entangledword.port.out.blogpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.entangledword.domain.user.User;
import io.entangledword.persist.entity.UserMongoDoc;
import io.entangledword.persist.repos.UserRepository;
import io.entangledword.port.out.DTOMappingService;
import io.entangledword.port.out.user.CreateUserPort;
import reactor.core.publisher.Mono;

@Service
public class CreateUserAdapter implements CreateUserPort {

	@Autowired
	private UserRepository repo;
	@Autowired
	private DTOMappingService<User, UserMongoDoc> mapping;

	@Override
	public Mono<User> save(User user) {
		return repo.save(mapping.toEntity(user)).map(mapping::toDTO);
	}

}
