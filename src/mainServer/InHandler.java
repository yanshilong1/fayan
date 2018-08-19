package mainServer;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import mysevlete.ServletTest;
import org.apache.log4j.Logger;
import pojo.Goods;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by jingbao on 18-6-23.
 */
public class InHandler extends ChannelInboundHandlerAdapter{
    private static Logger log = Logger.getLogger(InHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        log.info("InHandler :" + ctx);
        System.out.println("read");
        System.out.println("inboune recive"+msg);
        try {
//            System.out.println(msg.toString());
            FullHttpRequest fhr = (FullHttpRequest) msg;
            String url=fhr.uri();
//            ByteBuf result = (ByteBuf) msg;
//            byte[] result1 = new byte[result.readableBytes()];
//            result.readBytes(result1);
            System.out.println("请求的URL："+fhr);
            ByteBuf buf = fhr.content();
            HttpHeaders head=fhr.headers();
//            System.out.println( head.toString());
            byte[] result1 = new byte[buf.readableBytes()];
            buf.readBytes(result1);
            String data=new String(result1,"utf8");
            System.out.println("读取的数据："+data);
//            ServletTest.doServlet(fhr.uri(),new
//                    Gson().fromJson(data,Goods.class));



//            ByteBuf buf = fhr.content();
//            String message = buf.toString(io.netty.util.CharsetUtil.UTF_8);
//            buf.release();
            String tt =ServletTest.doServlet(fhr.uri(),data);
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                    OK, Unpooled.wrappedBuffer(tt.getBytes("UTF-8")));
            response.headers().set(CONTENT_TYPE, "application/json");
            response.headers().setInt(CONTENT_LENGTH,
                    response.content().readableBytes());
            if (HttpHeaderUtil.isKeepAlive(fhr)) {
                response.headers().set(CONNECTION, KEEP_ALIVE);
            }
            ctx.write(response);
            ctx.flush();
            System.out.println("write");
//            int a=5/0;
        }catch (Exception e){
            log.error("",e);
            e.printStackTrace();
        }
        //log.debug("--------------------------------------");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("*******************");
    }


}
