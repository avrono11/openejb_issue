<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add an Item</title>
</head>
<body>
<f:view>
  <h:form>
    <h:panelGrid columns="2">
      <h:outputLabel value="Id"></h:outputLabel>
      <h:inputText  value="#{itemAdder.id}"></h:inputText>
      <h:outputLabel value="Name"></h:outputLabel>
      <h:inputText  value="#{itemAdder.name}"></h:inputText>
      <h:outputLabel value="Initial Price"></h:outputLabel>
      <h:inputText  value="#{itemAdder.initialPrice}"></h:inputText>
    </h:panelGrid>
    <h:commandButton action="#{itemAdder.addItem}" value="Add"></h:commandButton>
    <h:commandButton action="#{itemAdder.reset}" value="Reset"></h:commandButton>
    <h:messages layout="table"></h:messages>
  </h:form>
  <!-- 
  <h:panelGroup rendered="#{temperatureConvertor.initial!=true}">
	  <h3> Result </h3>
	  <h:outputLabel value="Fahrenheit "></h:outputLabel>
	  <h:outputLabel value="#{temperatureConvertor.fahrenheit}"></h:outputLabel>
	</h:panelGroup>
	 -->
</f:view>
</body>
</html> 