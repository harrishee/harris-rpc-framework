package com.hanfei.rpc.transport;

import com.hanfei.rpc.entity.RpcRequest;
import com.hanfei.rpc.serialize.CommonSerializer;

/**
 * RPC client interface
 *
 * @author: harris
 * @time: 2023
 * @summary: harris-rpc-framework
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);
}
