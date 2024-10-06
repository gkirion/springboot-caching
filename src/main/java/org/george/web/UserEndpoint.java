package org.george.web;

import org.george.model.User;
import org.george.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpoint.class);

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User setUser(@PathVariable Long id, @RequestBody User user) {
        return userService.setUser(id, user);
    }

    @GetMapping("/cache")
    public void cacheInfo() {
        LOGGER.info("cache manager: {}", cacheManager);
        LOGGER.info("caches: {}", cacheManager.getCacheNames());
        LOGGER.info("cache: {}", cacheManager.getCache("users").getNativeCache());
        LOGGER.info("redisConnectionFactory: {}", redisConnectionFactory);
    }

}
