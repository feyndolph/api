package kube.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("token")
public class Token {
    String token;
    @TimeToLive
    Integer expiration;
}
