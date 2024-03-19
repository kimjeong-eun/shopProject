<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
    // 클라이언트로부터 받은 댓글 내용을 변수에 저장합니다.
    String commentContent = request.getParameter("content");

    // JDBC를 사용하여 Oracle 데이터베이스에 연결합니다.
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // 데이터베이스 연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "shopmanger";
        String password = "shop5353";

        // 데이터베이스 연결
        conn = DriverManager.getConnection(url, username, password);

        // SQL 문을 작성합니다. 여기서는 comments 테이블에 댓글 내용을 저장하는 INSERT 문입니다.
        String sql = "INSERT INTO comments (content) VALUES (?)";

        // PreparedStatement를 사용하여 SQL 문을 실행합니다.
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, commentContent);
        int rowsInserted = pstmt.executeUpdate();

        // 실행 결과를 클라이언트로 응답합니다.
        if (rowsInserted > 0) {
            out.println("댓글이 성공적으로 저장되었습니다.");
        } else {
            out.println("댓글 저장에 실패하였습니다.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("오류가 발생하여 댓글을 저장할 수 없습니다.");
    } finally {
        // 리소스를 닫습니다.
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
