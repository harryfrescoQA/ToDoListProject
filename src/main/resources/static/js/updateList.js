const params = new URLSearchParams(window.location.search);
 
for(let param of params ){
    let id = param[1];
    console.log(id);
    getData(id)
}


function getData(id){
  
  fetch('http://localhost:9092/list/read/'+id)
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then(function(data) {
        showData(data);
        
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

function showData(data){
  document.querySelector("input#idInput").value = data.id;
  document.querySelector("input#nameInput").value = data.title;
}



document
.querySelector("form.viewRecord")
.addEventListener("submit", function (stop) {
  stop.preventDefault();
  let formElements = document.querySelector("form.viewRecord").elements;

  let id =formElements["idInput"].value;
  let name=formElements["nameInput"].value;
  let data = {
    "id": id,
    "title":name
  }

  sendData(data)
  window.location.replace("startPage.html");
});

  
  function sendData(data){
    fetch("http://localhost:9092/list/update/"+data.id, {
        method: 'put',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Request succeeded with JSON response', data);
      })
      .catch(function (error) {
        console.log('Request failed', error);
      });
    }
