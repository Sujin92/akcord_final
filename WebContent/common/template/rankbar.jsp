<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<style>
.list-group-item {
	border-color: #fff;
}
</style>
<script>
var output1 = "";
var output2 = "";
var output3 = "";
$(document).ready(function() {
	$.ajax({
		type : 'GET',
		dataType : 'json',
		url : '${root}/rank/getrank.akcord',
		//data : {'data', data},

		success : function(data) {
			qnaRank(data);
			groupRank(data);
			myroomRank(data);
		}

	});

});

function qnaRank(data) {
	var resultView1 = $('#append1');
	output1 += '<div class="card-block text-center card-primary">';
	output1 += '<p class="lead"><b>RECORDER</b></p>';
	output1 += '</div>';
	output1 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jq.length; i++) {
		output1 += '<li class="list-group-item">&nbsp;&nbsp;'+(i+1)+'. '+data.jq[i].subject+'&nbsp;&nbsp;('+data.jq[i].hit+')</li>';
	}

	output1 += '</ul>';
	resultView1.empty();
	resultView1.append(output1);
}

function groupRank(data) {
	var resultView2 = $('#append2');
	output2 += '<div class="card-block text-center card-primary">';
	output2 += '<p class="lead"><b>그룹방</b></p>';
	output2 += '</div>';
	output2 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jg.length; i++) {
		output2 += '<li class="list-group-item">&nbsp;&nbsp;'+(i+1)+'. '+data.jg[i].subject+'&nbsp;&nbsp;('+data.jg[i].hit+')</li>';
	}

	output2 += '</ul>';
	resultView2.empty();
	resultView2.append(output2);
}

function myroomRank(data) {
	var resultView3 = $('#append3');
	output3 += '<div class="card-block text-center card-primary">';
	output3 += '<p class="lead"><b>MY ROOM</b></p>';
	output3 += '</div>';
	output3 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jm.length; i++) {
		output3 += '<li class="list-group-item">&nbsp;&nbsp;'+(i+1)+'. '+data.jm[i].subject+'&nbsp;&nbsp;('+data.jm[i].hit+')</li>';
	}

	output3 += '</ul>';
	resultView3.empty();
	resultView3.append(output3);
}

</script>
     <div class="row text-left" style="margin-top:20px;">
	        <div class="col-md-3">
	          <div class="card my-1 card-primary" id="append1">
	            <!-- append (1) -->
	          </div>
	        </div>
	        <div class="col-md-3">
	          <div class="card my-1 card-primary" id="append2">
	            <!-- append (2) -->
	          </div>
	        </div>
	        <div class="col-md-3">
	          <div class="card my-1 card-primary" id="append3">
	            <!-- append (3) -->
	          </div>
	        </div>
	        <div class="col-md-3">
	 			<c:choose> 
				<c:when test="${plist.size()!=0}">
				<%@ include file="/admin/poll.jsp" %>
				</c:when>
				<c:otherwise>
				 <h4>설문조사준비중입니다.</h4>
				</c:otherwise>
				</c:choose>
	        </div>
     </div>
</body>
</html>