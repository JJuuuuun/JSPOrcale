<%@ page import="Ex01.FileReader" %>
<%@ page import="java.util.List" %>
<%@ page import="Ex01.Customers" %>
<%@ page import="Ex01.DataProc" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 2020-06-08
  Time: 오후 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String filePath = "C:\\Users\\HOME\\Documents\\카카오톡 받은 파일\\Categories\\Customers.txt";

    FileReader fileReader = new FileReader();
    List<String> list = fileReader.getFileContents(filePath);
    List<Customers> customersList = fileReader.getCustomersList(list);

    for (Customers customer : customersList) {
        out.print(customer.getCustomerID()+"<br>");
    }

    /*DataProc dataProc = new DataProc();
    try {
        dataProc.storeCustomers(customersList);
        dataProc.closeConnect();

        out.print("정상 종료");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }*/
%>