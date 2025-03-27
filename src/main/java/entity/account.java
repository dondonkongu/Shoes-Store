package entity;

public class account {
		private int uid;
		private String user;
		private String pass;
		private int isAdmin;
		
		
		public account() {
		}
		public account(int uid,String user,String pass, int isAdmin) {
			this.uid =uid;
			this.user=user;
			this.pass=pass;
			this.isAdmin=isAdmin;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public int getIsAdmin() {
			return isAdmin;
		}
		public void setIsAdmin(int isAdmin) {
			this.isAdmin = isAdmin;
		}
		@Override
		public String toString() {
			return "account [uid=" + uid + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + "]";
		}
		
}
