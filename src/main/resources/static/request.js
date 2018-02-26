$(document).ready(function () {
    var url = window.location;
    var str = '';

    function submit (str) {
        $.ajax({
            type: 'GET',
            url: url + 'traverse',
            data: {
                str: str
            },
            success: function (result) {
                $('#result-div').html('<strong>' + result + '</strong>')
            }
        })
    }

    $('#btn').click(function (event) {
        event.preventDefault();

        if ($('#str').val() == '') {
            $('#result-div').html('<strong>Input a String!</strong>');
        }
        else if ($('#str').val().match(/[a-z]/i)) {
            str = $('#str').val();
            submit(str);
        }
        else {
            $('#result-div').html('<strong>No letters found!</strong>');
        }
    });

    $('#str').keypress(function (e) {
        if(e.which == 13)  // the enter key code
        {
            e.preventDefault();
            $("#btn").click();
        }
    });

    $('#btn-reset').click(function (event) {
        event.preventDefault();

        $('#result-div').empty();
        $('#str').val('');
    });
});