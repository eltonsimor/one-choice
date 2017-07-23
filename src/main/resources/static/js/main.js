$(document).ready(function () {
    $("#btn-list").click(function (event) {
        event.preventDefault;
        create_list();
    });

    $("#name-list").click(function () {
        $("#btn-list").prop("disabled", false);
    });
});

function create_list() {
    var search = {}

    var name = $("#name-list").val();
    search["name"] = name;
    $("#btn-list").prop("disabled", true);

    if(name != ""){
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/vianuvem/saveList",
            data: JSON.stringify(search),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Reponse Success</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
                $("#btn-list").prop("disabled", false);

                $("#name-list").val('');
            },
            error: function (e) {

                var json = "<h4>Reponse Error</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-list").prop("disabled", false);

            }
        });
    } else {
        var message = "<h4>Reponse Error</h4><pre>Por favor, informe o nome para lista!</pre>";
        console.log("Error: ", message);
        $("#feedback").html(message);
    }

}