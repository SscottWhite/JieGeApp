package com.ncstudy.config;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class AuthenticationConfig extends AuthenticationManagerBuilder {

	public AuthenticationConfig(ObjectPostProcessor<Object> objectPostProcessor) {
		super(objectPostProcessor);
	}

	@Override
	public AuthenticationManagerBuilder authenticationEventPublisher(AuthenticationEventPublisher eventPublisher) {
		
		return super.authenticationEventPublisher(eventPublisher);
	}

	@Override
	public AuthenticationManagerBuilder authenticationProvider(AuthenticationProvider authenticationProvider) {
		
		return super.authenticationProvider(authenticationProvider);
	}

}
