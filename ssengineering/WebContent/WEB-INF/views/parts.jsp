<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> :: SSE - Parts ::</title>	
</head>
<body>
	<div class="site-container">
		<%@ include file="header.jsp" %>
		<div class="content">					
			<div class="jtable-main-container">
				<div class="jtable-title">
					<div class="jtable-title-text">Parts List</div>
					<div class="jtable-toolbar">
						<span>						
							<span class="search-container">															
								<input class="search" placeholder="Search" class="search"/>
							</span>
						</span>
						<span class="jtable-toolbar-item jtable-toolbar-item-add-record" id="add-dialog-link">
							<span class="jtable-toolbar-item-icon"><i class="fa fa-plus add"></i></span>
							<span class="jtable-toolbar-item-text">Add new record</span>
						</span>
					</div>
				</div>	
				<div id="jtableContainer">
					<table class="jtable" id="jtable">
						<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>				
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						</thead>
						<tbody>
						
						</tbody>
					</table>
					<div id="emptyTable"></div>
				</div>	
				<div class="jtable-bottom-panel">
					<div class="jtable-left-area">
						<span class="jtable-page-list"></span>
						<span class="jtable-goto-page">
							<span>Go to page: </span>
							<select name="gotoPage" id="gotoPage">
								
							</select>
						</span>
						<span class="jtable-page-size-change">
							<span>Record per page: </span>
							<select name="pageSize" id="pageSize">
								<option value="15">15</option>								
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
								<option value="50">50</option>
								<option value="60">60</option>
								<option value="70">70</option>
								<option value="80">80</option>
								<option value="90">90</option>
								<option value="100">100</option>
							</select>
						</span>
					</div>
					<div class="jtable-right-area">
						<span class="jtable-page-info">Showing 1-10 of 128</span>
					</div>					
				</div>	
			</div>	
		</div>		
		<div id="edit-dialog" title="Edit Part">
			<form method="post" action="edit" id="formEdit">
				<div>
					<span class="error" id="editFormErrorText"></span>
				</div>
				<div class="form-wrapper">
					<div>
				        <label>ID : </label>
				        <input type=text name="id" readonly />
				    </div>
				    <div>
				        <label>Name : </label>
				        <input type=text name="name" autocomplete="off" />
				    </div>
				    <div>
				        <label>Description : </label>
				        <input type=text name="description" autocomplete="off"/>
				    </div>
				    <div class="controls">				    	
		        		<input type="reset" value="Cancel"/>
		        		<input type="button" value="Update" id="updateButton"/>
				    </div>
				</div>
			</form>
		</div>		
		<div id="add-dialog" title="Add Part">			
			<form:form method="post" action="add" commandName="part" id="formAdd">
				<div>
					<span class="error" id="addFormErrorText"></span>
				</div>
				<div class="form-wrapper">
				    <div>
				        <label>Name : </label>
				        <form:input path="name" autocomplete="off" />
				    </div>
				    <div>
				        <label>Description : </label>
				        <form:input path="description" autocomplete="off" />
				    </div>
				    <div class="controls">				    	
		        		<input type="reset" value="Cancel"/>
		        		<input type="button" value="Save" id="addButton"/>
				    </div>
				</div>
			</form:form>			
		</div>		
	</div>
	
	<div id="confirm-dialog" title="Please Confirm!">
		<p>Do you really want to delete this record?</p>
	</div>
	
	<script type="text/javascript">
		
		var jsonData = ${jsonData};
		
		function setData(data){
			for (var i = 0; i < data.length; i++) {
            	var rowData = data[i];            	
    		   	var row = $("<tr />");		   	
    		    $("#jtable").append(row);
    		    row.append($("<td>" + rowData.id + "</td>"));    		    
    		    row.append($("<td>" + rowData.name + "</td>"));
    		    row.append($("<td>" + rowData.description + "</td>"));
    		    row.append($("<td class='center-content'><a href='#'  class='edit-dialog-link edit' data-id='"+rowData.id+"'><i class='fa fa-edit'></i></a></td>"));
    		    row.append($("<td class='center-content'><a data-id='"+rowData.id+"'  class='delete'><i class='fa fa-trash-o'></i></a></td>")); 
        	}
		}
		
		$( "#confirm-dialog" ).dialog({
			autoOpen: false,
			width: 400,
			height: 200,
			modal: true
		});
		
		$( "#add-dialog" ).dialog({
			autoOpen: false,
			width: 600,
			modal: true
		});
	
		$( "#edit-dialog" ).dialog({
			autoOpen: false,
			width: 600,
			modal: true
		});
		
		$('#jtable').on('click', '.edit-dialog-link' ,function(event){
			var id = $(this).attr("data-id");
			$.ajax({
			     type : "GET", 
			     url : "getpart", 
			     data : "id=" + id,
			     success : function(response) {
			    	 var obj = JSON.parse(response);
			    	 $("#formEdit input[name=id]").val(obj.part.id);
			    	 $("#formEdit input[name=name]").val(obj.part.name);
			    	 $("#formEdit input[name=description]").val(obj.part.desc);
			     },
			     error : function(e) {
			      alert('Error: ' + e); 
			     }
			    });
			$( "#edit-dialog" ).dialog( "open" );
			event.preventDefault();
		});

		
		$( "#add-dialog-link" ).click(function( event ) {
			$( "#add-dialog" ).dialog( "open" );			
			event.preventDefault();
		});
		
		$('#pageSize').change(function(e){
			$('#jtable').paging('updatePaging',$('#pageSize').val(),jsonData);	
		});
		
		$('#gotoPage').click(function(e){
			$('#jtable').paging('showPage', $('#gotoPage').val());
		});

		$(document).ready(function(){
			$('#jtable').paging({
				limit:$('#pageSize').val(),
				data:jsonData
				});
			
			$('#jtableContainer').height($(window).height() - ($('.main-header').height()+$('.top-navigation').height()
					+$('.jtable-title').height()+$('.jtable-bottom-panel').height())-10);
			
			$('#cssmenu').removeClass('active');
			$($('#cssmenu li')[1]).addClass('active');
			
        });
		
		$('#jtable').on('click', 'tr' ,function(event){
			$(this).addClass('selected').siblings().removeClass('selected');
		});
		
		$('.search').keyup(function(e) {
			var text = $(this).val();
			var results = [];
			$.each(jsonData,function(i,obj){
				var name = obj.name+"";
				var desc = obj.description+"";				
				if(name.indexOf(text) > -1 || desc.indexOf(text) > -1)
					results.push(obj);
			});
			$('#jtable').paging('searchData',$('#pageSize').val(),results);
		});
		
		$('#jtable').on('click', '.delete' ,function(event){
			var id = $(this).data("id");
			var myButtons = {
	                "Ok": function () {
	                	window.location.href = "delete/"+id;
	                },
	                "Cancel": function () {
	                	event.preventDefault();
	                    $(this).dialog("close");		                    
	                }
	            };
			$( "#confirm-dialog p" ).html("Do you really want to delete this record?");
			$( "#confirm-dialog" ).dialog('option', 'buttons', myButtons);
			$( "#confirm-dialog" ).dialog('open');
		});
		
		$('#updateButton').click(function(){
			validateEditForm();
		});
		
		$('#addButton').click(function(){
			validateAddForm();
		});
		
		
		function validateAddForm(){			
			if($('#formAdd input[name=name]').val().length == 0){
				$('#addFormErrorText').html("Please enter part name");
				return;
			}
			else if($('#formAdd input[name=description]').val().length == 0){
				$('#addFormErrorText').html("Please enter part description");
				return;
			}
			
			$('#addFormErrorText').html("");
			
			var myButtons = {
	                "Ok": function () {
	                	$('#formAdd').submit();
	                },
	                "Cancel": function () {
	                	event.preventDefault();
	                    $(this).dialog("close");		                    
	                }
	            };
			
			$( "#confirm-dialog p" ).html("Do you really want to add new record?");
			$( "#confirm-dialog" ).dialog('option', 'buttons', myButtons);
			$( "#confirm-dialog" ).dialog('open');		
		}
		
		function validateEditForm(){
			if($('#formEdit input[name=name]').val().length == 0){
				$('#editFormErrorText').html("Please enter part name");
				return;
			}
			else if($('#formEdit input[name=description]').val().length == 0){
				$('#editFormErrorText').html("Please enter part description");
				return;
			}
			$('#editFormErrorText').html("");		
			
			var myButtons = {
	                "Ok": function () {
	                	$('#formEdit').submit();
	                },
	                "Cancel": function () {
	                	event.preventDefault();
	                    $(this).dialog("close");		                    
	                }
	            };
			
			$( "#confirm-dialog p" ).html("Do you really want to update this record?");
			$( "#confirm-dialog" ).dialog('option', 'buttons', myButtons);
			$( "#confirm-dialog" ).dialog('open');
		}
		
	</script>
	
</body>	
</html>