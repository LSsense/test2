package test2;

import java.util.Collections;

import javax.swing.table.DefaultTableModel;

public class Shownum {//将界面与后面运行代码连接模块
	static public void show_worklist(int a[][],int time_now)//展现作业队列
	{
		int i,row=0;
		Object[][] obj = new Object[8][4];
		int time_begin=time_now-10;
		for( i=0;i<a.length;i++)
		 { 
			 if(a[i][2]>time_begin&&a[i][2]<=time_now)
			 {
				 
				 obj[row][0]=a[i][0];
				 obj[row][1]=a[i][1];
				 obj[row][2]=a[i][2];
				 obj[row][3]=a[i][3];
				 row++;
				 Control.AddtoReady_sored(new PCB(worklist.Return_work(i),time_now));
				 }
		 }
		JFInfo.table_3.setModel(new DefaultTableModel(
				obj,
				new String[] {
					"ID", "Priority", "InTimes", "InstrucNum"
				}
			));
	}
	static public void show__textField()//展现时间秒数
	{
		JFInfo.textField.setText(Time.time_now()+"s");
	}
	static public void show_Memory() {//展现位示图
		int j,i;
		Object[][] obj = new Object[16][10];
		for( i=0;i<Memory.memory.length;i++) 
			 for(j=0;j<Memory.memory[i].length;j++)
				 obj[i][j]=Memory.memory[i][j];
		JFInfo.table_4.setModel(new DefaultTableModel(
				obj,
				new String[] {
					"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
				}
			));
	}
	static public void show_message(String str) {//显示作业信息调度信息
		JFInfo.textArea.append(str+"\n");
		JFInfo.textArea.setCaretPosition(JFInfo.textArea.getDocument().getLength());
	}
	public static void show_reReadyQueue() {//显示就绪队列
		int i;
		Object[][] obj=new Object[7][1];
		for(i=0;i<Control.reReady_queue.size();i++)
		{
			PCB temp=Control.reReady_queue.get(i);
			obj[i][0]=temp.ProID;
		}
		JFInfo.table.setModel(new DefaultTableModel(
				obj,
				new String[] {
					"\u5C31\u7EEA"
				}
			));
	} 
	public static void show_End_queue()//显示结束对列
	{
		int i;
		Object[][] obj=new Object[7][1];
		for(i=0;i<Control.End_queue.size();i++)
		{
			PCB temp=Control.End_queue.get(i);
			obj[i][0]=temp.ProID;
		}
		JFInfo.table_5.setModel(new DefaultTableModel(
				obj,
				new String[] {
						"\u7ED3\u675F\u961F\u5217"
				}
			));
	}
	public static void show_Block_the_queue1()//显示阻塞对列1
	{
		int i;
		Object[][] obj=new Object[7][1];
		for(i=0;i<Control.Block_the_queue1.size();i++)
		{
			PCB temp=Control.Block_the_queue1.get(i);
			obj[i][0]=temp.ProID;
		}
		JFInfo.table_1.setModel(new DefaultTableModel(
				obj,
				new String[] {
						"\u7B49\u5F851"
				}
			));
	}
	public static void show_Block_the_queue2()//显示阻塞对列2
	{
		int i;
		Object[][] obj=new Object[7][1];
		for(i=0;i<Control.Block_the_queue2.size();i++)
		{
			PCB temp=Control.Block_the_queue2.get(i);
			obj[i][0]=temp.ProID;
		}
		JFInfo.table_2.setModel(new DefaultTableModel(
				obj,
				new String[] {
						"\u7B49\u5F852"
				}
			));
	}
}
