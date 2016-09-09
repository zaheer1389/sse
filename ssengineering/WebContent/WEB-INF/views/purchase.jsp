<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> :: SSE - Purchases ::</title>	
</head>
<body>
	<div class="site-container">
		<%@ include file="header.jsp" %>
		<div class="content">					
			<div class="jtable-main-container">
				<div class="jtable-title">
					<div class="jtable-title-text">Purchase List</div>
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
							<th>Puchase From</th>
							<th>Purchase Date</th>		
							<th>Total Amount</th>
							<th>View Purchases</th>								
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
		<div id="view-dialog" title="Purchase Details">
			<div id="purchaseDetails">
				<table id="purchaseDetailsTable" width="100%">
					<thead>
						<tr>
							<th>Parts</th>
							<th>Sub Parts</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>		
		<div id="edit-dialog" title="Edit Purchase">
			<form method="post" action="edit" id="formEdit">
				<input type="hidden" name="totalItems">
				<input type="hidden" name="purchaseId">
				<div>
					<span class="error" id="editFormErrorText"></span>
				</div>
				<div class="align-right align-middle">
					<div class="bottom-padding"><input type="button" value="Add Item" id="editAddItem"></div>					
				</div>
				<div class="form-wrapper">
					<div>
				        <div>
							<label>Customer : </label>
				        	<select name="customerId">
								<option value='-1'>-- Select Customer --</option>
				            	<c:forEach items="${customers}" var="p">
				            		<c:if test="${p.customerType == 'PURCHASE'}">
				               			<option value="${p.id}">${p.name}</option>
				               		</c:if>
				            	</c:forEach>
							</select>
						</div>
						<div>
							<label>Purchase Date : </label>
							<input type="text" name="txtPurhcaseDate">
						</div>
				    </div>																
				</div>
				<div>
					<div class="bottom-padding">
						<table id="editItemTable" width="100%">
							<thead>
							<tr>
								<th>ID</th>
								<th>Parts</th>
								<th>SubParts</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Delete</th>
							</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				<div class="align-right align-middle">
					<div>
						<input type="button" value="Update" id="updateButton">
					</div>
				</div>
			</form>
		</div>		
		<div id="add-dialog" title="Add Purchase">					
			<form:form method="post" action="add" commandName="purchaseForm" id="formAdd">
				<input type="hidden" name="totalItems">
				<div>
					<span class="error" id="addFormErrorText"></span>
				</div>
				<div class="align-right align-middle">
					<div class="bottom-padding"><input type="button" value="Add Item" id="addItem"></div>					
				</div>
				
				<div class="form-wrapper">
					<div>
						<div>
							<label>Customer : </label>
				        	<select name="customerId">
								<option value='-1'>-- Select Customer --</option>
				            	<c:forEach items="${customers}" var="p">
				            		<c:if test="${p.customerType == 'PURCHASE'}">
				               			<option value="${p.id}">${p.name}</option>
				               		</c:if>
				            	</c:forEach>
							</select>
						</div>
						<div>
							<label>Purchase Date : </label>
							<input type="text" name="txtPurhcaseDate">
						</div>				        
				    </div>																
				</div>
				
				<div>
					<div class="bottom-padding">
						<table id="itemTable" width="100%">
							<thead>
							<tr>
								<th>Parts</th>
								<th>SubParts</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Delete</th>
							</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				<div class="align-right align-middle">
					<div>
						<input type="button" value="Purchase" id="addButton">
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
		var parts = ${jsonPart};
		var subparts = ${jsonSubpart};
		
		$('input[name=txtPurhcaseDate]').datepicker({buttonImageOnly: true});
		
		$( "#confirm-dialog" ).dialog({
			autoOpen: false,
			width: 500,
			modal: true
		});
		
		$( "#view-dialog" ).dialog({
			autoOpen: false,
			width: 500,
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
		
		$(document).ready(function(){
			$('#jtable').paging({
				limit:$('#pageSize').val(),
				data:jsonData
				});
			
			$('#jtableContainer').height($(window).height() - ($('.main-header').height()+$('.top-navigation').height()
					+$('.jtable-title').height()+$('.jtable-bottom-panel').height())-10);
			
			$('#cssmenu').removeClass('active');
			$($('#cssmenu li')[3]).addClass('active');
			
			var states = new Array("Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal");
			for(var i=0; i<states.length; i++){
				$('#formAdd select[name=state],#formEdit select[name=state]').append($('<option>', {
         	 	   value: states[i],
         	 	   text: states[i]
         	    }));
			}
			
        });
		
		function setData(data){
			for (var i = 0; i < data.length; i++) {
            	var rowData = data[i];               	
    		   	var row = $("<tr data-id='"+rowData.id+"'/>");		   	
    		    $("#jtable").append(row);
    		    row.append($("<td>" + rowData.id + "</td>"));    		    
    		    row.append($("<td>" + rowData.customer.name + "</td>"));
    		    row.append($("<td>" + rowData.purchaseDate + "</td>"));
    		    row.append($("<td>" + rowData.totalAmount + "</td>"));
    		    row.append($("<td class='center-content'><a href='#'  class='view-dialog-link view' data-id='"+rowData.id+"'><i class='fa fa-eye'></i></a></td>"));
    		    row.append($("<td class='center-content'><a href='#'  class='edit-dialog-link edit' data-id='"+rowData.id+"'><i class='fa fa-edit'></i></a></td>"));
    		    row.append($("<td class='center-content'><a href='#' data-id='"+rowData.id+"' class='delete'><i class='fa fa-trash-o'></i></a></td>")); 
        	}
		}

		function setEvents(){

			$('#jtable').on('click', '.view-dialog-link' ,function(event){
				var id = $(this).data("id");
				$.ajax({
				     type : "GET", 
				     url : "getpurchasedetail", 
				     data : "id=" + id,
				     success : function(response) {
				    	 showPurchaseDetails(response);
				     },
				     error : function(e) {
				      alert('Error: ' + e); 
				     }
				    });
			});	
			
			$('#jtable').on('click', '.edit-dialog-link' ,function(event){
				var id = $(this).data("id");				
				showEditForm(id);
			});		
			
			$( "#add-dialog-link" ).click(function( event ) {
				$("#itemTable tbody").empty();
				$('#addFormErrorText').html("");
				$( "#add-dialog" ).dialog( "open" );			
				event.preventDefault();
			});
			
			$('#pageSize').change(function(e){
				$('#jtable').paging('updatePaging',$('#pageSize').val(),jsonData);	
			});
			
			$('#gotoPage').click(function(e){
				$('#jtable').paging('showPage', $('#gotoPage').val());
			});
			
			$('#jtable').on('click', 'tr' ,function(event){
				$(this).addClass('selected').siblings().removeClass('selected');								
			});
			
			$('#jtable').on('dblclick', 'td', function () {
				var $this = $(this);
			    var row = $this.closest("tr");
			    var id = row.data("id");
				showEditForm(id);
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
			
			$('#addItem').click(function (){
				addItem($("#itemTable tbody").children().length);
			});
			
			$('#editAddItem').click(function (){
				addItemToEditForm($("#editItemTable tbody").children().length);
			});
			
			$('#itemTable').on('change', 'select[id^=part]' ,function(event){
				var $this = $(this);
			    var row = $this.closest("tr");
			    var rowid = row.data("id");
			    var dataid = $this.val();
			    setSubPartsDropDown(rowid, dataid);
			});
			
			$('#editItemTable').on('change', 'select[id^=part]' ,function(event){
				var $this = $(this);
			    var row = $this.closest("tr");
			    var rowid = row.data("id");
			    var dataid = $this.val();
			    setSubPartsDropDown(rowid, dataid);
			});
			
			$('#editItemTable').on('change', 'input[id^=deleted]' ,function(event){
				var $this = $(this);
			    var row = $this.closest("tr");			    
			    if($(row).hasClass('newitem')){
			    	$(row).remove();	
			    	$("#formEdit input[name=totalItems]").val($("#editItemTable tbody").children().length);
			    }
			    else{
			    	if($(this).is(':checked')){
				    	$(row).find('select[id^=part],select[id^=subpart],input[id^=qty],input[id^=price]').prop("disabled",true);
				    }
				    else{
				    	$(row).find('select[id^=part],select[id^=subpart],input[id^=qty],input[id^=price]').prop("disabled",false);
				    }	
			    }			    
			});
			
			$('#itemTable').on('change', 'input[id^=deleted]' ,function(event){
				var $this = $(this);
			    var row = $this.closest("tr");			    
			    $(row).remove();	
			    $("#formAdd input[name=totalItems]").val($("#itemTable tbody").children().length);			    			   
			});
			
			$('#updateButton').click(function(){
				validateEditForm();
			});
			
			$('#addButton').click(function(){
				validateAddForm();
			});
		}
		
		function addItem(rowid){
			var row = $("<tr data-id='"+rowid+"'>");			
		    $("#itemTable tbody").append(row);
		    //$(row).data("id",rowid);
		    
		    var ddPart = "<select name='part"+rowid+"' id='part"+rowid+"' style='width:120px;'/>";
		    var ddSubPart = "<select name='subpart"+rowid+"' id='subpart"+rowid+"' style='width:120px;'/>";
		    var txtQty = "<input type=text name='qty"+rowid+"' id='qty"+rowid+"' style='width:60px;'>";
		    var txtPrice = "<input type=text name='price"+rowid+"' id='price"+rowid+"' style='width:60px;'>";
		    var deleteLink = "<input type=checkbox name='deleted"+rowid+"' id='deleted"+rowid+"' style='width:60px;'>";
		    
		    row.append($("<td>" + ddPart + "</td>"));    		    
		    row.append($("<td>" + ddSubPart + "</td>"));
		    row.append($("<td>" + txtQty + "</td>"));
		    row.append($("<td>" + txtPrice + "</td>"));
		    row.append($("<td>" + deleteLink + "</td>"));
		    
		    $("#formAdd input[name=totalItems]").val($("#itemTable tbody").children().length);
		    
		    setPartsDropDown(rowid);
			
		}
		
		function addItemToEditForm(rowid){
			var row = $("<tr data-id='"+rowid+"' class='newitem'>");			
		    $("#editItemTable tbody").append(row);
		    //$(row).data("id",rowid);
		    
		    var txtID = "<input type=text value='"+rowid+"' name='id"+rowid+"' id='id"+rowid+"' style='width:30px;' readonly>";
		    var ddPart = "<select name='part"+rowid+"' id='part"+rowid+"' style='width:120px;'/>";
		    var ddSubPart = "<select name='subpart"+rowid+"' id='subpart"+rowid+"' style='width:120px;'/>";
		    var txtQty = "<input type=text name='qty"+rowid+"' id='qty"+rowid+"' style='width:60px;'>";
		    var txtPrice = "<input type=text name='price"+rowid+"' id='price"+rowid+"' style='width:60px;'>";
		    var deleteLink = "<input type=checkbox name='deleted"+rowid+"' id='deleted"+rowid+"' style='width:60px;'>";
		    
		    row.append($("<td>"+ txtID+"</td>"));
		    row.append($("<td>" + ddPart + "</td>"));    		    
		    row.append($("<td>" + ddSubPart + "</td>"));
		    row.append($("<td>" + txtQty + "</td>"));
		    row.append($("<td>" + txtPrice + "</td>"));
		    row.append($("<td class='center-content'>" + deleteLink + "</td>"));
		    
		    $("#formEdit input[name=totalItems]").val($("#editItemTable tbody").children().length);
		    
		    setPartsDropDown(rowid);
		}
		
		function setPartsDropDown(rowid){
			$('#part'+rowid).append($('<option>', {
 	 	   		value: -1,
 	 	   		text: '-- Select Parts --'
 	    	}));
			for (var i = 0; i < parts.length; i++) {
				var rowData = parts[i];
				$('#part'+rowid).append($('<option>', {
     	 	   		value: rowData.id,
     	 	   		text: rowData.name
     	    	}));
				
			}            	
		}
		
		function setSubPartsDropDown(rowid, dataid){
			$('#subpart'+rowid).empty();
			$('#subpart'+rowid).append($('<option>', {
 	 	   		value: -1,
 	 	   		text: '-- Select Subparts --'
 	    	}));
			for (var i = 0; i < subparts.length; i++) {
				var rowData = subparts[i];
				if(rowData.part.id == dataid){
					$('#subpart'+rowid).append($('<option>', {
	     	 	   		value: rowData.id,
	     	 	   		text: rowData.name
	     	    	}));
				}
			}
			//$('#subpart'+rowid).val(-1);
		}
		
		function showEditForm(id){
			$.ajax({
			     type : "GET", 
			     url : "getpurchasedetail", 
			     data : "id=" + id,
			     success : function(response) {
			    	 setEditForm(response);
			     },
			     error : function(e) {
			      alert('Error: ' + e); 
			     }
			    });						
		}
		
		function setEditForm(jsondata){
			$("#editItemTable tbody").empty();
			$( "#edit-dialog" ).dialog( "open" );
			var data = JSON.parse(jsondata);
			var purchaseId = 0;
			var customerId = 0;
			for (var i = 0; i < data.length; i++) {				
            	var rowData = data[i];
            	purchaseId = rowData.purchase.id;
            	customerId = rowData.purchase.customer.id;
            	var rowid = i;            	
            	var row = $("<tr data-id='"+rowid+"'>");			
    		    $("#editItemTable tbody").append(row);
    		    
    		    var txtID = "<input type=text name='id"+rowid+"' id='id"+rowid+"' style='width:30px;' readonly>";
    		    var ddPart = "<select name='part"+rowid+"' id='part"+rowid+"' style='width:120px;'/>";
    		    var ddSubPart = "<select name='subpart"+rowid+"' id='subpart"+rowid+"' style='width:120px;'/>";
    		    var txtQty = "<input type=text name='qty"+rowid+"' id='qty"+rowid+"' style='width:60px;'>";
    		    var txtPrice = "<input type=text name='price"+rowid+"' id='price"+rowid+"' style='width:60px;'>";
    		    var deleteLink = "<input type=checkbox name='deleted"+rowid+"' id='deleted"+rowid+"' style='width:60px;'>";
    		    
    		    row.append($("<td>" + txtID + "</td>"));
    		    row.append($("<td>" + ddPart + "</td>"));    		    
    		    row.append($("<td>" + ddSubPart + "</td>"));
    		    row.append($("<td>" + txtQty + "</td>"));
    		    row.append($("<td>" + txtPrice + "</td>"));
    		    row.append($("<td class='center-content'>" + deleteLink + "</td>"));
    		    
    		    setPartsDropDown(rowid);
    		    
    		    $('#id'+i).val(rowData.id);
    		    $('#part'+i).val(rowData.part.id).change();
    		    $('#subpart'+i).val(rowData.subPart.id).change();
    		    $('#qty'+i).val(rowData.totalUnit);
    		    $('#price'+i).val(rowData.amountPerUnit);
			}
			$("#formEdit input[name=totalItems]").val($("#editItemTable tbody").children().length);
			$("#formEdit input[name=purchaseId]").val(purchaseId);
			$("#formEdit select[name=customerId]").val(customerId);			
			event.preventDefault();
		}
		
		function showPurchaseDetails(jsondata){
			$("#purchaseDetailsTable tbody").empty();
			$( "#view-dialog" ).dialog( "open" );
			var data = JSON.parse(jsondata);
			for (var i = 0; i < data.length; i++) {
            	var rowData = data[i];
            	var totalPrice = parseFloat(rowData.amountPerUnit)*parseInt(rowData.totalUnit);
    		   	var row = $("<tr data-id='"+rowData.id+"'/>");		   	
    		    $("#purchaseDetailsTable tbody").append(row);
    		    row.append($("<td>" + rowData.part.name + "</td>"));
    		    row.append($("<td>" + rowData.subPart.name + "</td>"));
    		    row.append($("<td>" + rowData.totalUnit + "</td>"));
    		    row.append($("<td>" + rowData.amountPerUnit + "</td>"));    		    
    		    row.append($("<td>" + totalPrice + "</td>"));
        	}
			event.preventDefault();
		}
		
		function validateAddForm(){			
			if($('#formAdd select[name=customerId]').val() == -1){
				$('#addFormErrorText').html("Please select customer");
				return;
			}
			var items = $('#formAdd input[name=totalItems]').val();
			if(items == 0){
				$('#addFormErrorText').html("Please add atleast one item to purchase using Add Item button ");
				return;
			}
			
			for(var i=0; i < items; i++){
				var qty = $('#formAdd #qty'+i).val();
				var price = $('#formAdd #price'+i).val();
				if($('#formAdd #part'+i).val() == -1){
					$('#addFormErrorText').html("Please select purchase parts for item "+(i+1));
					return;
				}
				else if($('#formAdd #subpart'+i).val() == -1){
					$('#addFormErrorText').html("Please select purchase subparts for item "+(i+1));
					return;
				}
				else if(qty.length == 0){
					$('#addFormErrorText').html("Please enter purchase quantity for item "+(i+1));
					return;
				}
				else if(!$.isNumeric(qty)){
					$('#addFormErrorText').html("Purchase quantity for item "+(i+1)+" must contains only numbers");
					return;
				}
				else if(price.length == 0){
					$('#addFormErrorText').html("Please enter purchase unit price for item "+(i+1));
					return;
				}
				else if(!$.isNumeric(price)){
					$('#addFormErrorText').html("Purchase price for item "+(i+1)+" must contains only numbers");
					return;
				}
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
			if($('#formEdit select[name=customerId]').val() == -1){
				$('#editFormErrorText').html("Please select customer");
				return false;
			}
			var items = $('#formEdit input[name=totalItems]').val();
			if(items == 0){
				$('#editFormErrorText').html("Please add atleast one item to purchase using Add Item button ");
				return false;
			}

			for(var i=0; i < items; i++){
				var qty = $('#formEdit #qty'+i).val();
				var price = $('#formEdit #price'+i).val();
				if($('#formEdit #part'+i).val() == -1){
					$('#editFormErrorText').html("Please select purchase parts for item "+(i+1));
					return false;
				}
				else if($('#formEdit #subpart'+i).val() == -1){
					$('#editFormErrorText').html("Please select purchase subparts for item "+(i+1));
					return false;
				}
				else if(qty.length == 0){
					$('#editFormErrorText').html("Please enter purchase quantity for item "+(i+1));
					return false;
				}
				else if(!$.isNumeric(qty)){
					$('#editFormErrorText').html("Purchase quantity for item "+(i+1)+" must contains only numbers");
					return false;
				}
				else if(price.length == 0){
					$('#editFormErrorText').html("Please enter purchase unit price for item "+(i+1));
					return false;
				}
				else if(!$.isNumeric(price)){
					$('#editFormErrorText').html("Purchase price for item "+(i+1)+" must contains only numbers");
					return false;
				}
				
			}
			
			if($("#formEdit input[type=checkbox]:checked").length == items){
				$('#editFormErrorText').html("Purchase sholud not have been blank, at least one item should be there");
				return false;
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
		
		setEvents();
		
	</script>
	
</body>	
</html>