package com.smartqueue.smartqueue.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smartqueue.smartqueue.entity.Token;
import com.smartqueue.smartqueue.service.TokenService;
@RestController
@RequestMapping("/tokens")
public class TokenController {
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public Token addToken(@RequestBody Token token) {
        return tokenService.addToken(token);
    }
    @GetMapping
    public List<Token> getAllTokens() {
        return tokenService.getAllTokens();
    }
    @GetMapping("/{id}")
    public Token getTokenById(@PathVariable Long id) {
        return tokenService.getTokenById(id);
    }
    @PutMapping("/{id}")
    public Token updateToken(@PathVariable Long id, @RequestBody Token token) {
        return tokenService.updateToken(id, token);
    }
    @DeleteMapping("/{id}")
    public String deleteToken(@PathVariable Long id) {
        return tokenService.deleteToken(id);
    }
    @PutMapping("/call/{id}")
    public Token callNextToken(@PathVariable Long id) {
        return tokenService.callNextToken(id);
    }
    @PutMapping("/complete/{id}")
public Token completeToken(@PathVariable Long id) {
    return tokenService.completeToken(id);
}
}