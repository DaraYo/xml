package xml.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xml.web.dto.AuthorDTO;
import xml.web.dto.LoginDTO;
import xml.Util;
import xml.model.Author;
import xml.security.TokenUtils;
import xml.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> registration(@RequestBody AuthorDTO authorDTO) {
		try {
			userService.register(authorDTO);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
		System.out.println("LOGIN - " + loginDTO.getUsername());
		Map<String, Object> retVal = userService.login(loginDTO);
		return Optional.ofNullable(retVal)
				.map(cookie -> new ResponseEntity<>(cookie, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@RequestMapping(value = "/usersByRole/{role}", method = RequestMethod.GET)
	public ResponseEntity<List<AuthorDTO>> getUsersByRole(@PathVariable String role) throws JAXBException {
		List<AuthorDTO> authorsDTO = new ArrayList<>();
		try {
			List<Author> authors = userService.getByRole(role);
			System.out.println("Found authors: " + authors.size());
			for (Author a : authors) {
				
				AuthorDTO authorDTO = new AuthorDTO(a);
				authorsDTO.add(authorDTO);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(authorsDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<AuthorDTO> getUserDetails(Principal principal)
			throws ParserConfigurationException, IOException, JAXBException {
		System.out.println("GET USER DETAILS");
		if (principal == null) {
			System.out.println("korisnik nije ulogovan");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Author author = userService.getUserDetails(principal.getName());
		AuthorDTO authorDTO= new AuthorDTO(author);
		System.out.println(author.getUsername());
		System.out.println(author.getPassword());
		System.out.println(author.getEMail());
		
		if (author == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(authorDTO, HttpStatus.OK);
	}
}
