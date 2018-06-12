package org.lhyf.demo.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/****
 * @author YF
 * @date 2018-06-12 15:37
 * @desc RedisCache
 *
 **/
public class RedisCache<K, V> implements Cache<K, V> {

    private final String CACHE_PREFIX = "shiro-cache";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    private Object redisGet(K key) {
        return redisTemplate.opsForValue().get(getKey(key));
    }

    private void redisSet(K key, V value) {
        redisTemplate.opsForValue().set(getKey(key), value);
        redisTemplate.expire(key, 600, TimeUnit.SECONDS);
    }

    private void redisDel(K key) {
        redisTemplate.delete(getKey(key));
    }

    private String getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k);
        }
        return k.toString();
    }


    @Override
    public V get(K k) throws CacheException {
        Object o = redisGet(k);
        if (o != null) {
            return (V) o;
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        redisSet(k,v);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        Object o = redisGet(k);
        redisDel(k);
        if(o != null){
            return (V) o;
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
