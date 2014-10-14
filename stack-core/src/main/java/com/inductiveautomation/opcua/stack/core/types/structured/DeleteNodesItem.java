package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;

public class DeleteNodesItem implements UaStructure {

    public static final NodeId TypeId = Identifiers.DeleteNodesItem;
    public static final NodeId BinaryEncodingId = Identifiers.DeleteNodesItem_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.DeleteNodesItem_Encoding_DefaultXml;

    protected final NodeId _nodeId;
    protected final Boolean _deleteTargetReferences;

    public DeleteNodesItem(NodeId _nodeId, Boolean _deleteTargetReferences) {
        this._nodeId = _nodeId;
        this._deleteTargetReferences = _deleteTargetReferences;
    }

    public NodeId getNodeId() {
        return _nodeId;
    }

    public Boolean getDeleteTargetReferences() {
        return _deleteTargetReferences;
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


    public static void encode(DeleteNodesItem deleteNodesItem, UaEncoder encoder) {
        encoder.encodeNodeId("NodeId", deleteNodesItem._nodeId);
        encoder.encodeBoolean("DeleteTargetReferences", deleteNodesItem._deleteTargetReferences);
    }

    public static DeleteNodesItem decode(UaDecoder decoder) {
        NodeId _nodeId = decoder.decodeNodeId("NodeId");
        Boolean _deleteTargetReferences = decoder.decodeBoolean("DeleteTargetReferences");

        return new DeleteNodesItem(_nodeId, _deleteTargetReferences);
    }

    static {
        DelegateRegistry.registerEncoder(DeleteNodesItem::encode, DeleteNodesItem.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(DeleteNodesItem::decode, DeleteNodesItem.class, BinaryEncodingId, XmlEncodingId);
    }

}
