<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<section class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6">
         <h1>Profile</h1>
       </div>
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>
           Home</a></li>
           <li class="breadcrumb-item active">
           Change Profile</li>
         </ol>
       </div>
     </div>
   </div><!-- /.container-fluid -->
</section>
  
<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card card-primary">
              <s:form method="post" modelAttribute="users" 
              action="${pageContext.request.contextPath}/users/profile" role="form">
                <div class="card-body">
                  <div class="form-group">
                    <label for="username">Username</label>
                    <s:input path="username" cssClass="form-control" id="username" 
                    readonly="true"/>
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
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <s:hidden path="id"/>
                </div>
              </s:form>
            </div>
         </div>
      </div>
    </div>
</section>