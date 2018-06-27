package com.guocai.thread.thread10;

/**
 * @Description: 给应用程序注入钩子程序，实现异常的处理；
 * @auther: Sun Guocai
 * @date:   2018/6/26 15:08
 * @name:
 * @param:
 * @return:
 *
 */
public class ExitCapture{
	public static void main(String[] args){
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
			System.out.println("The application will be exit.");
			notifyAndRelease();
		}));
	
		int i = 0;
		while(true){
			try{	
				Thread.sleep(3_000L);
				System.out.println("I am Working...");
			} catch(Exception e){
				//ignore
			} 
			i++;
			if(i>20){
				throw new RuntimeException("error");	
			}
		}
	
	}
	private static void notifyAndRelease(){
		System.out.println("notify to the admin.");
		try{
			Thread.sleep(1_000);
		} catch(Throwable e){}	
		System.out.println("Will release resource(socket,file,connection...)");
		try{
			Thread.sleep(1_000);
		} catch(Throwable e){}
		System.out.println("Release and Notify Done ...");
	}	
}
