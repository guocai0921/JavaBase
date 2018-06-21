package com.guocai.thread.thread2;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread2
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 11:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateThread5 {

	private static int count = 1;

	public static void main(String[] args) {
		try {
			for (int i = 0; i <Integer.MAX_VALUE ; i++) {
				count++;
				byte[] b = new byte[1024 * 1024 *2];
				new Thread(()->{
					while (true){

					}
				}).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
