<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="content-header">
    	<h1>
    		Add Status
    	</h1><br>
    	<ol class="breadcrumb">
    		<li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>
    		<li class="active">Add Status</li>
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

                <s:form method="post" modelAttribute="status" action="${pageContext.request.contextPath}/status/add" role="form">
                <div class="card-body">
                
                  <div class="form-group">
                    <label for="name">Name</label>
                    <s:input path="name" cssClass="form-control" id="name"/>
                  </div>
                  
                  <div class="form-group">
                  	<label for="color">Color</label>
                  	<s:select path="color" cssClass="form-control" id="color">
                  		<s:option value="success">Success</s:option>
                  		<s:option value="warning">Warning</s:option>
                  		<s:option value="danger">Danger</s:option>
                  		<s:option value="info">Info</s:option>
                  	</s:select>
                  </div>
                  
                  <div class="checkbox">
                  	<label>
                  		<s:checkbox path="display" /> Display
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