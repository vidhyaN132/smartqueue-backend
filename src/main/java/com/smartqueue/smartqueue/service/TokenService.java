package com.smartqueue.smartqueue.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartqueue.smartqueue.entity.Token;
import com.smartqueue.smartqueue.repository.TokenRepository;
@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;
    public Token addToken(Token token) {
        int nextToken = tokenRepository.findAll().size() + 1;
        token.setTokenNumber(nextToken);
        return tokenRepository.save(token);
    }
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
    public Token getTokenById(Long id) {
        return tokenRepository.findById(id).orElse(null);
    }
    public Token updateToken(Long id, Token tokenDetails) {
        Token token = tokenRepository.findById(id).orElse(null);
        if (token != null) {
            token.setTokenNumber(tokenDetails.getTokenNumber());
            token.setUserId(tokenDetails.getUserId());
            token.setQueueId(tokenDetails.getQueueId());
            token.setStatus(tokenDetails.getStatus());
            return tokenRepository.save(token);
        }
        return null;
    }
    public String deleteToken(Long id) {
        tokenRepository.deleteById(id);
        return "Token deleted successfully";
    }
    public Token callNextToken(Long id) {
        Token token = tokenRepository.findById(id).orElse(null);
        if (token != null) {
            token.setStatus("CALLED");
            return tokenRepository.save(token);
        }
        return null;
    }
    public Token completeToken(Long id) {

    Token token = tokenRepository.findById(id).orElse(null);

    if (token != null) {
        token.setStatus("COMPLETED");
        return tokenRepository.save(token);
    }

    return null;
}
}