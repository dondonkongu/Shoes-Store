package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.account;
import entity.category;
import entity.product;

public class DAO {
	Connection conn= null; // ket noi sql serve
	PreparedStatement ps =null; // nem cau lenh query qua sql serve 
	ResultSet rs =null; // nhan ket qua tra ve
	
	public List<product> getAllProduct(){
		List<product> list = new ArrayList<product>();
		String querry= "select * from product";
		try {
			conn = new DBContext().getConnection();// mo ket noi sql serve
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<product> getLast(){
		List<product> listLast = new ArrayList<product>();
		String query ="select top 3 * from product order by id desc";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs =ps.executeQuery();
			while(rs.next()) {
				listLast.add(new product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listLast;
	}

	
	public List<category> getAllCategory(){
		List<category> list = new ArrayList<category>();
		String query = "select * from category";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs =ps.executeQuery();
			while(rs.next()) {
				list.add(new category((rs.getInt(1)),rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<product> getProductByCid(String cid){
		List<product> list = new ArrayList<product>();
		String query = "select * from product where cateId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs= ps.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public product getProductByPid(String pid) {
		String query ="select * from product where id =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,pid);
			rs =ps.executeQuery();
			while(rs.next()) {
				return new product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<product> getProductBySearchTxt(String txt){
		List<product> list = new ArrayList<product>();
		String query ="select * from product where [name] like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+txt+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public account login(String user, String pass) {
		String query = "select * from account where [user] = ? and pass= ?";
		try {
			conn= new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs= ps.executeQuery();
			while(rs.next()) {
				return new account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void sigup(String user, String pass) {
		String query="insert into account values(?,?,0)";
		try {
			conn = new DBContext().getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public account checkUserDuplicate(String user) {
		String query="select * from account where [user]=?";
		try {
			conn= new DBContext().getConnection();	
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs= ps.executeQuery();
			while(rs.next()) {
				return new account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4));
			}
				} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void addProduct(String name, String image, String price, String title, String description, String image1, String image2,String image3, String image4, String cateId) {
		String query ="insert into product values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps= conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, image);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, image1);
			ps.setString(7, image2);
			ps.setString(8, image3);
			ps.setString(9, image4);
			ps.setString(10, cateId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void updateProduct(String name, String image, String price, String title, String description, String image1, String image2,String image3, String image4, String cateId,String id) {
		String query = "update product set name =?, price=?,image=?,title=?,description=?,image1=?,image2=?,image3=?,image4=?,cateId=? where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, image);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, image1);
			ps.setString(7, image2);
			ps.setString(8, image3);
			ps.setString(9, image4);
			ps.setString(10, cateId);
			ps.setString(11, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deleteProduct(String id) {
		String query = "delete from product where id=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
