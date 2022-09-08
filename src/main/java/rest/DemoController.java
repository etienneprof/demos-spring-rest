package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@GetMapping
	// @RequestMapping(method = HttpMethod.GET) // Ligne equivalente a la precedente
	public ResponseEntity<Integer> getInt() {
		return new ResponseEntity<Integer>(123, HttpStatus.OK);
	}
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello() {
		return new ResponseEntity<String>("Hello world !", HttpStatus.OK);
	}
}
