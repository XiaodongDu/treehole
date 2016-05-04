var begin = 0;
var sum = 7;

$(document).ready(function() {
	loadItem();
	isLogin();
	login();
	loadMoreItem();

	$('.nav-brand').click(function() {
		location.href = 'index.html';
	});

	$('.nav-intro').click(function() {
		ifLoginDo(showEditor);
	});
});

function ifLoginDo(callback) {
	$.ajax({
		url: 'login/isLogin.do',
		type: 'get',
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				callback();
			} else {
				alert('Please sign in!');
			}
		}
	});
}

function showEditor() {
	var isShow = $('.editor-container').css('display');
	if (isShow == 'none') {
		$('.editor-container').css({
			'display': 'block'
		});
		$('.outest-container').css({
			'display': 'none'
		});
		$('.footer-container').css({
			'display': 'none'
		});
	} else {
		$('.editor-container').css({
			'display': 'none'
		});
		$('.outest-container').css({
			'display': 'block'
		});
		$('.footer-container').css({
			'display': 'block'
		});
	}
}

function loadMoreItem() {
	$('.footer-load-button').click(function() {
		$.ajax({
			url: 'login/isLogin.do',
			type: 'get',
			dataType: 'json',
			success: function(json) {
				if (json.success) {
					if (sum < 7) {
						$('.item-container').append('<div class="item-tip">No more ~</div>');
			    		$('.footer-container').css({
			    			'visibility': 'hidden'
			    		});
					} else {
						loadItem();
					}
				} else {
					alert('Please sign in!');
				}
			}
		});
	});

}

function login() {
	$('.nav-username').click(function() {
		if ($('.nav-username').text().trim() == 'Sign in') {
			location.href = 'login.html';
		}
	});
}

function isLogin() {
	$.ajax({
		url: 'login/isLogin.do',
		type: 'get',
		dataType: 'json',
		success: function(json) {
			if (json.success) {
				$('.nav-username').html(json.result[0].username);
				$('.nav-id').html(json.result[0].id);
			}
		}
	});
}

function loadItem() {
    $.ajax({
        url: 'secret/queryBy.do',
        type: 'get',
        data: {
        	begin: begin,
        	sum: sum
        },
        success: function(json) {
    		var i = 0;
    		for(; i < json.result.length; i++) {
    			createItem(json.result[i]);
    		}
    		if (i < 7) {
    			sum = i;
    		}
    		begin += sum;
        },
        dataType: 'json'
    });
}

function createItem(item) {
    var itemDiv = $('<div class="item"><div class="item-avatar"><img alt="avatar" src="' +
    item.user.avatarPath +
    '" /></div><div class="item-content-container"><div class="item-username">' +
    item.user.username +
    '</div><div class="item-title">' +
    item.title +
    '</div><div class="item-content">' +
    item.content +
    '</div><div class="item-footer">' +
    item.pubdate +
    '</div></div></div>');
    $('.item-container').append(itemDiv);
}
