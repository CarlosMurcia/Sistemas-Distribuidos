package com.Peluqueria;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/Ofertas")
public class OfertasRestController {

	private static final Logger log = LoggerFactory.getLogger(OfertasRestController.class);

	@Autowired
	private OfertasRepository repository3;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Oferta> getBooks() {
		return repository3.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Oferta> getBook(@PathVariable long id) {

		log.info("Get book {}", id);

		Oferta oferta = repository3.findOne(id);
		if (oferta != null) {
			return new ResponseEntity<>(oferta, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Oferta newBook(@RequestBody Oferta oferta) {

		repository3.save(oferta);

		return oferta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Oferta> updateBook(@PathVariable long id, @RequestBody Oferta updatedBook) {

		Oferta oferta = repository3.findOne(id);
		if (oferta != null) {

			updatedBook.setId(id);
			repository3.save(updatedBook);

			return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Oferta> deleteBook(@PathVariable long id) {

		Oferta deletedBook = repository3.findOne(id);
		if (deletedBook != null) {
			repository3.delete(id);
			return new ResponseEntity<>(deletedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
