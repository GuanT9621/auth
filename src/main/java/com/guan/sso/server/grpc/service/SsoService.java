package com.guan.sso.server.grpc.service;

import com.guan.sso.server.entity.RedisDO;
import com.guan.sso.server.grpc.autoPro.*;
import com.guan.sso.server.services.RedisService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.guan.sso.server.constant.GlobalValue.TOKEN_ALIVE_TIME;

@Service
public class SsoService extends SsoServiceGrpc.SsoServiceImplBase {

    @Autowired
    private RedisService redisService;

    /**
     * 验证token是否有效
     */
    @Override
    public void verifyToken(TokenRequest request, StreamObserver<VerifyReply> responseObserver) {
        String token = request.getToken();
        try {
            VerifyReply reply = VerifyReply.newBuilder().setReal(redisService.has(token, TOKEN_ALIVE_TIME)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getUserByToken(TokenRequest request, StreamObserver<UserReply> responseObserver) {
        String token = request.getToken();
        long uid = 0L;
        try {
            if (redisService.has(token, TOKEN_ALIVE_TIME)) {
                RedisDO redisDO = redisService.get(token);
                uid = redisDO.getUid();
            }
            UserReply reply = UserReply.newBuilder().setUid(uid).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    /**
     * 退出单点登录
     */
    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutReply> responseObserver) {
        try {
            String token = request.getToken();
            redisService.delete(token);
            LogoutReply reply = LogoutReply.newBuilder().setReal(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

}
