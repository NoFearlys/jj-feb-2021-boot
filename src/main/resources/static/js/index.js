var clientModalElements = $('.modal-overlay, .modal');
var addFormModal = $('.modal-overlay1, .modal1');
var modalClientFields = document.getElementsByClassName('Client')
var modal = document.getElementById('clientModal')
var modal1 = document.getElementById('addFormModal')
var content = document.getElementById('content')



window.onclick = function (event){
    if(event.target == modal){
        clientModalElements.removeClass('active');
    }
    else if(event.target == modal1){
        addFormModal.removeClass('active');
    }
}
function showClient(id) {
    clientModalElements.addClass('active');
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

function addForm(){
    addFormModal.addClass('active');
}