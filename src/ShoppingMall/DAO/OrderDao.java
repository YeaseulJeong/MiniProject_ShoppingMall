package ShoppingMall.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShoppingMall.Util.DBUtil;
import ShoppingMall.VO.Order;
import ShoppingMall.VO.Product;


public class OrderDao {
	public boolean addOrder(Order order) {
		//1. 필요한 객체 선언 Connection, statment
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "insert into orders values (?,?,?,?,?,?)";	
		try {
			//3. 접속
				conn =DBUtil.getConnection();
			//4. 쿼리작성
				ps=conn.prepareStatement(sql);
				ps.setInt(1, order.getOrderNumber());
				ps.setString(2, order.getUserId());
				ps.setInt(3, order.getTotalPrice());
				ps.setString(4, order.getOrderDate());
				ps.setString(5, order.getAddress());
				ps.setString(6, order.getPayMethod());
				
				
			//5. 실행
				int count = ps.executeUpdate();
				if(count ==1)
					resultFlag =true;				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//2 .닫기
			DBUtil.close(conn,ps);
		}
		
		return resultFlag;
	}
	

	
	//수정
	public boolean updateOrder(Order order)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "update orders set totalPrice=?,orderdate=?, address=?,payMethod=?"
				+ "where orderNumber=? ";
		
		try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, order.getTotalPrice());
				ps.setString(2, order.getOrderDate());
				ps.setString(3, order.getAddress());
				ps.setString(4, order.getPayMethod());
				ps.setInt(5, order.getOrderNumber());
				
				int count = ps.executeUpdate();
				if(count == 1)
					resultFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return resultFlag;
	}
	
	
	//삭제
	public boolean deleteOrder(Order order)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "delete from orders where orderNumber = ?";
		try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, order.getOrderNumber());
				
				int count = ps.executeUpdate();
				if(count == 1)
					resultFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return resultFlag;
	}
	//조회
	public Order getOrder(int orderno) {
		Order order = null;
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select * from orders where orderNumber=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderno);
			rs = ps.executeQuery();
			if(rs.next()) {
				order = new Order();
				order.setOrderNumber(rs.getInt(1));
				order.setUserId(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setOrderDate(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setPayMethod(rs.getString(6));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		
		return order;
	}
	//dept테이블에 있는 모든 정보 조회
	public List<Order> getOrderList(){
		List<Order> orderList = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "select * from orders";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderNumber(rs.getInt(1));
				order.setUserId(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setOrderDate(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setPayMethod(rs.getString(6));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return orderList;
	}
}
