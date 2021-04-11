
var url='http://localhost:8080/user/save'

var formulario1=document.getElementById("formulario");

formulario1.addEventListener("submit", function(e){
    e.preventDefault();

    var datos=new FormData(formulario1);

    var data={name:`${datos.get('nombres')}`,
              lastName:`${datos.get('apellidos')}`
              };

    console.log(JSON.stringify(data));

    fetch(url, {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(data), // data can be `string` or {object}!
      headers:{
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));

}, false);