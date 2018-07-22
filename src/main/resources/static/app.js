function Get(){
    var amount = $("#input").val()
    var currentAmount = $("#Current_amount").val()
    currentAmount = amount;


    $.ajax({
        url: 'http://localhost:8080/proxy-payment',
        method: 'POST',
        success: function (response) {
            currentAmount = response


        }
    }).done(function () {

    })

}

