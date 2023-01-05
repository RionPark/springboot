<%@page import="com.ezen.demo.vo.UserInfoVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uiId = request.getParameter("uiId");
String uiPwd = request.getParameter("uiPwd");

String url = "jdbc:mariadb://database-1.cxvnz2j52ggq.ap-northeast-2.rds.amazonaws.com:3306/EZEN";
String username = "admin";
String password = "aws1234!!";
String className = "org.mariadb.jdbc.Driver";

Class.forName(className);
String sql = "SELECT UI_NUM, UI_ID, UI_NAME, UI_PWD, UI_ADDR1," 
 			+ "UI_ADDR2, UI_ZIP, UI_PROFILE, UI_PROFILE_IMG_PATH " 
 			+ " FROM USER_INFO WHERE UI_ID=? AND UI_PWD=?";

try(Connection con = DriverManager.getConnection(url, username, password)){
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, uiId);
	pstmt.setString(2, uiPwd);
	
	ResultSet rs = pstmt.executeQuery();
	UserInfoVO userInfo = new UserInfoVO();
	if(rs.next()){
		userInfo.setUiNum(rs.getInt("UI_NUM"));
	
	}
}catch(Exception e){
	
}

%>
