package com.Peluqueria;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInicializer {

    @Autowired
    private OfertasRepository repository3;

    @PostConstruct
    private void initDatabase() {
    	
    	repository3.save(new Oferta (" Corte 20€", "2017/04/15", "2017/05/23"));
		repository3.save(new Oferta ("Lavado y tinte 15€", "2017/04/15", "2017/05/23"));
		
    }

}
