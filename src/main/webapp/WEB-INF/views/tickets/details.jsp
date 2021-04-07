<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Ticket Details</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
             <li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>
              <li class="breadcrumb-item active">Ticket Details</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
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
                  Ticket Submitter:
                  <address>
                    <strong>${tickets.accountByUserId.fullName }</strong>
                    <br>
                    Email: ${tickets.accountByUserId.email }
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  Ticket Owner:
                  <address>
                    <strong>${tickets.accountByUserId.fullName }</strong>
                    <br>
                    Email: ${tickets.accountByUserId.email }
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  <b>Ticket Id:</b> #${tickets.id }<br>
                  <fmt:formatDate var="createdDate" 
                  		value="${tickets.createdDate }" pattern="MM/dd/yyyy" />
                  <b>Created Date:</b> ${createdDate }<br>
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