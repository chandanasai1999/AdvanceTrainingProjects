<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bookstore.dao.*"%>
<%@page import="com.bookstore.db.*"%>
<%@page import="com.bookstore.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body bgcolor="yellow">
<%
	int q=Integer.parseInt(request.getParameter("qau"));

	String Book_id=request.getParameter("bid");
	UserDao dao= new UserDao(jdbcconnection.getConnection());
	Books book=dao.getBookDetailsById(Book_id);

%>





	<style>
#logout {
	color: red;
	padding-right: 20px;
	font-size: 30px
}
</style>

	<div align="right">
		<a id="logout" href="LogoutServlet">Logout</a>
	</div>


	<form method="post" action="OrderConfirm.jsp?q=<%=q%>">
		<center>
			<h1>SHOPPING CART FOR BOOK STORE</h1>
			<h2>ORDER CONFIRMATION</h2>
			<table width="22%" cellpadding="3">


				<tbody>
					<tr>
						<td><b>Customer Name :</b></td>
						<td><input type="text" name="cname" /></td>
					</tr>
					<tr>
						<td><b>Address :</b></td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td><b>Phone no :</b></td>
						<td><input type="text" name="no" /></td>
					</tr>

				</tbody>
			</table>
			<h3>Purchased book details are as follow :</h3>
			<table>
				<tbody>
					<tr>
						<td><b>Book ID : <%=book.getBook_id() %></b></td>
					</tr>


					<tr>
						<td><b> Book Name : <%=book.getBook_name() %></b></td>
					</tr>


					<tr>
						<td><b>Author : <%=book.getAuthor() %></b>
						<td>
					</tr>


					<tr>
						<td><b>Total Price :<%=book.getPrice()*q %>
						</b></td>
					</tr>

					<tr>
						<td><b>Quantity : <%=q%>
						</b> </b></td>
					</tr>
				</tbody>
			</table>

			<centre>
			<tr>
				<td><input type="submit" value="Confrim" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Cancel" /></td>

			</tr>
			</centre>
		</center>

	</form>
</body>
</html>