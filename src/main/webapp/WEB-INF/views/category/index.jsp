<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Category List</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
             <li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>
              <li class="breadcrumb-item active">Category List</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-body">
              
              	<c:if test="${err != null }">
              		<div class="callout callout-danger">
            			<h4>${err }</h4>
            		</div>
              	</c:if>
              
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Action</th>     
                  </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="category" items="${categories}">
                  	<tr>
                    	<td>${category.id }</td>
                    	<td>${category.name }</td>
                    	<td>${category.status ? "Show" : "Hide" }</td>
                    	<td>
                    	<a href="${pageContext.request.contextPath}/category/edit/${category.id}">Edit</a> | 
                    	<a href="${pageContext.request.contextPath}/category/delete/${category.id}" 
                    	onclick="return confirm('Are you sure that you want to delete this category?')">Delete</a></td>
                  	</tr>
                  	</c:forEach>
                  </tbody>
                  <tfoot>
                  <tr>
                	<th>Id</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Action</th> 
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    
    <script>
  $(function () {
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
