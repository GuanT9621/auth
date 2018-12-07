// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serivce.proto

package com.guan.sso.server.grpc.server;

/**
 * Protobuf type {@code api.LogoutRequest}
 */
public  final class LogoutRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.LogoutRequest)
    LogoutRequestOrBuilder {
  // Use LogoutRequest.newBuilder() to construct.
  private LogoutRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogoutRequest() {
    token_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private LogoutRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            token_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return SsoServerProtos.internal_static_api_LogoutRequest_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return SsoServerProtos.internal_static_api_LogoutRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            LogoutRequest.class, LogoutRequest.Builder.class);
  }

  public static final int TOKEN_FIELD_NUMBER = 1;
  private volatile Object token_;
  /**
   * <code>string token = 1;</code>
   */
  public String getToken() {
    Object ref = token_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTokenBytes() {
    Object ref = token_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, token_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, token_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof LogoutRequest)) {
      return super.equals(obj);
    }
    LogoutRequest other = (LogoutRequest) obj;

    boolean result = true;
    result = result && getToken()
        .equals(other.getToken());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static LogoutRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LogoutRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LogoutRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LogoutRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LogoutRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static LogoutRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static LogoutRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static LogoutRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static LogoutRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static LogoutRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static LogoutRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static LogoutRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(LogoutRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code api.LogoutRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.LogoutRequest)
      LogoutRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return SsoServerProtos.internal_static_api_LogoutRequest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return SsoServerProtos.internal_static_api_LogoutRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              LogoutRequest.class, LogoutRequest.Builder.class);
    }

    // Construct using com.guan.sso.server.grpc.server.LogoutRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      token_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return SsoServerProtos.internal_static_api_LogoutRequest_descriptor;
    }

    public LogoutRequest getDefaultInstanceForType() {
      return LogoutRequest.getDefaultInstance();
    }

    public LogoutRequest build() {
      LogoutRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public LogoutRequest buildPartial() {
      LogoutRequest result = new LogoutRequest(this);
      result.token_ = token_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof LogoutRequest) {
        return mergeFrom((LogoutRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(LogoutRequest other) {
      if (other == LogoutRequest.getDefaultInstance()) return this;
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      LogoutRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (LogoutRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object token_ = "";
    /**
     * <code>string token = 1;</code>
     */
    public String getToken() {
      Object ref = token_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string token = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 1;</code>
     */
    public Builder setToken(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 1;</code>
     */
    public Builder clearToken() {

      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>string token = 1;</code>
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      token_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:api.LogoutRequest)
  }

  // @@protoc_insertion_point(class_scope:api.LogoutRequest)
  private static final LogoutRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new LogoutRequest();
  }

  public static LogoutRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogoutRequest>
      PARSER = new com.google.protobuf.AbstractParser<LogoutRequest>() {
    public LogoutRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LogoutRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogoutRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<LogoutRequest> getParserForType() {
    return PARSER;
  }

  public LogoutRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

