package com.example.myapp2.daos;

import com.example.myapp2.models.Listener;
import com.example.myapp2.models.User;
import com.example.myapp2.repositories.ListenerRepository;
import com.example.myapp2.repositories.UserRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerDao {
    @Autowired
    ListenerRepository listenerRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/findAllListeners")
    public Iterable<Listener> findAllListeners() {
        return listenerRepository.findAll();
    }
    @GetMapping("/findListenerByUserId/{userId}")
    public Listener findListenerByUserId(
            @PathVariable("userId") Integer userId) {
        return listenerRepository.findById(userId).get();
    }
    @GetMapping("/deleteListener/{userId}")
    public void deleteListener(
            @PathVariable("userId") Integer userId) {
        listenerRepository.deleteById(userId);
    }
    @GetMapping("/createListener")
    public Listener createListener() {
        User user = new User();
        userRepository.save(user);

        Integer userId = user.getId();
        Listener listener = new Listener(userId);
        listenerRepository.save(listener);
        return listener;
    }

}
