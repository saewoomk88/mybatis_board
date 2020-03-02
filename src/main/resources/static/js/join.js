$(document).ready(function () {
    //아이디 중복체크
    $('#id').on('keyup',function () {
        if($('#id').val()==='dad'){
            $('#idHelp p').text('중복된 id 입니다.');
        }else {
            $('#idHelp p').text("사용 가능합니다");
        }
    });
    //비밀번호 정규식 체크
    $('#pw').on('keyup',function () {
        var regExpPw = /^(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

        if(!regExpPw.test($('#pw').val())){
            $('#pwHelp p').text('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');

        }else {
            $('#pwHelp p').text('사용가능한 비밀번호입니다.');
        }
    });
    //비밀번호 일치 확인
    $('#pw2').on('blur',function () {
        if($('#pw').val()!==$('#pw2').val()){
            $('#pw2Help p').text('비밀번호가 일치하지 않습니다.');
        }else{
            $('#pw2Help p').text('');
        }

    });
    //전화번호 체크
    $('#phone').on('blur',function () {
        var regExpPw = /^\d{3}-\d{3,4}-\d{4}$/;

        if(!regExpPw.test($('#phone').val())){
            $('#phoneHelp p').text('올바른 핸드폰번호가 아닙니다.');
        }else {
            $('#phoneHelp p').text('');
        }
    });
    //이메일 체크
    $('#email').on('blur',function () {
        var regExpPw = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

        if(!regExpPw.test($('#phone').val())){
            $('#emailHelpa p').text('올바른 이메일이 아닙니다.');
        }else {
            $('#emailHelp p').text('');
        }
    });
});