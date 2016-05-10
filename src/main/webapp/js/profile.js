$(document).ready(function() {
	$('.avatar-file').change(function() {
		var formData = new FormData();
		var file = this.files[0];
		var fileName = $ ('.nav-id').text() 
				+ getFileName($('.avatar-file').val());
		var id = $('.nav-id').text();
		formData.append('file', file);
		formData.append('name', fileName);
		formData.append('id', id);
		
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
					$('.avatar-container img').attr('src', json.result[0].avatarPath);
				}
			}
		});
	});
	
	$('.profile-submit').click(updateUser);
});

function getFileName(file){
    var pos = file.lastIndexOf("\\");
    return file.substring(pos + 1);  
}

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