package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author zh0809
 * @date 2020/11/3 11:11
 **/
public class ZhouHaoHttpRequestFilter implements HttpRequestFilter {

    final static String NIO_KEY = "nio";
    final static String NIO_VALUE = "zhouhao";

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        // 往请求头中添加一个新的key-value
        fullRequest.headers().add(NIO_KEY, NIO_VALUE);
    }
}
