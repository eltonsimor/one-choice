/**
 * Created by eltonmoraes on 7/23/17.
 */


$(document).ready(function () {
    $("#btn-order").click(function (event) {
        event.preventDefault;
        create_order();
    });

    $("#name-order").click(function () {
        $("#btn-order").prop("disabled", false);
    });

    $("#price-order").click(function () {
        $("#btn-order").prop("disabled", false);
    });

    $("#quantity-order").click(function () {
        $("#btn-order").prop("disabled", false);
    });

    $("#list-selected-order").click(function () {
        $("#btn-order").prop("disabled", false);
    });

    $("#photo-order").click(function () {
        $("#btn-order").prop("disabled", false);
    });


    loadSelectList();

});

function create_order() {
    var order = {};
    var lists = {};

    var name = $("#name-order").val();
    var price = $("#price-order").val();
    var quantity = $("#quantity-order").val();
    var list = $("#list-selected-order").val();
    var nameImage = $("#photo-order").val();

    lists['pk']= list;
    order['name'] = name;
    order['price'] = price;
    order['quantity'] = quantity;
    order['lists'] = lists;
    order['nameImage'] = nameImage;
    order['marked'] = 'N'
    $("#btn-order").prop("disabled", true);
    var isValid = checkFields(name, price, quantity, list);
    if(isValid){
        $.ajax({
            type: "POST",
            headers:{
              'Content-Type':'application/json'
            },
            url: "/vianuvem/saveOrder",
            data: JSON.stringify(order),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                $('#feedback').html("<h4>Reponse Success</h4><pre>Cadastro Realizado com Sucesso!</pre>");

                console.log("SUCCESS : ", data);
                $("#btn-order").prop("disabled", false);

                $("#name-order").val('');
                $("#price-order").val('');
                $("#quantity-order").val('');
                $("#list-selected-order").val('');
                $("#photo-order").val('');
            },
            error: function (e) {

                var json = "<h4>Reponse Error</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-order").prop("disabled", false);

            }
        });
    }
}

function checkFields(name, price, quantity, list){
    var message = "<h4>Reponse Error</h4>";
    var isValid = true;
    if(name == ''){
        message = message.concat("<pre>Por favor, informe o nome da Ordem!</pre>");
        isValid = false;
    }

    if(price == ''){
        message = message.concat("<pre>Por favor, informe o Preço da Ordem!</pre>");
        isValid = false;
    }

    if(quantity == ''){
        message = message.concat("<pre>Por favor, informe a Quantidade da Ordem!</pre>");
        isValid = false;
    }

    if(list == ''){
        message = message.concat("<pre>Por favor, informe a Lista da Ordem!</pre>");
        isValid = false;
    }

    $("#feedback").html(message);

    return isValid;
}

function loadSelectList() {
    $.ajax({
        type: "GET",
        headers: {
          'Content-Type': 'application/json'
        },
        url: "/vianuvem/findAllLists",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            data.forEach((d) => { $("#list-selected-order").append('<option value="'+d.pk + '" label="' + d.name +'"') });
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}