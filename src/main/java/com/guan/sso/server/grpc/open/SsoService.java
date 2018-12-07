package com.guan.sso.server.grpc.open;

import com.guan.sso.server.entity.RedisDO;
import com.guan.sso.server.grpc.server.*;
import com.guan.sso.server.services.RedisService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

public class SsoService extends SsoServiceGrpc.SsoServiceImplBase {

    @Autowired
    private RedisService redisService;

    /**
     * 验证token是否有效
     */
    public void verifyToken(TokenRequest request, StreamObserver<TokenReply> responseObserver) {
        try {
            String token = request.getToken();
            long uid = 0L;
            if (redisService.has(token)) {
                RedisDO redisDO = redisService.get(token);
                uid = redisDO.getUid();
            }
            TokenReply reply = TokenReply.newBuilder().setUid(uid).build();
            responseObserver.onNext(reply);
        } catch (Exception e) {
            responseObserver.onError(e);
        }
        responseObserver.onCompleted();
    }

    /**
     * 退出单点登录
     */
    public void logout(LogoutRequest request, StreamObserver<LogoutReply> responseObserver) {
        try {
            String token = request.getToken();
            redisService.delete(token);
            LogoutReply reply = LogoutReply.newBuilder().build();
            responseObserver.onNext(reply);
        } catch (Exception e) {
            responseObserver.onError(e);
        }
        responseObserver.onCompleted();
    }

}
