package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
				return user; 
				}
			} catch (Exception e) {e.printStackTrace(); }
			return null;
		}
	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createDate"));
		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;
		}
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List <UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		while (rs.next()) {	
			list.add(new UserModel(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("images"),
					rs.getString("fullname"),
					rs.getString("email"),
					rs.getInt("roleid"),
					rs.getString("phone"),
					rs.getDate("createDate")));
			
			return list;
		}
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	
	

	@Override
	public void insert(UserModel user) {
	
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		try {
			IUserDao userDao=new UserDaoImpl();		
			System.out.println(userDao.findAll());
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
