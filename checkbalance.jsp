<%@page import="com.bank.dbconnection.DB_Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="Dashboard_Sidebar.jsp"%>
   <%@page import="com.bank.bo.Bank_Encapsulation"%>
<%@page import="com.bank.dao.Bank_DAO"%>
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="content-wrap">
		<div class="main">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-8 p-r-0 title-margin-right">
						<div class="page-header">
							<div class="page-title">

						<%
                          Bank_DAO fdc=new Bank_DAO(DB_Connection.getConnection());
                          List<Bank_Encapsulation> l=fdc.showAllRecordAmount();
                          int i=0;
                          for(Bank_Encapsulation fs:l){
                    	      i++;
                                 %>


								<h1>
									Your Balance is: <%=fs.getAmount() %>
								</h1>
							
							<%
                              }
                             %>
    
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>