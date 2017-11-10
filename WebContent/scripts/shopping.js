function deleteCart(cid) {

	$.ajax({
		url : "deleteCart",// 请求的servlet地址
		type : "GET",// 请求方式
		data : "" + cid,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function() {

		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

function alterCount(cid) {

	// window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	$.ajax({
		url : "alterQuantity",// 请求的servlet地址
		type : "GET",// 请求方式
		data : "cid=" + cid + "&count=" + $("#" + cid).val(),// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			$("#cartCount").html(total);
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

// -按钮事件
function reduce(id) {

	if ($("#" + id).val() == 1) {
		$("#" + id).val(1)
	} else if ($("#" + id).val() >= 2) {
		var old = $("#" + id).val()
		$("#" + id).val(parseInt(old) - 1)
	}
	alterCount(id)
}

// +按钮事件
function increase(id) {

	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#" + id).val()// 获得原来的数量
	if (parseInt(old) < parseInt(stock)) {
		$("#" + id).val(parseInt(old) + 1)
		alterCount(id)
	} else {
		alert("您选择的数量超过库存!")
	}

}

function checkStock(id) {
	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#" + id).val()// 获得原来的数量
	if (parseInt(old) > parseInt(stock)) {
		alert("您选择的数量超过库存!")
	} else {
		alterCount(id)
	}
}

function buttonTest(id) {
	alert("测试id=" + id)
}

// 复选框
$(document).ready(function() {

	$("#ischeck").click(function() {
		if ($(this).prop("checked")) {
			$('input[name="cb"]').prop("checked", true);
		} else {
			$('input[name="cb"]').prop("checked", false);
		}
	});
	// or
	var isChecked = $(this).prop("checked");
	$("input[name='cb']").prop("checked", isChecked);

});
function setSelectAll() {
	// 当没有选中某个子复选框时，SelectAll取消选中
	if (!$("#cb").checked) {
		$("#ischeck").prop("checked", false);
	}
	var chsub = $("input[type='checkbox'][name='cb']").length; // 获取subcheck的个数
	var checkedsub = $("input[type='checkbox'][name='cb']:checked").length; // 获取选中的subcheck的个数
	if (checkedsub == chsub) {
		$("#ischeck").prop("checked", true);
	}
	
}
