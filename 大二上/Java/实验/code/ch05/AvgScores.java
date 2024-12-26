package cn.edu.zjut.java.ch05;

public class AvgScores {
	public static void main(String args[]) {
		String names[] = { "张国荣", "丁二", "陈坤" }; // 三位同学的姓名
		// 三门课程的成绩
		int[][] iScores = { { 89, 98, 87 }, { 90, 88, 95 }, { 86, 92, 93 } };
		for (int i = 0; i < iScores.length; i++) {
			double avg = 0.0; // 初始化每个同学的平均成绩
			int count = 0;
			for (int j = 0; j < iScores[i].length; j++) {
				avg += iScores[i][j]; // 先用avg保存三门课程的总和
				count++;
			} // for j
			avg = avg / count; // 此时的j表示一共有几门课
			System.out.printf("%s:%2.0f\n", names[i], avg); // 格式化输出 

		} // for i
	} // main
}
