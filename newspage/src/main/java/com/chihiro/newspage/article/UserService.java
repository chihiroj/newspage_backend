package com.chihiro.newspage.article;

import com.chihiro.newspage.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email, String name) {
        Optional<User> foundUser = userRepository.findByEmail(email);

        if(foundUser.isEmpty()) {
            User newUser = new User();
            newUser.setId(UUID.randomUUID());
            newUser.setEmail(email);
            newUser.setName(name);
            userRepository.save(newUser);
            return newUser;
        } else {
           return foundUser.get();
        }
    }
}
