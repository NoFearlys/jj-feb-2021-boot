var elements = $('.modal-overlay, .modal');
var modalClientFields = document.getElementsByClassName('modalClient')
var modal = document.getElementById('clientModal')
var content = document.getElementById('content')



window.onclick = function (event){
    if(event.target == modal){
        elements.removeClass('active');
    }
}
function showClient(id) {
    elements.addClass('active');
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if (request.readyState == 4){
            var client = JSON.parse(request.responseText);
            modalClientFields.item(0).textContent = client.name;
            modalClientFields.item(1).textContent = client.city.name;
            modalClientFields.item(2).textContent = client.address;
            modalClientFields.item(3).textContent = client.phone;
            modalClientFields.item(4).textContent = client.model.name;
        }
    }
    request.open("get", "/client/"+id, true);
    request.send();
}