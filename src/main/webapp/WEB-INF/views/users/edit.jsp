<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="content-header">
    	<h1>
    		Edit Users
    	</h1><br>
    	<ol class="breadcrumb">
    		<li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>
    		<li class="active">Edit Users</li>
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

                <s:form method="post" modelAttribute="users" action="${pageContext.request.contextPath}/users/edit" role="form">
                <div class="card-body">
                
                  <div class="form-group">
                    <label for="username">Username</label>
                    <s:input path="username" cssClass="form-control" id="username"/>
                  </div>
                  
                  <div class="form-group">
                    <label for="password">Password</label>
                    <s:password path="password" cssClass="form-control" id="password"/>
                  </div>
                  
                  <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <s:input path="fullName" cssClass="form-control" id="fullName"/>
                  </div>
                  
                  <div class="form-group">
                    <label for="email">Email</label>
                    <s:input path="email" cssClass="form-control" id="email"/>
                  </div>
                  
                  <div class="form-group">
                  	<label>Role</label>
                  	<s:select path="role" class="form-control">
                  		<s:option value="1">Admin</s:option>
                  		<s:option value="2">Employee</s:option>
                  		<s:option value="3">User</s:option>

                  	</s:select>
                  
                  </div>
                  
                  <div class="checkbox">
                  	<label>
                  		<s:checkbox path="status" /> Status
                  	</label>
                  </div>
                 
                </div>
               
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Save</button>
                  <s:hidden path="id"/>
                </div>
              </s:form>
            </div>
              </div>
            </div>
          </div> 
    </section>
    <!-- /.content -->