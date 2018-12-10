package com.guan.sso.server.grpc.autoPro;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: serivce.proto")
public final class SsoServiceGrpc {

  private SsoServiceGrpc() {}

  public static final String SERVICE_NAME = "api.SsoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<TokenRequest,
      VerifyReply> getVerifyTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "verifyToken",
      requestType = TokenRequest.class,
      responseType = VerifyReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TokenRequest,
      VerifyReply> getVerifyTokenMethod() {
    io.grpc.MethodDescriptor<TokenRequest, VerifyReply> getVerifyTokenMethod;
    if ((getVerifyTokenMethod = SsoServiceGrpc.getVerifyTokenMethod) == null) {
      synchronized (SsoServiceGrpc.class) {
        if ((getVerifyTokenMethod = SsoServiceGrpc.getVerifyTokenMethod) == null) {
          SsoServiceGrpc.getVerifyTokenMethod = getVerifyTokenMethod =
              io.grpc.MethodDescriptor.<TokenRequest, VerifyReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "api.SsoService", "verifyToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  VerifyReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SsoServiceMethodDescriptorSupplier("verifyToken"))
                  .build();
          }
        }
     }
     return getVerifyTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TokenRequest,
      UserReply> getGetUserByTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserByToken",
      requestType = TokenRequest.class,
      responseType = UserReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TokenRequest,
      UserReply> getGetUserByTokenMethod() {
    io.grpc.MethodDescriptor<TokenRequest, UserReply> getGetUserByTokenMethod;
    if ((getGetUserByTokenMethod = SsoServiceGrpc.getGetUserByTokenMethod) == null) {
      synchronized (SsoServiceGrpc.class) {
        if ((getGetUserByTokenMethod = SsoServiceGrpc.getGetUserByTokenMethod) == null) {
          SsoServiceGrpc.getGetUserByTokenMethod = getGetUserByTokenMethod =
              io.grpc.MethodDescriptor.<TokenRequest, UserReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "api.SsoService", "getUserByToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UserReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SsoServiceMethodDescriptorSupplier("getUserByToken"))
                  .build();
          }
        }
     }
     return getGetUserByTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LogoutRequest,
      LogoutReply> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = LogoutRequest.class,
      responseType = LogoutReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LogoutRequest,
      LogoutReply> getLogoutMethod() {
    io.grpc.MethodDescriptor<LogoutRequest, LogoutReply> getLogoutMethod;
    if ((getLogoutMethod = SsoServiceGrpc.getLogoutMethod) == null) {
      synchronized (SsoServiceGrpc.class) {
        if ((getLogoutMethod = SsoServiceGrpc.getLogoutMethod) == null) {
          SsoServiceGrpc.getLogoutMethod = getLogoutMethod =
              io.grpc.MethodDescriptor.<LogoutRequest, LogoutReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "api.SsoService", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LogoutReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SsoServiceMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SsoServiceStub newStub(io.grpc.Channel channel) {
    return new SsoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SsoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SsoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SsoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SsoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SsoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void verifyToken(TokenRequest request,
        io.grpc.stub.StreamObserver<VerifyReply> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyTokenMethod(), responseObserver);
    }

    /**
     */
    public void getUserByToken(TokenRequest request,
        io.grpc.stub.StreamObserver<UserReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByTokenMethod(), responseObserver);
    }

    /**
     */
    public void logout(LogoutRequest request,
        io.grpc.stub.StreamObserver<LogoutReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerifyTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TokenRequest,
                VerifyReply>(
                  this, METHODID_VERIFY_TOKEN)))
          .addMethod(
            getGetUserByTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TokenRequest,
                UserReply>(
                  this, METHODID_GET_USER_BY_TOKEN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LogoutRequest,
                LogoutReply>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class SsoServiceStub extends io.grpc.stub.AbstractStub<SsoServiceStub> {
    private SsoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SsoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SsoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SsoServiceStub(channel, callOptions);
    }

    /**
     */
    public void verifyToken(TokenRequest request,
        io.grpc.stub.StreamObserver<VerifyReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByToken(TokenRequest request,
        io.grpc.stub.StreamObserver<UserReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(LogoutRequest request,
        io.grpc.stub.StreamObserver<LogoutReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SsoServiceBlockingStub extends io.grpc.stub.AbstractStub<SsoServiceBlockingStub> {
    private SsoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SsoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SsoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SsoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public VerifyReply verifyToken(TokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerifyTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public UserReply getUserByToken(TokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public LogoutReply logout(LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SsoServiceFutureStub extends io.grpc.stub.AbstractStub<SsoServiceFutureStub> {
    private SsoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SsoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SsoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SsoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<VerifyReply> verifyToken(
        TokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserReply> getUserByToken(
        TokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LogoutReply> logout(
        LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFY_TOKEN = 0;
  private static final int METHODID_GET_USER_BY_TOKEN = 1;
  private static final int METHODID_LOGOUT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SsoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SsoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFY_TOKEN:
          serviceImpl.verifyToken((TokenRequest) request,
              (io.grpc.stub.StreamObserver<VerifyReply>) responseObserver);
          break;
        case METHODID_GET_USER_BY_TOKEN:
          serviceImpl.getUserByToken((TokenRequest) request,
              (io.grpc.stub.StreamObserver<UserReply>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((LogoutRequest) request,
              (io.grpc.stub.StreamObserver<LogoutReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SsoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SsoServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SsoServerProtos.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SsoService");
    }
  }

  private static final class SsoServiceFileDescriptorSupplier
      extends SsoServiceBaseDescriptorSupplier {
    SsoServiceFileDescriptorSupplier() {}
  }

  private static final class SsoServiceMethodDescriptorSupplier
      extends SsoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SsoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SsoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SsoServiceFileDescriptorSupplier())
              .addMethod(getVerifyTokenMethod())
              .addMethod(getGetUserByTokenMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
