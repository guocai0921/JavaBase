package com.guocai.thread.thread11;

import java.util.Arrays;
import java.util.Optional;

/**
 * java类简单作用描述
 *
 * @ClassName: Main
 * @Package: com.guocai.thread.thread11
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 16:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Main {

	public void runMain(){
		Arrays.asList(Thread.currentThread().getStackTrace()).stream()
				.filter(e -> !e.isNativeMethod())
				.forEach(e -> Optional.of(e.getClassName()+":"+e.getMethodName()+":"+e.getLineNumber())
						.ifPresent(System.out::println)
				);
	}

}
