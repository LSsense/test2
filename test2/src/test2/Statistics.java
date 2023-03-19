package test2;

import java.util.ArrayList;

public class Statistics {
	public static ArrayList<String> string=new ArrayList<String>();//进程调度信息存储
	public static String OutputBlock=new String("BBBB:[OutBlock_thread:");//outputBlock
	public static String InputBlock=new String("BBBB:[InputBlock_thread:");//InputBlock
	public static void Add_str(String temp) {//添加信息到输出框，加入String
		string.add(temp);
		Shownum.show_message(temp);
	}

}
