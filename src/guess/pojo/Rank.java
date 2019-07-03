package guess.pojo;

public class Rank  implements Comparable<Rank> {
	private String time;
	private String username;
	private int score;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		String str="";
		str+="时间："+"  "+ this.getTime()+"  \t姓名："+"  "+this.username+"  \t本轮成绩："+"  "+ this.score+"\n";
		return str;
		}
	
	@Override
	public int compareTo(Rank o) { // TODO Auto-generated method stub
		return o.getScore() - this.score;
	}
	 
	
	

}
