package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomeService implements FortuneService {

	@Override
	public String getFortune() {
		return "";
	}

}
