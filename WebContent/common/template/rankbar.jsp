<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var output1 = "";
var output2 = "";
var output3 = "";
$(document).ready(function() {

	$.ajax({
		type : 'GET',
		dataType : 'json',
		url : '${root}/rank/rank.akcord',
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
	output1 += '<p class="lead">지식인 조회수 랭킹</p>';
	output1 += '</div>';
	output1 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jq.length(); i++) {
		output1 += '<li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;1&nbsp;<b>'+i+'. '+data.jq[i].subject+'</b></li>';
	}

	output1 += '</ul>';
	resultView1.empty();
	resultView1.append(output1);
}

function groupRank(data) {
	var resultView2 = $('#append2');
	output2 += '<div class="card-block text-center card-primary">';
	output2 += '<p class="lead">그룹방 랭킹</p>';
	output2 += '</div>';
	output2 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jg.length(); i++) {
		output1 += '<li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;1&nbsp;<b>'+i+'. '+data.jg[i].subject+'</b></li>';
	}

	output2 += '</ul>';
	resultView2.empty();
	resultView2.append(output2);
}

function myroomRank(data) {
	var resultView3 = $('#append3');
	output3 += '<div class="card-block text-center card-primary">';
	output3 += '<p class="lead">MY ROOM 랭킹</p>';
	output3 += '</div>';
	output3 += '<ul class="list-group list-group-flush">';
	
	for (var i = 0; i < data.jm.length(); i++) {
		output1 += '<li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;1&nbsp;<b>'+i+'. '+data.jm[i].subject+'</b></li>';
	}

	output3 += '</ul>';
	resultView3.empty();
	resultView3.append(output3);
}

</script>

     <div class="row text-left">
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
	          <div class="card my-1 card-primary">
	            <div class="card-block text-center">
	              <p class="lead">설문조사</p>
	            </div>
	            <ul class="list-group list-group-flush">
	               <li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;1&nbsp;<b>JAVA 공부방</b></li>
	              <li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;2&nbsp;<b>JAVA 공부방</b></li>
	              <li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;3&nbsp;<b>JAVA 공부방</b></li>
	              <li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;4&nbsp;<b>JAVA 공부방</b></li>
	              <li class="list-group-item"><i class="mx-auto fa d-inline fa-clock-o"></i>&nbsp;5&nbsp;<b>JAVA 공부방</b></li>
	            </ul>
	          </div>
	        </div>
     </div>
</body>
</html>