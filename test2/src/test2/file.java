package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class file {
	public  static int[][] getSparseArrayFromFile(String filepath){//读文件，返回int数组（work）
        //将稀疏矩阵从文件中读取出来
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        int line_num=getFileLineNum(filepath)-1;
        int[][] datas = new int[line_num][4];
        try {
      	  File file = new File(filepath);
      	  FileInputStream fis= new FileInputStream(filepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if(null != line){
                    //将按行读取的字符串按空格分割，得到一个string数组
                    String[] strings = line.split(",");
                    //依次转换为int类型存入到分配好空间的数组中
                    for(int k = 0;k<strings.length;k++){
                        datas[i][k] = Integer.valueOf(strings[k]);
                    }
                    //行数加1
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回读取的二维数组
        return datas;    
}
	public  static int[][] getSparseArrayFromFile2(String filepath){//读文件，返回int数组（Instruct）
        //将稀疏矩阵从文件中读取出来
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        int line_num=getFileLineNum(filepath)-1;
        int[][] datas = new int[line_num][3];
        try {
      	  File file = new File(filepath);
      	  FileInputStream fis= new FileInputStream(filepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if(null != line){
                    //将按行读取的字符串按空格分割，得到一个string数组
                	String[] strings = line.split(",");
                    //依次转换为int类型存入到分配好空间的数组中
                    for(int k = 0;k<3;k++){
                        datas[i][k] = Integer.valueOf(strings[k]);
                    }
                    //行数加1
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回读取的二维数组
        return datas;    
}
	public static void writer(String content,String filePath)//将一串字符写入文件
	{
		 FileWriter fwriter = null;
	        try {
	            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
	            fwriter = new FileWriter(filePath, true);
	            fwriter.write(content);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                fwriter.flush();
	                fwriter.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	}
	public static void writer_to_file(ArrayList<String> AllText,String filepath)//将list内的字符写入文件
	{
        //遍历集合，写出集合数据
        BufferedWriter bfw;
		try {
			bfw = new BufferedWriter(new FileWriter(filepath));
			for (String s : AllText) {
            bfw.write(s);//通过高效流向txt文件中写入集合中的字符串元素；
            bfw.newLine();//换行
            bfw.flush();//刷新
        }
        //释放资源
        bfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	public static int getFileLineNum(String filePath) {//获取文本文件的行数
	    try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))){
	        lineNumberReader.skip(Long.MAX_VALUE);
	        int lineNumber = lineNumberReader.getLineNumber();
	        return lineNumber + 1;//实际上是读取换行符数量 , 所以需要+1
	    } catch (IOException e) {
	        return -1;
	    }
	}

}
