package com.guocai.thread.thread2;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread2
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 10:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateThread3 {//类信息，修饰符等放到方法区

	private static int a = 1;//存放虚拟机栈中

	private byte[] b = new byte[1024];//具体数据会放到堆中，b的地址会存到方法区中

	public static void main(String[] args) {
		/*int j = 0;//放到局部变量表中

		byte[] b = new byte[1024];//体数据会放到局部变量表中，b的地址会存到方法区中

		System.out.println(1<<23);//1*2^23=8388608
		System.out.println(8388608>>23);
		*/

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					add(1);
				} catch (Error e) {

					System.out.println(a);//35500
				}

			}
			private void add(int i) {
				a++;
				add(i+1);

			}
		});

		t.start();

	}



}
