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
	public  static int[][] getSparseArrayFromFile(String filepath){//���ļ�������int���飨work��
        //��ϡ�������ļ��ж�ȡ����
        BufferedReader bufferedReader = null;
        //Ϊ������������ռ�
        int line_num=getFileLineNum(filepath)-1;
        int[][] datas = new int[line_num][4];
        try {
      	  File file = new File(filepath);
      	  FileInputStream fis= new FileInputStream(filepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //���ж�ȡ
            while((line = bufferedReader.readLine() )!= null){
                if(null != line){
                    //�����ж�ȡ���ַ������ո�ָ�õ�һ��string����
                    String[] strings = line.split(",");
                    //����ת��Ϊint���ʹ��뵽����ÿռ��������
                    for(int k = 0;k<strings.length;k++){
                        datas[i][k] = Integer.valueOf(strings[k]);
                    }
                    //������1
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //���ض�ȡ�Ķ�ά����
        return datas;    
}
	public  static int[][] getSparseArrayFromFile2(String filepath){//���ļ�������int���飨Instruct��
        //��ϡ�������ļ��ж�ȡ����
        BufferedReader bufferedReader = null;
        //Ϊ������������ռ�
        int line_num=getFileLineNum(filepath)-1;
        int[][] datas = new int[line_num][3];
        try {
      	  File file = new File(filepath);
      	  FileInputStream fis= new FileInputStream(filepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //���ж�ȡ
            while((line = bufferedReader.readLine() )!= null){
                if(null != line){
                    //�����ж�ȡ���ַ������ո�ָ�õ�һ��string����
                	String[] strings = line.split(",");
                    //����ת��Ϊint���ʹ��뵽����ÿռ��������
                    for(int k = 0;k<3;k++){
                        datas[i][k] = Integer.valueOf(strings[k]);
                    }
                    //������1
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //���ض�ȡ�Ķ�ά����
        return datas;    
}
	public static void writer(String content,String filePath)//��һ���ַ�д���ļ�
	{
		 FileWriter fwriter = null;
	        try {
	            // true��ʾ������ԭ�������ݣ����Ǽӵ��ļ��ĺ��档��Ҫ����ԭ�������ݣ�ֱ��ʡ����������ͺ�
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
	public static void writer_to_file(ArrayList<String> AllText,String filepath)//��list�ڵ��ַ�д���ļ�
	{
        //�������ϣ�д����������
        BufferedWriter bfw;
		try {
			bfw = new BufferedWriter(new FileWriter(filepath));
			for (String s : AllText) {
            bfw.write(s);//ͨ����Ч����txt�ļ���д�뼯���е��ַ���Ԫ�أ�
            bfw.newLine();//����
            bfw.flush();//ˢ��
        }
        //�ͷ���Դ
        bfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	public static int getFileLineNum(String filePath) {//��ȡ�ı��ļ�������
	    try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))){
	        lineNumberReader.skip(Long.MAX_VALUE);
	        int lineNumber = lineNumberReader.getLineNumber();
	        return lineNumber + 1;//ʵ�����Ƕ�ȡ���з����� , ������Ҫ+1
	    } catch (IOException e) {
	        return -1;
	    }
	}

}
