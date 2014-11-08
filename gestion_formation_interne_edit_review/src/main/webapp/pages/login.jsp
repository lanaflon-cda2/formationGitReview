<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<%-- <s:iterator value="fieldErrors">        
	     <s:iterator value="value"> 
	     		error : <s:property/> 
	     </s:iterator>
  	</s:iterator> --%>
  	<%-- <s:fielderror />  --%>        

	<s:if test="hasFieldErrors()">
    	<%-- <s:fielderror /> --%>
    	<s:fielderror fieldName="password" />
	</s:if>
	
	<s:if test="hasActionErrors()">
    	<s:actionerror />
	</s:if>

	<s:form action="login" method="post" >
		<s:textfield name="email" />
		<s:password name="password" />
		<s:submit value="Se connecter" />
	</s:form>
</body>
</html>