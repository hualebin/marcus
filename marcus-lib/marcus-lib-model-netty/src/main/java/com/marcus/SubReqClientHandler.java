package com.marcus;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(int i = 0; i < 10; i++){
			ctx.write(subReq(i));
		}
		ctx.flush();
	}
	
	private SubscribeReq subReq(int i) {
		SubscribeReq req= new SubscribeReq();
		req.setAddress("中国");
		req.setPhoneNumber("13570293738");
		req.setProductName("Netty");
		req.setSubReqID(i);
		req.setUserName("marcus");
		return req;
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("receive server response : [" + msg + "]");
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		cause.printStackTrace();
		ctx.close();
	}

}
