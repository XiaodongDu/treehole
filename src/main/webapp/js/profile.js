$(document).ready(function() {
	$('.avatar-file').change(function() {
		var formData = new FormData();
		var file = this.files[0];
		var name = $('.nav-id').text() + 'Avatar.jpg';
		var id = $('.nav-id').text();
		formData.append('file', file);
		formData.append('name', name);
		formDate.append('id', id);
		
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
		url: '/user/update.do',
		type: 'post',
		dataType: 'json',
		date: {
			id: $('.nav-id').text(),
			username: $('.username-input').val(),
			password: $('.password-input').val(),
			aboutMe: $('.aboutme-input').val(),
			location: $('.location-input').val(),
			birthdate: $('.birthdate-input').val()
		},
		success: function(json) {
			if (json.success) {
				alert("update profile success!");
				location.href = 'index.html';
			} else {
				alert("update profile fail!");
			}
		}
	});
}