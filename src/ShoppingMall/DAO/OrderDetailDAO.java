package ShoppingMall.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShoppingMall.Util.DBUtil;
import ShoppingMall.VO.OrderDetail;


public class OrderDetailDAO {
	public boolean addOrderDetail(OrderDetail orderDetail) {
		//1. 필요한 객체 선언 Connection, statment
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "insert into orderDetail values (?,?,?,?,?)";	
		try {
			//3. 접속
				conn =DBUtil.getConnection();
			//4. 쿼리작성
				ps=conn.prepareStatement(sql);
				ps.setInt(1, orderDetail.getOrderNumber());
				ps.setString(2, orderDetail.getProductId());
				ps.setInt(3, orderDetail.getProductCount());
				ps.setInt(4, orderDetail.getProductPrice());
				ps.setInt(5,orderDetail.getPrice());
				
				
				
				
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
	public boolean updateOrderDetail(OrderDetail orderdetail)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "update orderDetail set productCount = ? , price = ?"
				+ "where orderNumber=? ";
		
		try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderdetail.getProductCount());
				ps.setInt(2, orderdetail.getPrice());
				ps.setInt(3, orderdetail.getOrderNumber());
				
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
	public boolean deleteOrderDetail(OrderDetail orderdetail)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean resultFlag = false;
		String sql = "delete from orderDetail where orderNumber = ?";
		try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderdetail.getOrderNumber());
				
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

	//orderDetail테이블에 있는 모든 정보 조회
	public List<OrderDetail> getOrderDetailList(int orderNo){
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "select * from orders where orderNumber = ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderDetail orderdetail = new OrderDetail();
				
			    orderdetail.setOrderNumber(rs.getInt(1));
				orderdetail.setProductId(rs.getString(2));
				orderdetail.setProductCount(rs.getInt(3));
				orderdetail.setProductPrice(rs.getInt(4));
				orderdetail.setPrice(rs.getInt(5));
				orderDetailList.add(orderdetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return orderDetailList;
	}
	public static void main(String[] args) {
		OrderDetailDAO dao = new OrderDetailDAO();
		OrderDetail od = new OrderDetail();
		od.setOrderNumber(1);
		od.setProductCount(5);
		od.setProductId("ss");
		od.setProductPrice(1000);
		od.setPrice(5000);
		boolean b = dao.addOrderDetail(od);
		if(b)
			System.out.println("성공");
	}
}
