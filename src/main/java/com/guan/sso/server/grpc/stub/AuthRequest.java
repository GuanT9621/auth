// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: auth_data.proto

package com.guan.sso.server.grpc.stub;

/**
 * Protobuf type {@code AuthRequest}
 */
public  final class AuthRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AuthRequest)
    AuthRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AuthRequest.newBuilder() to construct.
  private AuthRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AuthRequest() {
    acn_ = "";
    pwd_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AuthRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            acn_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            pwd_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return UmsAuthServiceProto.internal_static_AuthRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UmsAuthServiceProto.internal_static_AuthRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AuthRequest.class, AuthRequest.Builder.class);
  }

  public static final int ACN_FIELD_NUMBER = 1;
  private volatile Object acn_;
  /**
   * <code>string acn = 1;</code>
   */
  public String getAcn() {
    Object ref = acn_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      acn_ = s;
      return s;
    }
  }
  /**
   * <code>string acn = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAcnBytes() {
    Object ref = acn_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      acn_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PWD_FIELD_NUMBER = 2;
  private volatile Object pwd_;
  /**
   * <code>string pwd = 2;</code>
   */
  public String getPwd() {
    Object ref = pwd_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      pwd_ = s;
      return s;
    }
  }
  /**
   * <code>string pwd = 2;</code>
   */
  public com.google.protobuf.ByteString
      getPwdBytes() {
    Object ref = pwd_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      pwd_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAcnBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, acn_);
    }
    if (!getPwdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, pwd_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAcnBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, acn_);
    }
    if (!getPwdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, pwd_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof AuthRequest)) {
      return super.equals(obj);
    }
    AuthRequest other = (AuthRequest) obj;

    boolean result = true;
    result = result && getAcn()
        .equals(other.getAcn());
    result = result && getPwd()
        .equals(other.getPwd());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACN_FIELD_NUMBER;
    hash = (53 * hash) + getAcn().hashCode();
    hash = (37 * hash) + PWD_FIELD_NUMBER;
    hash = (53 * hash) + getPwd().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AuthRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AuthRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AuthRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AuthRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AuthRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AuthRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AuthRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AuthRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AuthRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AuthRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AuthRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AuthRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AuthRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
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
   * Protobuf type {@code AuthRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AuthRequest)
      AuthRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UmsAuthServiceProto.internal_static_AuthRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UmsAuthServiceProto.internal_static_AuthRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AuthRequest.class, AuthRequest.Builder.class);
    }

    // Construct using com.guan.ums.core.grpc.auth.AuthRequest.newBuilder()
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
    @Override
    public Builder clear() {
      super.clear();
      acn_ = "";

      pwd_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UmsAuthServiceProto.internal_static_AuthRequest_descriptor;
    }

    @Override
    public AuthRequest getDefaultInstanceForType() {
      return AuthRequest.getDefaultInstance();
    }

    @Override
    public AuthRequest build() {
      AuthRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AuthRequest buildPartial() {
      AuthRequest result = new AuthRequest(this);
      result.acn_ = acn_;
      result.pwd_ = pwd_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof AuthRequest) {
        return mergeFrom((AuthRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AuthRequest other) {
      if (other == AuthRequest.getDefaultInstance()) return this;
      if (!other.getAcn().isEmpty()) {
        acn_ = other.acn_;
        onChanged();
      }
      if (!other.getPwd().isEmpty()) {
        pwd_ = other.pwd_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      AuthRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AuthRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object acn_ = "";
    /**
     * <code>string acn = 1;</code>
     */
    public String getAcn() {
      Object ref = acn_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        acn_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string acn = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAcnBytes() {
      Object ref = acn_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        acn_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string acn = 1;</code>
     */
    public Builder setAcn(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      acn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string acn = 1;</code>
     */
    public Builder clearAcn() {

      acn_ = getDefaultInstance().getAcn();
      onChanged();
      return this;
    }
    /**
     * <code>string acn = 1;</code>
     */
    public Builder setAcnBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      acn_ = value;
      onChanged();
      return this;
    }

    private Object pwd_ = "";
    /**
     * <code>string pwd = 2;</code>
     */
    public String getPwd() {
      Object ref = pwd_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        pwd_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string pwd = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPwdBytes() {
      Object ref = pwd_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        pwd_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string pwd = 2;</code>
     */
    public Builder setPwd(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      pwd_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string pwd = 2;</code>
     */
    public Builder clearPwd() {

      pwd_ = getDefaultInstance().getPwd();
      onChanged();
      return this;
    }
    /**
     * <code>string pwd = 2;</code>
     */
    public Builder setPwdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      pwd_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:AuthRequest)
  }

  // @@protoc_insertion_point(class_scope:AuthRequest)
  private static final AuthRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AuthRequest();
  }

  public static AuthRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuthRequest>
      PARSER = new com.google.protobuf.AbstractParser<AuthRequest>() {
    @Override
    public AuthRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AuthRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AuthRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AuthRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public AuthRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

