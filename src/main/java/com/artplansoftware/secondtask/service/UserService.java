package com.artplansoftware.secondtask.service;

import com.artplansoftware.secondtask.entity.User;
import com.artplansoftware.secondtask.exceptions.CreationOfExistingUserException;
import com.artplansoftware.secondtask.repository.RolesRepository;
import com.artplansoftware.secondtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {


    UserRepository repository;
    PasswordEncoder passwordEncoder;
    RolesRepository rolesRepository;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }

    public void addNewUser (User user,  HttpServletRequest request) {
        if (!repository.existsByName(user.getName())) {
            User newUser = new User(
                    user.getName().toLowerCase(),
                    passwordEncoder.encode(user.getPassword()));
            repository.save(newUser);

            authWithHttpServletRequest(request, user.getName().toLowerCase(), user.getPassword());
        } else throw new CreationOfExistingUserException();
    }

    private void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public String validateName (String name) {
        if (repository.existsByName(name)) {
            return "К сожалению, имя " + name + " занято другим пользователем.";
        } else
            return "Имя " + name + " доступно для регистрации.";
    }

}
