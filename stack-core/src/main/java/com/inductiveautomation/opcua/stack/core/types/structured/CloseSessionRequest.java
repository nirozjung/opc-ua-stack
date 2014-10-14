package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaRequestMessage;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;

public class CloseSessionRequest implements UaRequestMessage {

    public static final NodeId TypeId = Identifiers.CloseSessionRequest;
    public static final NodeId BinaryEncodingId = Identifiers.CloseSessionRequest_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.CloseSessionRequest_Encoding_DefaultXml;

    protected final RequestHeader _requestHeader;
    protected final Boolean _deleteSubscriptions;

    public CloseSessionRequest(RequestHeader _requestHeader, Boolean _deleteSubscriptions) {
        this._requestHeader = _requestHeader;
        this._deleteSubscriptions = _deleteSubscriptions;
    }

    public RequestHeader getRequestHeader() {
        return _requestHeader;
    }

    public Boolean getDeleteSubscriptions() {
        return _deleteSubscriptions;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(CloseSessionRequest closeSessionRequest, UaEncoder encoder) {
        encoder.encodeSerializable("RequestHeader", closeSessionRequest._requestHeader);
        encoder.encodeBoolean("DeleteSubscriptions", closeSessionRequest._deleteSubscriptions);
    }

    public static CloseSessionRequest decode(UaDecoder decoder) {
        RequestHeader _requestHeader = decoder.decodeSerializable("RequestHeader", RequestHeader.class);
        Boolean _deleteSubscriptions = decoder.decodeBoolean("DeleteSubscriptions");

        return new CloseSessionRequest(_requestHeader, _deleteSubscriptions);
    }

    static {
        DelegateRegistry.registerEncoder(CloseSessionRequest::encode, CloseSessionRequest.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(CloseSessionRequest::decode, CloseSessionRequest.class, BinaryEncodingId, XmlEncodingId);
    }

}
