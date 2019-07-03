package guess.service;

import java.util.*;
import guess.pojo.Rank;
import java.io.*;

public class IOUtils {
	public static List<Rank> list = new ArrayList<Rank>();

	public static String readData() {
		StringBuffer data = null;
		try {
			File file = new File("d:\\guess.txt");
			if (!file.exists()) {
				return "上次成绩：0";
			}
			FileReader fr = new FileReader(file);
			char[] cs = new char[1024];
			data = new StringBuffer();
			int len = -1;
			while ((len = fr.read(cs)) != -1) {
				data.append(new String(cs, 0, len));
			}
			fr.close();
		} catch (Exception ex) {
			System.out.println("读取数据异常");
		}
		return data.toString();
	}

	public static void writeData(Rank data) throws IOException {
		FileWriter fw = new FileWriter("d:\\guess.txt",true);
		
		list.add(data);
		for (Rank rank : list) {
			
			fw.write(rank.toString());
		}
		fw.close();
	}

	public static void sort() throws IOException {
		List<Rank> ranklist= new ArrayList<Rank>();
		String str = readData();
		String[] strs = str.split("\\n");
		for (int i = 0; i < strs.length; i++) {
			String[] string = new String[10];
			string = strs[i].split("\\s+");
			Rank rank = new Rank();
			rank.setTime(string[1].toString() + " " + string[2].toString());
			rank.setUsername(string[4].toString());
			rank.setScore(Integer.parseInt(string[6].toString()));
			ranklist.add(rank);
		}
			 
		File file = new File("d:/list.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Collections.sort(ranklist, new Comparator<Rank>() {
			@Override
			public int compare(Rank o1, Rank o2) {
				int diff = o2.getScore() - o1.getScore();
				System.out.println(diff);
				if (diff > 0) {
					return 1;
				} else if (diff < 0) {
					return -1;
				}
				return 0;
			}
		});

		FileWriter fw=new FileWriter(file);
		for (Rank rank : ranklist) {
			fw.write(rank.toString());
		}
		fw.close();
		
		  Iterator<Rank> it = ranklist.iterator(); 
		  while (it.hasNext()) { 
			  Rank str1 =(Rank) it.next(); 
			  System.out.println(str1.toString()); 
			  }
		 
		 
	}
}
