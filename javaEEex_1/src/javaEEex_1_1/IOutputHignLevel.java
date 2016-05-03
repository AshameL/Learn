package javaEEex_1_1;

import java.util.Queue;

public interface IOutputHignLevel extends IOutput {
	@SuppressWarnings("rawtypes")
	Queue getQueueNow();// 作业队列

	String leftLink(int need);
}
