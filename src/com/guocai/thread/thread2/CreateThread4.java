package com.guocai.thread.thread2;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread2
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 11:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateThread4 {

	private static int counter = 1;

	public static void main(String[] args) {
		Thread t1 = new Thread(null,new Runnable(){

			@Override
			public void run() {
				try {
					add(1);
				} catch (Error e) {

					System.out.println(counter);//130257
				}
			}
			private void add(int i) {
				counter++;
				add(i+1);

			}
		},"test",1<<23);
		t1.start();
	}

}
