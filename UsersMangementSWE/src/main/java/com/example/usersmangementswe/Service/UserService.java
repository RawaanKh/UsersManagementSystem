package com.example.usersmangementswe.Service;

import com.example.usersmangementswe.Model.User;
import com.example.usersmangementswe.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);

        if (!userRepository.existsById(id)) {
            return false;
        }
        oldUser.setUsername(user.getUsername());
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }
}
