<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6">
         <h1>Status List</h1>
       </div>
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>
           Dashboard</a></li>
           <li class="breadcrumb-item active">
           Status List</li>
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
                    <th>Color</th>
                    <th>Display</th>
                    <th>Action</th>     
                  </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="status" items="${statuses}">
                  	<tr>
                    	<td>${status.id }</td>
                    	<td>${status.name }</td>
                    	<td><span class="label label-${status.color }">${status.color }</span></td>
                    	<td>${status.display ? "Show" : "Hide" }</td>
                    	<td>
                    	<a href="${pageContext.request.contextPath}/status/edit/${status.id}">Edit</a> | 
                    	<a href="${pageContext.request.contextPath}/status/delete/${status.id}" 
                    	onclick="return confirm('Are you sure?')">Delete</a></td>
                  	</tr>
                  	</c:forEach>
                  </tbody>
                  <tfoot>
                  <tr>
                	<th>Id</th>
                    <th>Name</th>
                    <th>Color</th>
                    <th>Display</th>
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
