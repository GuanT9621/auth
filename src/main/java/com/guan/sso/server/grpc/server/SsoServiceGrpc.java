package com.guan.sso.server.grpc.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: serivce.proto")
public final class SsoServiceGrpc {

  private SsoServiceGrpc() {}

  public static final String SERVICE_NAME = "api.SsoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<TokenRequest,
      TokenReply> METHOD_VERIFY_TOKEN =
      io.grpc.MethodDescriptor.<TokenRequest, TokenReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "api.SsoService", "verifyToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              TokenRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              TokenReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<LogoutRequest,
      LogoutReply> METHOD_LOGOUT =
      io.grpc.MethodDescriptor.<LogoutRequest, LogoutReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "api.SsoService", "logout"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              LogoutRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              LogoutReply.getDefaultInstance()))
          .build();

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
        io.grpc.stub.StreamObserver<TokenReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_VERIFY_TOKEN, responseObserver);
    }

    /**
     */
    public void logout(LogoutRequest request,
        io.grpc.stub.StreamObserver<LogoutReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGOUT, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_VERIFY_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                TokenRequest,
                TokenReply>(
                  this, METHODID_VERIFY_TOKEN)))
          .addMethod(
            METHOD_LOGOUT,
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
        io.grpc.stub.StreamObserver<TokenReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_VERIFY_TOKEN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(LogoutRequest request,
        io.grpc.stub.StreamObserver<LogoutReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGOUT, getCallOptions()), request, responseObserver);
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
    public TokenReply verifyToken(TokenRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_VERIFY_TOKEN, getCallOptions(), request);
    }

    /**
     */
    public LogoutReply logout(LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGOUT, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<TokenReply> verifyToken(
        TokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_VERIFY_TOKEN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LogoutReply> logout(
        LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGOUT, getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFY_TOKEN = 0;
  private static final int METHODID_LOGOUT = 1;

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
              (io.grpc.stub.StreamObserver<TokenReply>) responseObserver);
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

  private static final class SsoServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SsoServerProtos.getDescriptor();
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
              .setSchemaDescriptor(new SsoServiceDescriptorSupplier())
              .addMethod(METHOD_VERIFY_TOKEN)
              .addMethod(METHOD_LOGOUT)
              .build();
        }
      }
    }
    return result;
  }
}
