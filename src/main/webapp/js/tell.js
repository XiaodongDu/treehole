$(document).ready(function() {
	$('.nav-brand').click(function() {
		location.href = 'index.html';
	});
	
	$('.editor-submit').click(function() {
		tellTreehole();
	});
});

function tellTreehole() {
	$.ajax({
		url: 'secret/insert.do',
		type: 'post',
		data: {
			title: $('.editor-title-input').val(),
			content: $('.editor-content-input').val(),
			'user.id': $('.nav-id').text().trim()
		},
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				alert('Tell Treehole Success!');
				location.href = 'index.html';
			} else {
				alert('Tell Treehole Fail!');
			}
		}
	});
}