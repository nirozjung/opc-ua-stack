package com.inductiveautomation.opcua.stack.core.types.structured;

import com.inductiveautomation.opcua.stack.core.Identifiers;
import com.inductiveautomation.opcua.stack.core.serialization.DelegateRegistry;
import com.inductiveautomation.opcua.stack.core.serialization.UaDecoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaEncoder;
import com.inductiveautomation.opcua.stack.core.serialization.UaStructure;
import com.inductiveautomation.opcua.stack.core.types.builtin.LocalizedText;
import com.inductiveautomation.opcua.stack.core.types.builtin.NodeId;
import com.inductiveautomation.opcua.stack.core.types.enumerated.ApplicationType;

public class ApplicationDescription implements UaStructure {

    public static final NodeId TypeId = Identifiers.ApplicationDescription;
    public static final NodeId BinaryEncodingId = Identifiers.ApplicationDescription_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.ApplicationDescription_Encoding_DefaultXml;

    protected final String _applicationUri;
    protected final String _productUri;
    protected final LocalizedText _applicationName;
    protected final ApplicationType _applicationType;
    protected final String _gatewayServerUri;
    protected final String _discoveryProfileUri;
    protected final String[] _discoveryUrls;

    public ApplicationDescription(String _applicationUri, String _productUri, LocalizedText _applicationName, ApplicationType _applicationType, String _gatewayServerUri, String _discoveryProfileUri, String[] _discoveryUrls) {
        this._applicationUri = _applicationUri;
        this._productUri = _productUri;
        this._applicationName = _applicationName;
        this._applicationType = _applicationType;
        this._gatewayServerUri = _gatewayServerUri;
        this._discoveryProfileUri = _discoveryProfileUri;
        this._discoveryUrls = _discoveryUrls;
    }

    public String getApplicationUri() {
        return _applicationUri;
    }

    public String getProductUri() {
        return _productUri;
    }

    public LocalizedText getApplicationName() {
        return _applicationName;
    }

    public ApplicationType getApplicationType() {
        return _applicationType;
    }

    public String getGatewayServerUri() {
        return _gatewayServerUri;
    }

    public String getDiscoveryProfileUri() {
        return _discoveryProfileUri;
    }

    public String[] getDiscoveryUrls() {
        return _discoveryUrls;
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


    public static void encode(ApplicationDescription applicationDescription, UaEncoder encoder) {
        encoder.encodeString("ApplicationUri", applicationDescription._applicationUri);
        encoder.encodeString("ProductUri", applicationDescription._productUri);
        encoder.encodeLocalizedText("ApplicationName", applicationDescription._applicationName);
        encoder.encodeSerializable("ApplicationType", applicationDescription._applicationType);
        encoder.encodeString("GatewayServerUri", applicationDescription._gatewayServerUri);
        encoder.encodeString("DiscoveryProfileUri", applicationDescription._discoveryProfileUri);
        encoder.encodeArray("DiscoveryUrls", applicationDescription._discoveryUrls, encoder::encodeString);
    }

    public static ApplicationDescription decode(UaDecoder decoder) {
        String _applicationUri = decoder.decodeString("ApplicationUri");
        String _productUri = decoder.decodeString("ProductUri");
        LocalizedText _applicationName = decoder.decodeLocalizedText("ApplicationName");
        ApplicationType _applicationType = decoder.decodeSerializable("ApplicationType", ApplicationType.class);
        String _gatewayServerUri = decoder.decodeString("GatewayServerUri");
        String _discoveryProfileUri = decoder.decodeString("DiscoveryProfileUri");
        String[] _discoveryUrls = decoder.decodeArray("DiscoveryUrls", decoder::decodeString, String.class);

        return new ApplicationDescription(_applicationUri, _productUri, _applicationName, _applicationType, _gatewayServerUri, _discoveryProfileUri, _discoveryUrls);
    }

    static {
        DelegateRegistry.registerEncoder(ApplicationDescription::encode, ApplicationDescription.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(ApplicationDescription::decode, ApplicationDescription.class, BinaryEncodingId, XmlEncodingId);
    }

}
