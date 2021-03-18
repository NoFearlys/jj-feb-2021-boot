var elements = $('.modal-overlay, .modal');
var clients = document.getElementsByClassName('client')
var modal = document.getElementById('clientModal')
var btn = document.getElementById('btnModal')
var content = document.getElementById('content')


btn.onclick = function (){
    elements.addClass('active');
}

window.onclick = function (event){
    if(event.target == modal){
        elements.removeClass('active');
    }
}
function showClient(id) {
    elements.addClass('active');
    content.textContent = id;
}