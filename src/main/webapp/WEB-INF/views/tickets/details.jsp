<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6">
         <h1>Ticket Details</h1>
       </div>
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>
           Dashboard</a></li>
           <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/tickets/history"><i class="fa fa-dashboard"></i>
           Ticket History</a></li>
           <li class="breadcrumb-item active">
           Ticket Details</li>
         </ol>
       </div>
     </div>
   </div>
</section>
    
    <!-- Main content -->
<div class="invoice p-3 mb-3">
              <!-- title row -->
              <div class="row">
                <div class="col-12">
                  <div class="page-header">
                    <h4><b>${tickets.title }</b></h4>
                  		${tickets.description }
                  </div>
                </div>
                <!-- /.col -->
              </div>
              <!-- info row -->
              <div class="row invoice-info">
                <div class="col-sm-4 invoice-col">
                  <strong>Ticket Submitter:</strong>
                  <address>
                    ${tickets.accountByUserId.fullName }
                    <br>
                    Email: ${tickets.accountByUserId.email }
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  <strong>Ticket Owner:</strong>
                  <address>
                    ${tickets.accountByUserId.fullName }
                    <br>
                    Email: ${tickets.accountByUserId.email }
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                <strong>Details:</strong>
                	<address>
                  Ticket Id: #${tickets.id }<br>
                  <fmt:formatDate var="createdDate" 
                  		value="${tickets.createdDate }" pattern="MM/dd/yyyy" />
                  Created Date: ${createdDate }<br>
                  Category: ${tickets.category.name}<br>
                  Status: ${tickets.status.name}
                	</address>
                </div>
                <!-- /.col -->
              </div>
              <!-- Comments to be implemented here -->
              <!-- /.row -->
              <!-- this row will not appear when printing -->
              <div class="row no-print">
                <div class="col-12">
                  <button type="button" class="btn btn-primary float-right" style="margin-right: 5px;">
                    <i class="fas fa-download"></i> Generate PDF
                  </button>
                </div>
              </div>
            </div>