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
    loadTableOrders();

});

function create_order() {
    var order = {};
    var lists = {};

    var pk = $("#pk-order").val();
    var name = $("#name-order").val();
    var price = $("#price-order").val();
    var quantity = $("#quantity-order").val();
    var list = $("#list-selected-order").val();
    var nameImage = $("#photo-order").val();

    lists['pk']= list;
    order['pk'] = pk;
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
            url: "/vianuvem/orders",
            data: JSON.stringify(order),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                $('#feedback').html("<h4>Reponse Success</h4><pre>Cadastro Realizado com Sucesso!</pre>");

                console.log("SUCCESS : ", data);
                $("#btn-order").prop("disabled", false);
                $('#pk-order').val('');
                $("#name-order").val('');
                $("#price-order").val('');
                $("#quantity-order").val('');
                $("#list-selected-order").val('');
                $("#photo-order").val('');
                window.location.href = '/vianuvem/home'
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
        url: "/vianuvem/lists",
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

function loadTableOrders() {
    $.ajax({
        type: "GET",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "/vianuvem/orders",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            data.forEach((d) => {
                $("#tbody-order").append(
                '<tr class="gradeX">'+
                '<td>'+ d.pk + '</td>' +
                '<td>'+ d.name + '</td>' +
                '<td class="center">' + d.quantity + '</td>' +
                '<td class="center"> R$' + d.price + '</td>' +
                '<td class="center">' + d.marked + '</td>' +
                '<td>'+ d.lists.name + '</td>'+
                '<td>'+
                '<div class="btn-group">' +
                '<a href="javascript:updateOrder('+ d.pk +')">Editar</a> /' +
                '<a href="javascript:deleteOrder('+ d.pk +')">Deletar</a>' +
                '</div>' +
                '</td>'+
                '</tr>'
            )
        });
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function updateOrder(pk) {
    $.ajax({
        type: "GET",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "/vianuvem/orders/" + pk,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            $("#name-order").val(data.name);
            $("#pk-order").val(data.pk);
            $("#price-order").val(data.price);
            $("#quantity-order").val(data.quantity);
            $("#list-selected-order").val(data.lists.pk);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function deleteOrder(pk) {
    $.ajax({
        type: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "/vianuvem/orders/" + pk,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            window.location.href = "/vianuvem/home";
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function openModal(id){
    $(id).show()
}