$(document).ready(function() {
	$('.avatar-file').change(function() {
		var formData = new FormData();
		var file = this.files[0];
		formData.append('file', file);
		formData.append('name', '2.jpg');
		
		$.ajax({
			url: 'upload.do',
			type: 'post',
			data: formData,
			dataType: 'json',
			cache: false,
			contentType: false,	// 必须，不然会报出‘非法调用’的错误，原因应该是不支持ajax文件上传
			processData: false,
			success: function(json) {
				if (json.success) {
					alert("upload success!");
				}
			}
		});
	});
	
	$('.profile-submit').click(updateUser);
});

function updateUser() {
	$.ajax({
		
	});
}