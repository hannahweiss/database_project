package com.example.myapp2.daos;

import com.example.myapp2.models.*;
import com.example.myapp2.repositories.ListenerRepository;
import com.example.myapp2.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
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

    @GetMapping("/createListener/{userId}")
    public Listener createListener(
        @PathVariable("userId") Integer userId
    ) {
        Listener listener = new Listener(userId);
        listenerRepository.save(listener);
        return listener;
    }

    @GetMapping("/findListenerInformation")
    public List<ListenerInformation> findListenerInformation(){
        List<ListenerInformation> informations = new ArrayList<>();

        Iterable<Listener> listeners = findAllListeners();
        for (Listener l : listeners){
            int userId = l.getUserId();
            User u = userRepository.findById(userId).get();
            String listenerName = (u.getFirstName() + " " + u.getLastName());

            ListenerInformation info = new ListenerInformation(l, listenerName);
            informations.add(info);
        }
        return informations;
    }

}
