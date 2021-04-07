<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="content-header">
    	<h1>
    		Send Ticket
    	</h1><br>
    	<ol class="breadcrumb">
    		<li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>
    		<li class="active">Send Ticket</li>
    	</ol>
    </section>
    
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
            	
            	<c:if test="${err != null }">
            		<div class="callout callout-danger">
            			<h4>${err }</h4>
            		</div>
            	</c:if>
            	
            	<c:if test="${success != null }">
            		<div class="callout callout-success">
            			<h4>${success }</h4>
            		</div>
            	</c:if>

                <s:form method="post" modelAttribute="tickets" action="${pageContext.request.contextPath}/tickets/send" role="form">
                <div class="card-body">
                
                  <div class="form-group">
                    <label for="title">Title</label>
                    <s:input path="title" cssClass="form-control" id="title"/>
                  </div>
                  
                  <div class="form-group">
                    <label for="description">Description</label>
                    <s:textarea path="description" cols="20" rows="5" cssClass="form-control" id="description"/>
                  </div>
                  
                  <div class="form-group">
                  	<label>Category</label>
                  	<s:select path="category.id"
                  		items="${category }"
                  		itemLabel="name"
                  		itemValue="id"
                  	 	class="form-control"></s:select>
                  
                  </div>
                </div>
                <!-- /.card-body -->
                
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Save</button>
                </div>
              </s:form>
            </div>
              </div>
            </div>
          </div> 
    </section>
    <!-- /.content -->