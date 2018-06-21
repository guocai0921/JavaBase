package com.guocai.thread.thread0;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread0
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 7:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TemplateMethod {
	public final void print(String message){
		System.out.println("################");
		warpPrint(message);
		System.out.println("################");
	}

	protected void warpPrint(String message){

	}

	public static void main(String[] args) {
		TemplateMethod t1 = new TemplateMethod(){
			@Override
			protected void warpPrint(String message) {
				System.out.println("*"+message+"*");
			}
		};
		t1.print("hello thread0");
	}
}
