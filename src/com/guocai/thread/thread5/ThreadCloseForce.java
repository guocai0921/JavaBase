package com.guocai.thread.thread5;

import java.time.Duration;
import java.time.Instant;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread5
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 8:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadCloseForce {
	public static void main(String[] args) {

		Instant start = Instant.now();
		for (int i = 0; i <10 ; i++) {
			System.out.println(i);
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());


	}
}
