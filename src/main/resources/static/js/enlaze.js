
function obtenerDatos(){

    fetch('http://localhost:8080/user/all')
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato');
      fila.innerHTML= '';

      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.id}</td>
                <td>${dato.name}</td>
                <td>${dato.lastName}</td>
                <td>${dato.process}</td>
                <td><button value=${dato.restaurantId}; onClick="actualizar(this)">Modificar</button></td>
                <td><button value=${dato.restaurantId} onclick="eliminar('${dato.restaurantId}')">Eliminar</button></td>
            </tr>
            `
      }

      })
}



function redireccionarUpdate(){
    location.href='http://localhost:8090/restaurante/apiv1/usuario/actualizarRestaurante';
}
function actualizar(comp){
    let id=comp.value;
    console.log(id);
    localStorage.setItem("ID1",id);
    redireccionarUpdate();

}
function eliminar(comp){

    var requestOptions = {
      method: 'DELETE',
      redirect: 'follow'
    };
    let url='http://localhost:8090/restaurante/apiv1/restaurant/delete/'+comp
    fetch(url, requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
    location.href='http://localhost:8090/restaurante/apiv1/usuario/restaurant-list';

}

function redireccionarmenu(){
    location.href='http://localhost:8090/restaurante/apiv1/usuario/menuRestaurante';
}

function menus(comp){
    let id=comp.value;
    console.log(id);
    localStorage.setItem("ID1",id);
    redireccionarmenu();
}