<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>MAPLE | Dashboard </title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
    new="viewport">

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath}/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="dist/js/demo.js"></script>

<!-- PAGE PLUGINS -->
<!-- jQuery Mapael -->
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/raphael/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-mapael/jquery.mapael.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/jquery-mapael/maps/usa_states.min.js"></script>
<!-- ChartJS -->
<script src="${pageContext.request.contextPath}/resources/plugins/chart.js/Chart.min.js"></script>

<!-- PAGE SCRIPTS -->
<script src="${pageContext.request.contextPath}/resources/dist/js/pages/dashboard2.js"></script>
  
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      
      
    </ul>
   
    <!-- Right navbar links -->
    <div class="navbar-custom-menu">
    	<ul class= "nav navbar-nav">
    		
    		<!-- Part 5 User Account: style can be found in dropdown.less FILL OUT LATER -->
    		<li class="dropdown user user-menu"><a href="#" class="pull-right-container" 
    			data-toggle="dropdown"> <span class="#">Welcome ${pageContext.request.userPrincipal.name}</span>
    		</a>
    			<ul class="dropdown-menu">
    			
    			<!-- Menu Footer -->
    			<li class="user-footer">
    				<div class="pull-left">
    					<a href=""${pageContext.request.contextPath}/users/profile" class="btn btn-default btn-flat">Profile</a>
    				</div>
    				<div class="pull-right">
    					<a href="${pageContext.request.contextPath}/process-logout" class="btn btn-default btn-flat">Sign Out</a>
    				</div>
    				</li>
    				</ul>
    				</li>
    	</ul>
    </div>
  </nav>
  <!-- /.navbar -->
  

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <span class="brand-text font-weight-light">MAPLE</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
      </div>
      

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
		</ul>
		<aside class="main-sidebar">
		
		<section class="sidebar">
		
		<ul class="sidebar-menu" data-widget="tree">
          
          <li class="treeview"><a href="#"><i class="fa fa-laptop"></i>
          		<span>Category</span> <span class="pull-right-container">
          			<i class="fa fa-angle-left pull-right"></i>
          	</span>
        </a>
        		<ul class="treeview-menu">
        			<li><a href="${pageContext.request.contextPath}/category/add"><i 
        				class="fa fa-circle-o"></i>
        		 	Add</a></li>
        		 	<li><a href="${pageContext.request.contextPath}/category/index"><i 
        		 		class="fa fa-circle-o"></i>
        		 	List</a></li>
        	
        	</ul></li>
        	
        <li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
        	<span>Status</span> <span class="pull-right-container">
        		<i class="fa fa-angle-left pull-right"></i>
        		</span>
        	</a>
        		<ul class="treeview-menu">
        			<li><a href="${pageContext.request.contextPath}/status/add"><i
        				class="fa fa-circle-o"></i>
        				Add</a></li>
        			<li><a href="${pageContext.request.contextPath}/status/index"><i
        				class="fa fa-circle-o"></i>
        				List</a></li>
        		
        		</ul></li>
        	
        	</ul>
        	</section>
          </aside>
         
       
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  	<tiles:insertAttribute name="content"></tiles:insertAttribute>
    
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
  </footer>
</div>
<!-- ./wrapper -->


</body>
</html>
