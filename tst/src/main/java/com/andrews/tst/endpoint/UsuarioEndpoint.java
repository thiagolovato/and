package com.andrews.tst.endpoint;

import com.andrews.tst.entity.User;
import com.andrews.tst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioEndpoint {

    private final UserRepository userRepository;

    @Autowired
    public UsuarioEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    User busca(@PathVariable("id") Long id) {
        return userRepository.findUserById(id);
    }

    @RequestMapping(path = "/user/name", method = RequestMethod.GET)
    List<User> buscaByName(@RequestParam(value = "nome") String nome) {
        return userRepository.findUserByNomeContainsIgnoreCase(nome);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    ResponseEntity salva(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}