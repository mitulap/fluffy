// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: filedata.proto

package pipe.filedata;

public final class Filedata {
  private Filedata() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface FileDataInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:FileDataInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string filename = 1;</code>
     */
    boolean hasFilename();
    /**
     * <code>required string filename = 1;</code>
     */
    java.lang.String getFilename();
    /**
     * <code>required string filename = 1;</code>
     */
    com.google.protobuf.ByteString
        getFilenameBytes();

    /**
     * <code>required bytes data = 2;</code>
     */
    boolean hasData();
    /**
     * <code>required bytes data = 2;</code>
     */
    com.google.protobuf.ByteString getData();

    /**
     * <code>required int64 chunkblockid = 3;</code>
     */
    boolean hasChunkblockid();
    /**
     * <code>required int64 chunkblockid = 3;</code>
     */
    long getChunkblockid();

    /**
     * <code>required int64 filesize = 4;</code>
     */
    boolean hasFilesize();
    /**
     * <code>required int64 filesize = 4;</code>
     */
    long getFilesize();

    /**
     * <code>required int64 totalchunks = 5;</code>
     */
    boolean hasTotalchunks();
    /**
     * <code>required int64 totalchunks = 5;</code>
     */
    long getTotalchunks();
  }
  /**
   * Protobuf type {@code FileDataInfo}
   */
  public static final class FileDataInfo extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:FileDataInfo)
      FileDataInfoOrBuilder {
    // Use FileDataInfo.newBuilder() to construct.
    private FileDataInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private FileDataInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final FileDataInfo defaultInstance;
    public static FileDataInfo getDefaultInstance() {
      return defaultInstance;
    }

    public FileDataInfo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private FileDataInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              filename_ = bs;
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              data_ = input.readBytes();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              chunkblockid_ = input.readInt64();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              filesize_ = input.readInt64();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              totalchunks_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pipe.filedata.Filedata.internal_static_FileDataInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pipe.filedata.Filedata.internal_static_FileDataInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pipe.filedata.Filedata.FileDataInfo.class, pipe.filedata.Filedata.FileDataInfo.Builder.class);
    }

    public static com.google.protobuf.Parser<FileDataInfo> PARSER =
        new com.google.protobuf.AbstractParser<FileDataInfo>() {
      public FileDataInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new FileDataInfo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<FileDataInfo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int FILENAME_FIELD_NUMBER = 1;
    private java.lang.Object filename_;
    /**
     * <code>required string filename = 1;</code>
     */
    public boolean hasFilename() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string filename = 1;</code>
     */
    public java.lang.String getFilename() {
      java.lang.Object ref = filename_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          filename_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string filename = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFilenameBytes() {
      java.lang.Object ref = filename_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        filename_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATA_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString data_;
    /**
     * <code>required bytes data = 2;</code>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes data = 2;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    public static final int CHUNKBLOCKID_FIELD_NUMBER = 3;
    private long chunkblockid_;
    /**
     * <code>required int64 chunkblockid = 3;</code>
     */
    public boolean hasChunkblockid() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required int64 chunkblockid = 3;</code>
     */
    public long getChunkblockid() {
      return chunkblockid_;
    }

    public static final int FILESIZE_FIELD_NUMBER = 4;
    private long filesize_;
    /**
     * <code>required int64 filesize = 4;</code>
     */
    public boolean hasFilesize() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int64 filesize = 4;</code>
     */
    public long getFilesize() {
      return filesize_;
    }

    public static final int TOTALCHUNKS_FIELD_NUMBER = 5;
    private long totalchunks_;
    /**
     * <code>required int64 totalchunks = 5;</code>
     */
    public boolean hasTotalchunks() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required int64 totalchunks = 5;</code>
     */
    public long getTotalchunks() {
      return totalchunks_;
    }

    private void initFields() {
      filename_ = "";
      data_ = com.google.protobuf.ByteString.EMPTY;
      chunkblockid_ = 0L;
      filesize_ = 0L;
      totalchunks_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasFilename()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasData()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasChunkblockid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasFilesize()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTotalchunks()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getFilenameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, data_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt64(3, chunkblockid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt64(4, filesize_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt64(5, totalchunks_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getFilenameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, data_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, chunkblockid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(4, filesize_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, totalchunks_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static pipe.filedata.Filedata.FileDataInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(pipe.filedata.Filedata.FileDataInfo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code FileDataInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:FileDataInfo)
        pipe.filedata.Filedata.FileDataInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return pipe.filedata.Filedata.internal_static_FileDataInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return pipe.filedata.Filedata.internal_static_FileDataInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                pipe.filedata.Filedata.FileDataInfo.class, pipe.filedata.Filedata.FileDataInfo.Builder.class);
      }

      // Construct using pipe.filedata.Filedata.FileDataInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        filename_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        data_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        chunkblockid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        filesize_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000008);
        totalchunks_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return pipe.filedata.Filedata.internal_static_FileDataInfo_descriptor;
      }

      public pipe.filedata.Filedata.FileDataInfo getDefaultInstanceForType() {
        return pipe.filedata.Filedata.FileDataInfo.getDefaultInstance();
      }

      public pipe.filedata.Filedata.FileDataInfo build() {
        pipe.filedata.Filedata.FileDataInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public pipe.filedata.Filedata.FileDataInfo buildPartial() {
        pipe.filedata.Filedata.FileDataInfo result = new pipe.filedata.Filedata.FileDataInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.filename_ = filename_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.data_ = data_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.chunkblockid_ = chunkblockid_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.filesize_ = filesize_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.totalchunks_ = totalchunks_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof pipe.filedata.Filedata.FileDataInfo) {
          return mergeFrom((pipe.filedata.Filedata.FileDataInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(pipe.filedata.Filedata.FileDataInfo other) {
        if (other == pipe.filedata.Filedata.FileDataInfo.getDefaultInstance()) return this;
        if (other.hasFilename()) {
          bitField0_ |= 0x00000001;
          filename_ = other.filename_;
          onChanged();
        }
        if (other.hasData()) {
          setData(other.getData());
        }
        if (other.hasChunkblockid()) {
          setChunkblockid(other.getChunkblockid());
        }
        if (other.hasFilesize()) {
          setFilesize(other.getFilesize());
        }
        if (other.hasTotalchunks()) {
          setTotalchunks(other.getTotalchunks());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasFilename()) {
          
          return false;
        }
        if (!hasData()) {
          
          return false;
        }
        if (!hasChunkblockid()) {
          
          return false;
        }
        if (!hasFilesize()) {
          
          return false;
        }
        if (!hasTotalchunks()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        pipe.filedata.Filedata.FileDataInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (pipe.filedata.Filedata.FileDataInfo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object filename_ = "";
      /**
       * <code>required string filename = 1;</code>
       */
      public boolean hasFilename() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string filename = 1;</code>
       */
      public java.lang.String getFilename() {
        java.lang.Object ref = filename_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            filename_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string filename = 1;</code>
       */
      public com.google.protobuf.ByteString
          getFilenameBytes() {
        java.lang.Object ref = filename_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          filename_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string filename = 1;</code>
       */
      public Builder setFilename(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        filename_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string filename = 1;</code>
       */
      public Builder clearFilename() {
        bitField0_ = (bitField0_ & ~0x00000001);
        filename_ = getDefaultInstance().getFilename();
        onChanged();
        return this;
      }
      /**
       * <code>required string filename = 1;</code>
       */
      public Builder setFilenameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        filename_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes data = 2;</code>
       */
      public boolean hasData() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes data = 2;</code>
       */
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <code>required bytes data = 2;</code>
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes data = 2;</code>
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000002);
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }

      private long chunkblockid_ ;
      /**
       * <code>required int64 chunkblockid = 3;</code>
       */
      public boolean hasChunkblockid() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required int64 chunkblockid = 3;</code>
       */
      public long getChunkblockid() {
        return chunkblockid_;
      }
      /**
       * <code>required int64 chunkblockid = 3;</code>
       */
      public Builder setChunkblockid(long value) {
        bitField0_ |= 0x00000004;
        chunkblockid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 chunkblockid = 3;</code>
       */
      public Builder clearChunkblockid() {
        bitField0_ = (bitField0_ & ~0x00000004);
        chunkblockid_ = 0L;
        onChanged();
        return this;
      }

      private long filesize_ ;
      /**
       * <code>required int64 filesize = 4;</code>
       */
      public boolean hasFilesize() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int64 filesize = 4;</code>
       */
      public long getFilesize() {
        return filesize_;
      }
      /**
       * <code>required int64 filesize = 4;</code>
       */
      public Builder setFilesize(long value) {
        bitField0_ |= 0x00000008;
        filesize_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 filesize = 4;</code>
       */
      public Builder clearFilesize() {
        bitField0_ = (bitField0_ & ~0x00000008);
        filesize_ = 0L;
        onChanged();
        return this;
      }

      private long totalchunks_ ;
      /**
       * <code>required int64 totalchunks = 5;</code>
       */
      public boolean hasTotalchunks() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required int64 totalchunks = 5;</code>
       */
      public long getTotalchunks() {
        return totalchunks_;
      }
      /**
       * <code>required int64 totalchunks = 5;</code>
       */
      public Builder setTotalchunks(long value) {
        bitField0_ |= 0x00000010;
        totalchunks_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 totalchunks = 5;</code>
       */
      public Builder clearTotalchunks() {
        bitField0_ = (bitField0_ & ~0x00000010);
        totalchunks_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:FileDataInfo)
    }

    static {
      defaultInstance = new FileDataInfo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:FileDataInfo)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FileDataInfo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_FileDataInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016filedata.proto\032\014common.proto\"k\n\014FileDa" +
      "taInfo\022\020\n\010filename\030\001 \002(\t\022\014\n\004data\030\002 \002(\014\022\024" +
      "\n\014chunkblockid\030\003 \002(\003\022\020\n\010filesize\030\004 \002(\003\022\023" +
      "\n\013totalchunks\030\005 \002(\003B\021\n\rpipe.filedataH\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          pipe.common.Common.getDescriptor(),
        }, assigner);
    internal_static_FileDataInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_FileDataInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_FileDataInfo_descriptor,
        new java.lang.String[] { "Filename", "Data", "Chunkblockid", "Filesize", "Totalchunks", });
    pipe.common.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
