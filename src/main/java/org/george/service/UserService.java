package org.george.service;

import org.george.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {

    private Map<Long, User> userRepository = new HashMap<>();

    @Cacheable(value = "users", key = "#id")
    public User getUser(Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepository.get(id);
    }

    @Cacheable(value = "users")
    public List<User> getUsers() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(userRepository.values());
    }

    @CachePut(value = "users", key = "#id")
    public User setUser(Long id, User user) {
        userRepository.put(id, user);
        return user;
    }

}
