package io.entangledword.services.user;

import org.springframework.stereotype.Service;

import io.entangledword.domain.user.User;
import io.entangledword.port.in.user.CreateUserUseCase;
import io.entangledword.port.out.user.CreateUserPort;
import reactor.core.publisher.Mono;

@Service
public class CreateUserService implements CreateUserUseCase{
	private final CreateUserPort createUserPort;

	public CreateUserService(CreateUserPort createUSerPort) {
		super();
		this.createUserPort = createUSerPort;
	}

	public Mono<User> save(User user) {
		return createUserPort.save(user);
	}

}
