package entity;

public class category {
	private int cid;
	private String cname;
	public category() {
		
	}
	public category(int cid, String cname) {
		this.cid=cid;
		this.cname=cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
