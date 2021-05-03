$(document).ready(function () {
    $('#login').click(function () {
        let  email=$('#inputEmail').val();
        let password=$('#inputPassword').val();
        if($.trim(email).length>0 && $.trim(password).length>0){


        }
        else {
            $('#error').html("<span class='text-danger'>Invalid email or Password</span>")
        }
    });
    $('#inputEmail').blur(function () {
        let email=$(this).val();
        $.ajax({
            url:"/checkUser",
            method:"POST",
            data:{email:email},
            dataType:"text",
            success:function (html)
            {

                $('#error').html("<span class='text-danger'>Email is not available</span>")


            }
        });
    });
});