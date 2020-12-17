// Get params from url to read a list
const params = new URLSearchParams(window.location.search);
 
for(let param of params ){
    let id = param[1];
    // Get data
    getData(id)
}

// Get list from url
function getData(id){
  
  fetch('http://localhost:9092/list/read/'+id)
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Error with code: ' + response.status);
        return;
      }

      response.json().then(function(data) {
        // Show data to form
        showData(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}
// Show data to form
function showData(data){
  document.querySelector("input#idInput").value = data.id;
  document.querySelector("input#nameInput").value = data.title;
}


// Listen for submit button
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
  // Put to url
  sendData(data)
  // Send user to start page
  window.location.replace("startPage.html");
});

// Put to url
function sendData(data){
    fetch("http://localhost:9092/list/update/"+data.id, {
        method: 'put',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Successs with resp: ', data);
      })
      .catch(function (error) {
        console.log('failed! response: ', error);
      });
}
