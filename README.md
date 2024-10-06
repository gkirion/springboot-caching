# Springboot Caching
A simple app to demonstrate the concept of caching in Spring Boot

## Notes
CacheConfig is not needed, but its there for demonstration purposes to show how we can customize our cache setup.

By default ConcurrentMapCacheManager is used, which uses a simple Map to cache the values.

When we include the redis dependency a RedisCacheManager is being used, without any further configuration.
 
Of course we can customize our setup via CacheConfig class.
