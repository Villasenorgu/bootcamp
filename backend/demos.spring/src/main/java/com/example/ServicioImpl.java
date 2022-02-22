package com.example;

import org.springframework.stereotype.Component;

@Component
public class ServicioImpl implements Servicio {

	public ServicioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Soy el servicio");

	}

}
