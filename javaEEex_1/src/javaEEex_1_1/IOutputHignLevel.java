package javaEEex_1_1;

import java.util.Queue;

public interface IOutputHignLevel extends IOutput {
	@SuppressWarnings("rawtypes")
	Queue getQueueNow();// ��ҵ����

	String leftLink(int need);
}
