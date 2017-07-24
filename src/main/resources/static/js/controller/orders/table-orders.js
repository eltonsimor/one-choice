/**
 * Created by eltonmoraes on 7/23/17.
 */

$(document).ready(function () {
    loadTableOrders();
});

function loadTableOrders() {
    $.ajax({
        type: "GET",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "/vianuvem/findAllOrders",
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
                                '<a href="/vianuvem/updateOrderByPk?pk='+ d.pk +'">Editar</a> /' +
                                '<a href="/vianuvem/deleteOrder?pk='+ d.pk +'">Deletar</a>' +
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